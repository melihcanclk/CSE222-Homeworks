import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaxHeap<E extends Comparable<E>> {

    private final ArrayList<E> arraylist;

    MaxHeap(){
        arraylist = new ArrayList<>();
    }
    MaxHeap(E root){
        arraylist = new ArrayList<>();
        //Root
        arraylist.add(root);
    }
    public E find(E item){
        int result = 1;
        for (E e : arraylist) {
            result = item.compareTo(e);
            if(result == 0)
                return e;
        }
        return null;
    }
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
                        if(arraylist.get(i).compareTo(e) > 0){
                            Collections.swap(arraylist,i,arraylist.indexOf(e));
                            return;
                        }
                    }
                }
            }
        }
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : arraylist) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }

    public int youngerThan(int i) {
        AgeData ageData = new AgeData(i);
        E object = (E)ageData;
        return youngerThan(object);
    }
    public int olderThan(int i) {
        AgeData ageData = new AgeData(i);
        E object = (E)ageData;
        return olderThan(object);
    }
}
