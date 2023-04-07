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
	 * Constructor to create a bin
	 * @param ingredient String of ingredient
	 * @param storage double of amount in storage
	 */
	public Bin(String ingredient, double storage) {
		this.ingredient = ingredient;
		this.storage = storage;
	}
	
	/**
	 * Get the ingredient name
	 * @return String of the ingredient name
	 */
	public String getIngredient() {
		return this.ingredient;
	}
	
	/**
	 * Set the ingredient name
	 * @param ingredient String name of new ingredient
	 */
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
		return;
	}
	
	/**
	 * Get amount in bin
	 * @return double of amount in bin
	 */
	public double getStorage() {
		return storage;
	}
	
	/**
	 * Add goods to storage of inbound matching ingredients
	 * @param inbound double input for storage
	 */
	public void addStorage(double inbound) {
		this.storage += inbound;
	}
	
	/**
	 * Subtract from storage based on parameters
	 * @param outbound double of amount needed to subract
	 */
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
