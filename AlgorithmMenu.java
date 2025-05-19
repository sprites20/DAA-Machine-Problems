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
	//Helper Functions
	static void printArray(int[] array) {
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
	
	static float[][] generateCostMatrix(int n) {
        float[][] matrix = new float[n][n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    // Random cost between 1 and 100
                    float cost = 1 + rand.nextInt(100);
                    matrix[i][j] = cost;
                    matrix[j][i] = cost; // Ensure symmetry
                }
            }
        }

        return matrix;
    }

    static void printMatrix(float[][] matrix) {
        for (float[] row : matrix) {
            for (float val : row) {
                System.out.printf("%6.1f ", val);
            }
            System.out.println();
        }
    }
	
    // === 1. Knapsack Problem ===
    static void runKnapsack() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter number of items (n): ");
        int n = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        // Generate random weights and values
        for (int i = 0; i < n; i++) {
            weights[i] = 1 + rand.nextInt(10); // weight between 1 and 10
            values[i] = 1 + rand.nextInt(20);  // value between 1 and 20
        }

        // Generate a random capacity between 1/3 and 2/3 of total weight
        int totalWeight = 0;
        for (int w : weights) totalWeight += w;
        int capacity = totalWeight / 3 + rand.nextInt(totalWeight / 3 + 1);

        // Print generated inputs
        System.out.println("\nGenerated weights:");
        printArray(weights);
        System.out.println("Generated values:");
        printArray(values);
        System.out.println("Generated knapsack capacity: " + capacity + "\n");

        // Solve using brute force
        int maxValue = KnapsackFunctions.solveKnapsackBF(weights, values, capacity, 0);
        System.out.println("Maximum value in knapsack (Brute Force): " + maxValue);

        // Solve using dynamic programming
        maxValue = KnapsackFunctions.solveKnapsackDP(weights, values, capacity);
        System.out.println("Maximum value in knapsack (DP): " + maxValue);
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of cities (n): ");
        int n = scanner.nextInt();

        float[][] matrix = generateCostMatrix(n);

        System.out.println("\nGenerated Cost Matrix:");
        printMatrix(matrix);

		
		long startTime = System.nanoTime();
        TSPFunctions.solveUnoptimized(matrix);
        long endTime = System.nanoTime();
        System.out.println("Unoptimized runtime (ms): " + (endTime - startTime) / 1_000_000.0);
        
		matrix = generateCostMatrix(n);

        System.out.println("\nGenerated Cost Matrix:");
        printMatrix(matrix);
		
		startTime = System.nanoTime();
        TSPFunctions.solveOptimized(matrix);
        endTime = System.nanoTime();
        System.out.println("Optimized runtime (ms): " + (endTime - startTime) / 1_000_000.0);
        
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
