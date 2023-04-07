/**
 * 
 */
package capstoneMainFrame;

import java.util.Date;

/**
 * @author 19sky
 *
 */
public class Spread {

	private int number;
	private int customerID;
	private Date date;

	/**
	 * Constructer to add spreader number with initial/default values
	 * @param number integer of spreader to add
	 */
	public Spread(int number) {
		this.number = number;
		this.customerID = -1;
		this.date = null;
	}
	
	/**
	 * Get number of spreader
	 * @return integer of spreader object
	 */
	public int getNumber() {
		return this.number;
	}
	
	/**
	 * Get customerID of spreader
	 * @return integer of customerID
	 */
	public int getCustomerID() {
		return this.customerID;
	}
	
	/**
	 * Assigns spreader to the customerID
	 * @param customerID integer of current customerID
	 */
	public void assignSpreader(int customerID) {
		this.customerID = customerID;
		this.date = new Date();
	}
	
	/**
	 * Get the date the spreader was taken
	 * @return Date associated with the spreader
	 */
	public Date getdate() {
		return this.date;
	}
	
	/**
	 * Reset spreader to appear to be returned/default state
	 */
	public void reset() {
		this.customerID = -1;
		this.date = null;
	}

}
