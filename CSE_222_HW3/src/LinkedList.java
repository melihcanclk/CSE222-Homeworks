

// Java program to implement
// a Singly Linked List
public class LinkedList<T> {

    private Node<T> head; // head of list
    private int capacity_of_arrays;

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    private static class Node<T>{

        DynamicArray<T> data;
        Node<T> next;

        // Constructor
        Node(Object object) {
            data = (DynamicArray<T>) object;
            next = null;
        }

    }

    public LinkedList(int capacity_of_arrays) {
        this.capacity_of_arrays = capacity_of_arrays;
    }

    // Method to insert a new node
    public void insert( T data) throws CloneNotSupportedException
    {
        // If the Linked List is empty,
        // then make the new node as head
        if (this.head == null) {
            DynamicArray array = new DynamicArray(this.capacity_of_arrays);
            array.addElement(data);
            // Create a new node with given data
            Node <T> new_node = new Node<T>(array.clone());
            this.head = new_node;
        }
        else {

            Node<T> last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            if(last.data.size() == last.data.capacity()){
                DynamicArray array = new DynamicArray(this.capacity_of_arrays);
                // Create a new node with given data
                Node <T> new_node = new Node<T>(array.clone());
                new_node.next = last.next;
                last.next = new_node;
                last = new_node;
            }
            last.data.addElement(data);
        }

    }

    public LinkedList<T> deleteByKey(T key)
    {
        // Store head node
        Node<T> currNode = this.head, prev = null;

        //
        // CASE 1:
        // If head node itself holds the key to be deleted

        if (currNode != null && key.equals(currNode.data)) {
            this.head = currNode.next; // Changed head

            // Display the message
            System.out.println(key + " found and deleted");

            // Return the updated List
            return this;
        }

        //
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && ! currNode.data.equals(key)){
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;

            // Display the message
            System.out.println(key + " found and deleted");
        }

        //
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }

        // return the List
        return this;
    }

    public LinkedList<T> remove(int index)
    {
        // Store head node
        Node<T> currNode = this.head, prev = null;

        //
        // CASE 1:
        // If index is 0, then head node itself is to be deleted

        if (index == 0 && currNode != null) {
            this.head = currNode.next; // Changed head

            // Display the message
            System.out.println(index + " position element deleted");

            // Return the updated List
            return this;
        }

        // CASE 2:
        // If the index is greater than 0 but less than the size of LinkedList
        //
        // The counter
        int counter = 0;

        while (currNode != null) {

            if (counter == index) {
                prev.next = currNode.next;

                // Display the message
                System.out.println(index + " position element deleted");
                break;
            }
            else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        // In this case, the currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(index + " position element not found");
        }

        // return the List
        return this;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        Node<T> currNode = this.head;
        while (currNode != null){
            stringBuilder.append(currNode.data.toString());
            currNode = currNode.next;
        }

        return stringBuilder.toString();
    }

}
