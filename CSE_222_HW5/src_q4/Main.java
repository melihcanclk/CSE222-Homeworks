public class Main {
    private static MaxHeap<AgeData> maxHeap;
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
//        test11();
//        test12();
    }
    public static void construct(){
        maxHeap = new MaxHeap<>();
        maxHeap.add(new AgeData(10));
        maxHeap.add(new AgeData(70));
        maxHeap.add(new AgeData(50));
        maxHeap.add(new AgeData(5));
        maxHeap.add(new AgeData(64));
        maxHeap.add(new AgeData(76));
        maxHeap.add(new AgeData(3));
        maxHeap.add(new AgeData(654));
        maxHeap.add(new AgeData(23));
        maxHeap.add(new AgeData(65));
    }
    //Add method / adding AgeData that is not in the heap
    public static void test1(){
        construct();
        System.out.println(maxHeap);
        maxHeap.add(new AgeData(765));
        System.out.println(maxHeap);
    }
    //Add method / adding AgeData that is in the heap and numberOfPeople will be increased
    //so we move it to top of the heap
    public static void test2(){
        construct();
        System.out.println(maxHeap);
        maxHeap.add(new AgeData(10));
        System.out.println(maxHeap);
    }
    //Add method / adding AgeData that is in the heap and numberOfPeople will be increased
    //so we move it to top of the heap
    public static void test3(){
        construct();
        maxHeap.add(new AgeData(10));
        System.out.println(maxHeap);
        maxHeap.add(new AgeData(3));
        maxHeap.add(new AgeData(3));
        System.out.println(maxHeap);
    }
    //Find method / finding ageData that can be found
    public static void test4(){
        construct();
        System.out.println(maxHeap.find(new AgeData(3)));
    }
    //Find method / finding ageData that cannot be found
    public static void test5(){
        construct();
        System.out.println(maxHeap.find(new AgeData(45)));
    }
    //Remove method / remove that has 1 number of people
    public static void test6(){
        construct();
        System.out.println(maxHeap);
        maxHeap.remove(new AgeData(3));
        System.out.println(maxHeap);
    }
    //Remove method / remove that has more than one number of people
    public static void test7(){
        construct();
        maxHeap.add(new AgeData(10));
        System.out.println(maxHeap);
        maxHeap.remove(new AgeData(10));
        System.out.println(maxHeap);
    }
    //Remove method / remove that has more than one number of people
    public static void test8(){
        construct();
        maxHeap.add(new AgeData(10));
        maxHeap.add(new AgeData(3));
        System.out.println(maxHeap);
        maxHeap.remove(new AgeData(3));
        System.out.println(maxHeap);
    }
    //Remove method / remove that has more than one number of people
    public static void test9(){
        construct();
        maxHeap.add(new AgeData(10));
        maxHeap.add(new AgeData(3));
        maxHeap.add(new AgeData(10));
        maxHeap.add(new AgeData(3));
        System.out.println(maxHeap);
        maxHeap.remove(new AgeData(3));
        System.out.println(maxHeap);
    }
    //olderThan method
    public static void test10(){
        construct();
        System.out.println(maxHeap.olderThan(32));
    }
    //youngerThan method
    public static void test11(){
        construct();
        System.out.println(maxHeap.youngerThan(32));
    }
    //toString method
    public static void test12(){
        construct();
        System.out.println(maxHeap.toString());
    }

}
