/**
 * 
 */
package capstoneMainFrame;

import javax.swing.JPanel;
import java.util.ArrayList;

/**
 * @author 19sky
 *
 */
public class Spreader {

	private ArrayList<Spread> Spreaders = new ArrayList<Spread>();
	
	/**
	 * 
	 */
	public Spreader() {
		// //Load Spreader information from database
		
	}
	
	/*
	 * check if arraylist is empty
	 */
	public void newSpreader(int number) {
		Spread sort = new Spread(number);
		for(int i = 0; i < Spreaders.size(); i++ ) {
			if(sort.getNumber() == Spreaders.get(i).getNumber()) {
				//Caution already exists
				break;
			}
			else if(sort.getNumber() < Spreaders.get(i).getNumber()) {
				Spreaders.add(i,sort);
				break;
			}
		}
	}
	
	/*
	 * Updates the information on spreader page. import all labels and assign appropiatly.
	 */
	public void updatePage() {
		
	}
	
	/*
	 * Check if customerID exist and update date to current date at number index
	 * check if arraylist is empty
	 */
	public void claimSpreader(int number, int customerID, int date) {
		if(Spreaders.isEmpty()) {
			
		}
		for(int i = 0; i < Spreaders.size(); i++ ) {
			if(number == Spreaders.get(i).getNumber()) {
				// If customer exists in database
				if(customerID == 0) {
					Spreaders.get(i).setCustomerID(customerID);
				}
				Spreaders.get(i).setdate();
			}
		}
	}
	
	/*
	 * reset spreader information to return state with location blank
	 */
	public void returnSpreader(int number) {
		if(Spreaders.isEmpty()) {
			System.out.print("Array is empty");
		}
		for(int i = 0; i < Spreaders.size(); i++ ) {
			if(number == Spreaders.get(i).getNumber()) {
				// If customer exists in database
				if(customerID == 0) {
					Spreaders.get(i).setCustomerID(customerID);
				}
				Spreaders.get(i).setdate();
				return;
			}
		}
		System.out.print("Spreader Not Found");
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
