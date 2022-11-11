package capstoneMainFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CapstoneMainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapstoneMainFrame window = new CapstoneMainFrame();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(171, 76, 93, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Export");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(100, 124, 236, 20);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnInventory = new JButton("Orders");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInventory.setBounds(100, 144, 236, 20);
		frame.getContentPane().add(btnInventory);
		
		JButton btnInventory_1 = new JButton("Inventory");
		btnInventory_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInventory_1.setBounds(100, 164, 236, 20);
		frame.getContentPane().add(btnInventory_1);
		
		JButton btnSpreaders = new JButton("Spreaders");
		btnSpreaders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSpreaders.setBounds(100, 184, 236, 20);
		frame.getContentPane().add(btnSpreaders);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCustomers.setBounds(100, 204, 236, 20);
		frame.getContentPane().add(btnCustomers);
		
		JButton btnEmployees = new JButton("Employees");
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEmployees.setBounds(100, 224, 236, 20);
		frame.getContentPane().add(btnEmployees);
	}
}
