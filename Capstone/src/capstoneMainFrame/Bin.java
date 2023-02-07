/**
 * 
 */
package capstoneMainFrame;

/**
 * @author 19sky
 *
 */
public class Bin {
	private String ingredient;
	private int storage;
	
	/**
	 * 
	 */
	public Bin() {
		this.ingredient = "-";
		this.storage = 0;
	}
	
	public String getIngredient() {
		return this.ingredient;
	}
	
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
		return;
	}
	
	public int getStorage() {
		return storage;
	}
	
	public void addStorage(int inbound) {
		this.storage += inbound;
	}
	
	public boolean subStorage(int outbound) {
		if(this.storage >= outbound) {
			this.storage -= outbound;
			if(this.storage == 0) {
				this.ingredient = "-";
			}
			return true;
		}
		return false;
	}
	
	/**
	 * This emptyBin function will reset a bin to be empty.
	 * @return amount remaining in bin before emptied.
	 */
	public int emptyBin() {
		int temp = this.storage;
		this.ingredient = "-";
		this.storage = 0;
		return temp;
	}
}
