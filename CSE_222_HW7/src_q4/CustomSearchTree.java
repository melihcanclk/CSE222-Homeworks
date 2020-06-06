public class CustomSearchTree {
    SearchTree<Software> searchNameTree;
    SearchTree<Software> searchQuantityTree;
    SearchTree<Software> searchPriceTree;

    CustomSearchTree(SearchTree<Software> searchTree) throws IllegalAccessException, InstantiationException {
        this.searchNameTree = searchTree.getClass().newInstance();
        this.searchQuantityTree = searchTree.getClass().newInstance();
        this.searchPriceTree = searchTree.getClass().newInstance();
    }
    @Override
    public String toString() {
        return searchNameTree.toString();
    }
}
