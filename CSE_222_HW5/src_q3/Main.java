public class Main{
    public static void main(String[] args) {
        AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();
        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(15));
        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(25));
        ageTree.add(new AgeData(5));

        System.out.println(ageTree.youngerThan(20));
        System.out.println(ageTree.olderThan(6));
        System.out.println(ageTree);
        ageTree.remove(new AgeData(20));
        System.out.println(ageTree);
        ageTree.remove(new AgeData(20));
        System.out.println(ageTree);
        ageTree.remove(new AgeData(10));
        System.out.println(ageTree);
        ageTree.remove(new AgeData(10));
        System.out.println(ageTree);

    }
}