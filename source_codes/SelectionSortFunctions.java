package algorithms;

public class SelectionSortFunctions {

    public static void selectionSortUnoptimized(int array[]) {
        int size = array.length;
        int passCount = 0;

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

            passCount++;
        }

        System.out.println("Sorted array (Unoptimized):");
        printArray(array);
        System.out.println("Number of passes (Unoptimized): " + passCount);
    }

    public static void selectionSortOptimized(int array[]) {
        int size = array.length;
        int passCount = 0;

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }

            passCount++;
        }

        System.out.println("Sorted array (Optimized):");
        printArray(array);
        System.out.println("Number of passes (Optimized): " + passCount);
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int[] array1 = {100, 75, 24, 39, 19};
        int[] array2 = array1.clone();

        System.out.println("Running Unoptimized Selection Sort:");
        selectionSortUnoptimized(array1);

        System.out.println("\nRunning Optimized Selection Sort:");
        selectionSortOptimized(array2);
    }
}
