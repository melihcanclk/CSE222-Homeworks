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
        skipList.add(56);
        skipList.add(489);
        skipList.add(18);
        skipList.add(61);
        skipList.add(26);
        skipList.add(47);
        skipList.add(23);
        System.out.println(skipList);
        System.out.println(skipList.find(44));
        skipList.remove(8);
        skipList.remove(23);
        skipList.remove(43);
        skipList.remove(21);
        skipList.remove(23);
        skipList.remove(47);
        skipList.remove(56);
        System.out.println(skipList);
    }
}