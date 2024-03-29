import java.util.ListIterator;

public class Tests {
    static final int CAPACITY_OF_ARRAYS = 3;

    /**
     * adding standart values to LinkedArrayList
     * @param linkedArrayList Arraylist that will be changed
     */
    public static void add( LinkedArrayList<Integer> linkedArrayList){
        linkedArrayList.add(0);
        linkedArrayList.add(1);
        linkedArrayList.add(2);
        linkedArrayList.add(3);
        linkedArrayList.add(4);
        linkedArrayList.add(5);
        linkedArrayList.add(6);
        linkedArrayList.add(7);
    }

    /**
     * Printing size of LinkedArrayList
     * @param linkedArrayList LinkedArrayList that will be counted
     */
    public static void printSize( LinkedArrayList<Integer> linkedArrayList){
        System.out.println("Size Of list is " + linkedArrayList.size());
    }

    /**
     * Check if LinkedArrayList empty or not
     * @param linkedArrayList LinkedArrayList that will be checked if LinkedArrayList empty or not
     */
    public static void printIsEmpty( LinkedArrayList<Integer> linkedArrayList){
        System.out.println("Is LinkedArrayList Empty: " + linkedArrayList.isEmpty());
    }

    /**
     * Printing print functions
     * @param linkedArrayList LinkedArrayList that will be printed
     */
    public static void print(LinkedArrayList<Integer> linkedArrayList){

        System.out.println( "\n" + linkedArrayList);
        printSize(linkedArrayList);
        printIsEmpty(linkedArrayList);
    }

    /**
     * Printing test number
     * @param number number of text
     */
    public static void printTestName(int number){

        System.out.println("-----------------Test Number " + number + "----------------------");
    }

    /**
     * Removing String
     */
    public static void test1(){
        printTestName(1);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        print(linkedArrayList);

        linkedArrayList.remove("hakan");
        print(linkedArrayList);

    }

    /**
     * Removing Double object
     */
    public static void test2(){
        printTestName(2);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        print(linkedArrayList);
        linkedArrayList.remove(4.5);
        print(linkedArrayList);
    }

    /**
     * Remove given value
     */
    public static void test3(){
        printTestName(3);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);

        print(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(5));
        print(linkedArrayList);

    }

    /**
     * Remove item to given iterator
     */
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

    /**
     * Adding element if there is a space
     */
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

    /**
     * Removing Element
     */
    public static void test6(){
        printTestName(6);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.add(9);
        print(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(9));
        print(linkedArrayList);
    }

    /**
     * Removing not existing element
     */
    public static void test7(){
        printTestName(7);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(7));
        print(linkedArrayList);

        linkedArrayList.remove(Integer.valueOf(7));
        print(linkedArrayList);

    }

    /**
     * Removing elements according to given value Objects and array deleted
     */
    public static void test8(){
        printTestName(8);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(7));
        print(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(6));
        print(linkedArrayList);

    }

    /**
     * Getting index of given value
     */
    public static void test9(){
        printTestName(9);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);

        linkedArrayList.indexOf(4);
        print(linkedArrayList);
    }

    /**
     * Adding element to end of the given index
     */
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

    /**
     * Adding element at the end of the list because of index is not filled
     */
    public static void test11(){
        printTestName(11);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.add(0,76);
        print(linkedArrayList);

        linkedArrayList.add(0,84);
        print(linkedArrayList);


    }

    /**
     * Removing all values inside list by using iterator
     */
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

    /**
     * Setting value according to given value
     */
    public static void test13(){
        printTestName(13);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        ListIterator<Integer> iterator = linkedArrayList.listIterator();
        print(linkedArrayList);
        iterator.set(1);
        print(linkedArrayList);
    }

    /**
     * Checking listIterator(int index) method inside ListIterator class
     */
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

    /**
     * remove according to indexes
     */
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

    /**
     * Removing out of bound index
     */
    public static void test16(){
        printTestName(16);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        print(linkedArrayList);
        linkedArrayList.remove(9);
        print(linkedArrayList);

    }

    /**
     * Delete empty LinkedArrayList
     */
    public static void test17(){
        printTestName(17);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        print(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(0));
        print(linkedArrayList);

    }
    /**
     * Adding new element after that new array will be created
     */
    public static void test18(){
        printTestName(18);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.add(Integer.valueOf(8));
        print(linkedArrayList);
        linkedArrayList.add(Integer.valueOf(9));
        print(linkedArrayList);
    }
    /**
     * Get Method test
     */
    public static void test19(){
        printTestName(19);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        print(linkedArrayList);
        System.out.println("Get value of index 5 is " + linkedArrayList.get(5));


    }


    /**
     * Set method test
     */
    public static void test20(){
        printTestName(20);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        print(linkedArrayList);
        System.out.println("Return value is " + linkedArrayList.set(0,4));
        print(linkedArrayList);

    }

    /**
     * Adding element at the end of the linkedarraylist
     */
    public static void test21() {
        printTestName(21);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        ListIterator<Integer> iterator = linkedArrayList.listIterator();
        print(linkedArrayList);
        iterator.add(5);
        print(linkedArrayList);
    }

    /**
     * Removing Empty LinkedArrayList
     */
    public static void test22(){
        printTestName(22);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        print(linkedArrayList);
        linkedArrayList.remove(Integer.valueOf(5));
    }

    /**
     * Testing removeRange(int fromIndex, int toIndex) Method
     */
    public static void test23(){
        printTestName(23);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.removeRange(0,2);
    }
    /**
     * Testing contains(Object o) Method
     */
    public static void test24(){
        printTestName(24);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        System.out.println("Does list contains value 3 : " + linkedArrayList.contains(Integer.valueOf(3)));
    }
    /**
     * Testing sublist(int fromIndex, int toIndex) Method
     */
    public static void test25(){
        printTestName(25);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        System.out.println(linkedArrayList.subList(0, 2));
    }
    /**
     * Testing contains(Object o) Method
     */
    public static void test26(){
        printTestName(26);
        LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<>(CAPACITY_OF_ARRAYS);
        add(linkedArrayList);
        linkedArrayList.add(Integer.valueOf(3));
        System.out.println("Last Index of number 3 is " + linkedArrayList.lastIndexOf(Integer.valueOf(3)));
    }
}
