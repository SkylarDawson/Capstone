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
import javax.swing.JTextField;

/**
 * @author 19sky
 *
 */
public class Order {

	private int orderID = 0;
	private int priority;
	private int customerNum = 0;
	private int employeeNum = 0;
	private String PickUpDate = null;
	private	String PickUpTime = null;
	private	Double Potash = 0.0;
	private	Double MAP = 0.0;
	private	Double AMS = 0.0;
	private	Double Urea= 0.0;
	private	Double Gypsum = 0.0;
	private	String Comments = null;
	private	Boolean paid = false;
	private	Boolean complete = false;
	private	Boolean delivered = false;
	private	String orderDate = null;
	
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
	
	/**
	 * Create order given the order from the database and a priority of order
	 * @param OrderNum integer of the orderID to search in the database
	 * @param prior integer 1 - 10 of urgency of the order
	 * @throws Exception for when an invalid input is made
	 */
	public Order(String OrderNum, String prior) throws Exception {
		// Convert the customerNum from String to Int
    	int orderID = Integer.parseInt(OrderNum);
    	int priority = Integer.parseInt(prior);
    	
		// Is priority outside of range 1 - 10
		if(priority > 10 || priority < 1) throw new Exception("Priority Out of Range");
		this.priority = priority;
		
		// Import Order from database	
		String sql = String.format("SELECT * from orders where orderNum = \"%d\"", orderID); 
		// Try and connect to the database
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);
            
            // Extract the needed information
            this.orderID = orderID;
            this.customerNum = rs.getInt("customerNum");
            this.employeeNum = rs.getInt("employeeNum");
            this.paid = rs.getBoolean("orderPaid");
            this.complete = rs.getBoolean("orderComplete");
            this.delivered = rs.getBoolean("orderDelivered");
            this.PickUpDate = rs.getString("pickUpDate");
            this.PickUpTime = rs.getString("pickUpTime");
            this.Potash = rs.getDouble("Potash");
            this.MAP = rs.getDouble("MAP");
            this.AMS = rs.getDouble("AMS");
            this.Urea = rs.getDouble("Urea");
            this.Gypsum = rs.getDouble("Gypsum");
            this.Comments = rs.getString("comments");
            this.orderDate = rs.getString("orderDate");
            
            stmt.close();
            conn.close();
            return;
    
        } catch (SQLException e) {  
        	System.out.println(e.getMessage());  
        	return;
        
        } 
	}
	
	/**
	 * Get the customer name associated to the customer ID from the database
	 * @return String of customers first and last name together
	 */
	public String getCustomerName() {
		String firstName = null;
		String lastName = null;
		
		String sql = String.format("SELECT * from customers where customerNum = \"%d\"", this.customerNum);
		// Try and connect to the database
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);
            
            // Extract the needed information
            firstName = rs.getString("firstName");
            lastName = rs.getString("lastName");
            
            stmt.close();
            conn.close();
            return firstName + " " + lastName;
    
        } catch (SQLException e) {  
        	System.out.println(e.getMessage());  
        	return null;
        
        }
	}
	
	/**
	 * Get the address associated to the customer ID from the database
	 * @return String of customer address
	 */
	public String getAddress() {
		String address = null;
		
		String sql = String.format("SELECT * from customers where customerNum = \"%d\"", this.customerNum);
		// Try and connect to the database
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);
            
            // Extract the needed information
            address = rs.getString("address");
            
            stmt.close();
            conn.close();
            return address;
    
        } catch (SQLException e) {  
        	System.out.println(e.getMessage());  
        	return null;
        
        }
	}
	
	/**
	 * Get orderID to order
	 * @return integer of orderID
	 */
	public int getOrderID() {
		return this.orderID;
	}
	
	/**
	 * Get priority assigned to order
	 * @return integer of order priority
	 */
	public int getPriority() {
		return this.priority;
	}
	
	/**
	 * Get customer ID of order
	 * @return integer of customer ID
	 */
	public int getCustomerID() {
		return this.customerNum;
	}
	
	/**
	 * Get spreader number of customer associated with the order
	 * @return integer of spreader number
	 */
	public int getSpreader() {
		int number;
		
		String sql = String.format("SELECT * from spreaders where customerID = \"%d\"", this.customerNum);
		// Try and connect to the database
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);
            
            // Extract the needed information
            number = rs.getInt("spreaderNum");
            
            stmt.close();
            conn.close();
            return number;
    
        } catch (SQLException e) {  
        	System.out.println(e.getMessage());  
        	return 0;
        
        }
	}
	
	/**
	 * Get all the ingredient amounts in an array
	 * @return array of ingredient amounts
	 */
	public Double[] getOutputs() {
		Double[] arr = {this.Potash, this.MAP, this.AMS, this.Urea, this.Gypsum};
		return arr;
	}
	
	/**
	 * Updates order in database to show completed
	 */
	public void completeOrder() {
		// Update
		String updateOrder = "Update orders SET "
				+ "orderComplete = ?"
		     	+ " WHERE orderNum = ?";
						
		try {
			Connection conn = this.connect();  
			PreparedStatement pstmt  = conn.prepareStatement(updateOrder);  
			pstmt.setBoolean(1, true);
			pstmt.setInt(2, this.orderID);
			pstmt.executeUpdate();
			        
			pstmt.close();
			conn.close();
			return;
			} catch (SQLException e) {  
				System.out.println(e.getMessage());  
			return;
			} 
	}

	/**
	 * Set all the labels to display the order information
	 * @param lblcustomer label to display customer name
	 * @param lbldate label to display order date
	 * @param lbladdress label to display the address of delivery
	 * @param lbldelivered checkbox to display delivery status
	 * @param spreader textbox to display if customer has a spreader
	 * @param potashAmt label to display the amount of potash
	 * @param mapAmt label to display the amount of map
	 * @param amsAmt label to display the amount of ams
	 * @param ureaAmt label to display the amount of urea
	 * @param gypsumAmt label to display the amount of gypsum
	 * @param potashMix label to display the mixing label of potash
	 * @param mapMix label to display the mixing label of map
	 * @param amsMix label to display the mixing label of ams
	 * @param ureaMix label to display the mixing label of urea
	 * @param gypsumMix label to display the mixing label of gypsum
	 * @param employeeID label to display the employee's ID
	 */
	public void display(JLabel lblcustomer, JLabel lbldate, JLabel lbladdress, JCheckBox lbldelivered, JTextField spreader, JLabel potashAmt, JLabel mapAmt, JLabel amsAmt, JLabel ureaAmt, JLabel gypsumAmt, JLabel potashMix, JLabel mapMix, JLabel amsMix, JLabel ureaMix, JLabel gypsumMix, JLabel NPK, JLabel employeeID) {
		Double mix0 = this.Potash;
		Double mix1 = mix0 + this.MAP;
		Double mix2 = mix1 + this.AMS;
		Double mix3 = mix2 + this.Urea;
		Double mix4 = mix3 + this.Gypsum;
		
		int[] npkPotash = new int[] {0, 0, 60, 0};
		int[] npkMAP = new int[] {11, 52, 0, 0};
		int[] npkAMS = new int[] {21, 0, 0, 24};
		int[] npkUrea = new int[] {46, 0, 0, 0};
		
		Double n = ((npkPotash[0] * this.Potash) + (npkMAP[0] * this.MAP) + (npkAMS[0] * this.AMS) + (npkUrea[0] * this.Urea)) / mix3;
		Double p = ((npkPotash[1] * this.Potash) + (npkMAP[1] * this.MAP) + (npkAMS[1] * this.AMS) + (npkUrea[1] * this.Urea)) / mix3;;
		Double k = ((npkPotash[2] * this.Potash) + (npkMAP[2] * this.MAP) + (npkAMS[2] * this.AMS) + (npkUrea[2] * this.Urea)) / mix3;;
		Double s = ((npkPotash[3] * this.Potash) + (npkMAP[3] * this.MAP) + (npkAMS[3] * this.AMS) + (npkUrea[3] * this.Urea)) / mix3;;
		String npk = String.format("%.0f - %.0f - %.0f - %.0fs", n, p, k, s);
		
		lblcustomer.setText(this.getCustomerName());
		lbldate.setText(this.PickUpDate);
		lbladdress.setText(this.getAddress());
		lbldelivered.setSelected(this.delivered);
		if(this.getSpreader() == 0) spreader.setText("");
		else spreader.setText(String.valueOf(this.getSpreader()));
		potashAmt.setText(String.valueOf(this.Potash));
		mapAmt.setText(String.valueOf(this.MAP));
		amsAmt.setText(String.valueOf(this.AMS));
		ureaAmt.setText(String.valueOf(this.Urea));
		gypsumAmt.setText(String.valueOf(this.Gypsum));
		potashMix.setText(String.valueOf(mix0));
		mapMix.setText(String.valueOf(mix1));
		amsMix.setText(String.valueOf(mix2));
		ureaMix.setText(String.valueOf(mix3));
		gypsumMix.setText(String.valueOf(mix4));
		NPK.setText(npk);
		employeeID.setText(String.valueOf(employeeNum));
	}
}
