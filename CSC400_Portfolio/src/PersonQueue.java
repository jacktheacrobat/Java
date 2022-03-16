import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class that stores Person objects in queue
 * Queue can be sorted based on last name or age (Quick sort)
 * @author jackp
 *
 */
public class PersonQueue {
	
	private Queue<Person> queue;
	
	PersonQueue(){
		this.queue = new LinkedList<>();
	}
	
	public void addPerson(Person newPerson) {
		this.queue.add(newPerson);
	}
	
	public int size() {
		return this.queue.size();
	}
	
	//Method to print personQueue
	public void printQueue() {
		for (Person person : this.queue) {
			System.out.println("First Name: \t" + person.getFirstName() + "\n" +
								"Last Name: \t" + person.getLastName() + "\n" +
								"Age: \t\t" + person.getAge() + "\n");
		}
	}

	/**
	 * Converts Queue into ArrayList for sorting with quickSort
	 * @param sortField 0=lastName, 1=age
	 */
	public void sortQueue(int sortField) {
		ArrayList<Person> personList = new ArrayList<>(this.queue);
		PersonQuickSort.quickSort(personList, 0, personList.size() - 1, sortField);
		this.queue = new LinkedList<>(personList);
	}
	
}
