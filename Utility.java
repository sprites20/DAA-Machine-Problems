import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

public class Utility
{
    static void swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void printArray(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    public static int[] randomizeArray()
    {
        long seed = 42;  
        Random rand = new Random(seed);
        int[] arr = new int[1000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000); 
        }

        return arr;
    }

    public static int[] randomizeUniqueArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i;
        }

        // Convert the int[] array to a List<Integer>
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        // Shuffle the List
        Collections.shuffle(list);

        // Convert the shuffled List back to an int[] array
        int[] shuffledArr = list.stream().mapToInt(Integer::intValue).toArray();

        return shuffledArr;
    }


    public static int[] knapsackValues(int randomSeed){
        
        long seed = randomSeed;  
        Random rand = new Random(seed);
        int [] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10); 
        }

        return arr;
    }

    }
    // public static void main(String[] args)
    // {
    //     int[] arr = randomizeUniqueArray();

    //     for (int number: arr)
    //     {
    //         System.out.print(number + " ");
    //     }

    // }
