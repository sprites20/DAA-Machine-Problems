public class BubbleSortFunctions {

       public static void bubbleSortOptimized(int[] arr) {
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
    
    public static void bubbleSortUnoptimized(int[] arr) {
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

        bubbleSortOptimized(elements);

        System.out.println("Final sorted array:");
        printArray(elements);
        
        int[] elements1 = {57, 98, 65, 11, 3, 19, 22};
        
        System.out.println("Original array:");
        printArray(elements1);

        bubbleSortUnoptimized(elements1);

        System.out.println("Final sorted array:");
        printArray(elements1);
    }
}

