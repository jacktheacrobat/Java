import java.util.Arrays;

public abstract class test extends Bag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bag bag = new Bag();
		bag.add("Shirt", 14.30);
		bag.add("Pants", 10.12);
		bag.add("Hat", 8.99);
		bag.add("Underwear", 12.34);
//		
//		while (bag.isFull() == false) {
//			bag.add("No item", 0);
//		}

		System.out.println(bag.getCurrentSize());

		System.out.println(Arrays.toString(bag.toArray()));
		
		System.out.println(bag.isFull());
	}

}
