/**
 * 
 */
package capstoneMainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 19sky
 *
 */
public class CreateEmployee {

	/**
	 * 
	 */
	public CreateEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * connect to the database the specified based on the file path
	 */
    private Connection connect() {  
    	 // SQLite connection string  - this string is the file path to the database 
        String url = "jdbc:sqlite:C://sqlite/fertilizer.db";  
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
     * This function executes the functionality of the create employee page
     * @param JTextField EmployeeIDField is the passed in employee ID field from the GUI. This field is used create the needed EmployeeNum for the input. 
     * @param JTextField FirstNameField is the passed in First Name Field from the GUI
     * @param JTextField LastNameField is the passed in Last Name Field from the GUI
     * @param JTextField JobTitleField is the passed in Job Title Field from the GUI
     * @param JTextField AssignedRepID is the passed in Employee Number from the GUI
     * @return nothing
     */
	public void execute(JTextField EmployeeIDField, JTextField FirstNameField, JTextField LastNameField, JTextField JobTitleField, JTextField userNameField, JTextField passwordField) {
		
		// Attributes needed for new Employee (based on the attributes found in the Employees Table in the Database)
		int employeeNum = 0;
		String firstName = null;
		String lastName = null;
		String jobTitle = null;
		String userName = null;
		String password = null;
		int passwordHash = 0;
		
		// For error checking
		boolean error = false;
		
		// String for error message(s)
		String errorMessage = "";
		
		// Check that the fields are not empty and all needed information is included
		// Needed information is ID, First Name, Last Name, Job Title
		
		if(EmployeeIDField.getText().equals(null) || EmployeeIDField.getText().equals("")) { error = true; errorMessage += "Employee ID Missing \n";}
		if(FirstNameField.getText().equals(null) || FirstNameField.getText().equals("")) { error = true; errorMessage += "First Name Missing \n";}
		if(LastNameField.getText().equals(null) || LastNameField.getText().equals("")) { error = true; errorMessage += "Last Name Missing \n";}
		if(JobTitleField.getText().equals(null) || JobTitleField.getText().equals("")) { error = true; errorMessage += "Job Title Missing \n";}
		if(userNameField.getText().equals(null) || userNameField.getText().equals("")) { error = true; errorMessage += "User Name Missing \n";}
		if(passwordField.getText().equals(null) || passwordField.getText().equals("")) { error = true; errorMessage += "Password Missing \n";}
		
		// Using the passed in JTextFields - extract the needed information to create a Employee
		employeeNum = Integer.parseInt(EmployeeIDField.getText());
		firstName = FirstNameField.getText();
		lastName = LastNameField.getText();
		jobTitle = JobTitleField.getText();
		userName = userNameField.getText();
		passwordHash = passwordField.getText().hashCode();
		password = passwordHash+"";
		
		
		// Check to make sure that the information put in is valid
    		// Employee ID Doesn't Exist
		 	String sqlCheckID = String.format("Select employeeNum from employees where employeeNum = \"%d\"", employeeNum);
	        
	        try {
	        Connection conn = this.connect();  
	        Statement stmt  = conn.createStatement(); 
	        
	        // Run SQL statement and return the result
	        ResultSet rs  = stmt.executeQuery(sqlCheckID);
	        
	        // loop through the result set - prints out each attribute for each tuple pulled
	        while (rs.next()) {  
	        	// If the Employee ID already exists
	            if(rs.getInt("employeeNum") == employeeNum) {error = true; errorMessage += "Employee ID Already Exists \n";}
	        }  
	        	} catch (SQLException e) {  
	        System.out.println(e.getMessage());  
	        	}  
	        
        	// Employee ID is not a negative
	        if(employeeNum <= 0 ) {error = true; errorMessage += "Employee ID Cannot Be Negative \n";}
	        
        	
	        
			// Phone Number is valid & does not exist

	     // Check for SQL injection
			
			// If no error was found in the input information - insert the employee and clear
			if(!error) {
				// Insert the employee into the Database
				insertEmployee(employeeNum, firstName, lastName, jobTitle, userName, password);
				
				// Update System
				
				// Clear the text fields
				
				EmployeeIDField.setText("");
				FirstNameField.setText("");
				LastNameField.setText("");
				JobTitleField.setText("");
				userNameField.setText("");
				passwordField.setText("");
				
				return;
			}
			
			// If an error was discovered - show error message to the user. 
			else {
				// Display pop up showing that the employee could not be found
	        	JOptionPane.showMessageDialog(null, errorMessage);
	        	return;
			}
		}

	
	 /*
     * Function adds an entry into the employee table within the fertilizer database
     * @param int employeeID is the unique employeeID assigned to a specific employee
     * @param String firstName is the employee's first name
     * @param String lastName is the employee's last name
     * @param String jobTitle is the employee's phone number
     * @param int assignedRepID is the corresponding employeeID for the sales rep associated
     * @return nothing
     */
    public void insertEmployee(int employeeNum, String firstName, String lastName, String jobTitle, String username, String password) {  
        
    	// The needed SQL command to be executed on the database to successfully insert an employee
    	String sql = "INSERT INTO employees(employeeNum, firstName, lastName, jobTitle, username, password )"
        		+ " VALUES(?,?,?,?,?,?)";  
   
        try{  
        	// Connect to the database
            Connection conn = this.connect();  
            
            // Execute the statement and insert the passed values
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, employeeNum);  
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, jobTitle);
            pstmt.setString(5, username); 
            pstmt.setString(6, password);
            
            // Update after executing
            pstmt.executeUpdate();  
            
            return;
        } catch (SQLException e) {  
            System.out.println(e.getMessage()); 
            return;
        }  
    }
    
    
    /*
     * Function to update a employee's entry in the database
     * @param String employeeNum is the unique employee ID of the employee being edited
     * @param JTextField FirstNameField is the Text Field Containing the Employee's first name
     * @param JTextField LastNameField is the Text Field Containing the Employee's Last name
     * @param JTextField JobTitleField is the Text Field Containing the Employee's job title
     * @param JTextField AssignedRepID is the Text Field Containing the Customer's assigned sales rep
     * @return nothing
     */
    public void updateEmployee(String employeeNum, JTextField FirstNameField, JTextField LastNameField, JTextField JobTitleField) {
		// Convert the employeeNum from String to Int
    	int employeeID = Integer.parseInt(employeeNum);
		
		// Load with information based on the loaded information in the text fields
    	String firstName = null;
		String lastName = null;
		String jobTitle = null;
            
            firstName = FirstNameField.getText();
            lastName = LastNameField.getText();
            jobTitle = JobTitleField.getText();
    	
        /*
         * Pass through the fields & ensure that they aren't blank - if not alter what the variable is assigned
         */
		if(FirstNameField.getText().length() != 0)
		{
			firstName = FirstNameField.getText();
		}
		
		if(LastNameField.getText().length() != 0) {
			lastName = LastNameField.getText();
		}
		
		if(JobTitleField.getText().length() != 0)
		{
			jobTitle = JobTitleField.getText();
		}
		
		
		// Update
		String updateEmployee = "Update employees "
				+ "SET firstName = ? , "
				+ "lastName = ?,"
				+ "jobTitle = ?,"
				+ "WHERE employeeNum = ?";
				
		try {
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(updateEmployee);  
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, jobTitle);
            pstmt.setInt(4, employeeID);
            pstmt.executeUpdate();
		
            pstmt.close();
            conn.close();
            return;
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            return;
            
        }  
    }

    
    /*
     * Function deletes employee from database 
     * @param String employeeID is the input employeeID to delete
     */
    public void deleteEmployee(String employeeID) {
    	int employeeNum = Integer.parseInt(employeeID);
    	
    	JFrame frame = new JFrame();
		int result = JOptionPane.showConfirmDialog(frame,"Are you sure you want to delete user", "CAUTION",
	               JOptionPane.YES_NO_OPTION,
	               JOptionPane.QUESTION_MESSAGE);
		
	    if(result == JOptionPane.YES_OPTION){
    	String sqlDelete = "Delete from employees where employeeNum = ?";
    	
    	try {
            Connection conn = this.connect();
            PreparedStatement pstmt  = conn.prepareStatement(sqlDelete);  
            pstmt.setInt(1, employeeNum);
            
            pstmt.executeUpdate();
    		
            pstmt.close();
            conn.close();
            
            // Tell user that operation was successful
        	JOptionPane.showMessageDialog(null, "Employee Deleted");
            return;
    	} catch (SQLException e) {  
            System.out.println(e.getMessage());  
            return;
            
        }  
	    } else {
	    	return;
	    }
	    
    }


    /*
     * Function to load a employee's entry in the database
     * @param String employeeNum is the unique employee ID of the employee being edited
     * @param JLabel IDLabel is the label used to show the employee's ID
     * @param JTextField FirstNameField is the Text Field Containing the Employee's first name
     * @param JTextField LastNameField is the Text Field Containing the Employee's Last name
     * @param JTextField JobTitleField is the Text Field Containing the Employee's job title
     * @param JTextField AssignedRepID is the Text Field Containing the Customer's assigned sales rep
     * @return nothing
     */
    public void loadEmployee(String employeeNum, JLabel IDLabel, JTextField FirstNameField, JTextField LastNameField, JTextField JobTitleField) {
    	// Convert the ID into an integer
    	int employeeID = Integer.parseInt(employeeNum);
		
		// Load with information based on the employee ID
    	String firstName = null;
		String lastName = null;
		String jobTitle = null;
		
		String sql = String.format("SELECT * from employees where employeeNum = \"%d\"", employeeID); 
		// Try and connect to the database
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);
            
            // Extract the needed information
            firstName = rs.getString("firstName");
            lastName = rs.getString("lastName");
            jobTitle = rs.getString("jobTitle");
            
            // Set the text of the fields
            IDLabel.setText(employeeID + "");
            FirstNameField.setText(firstName);
            LastNameField.setText(lastName);
            JobTitleField.setText(jobTitle);
            
            stmt.close();
            conn.close();
            return;
    
        } catch (SQLException e) {  
        	System.out.println(e.getMessage());  
        	return;
        
        }  
    }
    
    /*
     * function that runs selection on Customers table - specifically to pull information from all columns
     * @param String sql is the passed in SQL command to be sent to the Database
     */
    public Integer selectMaxEmployees(String sql){  
    	// Connect to the database
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);  
            // Result
            int result = 0;
            // loop through the result set - prints out each attribute for each tuple pulled
            while (rs.next()) {  
                result = (rs.getInt("employeeNum"));  
            }  
           
            return result;
            
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            return -1;
        }  
    }  
    
}






/*
public class CreateEmployee {
	
	private String firstName;
	private String lastName;
	private int employeeID;
	private String jobTitle;
	

	/**
	 * 
	 */

/*
	public CreateEmployee(String firstName, String lastName, int employeeID, String jobTitle) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
	}
	
	
	private Connection connect() {
		
		// SQLite connection string - this string is the file path to the database
		String url = "jdbc:sqlite:C://sqlite/fertilizer.db";
		Connection conn = null;
		
		// Test to make sure that the database exists
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
	
	
	// function to have the ability to delete an employee
	
	public void deleteEmployee() {
		this.firstName = null;
		this.lastName = null;
		this.employeeID = 0;
		this.jobTitle = null;
	}
	
	// Getter functions to obtain general employee information
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	
	// List allows for ability to lookup a specific employee
	
	public class EmployeeDirectory {
		private static List<CreateEmployee> employees = new ArrayList<>();
		
		public static void addEmployee(CreateEmployee employee) {
			employees.add(employee);
		}
		
		// search by employee name
		
		public static CreateEmployee searchEmployeeName(String firstName, String lastName) {
			for (CreateEmployee employee : employees) {
				if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
					return employee;
				}
			}
			return null;
		}
		
		// search by employee number
		
		public static CreateEmployee searchEmployeeID(int employeeID) {
			for (CreateEmployee employee : employees) {
				if (employee.getEmployeeID() == employeeID) {
					return employee;
				}
			}
			return null;
		}
		
	}

} */
