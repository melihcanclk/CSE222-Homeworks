import java.util.Iterator;
import java.util.LinkedList;

public class MergeSortLL {
    public static <T extends Comparable<T>> void sort(LinkedList<T> table){
        if(table.size() > 1){
            int halfSize = table.size() / 2;
            LinkedList<T> first = new LinkedList<T>();
            LinkedList<T> second = new LinkedList<T>();
            Iterator<T> iterator = table.iterator();
            for (int i = 0; i< halfSize && iterator.hasNext();i++){
                first.add(iterator.next());
            }
            for (int i = 0; i< table.size() - halfSize && iterator.hasNext();i++){
                second.add(iterator.next());
            }
            sort(first);
            sort(second);
            merge(table,first,second);
        }
    }
    private static <T extends Comparable<T>> void merge(LinkedList<T> outputSequence,
                                                        LinkedList<T> leftSequence,
                                                        LinkedList<T> rightSequence){
        int i = 0;
        int j = 0;
        int k = 0;
        Iterator<T> iterator_left = leftSequence.iterator();
        Iterator<T> iterator_right = rightSequence.iterator();

        while (iterator_left.hasNext() && iterator_right.hasNext()){
            T element_left = iterator_left.next();
            T element_right = iterator_right.next();
            if(element_left.compareTo(element_right) < 0){
                outputSequence.add(element_left);
            }else {
                outputSequence.add(element_right);
            }
        }
        while (iterator_left.hasNext()){
            T element_left = iterator_left.next();
            outputSequence.add(element_left);
        }
        while (iterator_right.hasNext()){
            T element_right = iterator_right.next();
            outputSequence.add(element_right);
        }
    }
}
