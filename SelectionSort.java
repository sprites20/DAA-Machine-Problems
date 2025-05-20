package com.myapp.package.algorithms;

public class SelectionSort{

    private static int[] arr = Utility.randomizeArray();
	static void selectionSortUnoptimized(int array[]) {
		int size = array.length; //get the size of the array

        //outer loop controls the boundary between sorted and unsorted parts
		for(int i=0; i<size-1; i++) {
            //assume the current index is the minIndex
		    int minIndex = i;
		
            //inner loop searches for the actual smallest element in the unsorted part
            //this is the brute force part: it checks every remaining element
            for(int j = i + 1; j < size; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j; //update the smallest element found
                }
            }
		
            //swap the smallest found element with the first unsorted element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
	}
    static void selectionSortOptimized(int array[]) {
        for (int i = 0, j = size - 1; i < j; i++, j--)
        {
            int min = arr[i];
            int max = arr[i];
            
            int id_min = i;
            int id_max = i;
            
            for (int k = i + 1; k <= j; k++)
            {
                if (arr[k] > max)
                {
                    max = arr[k];
                    id_max = k;
                }
                else if (arr[k] < min)
                {
                    min = arr[k];
                    id_min = k;
                }
            }
            swap(arr, i, id_min);
            if (arr[id_min] == max)
            {
                swap(arr, j, id_min);
            }
            else 
            {
                swap(arr, j, id_max);
            }
        }
    }

	
	public static void runSelectionSort(int choice) {
        //example array
        if(!(choice != 1 || choice != 2)){
            System.out.println("Invalid option. Try again."); 
            return;
        }

        //create object and call the sort method
        if(choice == 1)
        {
            selectionSortUnoptimized(arr);  
        } 
        else selectionSortOptimized(arr);

        System.out.println("Sorted Array:\n");
        for(int i=0; i<array.length; i++) {
	        System.out.print(arr[i] + " ");
        }
	}
}


