import java.util.Comparator;

class CustomComperator<E extends Comparable<E>> implements Comparator<E> {
    /**
     * Compare object 1 and object 2
     * @param o1 Class one
     * @param o2 Class two
     * @return result of o1 and o2 compareTo method
     */
    @Override
    public int compare(E o1, E o2) {
        return o2.compareTo(o1);
    }


}
