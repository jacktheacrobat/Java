import java.util.Arrays;

/**
 * Class to test the boutique bag implementation
 * @author jackp
 *
 */
public class BoutiqueBagDemo extends Bag{
	
	public static Bag bag = new Bag();

	//Adds item to the bag and returns true if add was successful, or false if not.
	public static boolean testAdd(String itemName, double itemPrice) {
		int initSize = bag.getCurrentSize();
		bag.add(itemName, itemPrice);
		int finSize = bag.getCurrentSize();
		if (initSize < finSize) {
			return true;
		}
		else return false;
		
	}
	//prints out the contents of the bag
	public static void displayBag() {
		System.out.println(Arrays.toString(bag.toArray()));
		}
	
	
	public static void main(String[] args) {
	
		System.out.println(testAdd("Test", 123));
		System.out.println(testAdd("Test Item", 123.456));
		displayBag();
	}
}
