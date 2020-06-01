import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Admin extends People{
    private final String password;

    /**
     * Constructor of Admin Class
     * @param username Username of Admin
     * @param password Password of Admin
     */
    Admin(String username, String password){
        super(username);
        this.password = password;
    }
    
    public static <T> T[] newArray(Class<T[]> type, int size) {
        return type.cast(Array.newInstance(type.getComponentType(), size));
     }
    /**
     * Adding book to Map
     * @param tree Tree that keeps all information about books
     * @param priceSortedTree
     * @param quantitySortedTree
     * @param priceSortedTree2
     * @param priceSortedTree2
     */
    public void addSoftware(SearchTree<RevisedNode<String>> nameSortedTree, SearchTree<RevisedNode<String>> versionSortedTree,
                             SearchTree<RevisedNode<String>> quantitySortedTree, SearchTree<RevisedNode<String>> priceSortedTree, Software software){
                                                         //sürekli get kullandığım için arraylist kullandım
        List<RevisedNode<String>> list = new ArrayList<>();
        list.add(new RevisedNode<String>(null, software.getNameOfSoftware(), null));
        list.add(new RevisedNode<String>(null, String.valueOf(software.getVersionOfSoftware()), null));
        list.add(new RevisedNode<String>(null, String.valueOf(software.getQuantityOfSoftware()), null));
        list.add(new RevisedNode<String>(null, String.valueOf(software.getPriceOfSoftware()), null));
        list.set(0, new RevisedNode<String>(null, list.get(0).data, list.get(1)));
        list.set(1, new RevisedNode<String>(list.get(0), list.get(1).data, list.get(2)));
        list.set(2, new RevisedNode<String>(list.get(1), list.get(2).data, list.get(3)));
        list.set(3, new RevisedNode<String>(list.get(2), list.get(3).data, null));
        nameSortedTree.add(list.get(0));
        versionSortedTree.add(list.get(1));
        quantitySortedTree.add(list.get(2));
        priceSortedTree.add(list.get(3));
    }

    /**
     *  Remove book from Maps
     * @param priceSortedTree
     * @param quantitySortedTree
     * @param map Map that keeps all information about books
     */
    public void removeSoftware(SearchTree<Software> tree, SearchTree<Software> quantitySortedTree, SearchTree<Software> priceSortedTree, 
                                Software software){
        
    }

    /**
     * Update locations of the books
     * @param priceSortedTree
     * @param quantitySortedTree
     * @param map Map that keeps all information about books
     */
    public void updateSoftware(SearchTree<Software> tree, SearchTree<Software> quantitySortedTree, SearchTree<Software> priceSortedTree, 
                                Software oldSoftware, Software newSoftware){
        
    }

    /**
     * Printing All books
     * @param map Map that keeps all information about books
     */
    public void printAllSoftwares(SearchTree<Software> tree){
    
    }

    /**
     * Getting password of the Admin
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
}
