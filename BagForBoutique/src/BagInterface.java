/**
 * An interface that describes the operations of a bag of objects
 * @author jackp
 *
 * @param <T>
 */
public interface BagInterface<T> {
	
	/**
	 * Gets the current number of entries in this bag.
	 * @return the integer number of entries currently in this bag.
	 */
	public int getCurrentSize();
	
	/**
	 * Retrieves all entries that are in this bag
	 * @return A newly allocated array of all the entries in the bag.
	 * 		Note: If the bag is empty, the returned array is empty.
	 */
	public T[] toArray();
	
	/**
	 * Sees whether this bag is full.
	 * @return True if the bag is full, or false if not.
	 */
	public boolean isFull();

	/**
	 * Adds a new Boutique Item to this bag.
	 * @param newItemName The name of the object to be added as the new entry.
	 * @param newItemPrice the price of the object to be added as the new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	public void add(String newItemName, double newItemPrice);
}
