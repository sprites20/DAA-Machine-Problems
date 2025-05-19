import java.util.*;

public class AlgorithmMenu {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // runSelectionSort();
                    break;
                case 2:
                    System.out.println("=== Bubble Sort ===");
                    printChoice();
                    choice = scanner.nextInt();
                    BubbleSort.runBubbleSort(choice);
                    break;
                case 3:
                    System.out.println("=== Sequential Search ===");
                    printChoice();
                    choice = scanner.nextInt();
                    SequentialSearch.runSequentialSearch(choice);
                    break;
                case 4:
                    // runTSP();
                    break;
                case 5:
                    // runKnapsack();
                    break;
                case 0:
                    System.out.println("Exiting. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void printMenu(){
        System.out.println("\n=== Algorithm Menu ===");
            System.out.println("1. Selection Sort");
            System.out.println("2. Bubble Sort");
            System.out.println("3. Sequential Search");
            System.out.println("4. TSP Problem");
            System.out.println("5. Knapsack Problem");
            System.out.println("0. Exit");
            System.out.print("Choose an algorithm (0-5): ");
    }
    
    static void printChoice(){
        System.out.println("1. Traditional Algorithm");
        System.out.println("2. Optimized Algorithm");
        System.out.print("Choice : ");
    }
}
