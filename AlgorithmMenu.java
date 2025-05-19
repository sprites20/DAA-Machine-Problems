import java.util.*;

public class AlgorithmMenu {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Algorithm Menu ===");
            System.out.println("1. Knapsack Problem");
            System.out.println("2. Selection Sort");
            System.out.println("3. Bubble Sort");
            System.out.println("4. TSP Problem");
            System.out.println("5. Sequential Search");
            System.out.println("0. Exit");
            System.out.print("Choose an algorithm (0-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    runKnapsack();
                    break;
                case 2:
                    runSelectionSort();
                    break;
                case 3:
                    runBubbleSort();
                    break;
                case 4:
                    runTSP();
                    break;
                case 5:
                    runSequentialSearch();
                    break;
                case 0:
                    System.out.println("Exiting. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // === 1. Knapsack Problem ===
    static void runKnapsack() {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;
        int n = weights.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        System.out.println("Max value in Knapsack: " + dp[n][capacity]);
    }

    // === 2. Selection Sort ===
    static void runSelectionSort() {
        int[] arr = {64, 25, 12, 22, 11};
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Selection Sorted: " + Arrays.toString(arr));
    }

    // === 3. Bubble Sort ===
    static void runBubbleSort() {
        int[] arr = {5, 1, 4, 2, 8};
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        System.out.println("Bubble Sorted: " + Arrays.toString(arr));
    }

    // === 4. TSP Problem ===
    static void runTSP() {
        float[][] matrix = {
            {0, 10, 15},
            {10, 0, 20},
            {15, 20, 0}
        };

        TSPFunctions.solveOptimized(matrix);
    }

    // === 5. Sequential Search ===
    static void runSequentialSearch() {
        int[] arr = {3, 7, 1, 9, 5};
        System.out.print("Enter number to search: ");
        int target = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Found at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) System.out.println("Not found.");
    }
}
