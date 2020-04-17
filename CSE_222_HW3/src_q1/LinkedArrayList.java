import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Arrays;
//Arraylist for sublist method implementation
import java.util.ArrayList;

public class LinkedArrayList<T> extends AbstractList<T> implements List<T>
{

    private Node head, last;
    private int capacity_of_all_arrays;

    private class Node
    {
        /**
         * Array that holds T type
         */
        private T[] array;

        /**
         * holds the current size of array
         */
        private int size;
        /**
         * holds the total capacity of array
         */
        private int capacity;

        Node next;
        Node before;

        /**
         * Node for hold information
         * @param capacity constant capacity of array
         */
        private Node(int capacity) {
            next = null;
            before = null;
            array = (T[])new Object[capacity];
            this.capacity = capacity;
        }

        /**
         * Setting value of element that is given by index
         * @param element element that will be changed
         * @param index index that is given
         */
        private void setIndex(T element, int index){
            System.out.println("Object at " + index + " will be replaced by " + element);
            array[index] = element;
        }

        /**
         * Setting data
         * @param t element
         * @param current current index
         */
        private void setData(T t, int current) {
            setIndex(t,current);
        }

        /**
         * to get the current size
         * @return size of array
         */
        private int size(){
            return size;
        }
        /**
         *  to get the current capacity
         * @return capacity of array
         */
        private int capacity(){
            return capacity;
        }

        /**
         *  to add an element at the end
         * @param element element will be add
         */
        private void addElement(T element) throws ArrayIndexOutOfBoundsException{
            try{
                array[size] = element;
                size++;
            }catch (ArrayIndexOutOfBoundsException exception){
                System.out.println(exception);
            }
        }
        /**
         * to get an element at an index
         * @param index index of element that will be taken
         * @return T type
         */
        private T getElement(int index){
            return array[index];
        }

        /**
         * to remove an element at a particular index
         * @param index index of array
         */
        private void remove(int index){
            if(index>=size || index<0){
                System.out.println("No element at this index");
            }else{
                for(int i=index;i<size-1;i++){
                    array[i] = array[i+1];
                }
                array[size-1]=null;
                size--;
            }
        }


        @Override
        public String toString() {
            return Arrays.toString(array);
        }
    }

    /**
     * LinkedArrayIterator for iterate over array and linkedlist
     * @param <E> generic tyoe
     */
    protected class LinkedArrayIterator<E> implements java.util.Iterator<E> {

        protected int current = 0;
        protected Node node;

        /**
         * Constructor for LinkedArrayList class
         */
        LinkedArrayIterator(){
            node = head;
            current = 0;
        }

        /**
         * Check if next item null or not
         * @return if next node is not null, returns true otherwise returns false
         */
        @Override
        public boolean hasNext() {
            if(node == null){
                return false;
            }
            if(current < node.size())
                return true;
            else if(current >= node.size() && node.next != null){
                current = 0;
                node = node.next;
                return true;
            } else
                return false;
        }

        /**
         * Getting next index
         * @return next index
         */
        @Override
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return (E) node.getElement(current++);

        }

        /**
         * Removing last element
         */
        @Override
        public void remove() {
            node.remove(current);
            if(node.size() == 0){
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

        /**
         * toString method
         * @return current index value
         */
        @Override
        public String toString() {
            return node.getElement(current).toString();
        }
    }

    /**
     * LinkedArrayListIterator list iterator
     * @param <E> generic type
     */
    protected class LinkedArrayListIterator<E> extends LinkedArrayIterator<E> implements ListIterator<E> {

        /**
         * LinkedArrayListIterator constructor
         */
        LinkedArrayListIterator(){
            super();
        }

        /**
         * Check if next item null or not
         * @return if next node is not null, returns true otherwise returns false
         */
        @Override
        public boolean hasNext() {
            return super.hasNext();
        }
        /**
         * Getting next index
         * @return next index
         */
        @Override
        public E next() {
            return super.next();
        }
        /**
         * Check if previous item null or not
         * @return if previous node is not null, returns true otherwise returns false
         */
        @Override
        public boolean hasPrevious() {
            if(node == null){
                return false;
            }
            if(current < node.size())
                return true;
            else if(current < 0 && node.before != null){
                current = 0;
                node = node.before;
                return true;
            } else
                return false;
        }
        /**
         * Getting previous index
         * @return previous index
         */
        @Override
        public E previous() {
            if(!hasPrevious())
                throw new NoSuchElementException();
            return (E) node.getElement(current--);
        }

        /**
         * getting next index
         * @return next index int value
         */
        @Override
        public int nextIndex() {
            return ((current == size()) ? 0 : current+1);
        }
        /**
         * getting previous index
         * @return previous index int value
         */
        @Override
        public int previousIndex() {
            return ((current < 0) ? capacity_of_all_arrays-1 : current-1);
        }

        /**
         * remove current element
         */
        @Override
        public void remove() {
            super.remove();
        }

        /**
         * Set t value to this value
         * @param t value will be changed to
         */
        @Override
        public void set(E t) {
            node.setData((T) t,current);
        }

        /**
         * Adding value
         * @param t value that will be added
         */
        @Override
        public void add(E t) {
            LinkedArrayList.this.add((T) t);
        }

    }

    /**
     * Constructor of LinkedArrayList
     * @param capacity_of_all_arrays constant capacity
     */
    public LinkedArrayList(int capacity_of_all_arrays)
    {
        Node t = new Node(capacity_of_all_arrays);
        head = t;
        last = t;
        this.capacity_of_all_arrays = capacity_of_all_arrays;
    }

    /**
     * LinkedArrayList add method
     * @param a value that will be added
     * @return if adding is successful, returns true otherwise false
     */
    @Override
    public boolean add(T a)
    {
        if(last == null)
        {
            clear();
        }
        else {
            if(last.size() == last.capacity()){
                Node t = new Node(capacity_of_all_arrays);
               last.next = t;
               t.before = last;
               last = t;

            }
        }
        System.out.println("Item that will be add is " + a);
        last.addElement(a);
        return true;
    }

    /**
     * Getting value according to given index
     * @param a index
     * @return value
     */
    @Override
    public T get(int a)
    {
        ListIterator<T> listIterator = listIterator(a);
        T t = listIterator.next();
        return t;
    }

    /**
     * setting value to given index
     * @param i index
     * @param a object will be added
     * @return object that is set
     */
    @Override
    public Object set(int i, Object a)
    {
        ListIterator<T> listIterator = listIterator(i);
        T t = listIterator.next();
        listIterator.previous();
        listIterator.set((T) a);
        return t;
    }

    /**
     * Calculate size of LinkedArrayList
     * @return Size
     */
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

    /**
     * Getting index of a object
     * @param a object that has to be searched
     * @return index, if not found, return -1
     */
    @Override
    public int indexOf(Object a)
    {
        Node traverse= head;
        int node_number = 1;
        while (traverse != null){

            for (int i = 0; i< traverse.size(); ++i){
                if(traverse.getElement(i).equals(a)){
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
    public void add(int index, T element) {
        try {
            if(index >= 0 && index < size()){
                Node node = head;
                for (int i = 0; i< index; i++){
                    node = node.next;
                }
                if(node.size() != capacity_of_all_arrays){
                    System.out.println("Object will be added to node" + (index+1));
                    node.addElement(element);
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

    /**
     * Getting last index of specified element
     * @param o Object that will be searched
     * @return last index of Object
     */
    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = 0;
        int counter = 0;
        T element = (T) o;
        Iterator<T> iterator = iterator();
        while(iterator.hasNext()){
            T element_of_index = (T) iterator.next();
            if(element == element_of_index)
                lastIndex = counter;
            counter++;
        }
        return lastIndex;
    }

    /**
     * Clearing all LinkedArrayList
     */
    @Override
    public void clear() {
        Node t = new Node(capacity_of_all_arrays);
        head = t;
        last = t;
        last.next = null;
        head.before = null;
    }

    /**
     * Creating new LinkedArrayIterator
     * @return Iterator<T>
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedArrayIterator<>();
    }
    /**
     * Creating new LinkedArrayListIterator
     * @return ListIterator<T>
     */
    @Override
    public ListIterator<T> listIterator() {
        return new LinkedArrayListIterator();
    }
    /**
     * Creating new LinkedArrayListIterator to specified index
     * @return ListIterator<T>
     */
    @Override
    public ListIterator<T> listIterator(int index) {

        LinkedArrayListIterator<T> linkedArrayListIterator = new LinkedArrayListIterator<>();
        for (int i = 0; i< index; i++){
            if(linkedArrayListIterator.hasNext())
                linkedArrayListIterator.next();
            else
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return linkedArrayListIterator;
    }

    /**
     * Creates sublist from given index to given index
     * @param fromIndex starting index
     * @param toIndex end index
     * @return List<T>
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> list = new ArrayList<>() ;
        for(int i = fromIndex; i< toIndex; i++)
            list.add(i,get(i));
        return list;
    }

    /**
     * Check whether two objects are equal or not
     * @param o Object that will be compared
     * @return if equal, return true otherwise return false
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    /**
     * Not implemented method
     * @param fromIndex -
     * @param toIndex -
     */
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        try {
            throw new NotImplementedException();
        } catch (NotImplementedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check whether LinkedArrayList empty or not
     * @return if LinkedArrayList empty, returns true otherwise returns false
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Check LinkedArrayList contains o Object or not
     * @param o Object that is compared
     * @return if LinkedArrayList contains o Object returns true, otherwise returns false
     */
    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    /**
     * Convert LinkedArrayList to Object array
     * @return Object []
     */
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
        Node traverse = head;
        if(traverse.size() == 0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            while (traverse != null){
                for (int i = 0; i< traverse.size(); ++i){
                    if(traverse.getElement(i).equals(o)){
                        traverse.remove(i);
                        if(traverse.size() == 0){
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
        }
        return false;
    }

    /**
     * Printing arrays
     * @return String that includes arrays
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        Node currNode = this.head;
        while (currNode != null){
            stringBuilder.append(currNode.toString());
            currNode = currNode.next;
        }

        return stringBuilder.toString();
    }
}
