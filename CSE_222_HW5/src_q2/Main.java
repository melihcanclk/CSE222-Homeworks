import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Main {
    private static String nameofFile = "output.txt";
    public static void main(String[] args) throws IOException {
        BinaryTree<String> binaryTree = new BinaryTree<>(new BinaryTree.Node<>("1"));
        binaryTree.root.left = new BinaryTree.Node<>("5");
        binaryTree.root.right = new BinaryTree.Node<>("6");
        binaryTree.writeObject(nameofFile);
        BinaryTree<String> temp = BinaryTree.readObject(nameofFile);
        System.out.println(temp);
    }
}
