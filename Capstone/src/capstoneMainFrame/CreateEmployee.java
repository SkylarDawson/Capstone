/**
 * 
 */
package capstoneMainFrame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 19sky
 *
 */
public class CreateEmployee {
	
	private String name;
	private int num;
	private String department;
	private int age;
	private double salary;
	

	/**
	 * 
	 */
	public CreateEmployee(String name, int num, String department, int age, double salary) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.department = department;
		this.age = age;
		this.salary = salary;
	}
	
	// function to have the ability to delete an employee
	
	public void deleteEmployee() {
		this.name = null;
		this.num = 0;
		this.department = null;
		this.age = 0;
		this.salary = 0.0;
	}
	
	// Getter functions to obtain general employee information
	
	public String getName() {
		return name;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getSalary() {
		return salary;
	}
	
	
	// List allows for ability to lookup a specific employee
	
	public class EmployeeDirectory {
		private static List<CreateEmployee> employees = new ArrayList<>();
		
		public static void addEmployee(CreateEmployee employee) {
			employees.add(employee);
		}
		
		// search by employee name
		
		public static CreateEmployee searchEmployeeName(String name) {
			for (CreateEmployee employee : employees) {
				if (employee.getName().equals(name)) {
					return employee;
				}
			}
			return null;
		}
		
		// search by employee number
		
		public static CreateEmployee searchEmployeeNum(int num) {
			for (CreateEmployee employee : employees) {
				if (employee.getNum() == num) {
					return employee;
				}
			}
			return null;
		}
		
	}

}
