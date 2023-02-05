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
	
	public int getStorage() {
		return storage;
	}
	
	/**
	 * This emptyBin function will reset a bin to be empty.
	 * @return true if bin emptied successfully
	 */
	public boolean emptyBin() {
		if(this.ingredient != "-") {
			this.ingredient = "-";
			this.storage = 0;
			return true;
		}
		return false;
	}
}
