import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        //test7();
        //test8();
        //test9();
        //test10();
        //test11();
        //test12();
        //test13();
        //test14();
        //test15();
        //test16();
        //test17();
        //test18();
        //test19();
        //test20();

    }

    public static void test1(){
        ExtendedGraph g = new ExtendedGraph(5,false);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println(g);
        g.insert(new Edge(3,4));
        System.out.println(g);
    }
    public static void test2(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println(g);
        g.insert(new Edge(3,4));
        System.out.println(g);
    }
    public static void test3(){
        ExtendedGraph g = new ExtendedGraph(5,false);
        g.insert(new Edge(2,5,5.4));
        g.insert(new Edge(2,1,2.5));
        g.insert(new Edge(3,5,23.4));
        g.insert(new Edge(5,1,4.56));
        System.out.println(g);
        g.insert(new Edge(3,4,123.98));
        System.out.println(g);
    }
    public static void test4(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5,5.4));
        g.insert(new Edge(2,1,2.5));
        g.insert(new Edge(3,5,23.4));
        g.insert(new Edge(5,1,4.56));
        System.out.println(g);
        g.insert(new Edge(3,4,123.98));
        System.out.println(g);
    }
    public static void test5(){
        ExtendedGraph g = new ExtendedGraph(5,false);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println(g);
        g.insert(new Edge(2,1));
        System.out.println(g);
    }
    public static void test6(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println(g);
        g.insert(new Edge(2,1));
        System.out.println(g);
    }
    public static void test7(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5,5.4));
        g.insert(new Edge(2,1,2.5));
        g.insert(new Edge(3,5,23.4));
        g.insert(new Edge(5,1,4.56));
        System.out.println(g);
        g.insert(new Edge(3,5,23.4));
        System.out.println(g);
    }
    public static void test8(){
        ExtendedGraph g = new ExtendedGraph(5,false);
        g.insert(new Edge(2,5,5.4));
        g.insert(new Edge(2,1,2.5));
        g.insert(new Edge(3,5,23.4));
        g.insert(new Edge(5,1,4.56));
        System.out.println(g);
        g.insert(new Edge(3,5,23.4));
        System.out.println(g);
    }
    public static void test9(){
        ExtendedGraph g = new ExtendedGraph(5,false);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println(g);
        g.deleteEdge(3,5);
        System.out.println(g);
    }
    public static void test10(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println(g);
        g.deleteEdge(3,5);
        System.out.println(g);
    }
    public static void test11(){
        ExtendedGraph g = new ExtendedGraph(5,false);
        g.insert(new Edge(2,5,5.4));
        g.insert(new Edge(2,1,2.5));
        g.insert(new Edge(3,5,23.4));
        g.insert(new Edge(5,1,4.56));
        System.out.println(g);
        g.deleteEdge(3,5);
        System.out.println(g);
    }
    public static void test12(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println(g);
        g.deleteEdge(3,5);
        System.out.println(g);
    }
    private static void test13() {
        ExtendedGraph g = new ExtendedGraph(5,false);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println(g);
        g.deleteEdge(1,1);
        System.out.println(g);
    }
    private static void test14() {
        ExtendedGraph g = new ExtendedGraph(5,false);
        g.insert(new Edge(2,5,5.4));
        g.insert(new Edge(2,1,2.5));
        g.insert(new Edge(3,5,23.4));
        g.insert(new Edge(5,1,4.56));
        System.out.println(g);
        g.deleteEdge(1,1);
        System.out.println(g);
    }
    public static void test15(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println(g.getNumV());
        g.insertVertex(8);
        System.out.println(g.getNumV());
    }
    public static void test16(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println("Number of vertices = " + g.getNumV());
        System.out.println(g);
        g.insert(new Edge(8,2));
        System.out.println("Number of vertices = " + g.getNumV());
        System.out.println(g);
        g.insertVertex(8);
        g.insert(new Edge(8,2));
        System.out.println("Number of vertices = " + g.getNumV());
        System.out.println(g);

    }
    public static void test17(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println("Number of vertices = " + g.getNumV());
        System.out.println(g);
        g.deleteVertex(3);
        System.out.println("Number of vertices = " + g.getNumV());
        System.out.println(g);
    }
    public static void test18(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        System.out.println(Arrays.toString(g.breathFirstSearch(2)));

    }
    public static void test19(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        int [] discoverOrder = new int [g.getNumV()];
        int [] finishOrder = new int [g.getNumV()];
        g.depthFirstSearch(2,discoverOrder,finishOrder);
        System.out.println(Arrays.toString(discoverOrder));
        System.out.println(Arrays.toString(finishOrder));

    }
    public static void test20(){
        ExtendedGraph g = new ExtendedGraph(5,true);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(2,3));
        g.insert(new Edge(3,5));
        g.insert(new Edge(5,1));
        Iterator<Edge> it = g.edgeIterator(2);
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
