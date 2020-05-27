import java.util.LinkedList;
import java.util.function.Consumer;

public class Evaluate <T> {
    /**
     * Evaluating Array to given function and printing the running time of the given function as seconds
     * @param arr Array that will be evaluated
     * @param action Consumer class function that will be accepted
     * @return Running time of given action
     */
    public long evaluateArr(T[] arr, Consumer<? super T[]> action){
        long timeMillis = 0;
        T[] arrcopy = arr.clone();
        long start = System.nanoTime();
        action.accept(arrcopy);
        long finish = System.nanoTime();
        timeMillis = ( finish - start);
        arrcopy = null;
        return timeMillis;
    }

    /**
     * Evaluating LinkedList to given function and printing the running time of the given function as seconds
     * @param ll LinkedList that will be evaluated
     * @param action Consumer class function that will be accepted
     * @return Running time of given action
     */
    public long evaluateALl(LinkedList<T> ll, Consumer<LinkedList<T>> action){
        long timeMillis = 0;
        LinkedList<T> clone = (LinkedList<T>) ll.clone();
        long start = System.nanoTime();
        action.accept(clone);
        long finish = System.nanoTime();
        timeMillis = ( finish - start);
        clone = null;
        return timeMillis;
    }

}
