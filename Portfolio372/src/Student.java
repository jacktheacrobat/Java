/**
 * Student Object with String name, String address, Double GPA
 * @author jackp
 *
 */
public class Student {

	private String name;
	private String address;
	private Double GPA;
	
	/**
	 * Creates a Student object of String name, String address, and double GPA
	 * @param name Name of student
	 * @param address Address of student
	 * @param GPA Grade Point Average of student
	 */
	Student(String name, String address, Double GPA){
		this.name = name;
		this.address = address;
		this.GPA = GPA;
	}
	/**
	 * Gets the name of this student
	 * Need for alphabetical sorting
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Gets the address of this student
	 * @return address
	 */
	public String getAddress() {
		return this.address;
	}
	/**
	 * Gets the GPA of this student
	 * @return GPA
	 */
	public double getGPA() {
		return this.GPA;
	}
	/**
	 * Converts the student fields to String for easy printing
	 */
	public String toString() {
		return "Name: \t\t" + name + "\n" +
			   "Address: \t" + address + "\n" + 
			   "GPA: \t\t" + Double.toString(GPA) + "\n";
	}
}
