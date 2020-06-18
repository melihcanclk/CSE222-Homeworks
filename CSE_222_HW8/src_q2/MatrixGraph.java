import java.util.Iterator;

public class MatrixGraph extends AbstractGraph {
    
    double[][] edges;

    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void insert(Edge edge) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEdge(int source, int dest) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Edge getEdge(int source, int dest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        // TODO Auto-generated method stub
        return null;
    }

}