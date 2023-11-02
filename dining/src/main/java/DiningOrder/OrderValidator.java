package DiningOrder;

import java.util.List;
import java.util.Map;

public class OrderValidator {
	
	
	
	public static boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
	
	
	public static boolean validateMenuItems(List<OrderItem> items, Map<String, Double> menu) {
        for (OrderItem item : items) {
            if (!menu.containsKey(item.getItemName())) {
                return false;
            }
        }
        return true;
    }

	private OrderValidator() {
		// TODO Auto-generated constructor stub
	}

}
