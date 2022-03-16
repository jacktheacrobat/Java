/**
 * Class with attributes of firstName, lastName, and age
 * @author jackp
 *
 */
public class Person {

	private String firstName;
	private String lastName;
	private int age;
	
	Person(String firstName, String lastName, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	/**
	 * Compares attributes of two Person objects, either lastName or age
	 * @param personB Second Person object to be compared
	 * @param sortField (0: compare on lastName, 1: age)
	 * @return boolean true if sort by age, false if sort by lastName
	 */
	public boolean isGreaterThan(Person personB, int sortField){
		int result = 0;
		
		switch (sortField) {
			case 0: result = this.getLastName().compareToIgnoreCase(personB.getLastName());
					break;
			case 1: result = this.getAge() - personB.getAge();
					break;
		}
		
		if(result > 0) {
			return true;
		}
		return false;
	}
}
