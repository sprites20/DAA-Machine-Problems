import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public static int[] randomizeArray(String path)
    {
        ArrayList<Integer> numberList = new ArrayList<>();

        try {
            File file = new File(path); // make sure this path is correct
            Scanner scanner = new Scanner(file);

            // Reads every token as an integer
            while (scanner.hasNextInt()) {
                numberList.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        // Convert to array if you really need an int[]
        int[] numbers = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            numbers[i] = numberList.get(i);
        }

        return numbers;
    }




    // public static int[] randomizeArray()
    // {
    //     long seed = 42;  
    //     Random rand = new Random(seed);
    //     int[] arr = new int[1000];

    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = rand.nextInt(1000); 
    //     }

    //     return arr;
    // }

    // public static int[] randomizeUniqueArray() {
    //     int[] arr = new int[1000];
    //     for (int i = 0; i < 1000; i++) {
    //         arr[i] = i;
    //     }

    //     // Convert the int[] array to a List<Integer>
    //     List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

    //     // Shuffle the List
    //     Collections.shuffle(list);

    //     // Convert the shuffled List back to an int[] array
    //     int[] shuffledArr = list.stream().mapToInt(Integer::intValue).toArray();

    //     return shuffledArr;
    // }


    // public static int[] knapsackValues(int randomSeed){
        
    //     long seed = randomSeed;  
    //     Random rand = new Random(seed);
    //     int [] arr = new int[10];

    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = rand.nextInt(10); 
    //     }

    //     return arr;
    // }

    }
    // public static void main(String[] args)
    // {
    //     int[] arr = randomizeUniqueArray();

    //     for (int number: arr)
    //     {
    //         System.out.print(number + " ");
    //     }

    // }
