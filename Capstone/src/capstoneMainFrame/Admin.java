package capstoneMainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Admin {

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
	 * Function sets the labels on the admin page
	 * @param JLabel orders is the total orders label
	 * @param JLabel customers is the total customers label
	 */
	public void execute(JLabel orders, JLabel customers) {
		// SQL commands to find the total orders and customers
		String sqlOrderCount = String.format("Select COUNT(*) AS total from orders");
		String sqlCustomerCount = String.format("Select COUNT(*) AS total from customers");
       
		// VARS to store the total
		int orderCount = 0;
        int customerCount = 0;
        
        try {
        Connection conn = this.connect();  
        Statement stmt  = conn.createStatement(); 
        
        // Run SQL statement and return the result
        ResultSet rs  = stmt.executeQuery(sqlOrderCount);
        
        while (rs.next()) {  
        	// Get Order Count
        	orderCount = rs.getInt("total");
        }  
        
        // Close connection
        stmt.close();
        conn.close();
        
	} catch (SQLException e) {  
        System.out.println(e.getMessage());  
        	} 
        
        try {
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement(); 
            
            // Run SQL statement and return the result
            ResultSet rs  = stmt.executeQuery(sqlCustomerCount);
            
            while (rs.next()) {  
            	// Get customer Count
            	customerCount = rs.getInt("total");
            }  
            
            // Close connection
            stmt.close();
            conn.close();
            
    	} catch (SQLException e) {  
            System.out.println(e.getMessage());  
            	} 
        
        // Set the text of the labels
        orders.setText(orderCount +"");
        customers.setText(customerCount + "");
        
        return;
	}
	
	/*
	 * Function runs a report based on the user's selection
	 * @param report is the selected report to run
	 * @return TableModel for JTable on Admin page
	 */
	public TableModel runReport(String report) {
		// Array to hold all possible reports
		String[] reports = {"Outstanding Orders", "Customers with Balances", "Unpaid Orders"};
		
		// String to hold SQL command
		String sqlCommand;
    	
		// Based on selection run certain reports    	
    	if(report.equals( reports[0])){
				// Run SQL Command
    			sqlCommand = "Select firstName, lastName, orders.customerNum, orderNum, employeeNum, orderPaid, orderComplete, orderDelivered, pickUpDate, pickupTime, Potash, MAP, AMS, Urea, Gypsum, comments, orderDate"
		        		+ " from customers,orders "
		        		+ "where customers.customerNum = orders.customerNum AND orderComplete = False";
				
    			// Data for created table
    			Object[][] rowData = {};
				String[] headers = {"First Name", "Last Name", "orderNum", "customerNum", "employeeNum", "Paid", "Complete", "Delivered", "PickUp Date", "PickUp Time"
						, "Potash", "MAP", "AMS", "Urea", "Gypsum", "Order Date", "Comments"};
				
				// Holds the table model
				DefaultTableModel orderModel;
				orderModel = new DefaultTableModel (rowData, headers);
				
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
		            ResultSet rs    = stmt.executeQuery(sqlCommand);  
		              
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
		            
		            // Add each entry to the JTable
		            for(int i = 0; i < firstNames.size(); i++) {
		            	orderModel.addRow(new Object[]{ firstNames.elementAt(i), lastNames.elementAt(i), orderNums.elementAt(i), customerNums.elementAt(i), employeeNums.elementAt(i), ordersPaid.elementAt(i), ordersComplete.elementAt(i), ordersDelivered.elementAt(i), pickUpDates.elementAt(i), pickUpTimes.elementAt(i),
		            		Potashes.elementAt(i), MAPS.elementAt(i), AMS.elementAt(i), Ureas.elementAt(i), Gypsums.elementAt(i), orderDates.elementAt(i), Comments.elementAt(i) });
		            	}
		            
		        // Return the table model
				return orderModel;
				
				 // Catch if database could not be connected to
		        } catch (SQLException e) {  
		            System.out.println(e.getMessage());  
		            return new DefaultTableModel();
		            
		        }  
    	}
    	else if(report.equals(reports[1])) { 
    			// Run SQL Command
				sqlCommand = "Select customerNum, firstName, lastName, phoneNum, email, address, outstandingBalance from customers where outstandingBalance > 0";
				
				// Data storage for the table 
				Object[][] rowData = {};
				String[] headers = {"Customer Number", "First Name", "Last Name", "Phone Number", "Email", "Address", "Outstanding Balance"};
				
				// Vectors to store the data collected from the query
				Vector<Integer> customerNums = new Vector<Integer>();
		    	Vector<String> firstNames = new Vector<String>();
		    	Vector<String> lastNames = new Vector<String>();
		    	Vector<String> phoneNums = new Vector<String>();
		    	Vector<String> address = new Vector<String>();
		    	Vector<String> email = new Vector<String>();
		    	Vector<Double> balances = new Vector<Double>();
		    	
				// Create table object
				DefaultTableModel customerModel;
				customerModel = new DefaultTableModel (rowData, headers);
				
				try {  
			            Connection conn = this.connect();  
			            Statement stmt  = conn.createStatement();  
			            
			            
			            // Run SQL statement and return the result
			            ResultSet rs    = stmt.executeQuery(sqlCommand);  
			              
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
			       
			            // Step through each result from the query pulling each piece of customer infromation
		    			for(int i = 0; i < firstNames.size(); i++) {
		    			customerModel.addRow(new Object[]{ customerNums.elementAt(i),firstNames.elementAt(i), lastNames.elementAt(i),phoneNums.elementAt(i), email.elementAt(i), address.elementAt(i), balances.elementAt(i)});
		    			}
		    			
		    			// Return table model
		    			return customerModel;
			            
			            // Catch if database could not be connected to
			            } catch (SQLException e) {  
			                System.out.println(e.getMessage());  
			                return new DefaultTableModel();
			                
			            }
    	}
    	else if(report.equals(reports[2])) {
    		// Run SQL Command
			sqlCommand = "Select firstName, lastName, orders.customerNum, orderNum, employeeNum, orderPaid, orderComplete, orderDelivered, pickUpDate, pickupTime, Potash, MAP, AMS, Urea, Gypsum, comments, orderDate"
	        		+ " from customers,orders "
	        		+ "where customers.customerNum = orders.customerNum AND orderPaid = False";
			
			// Data for created table
			Object[][] rowData = {};
			String[] headers = {"First Name", "Last Name", "orderNum", "customerNum", "employeeNum", "Paid", "Complete", "Delivered", "PickUp Date", "PickUp Time"
					, "Potash", "MAP", "AMS", "Urea", "Gypsum", "Order Date", "Comments"};
			
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
	    	
			// Create table object
			DefaultTableModel paidModel;
			paidModel = new DefaultTableModel (rowData, headers);
			
			try {  
		            Connection conn = this.connect();  
		            Statement stmt  = conn.createStatement();  
		            
		            
		            // Run SQL statement and return the result
		            ResultSet rs    = stmt.executeQuery(sqlCommand); 
		            
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
		            
		            // Add each entry to the JTable
		            for(int i = 0; i < firstNames.size(); i++) {
		            	paidModel.addRow(new Object[]{ firstNames.elementAt(i), lastNames.elementAt(i), orderNums.elementAt(i), customerNums.elementAt(i), employeeNums.elementAt(i), ordersPaid.elementAt(i), ordersComplete.elementAt(i), ordersDelivered.elementAt(i), pickUpDates.elementAt(i), pickUpTimes.elementAt(i),
		            		Potashes.elementAt(i), MAPS.elementAt(i), AMS.elementAt(i), Ureas.elementAt(i), Gypsums.elementAt(i), orderDates.elementAt(i), Comments.elementAt(i) });
		            	}
		            
		        // Return the table model
				return paidModel;
		    // Catch if database could not be connected to
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
                return new DefaultTableModel();
                
            }
    	}
    	// If no report matches - return a default table model
    	else {
			return new DefaultTableModel();
			}
		}
		
	public void changePassword (int employeeID, String newPassword)
	{
		String updatePassword = "Update employees set password = ? where employeeNum = ? ";
		String hashedPassword = newPassword.hashCode()+"";
		try {
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(updatePassword);  
            pstmt.setString(1, hashedPassword);
            pstmt.setInt(2, employeeID);
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Password Updated");
            return;
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            return;
        }
		
	}
	
	public Boolean checkLogin(String username, String password ) {
		String yubistring = "PASS";
		// Activates override into system to be able to change password
		
		if(username.equals("ADMINOVERRIDE")) {
			
			// Check to make sure override password is correct
			if(password.equals(yubistring)) { 
				// If yes then 
				try {
				// Add dialog box to update a password
				JTextField userID = new JTextField();
				JTextField newPassword = new JTextField();
				JTextField confirmPassword = new JTextField();
					Object[] message = {
					    "Employee ID:", userID,
					    "New Password:", newPassword,
					    "Confirm New Password: ", confirmPassword
					};
				
				// If they confirm check the password
				int option = JOptionPane.showConfirmDialog(null, message, "Change Password", JOptionPane.OK_CANCEL_OPTION);
				if(option == JOptionPane.OK_OPTION)
				{
				// Check to make sure password is correct
				if(newPassword.getText().equals(confirmPassword.getText())){
					
					// If so then update password and return in
					int employeeNum = Integer.parseInt(userID.getText());
					changePassword(employeeNum, confirmPassword.getText());
					return true;
				}
				// Else spit out an error
				else {
					JOptionPane.showMessageDialog(null, "Password could not be reset");
					return false;
				}
				// If they cancel return false
				} else {
					return false;
				}}
				
				// Catch exceptions in error handling
			catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Error in formatting - exiting");
				 return false;
			}
			}
			else {
				return false;
				}
		}
		else {
		// Check to see if userID exists and if it does check the password
		try {
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement(); 
            
            String userIDcheck = String.format("Select username, password from employees where username = \"%s\"", username);
            
            // Run SQL statement and return the result
            ResultSet rs  = stmt.executeQuery(userIDcheck);
            if(rs.next() == false) {return false;}
            // loop through the result set - prints out each attribute for each tuple pulled
                if(rs.getString("password").equals(password.hashCode()+"")) {return true;}
   
            	} catch (SQLException e) {  
            		JOptionPane.showMessageDialog(null,(e.getMessage()));  
            		return false;
            	}  
		
		// If it went through loop
		return false;
		}
	}
		
	}

