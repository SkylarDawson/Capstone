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
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author 19sky
 *
 */
public class Inventory {

	private Bin[] Bins = new Bin[10];
	
	/**
	 * 
	 */
	public Inventory() {
		//Load Bin information from database
		ArrayList<Integer> bin = new ArrayList<Integer>();
		ArrayList<String> ingredient = new ArrayList<String>();
		ArrayList<Double> storage = new ArrayList<Double>();
		
		String sql = "Select * from inventory";
		// Try and connect to the database
        try {  
            Connection conn = connect();  
            Statement stmt  = conn.createStatement();  
            
            // Run SQL statement and return the result
            ResultSet rs    = stmt.executeQuery(sql);
            
            while (rs.next()) { 
            	// Extract the needed information
            	bin.add(rs.getInt("binNum"));
            	ingredient.add(rs.getString("ingredient"));
            	storage.add(rs.getDouble("amount"));
            }
            
            stmt.close();
            conn.close();    
        } catch (SQLException e) {  
        	System.out.println(e.getMessage());  
        }
		
		Bins[0] = new Bin(ingredient.get(0), storage.get(0));
		Bins[1] = new Bin(ingredient.get(1), storage.get(1));
		Bins[2] = new Bin(ingredient.get(2), storage.get(2));
		Bins[3] = new Bin(ingredient.get(3), storage.get(3));
		Bins[4] = new Bin(ingredient.get(4), storage.get(4));
		Bins[5] = new Bin(ingredient.get(5), storage.get(5));
		Bins[6] = new Bin(ingredient.get(6), storage.get(6));
		Bins[7] = new Bin(ingredient.get(7), storage.get(7));
		Bins[8] = new Bin(ingredient.get(8), storage.get(8));
		Bins[9] = new Bin(ingredient.get(9), storage.get(9));
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
	
	public boolean inboundBin(int index, String ingredient, int inbound) {
		if(Bins[index].getIngredient().equals(ingredient) && inbound > 0 && !ingredient.equals("-")) {
			Bins[index].addStorage(inbound);
			return true;
		}
		else if(Bins[index].getIngredient().equals("-") && !ingredient.equals("-")) {
			Bins[index].setIngredient(ingredient);
			Bins[index].addStorage(inbound);
			return true;
		}
		return false;
	}
	
	public void emptyBin(int currIndex, int nextIndex) {
		if(Bins[currIndex].getIngredient().equals(Bins[nextIndex].getIngredient())) {
			Bins[nextIndex].addStorage(Bins[currIndex].emptyBin());
		}
	}
	
	public void updateInventory(JLabel bin1Ingredient, JLabel bin2Ingredient, JLabel bin3Ingredient, JLabel bin4Ingredient, JLabel bin5Ingredient, JLabel bin6Ingredient, JLabel bin7Ingredient, JLabel bin8Ingredient, JLabel bin9Ingredient, JLabel bin10Ingredient, JLabel bin1Storage, JLabel bin2Storage, JLabel bin3Storage, JLabel bin4Storage, JLabel bin5Storage, JLabel bin6Storage, JLabel bin7Storage, JLabel bin8Storage, JLabel bin9Storage, JLabel bin10Storage ) {
		bin1Ingredient.setText(Bins[0].getIngredient());
		bin1Storage.setText(String.valueOf(Bins[0].getStorage()));
		bin2Ingredient.setText(Bins[1].getIngredient());
		bin2Storage.setText(String.valueOf(Bins[1].getStorage()));
		bin3Ingredient.setText(Bins[2].getIngredient());
		bin3Storage.setText(String.valueOf(Bins[2].getStorage()));
		bin4Ingredient.setText(Bins[3].getIngredient());
		bin4Storage.setText(String.valueOf(Bins[3].getStorage()));
		bin5Ingredient.setText(Bins[4].getIngredient());
		bin5Storage.setText(String.valueOf(Bins[4].getStorage()));
		bin6Ingredient.setText(Bins[5].getIngredient());
		bin6Storage.setText(String.valueOf(Bins[5].getStorage()));
		bin7Ingredient.setText(Bins[6].getIngredient());
		bin7Storage.setText(String.valueOf(Bins[6].getStorage()));
		bin8Ingredient.setText(Bins[7].getIngredient());
		bin8Storage.setText(String.valueOf(Bins[7].getStorage()));
		bin9Ingredient.setText(Bins[8].getIngredient());
		bin9Storage.setText(String.valueOf(Bins[8].getStorage()));
		bin10Ingredient.setText(Bins[9].getIngredient());
		bin10Storage.setText(String.valueOf(Bins[9].getStorage()));
	}
	
	public static void updateDatabase() {
		
	}
	
	public String getBinIngredient(int index) {
		return Bins[index].getIngredient();
	}
	
	public double getBinStorage(int index) {
		return Bins[index].getStorage();
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
