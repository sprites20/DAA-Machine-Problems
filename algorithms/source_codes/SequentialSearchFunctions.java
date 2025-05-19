package algorithms;

public class SequentialSearchFunctions {
    //Method to call to search
    public static int searchUnoptimized(int arr[], int search, int size){
        for(int i = 0; i < size; i++) {//Iterate all elements in the array using loops.
            if(arr[i] == search) {//Checks if the element is equal to the target.
                return i; //Returns the index if element is found
            }
        }
        return -1;//Return -1 if the target element is not in the array.
    }
    public static void runSequentialSearch(int arr[], int searchItem, int size) {
        //Calls for search method
        int searchIndex = searchUnoptimized(arr, searchItem, size);
        if(searchIndex != -1){//Outputs the target/search index if found
            System.out.println(searchItem + " is found at index " + searchIndex);
            System.out.println("The element is found after " + (searchIndex+1) + " iteration/s"); //Outputs iterations needed to search.
        }else{
            System.out.println(searchItem + " is not found");
		}
    }
	
	private static int count = 0; //Variable for counting.
    //Method to call to improved search algorithm
    public static int searchOptimized(int arr[], int search, int size){
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
    public static void runImprovedSequentialSearch(int arr[], int searchItem, int size){
		count = 0;
        //Calls for search method
        int searchIndex = searchOptimized(arr, searchItem, size);
        if(searchIndex != -1){//Outputs the target/search index if found
            System.out.println(searchItem + " is found at index " + searchIndex);
            System.out.println("The element is found after " + count + " iteration/s"); //Outputs iterations needed to search.
        }else{
            System.out.println(searchItem + " is not found");
        }

    }
}