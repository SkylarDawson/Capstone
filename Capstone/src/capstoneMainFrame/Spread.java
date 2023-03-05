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
	 * 
	 */
	public Spread(int number) {
		this.number = number;
		this.customerID = -1;
		this.date = null;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public int getCustomerID() {
		return this.customerID;
	}
	
	/*
	 * assumes customer in database
	 */
	public void assignSpreader(int customerID) {
		this.customerID = customerID;
		this.date = new Date();
	}
	
	public Date getdate() {
		return this.date;
	}
	
	public void reset() {
		this.customerID = -1;
		this.date = null;
	}

}
