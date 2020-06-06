import java.util.function.Consumer;

public class Evaluate<T> {
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
