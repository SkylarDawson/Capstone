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
import javax.swing.JScrollBar;
import javax.swing.Box;
import javax.swing.JTextField;

public class CapstoneMainFrame {

	private JFrame mainFrame;
	private JTextField textFieldBinInput;
	private JTextField textFieldIngredientInput;
	private JTextField textFieldStorageInput;
	
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
		/**
		 * Main frame initialization
		 * All actions will start from this frame and operate other panels by showing and calling functions from a class for each panel.
		 */
		mainFrame = new JFrame();
		mainFrame.setTitle("Main");
		mainFrame.setBounds(100, 100, 562, 429);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new CardLayout(0, 0));
		
		/**
		 * Initialization of JPanels
		 * Main Panel - 
		 * Export Panel - 
		 * Inventory Panel - 
		 * Order Panel - 
		 * Create Order Panel - 
		 * Create Customer Panel - 
		 * Employee Panel - 
		 * Create Employee Panel - 
		 * Spreader Panel - 
		 */
		JPanel mainPanel = new JPanel();
		mainFrame.getContentPane().add(mainPanel, "name_768171061063700");
		JPanel exportPanel = new JPanel();
		mainFrame.getContentPane().add(exportPanel, "name_768316222739400");
		JPanel inventoryPanel = new JPanel();
		mainFrame.getContentPane().add(inventoryPanel, "name_164680866775500");
	
		/**
		 * Frame Class Initialization
		 */
		Export export = new Export();
		Inventory inventory = new Inventory();
		
		/**
		 * Main panel initialization
		 */
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
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.hide();
				inventoryPanel.show();
			}
		});
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
		
		/**
		 * Export panel initialization
		 */
		GridBagLayout gbl_exportPanel = new GridBagLayout();
		gbl_exportPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_exportPanel.rowHeights = new int[]{0, 25, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_exportPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_exportPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		exportPanel.setLayout(gbl_exportPanel);
		
		Box verticalBox = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBox.gridx = 3;
		gbc_verticalBox.gridy = 1;
		exportPanel.add(verticalBox, gbc_verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalBox.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Priority ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalBox.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Load");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalBox.add(lblNewLabel_3);
	
		
		
		JLabel lblExport = new JLabel("Export");
		lblExport.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblExport = new GridBagConstraints();
		gbc_lblExport.insets = new Insets(0, 0, 5, 5);
		gbc_lblExport.gridx = 1;
		gbc_lblExport.gridy = 5;
		exportPanel.add(lblExport, gbc_lblExport);
						
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				export.back(exportPanel,mainPanel);
				exportPanel.hide();
				mainPanel.show();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 6;
		exportPanel.add(btnBack, gbc_btnBack);
		
		JButton btnNewButton_1 = new JButton("New Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Box horizontalBox_1 = Box.createHorizontalBox();
				verticalBox.add(horizontalBox_1);
		
				JLabel lblNewLabel_4 = new JLabel("John Doe");
				horizontalBox_1.add(lblNewLabel_4);
		
				JLabel lblNewLabel_5 = new JLabel("1");
				horizontalBox_1.add(lblNewLabel_5);
		
				JButton btnNewButton = new JButton("");
				horizontalBox_1.add(btnNewButton);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 6;
		exportPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		/**
		 * Inventory panel initialization
		 */		
		GridBagLayout gbl_inventoryPanel = new GridBagLayout();
		gbl_inventoryPanel.columnWidths = new int[]{0, 0, 78, 0, 0, 0, 48, 0, 0, 0};
		gbl_inventoryPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_inventoryPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_inventoryPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		inventoryPanel.setLayout(gbl_inventoryPanel);
		
		// Temporary Label
		JLabel lblinventory = new JLabel("Inventory");
		lblinventory.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblinventory = new GridBagConstraints();
		gbc_lblinventory.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblinventory.insets = new Insets(0, 0, 5, 5);
		gbc_lblinventory.gridx = 2;
		gbc_lblinventory.gridy = 1;
		inventoryPanel.add(lblinventory, gbc_lblinventory);
		
		JLabel lblBin = new JLabel("Bin #");
		GridBagConstraints gbc_lblBin = new GridBagConstraints();
		gbc_lblBin.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_lblBin.insets = new Insets(0, 0, 5, 5);
		gbc_lblBin.gridx = 1;
		gbc_lblBin.gridy = 2;
		inventoryPanel.add(lblBin, gbc_lblBin);
		
		JLabel lblIngredient = new JLabel("Ingredient");
		lblIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIngredient = new GridBagConstraints();
		gbc_lblIngredient.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredient.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient.gridx = 2;
		gbc_lblIngredient.gridy = 2;
		inventoryPanel.add(lblIngredient, gbc_lblIngredient);
		
		JLabel lblStorage = new JLabel("Storage (lbs)");
		lblStorage.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStorage = new GridBagConstraints();
		gbc_lblStorage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorage.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorage.gridx = 3;
		gbc_lblStorage.gridy = 2;
		inventoryPanel.add(lblStorage, gbc_lblStorage);
		
		JLabel lblNewLabel_9 = new JLabel("Load");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 4;
		gbc_lblNewLabel_9.gridy = 2;
		inventoryPanel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel lblBin_1 = new JLabel("1");
		lblBin_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBin_1 = new GridBagConstraints();
		gbc_lblBin_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblBin_1.gridx = 1;
		gbc_lblBin_1.gridy = 3;
		inventoryPanel.add(lblBin_1, gbc_lblBin_1);
		
		JLabel lblIngredient_1 = new JLabel("-");
		lblIngredient_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIngredient_1 = new GridBagConstraints();
		gbc_lblIngredient_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredient_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient_1.gridx = 2;
		gbc_lblIngredient_1.gridy = 3;
		inventoryPanel.add(lblIngredient_1, gbc_lblIngredient_1);
		
		JLabel lblStorage_1 = new JLabel("-");
		lblStorage_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStorage_1 = new GridBagConstraints();
		gbc_lblStorage_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorage_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorage_1.gridx = 3;
		gbc_lblStorage_1.gridy = 3;
		inventoryPanel.add(lblStorage_1, gbc_lblStorage_1);
		
		JButton btnInvLoad_1 = new JButton("");
		GridBagConstraints gbc_btnInvLoad_1 = new GridBagConstraints();
		gbc_btnInvLoad_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvLoad_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvLoad_1.gridx = 4;
		gbc_btnInvLoad_1.gridy = 3;
		inventoryPanel.add(btnInvLoad_1, gbc_btnInvLoad_1);
		
		JLabel lblBinInput = new JLabel("Bin #");
		lblBinInput.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblBinInput = new GridBagConstraints();
		gbc_lblBinInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBinInput.insets = new Insets(0, 0, 5, 5);
		gbc_lblBinInput.gridx = 6;
		gbc_lblBinInput.gridy = 3;
		inventoryPanel.add(lblBinInput, gbc_lblBinInput);
		
		textFieldBinInput = new JTextField();
		GridBagConstraints gbc_textFieldBinInput = new GridBagConstraints();
		gbc_textFieldBinInput.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBinInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBinInput.gridx = 7;
		gbc_textFieldBinInput.gridy = 3;
		inventoryPanel.add(textFieldBinInput, gbc_textFieldBinInput);
		textFieldBinInput.setColumns(10);
		
		JLabel lblBin_2 = new JLabel("2");
		lblBin_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBin_2 = new GridBagConstraints();
		gbc_lblBin_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblBin_2.gridx = 1;
		gbc_lblBin_2.gridy = 4;
		inventoryPanel.add(lblBin_2, gbc_lblBin_2);
		
		JLabel lblIngredient_2 = new JLabel("-");
		lblIngredient_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIngredient_2 = new GridBagConstraints();
		gbc_lblIngredient_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredient_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient_2.gridx = 2;
		gbc_lblIngredient_2.gridy = 4;
		inventoryPanel.add(lblIngredient_2, gbc_lblIngredient_2);
		
		JLabel lblStorage_2 = new JLabel("-");
		lblStorage_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStorage_2 = new GridBagConstraints();
		gbc_lblStorage_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorage_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorage_2.gridx = 3;
		gbc_lblStorage_2.gridy = 4;
		inventoryPanel.add(lblStorage_2, gbc_lblStorage_2);
		
		JButton btnInvLoad_2 = new JButton("");
		GridBagConstraints gbc_btnInvLoad_2 = new GridBagConstraints();
		gbc_btnInvLoad_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvLoad_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvLoad_2.gridx = 4;
		gbc_btnInvLoad_2.gridy = 4;
		inventoryPanel.add(btnInvLoad_2, gbc_btnInvLoad_2);
		
		JLabel lblIngredientInput = new JLabel("Ingredient");
		lblIngredientInput.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblIngredientInput = new GridBagConstraints();
		gbc_lblIngredientInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredientInput.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredientInput.gridx = 6;
		gbc_lblIngredientInput.gridy = 4;
		inventoryPanel.add(lblIngredientInput, gbc_lblIngredientInput);
		
		textFieldIngredientInput = new JTextField();
		GridBagConstraints gbc_textFieldIngredientInput = new GridBagConstraints();
		gbc_textFieldIngredientInput.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIngredientInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIngredientInput.gridx = 7;
		gbc_textFieldIngredientInput.gridy = 4;
		inventoryPanel.add(textFieldIngredientInput, gbc_textFieldIngredientInput);
		textFieldIngredientInput.setColumns(10);
		
		JLabel lblBin_3 = new JLabel("3");
		lblBin_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBin_3 = new GridBagConstraints();
		gbc_lblBin_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblBin_3.gridx = 1;
		gbc_lblBin_3.gridy = 5;
		inventoryPanel.add(lblBin_3, gbc_lblBin_3);
		
		JLabel lblIngredient_3 = new JLabel("-");
		lblIngredient_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIngredient_3 = new GridBagConstraints();
		gbc_lblIngredient_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredient_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient_3.gridx = 2;
		gbc_lblIngredient_3.gridy = 5;
		inventoryPanel.add(lblIngredient_3, gbc_lblIngredient_3);
		
		JLabel lblStorage_3 = new JLabel("-");
		lblStorage_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStorage_3 = new GridBagConstraints();
		gbc_lblStorage_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorage_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorage_3.gridx = 3;
		gbc_lblStorage_3.gridy = 5;
		inventoryPanel.add(lblStorage_3, gbc_lblStorage_3);
		
		JButton btnInvLoad_3 = new JButton("");
		GridBagConstraints gbc_btnInvLoad_3 = new GridBagConstraints();
		gbc_btnInvLoad_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvLoad_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvLoad_3.gridx = 4;
		gbc_btnInvLoad_3.gridy = 5;
		inventoryPanel.add(btnInvLoad_3, gbc_btnInvLoad_3);
		
		JLabel lblStorageInput = new JLabel("Inbound (lbs)");
		lblStorageInput.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblStorageInput = new GridBagConstraints();
		gbc_lblStorageInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorageInput.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorageInput.gridx = 6;
		gbc_lblStorageInput.gridy = 5;
		inventoryPanel.add(lblStorageInput, gbc_lblStorageInput);
		
		textFieldStorageInput = new JTextField();
		GridBagConstraints gbc_textFieldStorageInput = new GridBagConstraints();
		gbc_textFieldStorageInput.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldStorageInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldStorageInput.gridx = 7;
		gbc_textFieldStorageInput.gridy = 5;
		inventoryPanel.add(textFieldStorageInput, gbc_textFieldStorageInput);
		textFieldStorageInput.setColumns(10);
		
		JLabel lblBin_4 = new JLabel("4");
		lblBin_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBin_4 = new GridBagConstraints();
		gbc_lblBin_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblBin_4.gridx = 1;
		gbc_lblBin_4.gridy = 6;
		inventoryPanel.add(lblBin_4, gbc_lblBin_4);
		
		JLabel lblIngredient_4 = new JLabel("-");
		lblIngredient_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIngredient_4 = new GridBagConstraints();
		gbc_lblIngredient_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredient_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient_4.gridx = 2;
		gbc_lblIngredient_4.gridy = 6;
		inventoryPanel.add(lblIngredient_4, gbc_lblIngredient_4);
		
		JLabel lblStorage_4 = new JLabel("-");
		lblStorage_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStorage_4 = new GridBagConstraints();
		gbc_lblStorage_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorage_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorage_4.gridx = 3;
		gbc_lblStorage_4.gridy = 6;
		inventoryPanel.add(lblStorage_4, gbc_lblStorage_4);
		
		JButton btnInvLoad_4 = new JButton("");
		GridBagConstraints gbc_btnInvLoad_4 = new GridBagConstraints();
		gbc_btnInvLoad_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvLoad_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvLoad_4.gridx = 4;
		gbc_btnInvLoad_4.gridy = 6;
		inventoryPanel.add(btnInvLoad_4, gbc_btnInvLoad_4);
		
		JButton btnSave = new JButton("Empty");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 7;
		gbc_btnSave.gridy = 6;
		inventoryPanel.add(btnSave, gbc_btnSave);
		
		JLabel lblBin_5 = new JLabel("5");
		lblBin_5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBin_5 = new GridBagConstraints();
		gbc_lblBin_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblBin_5.gridx = 1;
		gbc_lblBin_5.gridy = 7;
		inventoryPanel.add(lblBin_5, gbc_lblBin_5);
		
		JLabel lblIngredient_5 = new JLabel("-");
		lblIngredient_5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIngredient_5 = new GridBagConstraints();
		gbc_lblIngredient_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredient_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient_5.gridx = 2;
		gbc_lblIngredient_5.gridy = 7;
		inventoryPanel.add(lblIngredient_5, gbc_lblIngredient_5);
		
		JLabel lblStorage_5 = new JLabel("-");
		lblStorage_5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStorage_5 = new GridBagConstraints();
		gbc_lblStorage_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorage_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorage_5.gridx = 3;
		gbc_lblStorage_5.gridy = 7;
		inventoryPanel.add(lblStorage_5, gbc_lblStorage_5);
		
		JButton btnInvLoad_5 = new JButton("");
		GridBagConstraints gbc_btnInvLoad_5 = new GridBagConstraints();
		gbc_btnInvLoad_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvLoad_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvLoad_5.gridx = 4;
		gbc_btnInvLoad_5.gridy = 7;
		inventoryPanel.add(btnInvLoad_5, gbc_btnInvLoad_5);
		
		JButton btnEmpty = new JButton("Save");
		GridBagConstraints gbc_btnEmpty = new GridBagConstraints();
		gbc_btnEmpty.insets = new Insets(0, 0, 5, 5);
		gbc_btnEmpty.gridx = 7;
		gbc_btnEmpty.gridy = 7;
		inventoryPanel.add(btnEmpty, gbc_btnEmpty);
		
		JLabel lblBin_6 = new JLabel("6");
		lblBin_6.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBin_6 = new GridBagConstraints();
		gbc_lblBin_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblBin_6.gridx = 1;
		gbc_lblBin_6.gridy = 8;
		inventoryPanel.add(lblBin_6, gbc_lblBin_6);
		
		JLabel lblIngredient_6 = new JLabel("-");
		lblIngredient_6.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIngredient_6 = new GridBagConstraints();
		gbc_lblIngredient_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredient_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient_6.gridx = 2;
		gbc_lblIngredient_6.gridy = 8;
		inventoryPanel.add(lblIngredient_6, gbc_lblIngredient_6);
		
		JLabel lblStorage_6 = new JLabel("-");
		lblStorage_6.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStorage_6 = new GridBagConstraints();
		gbc_lblStorage_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorage_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorage_6.gridx = 3;
		gbc_lblStorage_6.gridy = 8;
		inventoryPanel.add(lblStorage_6, gbc_lblStorage_6);
		
		JButton btnInvLoad_6 = new JButton("");
		GridBagConstraints gbc_btnInvLoad_6 = new GridBagConstraints();
		gbc_btnInvLoad_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvLoad_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvLoad_6.gridx = 4;
		gbc_btnInvLoad_6.gridy = 8;
		inventoryPanel.add(btnInvLoad_6, gbc_btnInvLoad_6);
		
		JLabel lblBin_7 = new JLabel("7");
		lblBin_7.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBin_7 = new GridBagConstraints();
		gbc_lblBin_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblBin_7.gridx = 1;
		gbc_lblBin_7.gridy = 9;
		inventoryPanel.add(lblBin_7, gbc_lblBin_7);
		
		JLabel lblIngredient_7 = new JLabel("-");
		lblIngredient_7.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIngredient_7 = new GridBagConstraints();
		gbc_lblIngredient_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredient_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient_7.gridx = 2;
		gbc_lblIngredient_7.gridy = 9;
		inventoryPanel.add(lblIngredient_7, gbc_lblIngredient_7);
		
		JLabel lblStorage_7 = new JLabel("-");
		lblStorage_7.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStorage_7 = new GridBagConstraints();
		gbc_lblStorage_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorage_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorage_7.gridx = 3;
		gbc_lblStorage_7.gridy = 9;
		inventoryPanel.add(lblStorage_7, gbc_lblStorage_7);
		
		JButton btnInvLoad_7 = new JButton("");
		GridBagConstraints gbc_btnInvLoad_7 = new GridBagConstraints();
		gbc_btnInvLoad_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvLoad_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvLoad_7.gridx = 4;
		gbc_btnInvLoad_7.gridy = 9;
		inventoryPanel.add(btnInvLoad_7, gbc_btnInvLoad_7);
		
		JLabel lblBin_8 = new JLabel("8");
		lblBin_8.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBin_8 = new GridBagConstraints();
		gbc_lblBin_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblBin_8.gridx = 1;
		gbc_lblBin_8.gridy = 10;
		inventoryPanel.add(lblBin_8, gbc_lblBin_8);
		
		JLabel lblIngredient_8 = new JLabel("-");
		lblIngredient_8.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIngredient_8 = new GridBagConstraints();
		gbc_lblIngredient_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredient_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient_8.gridx = 2;
		gbc_lblIngredient_8.gridy = 10;
		inventoryPanel.add(lblIngredient_8, gbc_lblIngredient_8);
		
		JLabel lblStorage_8 = new JLabel("-");
		lblStorage_8.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStorage_8 = new GridBagConstraints();
		gbc_lblStorage_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorage_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorage_8.gridx = 3;
		gbc_lblStorage_8.gridy = 10;
		inventoryPanel.add(lblStorage_8, gbc_lblStorage_8);
		
		JButton btnInvLoad_8 = new JButton("");
		GridBagConstraints gbc_btnInvLoad_8 = new GridBagConstraints();
		gbc_btnInvLoad_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvLoad_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvLoad_8.gridx = 4;
		gbc_btnInvLoad_8.gridy = 10;
		inventoryPanel.add(btnInvLoad_8, gbc_btnInvLoad_8);
		
		JLabel lblBin_9 = new JLabel("9");
		lblBin_9.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBin_9 = new GridBagConstraints();
		gbc_lblBin_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblBin_9.gridx = 1;
		gbc_lblBin_9.gridy = 11;
		inventoryPanel.add(lblBin_9, gbc_lblBin_9);
		
		JLabel lblIngredient_9 = new JLabel("-");
		lblIngredient_9.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIngredient_9 = new GridBagConstraints();
		gbc_lblIngredient_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredient_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient_9.gridx = 2;
		gbc_lblIngredient_9.gridy = 11;
		inventoryPanel.add(lblIngredient_9, gbc_lblIngredient_9);
		
		JLabel lblStorage_9 = new JLabel("-");
		lblStorage_9.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStorage_9 = new GridBagConstraints();
		gbc_lblStorage_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorage_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorage_9.gridx = 3;
		gbc_lblStorage_9.gridy = 11;
		inventoryPanel.add(lblStorage_9, gbc_lblStorage_9);
		
		JButton btnInvLoad_9 = new JButton("");
		GridBagConstraints gbc_btnInvLoad_9 = new GridBagConstraints();
		gbc_btnInvLoad_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvLoad_9.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvLoad_9.gridx = 4;
		gbc_btnInvLoad_9.gridy = 11;
		inventoryPanel.add(btnInvLoad_9, gbc_btnInvLoad_9);
		
		JLabel lblBin_10 = new JLabel("10");
		lblBin_10.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBin_10 = new GridBagConstraints();
		gbc_lblBin_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblBin_10.gridx = 1;
		gbc_lblBin_10.gridy = 12;
		inventoryPanel.add(lblBin_10, gbc_lblBin_10);
		
		JLabel lblIngredient_10 = new JLabel("-");
		lblIngredient_10.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIngredient_10 = new GridBagConstraints();
		gbc_lblIngredient_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngredient_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient_10.gridx = 2;
		gbc_lblIngredient_10.gridy = 12;
		inventoryPanel.add(lblIngredient_10, gbc_lblIngredient_10);
		
		JLabel lblStorage_10 = new JLabel("-");
		lblStorage_10.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStorage_10 = new GridBagConstraints();
		gbc_lblStorage_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStorage_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorage_10.gridx = 3;
		gbc_lblStorage_10.gridy = 12;
		inventoryPanel.add(lblStorage_10, gbc_lblStorage_10);
		
		JButton btnInvLoad_10 = new JButton("");
		GridBagConstraints gbc_btnInvLoad_10 = new GridBagConstraints();
		gbc_btnInvLoad_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvLoad_10.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvLoad_10.gridx = 4;
		gbc_btnInvLoad_10.gridy = 12;
		inventoryPanel.add(btnInvLoad_10, gbc_btnInvLoad_10);
		
		// Temporary Back button
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventory.back(inventoryPanel,mainPanel);
			}
		});
		GridBagConstraints gbc_btnBack_1 = new GridBagConstraints();
		gbc_btnBack_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBack_1.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_btnBack_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack_1.gridx = 7;
		gbc_btnBack_1.gridy = 13;
		inventoryPanel.add(btnBack_1, gbc_btnBack_1);
	}
}
