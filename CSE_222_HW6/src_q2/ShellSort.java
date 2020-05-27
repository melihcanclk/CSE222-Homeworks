public class ShellSort {
    /**
     * Sort method  that takes table and sorts according to Shell Sort Algorithm
     * @param table Generic table
     * @param <T> Generic type Class that implements Comperable interface
     */
    public static <T extends Comparable<T>> void sort(T[] table){
        int gap = table.length / 2;
        while (gap>0){
            for (int nextPos = gap;nextPos < table.length;nextPos++){
                insert(table,nextPos,gap);
            }
            if(gap == 2){
                gap = 1;
            }else {
                gap = (int) (gap/2.2);
            }
        }
    }

    /**
     * private Insert method
     * @param table Table that will be done operations on
     * @param nextPos Next position
     * @param gap Gap between current index and next position
     * @param <T> Generic Class Type that implements Comperable interface
     */
    private static <T extends Comparable<T>>void insert(T[] table, int nextPos, int gap) {
        T nextVal = table[nextPos];
        while ((nextPos > gap - 1) && (nextVal.compareTo(table[nextPos - gap]) < 0)){
            table[nextPos] = table[nextPos - gap];
            nextPos -= gap;
        }
        table[nextPos] = nextVal;
    }
}
