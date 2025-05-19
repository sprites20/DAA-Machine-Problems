package algorithms.bubble_sort;

public class BruteForceBubbleSort {

    public static void bubbleSort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {
            System.out.println("Pass " + (i + 1) + ":");

            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            // Print array after each pass
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

       public static void main(String[] args) {
        int[] elements = {57, 98, 65, 11, 3, 19, 22};

        System.out.println("Original array:");
        printArray(elements);

        bubbleSort(elements);

        System.out.println("Final sorted array:");
        printArray(elements);
    }
}
