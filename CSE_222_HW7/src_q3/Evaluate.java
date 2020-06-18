import java.util.function.Consumer;

public class Evaluate<T> {
    /**
     * Evaluation of array
     * @param arr array that will be used for action
     * @param action consumer action that will be running time computed
     * @return long type running type with nanoseconds
     */
    public long evaluateArr(T[] arr, Consumer<? super T> action){
        long timeMillis = 0;
        long start = System.nanoTime();
        for (int i = 0; i< arr.length; i++) {
            action.accept(arr[i]);
        }
        long finish = System.nanoTime();
        timeMillis = ( finish - start);
        return timeMillis;
    }
}
