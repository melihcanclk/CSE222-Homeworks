/**
 * Edge Class that holds source, destination and weight
 */
public class Edge {
    /**
     * destination
     */
    private int dest;
    /**
     * source
     */
    private int source;
    /**
     * weight
     */
    private double weight;

    /**
     * Edge class constructor
     * @param source Source
     * @param dest Destination
     * @param w Weight
     */
    public Edge(int source, int dest, double w) {
        this.source = source;
        this.dest = dest;
        this.weight = w;
    }

    /**
     * Edge class constructor with default weight 1.0
     * @param source Source
     * @param dest Destionation
     */
    public Edge(int source, int dest) {
        this(source, dest, 1.0);
    }

    /**
     * Equal method Override
     * @param obj Edge object
     * @return If two Edges are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Edge))
            return false;

        Edge otherEdge = (Edge) obj;

        return (this.dest == otherEdge.dest && this.source == otherEdge.source);
    }

    /**
     * Getter for Destination
     * @return Destination
     */
    public int getDest() {
        return this.dest;
    }
    /**
     * Getter for Source
     * @return Source
     */
    public int getSource() {
        return this.source;
    }
    /**
     * Getter for Weight
     * @return Weight
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Override HashCode of Edge class
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        int hash = 5;

        hash = 31 * hash + dest;
        hash = 31 * hash + source;

        return hash;
    }

    /**
     * Overriden toString method as
     *      (source, destination, weight = ${weight})
     * @return String with given format above
     */
    @Override
    public String toString() {
        return String.format("(%d , %d , weight=%f)", source, dest, weight);
    }

}