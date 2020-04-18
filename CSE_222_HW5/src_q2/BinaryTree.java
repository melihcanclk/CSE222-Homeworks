import java.io.*;
import java.util.Scanner;

public class BinaryTree<E> implements Serializable {
    protected Node<E> root;

    protected static class Node<E> implements Serializable{
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data){
            this.data = data;
            left = null;
            right = null;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }
    public BinaryTree(){
        root = null;
    }
    protected BinaryTree(Node<E> root){
        this.root = root;
    }
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
        root = new Node<>(data);
        if(leftTree != null)
            root.left = leftTree.root;
        else
            root.left = null;
        if(rightTree != null)
            root.right = rightTree.root;
        else
            root.right = null;
    }
    public BinaryTree<E> getLeftSubTree(){
        if(root != null && root.left != null)
            return new BinaryTree<>(root.left);
        else
            return null;
    }
    public BinaryTree<E> getRightSubTree(){
        if(root != null && root.right != null)
            return new BinaryTree<>(root.right);
        else
            return null;
    }
    public boolean isLeaf(){
        return (root.left == null && root.right == null);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root,1,sb);
        return sb.toString();
    }

    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        for(int i = 1; i< depth;++i)
            sb.append("  ");

        if(node == null)
            sb.append("null\n");
        else{
            sb.append(node.toString()).append("\n");
            preOrderTraverse(node.left,depth+1,sb);
            preOrderTraverse(node.right,depth+1,sb);
        }
    }
    public static BinaryTree<String> readBinaryTree(Scanner scan){
        String data = scan.next();
        if(data.equals(null)){
            return null;
        }else{
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<>(data,leftTree,rightTree);
        }
    }

    public void writeObject(String nameofFile){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nameofFile));
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
   protected static BinaryTree<String> readObject(String nameofFile) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nameofFile));
            return (BinaryTree<String>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return new BinaryTree<>();
    }

}
