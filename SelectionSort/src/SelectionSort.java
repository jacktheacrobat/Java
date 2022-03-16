
public class SelectionSort {
	
	//Initiate int array
	private static int nums[] = {5, 7, 4, 9, 8, 5, 6, 3};

	public static void main(String[] args) {
		
		System.out.println("Unsorted List: ");
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		System.out.println("Acsending sorted List: ");
		upSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		System.out.println("Descending sorted List: ");
		downSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	
	//selection sort in ascending order
	public static int[] upSort(int[] nums) {
		
		int min;
		for (int i = 0; i < nums.length; i ++) {			//for every index of array
			min = i;
			for (int j = i + 1; j < nums.length; j++) {		//check the remainder of the array for a smaller number
				if (nums[j] < nums[min]) {					
					min = j;								//if new number is smaller than old number, assign new number to min
				}	
			}
			int temp = nums[min];							//temp slot stores minimum int
			nums[min] = nums[i];							//swap old num with new
			nums[i] = temp;									//minimum int is moved to front of unsorted list
		}
		
		return nums;
		
	}
	
	//selection sort in descending order
	public static int[] downSort(int[] nums) {

		int max;
		for (int i = 0; i < nums.length; i ++) {			//for every index of array
			max = i;
			for (int j = i + 1; j < nums.length; j++) {		//check the remainder of the array for a larger number
				if (nums[j] > nums[max]) {
					max = j;								//if new number is larger than old number, assign new number to max
				}	
			}
			int temp = nums[max];							//temp slot stores maximum int
			nums[max] = nums[i];							//swap old num with new
			nums[i] = temp;									//maximum int is moved to front of unsorted list
		}
		return nums;
		
	}
}
