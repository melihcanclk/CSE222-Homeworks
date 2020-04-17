import java.util.NoSuchElementException;

public class LinkedList<T> {
    // Front / head node
    public CustomDeque.ListNode<T> head;
    // Tail Node
    public CustomDeque.ListNode<T> tail;
    // Helper, keeping track of size.
    private int size;

    /**
     * Constructing empty list.
     */
    public LinkedList() {
        head = null;
        tail = null;
    }
    /**
     * Adding a node to the front of the list.
     *
     */
    public void addFront(CustomDeque.ListNode<T> newNode) {
        if (isEmpty()){
            head = newNode;
            tail = head;
        }
        else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    /**
     * Inserting a node at the end of the list.
     *
     */
    public void addEnd(CustomDeque.ListNode<T> newNode) {
        if (isEmpty()){
            head = newNode;
            tail = head;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        }
        size++;
    }
    /**
     * Adding node before another node
     *
     * @param x Value to look for, adding before x if found
     * @param y Value to add.
     */
    public void addBefore(T x, T y) {
        // List is empty, can't add
        if (isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");
        CustomDeque.ListNode<T> current = head;
        // Looping through until found
        while (current != null && !current.data.equals(x))
            current = current.next;
        // If null, not found
        if (current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");
        CustomDeque.ListNode<T> newNode = new CustomDeque.ListNode<T>(current.prev, y, current);
        if (current.prev != null)
            current.prev.next = newNode;
        else
            head = newNode;
        current.prev = newNode;
        size++;
    }
    /**
     * Adding node after another node
     *
     * @param x Value to look for, adding after x if found
     * @param y Value to add.
     */
    public void addAfter(T x, T y) {
        if (isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");
        CustomDeque.ListNode<T> current = head;
        // Looping through until found
        while (current != null && !current.data.equals(x))
            current = current.next;
        // If null, not found
        if (current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");
        // Not null, value found
        CustomDeque.ListNode<T> newNode = new CustomDeque.ListNode<T>(current, y, current.next);
        if (current.next != null)
            current.next.prev = newNode;
        current.next = newNode;
        size++;
    }
    public CustomDeque.ListNode<T> removeLast(){
        CustomDeque.ListNode<T> listNode;
        if(size() == 1){
            listNode = head;
            head = tail;
            return listNode;
        }
        else if(tail.prev != null) {
            listNode = tail.prev;
            CustomDeque.ListNode<T> temp = tail;
            listNode.next = null;
            temp.prev = null;
            tail = listNode;
            size--;
            return temp;
        }else {
            throw new NoSuchElementException();
        }
    }
    public CustomDeque.ListNode<T> removeFirst(){
        CustomDeque.ListNode<T> listNode = head;
        head = head.next;
        listNode.next = null;
        size--;
        return listNode;
    }

    /**
     * @return true if list is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * @return size of list
     */
    public int size() {
        return size;
    }

    public T getFirst(){
        return head.data;
    }
    public T getLast(){
        return tail.data;
    }
    @Override
    public String toString() {
        CustomDeque.ListNode<T> temp = head;
        StringBuilder builder = new StringBuilder("[");
        if(temp != null){
            while (temp != null) {
                builder.append(temp.data).append(",");
                temp = temp.next;
            }
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        return builder.toString();
    }
}