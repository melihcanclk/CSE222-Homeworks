import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Iterator;

class LinkedArrayList<T> extends AbstractList<T> implements List<T>
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
            data = (DynamicArray<T>) n;
            next = null;
            before = null;
        }

        public Node() {

        }

        public void setData(T t, int current) {
            data.setIndex(t,current);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    protected class LinkedArrayIterator<E> implements java.util.Iterator<E> {

        public int current = 0;
        public Node node;

        LinkedArrayIterator(){
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
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return (E) node.data.getElement(current++);

        }

        @Override
        public void remove() {
            node.data.remove(current);
            if(node.data.size() == 0){
                if(node == head)
                    if(head.next != null){
                        head = head.next;
                        node = head;
                    }else{
                        head = null;
                    }
                else if(node == last){
                    last = node.before;
                    last.next = null;
                } else {
                    node.before.next = node.next;
                }
            }

        }
        @Override
        public String toString() {
            return node.data.getElement(current).toString();
        }
    }

    protected class LinkedArrayListIterator<E> extends LinkedArrayIterator<E> implements ListIterator<E>{

        private Node node;
        LinkedArrayListIterator(){
            node = head;
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return super.hasNext();
        }

        @Override
        public E next() {
            return super.next();
        }

        @Override
        public boolean hasPrevious() {
            if(node == null){
                return false;
            }
            if(current < node.data.size())
                return true;
            else if(current < 0 && node.before != null){
                current = 0;
                node = node.before;
                return true;
            } else
                return false;
        }

        @Override
        public E previous() {
            if(!hasPrevious())
                throw new NoSuchElementException();
            return (E) node.data.getElement(current--);
        }

        @Override
        public int nextIndex() {
            return ((current == size()) ? 0 : current+1);
        }

        @Override
        public int previousIndex() {
            return ((current < 0) ? capacity_of_all_arrays-1 : current-1);
        }

        @Override
        public void remove() {
            super.remove();
        }

        @Override
        public void set(E t) {
            node.setData((T) t,current);
        }

        @Override
        public void add(E t) {
            DynamicArray<E> dynamicArray = new DynamicArray<>(capacity_of_all_arrays);
            dynamicArray.addElement(t);
            Node temp = new Node(dynamicArray);
            if(node == last){
                temp.before = node;
                node.next = temp;
                last = temp;
            }else if(node == head){
                temp.next = node;
                node.before = temp;
                head = temp;
            }else {
                temp.next = node.next;
                node.next.before = temp;
                temp.before = node;
                node.next = temp;
            }

        }

    }

    public LinkedArrayList(int capacity_of_all_arrays)
    {
        head = null;
        last = null;
        this.capacity_of_all_arrays = capacity_of_all_arrays;
    }

    @Override
    public boolean add(T a)
    {
        if (head == null){
            DynamicArray<T> dynamicArray = new DynamicArray<>(capacity_of_all_arrays);
            Node t = new Node(dynamicArray);
            head = t;
            last = t;
        }
        else if(last == null)
        {
            clear();
        }
        else {
            if(last.data.size() == last.data.capacity()){
                DynamicArray<T> dynamicArray = new DynamicArray<>(capacity_of_all_arrays);
                Node t = new Node(dynamicArray);
               last.next = t;
               t.before = last;
               last = t;

            }
        }
        System.out.println("Item that will be add is " + a);
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
            it.data = (DynamicArray<T>) a;
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
        int node_number = 1;
        while (traverse != null){

            for (int i = 0; i< traverse.data.size(); ++i){
                if(traverse.data.getElement(i).equals(a)){
                    System.out.println("Index of " + a + " is " + i + " where node " + node_number);
                    return i;
                }
            }
            traverse = traverse.next;
            ++node_number;
        }
        return -1;
    }

    /**
     * Deleting Any Given indexed node
     * @param index Index of any given node that will be deleted
     * @return null because Class that I removed is a Node which is private class inside of
     * my class hierarchy so I decided to not return what I removed because I can't return
     * any T type.
     */
    @Override
    public T remove(int index) {
        ListIterator<T> iterator = listIterator(index);
        System.out.println("Index " + index + " will be deleted by using iterator");
        iterator.remove();
        return null;
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
                Node node = head;
                for (int i = 0; i< index; i++){
                    node = node.next;
                }
                if(node.data.size() != capacity_of_all_arrays){
                    System.out.println("Object will be added to node" + (index+1));
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
        return new LinkedArrayIterator<>();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new LinkedArrayListIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {

        LinkedArrayListIterator<T> linkedArrayListIterator = new LinkedArrayListIterator<>();
        for (int i = 0; i< index; i++){
            if(linkedArrayListIterator.hasNext())
                linkedArrayListIterator.next();
            else
                throw new IndexOutOfBoundsException("Out of Bounds");
        }
        return linkedArrayListIterator;
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
                    }
                    System.out.println(o + " deleted.");
                    return true;
                }
            }
            traverse = traverse.next;

        }
        System.out.println("No element such as " + o);
        return false;
    }
}
