import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Creates a LinkedList<Student> from user input.
 * Unsorted List is then printed
 * List is then sorted and printed
 * List can be saved to a .txt file
 * @author jackp
 *
 */
public class StudentLinkedList {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		LinkedList<Student> studentList = new LinkedList<>();		//Initial list to be filled
		LinkedList<Student> sortedStudentList = new LinkedList<>();	//List after sorting

		
		//menu for adding students, keeps adding students while stillAdding
		boolean stillAdding = true;
		while (stillAdding) {
			System.out.println("Would you like to add a new Student? y/n");
			String input = scan.next();
			if (input.equals("y")) {
				System.out.println("Please enter the Student Name: ");
				//prevents scan.nextLine from skipping input
				scan.nextLine();									
				String name = scan.nextLine();
				System.out.println("Please enter the Student Address: ");
				String address = scan.nextLine();
				
				//Verify GPA Values are 0.0 < GPA <= 4.0
				boolean stillChecking = true;
				double GPA = 0;
				while (stillChecking) {
					System.out.println("Please enter the Student GPA: ");
					Double inputGPA = scan.nextDouble();
					if (inputGPA >= 0 && inputGPA <= 4.0) {
						GPA = inputGPA;
						stillChecking = false;
					}
					else {
						System.out.println("You entered an invalid value.");
					}
				}
				//all inputs are compiled into a Student obj and added to studentList
				studentList.add(new Student(name, address, GPA));
				System.out.println("New Student has been successfully added.");
			}
			//Stops adding students
			else if (input.equals("n")) {
				stillAdding = false;
			}
			
			else {
				System.out.println("Please try again: ");
			}
		}// end menu
		
		//print out unsorted studentList
		System.out.println("Unsorted Student List:\n" + 
						   "----------------------");
		printStudentList(studentList);
		
		//sort studentList by name (alphabetical a -> z)
		sortedStudentList = MergeSort.mergeSort(studentList);
		
		//print out sortedStudentList
		System.out.println("Sorted Student List:\n" + 
				   		   "----------------------");
		printStudentList(sortedStudentList);
		
		//Option to save list to .txt file
		System.out.println("Would you like to save this list? y/n ");
		String input = scan.next();
		if (input.equals("y")) {
			printListToFile(sortedStudentList);
			System.out.println("The file has been printed!");
		}
		else {
			return;
		}
		
		System.out.println("Thanks for using the program!");
	}// end main
	
	
	/**
	 * Prints out the student fields (name, address, gpa)
	 * @param studentList LinkedList<Student> to be printed
	 */
	public static void printStudentList(LinkedList<Student> studentList) {
		for (Student student : studentList) {
			System.out.println("Student Name: \t\t" + student.getName() + "\n" +
								"Student Address: \t" + student.getAddress() + "\n" +
								"Student GPA: \t\t" + student.getGPA() + "\n");
		}
	}
	/**
	 * Saves the list to a .txt file
	 * @param studentList LinkedList<Student> to be printed to .txt file
	 */
	public static void printListToFile(LinkedList<Student> studentList) {
	
		FileOutputStream fileStream;
		try {
			fileStream = new FileOutputStream("studentList.txt"); //name of file
			PrintWriter outFS = new PrintWriter(fileStream);

			outFS.print("Sorted Student List" + "\n" + 
					    "----------------------\n");
			for (Student student : studentList) {
				outFS.println(student.toString());
			}
			outFS.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
