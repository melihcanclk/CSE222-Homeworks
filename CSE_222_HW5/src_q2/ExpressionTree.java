import java.util.Scanner;

public class ExpressionTree extends BinaryTree<String>{

    ExpressionTree(String string){
        root = readBinaryTree(new Scanner(string));
    }
    ExpressionTree(Node<String> node){
        super(node);
    }

    public static Node<String> readBinaryTree(Scanner scan){
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
        input.append(" .");
        scan = new Scanner(input.toString());
        data = scan.next().trim();
        ExpressionTree expressionTree = new ExpressionTree(new Node<>(data));
        Node<String> currentNode = expressionTree.root;
        data = scan.next().trim();
        //eğer static yapmak zorunlu değil ise burayı kaldır
        while(!data.equals(".")){
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
        return expressionTree.root;
    }

    private static boolean isSymbol(String character){
        return "+-*/".contains(character);
    }

    @Override
    public String toString() {
        return super.toString();
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
