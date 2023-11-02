package DiningDiscount;

import DiningOrder.Order;
import DiningOrder.OrderItem;

public class DiscountCalculator {

	private DiscountCalculator() {
		// TODO Auto-generated constructor stub
	}
	
	public static double calculateTotalCost(Order order) {
        int totalQuantity = 0;

        for (OrderItem item : order.getItems()) {
            totalQuantity += item.getQuantity();
        }

        double totalCost = order.getTotalCost();

        if (totalQuantity > 5) {
            totalCost = applyMealQuantityDiscount(totalCost, totalQuantity);
        }

        totalCost = applySpecialOfferDiscount(totalCost);

        return totalCost;
    }

    public static double applyMealQuantityDiscount(double totalCost, int totalQuantity) {
        if (totalQuantity > 10) {
            return totalCost * 0.8; // 20% discount
        } else {
            return totalCost * 0.9; // 10% discount
        }
    }
	
	public static double applySpecialOfferDiscount(double totalCost) {
        if (totalCost > 100) {
            return totalCost - 25.0;
        } else if (totalCost > 50) {
            return totalCost - 10.0;
        }
        return totalCost;
    }
	
}
