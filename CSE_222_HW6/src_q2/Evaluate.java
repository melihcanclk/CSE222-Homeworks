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
    public void evaluateArr(T[] arr, Consumer<? super T[]> action, Class className){

        T[] arrcopy = arr.clone();
        System.out.println("Size = " + arrcopy.length);
        long start = System.nanoTime();
        action.accept(arrcopy);
        long finish = System.nanoTime();
        double timeMillis = (double) finish - start;
        System.out.println(className.getName()+ " = " + timeMillis/1000000000 + " seconds");

    }

    /**
     * Evaluating LinkedList to given function and printing the running time of the given function as seconds
     * @param ll LinkedList that will be evaluated
     * @param action Consumer class function that will be accepted
     * @param className Name of class that is sent. Reason of that parameter is that being able to print name of the
     *                  function that is called.
     */
    public void evaluateALl(LinkedList<T> ll, Consumer<LinkedList<T>> action, Class className){
        LinkedList<T> clone = (LinkedList<T>) ll.clone();
        System.out.println("Size = " + ll.size());
        long start = System.nanoTime();
        action.accept(clone);
        long finish = System.nanoTime();
        double timeMillis = (double) finish - start;
        System.out.println(className.getName()+ " = " + timeMillis/1000000000 + " seconds");

    }

}
