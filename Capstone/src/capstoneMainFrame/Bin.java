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
	private double storage;
	
	/**
	 * 
	 */
	public Bin(String ingredient, double storage) {
		this.ingredient = ingredient;
		this.storage = storage;
	}
	
	public String getIngredient() {
		return this.ingredient;
	}
	
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
		return;
	}
	
	public double getStorage() {
		return storage;
	}
	
	public void addStorage(double inbound) {
		this.storage += inbound;
	}
	
	public void subStorage(double outbound) {
		this.storage -= outbound;
		if(this.storage == 0) {
			this.ingredient = "-";
		}
		return;
	}
	
	/**
	 * This emptyBin function will reset a bin to be empty.
	 * @return amount remaining in bin before emptied.
	 */
	public double emptyBin() {
		double temp = this.storage;
		this.ingredient = "-";
		this.storage = 0;
		return temp;
	}
}
