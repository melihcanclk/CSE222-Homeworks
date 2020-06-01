import java.util.Arrays;
import java.util.Random;

/**
 * Implementation of a Skip-List data structure
 * @author Jacob / Koffman & Wolfgang
 *
 *@param <E> The type of data stored. Must be a Comparable
 */
public class SkipList<E extends Comparable<E>> {
	/**
	 * Head of the skip-list
	 */
	public GeneralNode<E> head;
	/**
	 * Size of the skip list
	 */
	private int size;
	/**
	 * The maximum level of the skip-list
	 */
	private int maxLevel;
	/**
	 * Smallest power of 2 that is greater than the current skip-list size
	 */
	private int maxCap;
	/**
	 * Natural log of 2
	 */
	static final double LOG2 = Math.log(2.0);
	/**
	 * Minimum possible integer value for the head
	 */
	static final int MIN = Integer.MIN_VALUE;
	/**
	 * Random number generator
	 */
	private Random rand = new Random();

	//Constructor

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SkipList(){
		size = 0;
		maxLevel = 0;
		maxCap = computeMaxCap(maxLevel);
		head = new GeneralNode<>(new SLNode(maxLevel, MIN, 0),null);
	}

	/**
	 * Search for an item in the list
	 * @param target The item being sought
	 * @return An SLNode array which references the predecessors of the target at each level.
	 */
	@SuppressWarnings("unchecked")
	private SLNode<E>[] search(E target){
		SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
		SLNode<E> current = head.node;
		for(int i = current.links.length - 1; i >= 0; i--){
			while(current.links[i] != null
					&& current.links[i].data[0].compareTo(target) < 0){
				current = current.links[i];
			}
			pred[i] = current;
		}
		return pred;
	}

	/**
	 * Find an object in the skip-list
	 * @param target The item being sought
	 * @return A reference to the object in the skip-list that matches
	 * 		   the target. If not found, null is returned
	 */
	public E find(E target){
		SLNode<E>[] pred = search(target);
		if(pred[0].links != null &&
				pred[0].links[0].data[0].compareTo(target) == 0){
			return pred[0].links[0].data[0];
		} else {
			return null;
		}
	}

	/**
	 * Inserts the given item
	 * @param item The item to add
	 * @return true as the item is added
	 */
	boolean add(E item){
		size++;
		SLNode<E>[] pred = search(item);
		if(size > maxCap){
			maxLevel++;
			maxCap = computeMaxCap(maxLevel);
			head.node.links = Arrays.copyOf(head.node.links, maxLevel);
			pred = Arrays.copyOf(pred, maxLevel);
			pred[maxLevel - 1] = head.node;
		}
		if(pred[0].cursor == SLNode.SIZE_OF_ARRAYS){
			SLNode<E> newNode = new SLNode<E>(logRandom(), item,0);
			for(int i = 0; i < newNode.links.length; i++){
				newNode.links[i] = pred[i].links[i];
				pred[i].links[i] = newNode;
			}
			GeneralNode<E> current = head;
			while(current.node != pred[0] && current.nextNode != null){
				current = current.nextNode;
			}
			current.nextNode = new GeneralNode<>(newNode, null);

		}else{
			pred[0].data[pred[0].cursor] = item;
			pred[0].cursor++;
		}
		return true;
	}

	/**
	 * Removes an instance of the given item
	 * @param item The item to remove
	 * @return true if the item is removed, false if the item is not in the list
	 */
	boolean remove(E item){
		SLNode<E>[] pred = search(item);
		if(pred[0].links != null &&
				pred[0].links[0].data[0].compareTo(item) != 0){
			return false; //item is not in the list
		} else {
			size--; //don't re-adjust maxCap and level, as we may have nodes at these levels
			SLNode<E> deleteNode = pred[0];
			for(int i = 0; i < deleteNode.links.length; i++){
				if(pred[i].links[i] != null)
					pred[i].links[i] = pred[i].links[i].links[i];
			}
			return true;
		}
	}


	/**
	 * Method to generate a logarithmic distributed integer between 1 and maxLevel.
	 *  I.E. 1/2 of the values are 1, 1/4 are 2, etc.
	 * @return a random logarithmic distributed int between 1 and maxLevel
	 */
	private int logRandom(){
		int r = rand.nextInt(maxCap);
		int k = (int) (Math.log(r + 1) / LOG2);
		if(k > maxLevel - 1)
			k = maxLevel - 1;
		return maxLevel - k;
	}

	/**
	 * Recompute the max cap
	 * @param level
	 * @return
	 */
	private int computeMaxCap(int level){
		return (int) Math.pow(2, level) - 1;
	}

	@SuppressWarnings("rawtypes")
	public String toString(){
		if(size == 0)
			return "Empty";
		StringBuilder sc = new StringBuilder();
		GeneralNode itr = head;
		sc.append("Head: " + maxLevel);
		int lineMaker = 0;
		while(itr != null){
			sc.append(" --> " + itr.node.toString());
			lineMaker++;
			if(lineMaker == 10){
				sc.append("\n");
				lineMaker = 0;
			}
			itr = itr.nextNode;
		}
		return sc.toString();
	}

	/**
	 * Static class to contain data and links
	 * @author Jacob / Koffman & Wolfgang
	 *
	 * @param <E> The type of data stored. Must be a Comparable
	 */
	static class SLNode<E>{
		private static final int SIZE_OF_ARRAYS = 5;
		SLNode<E>[] links;
		E []data;
		int cursor;
		/**
		 * Create a node of level m
		 * @param m The level of the node
		 * @param data The data to be stored
		 */
		@SuppressWarnings("unchecked")
		public SLNode(int m, E data,int index){
			links = (SLNode<E>[]) new SLNode[m];
			this.data = (E[])new Comparable[SIZE_OF_ARRAYS];
			this.data[index] = data;
			cursor = 1;
		}


		public String toString(){
			return (Arrays.toString(data) + " |" + links.length + "|");
		}
	}
	static class GeneralNode<E>{
		SLNode<E> node;
		GeneralNode<E> nextNode;

		public GeneralNode(SLNode<E> node, GeneralNode<E> nextNode) {
			this.node = node;
			this.nextNode = nextNode;
		}
	}
}
