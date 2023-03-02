/**
 * 
 */
package capstoneMainFrame;

/**
 * @author 19sky
 *
 */
public class Spread {

	private int number;
	private int customerID;
	private int date;
	/**
	 * 
	 */
	public Spread(int number) {
		this.number = number;
		this.customerID = -1;
		this.date = -1;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public int getCustomerID() {
		return this.customerID;
	}
	
	public void setCustomerID(int ID) {
		// Check if ID is in data base  before set
		if(ID == 1) {
			this.customerID = ID;
		}
		else {
			// Print ID not found
		}
	}
	
	public int getdate() {
		return this.date;
	}
	
	public void setdate() {
		this.date = 0;
	}

}
