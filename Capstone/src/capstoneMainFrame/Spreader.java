/**
 * 
 */
package capstoneMainFrame;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author 19sky
 *
 */
public class Spreader {
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");  
	LocalDateTime now = LocalDateTime.now();  
	
	/**
	 * Spreader Constructor
	 */
	public Spreader() {
		
	}
	
	/*
	 * connect to the database the specified based on the file path
	 */
    private static Connection connect() {  
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
     * Get the information from the data base to create a Table
     * @return TableModel with the spreader information
     */
	public static TableModel getTable() {

		ArrayList<Integer> spreaderNum = new ArrayList<Integer>();
		ArrayList<Integer> customerID = new ArrayList<Integer>();
		ArrayList<String> takenDate = new ArrayList<String>();
    	
		String sql = "Select * from spreaders";
		// Try and connect to the database
        try {  
            Connection conn = connect();  
            Statement stmt  = conn.createStatement();  
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);
            
            while (rs.next()) { 
            	// Extract the needed information
            	spreaderNum.add(rs.getInt("spreaderNum"));
            	customerID.add(rs.getInt("customerID"));
            	takenDate.add(rs.getString("dateOut"));
            }
            
            stmt.close();
            conn.close();    
        } catch (SQLException e) {  
        	System.out.println(e.getMessage());  
        	return null;
        }
		
		// Create objects to hold the data for the table
		Object[][] rowData = {};
		Object[] headers = {"Spreader #", "Customer", "Date"};
		
		// Create table object
		DefaultTableModel spreaderModel;
		spreaderModel = new DefaultTableModel (rowData, headers);
		
		// For each returned tuple - create a new row with all order information
		for(int i = 0; i < spreaderNum.size(); i++) {
			spreaderModel.addRow(new Object[]{ spreaderNum.get(i), getCustomerName(customerID.get(i)), takenDate.get(i) });
		}

		return spreaderModel;
	}
	
	/**
	 * Get customer name from database using the customerID
	 * @param customerNum integer of customerID
	 * @return String of customers first and last name
	 */
	public static String getCustomerName(int customerNum) {
		String firstName = null;
		String lastName = null;
		
		String sql = String.format("SELECT * from customers where customerNum = \"%d\"", customerNum);
		// Try and connect to the database
        try {  
            Connection conn = connect();  
            Statement stmt  = conn.createStatement();  
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);
            
            // Extract the needed information
            firstName = rs.getString("firstName");
            lastName = rs.getString("lastName");
            
            stmt.close();
            conn.close();
            if(firstName == null) firstName = "";
            if(lastName == null) lastName = "";
            return firstName + " " + lastName;
    
        } catch (SQLException e) {  
        	System.out.println(e.getMessage());  
        	return null;
        }
	}
	
	/**
	 * Create new spreader in database
	 * @param number integer of the new spreader
	 * @throws Exception thrown if the spreader number is invalid
	 */
	public void newSpreader(int number) throws Exception {
		if (number <= 0) {
			throw new Exception();
		}
		
		// The needed SQL command to be executed on the database to succssfully insert a customer
    	String sql = "INSERT INTO spreaders(spreaderNum, customerID, dateOut) VALUES(?,?,?)";  
   
        try{  
        	// Connect to the database
            Connection conn = connect();  
            
            // Execute the statement and insert the passed values
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, number);  
            pstmt.setInt(2, 0);
            pstmt.setString(3, null);
            
            // Update after executing
            pstmt.executeUpdate();  
            
            return;
        } catch (SQLException e) {  
            System.out.println(e.getMessage()); 
            return;
        }  
	}
	
	/**
	 * Claim the spreader by the customer and assign taken date
	 * @param number integer of spreader claimed
	 * @param customerID integer of customer claiming the spreader
	 * @throws Exception thrown if the spreader is not valid
	 */
	public void claimSpreader(int number, int customerID) throws Exception {
		
		String checkSpreader = String.format( "Select customerID from spreaders where spreaderNum = \"%x\" ;", number);
		// Update
		String updateSpreader = "Update spreaders "
				+ "SET customerID = ? , "
				+ "dateOut = ? "
				+ "WHERE spreaderNum = ?";
						
		try {
		    Connection conn = connect();  
		   
		    Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(checkSpreader); 
            if(!rs.next()) throw new Exception("Not Valid Spreader\n");
		    
		    PreparedStatement pstmt  = conn.prepareStatement(updateSpreader);  
		    pstmt.setInt(1, customerID);
		    pstmt.setString(2, dtf.format(now));
		    pstmt.setInt(3, number);	            
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
	 * Return spreader to the company
	 * @param number integer of the spreader number being returned
	 * @param check boolean true means spreader is returned
	 */
	public void returnSpreader(int number, boolean check) {
		if (check) {
			// Update
			String updateSpreader = "Update spreaders "
					+ "SET customerID = ? , "
					+ "dateOut = ? "
					+ "WHERE spreaderNum = ?";
							
			try {
	            Connection conn = connect();  
	            PreparedStatement pstmt  = conn.prepareStatement(updateSpreader);  
	            pstmt.setInt(1, 0);
	            pstmt.setString(2, null);
	            pstmt.setInt(3, number);	            
	            pstmt.executeUpdate();
				
	            pstmt.close();
	            conn.close();
	            return;
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	            return;
	            
	        }
		} 
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
}
