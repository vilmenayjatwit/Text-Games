import java.util.ArrayList;
import java.util.Scanner;

public class CookingMama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> visitedAreas = new ArrayList<>();

        // Tracks how many dishes are completed (each dish = 1 star)
        int starCount = 0;

        // Intro message 
        System.out.println("Welcome to Cooking Mama! Your goal is to earn 3 stars by completing dishes :)");
        System.out.println("Choose from Cake, Pizza, or Hamburger to begin!");

        // Loop until the player earns 3 stars or exits
        while (starCount < 3) {
            System.out.println("\nYou currently have " + starCount + " star(s).");
            System.out.println("Which dish would you like to make?");
            System.out.println("1) Cake");
            System.out.println("2) Pizza");
            System.out.println("3) Hamburger");
            System.out.println("Type a number, or type 0 to exit.");

            // Get player choice
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Invalid input
                System.out.println("Invalid input. Please enter a number.");
                continue; // Skip loop and ask again
            }

            // Exit the game if the player types 0
            if (choice == 0) {
                System.out.println("Exiting the game. Thanks for playing Cooking Mama!");
                break;
            }

            // If they type an invalid input
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid selection. Please choose 1, 2, 3, or 0 to exit.");
                continue; // Skip loop and ask again
            }

            // Attempt to complete the chosen dish
            boolean dishCompleted = playDish(scanner, visitedAreas, choice);

            // If the player completed the dish, +1 starCount
            if (dishCompleted) {
                starCount++;
                System.out.println("Dish completed! You earned a star.");
            } else {
                // If the user quits, no star is earned
                System.out.println("You quit. No star earned.");
            }
        }

        // If the player earns 3 stars, display congrats
        if (starCount >= 3) {
            System.out.println("\nWOOOHOOOO! You have earned all 3 stars!!");
        }

        // Final message when exiting the game
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static boolean playDish(Scanner scanner, ArrayList<String> visitedAreas, int dishNumber) {
        // Creates the area objects
        I area1 = new I();
        II area2 = new II();
        III area3 = new III();
        IV area4 = new IV();

        // The player must pass areas I -> II -> III -> IV in order
        // If they fail, we restart the same dish.
        // If they quit, we return false. If they finish area IV correctly, we return true.

        int currentArea = 1;

        // Display which dish the player is making
        System.out.println("\nStarting Dish " + dishNumber + "...");
        switch (dishNumber) {
            case 1 -> System.out.println("You're making a Cake!");
            case 2 -> System.out.println("You're making a Pizza!");
            case 3 -> System.out.println("You're making a Hamburger!");
        }

        // Main loop for navigating the 4 areas
        while (true) {
            int nextArea = switch (currentArea) {
                case 1 -> area1.enter(scanner, visitedAreas, dishNumber);
                case 2 -> area2.enter(scanner, visitedAreas, dishNumber);
                case 3 -> area3.enter(scanner, visitedAreas, dishNumber);
                case 4 -> area4.enter(scanner, visitedAreas, dishNumber);
                default -> -1; // exit condition
            };

            // Check result
            if (nextArea < 0) {
                // Player chose to exit or some error occurred
                System.out.println("Exiting the current dish.");
                return false;
            } else if (nextArea == 5) {
                // A return of 5 means "successfully served this dish"
                System.out.println("Dish completed successfully!");
                return true;
            } else {
                // Move to the next area the Player selected
                currentArea = nextArea;
            }
        }
    }
}
