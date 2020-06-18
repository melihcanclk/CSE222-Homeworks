import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ConvertMazeToJunc {
    private static class Point implements Comparable<Point>{
        Integer x;
        Integer y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Returns a hash code value for the object. This method is
         * supported for the benefit of hash tables such as those provided by
         * {@link HashMap}.
         * <p>
         * The general contract of {@code hashCode} is:
         * <ul>
         * <li>Whenever it is invoked on the same object more than once during
         *     an execution of a Java application, the {@code hashCode} method
         *     must consistently return the same integer, provided no information
         *     used in {@code equals} comparisons on the object is modified.
         *     This integer need not remain consistent from one execution of an
         *     application to another execution of the same application.
         * <li>If two objects are equal according to the {@code equals(Object)}
         *     method, then calling the {@code hashCode} method on each of
         *     the two objects must produce the same integer result.
         * <li>It is <em>not</em> required that if two objects are unequal
         *     according to the {@link Object#equals(Object)}
         *     method, then calling the {@code hashCode} method on each of the
         *     two objects must produce distinct integer results.  However, the
         *     programmer should be aware that producing distinct integer results
         *     for unequal objects may improve the performance of hash tables.
         * </ul>
         * <p>
         * As much as is reasonably practical, the hashCode method defined
         * by class {@code Object} does return distinct integers for
         * distinct objects. (The hashCode may or may not be implemented
         * as some function of an object's memory address at some point
         * in time.)
         *
         * @return a hash code value for this object.
         * @see Object#equals(Object)
         * @see System#identityHashCode
         */
        @Override
        public int hashCode() {
            return Objects.hash(this.x,this.y);
        }

        /**
         * Indicates whether some other object is "equal to" this one.
         * <p>
         * The {@code equals} method implements an equivalence relation
         * on non-null object references:
         * <ul>
         * <li>It is <i>reflexive</i>: for any non-null reference value
         *     {@code x}, {@code x.equals(x)} should return
         *     {@code true}.
         * <li>It is <i>symmetric</i>: for any non-null reference values
         *     {@code x} and {@code y}, {@code x.equals(y)}
         *     should return {@code true} if and only if
         *     {@code y.equals(x)} returns {@code true}.
         * <li>It is <i>transitive</i>: for any non-null reference values
         *     {@code x}, {@code y}, and {@code z}, if
         *     {@code x.equals(y)} returns {@code true} and
         *     {@code y.equals(z)} returns {@code true}, then
         *     {@code x.equals(z)} should return {@code true}.
         * <li>It is <i>consistent</i>: for any non-null reference values
         *     {@code x} and {@code y}, multiple invocations of
         *     {@code x.equals(y)} consistently return {@code true}
         *     or consistently return {@code false}, provided no
         *     information used in {@code equals} comparisons on the
         *     objects is modified.
         * <li>For any non-null reference value {@code x},
         *     {@code x.equals(null)} should return {@code false}.
         * </ul>
         * <p>
         * The {@code equals} method for class {@code Object} implements
         * the most discriminating possible equivalence relation on objects;
         * that is, for any non-null reference values {@code x} and
         * {@code y}, this method returns {@code true} if and only
         * if {@code x} and {@code y} refer to the same object
         * ({@code x == y} has the value {@code true}).
         * <p>
         * Note that it is generally necessary to override the {@code hashCode}
         * method whenever this method is overridden, so as to maintain the
         * general contract for the {@code hashCode} method, which states
         * that equal objects must have equal hash codes.
         *
         * @param obj the reference object with which to compare.
         * @return {@code true} if this object is the same as the obj
         * argument; {@code false} otherwise.
         * @see #hashCode()
         * @see HashMap
         */
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Point){
                Point p = (Point)obj;
                return (p.x.equals(this.x) && p.y.equals(this.y));
            }
            return false;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         *
         * <p>The implementor must ensure
         * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
         * for all {@code x} and {@code y}.  (This
         * implies that {@code x.compareTo(y)} must throw an exception iff
         * {@code y.compareTo(x)} throws an exception.)
         *
         * <p>The implementor must also ensure that the relation is transitive:
         * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
         * {@code x.compareTo(z) > 0}.
         *
         * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
         * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
         * all {@code z}.
         *
         * <p>It is strongly recommended, but <i>not</i> strictly required that
         * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
         * class that implements the {@code Comparable} interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         *
         * <p>In the foregoing description, the notation
         * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
         * <i>signum</i> function, which is defined to return one of {@code -1},
         * {@code 0}, or {@code 1} according to whether the value of
         * <i>expression</i> is negative, zero, or positive, respectively.
         *
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         * is less than, equal to, or greater than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified object's type prevents it
         *                              from being compared to this object.
         */
        @Override
        public int compareTo(Point o) {
            if(this.x > o.x)
                return 1;
            else if(this.x < o.x)
                return -1;
            else
                return this.y.compareTo(o.y);

        }
    }
    private static class Distance{
        Point firstPoint;
        Point secondPoint;
        int distance;

        public Distance(Point firstPoint, Point secondPoint, int distance) {
            this.firstPoint = firstPoint;
            this.secondPoint = secondPoint;
            this.distance = distance;
        }
    }
    private static class EdgeWithComparable extends Edge implements Comparable<Edge>{

        /**
         * Construct an edge from source to dest and sets weight to 1.0
         *
         * @param source The source vertex for the edge
         * @param dest   The destination vertex for the edge
         */
        public EdgeWithComparable(int source, int dest) {
            super(source, dest);
        }

        /**
         * Construct an edge from source to dest with the given weight
         *
         * @param source The source vertex
         * @param dest   The destination vertex
         * @param weight The specified weight of the edge
         */
        public EdgeWithComparable(int source, int dest, double weight) {
            super(source, dest, weight);
        }

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         *
         * <p>The implementor must ensure
         * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
         * for all {@code x} and {@code y}.  (This
         * implies that {@code x.compareTo(y)} must throw an exception iff
         * {@code y.compareTo(x)} throws an exception.)
         *
         * <p>The implementor must also ensure that the relation is transitive:
         * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
         * {@code x.compareTo(z) > 0}.
         *
         * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
         * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
         * all {@code z}.
         *
         * <p>It is strongly recommended, but <i>not</i> strictly required that
         * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
         * class that implements the {@code Comparable} interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         *
         * <p>In the foregoing description, the notation
         * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
         * <i>signum</i> function, which is defined to return one of {@code -1},
         * {@code 0}, or {@code 1} according to whether the value of
         * <i>expression</i> is negative, zero, or positive, respectively.
         *
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         * is less than, equal to, or greater than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified object's type prevents it
         *                              from being compared to this object.
         */
        @Override
        public int compareTo(Edge o) {
            if(this.getSource() > o.getSource())
                return 1;
            else if(this.getSource() < o.getSource())
                return -1;
            else
                return Integer.compare(this.getDest(), o.getDest());
        }
    }

    private static final int [] control = {-1, 0, 1, 0};
    private static int X;
    private static int Y;
    private static boolean [][] sol;
    private static boolean [][] isJunc;

    public static char[][] read(Scanner scan){
        ArrayList<String> array = new ArrayList<>();
        int sizex = 0;
        while (scan.hasNextLine()){
            String x = scan.nextLine();
            if(x.length() > 0)
                sizex = x.length();
            array.add(x);
        }
        char [][] charArray= new char[array.size()][sizex];
        for (int i = 0; i< array.size();i++){
            charArray[i] = array.get(i).toCharArray();
        }
        X = charArray[0].length;
        Y = charArray.length;
        return charArray;

    }
    public static Map<Point, Integer> convert(char[][] charArray){
        sol = new boolean[charArray.length][charArray[0].length];
        isJunc = new boolean[charArray.length][charArray[0].length];
        Stack<Point> arr = new Stack<>();
        ArrayList<Distance> distArr = new ArrayList<>();
        arr.add(new Point(0,0));
        isJunc[0][0] = true;
        findJunctions(charArray,0,0, arr, distArr,0);
        Set<Point> pointSet = new HashSet<>();
        for(Distance p : distArr){
            pointSet.add(p.firstPoint);
            pointSet.add(p.secondPoint);
            System.out.println("(" + p.firstPoint.x + " " + p.firstPoint.y + ") (" + p.secondPoint.x + " " + p.secondPoint.y + ") " + p.distance);
        }
        Map<Point,Integer> map = new LinkedHashMap<>();
        int i = 0;
        for(Point p:pointSet){
            map.put(p,i);
            i++;
        }
        try {
            FileWriter myWriter = new FileWriter("src_q3/graphWillBeRead.txt");
            myWriter.write(String.valueOf(pointSet.size()) + "\n");
            List<EdgeWithComparable> edgeList = new ArrayList<>();
            for(Point p :pointSet){
                for(Distance distance : distArr){
                    if(distance.firstPoint.equals(p)){
                        Point secondPoint = distance.secondPoint;
                        int firstVertex = map.get(secondPoint);
                        int secVertex = map.get(p);
                        edgeList.add(new EdgeWithComparable(firstVertex,secVertex,distance.distance));
                    }else if(distance.secondPoint.equals(p)){
                        Point firstPoint = distance.firstPoint;
                        int firstVertex = map.get(firstPoint);
                        int secVertex = map.get(p);
                        edgeList.add(new EdgeWithComparable(firstVertex,secVertex,distance.distance));
                    }
                }
            }
            Collections.sort(edgeList);
            for(EdgeWithComparable edge:edgeList){
                myWriter.write(edge.getSource() + "," + edge.getDest() + "," + (int) edge.getWeight() + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return map;
    }

    /**
     * Finds distance between junctions of given maze and returns them as Arraylist of Distance class
     * @param maze Maze as 2-D char array
     * @param x starting point x of maze
     * @param y starting point y of maze
     * @param pointStack Queue that keep track of last entered Point type variable
     * @param dist distance Arraylist that keeps distances
     * @param distCounter counter for count distance between junctions
     */
    public static void findJunctions(char[][] maze, int x, int y, Stack<Point> pointStack, ArrayList<Distance> dist, int distCounter){
        ArrayList<Point> points = isJunction(maze, x, y);
        sol[y][x] = true;
        if(points.size() != 1 ){
            isJunc[y][x] = true;
            Point firstPoint = pointStack.pop();
            Point secondPoint = new Point(x,y);
            if(isJunc[y][x] && points.size() > 1)
                for(int i = 0; i< points.size() ;i++){
                    pointStack.add(new Point(x,y));
                }
            if(points.size() != 0){
                dist.add(new Distance(firstPoint,secondPoint,distCounter));
            }else{
                if(isOut(y,x-1) && isJunc[y][x-1]){
                    dist.add(new Distance(firstPoint,new Point(secondPoint.x - 1, secondPoint.y),distCounter+1));
                } else if(isOut(y,x+1) && isJunc[y][x+1]){
                    dist.add(new Distance(firstPoint,new Point(secondPoint.x + 1, secondPoint.y),distCounter+1));
                } else if(isOut(y+1,x) && isJunc[y+1][x]){
                    dist.add(new Distance(firstPoint,new Point(secondPoint.x, secondPoint.y + 1),distCounter+1));
                } else if(isOut(y-1,x) && isJunc[y-1][x]){
                    dist.add(new Distance(firstPoint,new Point(secondPoint.x, secondPoint.y - 1),distCounter+1));
                } else{
                    dist.add(new Distance(firstPoint,secondPoint,distCounter));

                }
            }
            distCounter = 0;
        }
        for (Point point : points) {
            findJunctions(maze, point.x, point.y, pointStack, dist, distCounter + 1);
            if(isDone(maze))
                return;
        }
    }

    private static boolean isDone(char[][] maze) {
        for(int i = 0; i< sol.length;i++){
            for(int j = 0; j < sol[0].length;j++){
                if(!sol[i][j] || maze[i][j] == '0'){
                    return false;
                }
            }
        }
        return true;
    }

    private static ArrayList<Point> isJunction(char[][] charArray, int x, int y){
        ArrayList<Point> counter = new ArrayList<>();
        for(int i = 0; i< control.length;i++){
            int sideX = x + control[i % control.length];
            int sideY = y + control[(i+1) % control.length];
            if((isSafe(sideX,sideY) && !isJunc[sideY][sideX] && charArray[sideY][sideX] == '0' )){
                counter.add(new Point(sideX,sideY));
            }
        }
        return counter;
    }


    private static boolean isSafe(int x, int y)
    {
        // if (x, y outside maze) return false
        return (x >= 0 && x < X && y >= 0 && y < Y && !sol[y][x]);
    }

    private static boolean isOut(int x, int y)
    {
        // if (x, y outside maze) return false
        return (x >= 0 && x < X && y >= 0 && y < Y);
    }

    public static void mainFunc(String arg) {
        int numV = 0; // The number of vertices.
        Graph theMaze = null;
        //Load the graph from a file.
        Map<Point, Integer> returnMap = null;
        try {
            Scanner scan = new Scanner(new File(arg));
            char [][] readCharArray = ConvertMazeToJunc.read(scan);
            returnMap = ConvertMazeToJunc.convert(readCharArray);
            scan = new Scanner(new File("src_q3/graphWillBeRead.txt"));
            theMaze = AbstractGraph.createGraph(scan, false, "List");
            numV = theMaze.getNumV();
        } catch (IOException ex) {
            System.err.println("IO Error while reading graph");
            System.err.println(ex.toString());
            System.exit(1);
        }
        //Perform breadth-first search
        int[] parent = BreadthFirstSearch.breadthFirstSearch(theMaze, returnMap.get(new Point(X-1, Y-1)));
        //Construct the path
        Stack thePath = new Stack();
        int v = 0;
        while(parent[v] != -1){
            thePath.push(new Integer(v));
            v = parent[v];
        }
        //Add final point at the end of the stack
        thePath.push( returnMap.get(new Point(X-1, Y-1)));
        Stack<Point> figureOut = new Stack<>();
        //Get all route
        while(thePath.size() != 0)
            figureOut.push(getKey(returnMap,(Integer)thePath.pop()));
        //Output the path.
        System.out.println("The shortest path is:");
        while(!figureOut.empty()){
            System.out.println(figureOut.pop());
        }
    }
    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}
