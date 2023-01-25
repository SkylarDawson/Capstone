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
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import net.miginfocom.swing.MigLayout;

public class CapstoneMainFrame {

	private JFrame mainFrame;
	private JTextField textFieldBinInput;
	private JTextField textFieldIngredientInput;
	private JTextField textFieldStorageInput;
	private JTextField textField;
	private JTextField textField_2;
	
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
		JPanel orderPanel = new JPanel();
		mainFrame.getContentPane().add(orderPanel, "name_244894356188800");
		JPanel spreaderPanel = new JPanel();
		mainFrame.getContentPane().add(spreaderPanel, "name_245549368124800");
	
		/**
		 * Frame Class Initialization
		 */
		Export export = new Export();
		Inventory inventory = new Inventory();
		Order order = new Order();
		Spreader spreader = new Spreader();
		
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
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnSpreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		layeredPane.setLayout(new MigLayout("", "[77px][6px][42px][6px][79px]", "[13px][13px][21px][13px][13px][13px][13px][13px][13px][19px][13px][13px]"));
		
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
		
		JList list = new JList();
		layeredPane.add(list, "cell 2 9,grow");
		
		textField_2 = new JTextField();
		layeredPane.add(textField_2, "cell 4 9,growx,aligny top");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("Cu. Density ____");
		layeredPane.add(lblNewLabel_19, "cell 0 10,alignx left,aligny top");
		
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
		 * 
		 */
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		orderPanel.setLayout(gridBagLayout);
		
		JLabel lblNewLabel_6 = new JLabel("Database Screen");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 1;
		orderPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.back(orderPanel, mainPanel);
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 2;
		orderPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		/**
		 * 
		 */
		GridBagLayout gridBagLayout_1 = new GridBagLayout();
		gridBagLayout_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		spreaderPanel.setLayout(gridBagLayout_1);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spreader.back(spreaderPanel, mainPanel);
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridx = 6;
		gbc_btnNewButton_3.gridy = 7;
		spreaderPanel.add(btnNewButton_3, gbc_btnNewButton_3);
	}
}
