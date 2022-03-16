import java.util.ArrayList;

/**
 * Sorts Person objects
 * 
 * Descending order by lastName
 * 
 * Descending order by age
 * @author jackp
 *
 */
public class PersonQuickSort {
	
	/**
	 * Partitions ArrayList<Person> into logical segments
	 * @param personList ArrayList<Person> to be partitioned
	 * @param low 
	 * @param high
	 * @param sortField
	 * @return
	 */
	static int partition (ArrayList<Person> personList, int low, int high, int sortField) {
		int pivot = high;
		int i = (low - 1);
		
		for (int j = low; j <= high - 1; j++) {
			if (personList.get(j).isGreaterThan(personList.get(pivot), sortField)) { 	//if attribute at [j] > attribute at [pivot] 
				i++;																	//swap Person i and Person j
				swap(personList, i, j);
			}
		}
		swap(personList, i + 1, high);
		return (i + 1);
	}
	/**
	 * Swaps two elements in an ArrayList<Person>
	 * @param personList
	 * @param i leftmost item in partition
	 * @param j rightmost item in partition
	 */
	static void swap(ArrayList<Person> personList, int i, int j) {
		Person temp = personList.get(i);
		personList.set(i, personList.get(j));
		personList.set(j, temp);
	}
	
	/**
	 * Sorts an ArrayList<Person> by either lastName (sortField = 0) or age (sortField = 1)
	 * @param personQueue Queue to be sorted
	 * @param low starting index
	 * @param high ending index
	 * @param sortField Decides to sort based on lastName or age (0 or 1)
	 */
	static void quickSort(ArrayList<Person> personQueue, int low, int high, int sortField) {
		if (low < high) {
			int partIndex = partition(personQueue, low, high, sortField);
			
			quickSort(personQueue, low, partIndex - 1, sortField);
			quickSort(personQueue, partIndex + 1, high, sortField);
		}
	}
}


