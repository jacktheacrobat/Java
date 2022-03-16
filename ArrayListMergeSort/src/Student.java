/**
 * Creates Student obj which is characterized by  int roll#, String name, and  String address
 * @author jackp
 *
 */
public class Student {

	int rollno;
	String name;
	String address;
	
	/**
	 * Constructor to initiate values
	 * @param rollno Student Roll Number
	 * @param name Student Name
	 * @param address Student Address
	 */
	Student(int rollno, String name, String address){
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}
	
	/**
	 * Method to translate Student object variables into type String
	 * @return Student as String
	 */
	public String toString() {
		return Integer.toString(rollno) + " " + name + " " + address;
	}
	
	/**
	 * Gets the roll# of a Student obj
	 * @return rollno Roll Number of Student obj
	 */
	public int getRollno() {

		return this.rollno;
	}
	
	/**
	 * Gets the name of a Student obj
	 * @return name Name of Student obj
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the address of a Student obj
	 * @return address Address of Student obj
	 */
	public String getAddress() {
		return this.address;
	}
}
