package capstoneMainFrame;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
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
	
	/*
	 * Update creation of orders to be pulled from database
	 * check if arraylist is empty
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
		
		// Debugging code
		System.out.println(String.format("Orders in Queue: %s", Orders.size()));
		System.out.println(String.format("Pages of Queue: %s", ((Orders.size() - 1) / 10) + 1));
	}
	
	// give label parameters
	public void displayOrder(int index, JLabel lblcustomer, JLabel lbldate, JLabel lbladdress, JCheckBox lbldelivered, JTextField spreader, JLabel potashAmt, JLabel mapAmt, JLabel amsAmt, JLabel ureaAmt, JLabel gypsumAmt, JLabel potashMix, JLabel mapMix, JLabel amsMix, JLabel ureaMix, JLabel gypsumMix, JLabel employeeID) {
		Orders.get(page * 10 + index).display(lblcustomer, lbldate, lbladdress, lbldelivered, spreader, potashAmt, mapAmt, amsAmt, ureaAmt, gypsumAmt, potashMix, mapMix, amsMix, ureaMix, gypsumMix, employeeID);
	}
	
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
		}
	}
	
	public void forward() {
		if((page + 1) < ((Orders.size()-1) / 10 + 1)) page++;
	}
	
	public void backward() {
		if(page > 0) page--;
	}
	
	public void back(JPanel CurrPanel,JPanel NextPanel) {
		CurrPanel.hide();
		NextPanel.show();
	}

}
