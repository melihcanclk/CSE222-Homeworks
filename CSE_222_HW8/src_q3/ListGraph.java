import java.util.*;

/**
 * An implementation of a graph that uses an array of lists to represent the edges
 *
 */
public class ListGraph extends AbstractGraph {
	//Data Fields
	/**
	 * An array of Lists to contain the edges that originate with each vertex
	 */
	private List<Edge>[] edges;

	/**
	 * Construct a graph with the specified number of vertices and directionality
	 * @param numV The number of vertices
	 * @param directed The directionality flag
	 */
	@SuppressWarnings("unchecked")
	public ListGraph(int numV, boolean directed) {
		super(numV, directed);
		edges = new List[numV];
		for(int i = 0; i < numV; i++){
			edges[i] = new LinkedList<Edge>();
		}
	}

	/**
	 * Is given source and destination represents an edge
	 * @param source source index
	 * @param dest destination index
	 * @return if given source and destination represents edge or not
	 */
	public boolean isEdge(int source, int dest){
		return edges[source].contains(new Edge(source, dest));
	}

	/**
	 * Inserts an edge into List Graph
	 * @param edge Edge data field that will be inserted
	 */
	public void insert(Edge edge){
		edges[edge.getSource()].add(edge);
		if(!isDirected()){
			edges[edge.getDest()].add(new Edge(edge.getDest(), 
											   edge.getSource(), 
											   edge.getWeight()));
		}
	}

	/**
	 * Iterator of edge that traverse edges with given source
	 * @param source source of edge that will be traversed
	 * @return Iterator of a given source
	 */
	public Iterator<Edge> edgeIterator(int source){
		return edges[source].iterator();
	}

	/**
	 * Getting Edge Class Type with given source and destination
	 * @param source source of an edge
	 * @param dest destination of an edge
	 * @return edge with given source and destination
	 */
	public Edge getEdge(int source, int dest){
		Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
		for(Edge edge : edges[source]){
			if(edge.equals(target))
				return edge; //Desired edge found; return it
		}
		return target; //Desired edge not found.
	}

	/**
	 * toString method of Edges
	 * @return  Edges
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		int end = edges.length;
		for(int i=0; i < end; i++){
			sb.append("Node " + i + "-->\n");
			for(Edge e : edges[i]){
				sb.append("\tnode: " + e.getDest() + ", weight: " + e.getWeight() + "\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Loades edges From file as given below
	 *    source,dest,weight
	 * @param scan The Scanner connected to the data file
	 */
	@Override
	public void loadEdgesFromFile(Scanner scan){
		//System.out.println(edges.length);
		while(scan.hasNextLine())//while there are still more edges
		{
			Edge e = parseFileString(scan.nextLine());//parse a new Edge
			edges[e.getSource()].add(e); //Add the edge to the list of its source's edges
		}
		scan.close();
	}

	/**
	 * Returns edge with given file
	 * @param input One line
	 * @return Edge
	 */
	private Edge parseFileString(String input)
	{
		Edge toReturn = null;//initialize an Edge to return
		Scanner sc = new Scanner(input);//scan a line as an edge
		sc.useDelimiter(AbstractGraph.DELIM);//use only comma delimiter
		try
		{ //in case we fail to parse anything, such as format didn't work
			int source = sc.nextInt();//scan x position of point
			
			int dest = sc.nextInt();//scan y position of point
			double weight = Edge.UNWEIGHTED_EDGE;
			if(sc.hasNextDouble())
				weight = sc.nextDouble(); //parse in the weight if it's there
			toReturn = new Edge(source, dest, weight);
		}
		catch(Exception e)	
		{
			System.out.println("Failed to parse Edge: "+input);
		}		
		sc.close();//close scanner
		return toReturn;//return the scanned point
	}

}
