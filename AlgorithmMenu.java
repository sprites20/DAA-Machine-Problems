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
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter the number of elements (n): ");
        int n = scanner.nextInt();

        // Generate random array of n integers (range 0 to 100)
        int[] elements1 = new int[n];
        for (int i = 0; i < n; i++) {
            elements1[i] = rand.nextInt(101); // 0 to 100
        }
		System.out.println("Selection Sort\nOriginal array:");
        printArray(elements1);
		
		// Clone array for second test
        int[] elements2 = elements1.clone();
		
		SelectionSortFunctions.selectionSortUnoptimized(elements1);
		
		printArray(elements2);
		SelectionSortFunctions.selectionSortOptimized(elements1);
    }

    // === 3. Bubble Sort ===
    static void runBubbleSort() {
		Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter the number of elements (n): ");
        int n = scanner.nextInt();

        // Generate random array of n integers (range 0 to 100)
        int[] elements1 = new int[n];
        for (int i = 0; i < n; i++) {
            elements1[i] = rand.nextInt(101); // 0 to 100
        }

        System.out.println("Bubble Sort (Unoptimized)\nOriginal array:");
        printArray(elements1);

        // Clone array for second test
        int[] elements2 = elements1.clone();

        BubbleSortFunctions.bubbleSortUnoptimized(elements1);

        System.out.println("Final sorted array (Unoptimized):");
        printArray(elements1);

        System.out.println("\nBubble Sort (Optimized)\nOriginal array:");
        printArray(elements2);

        BubbleSortFunctions.bubbleSortOptimized(elements2);

        System.out.println("Final sorted array (Optimized):");
        printArray(elements2);
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
        Scanner scanner = new Scanner(System.in);
        
        //Inputs for the array initialization
        System.out.print("Enter size of array : ");
        int size = Integer.parseInt(scanner.nextLine());
		
		int[] arr = new int[size];
        System.out.println("Enter elements of the array :");
        for(int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Enter number to search : ");
        int searchItem = Integer.parseInt(scanner.nextLine());
		
		SequentialSearchFunctions.runSequentialSearch(arr, searchItem, size);
		SequentialSearchFunctions.runImprovedSequentialSearch(arr, searchItem, size);
		
		
		
    }
}
