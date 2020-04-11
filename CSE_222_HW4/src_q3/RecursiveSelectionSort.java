public class RecursiveSelectionSort {
    static int minIndex(int[] input, int i, int j)
    {
        if (i == j)
            return i;

        // Find minimum of remaining elements
        int k = minIndex(input, i + 1, j);

        // Return minimum of current and remaining.
        return (input[i] < input[k])? i : k;
    }
    static void recurSelectionSort(int[] input, int n, int index)
    {

        // Return when starting and size are same
        if (index == n)
            return;

        // calling minimum index function for minimum index
        int k = minIndex(input, index, n-1);

        // Swapping when index nd minimum index are not same
        if (k != index){
            // swap
            int temp = input[k];
            input[k] = input[index];
            input[index] = temp;
        }
        // Recursively calling selection sort function
        recurSelectionSort(input, n, index + 1);
    }
}
