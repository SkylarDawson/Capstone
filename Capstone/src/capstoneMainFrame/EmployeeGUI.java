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
     * @param JTextField phoneNumField is the phone number field from the GUI
     * @return JTable with yield from employeeSearch
     */
    public TableModel execute(JTextField employeeNumField, JTextField firstNameField, JTextField lastNameField, JTextField phoneNumField) {
    	
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
    	String phoneNum = phoneNumField.getText();
    	
    	// Conduct search on the database
    	runSearch(employeeNum, firstName, lastName, phoneNum);
    	
    	TableModel employeeSearch = getTable();
    	return employeeSearch;
    }

    /*
     * Function searches the database for the designated employee based on user input information
     * @param int employeeNum is the employee's unique ID
     * @param String firstName is the employee's first name
     * @param String lastName is the employee's last name
     * @param String phoneNum is the employee's phone number 
     */
    public void runSearch(int employeeNum, String firstName, String lastName, String phoneNum) {
    	// Search by employeeNum is top priority
    	// If there exists a employeeNum value that is valid (i.e. greater than 0)
    	if(employeeNum > 0) {
    		// run the SQL command searching by employeeNum
    		String sqlemployeeNum = String.format( "Select employeeNum, firstName, lastName, phoneNum, jobTitle"
	        		+ " from employees"
	        		+ " where employeeNum = \"%x\" ;", employeeNum);
    		
    		// Select Employees based on SQL command
    		selectEmployees(sqlemployeeNum);
    		return;
    	}
    	
    	
    	//PICK BACK UP HERE!!!
    
    
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

}
