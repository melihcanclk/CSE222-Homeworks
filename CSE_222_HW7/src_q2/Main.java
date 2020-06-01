public class Main {
    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();
        skipList.add(5);
        skipList.add(8);
        skipList.add(54);
        skipList.add(43);
        System.out.println(skipList);
    }
}