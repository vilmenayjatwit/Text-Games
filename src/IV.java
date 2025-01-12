import java.util.ArrayList;
import java.util.Scanner;

public class IV {
    public int enter(Scanner scanner, ArrayList<String> visitedAreas, int dishNumber) {
    	
    	System.out.println("Area IV: Serve your dish correctly to comple it!");
    	
    	
    	System.out.println("1) Serve dish");
    	
    	System.out.println("2) Don't serve dish");
    	
    	System.out.println("Please type your choice:");
    	
    	
    	int choice = -1; //Restart the dish
    	
    	while (true) {
    		if (scanner.hasNextInt()) {
    			choice = scanner.nextInt();
    			if (choice == 1 || choice == 2) {
    				break;
    			}
    			else {
    				System.out.println("Invalid choice. Please type 1 for YES or 2 for NO.");
    			}
    		}
    		else {
    			System.out.println("Invalid input. Please enter a number (1 or 2)!");
    			scanner.next();
    		}
    	}
    	
    	if (choice == 1) {
    		System.out.println("Dish successfully served! CONGRATULATIONS!");
    		visitedAreas.add("Dish Completed");
    		return 5; //returns to main game
    	}
    	else {
    		System.out.println("You chose not to serve the dish yet. STAY IN AREA IV!");
    		return 4;
    	}
    }
}