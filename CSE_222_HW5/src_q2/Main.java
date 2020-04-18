public class Main {
    private static String nameofFile = "output.txt";
    public static void main(String[] args){

        //Create a tree for preorder expression
        ExpressionTree expTree = new ExpressionTree("+ + 10 * 5 15 20");
        //System.out.println(expTree);
        //Create a tree for postorder expression
        ExpressionTree expTree2 = new ExpressionTree("10 5 15 * + 20 +");
        System.out.println(expTree.postOrderTraverse());
        //System.out.println(expTree.preOrderTraverse());

        //System.out.println(expTree2);
    }
}
