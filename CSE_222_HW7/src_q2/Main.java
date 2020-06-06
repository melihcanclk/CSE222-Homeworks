public class Main {
    static SkipList<Integer> skipList = new SkipList<>();
    public static void main(String[] args) {

        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        //test7();
        //test8();
        //test9();
        //test10();
        //test11();
    }
    public static void test1(){
        skipList.add(5);
        System.out.println(skipList);
    }
    public static void test2(){
        skipList.add(5);
        skipList.add(8);
        skipList.add(13);
        skipList.add(2);

        System.out.println(skipList);
    }
    public static void test3(){
        skipList.add(5);
        skipList.add(8);
        skipList.add(13);
        skipList.add(2);
        skipList.add(3);


        System.out.println(skipList);
    }
    public static void test4(){
        skipList.add(5);
        skipList.add(8);
        skipList.add(13);
        skipList.add(2);
        skipList.add(3);
        skipList.add(24);

        System.out.println(skipList);
    }
    public static void test5(){
        skipList.add(5);
        skipList.add(8);
        skipList.add(13);
        skipList.add(2);
        skipList.add(3);
        skipList.add(24);
        skipList.add(74);
        skipList.add(1);
        skipList.add(36);
        System.out.println(skipList);
    }
    public static void test6(){
        skipList.add(5);
        skipList.add(8);
        skipList.add(13);
        skipList.add(2);
        skipList.add(3);
        skipList.add(24);
        skipList.add(74);
        System.out.println(skipList);
        skipList.remove(3);
        System.out.println(skipList);
    }
    public static void test7(){
        skipList.add(5);
        skipList.add(8);
        skipList.add(13);
        skipList.add(2);
        skipList.add(3);

        System.out.println(skipList);
        skipList.remove(13);
        System.out.println(skipList);
    }
    public static void test8(){
        skipList.add(5);
        skipList.add(8);
        skipList.add(13);
        skipList.add(2);
        skipList.add(3);
        skipList.add(3);
        System.out.println(skipList);

    }
    public static void test9(){
        skipList.add(5);
        skipList.add(8);
        skipList.add(13);
        skipList.add(2);
        skipList.add(3);
        skipList.remove(31);
        System.out.println(skipList);

    }
    public static void test10(){
        skipList.add(5);
        skipList.add(8);
        skipList.add(13);
        skipList.add(2);
        skipList.add(3);
        System.out.println(skipList.find(2));
        System.out.println(skipList);

    }
    public static void test11(){
        skipList.add(5);
        skipList.add(8);
        skipList.add(13);
        skipList.add(2);
        skipList.add(3);
        System.out.println(skipList.find(31));
        System.out.println(skipList);

    }
}