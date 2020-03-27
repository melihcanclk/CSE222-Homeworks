import java.util.Iterator;
import java.util.ListIterator;

class Main {
    static final int CAPACITY_OF_ARRAYS = 3;

    public static void main(String[] args) throws CloneNotSupportedException {

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
        test14();
        test15();
        test16();
    }

    public static void add(LinkedArrayList<Integer> linkedArrayList){
        linkedArrayList.add(0);
        linkedArrayList.add(1);
        linkedArrayList.add(2);
        linkedArrayList.add(3);
        linkedArrayList.add(4);
        linkedArrayList.add(5);
        linkedArrayList.add(6);
        linkedArrayList.add(7);
    }

    public static void printSize(LinkedArrayList<Integer> linkedArrayList){
        System.out.println("Size Of list is " + linkedArrayList.size());
    }
    public static void printIsEmpty(LinkedArrayList<Integer> linkedArrayList){
        System.out.println("Is LinkedArrayList Empty: " + linkedArrayList.isEmpty());
    }

    public static void print(LinkedArrayList<Integer> linkedArrayList){

        System.out.println( "\n" + linkedArrayList);
        printIsEmpty(linkedArrayList);
        printSize(linkedArrayList);
        System.out.println("\n");
    }
    public static void printTestName(int number){

        System.out.println("-----------------Test Number " + number + "----------------------");
    }

    public static void test1(){
        printTestName(1);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        print(linkedArrayList);

        linkedArrayList.remove("hakan");
        print(linkedArrayList);

    }
    public static void test2(){
        printTestName(2);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        print(linkedArrayList);
        linkedArrayList.remove(4.5);
        print(linkedArrayList);
    }
    public static void test3(){
        printTestName(3);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);

        print(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(5));
        print(linkedArrayList);

    }
    public static void test4(){
        printTestName(4);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        ListIterator<Integer> iterator = linkedArrayList.listIterator();
        iterator.next();
        System.out.println("Item that will be removed is " + iterator);
        iterator.remove();
        print(linkedArrayList);
    }
    public static void test5(){
        printTestName(5);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        ListIterator<Integer> iterator = linkedArrayList.listIterator();
        iterator.next();
        iterator.remove();
        System.out.println();
        linkedArrayList.add(9);
        print(linkedArrayList);
    }
    public static void test6(){
        printTestName(6);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.add(9);
        print(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(9));
        print(linkedArrayList);
    }
    public static void test7(){
        printTestName(7);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(7));
        print(linkedArrayList);

        linkedArrayList.remove(Integer.valueOf(7));
        print(linkedArrayList);

    }
    public static void test8(){
        printTestName(8);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(7));
        print(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(6));
        print(linkedArrayList);

    }
    public static void test9(){
        printTestName(9);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);

        linkedArrayList.indexOf(4);
        print(linkedArrayList);
    }
    public static void test10(){
        printTestName(10);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(0));
        linkedArrayList.remove(Integer.valueOf(1));
        print(linkedArrayList);

        linkedArrayList.add(0,76);
        print(linkedArrayList);

        linkedArrayList.add(0,84);
        print(linkedArrayList);


    }
    public static void test11(){
        printTestName(11);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.add(0,76);
        print(linkedArrayList);

        linkedArrayList.add(0,84);
        print(linkedArrayList);


    }
    public static void test12(){
        printTestName(12);

        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        ListIterator<Integer> iterator = linkedArrayList.listIterator();

        while (iterator.hasNext()){
            print(linkedArrayList);
            iterator.remove();
        }
        print(linkedArrayList);
    }
    public static void test13(){
        printTestName(13);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        ListIterator<Integer> iterator = linkedArrayList.listIterator();
        print(linkedArrayList);
        iterator.set(1);
        print(linkedArrayList);
    }

    public static void test14(){
        printTestName(14);
        final int INDEX = 1;
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        print(linkedArrayList);
        ListIterator<Integer> iterator;
        iterator = linkedArrayList.listIterator(INDEX);
        System.out.println("Value of index " + INDEX + " is " +  iterator + ". This information is get by the iterator");

    }
    public static void test15(){
        printTestName(15);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        print(linkedArrayList);
        linkedArrayList.remove(2);
        print(linkedArrayList);
        linkedArrayList.remove(3);
        print(linkedArrayList);
    }
    public static void test16(){
        printTestName(16);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        print(linkedArrayList);
        linkedArrayList.remove(9);
        print(linkedArrayList);

    }
}