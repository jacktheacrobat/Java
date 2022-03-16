import java.util.LinkedList;

/**
 * Class that sorts an LinkedList<Student> by name in alpebetical order (a -> z)
 * @author jackp
 *
 */
public class MergeSort {

	//Method to Sort Students by name
	public static LinkedList<Student> mergeSort(LinkedList<Student> studentList) {
		
		// if total length of LinkedList = 1, return LinkedList
		// don't need to split array any further if size = 1
		if (studentList.size() == 1) {
			return studentList;
		}
		// when size > 1
		// split LinkedList in half, create two new LinkedLists (left and right)			
		LinkedList<Student> leftList = new LinkedList<>(); 		//Create new LinkedList for left half of original list
		LinkedList<Student> rightList = new LinkedList<>();		//Create new LinkedList for right half of original list
		
		// copy contents of original LinkedList to left and right
		for (int i = 0; i < studentList.size(); i++) {
			if (i < (studentList.size() / 2)) { 				//while at index < 1/2 total size, populate leftList
				leftList.add(studentList.get(i));
			}
			else {												//else, populate rightList
				rightList.add(studentList.get(i));
			}
		}
		// merge sort left and right halves
		// call mergeSort() to sort each LinkedList
		leftList = mergeSort(leftList);						//Assign value of split/populate back to leftList
		rightList = mergeSort(rightList);					//Assign value of split/populate back to rightList
	
		// go through left and right halves from the front, populating a sorted list
		LinkedList<Student> sortedStudentList = new LinkedList<>();	
		sortedStudentList = merge(leftList, rightList);

		// return
		return sortedStudentList;
	}
	
	
	/**
	 * Compares name of Student objs from two LinkedList<Student> and outputs a sorted LinkedList<Student>
	 * @param leftList LinkedList<Student> from first half of original LinkedList<Student>
	 * @param rightList LinkedList<Student> from second half of original LinkedList<Student>
	 * @return sortedStudentList LinkedList<Student> containing Student objs sorted by name
	 */
	public static LinkedList<Student> merge(LinkedList<Student> leftList, LinkedList<Student> rightList){
		LinkedList<Student> sortedStudentList = new LinkedList<>();	//Create new LinkedList for sorted elements
		
		// initiate pointers to track position in ArrayLists
		int leftPtr = 0;	
		int rightPtr = 0;
		
		// while pointers are in range of ArrayLists
		while (leftPtr < leftList.size() && rightPtr < rightList.size()) {
			// if name of leftList at pointer is < name of rightList at pointer			
			if (leftList.get(leftPtr).getName().compareTo(rightList.get(rightPtr).getName()) < 0) {
				// element from leftList is added to sortedArray
				sortedStudentList.add(leftList.get(leftPtr));
				// increment pointer to align with next element in LinkedList
				leftPtr++;
			}
			else {
				// if name of rightList at pointer is < name of leftList at pointer
				// element from rightList is added to sortedArray
				sortedStudentList.add(rightList.get(rightPtr));
				// increment pointer to align with next element in LinkedList
				rightPtr++;
			}
		}
		// if elements remain in leftList after right has emptied, 
		// add remaining elements to sortedStudentList
		if (leftPtr < leftList.size()) {
			for (int j = leftPtr; j < leftList.size(); j++) {
				sortedStudentList.add(leftList.get(j));
			}
		}
		// if elements remain in rightList after left has emptied, 
		// add remaining elements to sortedStudentList
		else {
			for (int j = rightPtr; j < rightList.size(); j++) {
				sortedStudentList.add(rightList.get(j));
			}
		}
		// return
		return sortedStudentList;
	}
}