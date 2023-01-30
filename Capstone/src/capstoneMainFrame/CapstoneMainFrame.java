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

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JList;
//import net.miginfocom.swing.MigLayout;


import javax.swing.JTable;

public class CapstoneMainFrame {

	private JFrame mainFrame;
	private JTextField textFieldBinInput;
	private JTextField textFieldIngredientInput;
	private JTextField textFieldStorageInput;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textFieldCreateCustomerID;
	private JTextField textFieldCreateCustomerFirst;
	private JTextField textFieldCreateCustomerLast;
	private JTextField textFieldPhone;
	private JTextField textFieldCreateCustomerAddress;
	private JTextField textFieldCreateCustomerEmail;
	private JTextField textField_9;
	private JTextField textFieldCreateEmployeeID;
	private JTextField textFieldCreateEmployeeFirst;
	private JTextField textFieldCreateEmployeeLast;
	private JTextField textFieldCreateEmployeePhone;
	private JTextField textFieldCreateEmployeeTitle;
	private JTextField textFieldPotash;
	private JTextField textFieldMAP;
	private JTextField textFieldAMS;
	private JTextField textFieldUrea;
	private JTextField textFieldGypsum;
	private JTextField textFieldCreateAdditional;
	private JTextField textFieldCustomer;
	private JTextField textFieldPriority;
	private JTextField orderHistoryOrderIDField;
	private JTextField orderHistoryOrderDateField;
	private JTextField orderHistoryFirstNameField;
	private JTextField orderHistoryLastNameField;
	private JTable orderHistoryTable;
	private JTextField customerLookupCustomerIDField;
	private JTextField customerLookupCustomerFirstNameField;
	private JTextField customerLookupLastNameField;
	private JTextField customerLookupPhoneNumberField;
	private JTable customerLookupTable;
	private JPanel previousPanel;
	
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
	 * Previous panel setters and getters
	 */	
	public void setPrevious(JPanel previous) {
		previousPanel = previous;
	}
	public JPanel getPrevious() {
		return previousPanel;
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
		mainFrame.setBounds(100, 100, 646, 472);
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
		JPanel orderPanel = new JPanel();
		mainFrame.getContentPane().add(orderPanel, "name_244894356188800");
		JPanel spreaderPanel = new JPanel();
		mainFrame.getContentPane().add(spreaderPanel, "name_245549368124800");
		JPanel customerPanel = new JPanel();
		mainFrame.getContentPane().add(customerPanel, "name_91413918142900");
		JPanel employeePanel = new JPanel();
		mainFrame.getContentPane().add(employeePanel, "name_92591373722400");
		JPanel createCustomerPanel = new JPanel();
		mainFrame.getContentPane().add(createCustomerPanel, "name_93463575990800");
		JPanel createEmployeePanel = new JPanel();
		mainFrame.getContentPane().add(createEmployeePanel, "name_94212916989400");
		JPanel createOrderPanel = new JPanel();
		mainFrame.getContentPane().add(createOrderPanel, "name_95035194878900");
		
		
		/**
		 * Frame Class Initialization
		 */
		Export export = new Export();
		Inventory inventory = new Inventory();
		OrderGUI order = new OrderGUI();
		Spreader spreader = new Spreader();
		CustomerGUI customerGUI = new CustomerGUI();
		EmployeeGUI employeeGUI = new EmployeeGUI();
		CreateOrder createOrder = new CreateOrder();
		CreateCustomer createCustomer = new CreateCustomer();
		CreateEmployee createEmployee = new CreateEmployee();
		

		
		
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
				setPrevious(mainPanel);
				mainPanel.hide();
				exportPanel.show();
				
			}
		});
				
		JButton btnOrders = new JButton("Orders");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPrevious(mainPanel);
				mainPanel.hide();
				orderPanel.show();
			}
		});
		GridBagConstraints gbc_btnOrders = new GridBagConstraints();
		gbc_btnOrders.fill = GridBagConstraints.BOTH;
		gbc_btnOrders.insets = new Insets(0, 0, 5, 5);
		gbc_btnOrders.gridx = 1;
		gbc_btnOrders.gridy = 3;
		mainPanel.add(btnOrders, gbc_btnOrders);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPrevious(mainPanel);
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
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPrevious(mainPanel);
				mainPanel.hide();
				customerPanel.show();
			}
		});
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
		btnSpreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPrevious(mainPanel);
				mainPanel.hide();
				spreaderPanel.show();
			}
		});
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
		gbl_exportPanel.columnWidths = new int[]{0, 0, 0, 115, 0, 0};
		gbl_exportPanel.rowHeights = new int[]{20, 100, 0, 0, 20, 0};
		gbl_exportPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_exportPanel.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		exportPanel.setLayout(gbl_exportPanel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.fill = GridBagConstraints.VERTICAL;
		gbc_verticalBox.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBox.gridx = 1;
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		verticalBox.add(scrollPane);
		
		Box verticalBoxQueue = Box.createVerticalBox();
		scrollPane.setViewportView(verticalBoxQueue);
		
		JLayeredPane layeredPane = new JLayeredPane();
		GridBagConstraints gbc_layeredPane = new GridBagConstraints();
		gbc_layeredPane.insets = new Insets(0, 0, 5, 5);
		gbc_layeredPane.fill = GridBagConstraints.BOTH;
		gbc_layeredPane.gridx = 3;
		gbc_layeredPane.gridy = 1;
		exportPanel.add(layeredPane, gbc_layeredPane);
		//layeredPane.setLayout(new MigLayout("", "[77px][6px][42px][6px][79px]", "[13px][13px][21px][13px][13px][13px][13px][13px][13px][19px][13px][13px]"));
		
		JLabel lblNewLabel_7 = new JLabel("Customer");
		layeredPane.add(lblNewLabel_7, "cell 0 0 3 1,growx,aligny top");
		
		JLabel lblNewLabel_8 = new JLabel("Date");
		layeredPane.add(lblNewLabel_8, "cell 4 0,alignx right,aligny top");
		
		JLabel lblNewLabel_7_1 = new JLabel("Address");
		layeredPane.add(lblNewLabel_7_1, "cell 0 1 5 1,growx,aligny top");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Delivered");
		layeredPane.add(chckbxNewCheckBox, "cell 0 2,growx,aligny top");
		
		JLabel lblNewLabel_11 = new JLabel("Spreader");
		layeredPane.add(lblNewLabel_11, "cell 2 2,alignx right,aligny center");
		
		textField = new JTextField();
		layeredPane.add(textField, "cell 4 2,growx,aligny center");
		textField.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Pounds");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblNewLabel_12, "cell 2 3,growx,aligny top");
		
		JLabel lblNewLabel_13 = new JLabel("Mixing");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblNewLabel_13, "cell 4 3,growx,aligny top");
		
		JLabel lblNewLabel_14 = new JLabel("Potash 60-0-0");
		layeredPane.add(lblNewLabel_14, "cell 0 4,growx,aligny top");
		
		JLabel lblPotashPound = new JLabel("-");
		lblPotashPound.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblPotashPound, "cell 2 4,growx,aligny top");
		
		JLabel lblPotashMix = new JLabel("-");
		lblPotashMix.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblPotashMix, "cell 4 4,growx,aligny top");
		
		JLabel lblNewLabel_15 = new JLabel("MAP 11-52-0");
		layeredPane.add(lblNewLabel_15, "cell 0 5,growx,aligny top");
		
		JLabel lblMAPPound = new JLabel("-");
		lblMAPPound.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblMAPPound, "cell 2 5,growx,aligny top");
		
		JLabel lblMAPMix = new JLabel("-");
		lblMAPMix.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblMAPMix, "cell 4 5,growx,aligny top");
		
		JLabel lblNewLabel_16 = new JLabel("AMS 21-0-0-24s");
		layeredPane.add(lblNewLabel_16, "cell 0 6,growx,aligny top");
		
		JLabel lblAMSPound = new JLabel("-");
		lblAMSPound.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblAMSPound, "cell 2 6,growx,aligny top");
		
		JLabel lblAMSMix = new JLabel("-");
		lblAMSMix.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblAMSMix, "cell 4 6,growx,aligny top");
		
		JLabel lblNewLabel_17 = new JLabel("Urea 0-0-46");
		layeredPane.add(lblNewLabel_17, "cell 0 7,growx,aligny top");
		
		JLabel lblUreaPound = new JLabel("-");
		lblUreaPound.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblUreaPound, "cell 2 7,growx,aligny top");
		
		JLabel lblUreaMix = new JLabel("-");
		lblUreaMix.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblUreaMix, "cell 4 7,growx,aligny top");
		
		JLabel lblNewLabel_18 = new JLabel("Gypsum");
		layeredPane.add(lblNewLabel_18, "cell 0 8,growx,aligny top");
		
		JLabel lblGypsumPound = new JLabel("-");
		lblGypsumPound.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblGypsumPound, "cell 2 8,growx,aligny top");
		
		JLabel lblGypsumMix = new JLabel("-");
		lblGypsumMix.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblGypsumMix, "cell 4 8,growx,aligny top");
		
		JLabel lblNewLabel_10 = new JLabel("Additional");
		layeredPane.add(lblNewLabel_10, "cell 0 9,alignx right,aligny center");
		
		JList listExportAdditional = new JList();
		layeredPane.add(listExportAdditional, "cell 2 9,grow");
		
		textField_2 = new JTextField();
		layeredPane.add(textField_2, "cell 4 9,growx,aligny top");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("Cu. Density ____");
		layeredPane.add(lblNewLabel_19, "cell 0 10,alignx left,aligny top");
		
		JLabel lblExportCost = new JLabel("Est. Cost:");
		layeredPane.add(lblExportCost, "cell 2 10");
		
		JLabel lblExportCalcCost = new JLabel("-");
		layeredPane.add(lblExportCalcCost, "cell 4 10");
		
		JLabel lblNewLabel_20 = new JLabel("Employee");
		layeredPane.add(lblNewLabel_20, "cell 0 11,growx,aligny top");
		
		JLabel lblNewLabel_21 = new JLabel("-");
		layeredPane.add(lblNewLabel_21, "cell 2 11 3 1,growx,aligny top");
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox_1 = new GridBagConstraints();
		gbc_horizontalBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalBox_1.gridx = 3;
		gbc_horizontalBox_1.gridy = 2;
		exportPanel.add(horizontalBox_1, gbc_horizontalBox_1);
		
		JButton btnNewButton_1 = new JButton("Create");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Box horizontalBox_1 = Box.createHorizontalBox();
				verticalBoxQueue.add(horizontalBox_1);
		
				JLabel lblNewLabel_4 = new JLabel("John Doe");
				horizontalBox_1.add(lblNewLabel_4);
		
				JLabel lblNewLabel_5 = new JLabel("1");
				horizontalBox_1.add(lblNewLabel_5);
		
				JButton btnNewButton = new JButton("");
				horizontalBox_1.add(btnNewButton);
				
				exportPanel.hide();
				exportPanel.show();
			}
		});
		horizontalBox_1.add(btnNewButton_1);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue);
		
		JButton btnNewButton = new JButton("Export");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		horizontalBox_1.add(btnNewButton);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox_2 = new GridBagConstraints();
		gbc_horizontalBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalBox_2.gridx = 3;
		gbc_horizontalBox_2.gridy = 3;
		exportPanel.add(horizontalBox_2, gbc_horizontalBox_2);
		
		JButton btnNewButton_4 = new JButton("Delete");
		horizontalBox_2.add(btnNewButton_4);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				export.back(exportPanel,mainPanel);
			}
		});
		horizontalBox_2.add(btnBack);
		
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
		
		/**
		 * Order History Panel
		 */
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 81, 103, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{27, 7, 35, 218, 94, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		orderPanel.setLayout(gridBagLayout);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderPanel.hide();
				getPrevious().show();
				setPrevious(orderPanel);
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Order ID");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 1;
		orderPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_29 = new JLabel("First Name");
		GridBagConstraints gbc_lblNewLabel_29 = new GridBagConstraints();
		gbc_lblNewLabel_29.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_29.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_29.gridx = 2;
		gbc_lblNewLabel_29.gridy = 1;
		orderPanel.add(lblNewLabel_29, gbc_lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("Last Name");
		GridBagConstraints gbc_lblNewLabel_30 = new GridBagConstraints();
		gbc_lblNewLabel_30.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_30.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_30.gridx = 3;
		gbc_lblNewLabel_30.gridy = 1;
		orderPanel.add(lblNewLabel_30, gbc_lblNewLabel_30);
		
		JLabel lblNewLabel_32 = new JLabel("Order Date");
		GridBagConstraints gbc_lblNewLabel_32 = new GridBagConstraints();
		gbc_lblNewLabel_32.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_32.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_32.gridx = 4;
		gbc_lblNewLabel_32.gridy = 1;
		orderPanel.add(lblNewLabel_32, gbc_lblNewLabel_32);
		
		orderHistoryOrderIDField = new JTextField();
		GridBagConstraints gbc_orderHistoryOrderIDField = new GridBagConstraints();
		gbc_orderHistoryOrderIDField.insets = new Insets(0, 0, 5, 5);
		gbc_orderHistoryOrderIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_orderHistoryOrderIDField.gridx = 1;
		gbc_orderHistoryOrderIDField.gridy = 2;
		orderPanel.add(orderHistoryOrderIDField, gbc_orderHistoryOrderIDField);
		orderHistoryOrderIDField.setColumns(10);
		
		orderHistoryFirstNameField = new JTextField();
		GridBagConstraints gbc_orderHistoryFirstNameField = new GridBagConstraints();
		gbc_orderHistoryFirstNameField.insets = new Insets(0, 0, 5, 5);
		gbc_orderHistoryFirstNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_orderHistoryFirstNameField.gridx = 2;
		gbc_orderHistoryFirstNameField.gridy = 2;
		orderPanel.add(orderHistoryFirstNameField, gbc_orderHistoryFirstNameField);
		orderHistoryFirstNameField.setColumns(10);
		
		orderHistoryLastNameField = new JTextField();
		GridBagConstraints gbc_orderHistoryLastNameField = new GridBagConstraints();
		gbc_orderHistoryLastNameField.insets = new Insets(0, 0, 5, 5);
		gbc_orderHistoryLastNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_orderHistoryLastNameField.gridx = 3;
		gbc_orderHistoryLastNameField.gridy = 2;
		orderPanel.add(orderHistoryLastNameField, gbc_orderHistoryLastNameField);
		orderHistoryLastNameField.setColumns(10);
		
		orderHistoryOrderDateField = new JTextField();
		GridBagConstraints gbc_orderHistoryOrderDateField = new GridBagConstraints();
		gbc_orderHistoryOrderDateField.insets = new Insets(0, 0, 5, 5);
		gbc_orderHistoryOrderDateField.fill = GridBagConstraints.HORIZONTAL;
		gbc_orderHistoryOrderDateField.gridx = 4;
		gbc_orderHistoryOrderDateField.gridy = 2;
		orderPanel.add(orderHistoryOrderDateField, gbc_orderHistoryOrderDateField);
		orderHistoryOrderDateField.setColumns(10);
		
		JScrollPane orderHistoryScroll = new JScrollPane();
		GridBagConstraints gbc_orderHistoryScroll = new GridBagConstraints();
		gbc_orderHistoryScroll.gridwidth = 5;
		gbc_orderHistoryScroll.insets = new Insets(0, 0, 5, 5);
		gbc_orderHistoryScroll.fill = GridBagConstraints.BOTH;
		gbc_orderHistoryScroll.gridx = 1;
		gbc_orderHistoryScroll.gridy = 3;
		orderPanel.add(orderHistoryScroll, gbc_orderHistoryScroll);
		
		orderHistoryTable = new JTable();
		orderHistoryScroll.setViewportView(orderHistoryTable);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 4;
		orderPanel.add(btnNewButton_2, gbc_btnNewButton_2);
				
		JButton orderHistorySearchButton = new JButton("Search");
		orderHistorySearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderGUI mySearch = new OrderGUI();
				
				// Create the table based on the returned results
				TableModel myModel = mySearch.execute(orderHistoryOrderIDField, orderHistoryFirstNameField, orderHistoryLastNameField, orderHistoryOrderDateField);
			    orderHistoryTable.setModel(myModel);
			    orderHistoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			    orderHistoryTable.setCellEditor(null);
			    orderHistoryTable.setBounds(37, 143, 397, 183);
			    
				
				orderPanel.setVisible(true);
			}
		});
		GridBagConstraints gbc_orderHistorySearchButton = new GridBagConstraints();
		gbc_orderHistorySearchButton.insets = new Insets(0, 0, 5, 5);
		gbc_orderHistorySearchButton.gridx = 5;
		gbc_orderHistorySearchButton.gridy = 2;
		orderPanel.add(orderHistorySearchButton, gbc_orderHistorySearchButton);
		

		
		/**
		 * 
		 */
		GridBagLayout gridBagLayout_1 = new GridBagLayout();
		gridBagLayout_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout_1.rowHeights = new int[]{0, 100, 0, 0, 0};
		gridBagLayout_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout_1.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		spreaderPanel.setLayout(gridBagLayout_1);
		
		Box verticalBox_1 = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox_1 = new GridBagConstraints();
		gbc_verticalBox_1.fill = GridBagConstraints.VERTICAL;
		gbc_verticalBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBox_1.gridx = 1;
		gbc_verticalBox_1.gridy = 1;
		spreaderPanel.add(verticalBox_1, gbc_verticalBox_1);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3);
		
		JLabel lblNewLabel_22 = new JLabel("Spreader");
		horizontalBox_3.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Customer");
		horizontalBox_3.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Date Taken");
		horizontalBox_3.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Load");
		horizontalBox_3.add(lblNewLabel_25);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		verticalBox_1.add(scrollPane_1);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		GridBagConstraints gbc_layeredPane_1 = new GridBagConstraints();
		gbc_layeredPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_layeredPane_1.fill = GridBagConstraints.BOTH;
		gbc_layeredPane_1.gridx = 3;
		gbc_layeredPane_1.gridy = 1;
		spreaderPanel.add(layeredPane_1, gbc_layeredPane_1);
	//	layeredPane_1.setLayout(new MigLayout("", "[60.00][]", "[][][]"));
		
		JLabel lblNewLabel_26 = new JLabel("Spreader #");
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane_1.add(lblNewLabel_26, "cell 0 0,growx");
		
		JLabel lblNewLabel_27 = new JLabel("Customer");
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane_1.add(lblNewLabel_27, "cell 1 0");
		
		textField_1 = new JTextField();
		layeredPane_1.add(textField_1, "cell 0 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_28 = new JLabel("-");
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane_1.add(lblNewLabel_28, "cell 1 1,growx");
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Returned");
		layeredPane_1.add(chckbxNewCheckBox_1, "cell 0 2");
		
		JButton btnNewButton_6 = new JButton("Save");
		layeredPane_1.add(btnNewButton_6, "cell 1 2");
		
		JButton btnNewButton_5 = new JButton("New Spreader");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 2;
		spreaderPanel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spreader.back(spreaderPanel, mainPanel);
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 3;
		gbc_btnNewButton_3.gridy = 2;
		spreaderPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		GridBagLayout gbl_customerPanel = new GridBagLayout();
		gbl_customerPanel.columnWidths = new int[]{40, 100, 100, 100, 100, 100, -62, 0};
		gbl_customerPanel.rowHeights = new int[]{57, 0, 47, 0, 0, 0, 0};
		gbl_customerPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_customerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		customerPanel.setLayout(gbl_customerPanel);
		
		JLabel lblNewLabel_33 = new JLabel("Customer ID");
		GridBagConstraints gbc_lblNewLabel_33 = new GridBagConstraints();
		gbc_lblNewLabel_33.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_33.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_33.gridx = 1;
		gbc_lblNewLabel_33.gridy = 1;
		customerPanel.add(lblNewLabel_33, gbc_lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("First Name");
		GridBagConstraints gbc_lblNewLabel_34 = new GridBagConstraints();
		gbc_lblNewLabel_34.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_34.gridx = 2;
		gbc_lblNewLabel_34.gridy = 1;
		customerPanel.add(lblNewLabel_34, gbc_lblNewLabel_34);
		
		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 3;
		gbc_lblLastName.gridy = 1;
		customerPanel.add(lblLastName, gbc_lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridx = 4;
		gbc_lblPhoneNumber.gridy = 1;
		customerPanel.add(lblPhoneNumber, gbc_lblPhoneNumber);
		
		customerLookupCustomerIDField = new JTextField();
		GridBagConstraints gbc_customerLookupCustomerIDField = new GridBagConstraints();
		gbc_customerLookupCustomerIDField.insets = new Insets(0, 0, 5, 5);
		gbc_customerLookupCustomerIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_customerLookupCustomerIDField.gridx = 1;
		gbc_customerLookupCustomerIDField.gridy = 2;
		customerPanel.add(customerLookupCustomerIDField, gbc_customerLookupCustomerIDField);
		customerLookupCustomerIDField.setColumns(10);
		
		customerLookupCustomerFirstNameField = new JTextField();
		GridBagConstraints gbc_customerLookupCustomerFirstNameField = new GridBagConstraints();
		gbc_customerLookupCustomerFirstNameField.insets = new Insets(0, 0, 5, 5);
		gbc_customerLookupCustomerFirstNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_customerLookupCustomerFirstNameField.gridx = 2;
		gbc_customerLookupCustomerFirstNameField.gridy = 2;
		customerPanel.add(customerLookupCustomerFirstNameField, gbc_customerLookupCustomerFirstNameField);
		customerLookupCustomerFirstNameField.setColumns(10);
		
		customerLookupLastNameField = new JTextField();
		GridBagConstraints gbc_customerLookupLastNameField = new GridBagConstraints();
		gbc_customerLookupLastNameField.insets = new Insets(0, 0, 5, 5);
		gbc_customerLookupLastNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_customerLookupLastNameField.gridx = 3;
		gbc_customerLookupLastNameField.gridy = 2;
		customerPanel.add(customerLookupLastNameField, gbc_customerLookupLastNameField);
		customerLookupLastNameField.setColumns(10);
		
		customerLookupPhoneNumberField = new JTextField();
		GridBagConstraints gbc_customerLookupPhoneNumberField = new GridBagConstraints();
		gbc_customerLookupPhoneNumberField.insets = new Insets(0, 0, 5, 5);
		gbc_customerLookupPhoneNumberField.fill = GridBagConstraints.HORIZONTAL;
		gbc_customerLookupPhoneNumberField.gridx = 4;
		gbc_customerLookupPhoneNumberField.gridy = 2;
		customerPanel.add(customerLookupPhoneNumberField, gbc_customerLookupPhoneNumberField);
		customerLookupPhoneNumberField.setColumns(10);
		
		JScrollPane customerPageScroll = new JScrollPane();
		customerPageScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_customerPageScroll = new GridBagConstraints();
		gbc_customerPageScroll.gridwidth = 5;
		gbc_customerPageScroll.insets = new Insets(0, 0, 5, 5);
		gbc_customerPageScroll.fill = GridBagConstraints.BOTH;
		gbc_customerPageScroll.gridx = 1;
		gbc_customerPageScroll.gridy = 3;
		customerPanel.add(customerPageScroll, gbc_customerPageScroll);
		
		customerLookupTable = new JTable();
		customerPageScroll.setViewportView(customerLookupTable);
		
		JButton customerLookupSearchButton = new JButton("Search");
		customerLookupSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerGUI mySearch = new CustomerGUI();
				
				// Create the table based on the returned results
				TableModel myModel = mySearch.execute(customerLookupCustomerIDField, customerLookupCustomerFirstNameField, customerLookupLastNameField, customerLookupPhoneNumberField);
			    customerLookupTable.setModel(myModel);
			    customerLookupTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			    customerLookupTable.setCellEditor(null);
			    customerLookupTable.setBounds(37, 143, 397, 183);
			    		
				customerPanel.setVisible(true);
			}
		});
		GridBagConstraints gbc_customerLookupSearchButton = new GridBagConstraints();
		gbc_customerLookupSearchButton.insets = new Insets(0, 0, 5, 5);
		gbc_customerLookupSearchButton.gridx = 5;
		gbc_customerLookupSearchButton.gridy = 2;
		customerPanel.add(customerLookupSearchButton, gbc_customerLookupSearchButton);
		
		
		Box horizontalBox_6 = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox_6 = new GridBagConstraints();
		gbc_horizontalBox_6.gridwidth = 5;
		gbc_horizontalBox_6.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalBox_6.gridx = 1;
		gbc_horizontalBox_6.gridy = 4;
		customerPanel.add(horizontalBox_6, gbc_horizontalBox_6);
		
		JButton btnNewButton_7 = new JButton("Create New");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPrevious(customerPanel);
				customerPanel.hide();
				createCustomerPanel.show();
			}
		});
		horizontalBox_6.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Delete");
		horizontalBox_6.add(btnNewButton_8);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_6.add(horizontalGlue_2);
		
		JButton btnNewButton_9 = new JButton("Back");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel newPrevious = customerPanel;
				customerPanel.hide();
				getPrevious().show();
				setPrevious(newPrevious);
				
			}
		});
		horizontalBox_6.add(btnNewButton_9);
		
		/*
		 * Employee Panel
		 */
		GridBagLayout gbl_employeePanel = new GridBagLayout();
		gbl_employeePanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_employeePanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_employeePanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_employeePanel.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		employeePanel.setLayout(gbl_employeePanel);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_3.gridx = 1;
		gbc_scrollPane_3.gridy = 1;
		employeePanel.add(scrollPane_3, gbc_scrollPane_3);
		
		Box horizontalBox_4_1 = Box.createHorizontalBox();
		scrollPane_3.setColumnHeaderView(horizontalBox_4_1);
		
		JLabel lblEmployeeID = new JLabel("Employee ID");
		horizontalBox_4_1.add(lblEmployeeID);
		
		JLabel lblEmployeeFirst = new JLabel("First");
		horizontalBox_4_1.add(lblEmployeeFirst);
		
		JLabel lblEmployeeLast = new JLabel("Last");
		horizontalBox_4_1.add(lblEmployeeLast);
		
		JLabel lblEmployeePhone = new JLabel("Phone");
		horizontalBox_4_1.add(lblEmployeePhone);
		
		JLabel lblEmployeeTitle = new JLabel("Title");
		horizontalBox_4_1.add(lblEmployeeTitle);
		
		Box horizontalBox_7 = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox_7 = new GridBagConstraints();
		gbc_horizontalBox_7.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalBox_7.gridx = 1;
		gbc_horizontalBox_7.gridy = 2;
		employeePanel.add(horizontalBox_7, gbc_horizontalBox_7);
		
		JButton btnNewButton_7_1 = new JButton("Create New");
		horizontalBox_7.add(btnNewButton_7_1);
		
		JButton btnNewButton_8_1 = new JButton("Delete");
		horizontalBox_7.add(btnNewButton_8_1);
		
		Component horizontalGlue_2_1 = Box.createHorizontalGlue();
		horizontalBox_7.add(horizontalGlue_2_1);
		
		JButton btnNewButton_9_1 = new JButton("Back");
		horizontalBox_7.add(btnNewButton_9_1);
		
		/*
		 * Customer Layout
		 */
		GridBagLayout gbl_createCustomerPanel = new GridBagLayout();
		gbl_createCustomerPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_createCustomerPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_createCustomerPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_createCustomerPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		createCustomerPanel.setLayout(gbl_createCustomerPanel);
		
		JLabel lblCreateCustomerID = new JLabel("Customer ID");
		lblCreateCustomerID.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCreateCustomerID = new GridBagConstraints();
		gbc_lblCreateCustomerID.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCreateCustomerID.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateCustomerID.gridx = 1;
		gbc_lblCreateCustomerID.gridy = 1;
		createCustomerPanel.add(lblCreateCustomerID, gbc_lblCreateCustomerID);
		
		textFieldCreateCustomerID = new JTextField();
		GridBagConstraints gbc_textFieldCreateCustomerID = new GridBagConstraints();
		gbc_textFieldCreateCustomerID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCreateCustomerID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCreateCustomerID.gridx = 2;
		gbc_textFieldCreateCustomerID.gridy = 1;
		createCustomerPanel.add(textFieldCreateCustomerID, gbc_textFieldCreateCustomerID);
		textFieldCreateCustomerID.setColumns(10);
		
		JLabel lblCreateCustomerFirst = new JLabel("First Name");
		lblCreateCustomerFirst.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCreateCustomerFirst = new GridBagConstraints();
		gbc_lblCreateCustomerFirst.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCreateCustomerFirst.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateCustomerFirst.gridx = 1;
		gbc_lblCreateCustomerFirst.gridy = 2;
		createCustomerPanel.add(lblCreateCustomerFirst, gbc_lblCreateCustomerFirst);
		
		textFieldCreateCustomerFirst = new JTextField();
		textFieldCreateCustomerFirst.setColumns(10);
		GridBagConstraints gbc_textFieldCreateCustomerFirst = new GridBagConstraints();
		gbc_textFieldCreateCustomerFirst.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCreateCustomerFirst.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCreateCustomerFirst.gridx = 2;
		gbc_textFieldCreateCustomerFirst.gridy = 2;
		createCustomerPanel.add(textFieldCreateCustomerFirst, gbc_textFieldCreateCustomerFirst);
		
		JLabel lblCreateCustomerLast = new JLabel("Last Name");
		lblCreateCustomerLast.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCreateCustomerLast = new GridBagConstraints();
		gbc_lblCreateCustomerLast.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCreateCustomerLast.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateCustomerLast.gridx = 1;
		gbc_lblCreateCustomerLast.gridy = 3;
		createCustomerPanel.add(lblCreateCustomerLast, gbc_lblCreateCustomerLast);
		
		textFieldCreateCustomerLast = new JTextField();
		textFieldCreateCustomerLast.setColumns(10);
		GridBagConstraints gbc_textFieldCreateCustomerLast = new GridBagConstraints();
		gbc_textFieldCreateCustomerLast.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCreateCustomerLast.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCreateCustomerLast.gridx = 2;
		gbc_textFieldCreateCustomerLast.gridy = 3;
		createCustomerPanel.add(textFieldCreateCustomerLast, gbc_textFieldCreateCustomerLast);
		
		JLabel lblCreateCustomerPhone = new JLabel("Phone Number");
		lblCreateCustomerPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCreateCustomerPhone = new GridBagConstraints();
		gbc_lblCreateCustomerPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCreateCustomerPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateCustomerPhone.gridx = 1;
		gbc_lblCreateCustomerPhone.gridy = 4;
		createCustomerPanel.add(lblCreateCustomerPhone, gbc_lblCreateCustomerPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		GridBagConstraints gbc_textFieldPhone = new GridBagConstraints();
		gbc_textFieldPhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPhone.gridx = 2;
		gbc_textFieldPhone.gridy = 4;
		createCustomerPanel.add(textFieldPhone, gbc_textFieldPhone);
		
		JLabel lblCreateCustomerAddress = new JLabel("Address");
		lblCreateCustomerAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCreateCustomerAddress = new GridBagConstraints();
		gbc_lblCreateCustomerAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCreateCustomerAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateCustomerAddress.gridx = 1;
		gbc_lblCreateCustomerAddress.gridy = 5;
		createCustomerPanel.add(lblCreateCustomerAddress, gbc_lblCreateCustomerAddress);
		
		textFieldCreateCustomerAddress = new JTextField();
		textFieldCreateCustomerAddress.setColumns(10);
		GridBagConstraints gbc_textFieldCreateCustomerAddress = new GridBagConstraints();
		gbc_textFieldCreateCustomerAddress.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCreateCustomerAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCreateCustomerAddress.gridx = 2;
		gbc_textFieldCreateCustomerAddress.gridy = 5;
		createCustomerPanel.add(textFieldCreateCustomerAddress, gbc_textFieldCreateCustomerAddress);
		
		JLabel lblCreateCustomerEmail = new JLabel("Email");
		lblCreateCustomerEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCreateCustomerEmail = new GridBagConstraints();
		gbc_lblCreateCustomerEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCreateCustomerEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateCustomerEmail.gridx = 1;
		gbc_lblCreateCustomerEmail.gridy = 6;
		createCustomerPanel.add(lblCreateCustomerEmail, gbc_lblCreateCustomerEmail);
		
		textFieldCreateCustomerEmail = new JTextField();
		textFieldCreateCustomerEmail.setColumns(10);
		GridBagConstraints gbc_textFieldCreateCustomerEmail = new GridBagConstraints();
		gbc_textFieldCreateCustomerEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCreateCustomerEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCreateCustomerEmail.gridx = 2;
		gbc_textFieldCreateCustomerEmail.gridy = 6;
		createCustomerPanel.add(textFieldCreateCustomerEmail, gbc_textFieldCreateCustomerEmail);
		
		JLabel lblCreateCustomerRep = new JLabel("Assigned Rep");
		lblCreateCustomerRep.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCreateCustomerRep = new GridBagConstraints();
		gbc_lblCreateCustomerRep.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCreateCustomerRep.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateCustomerRep.gridx = 1;
		gbc_lblCreateCustomerRep.gridy = 7;
		createCustomerPanel.add(lblCreateCustomerRep, gbc_lblCreateCustomerRep);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 2;
		gbc_textField_9.gridy = 7;
		createCustomerPanel.add(textField_9, gbc_textField_9);
		
		JButton btnNewButton_10 = new JButton("Clear");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCreateCustomerID.setText("");
				textFieldCreateCustomerFirst.setText("");
				textFieldCreateCustomerLast.setText("");
				textFieldCreateCustomerAddress.setText("");
				textFieldPhone.setText("");
				textFieldCreateCustomerEmail.setText("");
				textField_9.setText("");
			}
		});
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_10.gridx = 1;
		gbc_btnNewButton_10.gridy = 8;
		createCustomerPanel.add(btnNewButton_10, gbc_btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Create");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateCustomer newCustomer = new CreateCustomer();
				newCustomer.execute(textFieldCreateCustomerID, textFieldCreateCustomerFirst, textFieldCreateCustomerLast, textFieldCreateCustomerAddress, textFieldPhone, textFieldCreateCustomerEmail, textField_9);
			}
		});
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_11.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 2;
		gbc_btnNewButton_11.gridy = 8;
		createCustomerPanel.add(btnNewButton_11, gbc_btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Back");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCustomerPanel.hide();
				getPrevious().show();
				setPrevious(createCustomerPanel);
			}
		});
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_12.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_12.gridx = 2;
		gbc_btnNewButton_12.gridy = 9;
		createCustomerPanel.add(btnNewButton_12, gbc_btnNewButton_12);
		
		/*
		 * Employee Panel
		 */
		GridBagLayout gbl_createEmployeePanel = new GridBagLayout();
		gbl_createEmployeePanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_createEmployeePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_createEmployeePanel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_createEmployeePanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		createEmployeePanel.setLayout(gbl_createEmployeePanel);
		
		JLabel lblCreateEmployeeID = new JLabel("Employee ID");
		lblCreateEmployeeID.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCreateEmployeeID = new GridBagConstraints();
		gbc_lblCreateEmployeeID.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCreateEmployeeID.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateEmployeeID.gridx = 1;
		gbc_lblCreateEmployeeID.gridy = 1;
		createEmployeePanel.add(lblCreateEmployeeID, gbc_lblCreateEmployeeID);
		
		textFieldCreateEmployeeID = new JTextField();
		GridBagConstraints gbc_textFieldCreateEmployeeID = new GridBagConstraints();
		gbc_textFieldCreateEmployeeID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCreateEmployeeID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCreateEmployeeID.gridx = 2;
		gbc_textFieldCreateEmployeeID.gridy = 1;
		createEmployeePanel.add(textFieldCreateEmployeeID, gbc_textFieldCreateEmployeeID);
		textFieldCreateEmployeeID.setColumns(10);
		
		JLabel lblCreateEmployeeFirst = new JLabel("First Name");
		lblCreateEmployeeFirst.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCreateEmployeeFirst = new GridBagConstraints();
		gbc_lblCreateEmployeeFirst.anchor = GridBagConstraints.EAST;
		gbc_lblCreateEmployeeFirst.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateEmployeeFirst.gridx = 1;
		gbc_lblCreateEmployeeFirst.gridy = 2;
		createEmployeePanel.add(lblCreateEmployeeFirst, gbc_lblCreateEmployeeFirst);
		
		textFieldCreateEmployeeFirst = new JTextField();
		GridBagConstraints gbc_textFieldCreateEmployeeFirst = new GridBagConstraints();
		gbc_textFieldCreateEmployeeFirst.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCreateEmployeeFirst.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCreateEmployeeFirst.gridx = 2;
		gbc_textFieldCreateEmployeeFirst.gridy = 2;
		createEmployeePanel.add(textFieldCreateEmployeeFirst, gbc_textFieldCreateEmployeeFirst);
		textFieldCreateEmployeeFirst.setColumns(10);
		
		JLabel lblCreateEmployeeLast = new JLabel("Last Name");
		lblCreateEmployeeLast.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCreateEmployeeLast = new GridBagConstraints();
		gbc_lblCreateEmployeeLast.anchor = GridBagConstraints.EAST;
		gbc_lblCreateEmployeeLast.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateEmployeeLast.gridx = 1;
		gbc_lblCreateEmployeeLast.gridy = 3;
		createEmployeePanel.add(lblCreateEmployeeLast, gbc_lblCreateEmployeeLast);
		
		textFieldCreateEmployeeLast = new JTextField();
		GridBagConstraints gbc_textFieldCreateEmployeeLast = new GridBagConstraints();
		gbc_textFieldCreateEmployeeLast.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCreateEmployeeLast.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCreateEmployeeLast.gridx = 2;
		gbc_textFieldCreateEmployeeLast.gridy = 3;
		createEmployeePanel.add(textFieldCreateEmployeeLast, gbc_textFieldCreateEmployeeLast);
		textFieldCreateEmployeeLast.setColumns(10);
		
		JLabel lblCreateEmployeePhone = new JLabel("Phone");
		GridBagConstraints gbc_lblCreateEmployeePhone = new GridBagConstraints();
		gbc_lblCreateEmployeePhone.anchor = GridBagConstraints.EAST;
		gbc_lblCreateEmployeePhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateEmployeePhone.gridx = 1;
		gbc_lblCreateEmployeePhone.gridy = 4;
		createEmployeePanel.add(lblCreateEmployeePhone, gbc_lblCreateEmployeePhone);
		
		textFieldCreateEmployeePhone = new JTextField();
		GridBagConstraints gbc_textFieldCreateEmployeePhone = new GridBagConstraints();
		gbc_textFieldCreateEmployeePhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCreateEmployeePhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCreateEmployeePhone.gridx = 2;
		gbc_textFieldCreateEmployeePhone.gridy = 4;
		createEmployeePanel.add(textFieldCreateEmployeePhone, gbc_textFieldCreateEmployeePhone);
		textFieldCreateEmployeePhone.setColumns(10);
		
		JLabel lblCreateEmployeeTitle = new JLabel("Job Title");
		lblCreateEmployeeTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCreateEmployeeTitle = new GridBagConstraints();
		gbc_lblCreateEmployeeTitle.anchor = GridBagConstraints.EAST;
		gbc_lblCreateEmployeeTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateEmployeeTitle.gridx = 1;
		gbc_lblCreateEmployeeTitle.gridy = 5;
		createEmployeePanel.add(lblCreateEmployeeTitle, gbc_lblCreateEmployeeTitle);
		
		textFieldCreateEmployeeTitle = new JTextField();
		GridBagConstraints gbc_textFieldCreateEmployeeTitle = new GridBagConstraints();
		gbc_textFieldCreateEmployeeTitle.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCreateEmployeeTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCreateEmployeeTitle.gridx = 2;
		gbc_textFieldCreateEmployeeTitle.gridy = 5;
		createEmployeePanel.add(textFieldCreateEmployeeTitle, gbc_textFieldCreateEmployeeTitle);
		textFieldCreateEmployeeTitle.setColumns(10);
		
		JButton btnClearEmployee = new JButton("Clear");
		GridBagConstraints gbc_btnClearEmployee = new GridBagConstraints();
		gbc_btnClearEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_btnClearEmployee.gridx = 1;
		gbc_btnClearEmployee.gridy = 6;
		createEmployeePanel.add(btnClearEmployee, gbc_btnClearEmployee);
		
		JButton btnCreateEmployee = new JButton("Create");
		GridBagConstraints gbc_btnCreateEmployee = new GridBagConstraints();
		gbc_btnCreateEmployee.anchor = GridBagConstraints.EAST;
		gbc_btnCreateEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateEmployee.gridx = 2;
		gbc_btnCreateEmployee.gridy = 6;
		createEmployeePanel.add(btnCreateEmployee, gbc_btnCreateEmployee);
		
		JButton btnBack_9 = new JButton("Back");
		GridBagConstraints gbc_btnBack_9 = new GridBagConstraints();
		gbc_btnBack_9.anchor = GridBagConstraints.EAST;
		gbc_btnBack_9.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack_9.gridx = 2;
		gbc_btnBack_9.gridy = 7;
		createEmployeePanel.add(btnBack_9, gbc_btnBack_9);
		
		GridBagLayout gridBagLayout_2 = new GridBagLayout();
		gridBagLayout_2.columnWidths = new int[]{0, 303, 0, 0, 0, 0};
		gridBagLayout_2.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout_2.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		createOrderPanel.setLayout(gridBagLayout_2);
		
		JLayeredPane layeredPaneCreateOrder = new JLayeredPane();
		GridBagConstraints gbc_layeredPaneCreateOrder = new GridBagConstraints();
		gbc_layeredPaneCreateOrder.insets = new Insets(0, 0, 5, 5);
		gbc_layeredPaneCreateOrder.fill = GridBagConstraints.BOTH;
		gbc_layeredPaneCreateOrder.gridx = 1;
		gbc_layeredPaneCreateOrder.gridy = 1;
		createOrderPanel.add(layeredPaneCreateOrder, gbc_layeredPaneCreateOrder);
	//	layeredPaneCreateOrder.setLayout(new MigLayout("", "[][53.00][27.00][73.00][38.00][45.00,grow]", "[][][][][][][grow][][grow][]"));
		
		JLabel lblPounds = new JLabel("Pounds");
		lblPounds.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPaneCreateOrder.add(lblPounds, "cell 3 0 3 1,alignx center");
		
		JLabel lblCreatePotash = new JLabel("Potash 60-0-0");
		layeredPaneCreateOrder.add(lblCreatePotash, "flowy,cell 0 1 3 1");
		
		textFieldPotash = new JTextField();
		layeredPaneCreateOrder.add(textFieldPotash, "cell 3 1 3 1,growx");
		textFieldPotash.setColumns(10);
		
		JLabel lblCreateMAP = new JLabel("MAP 11-52-0");
		layeredPaneCreateOrder.add(lblCreateMAP, "cell 0 2 3 1");
		
		textFieldMAP = new JTextField();
		textFieldMAP.setColumns(10);
		layeredPaneCreateOrder.add(textFieldMAP, "cell 3 2 3 1,growx");
		
		JLabel lblCreateAMS = new JLabel("AMS 21-0-0-24s");
		layeredPaneCreateOrder.add(lblCreateAMS, "cell 0 3 3 1");
		
		textFieldAMS = new JTextField();
		textFieldAMS.setColumns(10);
		layeredPaneCreateOrder.add(textFieldAMS, "cell 3 3 3 1,growx");
		
		JLabel lblCreateUrea = new JLabel("Urea 0-0-46");
		layeredPaneCreateOrder.add(lblCreateUrea, "cell 0 4 3 1");
		
		textFieldUrea = new JTextField();
		textFieldUrea.setColumns(10);
		layeredPaneCreateOrder.add(textFieldUrea, "cell 3 4 3 1,growx");
		
		JLabel lblCreateGypsum = new JLabel("Gypsum");
		layeredPaneCreateOrder.add(lblCreateGypsum, "cell 0 5 3 1");
		
		textFieldGypsum = new JTextField();
		textFieldGypsum.setColumns(10);
		layeredPaneCreateOrder.add(textFieldGypsum, "cell 3 5 3 1,growx");
		
		JLabel lblAdditional = new JLabel("Additional");
		layeredPaneCreateOrder.add(lblAdditional, "cell 0 6 3 1");
		
		JList listCreateAdditional = new JList();
		layeredPaneCreateOrder.add(listCreateAdditional, "cell 3 6 2 1,grow");
		
		textFieldCreateAdditional = new JTextField();
		layeredPaneCreateOrder.add(textFieldCreateAdditional, "cell 5 6,growx");
		textFieldCreateAdditional.setColumns(10);
		
		JLabel lblNPK = new JLabel("NPK Value:");
		layeredPaneCreateOrder.add(lblNPK, "cell 0 7 3 1");
		
		JLabel lblCalcNPK = new JLabel("0-0-0-0s");
		layeredPaneCreateOrder.add(lblCalcNPK, "cell 3 7 3 1");
		
		JLabel lblCreateCost = new JLabel("Est. Cost:");
		layeredPaneCreateOrder.add(lblCreateCost, "cell 0 8 3 1");
		
		JLabel lblCreateCalcCost = new JLabel("-");
		layeredPaneCreateOrder.add(lblCreateCalcCost, "cell 3 8");
		
		JLabel lblCreateOrderEmployee = new JLabel("Employee");
		layeredPaneCreateOrder.add(lblCreateOrderEmployee, "cell 4 8");
		
		JList listEmployee = new JList();
		layeredPaneCreateOrder.add(listEmployee, "cell 5 8,grow");
		
		JButton btnCustomMixes = new JButton("Custom Mixes");
		layeredPaneCreateOrder.add(btnCustomMixes, "cell 0 9 2 1,alignx center");
		
		JButton btnOrderHistory = new JButton("Order History");
		layeredPaneCreateOrder.add(btnOrderHistory, "cell 2 9 2 1,alignx center");
		
		JButton btnCreateOrderClear = new JButton("Clear");
		layeredPaneCreateOrder.add(btnCreateOrderClear, "cell 4 9,alignx center");
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		GridBagConstraints gbc_layeredPane_2 = new GridBagConstraints();
		gbc_layeredPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_layeredPane_2.fill = GridBagConstraints.BOTH;
		gbc_layeredPane_2.gridx = 3;
		gbc_layeredPane_2.gridy = 1;
		createOrderPanel.add(layeredPane_2, gbc_layeredPane_2);
		//layeredPane_2.setLayout(new MigLayout("", "[][100px:n,grow][54.00][][][39.00][grow]", "[][][][][][][grow][][][]"));
		
		JLabel lblCustomer = new JLabel("Customer");
		layeredPane_2.add(lblCustomer, "cell 0 0");
		
		textFieldCustomer = new JTextField();
		layeredPane_2.add(textFieldCustomer, "cell 1 0,growx");
		textFieldCustomer.setColumns(10);
		
		JLabel lblNewLabel_31 = new JLabel("Address");
		layeredPane_2.add(lblNewLabel_31, "cell 0 1 3 1");
		
		JCheckBox chckbxCreateDelivery = new JCheckBox("Delivery");
		layeredPane_2.add(chckbxCreateDelivery, "cell 0 2");
		
		JCheckBox chckbxCreateSpreader = new JCheckBox("Spreader");
		layeredPane_2.add(chckbxCreateSpreader, "cell 0 3");
		
		JLabel lblPriority = new JLabel("Priority");
		layeredPane_2.add(lblPriority, "cell 0 4,alignx trailing");
		
		textFieldPriority = new JTextField();
		layeredPane_2.add(textFieldPriority, "cell 1 4,growx");
		textFieldPriority.setColumns(10);
		
		JButton btnDispatch = new JButton("Dispatch");
		layeredPane_2.add(btnDispatch, "cell 1 6,alignx right,aligny bottom");
		
		JButton btnBack_8 = new JButton("Back");
		btnBack_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createOrderPanel.hide();
				getPrevious().show();
				setPrevious(createOrderPanel);
			}
		});
		GridBagConstraints gbc_btnBack_8 = new GridBagConstraints();
		gbc_btnBack_8.anchor = GridBagConstraints.EAST;
		gbc_btnBack_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack_8.gridx = 3;
		gbc_btnBack_8.gridy = 2;
		createOrderPanel.add(btnBack_8, gbc_btnBack_8);
	}
}
