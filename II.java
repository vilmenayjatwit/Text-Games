import java.util.ArrayList;
import java.util.Scanner;

public class II {
    public II() {
    }

    public int enter(Scanner s, ArrayList<String> visitedAreas, int dishNumber){
        int toolChoice;

        System.out.println("Please select the correct tool to use.");
        System.out.println("1) Fry Pan");
        System.out.println("2) Baking Sheet");
        System.out.println("3) Mixer");
        System.out.println("0) Exit the current dish");

        // Loop until player enters a valid choice
        while (true) {
            // Get player choice
            if (s.hasNextInt()) {
                toolChoice = s.nextInt();

                // Checks if the number answer is a valid choice
                if (toolChoice < 0 || toolChoice > 3) {
                    System.out.printf("Invalid selection. Please choose one of the options above.%n%n");
                }
                else{
                    break;
                }
            }
            // Non-number answer
            else {
                System.out.printf("Invalid choice. Please enter a number.%n%n");
                s.next();
            }
        }

        // Check if player decided to quit current dish
        if (toolChoice == 0){
            return -1;
        }

        System.out.print("You have selected to use a ");
        switch (toolChoice){
            case 1 -> System.out.println("Fry Pan.");
            case 2 -> System.out.println("Baking Sheet.");
            case 3 -> System.out.println("Mixer.");
        }

        // The correct tool was selected
        if (dishNumber == 1 && toolChoice == 3 || dishNumber == 2 && toolChoice == 2 || dishNumber == 3 && toolChoice == 1){
            System.out.println("Congratulations! You have selected the correct tool. You will now move on to the cooking area.");
            visitedAreas.add("Area IV");
            return 3;
        }

        // The incorrect tool was selected
        else{
            System.out.println("Whoops! You have selected the incorrect tool. You will need to restart at the prep station.");
            visitedAreas.add("Area I");
            return 1;
        }
    }
}