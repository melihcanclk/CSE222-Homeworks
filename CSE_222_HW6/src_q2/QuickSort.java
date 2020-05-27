public class QuickSort {
    private static <T extends Comparable<T>> void swap(T[] table, int i, int j) {
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }
    public static <T extends Comparable<T>> void sort(T[] table) {
        // Sort the whole table.
        quickSort(table, 0, table.length - 1);
    }
    private static <T extends Comparable<T>> void quickSort(T[] table,
                                                            int first, int last) {
        if (first < last) { // There is data to be sorted.
            // Partition the table.
            int pivIndex = partition(table, first, last);
            // Sort the left half.
            quickSort(table, first, pivIndex - 1);
            // Sort the right half.
            quickSort(table, pivIndex + 1, last);
        }
    }
    private static <T extends Comparable<T>> int partition(T[] table, int first, int last) {
        bubbleSort3(table,first,last);
        int middle = (first + last) / 2;
        swap(table,first,middle);
        // Select the first item as the pivot value.
        T pivot = table[first];
        int up = first;
        int down = last;
        do {
            while ((up < last) && (pivot.compareTo(table[up]) >= 0)) {
                up++;
            }
            // assert: up equals last or table[up] > pivot.
            while (pivot.compareTo(table[down]) < 0) {
                down--;
            }
            // assert: down equals first or table[down] <= pivot.
            if (up < down) { // if up is to the left of down.
                // Exchange table[up] and table[down].
                swap(table, up, down);
            }
        } while (up < down); // Repeat while up is left of down.
        // Exchange table[first] and table[down] thus putting the
        // pivot value where it belongs.
        swap(table, first, down);
        // Return the index of the pivot value.
        return down;
    }
    private static <T extends Comparable<T>> void bubbleSort3(T[]table, int first, int last){
        int middle = (first + last ) / 2;
        if(table[middle].compareTo(table[first])< 0){
            swap(table, first,middle);
        }if(table[last].compareTo(table[middle]) < 0){
            swap(table,middle,last);
        }if(table[middle].compareTo(table[first]) < 0){
            swap(table,first,middle);
        }
    }
}
