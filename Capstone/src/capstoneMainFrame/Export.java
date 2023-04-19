package capstoneMainFrame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author 19sky
 *
 */
public class Export {

	private ArrayList<Order> Orders = new ArrayList<Order>();
	private int page = 0;
	
	/**
	 * 
	 */
	public Export() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Adds an order to the queue in order based on the priority.
	 * @param orderID the ID of the order from user input
	 * @param priority of the order based on the urgency from the user input
	 * @throws Exception is thrown when input error occurs
	 */
	public void addOrder(String orderID, String priority) throws Exception {
		Order sort = new Order(orderID, priority);
		if(Orders.size() == 0) {
			Orders.add(sort);
		}
		else {
			for(int i = 0; i <= Orders.size(); i++ ) {
				if(i == Orders.size()) {
					Orders.add(i, sort);
					break;
				}
				// < for 1 high priority > for 10 high priority
				else if(sort.getPriority() < Orders.get(i).getPriority()) {
					Orders.add(i, sort);
					break;
				}
				
			}
		}
	}
	
	/**
	 * Update the order displayed by selecting an order and displaying it on the appropriate labels
	 * @param index selected order index button
	 * @param lblcustomer label to display customer name
	 * @param lbldate label to display order date
	 * @param lbladdress label to display the address of delivery
	 * @param lbldelivered checkbox to display delivery status
	 * @param spreader textbox to display if customer has a spreader
	 * @param potashAmt label to display the amount of potash
	 * @param mapAmt label to display the amount of map
	 * @param amsAmt label to display the amount of ams
	 * @param ureaAmt label to display the amount of urea
	 * @param gypsumAmt label to display the amount of gypsum
	 * @param potashMix label to display the mixing label of potash
	 * @param mapMix label to display the mixing label of map
	 * @param amsMix label to display the mixing label of ams
	 * @param ureaMix label to display the mixing label of urea
	 * @param gypsumMix label to display the mixing label of gypsum
	 * @param employeeID label to display the employee's ID
	 */
	public void displayOrder(int index, JLabel lblcustomer, JLabel lbldate, JLabel lbladdress, JCheckBox lbldelivered, JTextField spreader, JLabel potashAmt, JLabel mapAmt, JLabel amsAmt, JLabel ureaAmt, JLabel gypsumAmt, JLabel potashMix, JLabel mapMix, JLabel amsMix, JLabel ureaMix, JLabel gypsumMix, JLabel NPK, JLabel employeeID) {
		Orders.get(page * 10 + index).display(lblcustomer, lbldate, lbladdress, lbldelivered, spreader, potashAmt, mapAmt, amsAmt, ureaAmt, gypsumAmt, potashMix, mapMix, amsMix, ureaMix, gypsumMix, NPK, employeeID);
	}
	
	/**
	 * Update the queue list by showing ten results at a time
	 * @param lbPageNumber display of current and total pages
	 * @param lbnumber_0 label for priority of order 0
	 * @param lbnumber_1 label for priority of order 1
	 * @param lbnumber_2 label for priority of order 2
	 * @param lbnumber_3 label for priority of order 3
	 * @param lbnumber_4 label for priority of order 4
	 * @param lbnumber_5 label for priority of order 5
	 * @param lbnumber_6 label for priority of order 6
	 * @param lbnumber_7 label for priority of order 7
	 * @param lbnumber_8 label for priority of order 8
	 * @param lbnumber_9 label for priority of order 9
	 * @param lbcustomer_0 label for customer of order 0
	 * @param lbcustomer_1 label for customer of order 1
	 * @param lbcustomer_2 label for customer of order 2
	 * @param lbcustomer_3 label for customer of order 3
	 * @param lbcustomer_4 label for customer of order 4
	 * @param lbcustomer_5 label for customer of order 5
	 * @param lbcustomer_6 label for customer of order 6
	 * @param lbcustomer_7 label for customer of order 7
	 * @param lbcustomer_8 label for customer of order 8
	 * @param lbcustomer_9 label for customer of order 9
	 */
	public void updatePage(JLabel lbPageNumber, JLabel lbnumber_0, JLabel lbnumber_1, JLabel lbnumber_2, JLabel lbnumber_3, JLabel lbnumber_4, JLabel lbnumber_5, JLabel lbnumber_6, JLabel lbnumber_7, JLabel lbnumber_8, JLabel lbnumber_9, JLabel lbcustomer_0, JLabel lbcustomer_1, JLabel lbcustomer_2, JLabel lbcustomer_3, JLabel lbcustomer_4, JLabel lbcustomer_5, JLabel lbcustomer_6, JLabel lbcustomer_7, JLabel lbcustomer_8, JLabel lbcustomer_9) {
		lbPageNumber.setText(String.format("%s/%d",page+1,((Orders.size()-1)/10)+1));
		// Page full
		if(Orders.size() / 10 > page) {
			lbnumber_0.setText(String.valueOf(Orders.get(page * 10 + 0).getPriority()));
			lbcustomer_0.setText(Orders.get(page * 10 + 0).getCustomerName());
			lbnumber_1.setText(String.valueOf(Orders.get(page * 10 + 1).getPriority()));
			lbcustomer_1.setText(Orders.get(page * 10 + 1).getCustomerName());
			lbnumber_2.setText(String.valueOf(Orders.get(page * 10 + 2).getPriority()));
			lbcustomer_2.setText(Orders.get(page * 10 + 2).getCustomerName());
			lbnumber_3.setText(String.valueOf(Orders.get(page * 10 + 3).getPriority()));
			lbcustomer_3.setText(Orders.get(page * 10 + 3).getCustomerName());
			lbnumber_4.setText(String.valueOf(Orders.get(page * 10 + 4).getPriority()));
			lbcustomer_4.setText(Orders.get(page * 10 + 4).getCustomerName());
			lbnumber_5.setText(String.valueOf(Orders.get(page * 10 + 5).getPriority()));
			lbcustomer_5.setText(Orders.get(page * 10 + 5).getCustomerName());
			lbnumber_6.setText(String.valueOf(Orders.get(page * 10 + 6).getPriority()));
			lbcustomer_6.setText(Orders.get(page * 10 + 6).getCustomerName());
			lbnumber_7.setText(String.valueOf(Orders.get(page * 10 + 7).getPriority()));
			lbcustomer_7.setText(Orders.get(page * 10 + 7).getCustomerName());
			lbnumber_8.setText(String.valueOf(Orders.get(page * 10 + 8).getPriority()));
			lbcustomer_8.setText(Orders.get(page * 10 + 8).getCustomerName());
			lbnumber_9.setText(String.valueOf(Orders.get(page * 10 + 9).getPriority()));			
			lbcustomer_9.setText(Orders.get(page * 10 + 9).getCustomerName());
		}
		// Page partially full
		else if(Orders.size() / 10 == page) {
			if(Orders.size() % 10 >= 1) {
				lbnumber_0.setText(String.valueOf(Orders.get(page * 10 + 0).getPriority()));
				lbcustomer_0.setText(Orders.get(page * 10 + 0).getCustomerName());
			}
			else {
				lbnumber_0.setText("-");
				lbcustomer_0.setText("-");
			}
			if(Orders.size() % 10 >= 2) {
				lbnumber_1.setText(String.valueOf(Orders.get(page * 10 + 1).getPriority()));
				lbcustomer_1.setText(Orders.get(page * 10 + 1).getCustomerName());
			}
			else {
				lbnumber_1.setText("-");
				lbcustomer_1.setText("-");
			}
			if(Orders.size() % 10 >= 3) {
				lbnumber_2.setText(String.valueOf(Orders.get(page * 10 + 2).getPriority()));
				lbcustomer_2.setText(Orders.get(page * 10 + 2).getCustomerName());
			}
			else {
				lbnumber_2.setText("-");
				lbcustomer_2.setText("-");
			}
			if(Orders.size() % 10 >= 4) {
				lbnumber_3.setText(String.valueOf(Orders.get(page * 10 + 3).getPriority()));
				lbcustomer_3.setText(Orders.get(page * 10 + 3).getCustomerName());
			}
			else {
				lbnumber_3.setText("-");
				lbcustomer_3.setText("-");
			}
			if(Orders.size() % 10 >= 5) {
				lbnumber_4.setText(String.valueOf(Orders.get(page * 10 + 4).getPriority()));
				lbcustomer_4.setText(Orders.get(page * 10 + 4).getCustomerName());
			}
			else {
				lbnumber_4.setText("-");
				lbcustomer_4.setText("-");
			}
			if(Orders.size() % 10 >= 6) {
				lbnumber_5.setText(String.valueOf(Orders.get(page * 10 + 5).getPriority()));
				lbcustomer_5.setText(Orders.get(page * 10 + 5).getCustomerName());
			}
			else {
				lbnumber_5.setText("-");
				lbcustomer_5.setText("-");
			}
			if(Orders.size() % 10 >= 7) {
				lbnumber_6.setText(String.valueOf(Orders.get(page * 10 + 6).getPriority()));
				lbcustomer_6.setText(Orders.get(page * 10 + 6).getCustomerName());
			}
			else {
				lbnumber_6.setText("-");
				lbcustomer_6.setText("-");
			}
			if(Orders.size() % 10 >= 8) {
				lbnumber_7.setText(String.valueOf(Orders.get(page * 10 + 7).getPriority()));
				lbcustomer_7.setText(Orders.get(page * 10 + 7).getCustomerName());
			}
			else {
				lbnumber_7.setText("-");
				lbcustomer_7.setText("-");
			}
			if(Orders.size() % 10 == 9) {
				lbnumber_8.setText(String.valueOf(Orders.get(page * 10 + 8).getPriority()));
				lbcustomer_8.setText(Orders.get(page * 10 + 8).getCustomerName());
			}
			else {
				lbnumber_8.setText("-");
				lbcustomer_8.setText("-");
			}
			if(Orders.size() % 10 == 0 && Orders.size() != 0) {
				lbnumber_9.setText(String.valueOf(Orders.get(page * 10 + 9).getPriority()));
				lbcustomer_9.setText(Orders.get(page * 10 + 9).getCustomerName());
			}
			else {
				lbnumber_9.setText("-");
				lbcustomer_9.setText("-");
			}
		}
	}
	
	/**
	 * Reset all the labels to their initial state
	 * @param lblcustomer label to display customer name
	 * @param lbldate label to display order date
	 * @param lbladdress label to display the address of delivery
	 * @param lbldelivered checkbox to display delivery status
	 * @param spreader textbox to display if customer has a spreader
	 * @param potashAmt label to display the amount of potash
	 * @param mapAmt label to display the amount of map
	 * @param amsAmt label to display the amount of ams
	 * @param ureaAmt label to display the amount of urea
	 * @param gypsumAmt label to display the amount of gypsum
	 * @param potashMix label to display the mixing label of potash
	 * @param mapMix label to display the mixing label of map
	 * @param amsMix label to display the mixing label of ams
	 * @param ureaMix label to display the mixing label of urea
	 * @param gypsumMix label to display the mixing label of gypsum
	 * @param employeeID label to display the employee's ID
	 */
	public void reset(JLabel lblcustomer, JLabel lbldate, JLabel lbladdress, JCheckBox lbldelivered, JTextField spreader, JLabel potashAmt, JLabel mapAmt, JLabel amsAmt, JLabel ureaAmt, JLabel gypsumAmt, JLabel potashMix, JLabel mapMix, JLabel amsMix, JLabel ureaMix, JLabel gypsumMix, JLabel NPK, JLabel employeeID) {
		lblcustomer.setText("Customer");
		lbldate.setText("Date");
		lbladdress.setText("Address");
		lbldelivered.setSelected(false);
		spreader.setText("");
		potashAmt.setText("-");
		mapAmt.setText("-");
		amsAmt.setText("-");
		ureaAmt.setText("-");
		gypsumAmt.setText("-");
		potashMix.setText("-");
		mapMix.setText("-");
		amsMix.setText("-");
		ureaMix.setText("-");
		gypsumMix.setText("-");
		NPK.setText("0 - 0 - 0 - 0s");
		employeeID.setText("-");
	}
	
	/**
	 * Get order from selected index
	 * @param selectedOrder order selected from page
	 * @return order given the order index selected and the displayed order
	 */
	public Order getOrder(int selectedOrder) {
		return Orders.get((page * 10) + selectedOrder);
	}
	
	/**
	 * Updates the database to complete order and remove from queue
	 * @param selectedOrder order selected from page
	 */
	public void completeOrder(int selectedOrder) {
		Orders.get((page * 10) + selectedOrder).completeOrder();;
		Orders.remove((page * 10) + selectedOrder);
	}
	
	/**
	 * Remove the selected
	 * @param selectedOrder order selected from page
	 */
	public void delete(int selectedOrder) {
		Orders.remove((page * 10) + selectedOrder);
	}
	
	/**
	 * Add 1 to the page number if avaiable
	 */
	public void forward() {
		if((page + 1) < ((Orders.size()-1) / 10 + 1)) page++;
	}
	
	/**
	 * Return to previous page
	 */
	public void backward() {
		if(page > 0) page--;
	}
	
	/**
	 * Hide current panel and show next
	 * @param CurrPanel current displayed panel
	 * @param NextPanel next panel to display
	 */
	public void back(JPanel CurrPanel,JPanel NextPanel) {
		CurrPanel.hide();
		NextPanel.show();
	}

}
