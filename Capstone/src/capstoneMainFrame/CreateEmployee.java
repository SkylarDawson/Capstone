/**
 * 
 */
package capstoneMainFrame;

/**
 * @author 19sky
 *
 */
public class CreateEmployee {
	
	private String name;
	private String department;
	private int age;
	private double salary;
	

	/**
	 * 
	 */
	public CreateEmployee(String name, String department, int age, double salary) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.department = department;
		this.age = age;
		this.salary = salary;
	}
	
	// Getter functions to obtain general employee information
	
	public String getName() {
		return name;
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
	

}
