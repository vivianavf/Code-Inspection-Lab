package DiningOrder;

public class OrderItem {
	
	private final int quantity;
	private final String itemName;

	public OrderItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }
	
	public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

}
