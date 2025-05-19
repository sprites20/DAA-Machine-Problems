package algorithms.selection_sort;

class OSelectionSort{
    static void swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    static void sort(int[] arr, int size)
    {
        for (int i = 0, j = size - 1; i < j; i++, j--)
        {
            int min = arr[i];
            int max = arr[i];
            
            int id_min = i;
            int id_max = i;
            
            for (int k = i + 1; k < j; k++)
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
    
    public static void main(String[] args) {
        int[] array = {100, 75, 75, 24, 24, 19, 39};
        System.out.print("Unsorted Array:\n");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        sort(array, array.length);
        System.out.print("\nSorted Array:\n");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
}