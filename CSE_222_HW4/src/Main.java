import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
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
}
