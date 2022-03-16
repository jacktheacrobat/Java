import java.util.ArrayList;

/**
 * Class that sorts an ArrayList<Student> by rollno
 * @author jackp
 *
 */
public class MergeSort {

	//Method to Sort Students by rollno
	public static ArrayList<Student> mergeSort(ArrayList<Student> studentList) {
		
		// if total length of ArrayList = 1, return ArrayList
		// don't need to split array any further if size = 1
		if (studentList.size() == 1) {
			return studentList;
		}
		// when size > 1
		// split ArrayList in half, create two new ArrayLists (left and right)			
		ArrayList<Student> leftArray = new ArrayList<>(); 		//Create new ArrayList for left half of original list
		ArrayList<Student> rightArray = new ArrayList<>();		//Create new ArrayList for right half of original list
		
		// copy contents of original ArrayList to left and right
		for (int i = 0; i < studentList.size(); i++) {
			if (i < (studentList.size() / 2)) { 				//while at index < 1/2 total size, populate leftArray
				leftArray.add(studentList.get(i));
			}
			else {												//else, populate rightArray
				rightArray.add(studentList.get(i));
			}
		}
		// merge sort left and right halves
		// call mergeSort() to sort each arrayList
		leftArray = mergeSort(leftArray);						//Assign value of split/populate back to leftArray
		rightArray = mergeSort(rightArray);						//Assign value of split/populate back to rightArray
	
		// go through left and right halves from the front, populating a sorted array
		ArrayList<Student> sortedStudentList = new ArrayList<>();	
		sortedStudentList = merge(leftArray, rightArray);

		// return
		return sortedStudentList;
	}
	
	
	/**
	 * Compares rollno of Student objs from two ArrayList<Student> and outputs a sorted ArrayList<Student>
	 * @param leftArray ArrayList<Student> from first half of original ArrayList<Student>
	 * @param rightArray ArrayList<Student> from second half of original ArrayList<Student>
	 * @return sortedStudentList ArrayList<Student> containing Student objs sorted by rollno
	 */
	public static ArrayList<Student> merge(ArrayList<Student> leftArray, ArrayList<Student> rightArray){
		ArrayList<Student> sortedStudentList = new ArrayList<>();	//Create new ArrayList for sorted elements
		
		// initiate pointers to track position in ArrayLists
		int leftPtr = 0;	
		int rightPtr = 0;
		
		// while pointers are in range of ArrayLists
		while (leftPtr < leftArray.size() && rightPtr < rightArray.size()) {
			// if rollno of leftArray at pointer is < rollno of rightArray at pointer
			if (leftArray.get(leftPtr).getRollno() < rightArray.get(rightPtr).getRollno()) {
				// element from leftArray is added to sortedArray
				sortedStudentList.add(leftArray.get(leftPtr));
				// increment pointer to align with next element in arrayList
				leftPtr++;
			}
			else {
				// if rollno of rightArray at pointer is < rollno of leftArray at pointer
				// element from rightArray is added to sortedArray
				sortedStudentList.add(rightArray.get(rightPtr));
				// increment pointer to align with next element in arrayList
				rightPtr++;
			}
		}
		// if elements remain in leftArray after right has emptied, 
		// add remaining elements to sortedStudentList
		if (leftPtr < leftArray.size()) {
			for (int j = leftPtr; j < leftArray.size(); j++) {
				sortedStudentList.add(leftArray.get(j));
			}
		}
		// if elements remain in rightArray after left has emptied, 
		// add remaining elements to sortedStudentList
		else {
			for (int j = rightPtr; j < rightArray.size(); j++) {
				sortedStudentList.add(rightArray.get(j));
			}
		}
		// return
		return sortedStudentList;
	}
}