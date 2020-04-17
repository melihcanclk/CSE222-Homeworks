import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class CustomDeque<T> implements Deque<T> {
    /**
     * Main Linked List for keep values
     */
    private LinkedList<T> mainLinkedList;
    /**
     * Trash Linked List for keep deleted Nodes
     */
    private LinkedList<T> trashLinkedList;

    /**
     * Inner static ListNode Class
     * @param <T>
     */
    static class ListNode<T> {
        /**
         * The actual data
         */
        T data;
        /**
         * Reference to the next node
         */
        ListNode<T> next;
        /**
         * Reference to the prev node
         */
        ListNode<T> prev;
        /**
         * Constructor.
         * Note that the next and prev variables are set to null, thus this is the "root-node"
         *
         * @param data node data
         */
        ListNode(T data) {
            this(null, data, null);
        }
        /**
         * Constructor.
         *
         * @param data node data
         * @param next reference to next node
         * @param prev reference to the previous node
         */
        ListNode(ListNode<T> prev, T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Constructor
     */
    CustomDeque(){
        clear();
    }

    /**
     * Adding Element First
     */
    @Override
    public void addFirst(T e) {
        ListNode<T> newNode;
        if(trashLinkedList.isEmpty()){
            newNode = new ListNode<T>(null, e,null);
        }else {
            newNode = trashLinkedList.removeLast();
            newNode.data = e;
        }
        mainLinkedList.addFront(newNode);
    }

    /**
     * Adding Element Last
     * @param e
     */
    @Override
    public void addLast(T e) {
        ListNode<T> newNode;
        if(trashLinkedList.isEmpty()){
            newNode = new ListNode<T>(null, e,null);
        }else {
            newNode = trashLinkedList.removeLast();
            newNode.data = e;
        }
        mainLinkedList.addEnd(newNode);
    }

    /**
     * Offer Element First
     * @param e
     * @return true when adding completed
     */
    @Override
    public boolean offerFirst(T e) {
        addFirst(e);
        return true;
    }

    /**
     * Offer Element First
     * @param e
     * @return true when adding completed
     */
    @Override
    public boolean offerLast(T e) {
        addLast(e);
        return true;
    }

    /**
     * Remove First Element
     * @return Removed Data
     */
    @Override
    public T removeFirst() {
        ListNode<T> listNode = mainLinkedList.removeFirst();
        trashLinkedList.addEnd(listNode);
        return listNode.data;
    }

    /**
     * Remove Last Element
     * @return Removed Data
     */
    @Override
    public T removeLast() {
        ListNode<T> listNode = mainLinkedList.removeLast();
        trashLinkedList.addEnd(listNode);
        return listNode.data;
    }

    /**
     * Poll First Element
     * @return Pooled data
     */
    @Override
    public T pollFirst() {
        return removeFirst();
    }

    /**
     * Pool Last Element
     * @return Pooled data
     */
    @Override
    public T pollLast() {
        return removeLast();
    }

    /**
     * Getting First Element Data
     * @return First Element Data
     */
    @Override
    public T getFirst() {
        return mainLinkedList.getFirst();
    }
    /**
     * Getting Last Element Data
     * @return Last Element Data
     */
    @Override
    public T getLast() {
        return mainLinkedList.getLast();
    }

    /**
     * Peek First Element
     * @return First Element Data
     */
    @Override
    public T peekFirst() {
        if(mainLinkedList.isEmpty())
            return null;
        else {
            return getFirst();
        }
    }
    /**
     * Peek Last Element
     * @return Last Element Data
     */
    @Override
    public T peekLast() {
        if(mainLinkedList.isEmpty())
            return null;
        else {
            return getLast();
        }
    }

    /**
     * Remove first occurence of given object
     * @param o object will be removed
     * @return true if success false not
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        ListNode<T> listNode = mainLinkedList.head;
        while (listNode != null){
            if(listNode.data.equals(o)){
                deleteObject(listNode);
                return true;
            }
            listNode = listNode.next;
        }
        return false;
    }
    /**
     * Remove last occurence of given object
     * @param o object will be removed
     * @return true if success false not
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        ListNode<T> listNode = mainLinkedList.tail;
        while (listNode != null){
            if(listNode.data.equals(o)){
                deleteObject(listNode);
                return true;
            }
            listNode = listNode.prev;
        }
        return true;
    }

    /**
     * Adding given element beginning of deque
     * @param e value
     * @return if given object is not null
     */
    @Override
    public boolean add(T e) {
        if(e == null){
            throw new NullPointerException();
        }
        try{
            this.addFirst(e);
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * Adding given element beginning of deque
     * @param e value
     * @return if given object is not null
     */
    @Override
    public boolean offer(T e) {
        return add(e);
    }
    /**
     * Remove element beginning of deque
     * @return if given object is not null
     */
    @Override
    public T remove() {
        return removeFirst();
    }
    /**
     * Remove element beginning of deque
     * @return if given object is not null
     */
    @Override
    public T poll() {
        return remove();
    }

    /**
     * Returns first element but not delete
     * @return first element
     */
    @Override
    public T element() {
        return peekFirst();
    }

    /**
     * Look first element
     * @return null if linkedlist empty otherwise returns element
     */
    @Override
    public T peek() {
        if(mainLinkedList.isEmpty()){
            return null;
        }else {
            return element();
        }
    }

    /**
     * Unimplemented method
     * @param collection
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends T> collection) {
        try {
            throw new CustomNotImplementedException();
        } catch (CustomNotImplementedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Unimplemented method
     * @param collection
     * @return
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        try {
            throw new CustomNotImplementedException();
        } catch (CustomNotImplementedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Unimplemented method
     * @param collection
     * @return
     */
    @Override
    public boolean retainAll(Collection<?> collection) {
        try {
            throw new CustomNotImplementedException();
        } catch (CustomNotImplementedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Clears either either deque or trash
     */
    @Override
    public void clear() {
        mainLinkedList = new LinkedList<>();
        trashLinkedList = new LinkedList<>();
    }

    /**
     * Pushes beginning of deque
     * @param e element will be pushed
     */
    @Override
    public void push(T e) {
        addFirst(e);
    }

    /**
     * pop first element at deque
     * @return removed element
     */
    @Override
    public T pop() {
        return removeFirst();
    }

    /**
     * Remove given Object
     * @param o Object will be removed
     * @return true if remove operation successful
     */
    @Override
    public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }
    /**
     * Unimplemented method
     * @param collection
     * @return
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        try {
            throw new CustomNotImplementedException();
        } catch (CustomNotImplementedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Determine if deque contains given element
     * @param o Object will be searched
     * @return True if contains otherwise returns False
     */
    @Override
    public boolean contains(Object o) {
        ListNode<T> listNode = mainLinkedList.head;
        while (listNode != null){
            if(listNode.data.equals(o)){
                return true;
            }
            listNode = listNode.next;
        }
        return false;
    }

    /**
     * Size of Deque
     * @return Size of Deque
     */
    @Override
    public int size() {
        return mainLinkedList.size();
    }

    /**
     * Determine if Deque is empty or not
     * @return if deque is empty, return true; else false
     */
    @Override
    public boolean isEmpty() {
        return mainLinkedList.head == null;
    }
/**
 * Creating new Iterator
 */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int current = 0;
            ListNode<T> node = null;
            ListNode<T> nextNode = mainLinkedList.head;
            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public T next() {
                current++;
                node = nextNode;
                nextNode = nextNode.next;
                return node.data;
            }
        };
    }

    /**
     * Converts Deque To Object array
     * @return Object []
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    /**
     * Unimplemented method
     * @param ts array
     * @return <T> array []
     */
    @Override
    public <T> T[] toArray(T[] ts) {
        try {
            throw new CustomNotImplementedException();
        } catch (CustomNotImplementedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creating new Descending Iterator
     * @return Iterator <T>
     */
    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            int current = 0;
            ListNode<T> node = null;
            ListNode<T> prevNode = mainLinkedList.tail;
            @Override
            public boolean hasNext() {
                return prevNode != null;
            }

            @Override
            public T next() {
                current++;
                node = prevNode;
                prevNode = prevNode.prev;
                return node.data;
            }
        };
    }

    /**
     * Deleting Given object and add to trash Linked List
     * @param listNode List Node will be deleted
     */
    private void deleteObject(ListNode<T> listNode){
        ListNode<T> temp;
        if(listNode == mainLinkedList.head){
            temp = mainLinkedList.head;
            listNode = listNode.next;
            mainLinkedList.head = listNode;
            temp.next = null;
            listNode.prev = null;
        }else if(listNode == mainLinkedList.tail){
            temp = mainLinkedList.tail.prev;
            temp.next = null;
            listNode.prev = null;
        }else {
            temp = listNode;
            listNode.prev.next = listNode.next;
            listNode.next.prev = listNode.prev;
            listNode.next = null;
            listNode.prev = null;
        }
        trashLinkedList.addEnd(temp);
    }

    /**
     * To String Method
     * @return String will be printed
     */
    @Override
    public String toString() {
        return"Deque=" + mainLinkedList;
    }
}
