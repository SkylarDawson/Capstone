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

public class CapstoneMainFrame {

	private JFrame mainFrame;
	private ExportFrame export = new ExportFrame();
	
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
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{25, 236, 25, 0};
		gridBagLayout.rowHeights = new int[]{41, 39, 20, 20, 20, 20, 20, 20, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		mainFrame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				export.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("FOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		mainFrame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.fill = GridBagConstraints.BOTH;
		gbc_btnExport.insets = new Insets(0, 0, 5, 5);
		gbc_btnExport.gridx = 1;
		gbc_btnExport.gridy = 2;
		mainFrame.getContentPane().add(btnExport, gbc_btnExport);
		
		JButton btnOrders = new JButton("Orders");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnOrders = new GridBagConstraints();
		gbc_btnOrders.fill = GridBagConstraints.BOTH;
		gbc_btnOrders.insets = new Insets(0, 0, 5, 5);
		gbc_btnOrders.gridx = 1;
		gbc_btnOrders.gridy = 3;
		mainFrame.getContentPane().add(btnOrders, gbc_btnOrders);
		
		JButton btnCustomer = new JButton("Customers");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnSpreader = new JButton("Spreaders");
		btnSpreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnInventory = new GridBagConstraints();
		gbc_btnInventory.fill = GridBagConstraints.BOTH;
		gbc_btnInventory.insets = new Insets(0, 0, 5, 5);
		gbc_btnInventory.gridx = 1;
		gbc_btnInventory.gridy = 4;
		mainFrame.getContentPane().add(btnInventory, gbc_btnInventory);
		GridBagConstraints gbc_btnSpreader = new GridBagConstraints();
		gbc_btnSpreader.fill = GridBagConstraints.BOTH;
		gbc_btnSpreader.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpreader.gridx = 1;
		gbc_btnSpreader.gridy = 5;
		mainFrame.getContentPane().add(btnSpreader, gbc_btnSpreader);
		GridBagConstraints gbc_btnCustomer = new GridBagConstraints();
		gbc_btnCustomer.fill = GridBagConstraints.BOTH;
		gbc_btnCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_btnCustomer.gridx = 1;
		gbc_btnCustomer.gridy = 6;
		mainFrame.getContentPane().add(btnCustomer, gbc_btnCustomer);
		
		JButton btnEmployee = new JButton("Employees");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnEmployee = new GridBagConstraints();
		gbc_btnEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_btnEmployee.fill = GridBagConstraints.BOTH;
		gbc_btnEmployee.gridx = 1;
		gbc_btnEmployee.gridy = 7;
		mainFrame.getContentPane().add(btnEmployee, gbc_btnEmployee);
	}
}
