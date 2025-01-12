import java.util.ArrayList;
import java.util.Scanner;

public class I {
    public int enter(Scanner scanner, ArrayList<String> visitedAreas, int dishNumber) {
        System.out.println("Area I: Select the correct ingredient for your dish.");

        // Provide options based on the selected dish
        switch (dishNumber) {
            case 1 -> System.out.println("1: Flour, 2: Meat, 3: Tomato Sauce/Shaved Cheese"); // Cake
            case 2 -> System.out.println("1: Flour, 2: Meat, 3: Tomato Sauce/Shaved Cheese"); // Pizza
            case 3 -> System.out.println("1: Flour, 2: Meat, 3: Tomato Sauce/Shaved Cheese"); // Hamburger
        }

        // Get the player's choice
        int choice = scanner.nextInt();

        // Check if the choice is correct based on the dish
        if ((dishNumber == 1 && choice == 1) ||  // Cake: Flour
            (dishNumber == 2 && choice == 3) ||  // Pizza: Sauce
            (dishNumber == 3 && choice == 2)) {  // Hamburger: Meat
            System.out.println("Correct! Moving to Area II.");
            return 2; // Move to Area II
        } else {
            System.out.println("Wrong choice! Try again.");
            return -1; // Failure (restart the dish)
        }
    }
}
