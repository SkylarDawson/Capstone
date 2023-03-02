/**
 * 
 */
package capstoneMainFrame;

import javax.swing.JPanel;

/**
 * @author 19sky
 *
 */
public class Spreader {

	private Spread[] Spreaders = new Spread[10];
	
	/**
	 * 
	 */
	public Spreader() {
		// TODO Auto-generated constructor stub
	}
	
	public void newSpreader(int number, ) {
		
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
