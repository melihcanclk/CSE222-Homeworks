/**
 * Custom search tree method for create trees with any class that implements
 * SearchTree method. When a class sent to that class as constructor, we create
 * clone of tree sent to that class as constructor.
 */
public class CustomSearchTree {
    SearchTree<Software> searchNameTree;
    SearchTree<Software> searchQuantityTree;
    SearchTree<Software> searchPriceTree;

    /**
     * Constructor of CustomSearchTree
     * @param searchTree SearchTree that will be sent
     * @throws IllegalAccessException Exception for Illegal Access
     * @throws InstantiationException Exception for Instantiation
     */
    CustomSearchTree(SearchTree<Software> searchTree) throws IllegalAccessException, InstantiationException {
        this.searchNameTree = searchTree.getClass().newInstance();
        this.searchQuantityTree = searchTree.getClass().newInstance();
        this.searchPriceTree = searchTree.getClass().newInstance();
    }

    /**
     * toString method for print NameTree
     * @return nameTree's toString method
     */
    @Override
    public String toString() {
        return searchNameTree.toString();
    }
}
