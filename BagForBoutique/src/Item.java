
public class Item {

	public String itemName;
	public double itemPrice;
	
	Item(String itemName, double itemPrice){
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public String toString() {
		
		return "\n" + itemName + " $" + Double.toString(itemPrice);
		
	}
}
