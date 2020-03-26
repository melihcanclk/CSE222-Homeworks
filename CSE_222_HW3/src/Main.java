import java.util.Iterator;
import java.util.ListIterator;

class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        final int CAPACITY_OF_ARRAYS = 3;

        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        linkedArrayList.add(0);
        linkedArrayList.add(1);
        linkedArrayList.add(2);
        linkedArrayList.add(3);
        linkedArrayList.add(4);
        linkedArrayList.add(5);
        linkedArrayList.add(6);
        linkedArrayList.add(7);
        System.out.println(linkedArrayList);

        linkedArrayList.remove("hakan");
        System.out.println(linkedArrayList);
        linkedArrayList.remove(4.5);
        System.out.println(linkedArrayList);

        linkedArrayList.remove(Integer.valueOf(5));
        System.out.println(linkedArrayList);

        ListIterator iterator = linkedArrayList.listIterator();
        iterator.next();
        iterator.remove();
        System.out.println(linkedArrayList);

        linkedArrayList.add(9);
        System.out.println(linkedArrayList);

        //we have to give object
        linkedArrayList.remove(Integer.valueOf(9));
        System.out.println(linkedArrayList);
        System.out.println("Size Of list is " + linkedArrayList.size());
        linkedArrayList.remove(Integer.valueOf(7));
        System.out.println(linkedArrayList);
        System.out.println("Size Of list is " + linkedArrayList.size());
        linkedArrayList.remove(Integer.valueOf(7));
        System.out.println(linkedArrayList);
        System.out.println("Size Of list is " + linkedArrayList.size());
        linkedArrayList.remove(Integer.valueOf(6));
        System.out.println(linkedArrayList);
        System.out.println("Size Of list is " + linkedArrayList.size());

        System.out.println(linkedArrayList.indexOf(4));

        System.out.println(linkedArrayList.isEmpty());

        linkedArrayList.add(0,76);
        System.out.println(linkedArrayList);

        linkedArrayList.add(0,84);
        System.out.println(linkedArrayList);


        iterator = linkedArrayList.listIterator();
        iterator.next();
        iterator.add(11);
        while (iterator.hasNext()){
            System.out.println(linkedArrayList);
            iterator.remove();
        }
        System.out.println(linkedArrayList);
        System.out.println(linkedArrayList.isEmpty());

        linkedArrayList.add(6);
        linkedArrayList.add(7);
        System.out.println(linkedArrayList);
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(CAPACITY_OF_ARRAYS);
        dynamicArray.addElement(12);
        dynamicArray.addElement(13);

        iterator = linkedArrayList.listIterator();
        iterator.set(dynamicArray);
        System.out.println(linkedArrayList);
        linkedArrayList.add(6);
        linkedArrayList.add(7);
        linkedArrayList.add(6);
        linkedArrayList.add(7);
        linkedArrayList.add(6);
        linkedArrayList.add(7);
        System.out.println(linkedArrayList);
        iterator = linkedArrayList.listIterator(1);
        System.out.println(iterator);
        linkedArrayList.remove(0);
        System.out.println(linkedArrayList);
    }
}