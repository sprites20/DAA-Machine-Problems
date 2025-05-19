package algorithms.bubble_sort;

public class OBubbleSort {

       public static void bubbleSort(int[] arr) {
        int size = arr.length;
        int i = size - 1;
        int pass = 1;

        while (i > 0) {
            boolean swapped = false;
            int lastIndex = 0;

            System.out.println("Pass " + pass + ":");

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                    lastIndex = j;
                }
            }

            // Print array after each pass
            printArray(arr);

            if (!swapped) {
                System.out.println("No swaps performed. The array is sorted.");
                break;
            }

            i = lastIndex;
            pass++;
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

