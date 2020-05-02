import java.util.Scanner;

public class ExpressionTree extends BinaryTree<String>{

    ExpressionTree(String string){
        root = readBinaryTree(new Scanner(string)).root;
    }
    ExpressionTree(Node<String> node){
        super(node);
    }

    public static BinaryTree<String> readBinaryTree(Scanner scan){
        //Determine whether input that is coming is postfix or prefix
        //according to that, input will be fixed.
        String data = convertScannerToString(scan);
        //determine whether we got end of the scanner or not
        data = data + " .";
        scan = new Scanner(data);
        ExpressionTree expressionTree = new ExpressionTree(new Node<>( scan.next().trim()));
        Node<String> currentNode = expressionTree.root;
        data = scan.next().trim();
        while(scan.hasNext()){
            Node<String> tempNode = new Node<>(data);
            if(currentNode.left != null && currentNode.right != null){
                if(isSymbol(currentNode.left.data)){
                    currentNode = currentNode.left;
                } else if(isSymbol(currentNode.right.data)){
                    currentNode = currentNode.right;
                } else{
                    currentNode = expressionTree.root;
                }
            }else if(currentNode.right == null){
                currentNode.right = tempNode;
                if(isSymbol(tempNode.data))
                    currentNode = currentNode.right;
                data = scan.next().trim();
            }else {
                currentNode.left = tempNode;
                if(isSymbol(tempNode.data))
                    currentNode = currentNode.left;
                data = scan.next().trim();
            }
        }
        return expressionTree;
    }
    public String postOrderTraverse(){
        StringBuilder sb = new StringBuilder();
        postOrderTraverse(root,1,sb);
        return sb.toString();
    }

    private void postOrderTraverse(Node<String> node, int depth, StringBuilder sb) {
        if(node == null){
            for(int i = 1; i<depth;++i)
                sb.append("  ");
            sb.append("null\n");
        }
        else{
            postOrderTraverse(node.left,depth+1,sb);
            postOrderTraverse(node.right,depth+1,sb);
            for(int i = 1; i<depth;++i)
                sb.append("  ");
            sb.append(node.toString()).append("\n");
        }
    }

    private static String convertScannerToString(Scanner scan){
        String data = scan.next().trim();
        StringBuilder input = new StringBuilder(data + " ");
        while(scan.hasNext()){
            input.append(scan.next()).append(" ");
        }
        if(isSymbol(data)){
            //Prefix
        }else {
            //postfix
            input = new StringBuilder(reverseString(input.toString()));
            //to understand that loop is over
        }
        //to understand that loop is over

        return input.toString();

    }

    public double eval(){
        return eval(root);
    }
    private double eval(Node<String> node){
        if(node == null)
            return 0;
        if(node.isLeaf())
            return Integer.parseInt(node.data);
        else {
            double firstOperant = eval(node.left);
            double secondOperant = eval(node.right);

            if(node.data.equals("+"))
                return firstOperant + secondOperant;
            else if(node.data.equals("-"))
                return secondOperant - firstOperant;
            else if(node.data.equals("*"))
                return firstOperant * secondOperant;
            else
                return secondOperant / firstOperant;
        }


    }

    private static boolean isSymbol(String character){
        return "+-*/".contains(character);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String toString2(){
        return postOrderTraverse();
    }

    private static String reverseString(String string){
        String [] tempArray = string.split(" ");
        String [] arr2 = new String[tempArray.length];
        for(int i = 0; i< tempArray.length;++i){
            arr2[i] = tempArray[tempArray.length - i - 1];
        }
        return String.join(" ",arr2);
    }
}
