import java.util.Scanner; //Import scanner for user input

public class SequentialSearch {
    //Method to call to search
    public static int search(int arr[], int search, int size){
        for(int i = 0; i < size; i++) {//Iterate all elements in the array using loops.
            if(arr[i] == search) {//Checks if the element is equal to the target.
                return i; //Returns the index if element is found
            }
        }
        return -1;//Return -1 if the target element is not in the array.
    }
    public static void runSequentialSearch() {
        Scanner scanner = new Scanner(System.in);
        
        //Inputs for the array initialization
        System.out.print("Enter size of array : ");
        int size = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[size];
        System.out.println("Enter elements of the array:");
        for(int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Enter number to search : ");
        int searchItem = Integer.parseInt(scanner.nextLine());

        //Calls for search method
        int searchIndex = search(arr, searchItem, size);
        if(searchIndex != -1){//Outputs the target/search index if found
            System.out.println(searchItem + " is found at index " + searchIndex);
            System.out.println("The element is found after " + (searchIndex+1) + " iteration/s"); //Outputs iterations needed to search.
        }else{
            System.out.println(searchItem + " is not found");
        }
        scanner.close();
    }
}
