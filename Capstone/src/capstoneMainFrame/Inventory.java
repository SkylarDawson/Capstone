/**
 * 
 */
package capstoneMainFrame;

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
		Bins[0] = new Bin();
		Bins[1] = new Bin();
		Bins[2] = new Bin();
		Bins[3] = new Bin();
		Bins[4] = new Bin();
		Bins[5] = new Bin();
		Bins[6] = new Bin();
		Bins[7] = new Bin();
		Bins[8] = new Bin();
		Bins[9] = new Bin();
	}
	
	public boolean inboundBin(int index, String ingredient, int inbound) {
		if(Bins[index].getIngredient().equals(ingredient) && inbound > 0) {
			Bins[index].addStorage(inbound);
			return true;
		}
		else if(Bins[index].getIngredient().equals("-") && ingredient != null) {
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
		bin1Storage.setText(Integer.toString(Bins[0].getStorage()));
		bin2Ingredient.setText(Bins[1].getIngredient());
		bin2Storage.setText(Integer.toString(Bins[1].getStorage()));
		bin3Ingredient.setText(Bins[2].getIngredient());
		bin3Storage.setText(Integer.toString(Bins[2].getStorage()));
		bin4Ingredient.setText(Bins[3].getIngredient());
		bin4Storage.setText(Integer.toString(Bins[3].getStorage()));
		bin5Ingredient.setText(Bins[4].getIngredient());
		bin5Storage.setText(Integer.toString(Bins[4].getStorage()));
		bin6Ingredient.setText(Bins[5].getIngredient());
		bin6Storage.setText(Integer.toString(Bins[5].getStorage()));
		bin7Ingredient.setText(Bins[6].getIngredient());
		bin7Storage.setText(Integer.toString(Bins[6].getStorage()));
		bin8Ingredient.setText(Bins[7].getIngredient());
		bin8Storage.setText(Integer.toString(Bins[7].getStorage()));
		bin9Ingredient.setText(Bins[8].getIngredient());
		bin9Storage.setText(Integer.toString(Bins[8].getStorage()));
		bin10Ingredient.setText(Bins[9].getIngredient());
		bin10Storage.setText(Integer.toString(Bins[9].getStorage()));
	}
	
	public String getBinIngredient(int index) {
		return Bins[index].getIngredient();
	}
	
	public int getBinStorage(int index) {
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
