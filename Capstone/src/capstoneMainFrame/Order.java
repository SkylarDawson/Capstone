/**
 * 
 */
package capstoneMainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author 19sky
 *
 */
public class Order {

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
	 * @throws Exception 
	 * 
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
	
	public int getPriority() {
		return this.priority;
	}
	
	public int getSpreader() {
		return 1;
	}

	/*
	 * Set labels with provided order information
	 */
	public void display(JLabel lblcustomer, JLabel lbldate, JLabel lbladdress, JCheckBox lbldelivered, JTextField spreader, JLabel potashAmt, JLabel mapAmt, JLabel amsAmt, JLabel ureaAmt, JLabel gypsumAmt, JLabel potashMix, JLabel mapMix, JLabel amsMix, JLabel ureaMix, JLabel gypsumMix, JLabel employeeID) {
		Double mix0 = this.Potash;
		Double mix1 = mix0 + this.MAP;
		Double mix2 = mix1 + this.AMS;
		Double mix3 = mix2 + this.Urea;
		Double mix4 = mix3 + this.Gypsum;
		
		lblcustomer.setText(this.getCustomerName());
		lbldate.setText(this.PickUpDate);
		lbladdress.setText(this.getAddress());
		lbldelivered.setSelected(this.delivered);
		spreader.setText(String.valueOf(this.getSpreader()));
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
		employeeID.setText(String.valueOf(employeeNum));
	}
}
