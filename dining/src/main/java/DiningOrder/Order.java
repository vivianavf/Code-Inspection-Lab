package DiningOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import DiningDiscount.DiscountCalculator;

public class Order {
	
	private final Map<String, Double> menu;
    private final List<OrderItem> items;
    private final double baseCost;
    private double totalCost;


	public Order(Map<String, Double> menu) {
		// TODO Auto-generated constructor stub
		this.menu = menu;
        this.items = new ArrayList<>();
        this.baseCost = 5.0;
        this.totalCost = baseCost;
	}

	public void placeOrder() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
            System.out.print("Enter the name of the item you want to order (or type 'done' to finish): ");
            String itemName = scanner.nextLine();

            if ("done".equals(itemName)) {
                break;
            }

            if (!menu.containsKey(itemName)) {
                System.out.println("Item not available. Please select a valid item.");
                continue;
            }

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();

            if (!OrderValidator.validateQuantity(quantity)) {
                System.out.println("Invalid quantity. Please enter a positive integer greater than zero.");
                continue;
            }

            OrderItem orderItem = createOrderItem(itemName, quantity);
            items.add(orderItem);
        }
		
		if (items.isEmpty()) {
            displayOrderSummary();
        } else {
            System.out.println("No items in the order. Order canceled.");
        }
		
		
	}
	
	private static OrderItem createOrderItem(String itemName, int quantity) {
		return new OrderItem(itemName, quantity);
	}

	public void displayOrderSummary() {
		// TODO Auto-generated method stub
		System.out.println("Order Summary:");
        for (OrderItem item : items) {
            double itemTotal = menu.get(item.getItemName()) * item.getQuantity();
            System.out.println(item.getItemName() + " x" + item.getQuantity() + " - $" + itemTotal);
            totalCost += itemTotal;
        }
        
        totalCost = DiscountCalculator.calculateTotalCost(this);

        System.out.println("Base Cost: $" + baseCost);
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Do you want to confirm the order? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String confirmation = scanner.nextLine();

        if ("yes".equalsIgnoreCase(confirmation)) {
            System.out.println("Order confirmed. Total cost: $" + totalCost);
        } else {
            System.out.println("Order canceled.");
        }
	}
	
	public List<OrderItem> getItems() {
        return items;
    }

	public double getTotalCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
