import java.util.Arrays;
import java.util.Stack;

public class Main{
    final static int BORDERX = 4;
    final static int BORDERY = 5;
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
        //Throw exception
        test11();
        test12();
        test13();
        //Throw Exception
        test14();

    }

    public static void test1(){
        ReverseString.reverseString("");
    }
    public static void test2(){
        ReverseString.reverseString("his function writes the sentence in reverse");
    }
    public static void test3(){
        ReverseString.reverseString("his     function     writes     the sentence    in   reverse  ");
    }
    public static void test4(){
        System.out.println( DetermineElfishWord.determineElfishWord(" "));
    }
    public static void test5(){
        System.out.println( DetermineElfishWord.determineElfishWord("Melihcan"));
    }
    public static void test6(){
        System.out.println( DetermineElfishWord.determineElfishWord("waffles"));
    }
    public static void test7(){
        int [] input = {};
        RecursiveSelectionSort.recurSelectionSort(input,input.length,0);
        System.out.println(Arrays.toString(input));
    }
    public static void test8(){
        int [] input = {4,5,62,4,6,78,2,121,43};
        RecursiveSelectionSort.recurSelectionSort(input,input.length,0);
        System.out.println(Arrays.toString(input));
    }
    public static void test9(){
        int [] input = {4,5,62,4,6,78,2,121,43};
        RecursiveSelectionSort.recurSelectionSort(input,input.length,3);
        System.out.println(Arrays.toString(input));
    }
    public static void test10(){
        Stack<String> stack = new Stack<>();
        ExpressionRecursive.evaluation(stack,"",0,1);
    }
    public static void test11(){
        Stack<String> stack = new Stack<>();
        ExpressionRecursive.evaluation(stack,"1 2 - 5 / 6 + + 7 8 / -",0,1);
    }
    public static void test12(){
        Stack<String> stack = new Stack<>();
        ExpressionRecursive.evaluation(stack,"1 2 3 4 * - 5 / 6 + + 7 8 / -",0,1);
    }
    public static void test13(){
        Stack<String> stack = new Stack<>();
        String string = "-+ + 1 / - 2 * 3 4 5 6 / 7 8";
        ExpressionRecursive.evaluation(stack,string, string.length() - 1,-1);
    }
    public static void test14(){
        Stack<String> stack = new Stack<>();
        String string = "-+ + 1 / - 2 5 6 / 7 8";
        ExpressionRecursive.evaluation(stack,string, string.length() - 1,-1);
    }
    public static void test15(){
        int [][] array = new int[BORDERY][BORDERX];
        Print2DArray.printArray(array,0,0,0,BORDERX,BORDERY);
    }

}