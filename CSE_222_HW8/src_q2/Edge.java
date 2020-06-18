public class Edge {

    private int dest;
    private int source;

    private double weight;

    public Edge(int source, int dest, double w) {
        this.source = source;
        this.dest = dest;
        this.weight = w;
    }

    public Edge(int source, int dest) {
        this(source, dest, 1.0);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Edge))
            return false;

        Edge otherEdge = (Edge) obj;

        return (this.dest == otherEdge.dest && this.source == otherEdge.source);
    }
    public int getDest() {
        return this.dest;
    }

    public int getSource() {
        return this.source;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public int hashCode() {
        int hash = 5;

        hash = 31 * hash + dest;
        hash = 31 * hash + source;

        return hash;
    }

    @Override
    public String toString() {
        return String.format("(%d , %d , weight=%.1f)", source, dest, weight);
    }

}