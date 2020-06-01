public class Main {
    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();
        skipList.add(5);
        skipList.add(8);
        skipList.add(54);
        skipList.add(43);
        skipList.add(12);
        skipList.add(64);
        skipList.add(23);
        skipList.add(44);
        skipList.add(21);
        System.out.println(skipList);
    }
}