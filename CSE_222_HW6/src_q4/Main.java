public class Main {
    public static void main(String[] args) {
        KWHashMap<Integer,Integer> map = new NewHashTableOpen<>();
        map.put(5,5);
        map.put(6,4);
        map.put(98,4);
        map.put(654,6);
        map.put(7,4);
        map.put(6,1);
        map.put(5,1);



        System.out.println(map);

    }
}
