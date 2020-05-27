import java.util.LinkedList;
import java.util.ListIterator;

public class QuickSortLL {
    public static <T extends Comparable<T>> void sort(LinkedList<T> table){
        quicksort(table,0,table.size() - 1);
    }

    private static <T extends Comparable<T>> void quicksort(LinkedList<T> table, int first, int last) {
        if(first < last){
            ListIterator<T> first_iter = table.listIterator(first);
            ListIterator<T> last_iter = table.listIterator(last);
            int pivIndex = partition(table,first_iter,last_iter);
            quicksort(table,first,pivIndex - 1);
            quicksort(table,pivIndex + 1,last);
        }
    }
    private static <T extends Comparable<T>> int partition(LinkedList<T> table, ListIterator<T> first_iter, ListIterator<T> last_iter){
        ListIterator<T> middle_iter = bubbleSort3(table, first_iter,last_iter);
        swap(table,first_iter,middle_iter);
        T pivot = first_iter.next();
        first_iter.previous();
        ListIterator<T> up = table.listIterator(first_iter.nextIndex());
        ListIterator<T> down = table.listIterator(last_iter.nextIndex());
        do {
            while(up.nextIndex() < down.previousIndex() && (pivot.compareTo(up.next()) >= 0) );
            if(up.nextIndex() < down.previousIndex())
                up.previous();
            while (pivot.compareTo(down.previous()) < 0);

            if(up.nextIndex() < down.nextIndex()){
                swap(table,up,down);
            }
        }while (up.nextIndex() < down.nextIndex());

        swap(table,first_iter,down);
        return down.nextIndex();
    }

    private static <T extends Comparable<T>> ListIterator<T> bubbleSort3(LinkedList<T>table,
                                                              ListIterator<T> first_iter, ListIterator<T> last_iter){

        ListIterator<T> middle_iter = table.listIterator((first_iter.nextIndex() + last_iter.nextIndex()) / 2);
        boolean isEntered = false;
        if(middle_iter.next().compareTo(first_iter.next()) < 0){
            first_iter.previous();
            middle_iter.previous();
            swap(table, first_iter,middle_iter);
            isEntered = true;
        }
        if(!isEntered){
            first_iter.previous();
            middle_iter.previous();
        }
        isEntered = false;
        if(last_iter.next().compareTo(middle_iter.next())< 0){
            last_iter.previous();
            middle_iter.previous();
            swap(table, last_iter,middle_iter);
            isEntered = true;
        }
        if(!isEntered){
            last_iter.previous();
            middle_iter.previous();
        }
        isEntered = false;
        if(middle_iter.next().compareTo(first_iter.next())< 0){
            middle_iter.previous();
            first_iter.previous();
            swap(table, middle_iter,first_iter);
            isEntered = true;
        }
        if(!isEntered){
            middle_iter.previous();
            first_iter.previous();
        }

        return middle_iter;
    }

    private static <T extends Comparable<T>> void swap(LinkedList<T> table, ListIterator<T> i , ListIterator<T> j) {
        T temp = i.next();
        i.previous();
        i.set(j.next());
        j.previous();
        j.set(temp);
    }
}
