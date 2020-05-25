import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer [] arr = generateRandomArray(100000);
        LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(arr));
        Evaluate<Integer> evaluater = new Evaluate<>();
        evaluater.evaluateArr(arr,MergeSort::sort,MergeSort.class);
        evaluater.evaluateALl(ll,MergeSortLL::sort,MergeSortLL.class);

        evaluater.evaluateArr(arr,QuickSort::sort,QuickSort.class);
        evaluater.evaluateALl(ll,QuickSortLL::sort,QuickSortLL.class);
    }
    public static Integer[] generateRandomArray(int arrayCapacity){
        Random rd = new Random(); // creating Random object
        Integer[] arr = new Integer[arrayCapacity];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
        }
        return arr;
    }
    /*evaluater.evaluateArr(arr,HeapSort::sort, HeapSort.class);
        evaluater.evaluateArr(arr,BubbleSort::sort, BubbleSort.class);
        evaluater.evaluateArr(arr,InsertionSort::sort, InsertionSort.class);
        evaluater.evaluateArr(arr,MergeSort::sort, MergeSort.class);
        evaluater.evaluateArr(arr,QuickSort::sort, QuickSort.class);
        evaluater.evaluateArr(arr,SelectionSort::sort, SelectionSort.class);
        evaluater.evaluateArr(arr,ShellSort::sort, ShellSort.class);*/
}
