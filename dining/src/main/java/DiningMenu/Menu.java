package DiningMenu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	
	private final Map<String, Double> menuItems;


	public Menu() {
		// TODO Auto-generated constructor stub
		menuItems = new HashMap<>();
        menuItems.put("Burger", 10.0);
        menuItems.put("Pizza", 12.0);
        menuItems.put("Pasta", 15.0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Map<String, Double> getMenu() {
		// TODO Auto-generated method stub
		return menuItems;
	}

	public void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("Menu:");
        for (Map.Entry<String, Double> item : menuItems.entrySet()) {
            System.out.println(item.getKey() + " - $" + item.getValue());
        }
		
	}

}
