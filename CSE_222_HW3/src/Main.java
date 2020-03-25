import java.util.Iterator;

class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        LinkedList<Integer> linkedList = new LinkedList<>(3);
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        System.out.println(linkedList);
        linkedList.remove("hakan");

        System.out.println(linkedList);
        linkedList.remove(4.5);
        System.out.println(linkedList);

        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("\n");
        iterator = linkedList.iterator();
        iterator.next();
        iterator.remove();
        iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(linkedList);
        linkedList.add(9);
        System.out.println(linkedList);

        //we have to give object
        linkedList.remove(Integer.valueOf(9));
        System.out.println(linkedList);
        System.out.println("Size Of list is " + linkedList.size());
        linkedList.remove(Integer.valueOf(7));
        System.out.println(linkedList);
        System.out.println("Size Of list is " + linkedList.size());
        linkedList.remove(Integer.valueOf(6));
        System.out.println(linkedList);
        System.out.println("Size Of list is " + linkedList.size());

        System.out.println(linkedList.indexOf(4));

        System.out.println(linkedList.isEmpty());

        linkedList.add(0,76);
        System.out.println(linkedList);

        linkedList.add(0,84);
        System.out.println(linkedList);


        iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(linkedList);
            iterator.remove();
        }
        System.out.println(linkedList);
        System.out.println(linkedList.isEmpty());

    }
}