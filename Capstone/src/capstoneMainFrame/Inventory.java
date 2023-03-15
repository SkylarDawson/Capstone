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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author 19sky
 *
 */
public class Inventory {

	private static Bin[] Bins = new Bin[10];
	private int selectedPotash = -1;
	private int selectedMAP = -1;
	private int selectedAMS = -1;
	private int selectedUrea = -1;
	private int selectedGypsum = -1;
	
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
    private static Connection connect() {  
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
			updateDatabase();
			return true;
		}
		else if(Bins[index].getIngredient().equals("-") && !ingredient.equals("-")) {
			Bins[index].setIngredient(ingredient);
			Bins[index].addStorage(inbound);
			updateDatabase();
			return true;
		}
		return false;
	}
	
	public boolean computeOrder(Double[] outbound) throws Exception {
		try {
			if(Bins[selectedPotash].getStorage()  < outbound[0] || 
				Bins[selectedMAP].getStorage()  < outbound[1] || 
				Bins[selectedAMS].getStorage()  < outbound[2] || 
				Bins[selectedUrea].getStorage()  < outbound[3] || 
				Bins[selectedGypsum].getStorage()  < outbound[4]) throw new Exception();
		} catch (ArrayIndexOutOfBoundsException e) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame,"Select Valid Bins\nBack > Inventory > Select Bins");
		}
		
		Bins[selectedPotash].subStorage(outbound[0]);
		Bins[selectedMAP].subStorage(outbound[1]);
		Bins[selectedAMS].subStorage(outbound[2]);
		Bins[selectedUrea].subStorage(outbound[3]);
		Bins[selectedGypsum].subStorage(outbound[4]);
		updateDatabase();
		return true;
	}
	
	public void emptyBin(int currIndex, int nextIndex) {
		if(Bins[currIndex].getIngredient().equals(Bins[nextIndex].getIngredient())) {
			Bins[nextIndex].addStorage(Bins[currIndex].emptyBin());
		}
		updateDatabase();
	}
	
	public void updateInventory(JLabel bin1Ingredient, JLabel bin2Ingredient, JLabel bin3Ingredient, JLabel bin4Ingredient, JLabel bin5Ingredient, JLabel bin6Ingredient, JLabel bin7Ingredient, JLabel bin8Ingredient, JLabel bin9Ingredient, JLabel bin10Ingredient, JLabel bin1Storage, JLabel bin2Storage, JLabel bin3Storage, JLabel bin4Storage, JLabel bin5Storage, JLabel bin6Storage, JLabel bin7Storage, JLabel bin8Storage, JLabel bin9Storage, JLabel bin10Storage ) {
		bin1Ingredient.setText(Bins[0].getIngredient());
		bin1Storage.setText(String.format("%,.0f", Bins[0].getStorage()));
		bin2Ingredient.setText(Bins[1].getIngredient());
		bin2Storage.setText(String.format("%,.0f", Bins[1].getStorage()));
		bin3Ingredient.setText(Bins[2].getIngredient());
		bin3Storage.setText(String.format("%,.0f", Bins[2].getStorage()));
		bin4Ingredient.setText(Bins[3].getIngredient());
		bin4Storage.setText(String.format("%,.0f", Bins[3].getStorage()));
		bin5Ingredient.setText(Bins[4].getIngredient());
		bin5Storage.setText(String.format("%,.0f", Bins[4].getStorage()));
		bin6Ingredient.setText(Bins[5].getIngredient());
		bin6Storage.setText(String.format("%,.0f", Bins[5].getStorage()));
		bin7Ingredient.setText(Bins[6].getIngredient());
		bin7Storage.setText(String.format("%,.0f", Bins[6].getStorage()));
		bin8Ingredient.setText(Bins[7].getIngredient());
		bin8Storage.setText(String.format("%,.0f", Bins[7].getStorage()));
		bin9Ingredient.setText(Bins[8].getIngredient());
		bin9Storage.setText(String.format("%,.0f", Bins[8].getStorage()));
		bin10Ingredient.setText(Bins[9].getIngredient());
		bin10Storage.setText(String.format("%,.0f", Bins[9].getStorage()));
	}
	
	public static void updateDatabase() {
		// Update
		String updateSpreader = "Update inventory "
				+ "SET ingredient = ? , "
				+ "amount = ? "
				+ "WHERE binNum = ?";
							
		try {
		     Connection conn = connect();  
		     PreparedStatement pstmt  = conn.prepareStatement(updateSpreader);
		     for(int i = 0 ; i < 10 ; i++) {
		    	 pstmt.setString(1, Bins[i].getIngredient());
		    	 pstmt.setDouble(2, Bins[i].getStorage());
		    	 pstmt.setInt(3, i + 1);	            
		    	 pstmt.executeUpdate();
			 }
						
			 pstmt.close();
			 conn.close();
			 return;
		} catch (SQLException e) {  
		     System.out.println(e.getMessage());  
		     return; 
		}
	}
	
	public String getBinIngredient(int index) {
		return Bins[index].getIngredient();
	}
	
	public double getBinStorage(int index) {
		return Bins[index].getStorage();
	}	
	
	public void selectBins() {
		while(true) {
			int potash = Integer.valueOf(JOptionPane.showInputDialog("Bin to pull Potash from:"));
			if (Bins[potash - 1].getIngredient().equals("Potash") && potash > 0 && potash < 10) {
				this.selectedPotash = potash - 1;
				break;
			}
		}
		while(true) {
			int map = Integer.valueOf(JOptionPane.showInputDialog("Bin to pull MAP from:"));
			if (Bins[map - 1].getIngredient().equals("MAP") && map > 0 && map < 9) {
				this.selectedMAP = map - 1;
				break;
			}
		}
		while(true) {
			int ams = Integer.valueOf(JOptionPane.showInputDialog("Bin to pull AMS from:"));
			if (Bins[ams - 1].getIngredient().equals("AMS") && ams > 0 && ams < 9) {
				this.selectedAMS = ams - 1;
				break;
			}
		}
		while(true) {
			int urea = Integer.valueOf(JOptionPane.showInputDialog("Bin to pull Urea from:"));
			if (Bins[urea - 1].getIngredient().equals("Urea") && urea > 0 && urea < 9) {
				this.selectedUrea = urea - 1;
				break;
			}
		}
		while(true) {
			int gypsum = Integer.valueOf(JOptionPane.showInputDialog("Bin to pull Gypsum from:"));
			if (Bins[gypsum - 1].getIngredient().equals("Gypsum") && gypsum > 0 && gypsum < 9) {
				this.selectedGypsum = gypsum - 1;
				break;
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
