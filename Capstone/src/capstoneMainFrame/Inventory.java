/**
 * 
 */
package capstoneMainFrame;

import javax.swing.JPanel;

/**
 * @author 19sky
 *
 */
public class Inventory {

	/**
	 * 
	 */
	public Inventory() {
		// TODO Auto-generated constructor stub
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
