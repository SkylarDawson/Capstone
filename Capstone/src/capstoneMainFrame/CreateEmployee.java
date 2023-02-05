/**
 * 
 */
package capstoneMainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 19sky
 *
 */
public class CreateEmployee {
	
	private String firstName;
	private String lastName;
	private int employeeID;
	private String jobTitle;
	

	/**
	 * 
	 */
	public CreateEmployee(String firstName, String lastName, int employeeID, String jobTitle) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
	}
	
	
	private Connection connect() {
		
		// SQLite connection string - this string is the file path to the database
		String url = "jdbc:sqlite:C://sqlite/fertilizer.db";
		Connection conn = null;
		
		// Test to make sure that the database exists
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
	
	
	// function to have the ability to delete an employee
	
	public void deleteEmployee() {
		this.firstName = null;
		this.lastName = null;
		this.employeeID = 0;
		this.jobTitle = null;
	}
	
	// Getter functions to obtain general employee information
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	
	// List allows for ability to lookup a specific employee
	
	public class EmployeeDirectory {
		private static List<CreateEmployee> employees = new ArrayList<>();
		
		public static void addEmployee(CreateEmployee employee) {
			employees.add(employee);
		}
		
		// search by employee name
		
		public static CreateEmployee searchEmployeeName(String firstName, String lastName) {
			for (CreateEmployee employee : employees) {
				if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
					return employee;
				}
			}
			return null;
		}
		
		// search by employee number
		
		public static CreateEmployee searchEmployeeID(int employeeID) {
			for (CreateEmployee employee : employees) {
				if (employee.getEmployeeID() == employeeID) {
					return employee;
				}
			}
			return null;
		}
		
	}

} 
