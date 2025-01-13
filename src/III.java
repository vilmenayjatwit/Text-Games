import java.util.ArrayList;
import java.util.Scanner;

public class III {
    public int enter(Scanner scanner, ArrayList<String> visitedAreas, int dishNumber) {
        System.out.println("Area III: Select the correct cooking method and temperature for your dish.");

        // Options for each dish
        String options;
        if (dishNumber == 1) { // Cake
            options = "1: Bake for 30-45 minutes\n2: Bake for 10-15 minutes\n3: Cook for 8 minutes";
        } else if (dishNumber == 2) { // Pizza
            options = "1: Bake for 30-45 minutes\n2: Bake for 10-15 minutes\n3: Cook for 8 minutes";
        } else { // Hamburger
            options = "1: Bake for 30-45 minutes\n2: Bake for 10-15 minutes\n3: Cook for 8 minutes";
        }

        System.out.println(options);

        int choice = -1;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        // Get the player's choice
        if ((dishNumber == 1 && choice == 1) ||  // Cake: Bake at 350°F for 30-45 minutes
            (dishNumber == 2 && choice == 2) ||  // Pizza: Bake at 425°F for 10-15 minutes
            (dishNumber == 3 && choice == 3)) {  // Hamburger: Grill at 500°F for 5 minutes
            System.out.println("Correct! Moving to Area IV.");
            visitedAreas.add("Completed Area III for Dish " + dishNumber);
            return 4; // Move to Area IV
        } else {
            System.out.println("Wrong choice! Try again.");
            return 3; // Stay in Area III
        }
    }
}