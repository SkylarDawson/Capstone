/**
 * 
 */
package capstoneMainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JPanel;

/**
 * @author 19sky
 *
 */
public class OrderGUI {

	private static JTable myTable;
	/**
	 * 
	 */
	public OrderGUI() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Back Function will hide the current panel and show the next panel.
	 * This function is called when the back button in pressed to return to the main panel
	 * @param CurrPanel
	 * @param NextPanel
	 */
	public void back(JPanel CurrPanel,JPanel NextPanel) {
		CurrPanel.hide();
		NextPanel.show();
	}
	
	public static void setTable(JTable table) {
		myTable = table;
	}
	
	public static JTable getTable() {
		return myTable;
	}
	/*
	 * connect to the database the specified based on the file path
	 */
    private Connection connect() {  
        // SQLite connection string  - this string is the file path to the database
        String url = "jdbc:sqlite:C:/sqlite/fertilizer.db";  
        Connection conn = null; 
        
        // Test to make sure that the database exists
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
    
    /*
     * Function executes the functionality of the order history page 
     * @param JTextField orderNumField is the orderNumber field in the search options on the GUI
     * @param JTextField firstNameField is the first Name field in the search options on the GUI
     * @param JTextField lastNameField is the last Name field in the search options on the GUI
     * @param JTextField orderDateField is the order date field in the search options on the GUI
     * @return nothing
     */
    public JTable execute(JTextField orderNumField, JTextField firstNameField, JTextField lastNameField, JTextField orderDateField, JPanel currPanel) {
    	// Extract information from passed in GUIs
    	int orderNum = Integer.parseInt(orderNumField.getText());
    	String firstName = firstNameField.getText();
    	String lastName = lastNameField.getText();
    	String orderDate = orderDateField.getText();
    	
    	
    	// Run a search on the database
    	runSearch(orderNum, firstName, lastName, orderDate);
    	
    	JTable orderHistory = getTable();
    	return orderHistory;
    }
    
    /*
     * Function runs a search on the orders table within the database based on searched information
     * @param int orderNum is the order number
     * @param String firstName is the customer's first name
     * @param String lastName is the customer's last name
     * @param String orderDate is the date the order was placed
     */
    public void runSearch(int orderNum, String firstName, String lastName, String orderDate)
    {
    	
    	// Search by orderNum is top priority
    	// If the orderNum is inserted and valid (i.e. greater than 0)
    	if(orderNum > 0) {
    		// Run search on order number
    		String sqlOrderNum = String.format( "Select firstName, lastName, orders.customerNum, orderNum, employeeNum, orderPaid, orderComplete, orderDelivered, pickUpDate, pickupTime, Potash, MAP, AMS, Urea, Gypsum, comments, orderDate"
	        		+ " from customers,orders"
	        		+ " where customers.customerNum = orders.customerNum AND orders.orderNum = \"%x\" ;", orderNum);
    		
    		// Select the orders
    		selectOrders(sqlOrderNum);
    		return;
    	}
    	
    	// Order Date search is second priority
    	// If date is inserted and valid
    	if(orderDate.length() > 0) {
    		// Create Order Date Search SQL command
    		String sqlOrderDate = String.format( "Select firstName, lastName, orders.customerNum, orderNum, employeeNum, orderPaid, orderComplete, orderDelivered, pickUpDate, pickupTime, Potash, MAP, AMS, Urea, Gypsum, comments, orderDate"
	        		+ " from customers,orders"
	        		+ " where orders.orderDate = \"%s\" ;", orderDate);
    		
    		// Select Orders based on order date SQL command
    		selectOrders(sqlOrderDate);
    		return;
    	}
    	
    	// Names Are Last Priority for Searching
    	// If First Name is entered but no last name - only search based on entered values for first name				
		if(firstName.length() > 0 && lastName.length() == 0) {
			// Executed SQL command
			String sqlFirst = String.format( "Select firstName, lastName, orders.customerNum, orderNum, employeeNum, orderPaid, orderComplete, orderDelivered, pickUpDate, pickupTime, Potash, MAP, AMS, Urea, Gypsum, comments, orderDate"
	        		+ " from customers,orders"
	        		+ " where orders.customerNum = customers.customerNum AND firstName like \"%s%c\" ;", firstName, '%');
			
			// Execute the command
			selectOrders(sqlFirst);
			return;
		}
		// Else if only the last name is entered
		else if(firstName.length() == 0 && lastName.length() > 0)
		{
			// Execute SQL command - for searching last name only
			String sqlLast = String.format( "Select firstName, lastName, orders.customerNum, orderNum, employeeNum, orderPaid, orderComplete, orderDelivered, pickUpDate, pickupTime, Potash, MAP, AMS, Urea, Gypsum, comments, orderDate"
	        		+ " from customers,orders"
	        		+ " where orders.customerNum = customers.customerNum AND lastName like \"%s%c\";", lastName, '%');
	  
			// Execute SQL command
			selectOrders(sqlLast);
			return;
		}
		// Else execute based on first and last name combination
		else if(firstName.length() > 0 && lastName.length() > 0){
			// SQL command to be executed
			String sqlFirstLast = String.format( "Select firstName, lastName, orders.customerNum, orderNum, employeeNum, orderPaid, orderComplete, orderDelivered, pickUpDate, pickupTime, Potash, MAP, AMS, Urea, Gypsum, comments, orderDate"
	        		+ " from customers,orders"
	        		+ " where orders.customerNum = customers.customerNum AND firstName like \"%s%c\" AND lastName like \"%s%c\";", firstName, '%', lastName, '%');
	  
			// Execute the SQL command
			selectOrders(sqlFirstLast);	
			return;
		}
		
		else {
		// No specific search - pull all orders
		String allOrders = "Select firstName, lastName, orders.customerNum, orderNum, employeeNum, orderPaid, orderComplete, orderDelivered, pickUpDate, pickupTime, Potash, MAP, AMS, Urea, Gypsum, comments, orderDate"
	        		+ " from customers,orders "
	        		+ "where customers.customerNum = orders.customerNum";
		
		// Select All Orders
		selectOrders(allOrders);
		return;
		}
    }
    /*
     * function that runs selection on Customers table - specifically to pull information from all columns
     * @param String sql is the passed in SQL command to be sent to the Database
     * @return nothing
     */
    public void selectOrders(String sql){  
    	// Create a vector for each attribute returned in SQL command 
    	Vector<String> firstNames = new Vector<String>();
    	Vector<String> lastNames = new Vector<String>();
    	Vector<Integer> orderNums = new Vector<Integer>();
    	Vector<Integer> customerNums = new Vector<Integer>();
    	Vector<Integer> employeeNums = new Vector<Integer>();
    	Vector<Boolean> ordersPaid = new Vector<Boolean>();
    	Vector<Boolean> ordersComplete = new Vector<Boolean>();
    	Vector<Boolean> ordersDelivered = new Vector<Boolean>();
    	Vector<String> pickUpDates = new Vector<String>();
    	Vector<String> pickUpTimes = new Vector<String>();
    	Vector<Double> Potashes = new Vector<Double>();
    	Vector<Double> MAPS = new Vector<Double>();
    	Vector<Double> AMS = new Vector<Double>();
    	Vector<Double> Ureas = new Vector<Double>();
    	Vector<Double> Gypsums = new Vector<Double>();
    	Vector<String> Comments = new Vector<String>();
    	Vector<String> orderDates = new Vector<String>();
    	
    	// Try and connect to the database
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // While there exists another result
            while (rs.next()) {  
                
            	// Add returned result to corresponding vector
            	firstNames.add(rs.getString("firstName"));
            	lastNames.add(rs.getString("lastName"));
            	orderNums.add(rs.getInt("orderNum"));
            	customerNums.add(rs.getInt("customerNum"));
            	employeeNums.add(rs.getInt("employeeNum"));
            	ordersPaid.add(rs.getBoolean("orderPaid"));
            	ordersComplete.add(rs.getBoolean("orderComplete"));
            	ordersDelivered.add(rs.getBoolean("orderDelivered"));
            	pickUpDates.add(rs.getString("pickUpDate"));
            	pickUpTimes.add(rs.getString("pickUpTime"));
            	Potashes.add(rs.getDouble("Potash"));
            	MAPS.add(rs.getDouble("MAP"));
            	AMS.add(rs.getDouble("AMS"));
            	Ureas.add(rs.getDouble("Urea"));
            	Gypsums.add(rs.getDouble("Gypsum"));
            	Comments.add(rs.getString("comments"));
            	orderDates.add(rs.getString("orderDate"));
                
            }
           
           // After results are gathered - display result
          displayResults(firstNames, lastNames, orderNums, customerNums, employeeNums, ordersPaid, ordersComplete, ordersDelivered,
        		  pickUpDates, pickUpTimes, Potashes, MAPS, AMS, Ureas, Gypsums, Comments, orderDates);
           
          return;
          
        // Catch if database could not be connected to
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            return;
            
        }  
    }  

/*
 * Function displays the results of the order history query by display all passed in information (see params)
 * @param Vector<String> firstName is all returned customer first names
 * @param Vector<String> lastName is all returned customer last names
 * @param Vector<Integer> orderNum is all returned order numbers
 * @param Vector<Integer> customerNum is all returned customer numbers
 * @param Vector<Integer> employeeNum is all returned employee numbers
 * @param Vector<Boolean> orderPaid is all returned values stating if an order was paid or not
 * @param Vector<Boolean> orderComplete is all returned values stating if an order was completed or not
 * @param Vector<Boolean> orderDelivered is all returned values stating if an order was delivered or not
 * @param Vector<String> pickupDate is all returned order pick up dates
 * @param Vector<String> pickupTime is all returned order pick up times
 * @param Vector<Double> Potash is all returned order potash values
 * @param Vector<Double> MAP is all returned order MAP values
 * @param Vector<Double> AMS is all returned order AMS values
 * @param Vector<Double> Urea is all returned order Urea values
 * @param Vector<Double> Gypsum is all returned order Gypsum values
 * @param Vector<String> Comments is all returned order comments
 * @param Vector<String> OrderDate is all returned order placement dates
 * @return nothing
 */
public static void displayResults(Vector<String> firstName, Vector<String> lastName, Vector<Integer> orderNum, Vector<Integer> customerNum, Vector<Integer> employeeNum, Vector<Boolean> orderPaid, Vector<Boolean> orderComplete, Vector<Boolean> orderDelivered, Vector<String> pickUpDate, Vector<String> pickUpTime,
		Vector<Double> Potash, Vector<Double> MAP, Vector<Double> AMS, Vector<Double> Urea, Vector<Double> Gypsum, Vector<String> comments, Vector<String> orderDate)
{
	// Create objects to hold the data for the table
	Object[][] rowData = {};
	Object[] headers = {"First Name", "Last Name", "orderNum", "customerNum", "employeeNum", "Paid", "Complete", "Delivered", "PickUp Date", "PickUp Time"
			, "Potash", "MAP", "AMS", "Urea", "Gypsum", "Order Date", "Comments"};
	
	// Create table object
	DefaultTableModel orderModel;
	orderModel = new DefaultTableModel (rowData, headers);
	
	// For each returned tuple - create a new row with all order information
	for(int i = 0; i < firstName.size(); i++) {
	orderModel.addRow(new Object[]{ firstName.elementAt(i), lastName.elementAt(i), orderNum.elementAt(i), customerNum.elementAt(i), employeeNum.elementAt(i), orderPaid.elementAt(i), orderComplete.elementAt(i), orderDelivered.elementAt(i), pickUpDate.elementAt(i), pickUpTime.elementAt(i),
		Potash.elementAt(i), MAP.elementAt(i), AMS.elementAt(i), Urea.elementAt(i), Gypsum.elementAt(i), orderDate.elementAt(i), comments.elementAt(i) });
	}
	
	// Create the table based on the returned results
	JTable listTable;
    listTable = new JTable(orderModel);
    listTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    listTable.setCellEditor(null);
    listTable.setBounds(37, 143, 397, 183);

    setTable(listTable);
    
	return;
}
}
