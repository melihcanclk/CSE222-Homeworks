import java.util.Deque;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
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
        test17();
        test18();
        test19();
        test20();
        test21();
        test22();
        test23();
        test24();
        test25();
        test26();
        test27();
        test28();
        test29();
        test30();
        test31();
        test32();
        test33();
        test34();
        //throws exception
        //test35();
        test36();
    }
    public static void construct(Deque<Double> deque){
        deque.addFirst(5.6);
        deque.addFirst(4.45);
        deque.addFirst(3.12);
        deque.addFirst(51.6);
        deque.addFirst(42.45);
        deque.addFirst(3.12);
        deque.addFirst(5.46);
        deque.addFirst(45.45);
        deque.addFirst(37.12);

    }

    public static void test1(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.addFirst(192.332);
        System.out.println(deque);
    }
    public static void test2(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.addLast(192.332);
        System.out.println(deque);
    }
    public static void test3(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.offerFirst(192.332);
        System.out.println(deque);
    }
    public static void test4(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.offerLast(192.332);
        System.out.println(deque);
    }
    public static void test5(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
    }
    public static void test6(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
    }
    public static void test7(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.pollFirst();
        System.out.println(deque);
    }
    public static void test8(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.pollLast();
        System.out.println(deque);
    }
    public static void test9(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        System.out.println("First value is " + deque.getFirst());
        System.out.println(deque);
    }
    public static void test10(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        System.out.println("Last value is " + deque.getLast());
        System.out.println(deque);
    }
    public static void test11(){
        Deque<Double> deque = new CustomDeque<>();
        System.out.println(deque);
        System.out.println("First value is " + deque.peekFirst());
    }
    public static void test12(){
        Deque<Double> deque = new CustomDeque<>();
        System.out.println(deque);
        System.out.println("Last value is " + deque.peekLast());
    }
    public static void test13(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        System.out.println("First value is " + deque.peekFirst());
        System.out.println(deque);
    }
    public static void test14(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        deque.addLast(45.45);
        System.out.println(deque);
        deque.removeFirstOccurrence(45.45);
        System.out.println(deque);
    }
    public static void test15(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        deque.addLast(45.45);
        System.out.println(deque);
        deque.removeLastOccurrence(45.45);
        System.out.println(deque);
    }
    public static void test16(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.add(192.332);
        System.out.println(deque);
    }
    public static void test17(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.offer(192.332);
        System.out.println(deque);
    }
    public static void test18(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.remove();
        System.out.println(deque);
    }
    public static void test19(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.poll();
        System.out.println(deque);
    }
    public static void test20(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        System.out.println("Result of element method is " + deque.element());
    }
    public static void test21(){
        Deque<Double> deque = new CustomDeque<>();
        System.out.println(deque);
        System.out.println("Result of peek method of empty method is " + deque.peek());
    }
    public static void test22(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        System.out.println("Result of peek method of empty method is " + deque.peek());
    }
    public static void test23(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.clear();
        System.out.println(deque);
    }
    public static void test24(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.push(192.332);
        System.out.println(deque);
    }
    public static void test25(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        deque.pop();
        System.out.println(deque);
    }
    public static void test26(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        deque.addLast(45.45);
        System.out.println(deque);
        System.out.println("Result of remove method is " + deque.remove(Double.valueOf(4.26)));
        System.out.println(deque);
    }
    public static void test27(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        deque.addLast(45.45);
        System.out.println(deque);
        System.out.println("Result of remove method is " + deque.remove(Double.valueOf(45.45)));
        System.out.println(deque);
    }
    public static void test28(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        System.out.println("Does Deque contains 4.26?\n" + deque.contains(Double.valueOf(4.26)));
    }
    public static void test29(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        System.out.println("Does Deque contains 3.12?\n" + deque.contains(Double.valueOf(3.12)));
    }

    public static void test30(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        System.out.println("Size of Deque is " + deque.size());
    }
    public static void test31(){
        Deque<Double> deque = new CustomDeque<>();
        System.out.println(deque);
        System.out.println("Is Deque empty?\n" + deque.isEmpty());
    }
    public static void test32(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        System.out.println("Is Deque empty?\n" + deque.isEmpty());
    }
    public static void test33(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        Iterator<Double> iterator = deque.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void test34(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        Object [] array = deque.toArray();
        for (Object o : array) {
            System.out.println(o);
        }
    }
    public static void test35(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        System.out.println(deque);
        Object [] array = deque.toArray();
        deque.toArray(array);
    }
    public static void test36(){
        Deque<Double> deque = new CustomDeque<>();
        construct(deque);
        Iterator<Double> iterator = deque.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
