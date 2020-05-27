import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    final static int NUMBER_OF_RANDOM_ARRAYS = 20;
    final static int NUMBER_OF_ORDERED_ARRAYS = 1;
    final static int [] ARRAY_CAPACITY = {10000,40000,100000,150000,180000};

    public static void main(String[] args) {
        Evaluate<Integer> evaluater = new Evaluate<>();
        StringBuilder sb = new StringBuilder();
        sb.append("Size ;")
                .append("Random or Ordered")
                .append(';')
                .append("Name of Sort Type      ")
                .append(';')
                .append("Miliseconds")
                .append('\n');

        for(int i = 0 ; i< 5; i++) {
            for (int k = 0; k < 9; k++) {
                long totalTime = 0;
                long ordered_time = 0;
                for (int j = 0; j < NUMBER_OF_RANDOM_ARRAYS; j++) {
                    int arrayCapacity = ARRAY_CAPACITY[i];
                    Integer[] arr_random = generateRandomArray(arrayCapacity);
                    LinkedList<Integer> ll_random = new LinkedList<>(Arrays.asList(arr_random));
                    totalTime = totalTime + execution(arr_random, ll_random, evaluater, sb, "Random ", arrayCapacity, k);
                }
                for (int j = 0; j < NUMBER_OF_ORDERED_ARRAYS; j++) {
                    int arrayCapacity = ARRAY_CAPACITY[i];
                    Integer[] arr_ordered = generateOrderedArray(arrayCapacity);
                    LinkedList<Integer> ll_ordered = new LinkedList<>(Arrays.asList(arr_ordered));
                    ordered_time = execution(arr_ordered, ll_ordered, evaluater, sb, "Ordered", arrayCapacity,k);
                }
                System.out.println();

                //Reason I didn't convert milliseconds to seconds is that .csv file deletes and doesn't show double values so
                //I left total time values as milliseconds
                sb.append("Total time Random(Milliseconds);" + ";" + ";").append(totalTime).append("\n");
                sb.append("Total time Ordered(Milliseconds);" + ";" + ";").append(ordered_time).append("\n");
                System.out.println(totalTime);
                System.out.println(ordered_time);
            }
        }
        try (PrintWriter printWriter = new PrintWriter(new File("src_q2/1801042092_output.csv"))){

            printWriter.write(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

    private static long execution(Integer[] arr,
                                  LinkedList<Integer> ll,
                                  Evaluate<Integer> evaluater,
                                  StringBuilder sb,
                                  String order,
                                  int array_capacity,
                                  int setting) {
        long result = 0;
        if(setting == 0){
            result = evaluater.evaluateArr(arr,HeapSort::sort);
            sb.append(array_capacity).append(';').append(order).append("          ").append(';').append("Heap Sort              ").append(';').append(result).append('\n');
            System.out.println(array_capacity + " Heap Sort " + order + " done");
        }else if(setting == 1){
            result = evaluater.evaluateArr(arr,BubbleSort::sort);
            sb.append(array_capacity).append(';').append(order).append("          ").append(';').append("Bubble Sort            ").append(';').append(result).append('\n');
            System.out.println(array_capacity + " Bubble Sort " + order + " done");
        }else if(setting == 2){
            result = evaluater.evaluateArr(arr,InsertionSort::sort);
            sb.append(array_capacity).append(';').append(order).append("          ").append(';').append("Insertion Sort         ").append(';').append(result).append('\n');
            System.out.println(array_capacity + " Insertion Sort " + order + " done");
        }else if(setting == 3){
            result = evaluater.evaluateArr(arr, SelectionSort::sort);
            sb.append(array_capacity).append(';').append(order).append("          ").append(';').append("Selection              ").append(';').append(result).append('\n');
            System.out.println(array_capacity + " Selection Sort " + order + " done");
        }else if(setting == 4){
            result = evaluater.evaluateArr(arr,ShellSort::sort);
            sb.append(array_capacity).append(';').append(order).append("          ").append(';').append("Shell Sort             ").append(';').append(result).append('\n');
            System.out.println(array_capacity + " Shell Sort " + order + " done");
        }else if(setting == 5){
            result = evaluater.evaluateArr(arr,MergeSort::sort);
            sb.append(array_capacity).append(';').append(order).append("          ").append(';').append("Merge Sort(Book)       ").append(';').append(result).append('\n');
            System.out.println(array_capacity + " Merge Sort(Book) " + order + "  done");
        }else if(setting == 6){
            result = evaluater.evaluateALl(ll,MergeSortLL::sort);
            sb.append(array_capacity).append(';').append(order).append("          ").append(';').append("Merge Sort(Linked List)").append(';').append(result).append('\n');
            System.out.println(array_capacity + " Merge Sort(Linkedlist) " + order + " done");
        }else if(setting == 7){
            result = evaluater.evaluateArr(arr,QuickSort::sort);
            sb.append(array_capacity).append(';').append(order).append("          ").append(';').append("Quick Sort(Book)       ").append(';').append(result).append('\n');
            System.out.println(array_capacity + " Quick Sort(Book) " + order + " done");
        }else if(setting == 8){
            result = evaluater.evaluateALl(ll,QuickSortLL::sort);
            sb.append(array_capacity).append(';').append(order).append("          ").append(';').append("Quick Sort(Linked List)").append(';').append(result).append('\n');
            System.out.println(array_capacity + " Quick Sort(LinkedList) " + order + " done");
        }
        return result;
    }

    public static Integer[] generateRandomArray(int arrayCapacity){
        Random rd = new Random();
        rd.setSeed(0);
        Integer[] arr = new Integer[arrayCapacity];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }
    public static Integer [] generateOrderedArray(int arrayCapacity){
        Integer[] arr = new Integer[arrayCapacity];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
