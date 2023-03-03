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

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author 19sky
 *
 */
public class CreateOrder {

	/**
	 * 
	 */
	public CreateOrder() {
		// TODO Auto-generated constructor stub
	}
	
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
		 * Function executes the functionality of the create order page 
		 * @param JTextField orderIDField is the passed orderID field value from the GUI
		 * @param JTextField customerIDField is the passed in customerIDField value from the GUI
		 * @param JTextField employeeIDField is the passed in employeeIDField from the GUI
		 * @param JTextField pickUpDateField is the pick up date field in the GUI
		 * @param JTextField pickUpTimeField is the pick up time field in the GUI
		 * @param JTextField potashField is the Potash Field in the GUI
		 * @param JTextField mapField is the MAP field in the GUI
		 * @param JTextField amsField is the AMS field in the GUI
		 * @param JTextField ureaField is the Urea Field in the GUI
		 * @param JTextField gypsumField is the Gypsum Field in the GUI
		 * @param JTextField commentsField is the Comments Field in the GUI
		 * @param JTextField orderDateField is the date that the order was placed (field from the GUI)
		 * @param JCheckBox OrderPaidBox is the box from the GUI stating if the order was paid
		 * @param JCheckBox OrderCompleteBox is the box from the GUI stating if the order was complete
		 * @param JCheckBox OrderDeliveredBox is the box from the GUI stating if the order was delivered
		 * @param double potashPrice is the price per unit of potash
		 * @param double mapPrice is the price per unit of MAP
		 * @param double amsPrice is the price per unit of AMS
		 * @param double ureaPrice is the price per unit of Urea
		 * @param double gypsumPrice is the price per unit of Gypsum
		 * @return nothing
		 */
		public void execute(JTextField orderIDField, JTextField customerIDField, JTextField employeeIDField, JTextField pickupDateField, JTextField pickupTimeField,
				JTextField potashField, JTextField mapField, JTextField amsField, JTextField ureaField, JTextField gypsumField, JTextField commentsField, JTextField orderDateField,
				JCheckBox OrderPaidBox, JCheckBox OrderCompleteBox, JCheckBox OrderDeliveredBox, double potashPrice, double mapPrice, double amsPrice, double ureaPrice, double gypsumPrice) {
	        
	        // All Attributes For Order
	        int orderNum = 0;
	        int customerNum = 0;
	        int employeeNum = 0;
	        boolean orderPaid = false;
	        boolean orderComplete = false;
	        boolean orderDelivered = false;
	        String pickUpDate = null;
	        String pickupTime = null;
	        double Potash = 0;
	        double MAP = 0;
	        double AMS = 0;
	        double Urea = 0;
	        double Gypsum = 0;
	        String comments = null;
	        String orderDate = null;
	        
	        // Flag for error checking
	        boolean error = false;
	        
	        // String for holding the Error Message(s)
	        String errorMessage = "";
	        
	        // Check to make sure that the required fields are not left empty
	        if(orderIDField.getText().equals(null) || orderIDField.getText().equals("")) {error = true; errorMessage += "Order ID Missing \n";}
	        if(customerIDField.getText().equals(null) || customerIDField.getText().equals("")) {error = true; errorMessage += "Customer ID Missing \n";}
	        if(employeeIDField.getText().equals(null) || employeeIDField.getText().equals("")) {error = true; errorMessage += "Employee ID Missing \n";}
	        if(pickupDateField.getText().equals(null) || pickupDateField.getText().equals("")) {error = true; errorMessage += "Pickup Date Missing \n";}
	        if(pickupTimeField.getText().equals(null)|| pickupTimeField.getText().equals("")) {error = true; errorMessage += "Pickup Time Missing \n";}
	        if(orderDateField.getText().equals(null)|| orderDateField.getText().equals("")) {error = true; errorMessage += "Order Date Missing \n";}
	        
	        // Attributes obtained by the user entered values
	        try {
	        orderNum = Integer.parseInt(orderIDField.getText());
	        } catch (Exception e) {
	        	error = true;
	        	errorMessage += "Order Number not an integer \n";
	        }
	        
	        try {
	        customerNum = Integer.parseInt(customerIDField.getText());
	        } catch (Exception e) {
	 	        error = true;
	 	        errorMessage += "Customer Number not an integer \n";
	 	    }
	        
	        try {
	        employeeNum = Integer.parseInt(employeeIDField.getText());
	        } catch (Exception e) {
	        	error = true;
	        	errorMessage += "Employee Number is not an integer \n";
	        }
	        if(OrderPaidBox.isSelected()) { orderPaid = true;}
	        if(OrderCompleteBox.isSelected()) { orderComplete = true;}
	        if(OrderDeliveredBox.isSelected()) { orderDelivered = true;}
	        pickUpDate = pickupDateField.getText();
	        pickupTime = pickupTimeField.getText();
	        
	        try {
	        	   Potash = Double.parseDouble(potashField.getText());
	        	   
	           } catch (Exception e) {
	        	   error = true;
	        	   errorMessage += "Potash Invalid # \n";
	           }
	            
	            try {
	            MAP = Double.parseDouble(mapField.getText());
	            } catch (Exception e) {
	            	error = true;
		        	errorMessage += "MAP Invalid # \n";
	            }
	            
	            try {
	            AMS = Double.parseDouble(amsField.getText());
	            } catch (Exception e) {
	            	error = true;
		        	errorMessage += "AMS Invalid # \n";
	            }
	            
	            try {
	            Urea = Double.parseDouble(ureaField.getText());
	            } catch (Exception e) {
	            	error = true;
		        	errorMessage += "Urea Invalid # \n";
	            }
	            
	            try {
	            Gypsum = Double.parseDouble(gypsumField.getText());
	            } catch (Exception e) {
	            	error = true;
		        	errorMessage += "Gypsum Invalid # \n";
	            }
	        comments = commentsField.getText();
	        orderDate = orderDateField.getText();
	        
	     // Check to make sure that the information put in is valid
	    	// Order ID Doesn't Exist
	        String sqlCheckID = String.format("Select orderNum from orders where orderNum = \"%d\"", orderNum);
	        
	        try {
	        Connection conn = this.connect();  
	        Statement stmt  = conn.createStatement(); 
	        
	        // Run SQL statement and return the result
	        ResultSet rs  = stmt.executeQuery(sqlCheckID);
	        
	        // loop through the result set - prints out each attribute for each tuple pulled
	        while (rs.next()) {  
	        	// If the order ID exists
	            if(rs.getInt("orderNum") == orderNum) {error = true; errorMessage += "Order ID already exists \n";}
	        }  
	        	} catch (SQLException e) {  
	        		System.out.println(e.getMessage());  
	        	}  
	        
	        // Order ID is not a negative
	        if(orderNum <= 0) {error = true; errorMessage += "Order ID cannot be negative \n";}
	        
	        // Customer ID exists in system
	        String customerIDExists = String.format("Select customerNum from customers where customerNUm = \"%d\"", customerNum);
	        
	        try {
	            Connection conn = this.connect();  
	            Statement stmt  = conn.createStatement(); 
	            
	            // Run SQL statement and return the result
	            ResultSet rs  = stmt.executeQuery(customerIDExists);
	            
	            // loop through the result set - prints out each attribute for each tuple pulled
	            while (rs.next()) {  
	                if(rs.getInt("customerNum") != customerNum) {error = true; errorMessage += "Customer ID does not exist \n";}
	            }  
	            	} catch (SQLException e) {  
	            		System.out.println(e.getMessage());  
	            	}  
	        // Employee ID exists in system
	        String employeeIDExists = String.format("Select employeeNum from employees where employeeNum = \"%d\"", employeeNum);
	       
	        try {
	            Connection conn = this.connect();  
	            Statement stmt  = conn.createStatement(); 
	            
	            // Run SQL statement and return the result
	            ResultSet rs  = stmt.executeQuery(employeeIDExists);
	            
	            // loop through the result set - prints out each attribute for each tuple pulled
	            while (rs.next()) {  
	                if(rs.getInt("employeeNum") != employeeNum) {error = true; errorMessage += "Employee ID does not exist \n";}
	            }  
	            	} catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	            	}  
	        // Bounds for ingredients
	        double minValue = 0;
	        double maxValue = 100;
	        
	        // Potash is valid number (not negative & does not exceed bound)
	        if(Potash < minValue || Potash > maxValue) {error = true; errorMessage += "Potash Invalid # \n";}
	        
	        // MAP is valid number (not negative & does not exceed bound)
	        if(MAP < minValue || MAP > maxValue) {error = true; errorMessage += "MAP Invalid # \n";}
	        
	        // AMS is valid number (not negative & does not exceed bound)
	        if(AMS < minValue || AMS > maxValue) {error = true; errorMessage += "AMS Invalid # \n";}
	        
	        // Urea is valid number (not negative & does not exceed bound)
	        if(Urea < minValue || Urea > maxValue) {error = true; errorMessage += "Urea Invalid # \n";}
	        
	        // Gypsum is valid number (not negative & does not exceed bound)
	        if(Gypsum < minValue || Gypsum > maxValue) {error = true; errorMessage += "Gypsum Invalid #";}
	        
	        // Check for SQL injection
	        
	        // If no error was found in the error checking - insert and clear
	        if(!error) {
	        	
	        // Insert the order
	        insertOrder(orderNum, customerNum, employeeNum, orderPaid, orderComplete, orderDelivered, pickUpDate,
	        		pickupTime, Potash, MAP, AMS, Urea, Gypsum, comments, orderDate);
	        
	        // Update System
	        	// Remove Amount from BINS
	        	// Automatically add billing
	        	double orderPrice = (Potash * potashPrice) + (MAP * mapPrice) + (AMS * amsPrice) + (Urea * ureaPrice) + (Gypsum * gypsumPrice);
	        	// Update Customer's Outstanding Balance
	        	if(orderPaid == false)
	        	{
	        		double currentBalance = 0.0;
	        		String sqlCurrentBalance = String.format("Select outstandingBalance from customers where customerNum = \"%d\"", customerNum);
	        		 try {
	     	            Connection conn = this.connect();  
	     	            Statement stmt  = conn.createStatement(); 
	     	            
	     	            // Run SQL statement and return the result
	     	            ResultSet rs  = stmt.executeQuery(sqlCurrentBalance);
	     	            
	     	            // loop through the result set - prints out each attribute for each tuple pulled
	     	            while (rs.next()) {  
	     	                currentBalance = rs.getDouble("outstandingBalance");
	     	            }
	     	            	} catch (SQLException e) {  
	     	            System.out.println(e.getMessage());  
	     	            	}  
	        		
	        		 double updatedBalance = currentBalance + orderPrice;
	        		// Update
	     			String updateBalance = "Update customers SET "
	     					+ "outstandingBalance = ?"
	     		       		+ " WHERE customerNum = ?";
	     					
	     			try {
	     	            Connection conn = this.connect();  
	     	            PreparedStatement pstmt  = conn.prepareStatement(updateBalance);  
	     	            pstmt.setDouble(1, updatedBalance);
	     	            pstmt.setInt(2, customerNum);
	     	            pstmt.executeUpdate();
	     	            
	     	            pstmt.close();
	     	            conn.close();
	     			
	     	            return;
	     	        } catch (SQLException e) {  
	     	            System.out.println(e.getMessage());  
	     	            return;
	     	            
	     	        }  
	        	}
	        
	        // Clear
			orderIDField.setText("");
	        customerIDField.setText("");
	        employeeIDField.setText("");
	        OrderPaidBox.setSelected(false);
	        OrderCompleteBox.setSelected(false);
	        OrderDeliveredBox.setSelected(false);
	        pickupDateField.setText("");
	        pickupTimeField.setText("");
	        potashField.setText("");
	        mapField.setText("");
	        amsField.setText("");
	        ureaField.setText("");
	        gypsumField.setText("");
	        commentsField.setText("");
	        orderDateField.setText("");
	        
	        return;
	        }
	        else {
	        	 // If an error was found - display error message to the user
	        	JOptionPane.showMessageDialog(null, errorMessage);
	        	return;
	        }
		}
	  
	   /*
	    * Function to insert a tuple into the order table
	    * @param int orderID is the unique orderID # for order
	    * @param int customerID is the customer ID number for the customer ordering the order
	    * @param int employeeID is the employee ID for the employee who placed the order
	    * @param boolean orderPaid denotes whether the order has been paid (T) or not (F)
	    * @param boolean orderComplete denotes whether the order has been completed (T) or not (F)
	    * @param boolean orderDelivered denotes whether the order has been delivered to customer or not (T) or not (F)
	    * @param String pickUpDate is the date the order is to be picked up
	    * @param String pickupTime is the time on the specified date the order is to be picked up
	    * @param double nitrogen is the N value of the fertilizer NPK value
	    * @param double phosphorous is the P value of the fertilizer NPK value
	    * @param double potassium is the K value of the fertilizer NPK value
	    * @param String comments is the comments on the order
	    * @param String orderDate is the date the order was placed. 
	    * @return nothing
	    */
	   public void insertOrder(int orderNum, int customerNum, int employeeNum, boolean orderPaid, boolean orderComplete, 
	   		boolean orderDelivered, String pickUpDate, String pickupTime, double potash, double MAP, double AMS, double Urea, double Gypsum, 
	   		String comments, String orderDate  ) {  
	   	
	   	// SQL statement to insert tuple into order table
	       String sql = "INSERT INTO orders(orderNum, customerNum, employeeNum, orderPaid, orderComplete, "
	       		+ "orderDelivered, pickUpDate, pickupTime, Potash, MAP, AMS, Urea, Gypsum, comments, orderDate )"
	       		+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
	  
	       try{ 
	       	// Connect to the database
	           Connection conn = this.connect();  
	           PreparedStatement pstmt = conn.prepareStatement(sql);  
	           
	           // Execute the insert statements
	           pstmt.setInt(1, orderNum);  
	           pstmt.setInt(2, customerNum);
	           pstmt.setInt(3, employeeNum);
	           pstmt.setBoolean(4, orderPaid);
	           pstmt.setBoolean(5,orderComplete);
	           pstmt.setBoolean(6, orderDelivered);
	           pstmt.setString(7, pickUpDate);
	           pstmt.setString(8, pickupTime);
	           pstmt.setDouble(9, potash);  
	           pstmt.setDouble(10, MAP);
	           pstmt.setDouble(11, AMS);
	           pstmt.setDouble(12, Urea);
	           pstmt.setDouble(13, Gypsum);
	           pstmt.setString(14, comments);
	           pstmt.setString(15, orderDate);
	           
	           // Update the database
	           pstmt.executeUpdate();  
	           
	           JOptionPane.showMessageDialog(null, "Order Created Successfully");
	           return;
	           
	       } catch (SQLException e) {  
	           System.out.println(e.getMessage()); 
	           
	           return;
	       }  
	   }  
	   
	   /*
	     * Function to update an order's entry in the database
	     * @param String orderNum is the unique order ID of the order being edited
	     * @param JTextField CustomerNumField is the Text Field Containing the Customer ID for the Order
	     * @param JTextField EmployeeNumField is the Text Field Containing the Employee IF for the Order
	     * @param JTextField PickUpDateField is the Text Field Containing the order pick up date
	     * @param JTextField PickUpTimeField is the Text Field Containing the order pick up time
	     * @param JTextField PotashField is the Text Field Containing the order potash amount
	     * @param JTextField MAPField is the Text Field Containing the order MAP amount
	     * @param JTextField AMSField is the Text Field Containing the order AMS Amount
	     * @param JTextField UreaField is the Text Field Containing the order Urea Amount
	     * @param JTextField GypsumField is the Text Field Containing the order pick up date
	     * @param JTextField CommentsField is the Text Field Containing the order comments
	     * @param JTextCheckBox PaidBox is the check box stating if the order is paid
	     * @param JTextCheckBox CompleteBox is the check box stating if the order is complete
	     * @param JTextCheckBox DeliveredBox is the check box stating if the order is delivered
	     * @return nothing
	     */
	    public void updateOrder(String OrderNum, JTextField CustomerNumField, JTextField EmployeeNumField, JTextField PickupDateField, JTextField PickupTimeField, JTextField PotashField, JTextField MAPField, JTextField AMSField, JTextField UreaField,
	    		JTextField GypsumField, JTextField CommentsField, JCheckBox PaidBox, JCheckBox CompleteBox, JCheckBox DeliveredBox, double potashPrice, double mapPrice, double amsPrice, double ureaPrice, double gypsumPrice) {
			// Convert the customerNum from String to Int
	    	int orderID = Integer.parseInt(OrderNum);
			
			// Load with information based on the loaded information in the text fields
	    	int customerNum = 0;
			int employeeNum = 0;
			String PickUpDate = null;
			String PickUpTime = null;
			Double Potash = 0.0;
			Double MAP = 0.0;
			Double AMS = 0.0;
			Double Urea= 0.0;
			Double Gypsum = 0.0;
			String Comments = null;
			Boolean paid = false;
			Boolean previouslyPaid = false;
			Boolean complete = false;
			Boolean delivered = false;
			Boolean error = false;
			String errorMessage = "";
	            
			  if(CustomerNumField.getText().equals(null) || CustomerNumField.getText().equals("")) {error = true; errorMessage += "Customer ID Missing \n";}
		      if(EmployeeNumField.getText().equals(null) || EmployeeNumField.getText().equals("")) {error = true; errorMessage += "Employee ID Missing \n";}
		      if(PickupDateField.getText().equals(null) || PickupDateField.getText().equals("")) {error = true; errorMessage += "Pickup Date Missing \n";}
		      if(PickupTimeField.getText().equals(null)|| PickupTimeField.getText().equals("")) {error = true; errorMessage += "Pickup Time Missing \n";}
		       
			try {
	            customerNum = Integer.parseInt(CustomerNumField.getText());
			} catch (Exception e) {
				error = true;
				errorMessage += "Customer Number not an integer \n";
			}
			
			try {
	            employeeNum = Integer.parseInt(EmployeeNumField.getText());
			} catch (Exception e){
				error = true;
				errorMessage += "Employee Number not an integer \n";
			}
			
	            PickUpDate = PickupDateField.getText();
	            PickUpTime = PickupTimeField.getText();
	           
	           try {
	        	   Potash = Double.parseDouble(PotashField.getText());
	        	   
	           } catch (Exception e) {
	        	   error = true;
	        	   errorMessage += "Potash Invalid # \n";
	           }
	            
	            try {
	            MAP = Double.parseDouble(MAPField.getText());
	            } catch (Exception e) {
	            	error = true;
		        	errorMessage += "MAP Invalid # \n";
	            }
	            
	            try {
	            AMS = Double.parseDouble(AMSField.getText());
	            } catch (Exception e) {
	            	error = true;
		        	errorMessage += "AMS Invalid # \n";
	            }
	            
	            try {
	            Urea = Double.parseDouble(UreaField.getText());
	            } catch (Exception e) {
	            	error = true;
		        	errorMessage += "Urea Invalid # \n";
	            }
	            
	            try {
	            Gypsum = Double.parseDouble(GypsumField.getText());
	            } catch (Exception e) {
	            	error = true;
		        	errorMessage += "Gypsum Invalid # \n";
	            }
	            
	            Comments = CommentsField.getText();
	            
	            paid = PaidBox.isSelected();
	            complete = CompleteBox.isSelected();
	            delivered = DeliveredBox.isSelected();
	            
	            // Bounds for ingredients
		        double minValue = 0;
		        double maxValue = 100;
		        
		        // Potash is valid number (not negative & does not exceed bound)
		        if(Potash < minValue || Potash > maxValue) {error = true; errorMessage += "Potash Invalid # \n";}
		        
		        // MAP is valid number (not negative & does not exceed bound)
		        if(MAP < minValue || MAP > maxValue) {error = true; errorMessage += "MAP Invalid # \n";}
		        
		        // AMS is valid number (not negative & does not exceed bound)
		        if(AMS < minValue || AMS > maxValue) {error = true; errorMessage += "AMS Invalid # \n";}
		        
		        // Urea is valid number (not negative & does not exceed bound)
		        if(Urea < minValue || Urea > maxValue) {error = true; errorMessage += "Urea Invalid # \n";}
		        
		        // Gypsum is valid number (not negative & does not exceed bound)
		        if(Gypsum < minValue || Gypsum > maxValue) {error = true; errorMessage += "Gypsum Invalid #";}
		        
	            if(!error) {
	            String checkIfPaid = String.format("Select orderPaid from orders where orderNum = \"%d\"", orderID);
	            try {
     	            Connection conn = this.connect();  
     	            Statement stmt  = conn.createStatement(); 
     	            
     	            // Run SQL statement and return the result
     	            ResultSet rs  = stmt.executeQuery(checkIfPaid);
     	            
     	            // loop through the result set - prints out each attribute for each tuple pulled
     	            while (rs.next()) {  
     	                previouslyPaid = rs.getBoolean("orderPaid");
     	            }
     	            conn.close();
     	            stmt.close();
     	            	} catch (SQLException e) {  
     	            System.out.println(e.getMessage());  
     	            	} 
			
			// Update
			String updateOrder = "Update orders SET "
					+ "customerNum = ?, employeeNum = ?, orderPaid = ?, orderComplete = ?, "
		       		+ "orderDelivered = ?, pickUpDate = ?, pickupTime = ?, Potash = ?, MAP = ?"
		       		+ ", AMS = ?, Urea = ?, Gypsum = ?, comments = ?"
		       		+ " WHERE orderNum = ?";
					
			try {
	            Connection conn = this.connect();  
	            PreparedStatement pstmt  = conn.prepareStatement(updateOrder);  
	            pstmt.setInt(1, customerNum);
	            pstmt.setInt(2, employeeNum);
	            pstmt.setBoolean(3, paid);
	            pstmt.setBoolean(4, complete);
	            pstmt.setBoolean(5, delivered);
	            pstmt.setString(6, PickUpDate);
	            pstmt.setString(7, PickUpTime);
	            pstmt.setDouble(8, Potash);
	            pstmt.setDouble(9, MAP);
	            pstmt.setDouble(10, AMS);
	            pstmt.setDouble(11, Urea);
	            pstmt.setDouble(12, Gypsum);
	            pstmt.setString(13, Comments);
	            pstmt.setInt(14, orderID);
	            pstmt.executeUpdate();
	            
	            pstmt.close();
	            conn.close();
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	            return;
	        }
	            
			// Update Billing
			// Automatically add billing
        	double orderPrice = (Potash * potashPrice) + (MAP * mapPrice) + (AMS * amsPrice) + (Urea * ureaPrice) + (Gypsum * gypsumPrice);
        	// Update Customer's Outstanding Balance
        	if(paid == false)
        	{
        		double currentBalance = 0.0;
        		String sqlCurrentBalance = String.format("Select outstandingBalance from customers where customerNum = \"%d\"", customerNum);
        		 try {
     	            Connection conn = this.connect();  
     	            Statement stmt  = conn.createStatement(); 
     	            
     	            // Run SQL statement and return the result
     	            ResultSet rs  = stmt.executeQuery(sqlCurrentBalance);
     	            
     	            // loop through the result set - prints out each attribute for each tuple pulled
     	            while (rs.next()) {  
     	                currentBalance = rs.getDouble("outstandingBalance");
     	                System.out.println(currentBalance + "");
     	            }
     	            	} catch (SQLException e) {  
     	            System.out.println(e.getMessage());  
     	            	}  
        		
        		 double updatedBalance = currentBalance + orderPrice;
        		 System.out.println(updatedBalance + "");
        		// Update
     			String updateBalance = "Update customers SET "
     					+ "outstandingBalance = ?"
     		       		+ " WHERE customerNum = ?";
     					
     			try {
     	            Connection conn = this.connect();  
     	            PreparedStatement pstmt  = conn.prepareStatement(updateBalance);  
     	            pstmt.setDouble(1, updatedBalance);
     	            pstmt.setInt(2, customerNum);
     	            pstmt.executeUpdate();
     	            
     	            pstmt.close();
     	            conn.close();
     			
     	        // Tell user that operation was successful
    	        	JOptionPane.showMessageDialog(null, "Order Updated");
     	            return;
     	        } catch (SQLException e) {  
     	            System.out.println(e.getMessage());  
     	            return;
     	            
     	        } 
        	}
     			else if(paid == true && previouslyPaid == false) {
     				double currentBalance = 0.0;
            		String sqlCurrentBalance = String.format("Select outstandingBalance from customers where customerNum = \"%d\"", customerNum);
            		 try {
         	            Connection conn = this.connect();  
         	            Statement stmt  = conn.createStatement(); 
         	            
         	            // Run SQL statement and return the result
         	            ResultSet rs  = stmt.executeQuery(sqlCurrentBalance);
         	            
         	            // loop through the result set - prints out each attribute for each tuple pulled
         	            while (rs.next()) {  
         	                currentBalance = rs.getDouble("outstandingBalance");
         	            }
         	            	} catch (SQLException e) {  
         	            System.out.println(e.getMessage());  
         	            	}  
            		
            		 double updatedBalance = currentBalance - orderPrice;
            		// Update
         			String updateBalance = "Update customers SET "
         					+ "outstandingBalance = ?"
         		       		+ " WHERE customerNum = ?";
         					
         			try {
         	            Connection conn = this.connect();  
         	            PreparedStatement pstmt  = conn.prepareStatement(updateBalance);  
         	            pstmt.setDouble(1, updatedBalance);
         	            pstmt.setInt(2, customerNum);
         	            pstmt.executeUpdate();
         	            
         	            pstmt.close();
         	            conn.close();
         			
         	            // Tell user that operation was successful
        	        	JOptionPane.showMessageDialog(null, "Order Updated");
  
         	            return;
         	        } catch (SQLException e) {  
         	            System.out.println(e.getMessage());  
         	            return;
         	            
         	        }  
     			}
        	
	    } else {
    	        	 // If an error was found - display error message to the user
    	        	JOptionPane.showMessageDialog(null, errorMessage);
    	        	return;
    	        }
        	}
	    
	    /*
	     * Function deletes order from database 
	     * @param String orderID is the input orderID to delete
	     */
	    public void deleteOrder(String orderID) {
	    	int orderNum = Integer.parseInt(orderID);
	    	
	    	String sqlDelete = "Delete from orders where orderNum = ?";
	    	
	    	try {
	            Connection conn = this.connect();
	            PreparedStatement pstmt  = conn.prepareStatement(sqlDelete);  
	            pstmt.setInt(1, orderNum);
	            
	            pstmt.executeUpdate();
	    		
	            pstmt.close();
	            conn.close();
	            
	            JOptionPane.showMessageDialog(null, "Order Deleted");
	            return;
	    	} catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	            return;
	            
	        }  
	    }
	    
	    /*
	     * Function to load a customer's entry in the database
	     * @param JLabel orderIDLabel is the label holding the order ID
	     * @param String orderNum is the unique order ID of the order being edited
	     * @param JTextField CustomerNumField is the Text Field Containing the Customer ID for the Order
	     * @param JTextField EmployeeNumField is the Text Field Containing the Employee IF for the Order
	     * @param JTextField PickUpDateField is the Text Field Containing the order pick up date
	     * @param JTextField PickUpTimeField is the Text Field Containing the order pick up time
	     * @param JTextField PotashField is the Text Field Containing the order potash amount
	     * @param JTextField MAPField is the Text Field Containing the order MAP amount
	     * @param JTextField AMSField is the Text Field Containing the order AMS Amount
	     * @param JTextField UreaField is the Text Field Containing the order Urea Amount
	     * @param JTextField GypsumField is the Text Field Containing the order pick up date
	     * @param JTextField CommentsField is the Text Field Containing the order comments
	     * @param JTextCheckBox PaidBox is the check box stating if the order is paid
	     * @param JTextCheckBox CompleteBox is the check box stating if the order is complete
	     * @param JTextCheckBox DeliveredBox is the check box stating if the order is delivered
	     * @param JLabel orderDateField is the label holding the date the order was placed
	     */
	    public void loadOrder(String OrderNum, JLabel orderIDLabel, JTextField CustomerNumField, JTextField EmployeeNumField, JTextField PickupDateField, JTextField PickupTimeField, JTextField PotashField, JTextField MAPField, JTextField AMSField, JTextField UreaField,
	    		JTextField GypsumField, JTextField CommentsField, JCheckBox PaidBox, JCheckBox CompleteBox, JCheckBox DeliveredBox, JLabel orderDateLabel) {
			// Convert the customerNum from String to Int
	    	int orderID = Integer.parseInt(OrderNum);
			
			// Load with information based on the loaded information in the text fields
	    	int customerNum = 0;
			int employeeNum = 0;
			String PickUpDate = null;
			String PickUpTime = null;
			Double Potash = 0.0;
			Double MAP = 0.0;
			Double AMS = 0.0;
			Double Urea= 0.0;
			Double Gypsum = 0.0;
			String Comments = null;
			Boolean paid = false;
			Boolean complete = false;
			Boolean delivered = false;
			String orderDate = null;
			
			String sql = String.format("SELECT * from orders where orderNum = \"%d\"", orderID); 
			// Try and connect to the database
	        try {  
	            Connection conn = this.connect();  
	            Statement stmt  = conn.createStatement();  
	            
	            // Run SQL statement and return the result
	            ResultSet rs    = stmt.executeQuery(sql);
	            
	            // Extract the needed information
	            customerNum = rs.getInt("customerNum");
            	employeeNum = rs.getInt("employeeNum");
            	paid = rs.getBoolean("orderPaid");
            	complete = rs.getBoolean("orderComplete");
            	delivered = rs.getBoolean("orderDelivered");
            	PickUpDate = rs.getString("pickUpDate");
            	PickUpTime = rs.getString("pickUpTime");
            	Potash = rs.getDouble("Potash");
            	MAP = rs.getDouble("MAP");
            	AMS = rs.getDouble("AMS");
            	Urea = rs.getDouble("Urea");
            	Gypsum = rs.getDouble("Gypsum");
            	Comments = rs.getString("comments");
            	orderDate = rs.getString("orderDate");
	            
	            // Set the text of the fields
	            orderIDLabel.setText(orderID + "");
	            CustomerNumField.setText(customerNum + "");
	            EmployeeNumField.setText(employeeNum + "");
	            PickupDateField.setText(PickUpDate);
	            PickupTimeField.setText(PickUpTime);
	            PotashField.setText(Potash + "");
	            MAPField.setText(MAP + "");
	            AMSField.setText(AMS + "");
	            UreaField.setText(Urea + "");
	            GypsumField.setText(Gypsum + "");
	            CommentsField.setText(Comments);
	            orderDateLabel.setText(orderDate);
	            PaidBox.setSelected(paid);
	            CompleteBox.setSelected(complete);
	            DeliveredBox.setSelected(delivered);
	            
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
	    public Integer selectMaxOrders(String sql){  
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
	                result = (rs.getInt("orderNum"));  
	            }  
	           
	            return result;
	            
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	            return -1;
	        }  
	    }  

}
