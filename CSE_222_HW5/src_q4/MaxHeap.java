import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaxHeap<E extends Comparable<E>> {
    /**
     * Arraylist for hold Max-Heap
     */
    private final ArrayList<E> arraylist;

    /**
     * Constructor of MaxHeap
     */
    MaxHeap(){
        arraylist = new ArrayList<>();
    }

    /**
     * Constructor of Maxheap
     * @param root root of MaxHeap
     */
    MaxHeap(E root){
        arraylist = new ArrayList<>();
        //Root
        arraylist.add(root);
    }

    /**
     * Finding item
     * @param item item that will be found
     * @return If Arraylist includes item, returns 0, otherwise returns null
     */
    public E find(E item){
        int result = 1;
        for (E e : arraylist) {
            result = item.compareTo(e);
            if(result == 0)
                return e;
        }
        return null;
    }

    /**
     * Adding new item
     * @param item item will be add
     */
    public void add(E item){
        E resultOfFind = find(item);
        int indexOfNewElement;
        if(resultOfFind != null){
            indexOfNewElement = arraylist.indexOf(resultOfFind);
        }else {
            arraylist.add(item);
            indexOfNewElement = arraylist.size() - 1;
        }
        common(indexOfNewElement);
    }

    /**
     * Remove item
     * @param item Item will be removed
     */
    public void remove(E item){
        E resultOfFind = find(item);
        int indexOfNewElement;
        if(resultOfFind != null){
            indexOfNewElement = arraylist.indexOf(resultOfFind);
            Collections.swap(arraylist,arraylist.indexOf(resultOfFind), arraylist.size() - 1);
            arraylist.remove(arraylist.size() - 1);
            common(indexOfNewElement);
        }else{
            for (E e : arraylist) {
                boolean result = e.equals(item);
                if(result){
                    for(int i = 0; i< arraylist.size(); i++){
                        if(arraylist.get(i).compareTo(e) > 0) {
                            int index = arraylist.indexOf(e);
                            if(index < i){
                                Collections.swap(arraylist, i, index);
                                return;
                            }
                        }else if(arraylist.get(i).compareTo(e) < 0){
                            int index = arraylist.indexOf(e);
                            if(index > i){
                                Collections.swap(arraylist, i, index);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Common method that both add and remove methods
     * @param indexOfNewElement Index of element
     */
    private void common(int indexOfNewElement){
        int result = 1;
        CustomComperator<E> comparator = new CustomComperator<>();
        result = comparator.compare(arraylist.get(indexOfNewElement), arraylist.get((indexOfNewElement - 1) / 2));
        while(indexOfNewElement != 0 && result < 0){
            Collections.swap(arraylist, indexOfNewElement, (indexOfNewElement - 1) / 2);
            indexOfNewElement = (indexOfNewElement - 1) / 2;
            result = comparator.compare(arraylist.get(indexOfNewElement), arraylist.get((indexOfNewElement - 1) / 2));
        }
    }

    /**
     * Number of people that is younger than item that is given
     * @param item Item that will be compared
     * @return Number of people that is younger than item
     */
    private int youngerThan(E item){

        int total = 0;
        for(E e: arraylist){
            if(e.compareTo(item) < 0){
                AgeData temp = (AgeData)e;
                total += temp.getNumberOfPeople();
            }
        }
        return total;
    }

    /**
     * Number of people that is older than item that is given
     * @param item Item that will be compared
     * @return Number of people that is older than item
     */
    private int olderThan(E item){
        int total = 0;
        for(E e: arraylist){
            if(e.compareTo(item) > 0){
                AgeData temp = (AgeData)e;
                total += temp.getNumberOfPeople();
            }
        }

        return total;
    }

    /**
     * toString Method
     * @return String that will be printed
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : arraylist) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }

    /**
     * Number of people that is younger than item that is given
     * @param i Age
     * @return Number of people that is older than item
     */
    public int youngerThan(int i) {
        AgeData ageData = new AgeData(i);
        E object = (E)ageData;
        return youngerThan(object);
    }

    /**
     * Number of people that is older than item that is given
     * @param i Age
     * @return Number of people that is older than item
     */
    public int olderThan(int i) {
        AgeData ageData = new AgeData(i);
        E object = (E)ageData;
        return olderThan(object);
    }
}
