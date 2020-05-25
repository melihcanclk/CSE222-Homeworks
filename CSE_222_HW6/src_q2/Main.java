import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    final static int NUMBER_OF_RANDOM_ARRAYS = 1;
    final static int NUMBER_OF_ORDERED_ARRAYS = 1;
    final static int [] ARRAY_CAPACITY = {10000,40000,100000,150000,180000};

    public static void main(String[] args) {
        int arrayCapacity = ARRAY_CAPACITY[1];
        Evaluate<Integer> evaluater = new Evaluate<>();
        StringBuilder sb = new StringBuilder();
        sb.append("Size |")
                .append("Random or Ordered")
                .append('|')
                .append("Name of Sort Type      ")
                .append('|')
                .append("Seconds")
                .append('\n');


        Integer [] arr_random = generateRandomArray(arrayCapacity);
        LinkedList<Integer> ll_random = new LinkedList<>(Arrays.asList(arr_random));

        Integer [] arr_ordered = generateOrderedArray(arrayCapacity);
        LinkedList<Integer> ll_ordered = new LinkedList<>(Arrays.asList(arr_ordered));

        execution(arr_random, ll_random, evaluater, NUMBER_OF_RANDOM_ARRAYS,sb,"Random ",arrayCapacity);

        execution(arr_ordered, ll_ordered, evaluater, NUMBER_OF_ORDERED_ARRAYS,sb,"Ordered",arrayCapacity);
        System.out.println(sb.toString());
    }

    private static void execution(Integer[] arr,
                                          LinkedList<Integer> ll,
                                          Evaluate<Integer> evaluater,
                                          int numberOfArrays,
                                          StringBuilder sb,
                                          String randomOrOrdered,
                                          int array_capacity) {
        sb.append(array_capacity).append(';').append(randomOrOrdered).append("          ").append(';').append("Heap Sort              ").append(';').append(
                evaluater.evaluateArr(arr,HeapSort::sort, HeapSort.class, numberOfArrays)
        ).append('\n');
        sb.append(array_capacity).append(';').append(randomOrOrdered).append("          ").append(';').append("Bubble Sort            ").append(';').append(
                evaluater.evaluateArr(arr,BubbleSort::sort, BubbleSort.class, numberOfArrays)
        ).append('\n');
        sb.append(array_capacity).append(';').append(randomOrOrdered).append("          ").append(';').append("Insertion Sort         ").append(';').append(
                evaluater.evaluateArr(arr,InsertionSort::sort, InsertionSort.class, numberOfArrays)
        ).append('\n');
        sb.append(array_capacity).append(';').append(randomOrOrdered).append("          ").append(';').append("Selection              ").append(';').append(
                ( evaluater.evaluateArr(arr, SelectionSort::sort, SelectionSort.class, numberOfArrays))
        ).append('\n');
        sb.append(array_capacity).append(';').append(randomOrOrdered).append("          ").append(';').append("Shell Sort             ").append(';').append(
                evaluater.evaluateArr(arr,ShellSort::sort, ShellSort.class, numberOfArrays)
        ).append('\n');
        sb.append(array_capacity).append(';').append(randomOrOrdered).append("          ").append(';').append("Merge Sort(Book)       ").append(';').append(
                evaluater.evaluateArr(arr,MergeSort::sort, MergeSort.class, numberOfArrays)
        ).append('\n');
        sb.append(array_capacity).append(';').append(randomOrOrdered).append("          ").append(';').append("Merge Sort(Linked List)").append(';').append(
                evaluater.evaluateALl(ll,MergeSortLL::sort, MergeSortLL.class, numberOfArrays)
        ).append('\n');
        sb.append(array_capacity).append(';').append(randomOrOrdered).append("          ").append(';').append("Quick Sort(Book)       ").append(';').append(
                evaluater.evaluateArr(arr,QuickSort::sort, QuickSort.class, numberOfArrays)
        ).append('\n');
        /*sb.append(array_capacity).append(';').append(randomOrOrdered).append("          ").append(';').append("Quick Sort(Linked List)").append(';').append(
                evaluater.evaluateALl(ll,QuickSortLL::sort, QuickSortLL.class, numberOfArrays)
        ).append('\n');*/
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
