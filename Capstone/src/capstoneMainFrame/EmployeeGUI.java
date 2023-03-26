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
import javax.swing.table.TableModel;

/**
 * @author 19sky
 *
 */
public class EmployeeGUI {
	
	private static TableModel myTable;
	/**
	 * 
	 */
	public EmployeeGUI() {
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
     * Function executes the functionality of the Employee Screen
     * @param JTextField employeeNumField is the employee number field from the GUI
     * @param JTextField firstNameField is the first name field from the GUI
     * @param JTextField lastNameField is the last name field from the GUI
     * @param JTextField jobTitleField is the phone number field from the GUI
     * @return JTable with yield from employeeSearch
     */
    public TableModel execute(JTextField employeeNumField, JTextField firstNameField, JTextField lastNameField, JTextField jobTitleField) {
    	
    	// Extract all passed through information
    	int employeeNum = 0;
    	if(employeeNumField.getText().length() == 0) {
    		employeeNum = 0;
    	}
    	else {
    	employeeNum = Integer.parseInt(employeeNumField.getText());
    	}
    	String firstName = firstNameField.getText();
    	String lastName = lastNameField.getText();
    	String jobTitle = jobTitleField.getText();
    	
    	// Conduct search on the database
    	runSearch(employeeNum, firstName, lastName, jobTitle);
    	
    	TableModel employeeSearch = getTable();
    	return employeeSearch;
    }

    /*
     * Function searches the database for the designated employee based on user input information
     * @param int employeeNum is the employee's unique ID
     * @param String firstName is the employee's first name
     * @param String lastName is the employee's last name
     * @param String jobTitle is the employee's job title
     */
    public void runSearch(int employeeNum, String firstName, String lastName, String jobTitle) {
    	// Search by employeeNum is top priority
    	// If there exists a employeeNum value that is valid (i.e. greater than 0)
    	if(employeeNum > 0) {
    		// run the SQL command searching by employeeNum
    		String sqlemployeeNum = String.format( "Select employeeNum, firstName, lastName, jobTitle, username"
	        		+ " from employees"
	        		+ " where employeeNum = \"%x\" ;", employeeNum);
    		
    		// Select Employees based on SQL command
    		selectEmployees(sqlemployeeNum);
    		return;
    	}
    	
    	
    	// Phone Number search is second priority
    	// If there exists a phone number passed into the search
    	if(jobTitle.length() > 0) {
    		// run the SQL command searching by phone
    		String sqljobTitle = String.format( "Select employeeNum, firstName, lastName, jobTitle, username"
	        		+ " from employees"
	        		+ " where jobTitle = \"%s\" ;", jobTitle);
    		
    		// Select Employees based on the SQL Command
    		selectEmployees(sqljobTitle);
    		return;
    	}
    	
    	// Names Are Last Priority for Searching
    	// If First Name is entered but no last name - only search based on entered values for first name				
		if(firstName.length() > 0 && lastName.length() == 0) {
			// Executed SQL command
			String sqlFirst = String.format( "Select employeeNum, firstName, lastName, jobTitle, username"
	        		+ " from employees"
	        		+ " where  firstName like \"%s%c\" ;", firstName, '%');
			
			// Select employees based on first name
			selectEmployees(sqlFirst);
			return;
		}
		
		// Else if only the last name is entered
				else if(firstName.length() == 0 && lastName.length() > 0)
				{
					// Execute SQL command - for searching last name only
					String sqlLast = String.format( "Select employeeNum, firstName, lastName, jobTitle, username"
			        		+ " from employees"
			        		+ " where lastName like \"%s%c\";", lastName, '%');
			  
					// Select employees based on last name
					selectEmployees(sqlLast);
					return;
				}
				// Else execute based on first and last name combination
				else if(firstName.length() > 0 && lastName.length() > 0){
					// SQL command to be executed
					String sqlFirstLast = String.format( "Select employeeNum, firstName, lastName, jobTitle, username"
			        		+ " from employees"
			        		+ " where firstName like \"%s%c\" AND lastName like \"%s%c\";", firstName, '%', lastName, '%');
			  
					// Execute the SQL command based on the names passed in
					selectEmployees(sqlFirstLast);	
					return;
				}
				
				else {
					
				// No specific search - pull all orders
				String allOrders = "Select employeeNum, firstName, lastName, jobTitle, username"
		        		+ " from employees";
				
				// Select all
				selectEmployees(allOrders);
				return;
				}
		    }
    
    /*
     * function that runs selection on Employees table - specifically to pull information from all columns
     * @param String sql is the passed in SQL command to be sent to the Database
     * @return nothing
     */
    public void selectEmployees(String sql){  
    	// Create a vector for each attribute returned in SQL command 
    	Vector<Integer> employeeNums = new Vector<Integer>();
    	Vector<String> firstNames = new Vector<String>();
    	Vector<String> lastNames = new Vector<String>();
    	Vector<String> jobTitles = new Vector<String>();
    	Vector<String> userNames = new Vector<String>();
    	
    	
    	// Try and connect to the database
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // While there exists another result
            while (rs.next()) {  
                
            	// Add returned result to corresponding vector
            	employeeNums.add(rs.getInt("employeeNum"));
            	firstNames.add(rs.getString("firstName"));
            	lastNames.add(rs.getString("lastName"));
            	jobTitles.add(rs.getString("jobTitle"));
            	userNames.add(rs.getString("username"));
                
            }
           
           // After results are gathered - display result
          displayResults(employeeNums, firstNames, lastNames, jobTitles, userNames);
           
          return;
          
        // Catch if database could not be connected to
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            return;
            
        }  
    }
    
    
    /*
     * Function displays result of employee search query into a JTable for easy viewing
     * @param Vector<Integer> employeeNum is list of all returned employee IDs
     * @param Vector<String> firstName is the list of all returned employee first names
     * @param Vector<String> lastName is the list of all returned employee last names
     * @param Vector<String> jobTitle is the list of all returned employee job titles
     * @return nothing
     */
    public void displayResults(Vector<Integer> employeeNum, Vector<String> firstName, Vector<String> lastName, Vector<String> jobTitle, Vector<String> userNames) {
    	// Create objects to hold the data for the table
    			Object[][] rowData = {};
    			Object[] headers = {"Employee Number", "First Name", "Last Name", "Job Title", "Username"};
    			
    			// Create table object
    			DefaultTableModel EmployeeModel;
    			EmployeeModel = new DefaultTableModel (rowData, headers){

    			    @Override
    			    public boolean isCellEditable(int row, int column) {
    			       //all cells false
    			       return false;
    			    }
    			};
    			
    			// Step through each result from the query pulling each piece of employee information
    			for(int i = 0; i < firstName.size(); i++) {
    			EmployeeModel.addRow(new Object[]{ employeeNum.elementAt(i),firstName.elementAt(i), lastName.elementAt(i), jobTitle.elementAt(i), userNames.elementAt(i)});
    			}
    			
    			/* Save for Reference
    			// Create table based on information received
    			JTable employeeTable;
    		    employeeTable = new JTable(EmployeeModel);
    		    employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    		    employeeTable.setCellEditor(null);
    		    employeeTable.setBounds(37, 143, 397, 183);
				*/
    			
    		    setTable(EmployeeModel);
    		    
    		    /* Save for reference
    		    // Show the frame
    		    JFrame frame = new JFrame();
    		    frame.add(new JScrollPane(employeeTable));
    		    frame.setVisible(true);
    		    frame.pack();
    		    */
    			return;
    }
}
    
    /*
	public static void main(String[] args) {
		String url = "";
		String username = "";
		String password = "";
		
		
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			String query = "SELECT * FROM employees";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			
			
			while (resultSet.next()) {
				int employeeID = resultSet.getInt("employeeID");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String jobTitle = resultSet.getString("jobTitle");
				System.out.println("Employee ID: " + employeeID + ", First Name: " + firstName +  ", Last Name: " + lastName + ", Job Title: " + jobTitle);
			}
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
	} 

} */
