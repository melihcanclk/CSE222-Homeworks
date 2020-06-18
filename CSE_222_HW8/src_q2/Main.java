import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ExtendedGraph g = new ExtendedGraph(5,false);
        g.insert(new Edge(2,5));
        g.insert(new Edge(2,1));
        g.insert(new Edge(5,7));
        System.out.println(g);
        //g.deleteEdge(4,3);
        //System.out.println(g);
        g.insertVertex(7);
        g.insertVertex(6);
        g.insert(new Edge(5,7));
        System.out.println(g + " number of vertex = " + g.getNumV());
        Iterator<Edge> it = g.edgeIterator(5);
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //bfs
        System.out.println(Arrays.toString(g.breathFirstSearch(2)));

        //dfs
        int [] discoveryOrder = new int[g.getNumV()];
        int [] finishOrder = new int[g.getNumV()];

        g.depthFirstSearch(2,discoveryOrder,finishOrder);
        System.out.println(Arrays.toString(discoveryOrder));
        System.out.println(Arrays.toString(finishOrder));
    }
}
