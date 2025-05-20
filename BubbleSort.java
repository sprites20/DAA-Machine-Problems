public class BubbleSort {

    private static int[] arr = Utility.randomizeArray();

    public static void bubbleSort(int[] arr) {
        int size = arr.length, i;

        for (i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Utility.swap(arr, j, j+1);
            }
        }

        System.out.println("Number of Passes : " + i);
    }

    public static void optimizedBubbleSort(int[] arr) {
        int size = arr.length;
        int i = size - 1;
        int pass = 1;

        while (i > 0) {
            boolean swapped = false;
            int lastIndex = 0;

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

            if (!swapped) {
                System.out.println("No swaps performed. The array is sorted.");
                break;
            }

            i = lastIndex;
            pass++;
        }

        System.out.println("Number of Passes : " + (pass-1));
    }

    public static void runBubbleSort(int choice) {
        if(!(choice == 1 || choice ==2)){
            System.out.println("Invalid option. Try again."); 
            return;
        }

        // int[] elements = {57, 98, 65, 11, 3, 19, 22};
        
        System.out.println("Original array:");
        Utility.printArray(arr);

        if(choice == 1) bubbleSort(arr);
        else if(choice == 2) optimizedBubbleSort(arr);
        else System.out.println("Invalid choice.");

        System.out.println("Final sorted array:");
        Utility.printArray(arr);
    }

    public static void main(String[] args)
    {
        System.out.println("Original array:");
        Utility.printArray(arr);

        optimizedBubbleSort(arr);
        System.out.println("Final sorted array:");
        Utility.printArray(arr);
    }   
}
