import java.util.LinkedList;
import java.util.function.Consumer;

public class Evaluate <T> {
    /**
     * Evaluating Array to given function and printing the running time of the given function as seconds
     * @param arr Array that will be evaluated
     * @param action Consumer class function that will be accepted
     * @param className Name of class that is sent. Reason of that parameter is that being able to print name of the
     *                  function that is called.
     */
    public double evaluateArr(T[] arr, Consumer<? super T[]> action, Class className, int numberOfArrays){
        double timeMillis = 0.0;
        for(int i = 0; i< numberOfArrays;i++){
            T[] arrcopy = arr.clone();
            long start = System.nanoTime();
            action.accept(arrcopy);
            long finish = System.nanoTime();
            timeMillis =+ ((double) finish - start);
        }
        return timeMillis;
    }

    /**
     * Evaluating LinkedList to given function and printing the running time of the given function as seconds
     * @param ll LinkedList that will be evaluated
     * @param action Consumer class function that will be accepted
     * @param className Name of class that is sent. Reason of that parameter is that being able to print name of the
     *                  function that is called.
     */
    public double evaluateALl(LinkedList<T> ll, Consumer<LinkedList<T>> action, Class className,int numberOfArrays){
        double timeMillis = 0.0;
        for(int i = 0; i< numberOfArrays;i++) {
            LinkedList<T> clone = (LinkedList<T>) ll.clone();
            long start = System.nanoTime();
            action.accept(clone);
            long finish = System.nanoTime();
            timeMillis =+ ((double) finish - start);
        }
        return timeMillis;
    }

}
