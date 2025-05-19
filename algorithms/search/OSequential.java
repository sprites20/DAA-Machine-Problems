package algorithms.search;

import java.util.Scanner; //Import scanner for user input

public class OSequential {
    private static int count = 0;//Variable for counting.
    //Method to call to improved search algorithm
    public static int search(int arr[], int search, int size){
        int first = 0, last = arr.length - 1; //Initialized variable of both ends for iterations
        while(first <= last){ //Loop will stop until it reaches the middle of the array.
            count++;//Increments to know how many iterations needed to find the target.
            if(search == arr[first] || search == arr[last]){//Checks if search targets matches the first or last index.
                if(search == arr[first]){   
                    return first; //Return first variable if found at this index
                }else{
                    return last; //Return last variable if found at this index
                }
            }
            first++; //Moves the first to the next element for the next iteration
            last--; //Moves the last to the previous element for the next iteration
        }
        return -1; //If not found returns -1
    }
    public static void main(String args[]){
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

        //Calls for search method
        int searchIndex = search(arr, searchItem, size);
        if(searchIndex != -1){//Outputs the target/search index if found
            System.out.println(searchItem + " is found at index " + searchIndex);
            System.out.println("The element is found after " + count + " iteration/s"); //Outputs iterations needed to search.
        }else{
            System.out.println(searchItem + " is not found");
        }
        scanner.close();
    }
}