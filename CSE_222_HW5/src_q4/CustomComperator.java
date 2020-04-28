import java.util.Comparator;

class CustomComperator<E extends Comparable<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o2.compareTo(o1);
    }


}
