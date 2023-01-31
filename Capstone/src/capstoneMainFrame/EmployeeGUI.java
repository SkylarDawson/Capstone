/**
 * 
 */
package capstoneMainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 19sky
 *
 */
public class EmployeeGUI {

	/**
	 * 
	 */
	public EmployeeGUI() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		String url = "";
		String username = "";
		String password = "";
		
		
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			String query = "SELECT * FROM employees";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			
			
			while (resultSet.next()) {
				int employeeID = resultSet.getInt("employeeID");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String jobTitle = resultSet.getString("jobTitle");
				System.out.println("Employee ID: " + employeeID + ", First Name: " + firstName +  ", Last Name: " + lastName + ", Job Title: " + jobTitle);
			}
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
	} 

}
