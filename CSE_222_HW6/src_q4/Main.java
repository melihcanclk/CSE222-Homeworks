import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        KWHashMap<Integer,Integer> mymap = null;
        StringBuilder sb = new StringBuilder();

        sb.append("Type of Hash Table;").append("Name of function;").append("NanoSeconds\n");
        for (int j = 0; j < 3; j++) {
           for (int i = 0; i< 4;i++) {
               long put = 0;
               long get = 0;
               long remove = 0;
               if (i == 0) {
                   mymap = new HashTableOpen<>();
                   sb.append("Hash Table Open;");
               } else if (i == 1) {
                   mymap = new NewHashTableOpen<>();
                   sb.append("My Hash Table Open;");
               } else if (i == 2) {
                   mymap = new HashTableChain<>();
                   sb.append("Hash Table Chain;");
               } else {
                   mymap = new BTHashTableChain<>();
                   sb.append("Binary Tree Hash Table Chain;");
               }
               if (j == 0) {
                   put = putMethod(mymap, 1000);
                   sb.append("put;").append(put).append("\n");
               } else if (j == 1) {
                   get = getMethod(mymap, 1000);
                   sb.append("get;").append(get).append("\n");
               } else {
                   remove = removeMethod(mymap, 1000);
                   sb.append("remove;").append(remove).append("\n");
               }
           }
       }
        try (PrintWriter printWriter = new PrintWriter(new File("1801042092_output.csv"))){

            printWriter.write(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());

    }
    public static long putMethod(KWHashMap<Integer, Integer> map, int number){

        long timeMillis = 0;
        for (int i = 0; i< number;i++){
            for (int j = 0; j< number;j++){
                long start = System.nanoTime();
                map.put(i,j);
                long finish = System.nanoTime();
                timeMillis = timeMillis + ( finish - start);
            }
        }
        return timeMillis;
    }
    public static long getMethod(KWHashMap<Integer, Integer> map, int number){
        long timeMillis = 0;
        for (int i = 0; i< number;i++){
            long start = System.nanoTime();
            map.get(i);
            long finish = System.nanoTime();
            timeMillis = timeMillis + ( finish - start);
        }
        return timeMillis;
    }
    public static long removeMethod(KWHashMap<Integer, Integer> map, int number){
        long timeMillis = 0;
        for (int i = 0; i< number;i++){
            long start = System.nanoTime();
            map.remove(i);
            long finish = System.nanoTime();
            timeMillis = timeMillis + ( finish - start);
        }
        return timeMillis;
    }

}
