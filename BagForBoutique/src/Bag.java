/**
 * A class that acts as a bag that holds boutique items
 * @author jackp
 *
 */
public class Bag implements BagInterface{

	private int current;
	private Item[] myBag;
	private int count = 0;
	protected static int maxSize = 10;
	
	//Constructor to instatiate the new bag in the form of 
	//an array of Items
	public Bag() {
		myBag = new Item[10];
	}
	
	//adds a new item to the bag, name and price stay connected
	@Override
	public void add(String newItemName, double newItemPrice) {
		myBag[count] = new Item(newItemName, newItemPrice);
		count++;
	}

	//The current items in the bag are copied to a new array
	//The new array is then returned
	@Override
	public Object[] toArray() {
		int currentSize = getCurrentSize();
		Object[] items = new Object[currentSize];
		for (int i = 0; i < currentSize; i++) {
			items[i] = myBag[i];
		}
		return items;
	}

	//Finds and returns the number of items currently in the bag
	public int getCurrentSize() {
		int currentSize = 0;
		for (int i = 0; i < maxSize; i++) {
			if (myBag[i] != null) {
				currentSize++;
			}
		}
		return currentSize;
	}
	
	//Checks to see if the bag is full
	@Override
	public boolean isFull() {
		if (getCurrentSize() == maxSize) {
			return true;
		}
		else return false;
	}
	
}
