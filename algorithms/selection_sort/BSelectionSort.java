package algorithms.selection_sort;

public class SelectionSortUnoptimized {
	void selectionSortUnoptimized(int array[]) {
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
void selectionSortOptimized(int array[]) {
        int size = array.length;

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;

            // Find the index of the smallest element in the unsorted part
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap only if a smaller element is found
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

	
	public static void main(String args[]) {
        //example array
		int[] array = {100, 75, 24, 39, 19};
		
        //create object and call the sort method
        SelectionSortUnoptimized sorter = new SelectionSortUnoptimized();
        sorter.selectionSortUnoptimized(array);

        //print the array in this ascending order: 19 24 39 75 100 
        System.out.println("Sorted Array:\n");
        for(int i=0; i<array.length; i++) {
	        System.out.print(array[i] + " ");
        }
	}
}


