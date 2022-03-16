import java.util.Scanner;

public class Final_Project {

	public static void main (String[] args) {
		
			Scanner scan = new Scanner(System.in);
			PersonQueue personQueue = new PersonQueue();
	
			//Prompt user to add five people to the queue
			while (personQueue.size() < 5) {
				System.out.print("Please enter a first name: ");
				String firstName = scan.next();
				System.out.print("Please enter a last name: ");
				String lastName = scan.next();
				System.out.print("Please enter an age: ");
				int age = scan.nextInt();
				personQueue.addPerson(new Person(firstName, lastName, age));
				System.out.println("Person has been added.\n");
			}
			scan.close();
			
			//print out contents of current queue
			System.out.println("Unsorted Queue:");
			System.out.println("--------------------------");
			personQueue.printQueue();
			
			//Quick sort in descending order by lastName
			System.out.println("Queue Sorted by Last Name:");
			System.out.println("--------------------------");
			personQueue.sortQueue(0);
			personQueue.printQueue();

			//Quick sort in descending order by age
			System.out.println("Queue Sorted by Age:");
			System.out.println("--------------------------");
			personQueue.sortQueue(1);
			personQueue.printQueue();
		}
}
