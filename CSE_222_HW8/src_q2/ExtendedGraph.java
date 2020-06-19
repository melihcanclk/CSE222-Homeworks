import java.util.*;

public class ExtendedGraph extends AbstractGraph{
    /**
     * Head node that keeps head of 2-D linkedlist
     */
    private static Node head;

    /**
     * Node class that represents Nodes of Linkedlist
     */
    private static class Node{
        /**
         * Edge of node
         */
        private Edge edge;
        /**
         * Row Previous of Node
         */
        private Node r_prev;
        /**
         * Row Next of Node
         */
        private Node r_next;
        /**
         * Column Previous of Node
         */
        private Node c_prev;
        /**
         * Column Next of Node
         */
        private Node c_next;

        /**
         * Node class constructor
         * @param source Source
         * @param dest Destination
         * @param weight Weight
         * @param r_prev Row Previous
         * @param r_next Row Next
         * @param c_prev Column Previous
         * @param c_next Column Next
         */
        public Node(int source, int dest, double weight, Node r_prev, Node r_next, Node c_prev, Node c_next) {
            this(source,dest,weight);
            this.r_prev = r_prev;
            this.r_next = r_next;
            this.c_prev = c_prev;
            this.c_next = c_next;
        }

        /**
         * Node class Constructor with no next or prev Node classes
         * @param source Source
         * @param dest Destination
         * @param weight Weight
         */
        public Node(int source, int dest, double weight) {
            this.edge = new Edge(source, dest, weight);
        }
        @Override
        public String toString(){
            return edge.toString();
        }
    }
    /**
     * Construct a graph with the specified number of vertices and the directed
     * flag. If the directed flag is true, this is a directed graph.
     *
     * @param numV     The number of vertices
     * @param directed The directed flag
     */
    public ExtendedGraph(int numV, boolean directed) {
        super(numV, directed);
        head = new Node(0,0,Double.POSITIVE_INFINITY);
        Node tempCurr = head;
        for (int i = 1; i<= numV ;i++){
            Node tempBefore = tempCurr;
            tempCurr = new Node(0,i,Double.POSITIVE_INFINITY,tempBefore,null,null, null);
            tempBefore.r_next = tempCurr;
        }
        tempCurr = head;
        for (int i = 1; i<= numV ;i++){
            Node tempBefore = tempCurr;
            tempCurr = new Node(i,0,Double.POSITIVE_INFINITY,null,null,tempBefore, null);
            tempBefore.c_next = tempCurr;
        }
    }

    /**
     * Find Row and Column nodes next to head node
     * @param source Source
     * @param dest Destination
     * @return Node[0] gives top Node of head with given source
     *          Node[1] gives left Node of head with given destination
     */
    private Node[] findRowAndColumn(int source, int dest){
        Node temp_col;
        Node temp_row = temp_col =  head;
        boolean flag = true;
        while(temp_row != null && flag){
            if(temp_row.edge.getDest() == dest){
                flag = false;
            }
            if(flag)
                temp_row = temp_row.r_next;
        }
        flag = true;
        while(temp_col != null && flag){
            if(temp_col.edge.getSource() == source){
                flag = false;
            }
            if(flag)
                temp_col = temp_col.c_next;
        }
        Node [] nodes = new Node[2];
        nodes[0] = temp_row;
        nodes[1] = temp_col;
        return nodes;
    }

    /**
     * Find Node with given source and destination
     * @param source Source
     * @param dest Destination
     * @return Node type node with given source and destination. If not found, returns null
     */
    private Node findNode(int source, int dest){
        Node [] nodes = findRowAndColumn(source, dest);
        Node temp = nodes[0];
        temp = temp.c_next;
        //from row towards down
        while (temp != null){
            if(temp.edge.getDest() == dest && temp.edge.getSource() == source){
                return temp;
            }
            temp = temp.c_next;
        }
        return null;
    }

    /**
     * Inserts new Edge to Graph
     * @param edge The new edge
     */
    @Override
    public void insert(Edge edge) {
        int source = edge.getSource();
        int dest = edge.getDest();
        double weight = edge.getWeight();
        insert(source,dest,weight);
        if(!isDirected()){
            insert(dest,source,weight);
        }
    }

    /**
     * Inserts new Edge to Graph
     * @param source Source
     * @param dest Destination
     * @param weight Weight
     */
    private void insert(int source,int dest, double weight){

        Node [] nodes = findRowAndColumn(source,dest);
        Node temp_row = nodes[0];
        Node temp_col = nodes[1];
        if(temp_col != null && temp_row != null){
            Node tempPredRow = temp_row;
            while (temp_row != null && temp_row.edge.getSource() < source){

                tempPredRow = temp_row;
                temp_row = temp_row.c_next;
            }
            Node tempPredCol = temp_col;
            while (temp_col != null && temp_col.edge.getDest() < dest ){

                tempPredCol = temp_col;
                temp_col = temp_col.r_next;
            }
            if(temp_col!= null && temp_row != null )
                if(weight == 1.0){
                    if(temp_col.edge.getDest() == dest && temp_row.edge.getSource() == source){
                        System.out.println(new Node(source,dest,weight) + " Already Exists");
                        return;
                    }
                } else{
                    if(temp_col.edge.getDest() == dest && temp_row.edge.getSource() == source && temp_col.edge.getWeight() == weight && temp_row.edge.getWeight() == weight){
                        System.out.println(new Node(source,dest,weight) + " Already Exists");
                        return;
                    }
                }
            Node node = new Node(source,dest,weight,tempPredCol, temp_col,tempPredRow,temp_row);

            tempPredCol.r_next = node;
            if(temp_col != null){
                temp_col.r_prev = node;
            }
            tempPredRow.c_next = node;
            if(temp_row != null){
                temp_row.c_prev = node;
            }
        }else{
            System.out.println("No vertex with " + (temp_col == null ? source: dest));
        }

    }

    /**
     * Returns if given source and destination vertexes represents an edge or not
     * @param source The source vertex
     * @param dest   The destination vertex
     * @return if  given source and destination vertexes represents an edge or not
     */
    @Override
    public boolean isEdge(int source, int dest) {
        return getEdge(source,dest) != null;
    }

    /**
     * Getting Edge with given Source and destination vertexes
     * @param source The source vertex
     * @param dest   The destination vertex
     * @return Edge with given Source and destination vertexes
     */
    @Override
    public Edge getEdge(int source, int dest) {
        Node n = findNode(source,dest);
        return (n == null? null :n.edge);
    }

    /**
     * edgeIterator
     * @param source The source vertex
     * @return Iterator with Edge class
     */
    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return new GraphIterator(source);

    }

    /**
     * Deletes edge. If undirected, deletes both direction
     * @param source source index of edge
     * @param dest destination index of edge
     * @return edge that is deleted
     */
    public Edge deleteEdge(int source, int dest) {
        Node n = findNode(source,dest);
        if(n != null){
            Edge e = deleteEdge(n).edge;
            if (!isDirected()) {
                n = findNode(dest,source);
                if(n!=null){
                    deleteEdge(n);
                }
            }
            return e;
        }else{
            System.out.println("No edge " + source + " , " + dest);
            return null;
        }
    }

    /**
     * Delete operation
     * @param n node that will be deleted
     * @return Edge object of deleted node
     */
    private Node deleteEdge(Node n){
        if(n.r_next != null){
            n.r_next.r_prev = n.r_prev;
        }
        if(n.c_next != null){
            n.c_next.c_prev = n.c_prev;
        }
        n.c_prev.c_next = n.c_next;
        n.r_prev.r_next = n.r_next;
        n.r_prev = null;
        n.c_prev = null;
        n.r_next = null;
        n.c_next = null;
        return n;
    }

    /**
     * Inserts a vertex to head Node source and destinations
     * @param source source vertex
     */
    public void insertVertex(int source) {
        Node temp = head;
        //Gets pred of position of node will be insert
        while(temp.c_next != null && temp.c_next.edge.getSource() < source){
            if(temp.c_next.edge.getSource() == source){
                System.out.println("We have vertex " + source);
                return;
            }
            temp = temp.c_next;
        }
        Node n = new Node(source,0,Double.POSITIVE_INFINITY,null, null, temp, temp.c_next);
        if(temp.c_next != null){
            temp.c_next.c_prev = n;
        }
        temp.c_next = n;

        temp = head;
        while(temp.r_next != null && temp.r_next.edge.getDest() < source){
            if(temp.r_next.edge.getDest() == source){
                System.out.println("We have vertex " + source);
                return;
            }
            temp = temp.r_next;
        }
        n = new Node(0,source,Double.POSITIVE_INFINITY,temp, temp.r_next, null, null);
        if(temp.r_next != null){
            temp.r_next.r_prev = n;
        }
        temp.r_next = n;
        setNumV(getNumV() + 1);
    }

    /**
     * Delete all Edges in the given source
     * @param source Source will be deleted
     */
    public void deleteVertex(int source) {
        Node left = findRowAndColumn(source,0 )[1];
        Node top = findRowAndColumn(0,source)[0];
        Node templeft = left.r_next;
        Node tempTop = top.c_next;
        while(templeft != null){
            deleteEdge(templeft);

            templeft = left.r_next;
        }
        while(tempTop != null){
            deleteEdge(tempTop);
            tempTop = top.c_next;
        }
        setNumV(getNumV() - 1);
    }

    /**
     * Breath First Search with starting vertex
     * @param start Starting Vertex
     * @return Parent int array
     */
    public int[] breathFirstSearch(int start){
        Queue<Integer> theQueue = new LinkedList<Integer>();
        //Declare array parent and initialize its elements to -1
        int[] parent = new int[getNumV() + 2];
        for(int i = 0; i < getNumV() + 2; i++){
            parent[i] = -1;
        }
        //Declare array identified and initialize its elements to false
        boolean[] identified = new boolean[getNumV() + 2];
        /* Mark the start vertex as identified and insert it into the queue */
        identified[start] = true;
        theQueue.offer(start);

        /* Perform breadth-first search until done */
        while(!theQueue.isEmpty()){
            /* Take a vertex, current, out of the queue. Begin visiting current */
            int current = theQueue.remove();
            /* Examine each vertex, neighbor, adjacent to current. */
            Iterator<Edge> itr = edgeIterator(current);
            while(itr.hasNext()){
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                //If neighbor has not been identified
                if(!identified[neighbor]){
                    //Mark it identified
                    identified[neighbor] = true;
                    //Place it into the queue
                    theQueue.offer(neighbor);
                    /* Insert the edge (current, neighbor) into the tree */
                    parent[neighbor] = current;
                }
            }
            //Finished visiting current
        }
        return parent;
    }

    /**
     * Depth First Search
     * @param startingIndex Starting Index
     * @param discoveryOrder Discovery Order
     * @param finishOrder Finish Order
     */
    public void depthFirstSearch(int startingIndex,  int [] discoveryOrder, int [] finishOrder) {
        int n = getNumV();
        int finishIndex;
        boolean[] visited;
        int[] parent;
        System.arraycopy(discoveryOrder,0,discoveryOrder,0,discoveryOrder.length);
        System.arraycopy(finishOrder,0,finishOrder,0,finishOrder.length);
        visited = new boolean[n +2 ];
        parent = new int[n + 2];
        finishIndex = finishOrder.length;
        for(int i = 0; i < n; i++){
            parent[i] = -1; //Declare array parent and initialize its elements to -1
        }
        for(int i = 0; i < n; i++){
            if(!visited[i])
                dFS( startingIndex, visited, discoveryOrder, parent, finishOrder, finishIndex);
        }
    }

    /**
     * Depth First Search private method
     * @param startingIndex Starting index
     * @param visited Visited boolean array
     * @param discoveryOrder int array discover order
     * @param parent Parent array
     * @param finishOrder int array finish order
     * @param finishIndex finish index
     */
    private void dFS(int startingIndex, boolean[] visited , int[] discoveryOrder, int[] parent, int[] finishOrder, int finishIndex){
        // Let s be a stack, then push the start vertex onto it
        int discoverIndex = 0;
        Stack<Integer> s = new Stack<Integer>();
        s.push(startingIndex);
        //While s is not empty
        while(!s.isEmpty()){
            int v = s.pop();
            //If v is not discovered
            if(!visited[v]){
                //label v as discovered
                visited[v] = true;
                discoveryOrder[discoverIndex++] = v;
                //For all edges adjacent to v
                Iterator<Edge> itr = edgeIterator(v);
                while(itr.hasNext()){
                    int u = itr.next().getDest();
                    s.push(u);
                    parent[u] = v;
                }
                finishIndex = finishIndex - 1;
                finishOrder[finishIndex] = v;
            }
        }

    }

    /**
     * Graph Iterator class that implements Iterator with Edge generic type
     */
    private static class GraphIterator implements Iterator<Edge>{
        /**
         * Node that holds left Nodes
         */
        Node node;

        /**
         * Constructor of Iterator
         * @param source Source
         */
        GraphIterator(int source){
            node = head;
            for (int i = 0; i< source;i++){
                node = node.c_next;
            }
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return node.r_next != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Edge next() {
            node = node.r_next;
            if(node != null)
                return new Edge(node.edge.getSource(), node.edge.getDest(), node.edge.getWeight());
            else
                return null;
        }
    }

    /**
     * toString method that prints all Edges in the Graph
     * @return String with all edges
     */
    @Override
    public String toString(){
       StringBuilder sb = new StringBuilder();
       Node n_col = head;
       while(n_col.c_next != null){
           Node n_row = n_col.c_next;
           while(n_row.r_next != null){
               Node n = n_row.r_next;
               sb.append(n).append(" ");
               n_row = n_row.r_next;
           }
           n_col = n_col.c_next;
       }
        return sb.toString();
    }
}
