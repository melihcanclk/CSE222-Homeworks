public class HeapSort {
    /**
     * Main sorting method
     * @param table Table that will be sorted according to Heap Sort Algorithm
     * @param <T> Generic type Class that implements Comperable interface
     */
    public static <T extends Comparable<T>> void sort(T[] table){
        buildHeap(table);
        shrinkHeap(table);
    }

    /**
     * Method For building heap
     * @param table Table that will be sorted according to Heap Sort Algorithm
     * @param <T> Generic Class Type
     */
    private static <T extends Comparable<T>> void buildHeap(T[] table) {
        int n = 1;
        while(n < table.length){
            n++;
            int child = n - 1;
            int parent = (child - 1) / 2;
            while (parent >= 0 && table[parent].compareTo(table[child]) < 0){
                swap(table,parent,child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }

    /**
     * Swaps values at position i and j
     * @param table Table that will elements be swapped
     * @param i First element
     * @param j Second element
     * @param <T> Generic Class Type that has comperable interface
     */
    private static <T extends Comparable<T>> void swap(T[] table, int i, int j) {
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }

    /**
     * Method for shrinking heap
     * @param table Table that will be sorted according to Heap Sort Algorithm
     * @param <T> Generic class Type that implements Comperable interface
     */
    private static <T extends Comparable<T>> void shrinkHeap(T[] table) {
        int n = table.length;
        while (n>0){
            n--;
            swap(table,0,n);
            int parent = 0;
            while (true){
                int leftChild = 2 * parent + 1;
                if(leftChild >= n){
                    break;
                }
                int rightChild = leftChild + 1;
                int maxChild = leftChild;
                if(rightChild < n && table[leftChild].compareTo(table[rightChild]) < 0){
                    maxChild = rightChild;
                }
                if(table[parent].compareTo(table[maxChild]) < 0){
                    swap(table,parent,maxChild);
                    parent = maxChild;
                }else {
                    break;
                }
            }
        }
    }



}
