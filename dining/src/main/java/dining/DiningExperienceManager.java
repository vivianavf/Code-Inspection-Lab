package dining;

import java.util.Scanner;

import DiningMenu.Menu;
import DiningOrder.Order;

public class DiningExperienceManager {

	private DiningExperienceManager() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menu menu = new Menu();
        Order order = new Order(menu.getMenu());
        
        while (true) {
            System.out.println("Welcome to the Dining Experience Manager!");
            System.out.println("Select from the following menu options:");
            System.out.println("1. View Menu");
            System.out.println("2. Place an Order");
            System.out.println("3. Exit");
            Scanner scanner = new Scanner(System.in); //NOPMD
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menu.displayMenu();
                    break;
                case 2:
                    order.placeOrder();
                    break;
                case 3:
                    System.out.println("Thank you for using Dining Experience Manager. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            
            scanner.close();
        }

	}

}
