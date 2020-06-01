public class Main {
    public static void main(String[] args) {
        SearchTree<Integer> searchTree = new AVLTree<>();
        searchTree.add(5);
        System.out.println(searchTree);
    }
}