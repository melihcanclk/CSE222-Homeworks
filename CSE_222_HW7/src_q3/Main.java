import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Main {
    public static void main(String[] args) {
        int [] arrOfCapacities = {10000,20000,40000,80000};
        Evaluate<Integer> evaluate = new Evaluate<>();
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        BTree<Integer> bTree = new BTree<>(4);
        SkipList<Integer> skipList = new SkipList<>();
        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();
        //Q2 Skiplist will be add

        Integer [][] values = new Integer[arrOfCapacities.length][10];
        for (int i = 0; i< arrOfCapacities.length;i++){
            values[i] = createRandomArrays(10,arrOfCapacities[i]);
        }
        long times [][] = new long[4][7];
        Integer [][][] arr = create3DArray(arrOfCapacities);
        for(int j = 0 ;j< arrOfCapacities.length; j++ ){
            for (int i = 0; i< arr[j].length; i++){
                for (int k = 0; k < arr[j][i].length;k++){
                    binarySearchTree.add(arr[j][i][k]);
                    redBlackTree.add(arr[j][i][k]);
                    treeSet.add(arr[j][i][k]);
                    bTree.add(arr[j][i][k]);
                    skipList.add(arr[j][i][k]);
                    skipListSet.add(arr[j][i][k]);
                }
                System.out.println(evaluate.evaluateArr(values[j],redBlackTree::add));
                System.out.println(evaluate.evaluateArr(values[j],treeSet::add));
                System.out.println(evaluate.evaluateArr(values[j],bTree::add));
                System.out.println(evaluate.evaluateArr(values[j],skipList::add));
                System.out.println(evaluate.evaluateArr(values[j],skipListSet::add));
                System.out.println(evaluate.evaluateArr(values[j],binarySearchTree::add));
                binarySearchTree = new BinarySearchTree<>();
                redBlackTree = new RedBlackTree<>();
                treeSet = new TreeSet<>();
                bTree = new BTree<>(4);
                skipList = new SkipList<>();
                skipListSet = new ConcurrentSkipListSet<>();
            }
        }
    }
    public static Integer[][][] create3DArray(int [] arrOfCapacities){
        Integer [][][] arr = new Integer[4][10][];
        for(int j = 0 ;j< 4; j++ ){
            for (int i = 0; i< 10; i++){
                arr[j][i] = createRandomArrays(arrOfCapacities[j],arrOfCapacities[j]);
            }
        }
        return arr;
    }
    public static Integer[] createRandomArrays(int numberofarrays,int maxNumber){
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        while(set.size() != numberofarrays){
            set.add(random.nextInt(maxNumber * 2));
        }
        Integer [] arr = new Integer[numberofarrays];
        set.toArray(arr);
        return arr;
    }

}