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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author 19sky
 *
 */
public class CreateCustomer {

	/**
	 * 
	 */
	public CreateCustomer() {
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
     * This function executes the functionality of the create customer page
     * @param JTextField CustomerIDField is the passed in customer ID field from the GUI. This field is used create the needed customerNum for the input. 
     * @param JTextField FirstNameField is the passed in First Name Field from the GUI
     * @param JTextField LastNameField is the passed in Last Name Field from the GUI
     * @param JTextField AddressField is the passed in Customer Address Field from the GUI
     * @param JTextField PhoneField is the passed in Customer Phone Number Field from the GUI
     * @param JTextField EmailField is the passed in Customer Email Field from the GUI
     * @param JTextField AssignedRepID is the passed in Employee Number from the GUI
     * @return nothing
     */
	public void execute(JTextField CustomerIDField, JTextField FirstNameField, JTextField LastNameField, JTextField AddressField, JTextField PhoneNumField, JTextField EmailField, JTextField AssignedRepIDField) {
		
		// Attributes needed for new customer (based on the attributes found in the Customers Table in the Database)
		int customerNum = 0;
		String firstName = null;
		String lastName = null;
		String phoneNum = null;
		String address = null;
		String emailAddress = null;
		int outstandingBalance = 0;
		int assignedRepID = 0;
		
		// For error checking
		boolean error = false;
		
		// String for error message(s)
		String errorMessage = "";
		
		// Check that the fields are not empty and all needed information is included
		// Needed information is ID, First Name, Last Name, and Address
		
		if(CustomerIDField.getText() == null || CustomerIDField.getText() == "") { error = true; errorMessage += "Customer ID Missing \n";}
		if(FirstNameField.getText() == null || FirstNameField.getText() == "") { error = true; errorMessage += "First Name Missing \n";}
		if(LastNameField.getText() == null || LastNameField.getText() == "") { error = true; errorMessage += "Last Name Missing \n";}
		if(AddressField.getText() == null || AddressField.getText() == "") { error = true; errorMessage += "Address Missing \n";}
		
		// Using the passed in JTextFields - extract the needed information to create a customer
		customerNum = Integer.parseInt(CustomerIDField.getText());
		firstName = FirstNameField.getText();
		lastName = LastNameField.getText();
		phoneNum = PhoneNumField.getText();
		address = AddressField.getText();
		emailAddress = EmailField.getText();
		assignedRepID = Integer.parseInt(AssignedRepIDField.getText());
		
		// Check to make sure that the information put in is valid
    		// Customer ID Doesn't Exist
		 	String sqlCheckID = String.format("Select customerNum from customers where customerNum = \"%d\"", customerNum);
	        
	        try {
	        Connection conn = this.connect();  
	        Statement stmt  = conn.createStatement(); 
	        
	        // Run SQL statement and return the result
	        ResultSet rs  = stmt.executeQuery(sqlCheckID);
	        
	        // loop through the result set - prints out each attribute for each tuple pulled
	        while (rs.next()) {  
	        	// If the customer ID already exists
	            if(rs.getInt("customerNum") == customerNum) {error = true; errorMessage += "Customer ID Already Exists \n";}
	        }  
	        	} catch (SQLException e) {  
	        System.out.println(e.getMessage());  
	        	}  
	        
        	// Customer ID is not a negative
	        if(customerNum <= 0 ) {error = true; errorMessage += "Customer ID Cannot Be Negative \n";}
	        
        	// Employee ID exists in system
	        String employeeIDExists = String.format("Select employeeNum from employees where employeeNum = \"%d\"", assignedRepID);
	        
	        try {
	            Connection conn = this.connect();  
	            Statement stmt  = conn.createStatement(); 
	            
	            // Run SQL statement and return the result
	            ResultSet rs  = stmt.executeQuery(employeeIDExists);
	            
	            // loop through the result set - prints out each attribute for each tuple pulled
	            while (rs.next()) {  
	                if(rs.getInt("employeeNum") != assignedRepID) {error = true; errorMessage += "Employee ID Does Not Exist \n";}
	            }  
	            	} catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	            	}  
	        
			// Phone Number is valid & does not exist
        
        // Check for SQL injection
		
		// If no error was found in the input information - insert the customer and clear
		if(!error) {
			// Insert the customer into the Database
			insertCustomer(customerNum, firstName, lastName, phoneNum, address, emailAddress, outstandingBalance, assignedRepID);
			
			// Update System
			
			// Clear the text fields
			
			CustomerIDField.setText("");
			FirstNameField.setText("");
			LastNameField.setText("");
			PhoneNumField.setText("");
			AddressField.setText("");
			EmailField.setText("");
			AssignedRepIDField.setText("");
			
			return;
		}
		
		// If an error was discovered - show error message to the user. 
		else {
			// Display pop up showing that the customer could not be found
        	JOptionPane.showMessageDialog(null, errorMessage);
        	return;
		}
	}
	
	 /*
     * Function adds an entry into the customer table within the fertilizer database
     * @param int customerID is the unique customerID assigned to a specific customer
     * @param String firstName is the customer's first name
     * @param String lastName is the customer's last name
     * @param String phoneNum is the customer's phone number
     * @param String address is the customer's address
     * @param String email is the customer's email address
     * @param double outstandingBalance is the customer's current outstanding balance
     * @param int assignedRepID is the corresponding employeeID for the sales rep associated
     * @return nothing
     */
    public void insertCustomer(int customerNum, String firstName, String lastName, String phoneNum, String address, String email, 
    		double outstandingBalance, int assignedRepID) {  
        
    	// The needed SQL command to be executed on the database to succssfully insert a customer
    	String sql = "INSERT INTO customers(customerNum, firstName, lastName, phoneNum, address, "
        		+ "email, outstandingBalance, assignedRepID)"
        		+ " VALUES(?,?,?,?,?,?,?,?)";  
   
        try{  
        	// Connect to the database
            Connection conn = this.connect();  
            
            // Execute the statement and insert the passed values
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, customerNum);  
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, phoneNum);
            pstmt.setString(5, address);
            pstmt.setString(6, email);
            pstmt.setDouble(7, outstandingBalance);
            pstmt.setInt(8, assignedRepID); 
            
            // Update after executing
            pstmt.executeUpdate();  
            
            return;
        } catch (SQLException e) {  
            System.out.println(e.getMessage()); 
            return;
        }  
    }

    /*
     * Function to update a customer's entry in the database
     * @param String customerNum is the unique customer ID of the customer being edited
     * @param JTextField FirstNameField is the Text Field Containing the Customer's first name
     * @param JTextField LastNameField is the Text Field Containing the Customer's Last name
     * @param JTextField AddressField is the Text Field Containing the Customer's address
     * @param JTextField PhoneNumField is the Text Field Containing the Customer's phone num
     * @param JTextField EmailField is the Text Field Containing the Customer's email
     * @param JTextField AssignedRepID is the Text Field Containing the Customer's assigned sales rep
     * @return nothing
     */
    public void updateCustomer(String customerNum, JTextField FirstNameField, JTextField LastNameField, JTextField AddressField, JTextField PhoneNumField, JTextField EmailField, JTextField AssignedRepIDField) {
		// Convert the customerNum from String to Int
    	int customerID = Integer.parseInt(customerNum);
		
		// Load with information based on the loaded information in the text fields
    	String firstName = null;
		String lastName = null;
		String phoneNum = null;
		String address = null;
		String emailAddress = null;
		int assignedRepID = 0;
            
            firstName = FirstNameField.getText();
            lastName = LastNameField.getText();
            phoneNum = PhoneNumField.getText();
            address = AddressField.getText();
            emailAddress = EmailField.getText();
            assignedRepID = Integer.parseInt(AssignedRepIDField.getText());
    	
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
		
		if(PhoneNumField.getText().length() != 0)
		{
			phoneNum = PhoneNumField.getText();
		}
		
		if(AddressField.getText().length() != 0)
		{
			address = AddressField.getText();
		}
		
		if(EmailField.getText().length() != 0) 
		{
			emailAddress = EmailField.getText();
		}
		
		if(AssignedRepIDField.getText().length() != 0)
		{
			assignedRepID = Integer.parseInt(AssignedRepIDField.getText());
		}
		
		// Update
		String updateCustomer = "Update customers "
				+ "SET firstName = ? , "
				+ "lastName = ?,"
				+ "phoneNum = ?,"
				+ "address = ?,"
				+ "email = ?,"
				+ "assignedRepID = ? "
				+ "WHERE customerNum = ?";
				
		try {
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(updateCustomer);  
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phoneNum);
            pstmt.setString(4, address);
            pstmt.setString(5, emailAddress);
            pstmt.setInt(6, assignedRepID);
            pstmt.setInt(7, customerID);
            pstmt.executeUpdate();
		
            return;
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            return;
            
        }  
    }
    
    /*
     * Function to load a customer's entry in the database
     * @param String customerNum is the unique customer ID of the customer being edited
     * @param JLabel IDLabel is the label used to show the customer's ID
     * @param JTextField FirstNameField is the Text Field Containing the Customer's first name
     * @param JTextField LastNameField is the Text Field Containing the Customer's Last name
     * @param JTextField AddressField is the Text Field Containing the Customer's address
     * @param JTextField PhoneNumField is the Text Field Containing the Customer's phone num
     * @param JTextField EmailField is the Text Field Containing the Customer's email
     * @param JTextField AssignedRepID is the Text Field Containing the Customer's assigned sales rep
     * @return nothing
     */
    public void loadCustomer(String customerNum, JLabel IDLabel, JTextField FirstNameField, JTextField LastNameField, JTextField AddressField, JTextField PhoneNumField, JTextField EmailField, JTextField AssignedRepIDField) {
    	// Convert the ID into an integer
    	int customerID = Integer.parseInt(customerNum);
		
		// Load with information based on the customer ID
    	String firstName = null;
		String lastName = null;
		String phoneNum = null;
		String address = null;
		String emailAddress = null;
		int assignedRepID = 0;
		
		String sql = String.format("SELECT * from customers where customerNum = \"%d\"", customerID); 
		// Try and connect to the database
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);
            
            // Extract the needed information
            firstName = rs.getString("firstName");
            lastName = rs.getString("lastName");
            phoneNum = rs.getString("phoneNum");
            address = rs.getString("address");
            emailAddress = rs.getString("email");
            assignedRepID = rs.getInt("assignedRepID");
            
            // Set the text of the fields
            IDLabel.setText(customerID + "");
            FirstNameField.setText(firstName);
            LastNameField.setText(lastName);
            PhoneNumField.setText(phoneNum);
            AddressField.setText(address);
            EmailField.setText(emailAddress);
            AssignedRepIDField.setText(assignedRepID + "");
            
            stmt.close();
            conn.close();
            return;
    
        } catch (SQLException e) {  
        	System.out.println(e.getMessage());  
        	return;
        
        }  
    }
    
}
