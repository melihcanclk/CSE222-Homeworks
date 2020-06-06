import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Main {
    static Random random = new Random(5);
    public static void main(String[] args) {
        int [] arrOfCapacities = {10000,20000,40000,80000};
        Evaluate<Integer> evaluate = new Evaluate<>();
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        BTree<Integer> bTree = new BTree<>(4);
        SkipList<Integer> skipList = new SkipList<>();
        SkipListArray<Integer> skipListArray = new SkipListArray<>();
        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();
        //Q2 Skiplist will be add


        long[][] times_add = new long[4][7];
        long[][] times_delete = new long[4][7];

        for(int j = 0 ;j< arrOfCapacities.length; j++ ){
            Integer [] values = new Integer[10];
            for (int k = 0; k< 10;k++){
                values[k] = k + arrOfCapacities[j];
            }
            for (int i = 0; i< 10; i++){
                Integer [] arr = createRandomArrays(arrOfCapacities[j],arrOfCapacities[j]);
                for (Integer integer : arr) {
                    binarySearchTree.add(integer);
                    redBlackTree.add(integer);
                    treeSet.add(integer);
                    bTree.add(integer);
                    skipList.add(integer);
                    skipListSet.add(integer);
                    skipListArray.add(integer);
                }
                System.out.println("ADDING");
                times_add[j][0] += evaluate.evaluateArr(values,binarySearchTree::add);
                times_add[j][1] += evaluate.evaluateArr(values,redBlackTree::add);
                times_add[j][2] += evaluate.evaluateArr(values,treeSet::add);
                times_add[j][3] += evaluate.evaluateArr(values,bTree::add);
                times_add[j][4] += evaluate.evaluateArr(values,skipList::add);
                times_add[j][5] += evaluate.evaluateArr(values,skipListSet::add);
                times_add[j][6] += evaluate.evaluateArr(values,skipListArray::add);
                System.out.println("DELETING");
                for (int k = 0; k< 10;k++){
                    values[k] =arrOfCapacities[j] - k * 2;
                }
                times_delete[j][0] += evaluate.evaluateArr(values,binarySearchTree::delete);
                //times_delete[j][1] += evaluate.evaluateArr(values,redBlackTree::delete);
                times_delete[j][2] += evaluate.evaluateArr(values,treeSet::remove);
                //times_delete[j][3] += evaluate.evaluateArr(values,bTree::delete);
                times_delete[j][4] += evaluate.evaluateArr(values,skipList::remove);
                times_delete[j][5] += evaluate.evaluateArr(values,skipListSet::remove);
                times_delete[j][6] += evaluate.evaluateArr(values,skipListArray::remove);
                binarySearchTree = new BinarySearchTree<>();
                redBlackTree = new RedBlackTree<>();
                treeSet = new TreeSet<>();
                bTree = new BTree<>(4);
                skipList = new SkipList<>();
                skipListSet = new ConcurrentSkipListSet<>();
                skipListArray = new SkipListArray<>();
            }
            System.out.println("Addition Results");
            System.out.println("Binary Search Tree" + " "+ (arrOfCapacities[j]) + " "+ times_add[j][0] /10);
            System.out.println("RedBlackTree" + " "+(arrOfCapacities[j]) +" " + times_add[j][1]/10);
            System.out.println("TreeSet" + " "+(arrOfCapacities[j]) +" " + times_add[j][2]/10);
            System.out.println("B-Tree" + " "+(arrOfCapacities[j]) +" " + times_add[j][3]/10);
            System.out.println("SkipList(Book)" + " "+(arrOfCapacities[j]) +" " + times_add[j][4]/10);
            System.out.println("SkipList(Java)" + " "+(arrOfCapacities[j]) +" " + times_add[j][5]/10);
            System.out.println("SkipList(Q2)" + " "+(arrOfCapacities[j]) +" " + times_add[j][6]/10);
            System.out.println();
            System.out.println("Deletion Results");
            System.out.println("Binary Search Tree" + " "+ (arrOfCapacities[j]) + " "+ times_delete[j][0]/10);
            System.out.println("RedBlackTree" + " "+(arrOfCapacities[j]) +" " + times_delete[j][1]/10);
            System.out.println("TreeSet" + " "+(arrOfCapacities[j]) +" " + times_delete[j][2]/10);
            System.out.println("B-Tree" + " "+(arrOfCapacities[j]) +" " + times_delete[j][3]/10);
            System.out.println("SkipList(Book)" + " "+(arrOfCapacities[j]) +" " + times_delete[j][4]/10);
            System.out.println("SkipList(Java)" + " "+(arrOfCapacities[j]) +" " + times_delete[j][5]/10);
            System.out.println("SkipList(Q2)" + " "+(arrOfCapacities[j]) +" " + times_delete[j][6]/10);
            System.out.println();
        }
    }
    public static Integer[] createRandomArrays(int numberofelement,int maxNumber){
        Set<Integer> set = new LinkedHashSet<>();
        while(set.size() != numberofelement){
            set.add(random.nextInt(maxNumber));
        }
        Integer [] arr = new Integer[numberofelement];
        set.toArray(arr);
        return arr;
    }
}