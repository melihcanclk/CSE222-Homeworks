public class Main {
    public static void main(String[] args) {
        KWHashMap<Integer,Integer> map = new BTHashTableChain<>();
        map.put(5,5);
        map.put(5,4);
        map.size();
        System.out.println(map.isEmpty());
    }
}
