package capstoneMainFrame;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
	public void addOrder(int priority) {
		Order sort = new Order(priority);
		for(int i = 0; i < Orders.size(); i++ ) {
			if(sort.getPriority() >= Orders.get(i).getPriority()) {
				Orders.add(i,sort);
				break;
			}
		}
	}
	
	public void updatePage(JLabel currpage, JLabel maxpage, JLabel lbnumber_0, JLabel lbnumber_1, JLabel lbnumber_2, JLabel lbnumber_3, JLabel lbnumber_4, JLabel lbnumber_5, JLabel lbnumber_6, JLabel lbnumber_7, JLabel lbnumber_8, JLabel lbnumber_9, JLabel lbcustomer_0, JLabel lbcustomer_1, JLabel lbcustomer_2, JLabel lbcustomer_3, JLabel lbcustomer_4, JLabel lbcustomer_5, JLabel lbcustomer_6, JLabel lbcustomer_7, JLabel lbcustomer_8, JLabel lbcustomer_9, JLabel lbdate_0, JLabel lbdate_1, JLabel lbdate_2, JLabel lbdate_3, JLabel lbdate_4, JLabel lbdate_5, JLabel lbdate_6, JLabel lbdate_7, JLabel lbdate_8, JLabel lbdate_9) {
		// Page full
		if(Orders.size() / 10 > page) {
			lbnumber_0.setText(null);
			lbcustomer_0.setText(null);
			lbdate_0.setText(null);
			lbnumber_1.setText(null);
			lbcustomer_1.setText(null);
			lbdate_1.setText(null);
			lbnumber_2.setText(null);
			lbcustomer_2.setText(null);
			lbdate_2.setText(null);
			lbnumber_3.setText(null);
			lbcustomer_3.setText(null);
			lbdate_3.setText(null);
			lbnumber_4.setText(null);
			lbcustomer_4.setText(null);
			lbdate_4.setText(null);
			lbnumber_5.setText(null);
			lbcustomer_5.setText(null);
			lbdate_5.setText(null);
			lbnumber_6.setText(null);
			lbcustomer_6.setText(null);
			lbdate_6.setText(null);
			lbnumber_7.setText(null);
			lbcustomer_7.setText(null);
			lbdate_7.setText(null);
			lbnumber_8.setText(null);
			lbcustomer_8.setText(null);
			lbdate_8.setText(null);
			lbnumber_9.setText(null);			
			lbcustomer_9.setText(null);
			lbdate_9.setText(null);
		}
		// Page partially full
		else if(Orders.size() / 10 == page) {
			if(Orders.size() % 10 >= 1) {
				lbnumber_0.setText(null);
				lbcustomer_0.setText(null);
				lbdate_0.setText(null);
			}
			else {
				lbnumber_0.setText("-");
				lbcustomer_0.setText("-");
				lbdate_0.setText("-");
			}
			if(Orders.size() % 10 >= 2) {
				lbnumber_1.setText(null);
				lbcustomer_1.setText(null);
				lbdate_1.setText(null);
			}
			else {
				lbnumber_1.setText("-");
				lbcustomer_1.setText("-");
				lbdate_1.setText("-");
			}
			if(Orders.size() % 10 >= 3) {
				lbnumber_2.setText(null);
				lbcustomer_2.setText(null);
				lbdate_2.setText(null);
			}
			else {
				lbnumber_2.setText("-");
				lbcustomer_2.setText("-");
				lbdate_2.setText("-");
			}
			if(Orders.size() % 10 >= 4) {
				lbnumber_3.setText(null);
				lbcustomer_3.setText(null);
				lbdate_3.setText(null);
			}
			else {
				lbnumber_3.setText("-");
				lbcustomer_3.setText("-");
				lbdate_3.setText("-");
			}
			if(Orders.size() % 10 >= 5) {
				lbnumber_4.setText(null);
				lbcustomer_4.setText(null);
				lbdate_4.setText(null);
			}
			else {
				lbnumber_4.setText("-");
				lbcustomer_4.setText("-");
				lbdate_4.setText("-");
			}
			if(Orders.size() % 10 >= 6) {
				lbnumber_5.setText(null);
				lbcustomer_5.setText(null);
				lbdate_5.setText(null);
			}
			else {
				lbnumber_5.setText("-");
				lbcustomer_5.setText("-");
				lbdate_5.setText("-");
			}
			if(Orders.size() % 10 >= 7) {
				lbnumber_6.setText(null);
				lbcustomer_6.setText(null);
				lbdate_6.setText(null);
			}
			else {
				lbnumber_6.setText("-");
				lbcustomer_6.setText("-");
				lbdate_6.setText("-");
			}
			if(Orders.size() % 10 >= 8) {
				lbnumber_7.setText(null);
				lbcustomer_7.setText(null);
				lbdate_7.setText(null);
			}
			else {
				lbnumber_7.setText("-");
				lbcustomer_7.setText("-");
				lbdate_7.setText("-");
			}
			if(Orders.size() % 10 == 9) {
				lbnumber_8.setText(null);
				lbcustomer_8.setText(null);
				lbdate_8.setText(null);
			}
			else {
				lbnumber_8.setText("-");
				lbcustomer_8.setText("-");
				lbdate_8.setText("-");
			}
		}
	}
	
	public void back(JPanel CurrPanel,JPanel NextPanel) {
		CurrPanel.hide();
		NextPanel.show();
	}

}
