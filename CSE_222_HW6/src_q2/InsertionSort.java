public class InsertionSort {
    /**
     * Method that implements Insetion Sorting Algorihm
     * @param table Table that will be sorted according to Heap Sort Algorithm
     * @param <T> Generic class Type that implements Comperable interface
     */
    public static <T extends Comparable<T>> void sort(T[] table){
        for(int nextPos = 1;nextPos < table.length;nextPos++){
            insert(table,nextPos);
        }
    }

    /**
     * Insert method
     * @param table Table that will be sorted according to Heap Sort Algorithm
     * @param <T> Generic class Type that implements Comperable interface
     * @param nextPos next position
     */
    private static <T extends Comparable<T>> void insert(T[] table, int nextPos){
        T nextVal = table[nextPos];
        while (nextPos>0 && nextVal.compareTo(table[nextPos - 1] ) < 0){
            table[nextPos] = table[nextPos - 1];
            nextPos--;
        }
        table[nextPos] = nextVal;
    }
}
