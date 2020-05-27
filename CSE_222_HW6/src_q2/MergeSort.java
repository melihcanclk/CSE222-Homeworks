public class MergeSort {
    /**
     * Sort method  that takes table and sorts according to Merge Sort Algorithm
     * @param table Generic table
     * @param <T> Generic type Class that implements Comperable interface
     */
    public static <T extends Comparable<T>> void sort(T[] table){
        if(table.length > 1){
            int halfSize = table.length / 2;
            T[] leftTable = (T[]) new Comparable[halfSize];
            T[] rightTable = (T[]) new Comparable[table.length - halfSize];
            System.arraycopy(table,0,leftTable,0,halfSize);
            System.arraycopy(table,halfSize,rightTable,0,table.length - halfSize);
            sort(leftTable);
            sort(rightTable);
            merge(table,leftTable,rightTable);
        }
    }

    /**
     * Merge two array
     * @param outputSequence Output array that is merged
     * @param leftSequence Left Array that will be compared by Right array
     * @param rightSequence Right array that will be compared by Left array
     * @param <T> Generic Class Type that implements Comperable interface
     */
    private static <T extends Comparable<T>> void merge(T[] outputSequence,
                                                        T[] leftSequence,
                                                        T[] rightSequence){
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftSequence.length && j < rightSequence.length){
            if(leftSequence[i].compareTo(rightSequence[j]) < 0){
                outputSequence[k++] = leftSequence[i++];
            }else {
                outputSequence[k++] = rightSequence[j++];
            }
        }
        while (i < leftSequence.length){
            outputSequence[k++] = leftSequence[i++];
        }
        while (j < rightSequence.length){
            outputSequence[k++] = rightSequence[j++];
        }
    }
}
