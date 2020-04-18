import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static String nameofFile = "output.txt";
    public static void main(String[] args){

        //Create a tree for preorder expression
        ExpressionTree expTree = new ExpressionTree("a b + e f * g * -");
        //Create a tree for postorder expression
        ExpressionTree expTree2 = new ExpressionTree("10 5 15 * + 20 +");
        System.out.println(expTree);
        System.out.println(expTree2);
    }
}
