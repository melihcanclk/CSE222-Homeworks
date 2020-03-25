import java.util.*;

class LinkedList<T> extends AbstractList<T> implements List<T>
{

    private Node head, last;
    private int capacity_of_all_arrays;

    private class Node
    {
        DynamicArray<T> data;
        Node next;
        Node before;
        public Node(Object n)
        {
            data = (DynamicArray) n;
            next = null;
            before = null;
        }

        public Node() {

        }
    }

    public class LinkedArrayListIterator implements java.util.Iterator<T> {

        private int current = 0;

        Node node;
        LinkedArrayListIterator(){
            node = head;
            current = 0;
        }

        @Override
        public boolean hasNext() {
            if(node == null){
                return false;
            }
            if(current < node.data.size())
                return true;
            else if(current >= node.data.size() && node.next != null){
                current = 0;
                node = node.next;
                return true;
            } else
                return false;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return (T) node.data.getElement(current++);
        }

        @Override
        public void remove() {
            node.data.remove(current);
            if(node.data.size() == 0){
                head = node.next;
                node = node.next;
            }

        }
    }

    public LinkedList(int capacity_of_all_arrays)
    {
        head = null;
        last = null;
        this.capacity_of_all_arrays = capacity_of_all_arrays;
    }

    @Override
    public boolean add(T a)
    {
        if(last == null)
        {
            clear();
        }
        else if(last != null){
            if(last.data.size() == last.data.capacity()){
                DynamicArray<T> dynamicArray = new DynamicArray<>(capacity_of_all_arrays);
                Node t = new Node(dynamicArray);
               last.next = t;
               t.before = last;
               last = t;

            }
        }
        last.data.addElement(a);
        return true;
    }
    @Override
    public T get(int a)
    {
        Node it = head;
        int contor = 0;
        while(it!=null && contor<a)
        {
            it = it.next;
            contor++;
        }

        if(it!=null)
        {
            return (T) it;
        }
        else
            return null;
    }

    @Override
    public Object set(int i, Object a)
    {
        Node it = head;
        int contor = 0;
        Node aux;
        while(it!=null && contor<i)
        {
            it = it.next;

        }
        if(it!=null)
        {
            aux = it;
            it.data = (DynamicArray) a;
            return aux;
        }
        else
            return null;
    }

    @Override
    public int size()
    {
        Node it = head;
        int contor = 0;
        while(it!=null)
        {
            contor++;
            it = it.next;
        }
        return contor;
    }

    @Override
    public int indexOf(Object a)
    {
        Node traverse = new Node();
        traverse = head;
        while (traverse != null){

            for (int i = 0; i< traverse.data.size(); ++i){
                if(traverse.data.getElement(i).equals(a)){
                    return i;
                }
            }
            traverse = traverse.next;

        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        Node currNode = this.head;
        while (currNode != null){
            stringBuilder.append(currNode.data.toString());
            currNode = currNode.next;
        }

        return stringBuilder.toString();
    }

    @Override
    public void add(int index, T element) {
        try {
            if(index >= 0 && index < size()){
                Node node = new Node();
                node = head;
                for (int i = 0; i< index; i++){
                    node = node.next;
                }
                if(node.data.size() != capacity_of_all_arrays){
                    node.data.addElement(element);
                }else {
                    System.out.println(element + " couldn't be added to index " + index + "." +
                            " So element added to end of the LinkedArrayList.");
                    add(element);
                }
            }

        }catch (IndexOutOfBoundsException exception){
            System.out.println(exception);
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        return super.lastIndexOf(o);
    }

    @Override
    public void clear() {
        DynamicArray<T> dynamicArray = new DynamicArray<>(this.capacity_of_all_arrays);
        Node t = new Node(dynamicArray);
        head = t;
        last = t;
        last.next = null;
        head.before = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedArrayListIterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        return super.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return super.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public Object[] toArray() {
        return super.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return super.toArray(a);
    }

    /**
     * Delete An Element from LinkedArrayList
     * @param o Element that will be deleted from any list that is seen first.
     * @return Returns if remove operation is done correctly or not
     */
    @Override
    public boolean remove(Object o) {
        Node traverse = new Node();
        traverse = head;
        while (traverse != null){

            for (int i = 0; i< traverse.data.size(); ++i){
                if(traverse.data.getElement(i).equals(o)){
                    traverse.data.remove(i);
                    if(traverse.data.size() == 0){
                        traverse.before.next = null;
                        last = traverse.before;
                        return true;
                    }
                }
            }
            traverse = traverse.next;

        }
        return false;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
