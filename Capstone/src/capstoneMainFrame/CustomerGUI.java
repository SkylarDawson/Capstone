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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author 19sky
 *
 */
public class CustomerGUI {

	private static TableModel myTable;
	/**
	 * 
	 */
	public CustomerGUI() {
		// TODO Auto-generated constructor stub
	}
	
	public static void setTable(TableModel table) {
		myTable = table;
	}
	
	public static TableModel getTable() {
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
     * Function executes the functionality of the Customer Screen
     * @param JTextField customerNumField is the customer Number field from the GUI
     * @param JTextField firstNameField is the first name field from the GUI
     * @param JTextField lastNameField is the last name field from the GUI
     * @param JTextField phoneNumField is the phone number field from the GUI
     * @return JTable with yield from customerSearch
     */
    public TableModel execute(JTextField customerNumField, JTextField firstNameField, JTextField lastNameField, JTextField phoneNumField) {
    	
    	// Extract all passed through information
    	int customerNum = 0;
    	boolean error = false;
    	String errorMessage = "";
    	if(customerNumField.getText().length() == 0) {
    		customerNum = 0;
    	}
    	else {
    		try{customerNum = Integer.parseInt(customerNumField.getText());}
    		catch (Exception e) {
    			error = true;
    			errorMessage += "Customer Number is not an Integer \n";
    		}
    	}
    	String firstName = firstNameField.getText();
    	String lastName = lastNameField.getText();
    	String phoneNum = phoneNumField.getText();
    	
    	if(!error) {
    	// Conduct search on the database
    	runSearch(customerNum, firstName, lastName, phoneNum);
    	
    	TableModel customerSearch = getTable();
    	return customerSearch;
    	}
    	else {
    		 // Tell user that operation was successful
        	JOptionPane.showMessageDialog(null, errorMessage);
        	return new DefaultTableModel();
    	}
    }
    
    /*
     * Function searches the database for the designated customer based on user input information
     * @param int customerNum is the customer's unique ID
     * @param String firstName is the customer's first name
     * @param String lastName is the customer's last name
     * @param String phoneNum is the customer's phone number 
     */
    public void runSearch(int customerNum, String firstName, String lastName, String phoneNum) {
    	// Search by customerNum is top priority
    	// If there exists a customerNum value that is valid (i.e. greater than 0)
    	if(customerNum > 0) {
    		// run the SQL command searching by customerNum
    		String sqlCustomerNum = String.format( "Select customerNum, firstName, lastName, phoneNum, address, email, outstandingBalance"
	        		+ " from customers"
	        		+ " where customerNum = \"%x\" ;", customerNum);
    		
    		// Select Customers based on SQL command
    		selectCustomers(sqlCustomerNum);
    		return;
    	}
    	
    	// Phone Number search is second priority
    	// If there exists a phone number passed into the search
    	if(phoneNum.length() > 0) {
    		// run the SQL command searching by phone
    		String sqlPhoneNum = String.format( "Select customerNum, firstName, lastName, phoneNum, address, email, outstandingBalance"
	        		+ " from customers"
	        		+ " where phoneNum = \"%s\" ;", phoneNum);
    		
    		// Select Customers based on the SQL Command
    		selectCustomers(sqlPhoneNum);
    		return;
    	}
    	
    	// Names Are Last Priority for Searching
    	// If First Name is entered but no last name - only search based on entered values for first name				
		if(firstName.length() > 0 && lastName.length() == 0) {
			// Executed SQL command
			String sqlFirst = String.format( "Select customerNum, firstName, lastName, phoneNum, address, email, outstandingBalance"
	        		+ " from customers"
	        		+ " where  firstName like \"%s%c\" ;", firstName, '%');
			
			// Select Customers based on first name
			selectCustomers(sqlFirst);
			return;
		}
		// Else if only the last name is entered
		else if(firstName.length() == 0 && lastName.length() > 0)
		{
			// Execute SQL command - for searching last name only
			String sqlLast = String.format( "Select customerNum, firstName, lastName, phoneNum, address, email, outstandingBalance"
	        		+ " from customers"
	        		+ " where lastName like \"%s%c\";", lastName, '%');
	  
			// Select Customers based on last name
			selectCustomers(sqlLast);
			return;
		}
		// Else execute based on first and last name combination
		else if(firstName.length() > 0 && lastName.length() > 0){
			// SQL command to be executed
			String sqlFirstLast = String.format( "Select customerNum, firstName, lastName, phoneNum, address, email, outstandingBalance"
	        		+ " from customers"
	        		+ " where firstName like \"%s%c\" AND lastName like \"%s%c\";", firstName, '%', lastName, '%');
	  
			// Execute the SQL command based on the names passed in
			selectCustomers(sqlFirstLast);	
			return;
		}
		
		else {
			
		// No specific search - pull all orders
		String allOrders = "Select customerNum, firstName, lastName, phoneNum, address, email, outstandingBalance"
        		+ " from customers";
		
		// Select all
		selectCustomers(allOrders);
		return;
		}
    }
    
    /*
     * function that runs selection on Customers table - specifically to pull information from all columns
     * @param String sql is the passed in SQL command to be sent to the Database
     * @return nothing
     */
    public void selectCustomers(String sql){  
    	// Create a vector for each attribute returned in SQL command 
    	Vector<Integer> customerNums = new Vector<Integer>();
    	Vector<String> firstNames = new Vector<String>();
    	Vector<String> lastNames = new Vector<String>();
    	Vector<String> phoneNums = new Vector<String>();
    	Vector<String> address = new Vector<String>();
    	Vector<String> email = new Vector<String>();
    	Vector<Double> balances = new Vector<Double>();
    	
    	
    	// Try and connect to the database
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // While there exists another result
            while (rs.next()) {  
                
            	// Add returned result to corresponding vector
            	customerNums.add(rs.getInt("customerNum"));
            	firstNames.add(rs.getString("firstName"));
            	lastNames.add(rs.getString("lastName"));
            	phoneNums.add(rs.getString("phoneNum"));
            	email.add(rs.getString("email"));
            	address.add(rs.getString("address"));
            	balances.add(rs.getDouble("outstandingBalance"));
                
            }
           
           // After results are gathered - display result
          displayResults(customerNums, firstNames, lastNames, phoneNums, email, address, balances);
           
          return;
          
        // Catch if database could not be connected to
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            return;
            
        }  
    }
    /*
     * Function displays result of customer search query into a JTable for easy viewing
     * @param Vector<Integer> customerNum is list of all returned customer IDs
     * @param Vector<String> firstName is the list of all returned customer first names
     * @param Vector<String> lastName is the list of all returned customer last names
     * @param Vector<String> phone is the list of all returned customer phone numbers
     * @param Vector<String> email is the list of all returned customer emails
     * @param Vector<String> address is the list of all returned customer addresses
     * @param Vector<String> balance is the list of all returned customer balances
     * @return nothing
     */
    public void displayResults(Vector<Integer> customerNum, Vector<String> firstName, Vector<String> lastName, Vector<String> phone, Vector<String> email, Vector<String> address, Vector<Double> balance ) {
    	// Create objects to hold the data for the table
    			Object[][] rowData = {};
    			Object[] headers = {"Customer #", "First Name", "Last Name", "Phone Number", "Email", "Address", "Outstanding $"};
    			
    			// Create table object
    			DefaultTableModel CustomerModel;
    			CustomerModel = new DefaultTableModel (rowData, headers){

    			    @Override
    			    public boolean isCellEditable(int row, int column) {
    			       //all cells false
    			       return false;
    			    }
    			};
    			
    			// Step through each result from the query pulling each piece of customer infromation
    			for(int i = 0; i < firstName.size(); i++) {
    			CustomerModel.addRow(new Object[]{ customerNum.elementAt(i),firstName.elementAt(i), lastName.elementAt(i),phone.elementAt(i), email.elementAt(i), address.elementAt(i), balance.elementAt(i)});
    			}
    			
    		    setTable(CustomerModel);
    		    
  
    			return;
    }

}
