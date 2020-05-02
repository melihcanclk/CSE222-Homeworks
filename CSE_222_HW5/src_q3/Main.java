public class Main{
    private static AgeSearchTree<AgeData> ageTree;
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

    }
    public static void construct(){
        ageTree = new AgeSearchTree<AgeData>();
        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(15));
        ageTree.add(new AgeData(65));
        ageTree.add(new AgeData(45));
        ageTree.add(new AgeData(854));
        ageTree.add(new AgeData(754));
    }
    //Add method test / adding different number to AgeTree
    public static void test1(){
        construct();
        System.out.println(ageTree);
        ageTree.add(new AgeData(9));
        System.out.println(ageTree);
    }
    //Add method test / adding same number to AgeTree
    public static void test2(){
        construct();
        System.out.println(ageTree);
        ageTree.add(new AgeData(854));
        System.out.println(ageTree);
    }
    //Find Method / find AgeData that will not be found
    public static void test3(){
        construct();
        System.out.println(ageTree);
        System.out.println(ageTree.find(new AgeData(47)));
        System.out.println(ageTree);
    }
    //Find Method / find AgeData that will be found
    public static void test4(){
        construct();
        System.out.println(ageTree);
        System.out.println(ageTree.find(new AgeData(854)));
        System.out.println(ageTree);
    }

    //Remove method / remove AgeData that will not be found
    public static void test5(){
        construct();
        System.out.println(ageTree);
        System.out.println(ageTree.remove(new AgeData(47)));
        System.out.println(ageTree);
    }
    //Remove method / remove AgeData that will be found and node that
    //has no child
    public static void test6(){
        construct();
        System.out.println(ageTree);
        System.out.println(ageTree.remove(new AgeData(5)));
        System.out.println(ageTree);
    }
    //Remove method / remove AgeData that will be found and node that
    //has child
    public static void test7(){
        construct();
        System.out.println(ageTree);
        System.out.println(ageTree.remove(new AgeData(20)));
        System.out.println(ageTree);
    }
    //Remove method / remove AgeData that will be found and node that
    //has more than one people
    public static void test8(){
        construct();
        ageTree.add(new AgeData(854));
        System.out.println(ageTree);
        System.out.println(ageTree.remove(new AgeData(854)));
        System.out.println(ageTree);
    }
    //olderThan method
    public static void test9(){
        construct();
        System.out.println(ageTree);
        System.out.println(ageTree.olderThan(60));
    }
    //youngerThan method
    public static void test10(){
        construct();
        System.out.println(ageTree);
        System.out.println(ageTree.youngerThan(60));
    }

    //toString method
    public static void test11(){
        construct();
        System.out.println(ageTree.toString());
    }

}