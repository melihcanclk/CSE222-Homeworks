public class Main {
    private static ExpressionTree expTree;

    public static void main(String[] args){
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
//        test13();
//        test14();
//        test15();
//        test16();

    }

    public static void construct_preorder(){
        expTree = new ExpressionTree("+ + 10 * 5 15 20");
    }
    public static void construct_postorder(){
        expTree = new ExpressionTree("+ + 10 * 5 15 20");
    }

    //Post Order Traverse for Preorder expression
    public static void test1(){
        construct_preorder();
        System.out.println(expTree.postOrderTraverse());
    }

    //Pre Order Traverse for Preorder expression
    public static void test2(){
        construct_preorder();
            System.out.println(expTree.preOrderTraverse());
    }

    //Post Order Traverse for PostOrder expression
    public static void test3(){
        construct_postorder();
        System.out.println(expTree.postOrderTraverse());
    }

    //Pre Order Traverse for PostOrder expression
    public static void test4(){
        construct_postorder();
        System.out.println(expTree.preOrderTraverse());
    }

    //Eval method result of Pre Order expression
    public static void test5(){
        construct_preorder();
        System.out.println("Result of preorder is: " + expTree.eval());
    }

    //Eval method result of Post Order expression
    public static void test6(){
        construct_postorder();
        System.out.println("Result of postorder is: " + expTree.eval());
    }

    //ToString Method result for Pre Order expression
    public static void test7(){
        construct_preorder();
        System.out.println("Result of toString method for preorder is \n" + expTree.toString());
    }

    //ToString Method result for Post Order expression
    public static void test8(){
        construct_postorder();
        System.out.println("Result of toString method for postorder is \n" + expTree.toString());
    }

    //ToString2 Method result for Pre Order expression
    public static void test9(){
        construct_preorder();
        System.out.println("Result of toString2 method for preorder is \n" + expTree.toString2());
    }

    //ToString2 Method result for Post Order expression
    public static void test10(){
        construct_postorder();
        System.out.println("Result of toString2 method for postorder is \n" + expTree.toString2());
    }

    //GetLeftSubtree Method result for Pre Order expression
    public static void test11(){
        construct_preorder();
        System.out.println("Result of getLeftSubtree method for preorder is \n" + expTree.getLeftSubtree());
    }

    //GetLeftSubtree Method result for Post Order expression
    public static void test12(){
        construct_postorder();
        System.out.println("Result of getLeftSubtree method for postorder is \n" +expTree.getLeftSubtree());
    }

    //GetRightSubtree Method result for Pre Order expression
    public static void test13(){
        construct_preorder();
        System.out.println("Result of getRightSubtree method for preorder is \n" + expTree.getRightSubtree());
    }

    //GetRightSubtree Method result for Post Order expression
    public static void test14(){
        construct_postorder();
        System.out.println("Result of getRightSubtree method for postorder is \n" +expTree.getRightSubtree());
    }

    //GetData Method result for Pre Order expression
    public static void test15(){
        construct_preorder();
        System.out.println("Result of getData method for preorder is \n" + expTree.getData());
    }
    //GetData Method result for Post Order expression
    public static void test16(){
        construct_postorder();
        System.out.println("Result of getData method for postorder is \n" +expTree.getData());
    }
}
