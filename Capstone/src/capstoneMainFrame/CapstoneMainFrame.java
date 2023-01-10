package capstoneMainFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class CapstoneMainFrame {

	private JFrame mainFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapstoneMainFrame window = new CapstoneMainFrame();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CapstoneMainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("Main");
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		mainFrame.getContentPane().add(mainPanel, "name_768171061063700");
		JPanel exportPanel = new JPanel();
		mainFrame.getContentPane().add(exportPanel, "name_768316222739400");
	
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{0, 236, 0, 0};
		gbl_mainPanel.rowHeights = new int[]{0, 39, 20, 20, 20, 20, 20, 20, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_mainPanel);
		
		JLabel lblNewLabel = new JLabel("FOS");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		mainPanel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnExport = new JButton("Export");
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.fill = GridBagConstraints.BOTH;
		gbc_btnExport.insets = new Insets(0, 0, 5, 5);
		gbc_btnExport.gridx = 1;
		gbc_btnExport.gridy = 2;
		mainPanel.add(btnExport, gbc_btnExport);
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.hide();
				exportPanel.show();
			}
		});
				
		JButton btnOrders = new JButton("Orders");
		GridBagConstraints gbc_btnOrders = new GridBagConstraints();
		gbc_btnOrders.fill = GridBagConstraints.BOTH;
		gbc_btnOrders.insets = new Insets(0, 0, 5, 5);
		gbc_btnOrders.gridx = 1;
		gbc_btnOrders.gridy = 3;
		mainPanel.add(btnOrders, gbc_btnOrders);
		
		JButton btnInventory = new JButton("Inventory");
		GridBagConstraints gbc_btnInventory = new GridBagConstraints();
		gbc_btnInventory.fill = GridBagConstraints.BOTH;
		gbc_btnInventory.insets = new Insets(0, 0, 5, 5);
		gbc_btnInventory.gridx = 1;
		gbc_btnInventory.gridy = 4;
		mainPanel.add(btnInventory, gbc_btnInventory);
		
		JButton btnCustomer = new JButton("Customers");
		GridBagConstraints gbc_btnCustomer = new GridBagConstraints();
		gbc_btnCustomer.fill = GridBagConstraints.BOTH;
		gbc_btnCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_btnCustomer.gridx = 1;
		gbc_btnCustomer.gridy = 6;
		mainPanel.add(btnCustomer, gbc_btnCustomer);						
		
		JButton btnEmployee = new JButton("Employees");
		GridBagConstraints gbc_btnEmployee = new GridBagConstraints();
		gbc_btnEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_btnEmployee.fill = GridBagConstraints.BOTH;
		gbc_btnEmployee.gridx = 1;
		gbc_btnEmployee.gridy = 7;
		mainPanel.add(btnEmployee, gbc_btnEmployee);
		
		JButton btnSpreader = new JButton("Spreaders");
		GridBagConstraints gbc_btnSpreader = new GridBagConstraints();
		gbc_btnSpreader.fill = GridBagConstraints.BOTH;
		gbc_btnSpreader.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpreader.gridx = 1;
		gbc_btnSpreader.gridy = 5;
		mainPanel.add(btnSpreader, gbc_btnSpreader);
		
		GridBagLayout gbl_exportPanel = new GridBagLayout();
		gbl_exportPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_exportPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_exportPanel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_exportPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		exportPanel.setLayout(gbl_exportPanel);
				
		Export export = new Export();
		
		JLabel lblExport = new JLabel("Export");
		lblExport.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblExport = new GridBagConstraints();
		gbc_lblExport.insets = new Insets(0, 0, 5, 5);
		gbc_lblExport.gridx = 1;
		gbc_lblExport.gridy = 1;
		exportPanel.add(lblExport, gbc_lblExport);
						
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				export.back(exportPanel,mainPanel);
				//exportPanel.hide();
				//mainPanel.show();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 2;
		exportPanel.add(btnBack, gbc_btnBack);
	}
}
