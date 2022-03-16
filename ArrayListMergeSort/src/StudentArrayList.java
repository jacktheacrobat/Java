import java.util.ArrayList;
/**
 * Class that creates and populates an ArrayList<Student>
 * Prints out Unsorted List
 * Sorts List
 * Prints out Sorted List
 * @author jackp
 *
 */
public class StudentArrayList {
	
	public static void main(String[] args) {

		//Create an ArrayList of Students
		ArrayList<Student> studentList = new ArrayList<>();
		ArrayList<Student> sortedStudentList = new ArrayList<>();

		//Populate ArrayList
		studentList.add(new Student(321, "Jimmy", "123 Road rd"));
		studentList.add(new Student(543, "Mary", "234 Street st"));
		studentList.add(new Student(423, "Tim", "345 Court ct"));
		studentList.add(new Student(142, "Phillip", "456 Boul blvd"));
		studentList.add(new Student(654, "Donna", "567 High way"));
		studentList.add(new Student(324, "Clarence", "678 Circle cir"));
		studentList.add(new Student(364, "Elizabeth", "789 Add ress"));
		studentList.add(new Student(112, "Bob", "890 This place"));
		studentList.add(new Student(100, "Tessa", "910 That place"));
		studentList.add(new Student(745, "Tyler", "100 Round abt"));

		//Print ArrayList PreSort
		System.out.println("Unsorted ArrayList: " + "\n" +
							"--------------------------------------");
		
		printStudentList(studentList);
		
		//Sort ArrayList via MergeSort
		sortedStudentList = MergeSort.mergeSort(studentList);
		
		//Print Sorted ArrayList
		System.out.println("Sorted ArrayList: " + "\n" +
							"--------------------------------------");
		printStudentList(sortedStudentList);
		
	}

	/**
	 * Prints out an ArrayList<Student>
	 * @param studentList An ArrayList<Student>
	 */
	public static void printStudentList(ArrayList<Student> studentList) {
		for (Student student : studentList) {
			System.out.println("Student # " + student.getRollno() + "\n" +
								"Student name: " + student.getName() + "\n" +
								"Student address: " + student.getAddress() + "\n");
		}
	}
}


