import java.util.AbstractList;
import java.util.List;

class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        LinkedList<Integer> linkedList = new LinkedList<>(4);
        linkedList.insert(5);
        linkedList.insert(6);
        linkedList.insert(7);
        linkedList.insert(8);
        linkedList.insert(9);
        linkedList.insert(0);

        System.out.println(linkedList);
    }
}