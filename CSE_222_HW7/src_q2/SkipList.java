import javax.sound.sampled.Line;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
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
	public SLNode<E> head;
	public static int size;
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
	static final int maxCapOfArray = 4;
	static final int minCapOfArray = 1;
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
		size = 1;
		maxLevel = 0;
		maxCap = computeMaxCap(maxLevel);
		LinkedList linkedList = new LinkedList();
		head = new SLNode(maxLevel,linkedList);
	}

	/**
	 * Search for an item in the list
	 * @param target The item being sought
	 * @return An SLNode array which references the predecessors of the target at each level.
	 */
	@SuppressWarnings("unchecked")
	private SLNode<E>[] search(E target){
		SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
		SLNode<E> current = head;
		for(int i = current.links.length - 1; i >= 0; i--){
			while(current.links[i] != null
					&& current.links[i].data.get(0).compareTo(target) < 0){
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
		int i = 0;
		while(i < pred[0].data.size()){
			if(pred[0].data.get(i).compareTo(target) == 0){
				return pred[0].data.get(i);
			} else {
				i++;
			}
		}
		return null;
	}

	/**
	 * Inserts the given item
	 * @param item The item to add
	 * @return true as the item is added
	 */
	boolean add(E item){
		SLNode<E>[] pred = search(item);
		if(pred.length != 0 && pred[0].data.indexOf(item) != -1 ){
			System.out.println(item + " is already in Skip List");
			return false;
		}
		if(size > maxCap){
			maxLevel++;
			maxCap = computeMaxCap(maxLevel);
			head.links = Arrays.copyOf(head.links, maxLevel);
			pred = Arrays.copyOf(pred, maxLevel);
			pred[maxLevel - 1] = head;
		}
		if(pred[0].data.size() < maxCapOfArray){
			pred[0].data.add(item);
			Collections.sort(pred[0].data);
			return true;
		}else if(pred[0].data.size() == maxCapOfArray){
			int returnVal = add(item,pred[0], 0);
			if(returnVal == -1){
				while(pred[0].links[0] != null)
					pred[0] = pred[0].links[0];
				size++;
				LinkedList<E> ll = new LinkedList<>();
				ll.add(pred[0].data.removeLast());
				SLNode<E> newNode = new SLNode<E>(logRandom(), ll);
				for(int i = 0; i < newNode.links.length; i++){
					newNode.links[i] = pred[i].links[i];
					pred[i].links[i] = newNode;
				}
			}
		}
		return true;
	}
	int add(E item, SLNode<E> node, int i){
		//---- -> --
		if(node.links[0] != null && node.links[0].data.size() < maxCapOfArray){
			if(i < 1){
				node.data.add(item);
				Collections.sort(node.data);
			}
			item = node.data.removeLast();
			node.links[0].data.addFirst(item);
			return 1;
		}else if(node.links[0] == null){
			if(i < 1){
				node.data.add(item);
				Collections.sort(node.data);
			}
			return -1;
		} else {
			//----
			if(i <= 1){
				node.data.add(item);
			}
			Collections.sort(node.data);
			item = node.data.removeLast();
			node.links[0].data.addFirst(item);
			return add(item,node.links[0],i+1);
		}
	}

	/**
	 * Removes an instance of the given item
	 * @param item The item to remove
	 * @return true if the item is removed, false if the item is not in the list
	 */
	boolean remove(E item){
		SLNode<E>[] pred = search(item);
		int index = 0;
		boolean isInclude = false;
		for(; index< pred[0].data.size();index++){
			if(pred[0].data.get(index).compareTo(item) == 0) {
				isInclude = true;
				break;
			}
		}
		if(!isInclude && pred[0].links[0] == null){
			System.out.println(item + " is not in this list");
			return false;
		}

		else if(!isInclude && pred[0].links[0].data.get(0).equals(item)){
			pred[0].links[0].data.remove(0);
			if(pred[0].links[0].data.size() == 0){
				size--; //don't re-adjust maxCap and level, as we may have nodes at these levels
				for(int i = 0; i < pred[0].links.length; i++){
					if(pred[i].links[i] != null)
						pred[i].links[i] = pred[0].links[i].links[i];
				}
			}
			return true;
		} else if (isInclude) {
			pred[0].data.remove(index);
			return true;
		} else {
			return false;
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
		SLNode itr = head;
		sc.append("Head: " + size);
		int lineMaker = 0;
		while(itr.links[0] != null){
			sc.append(" --> " + itr.toString());
			lineMaker++;
			if(lineMaker == 10){
				sc.append("\n");
				lineMaker = 0;
			}
			itr = itr.links[0];
		}
		sc.append(" --> " + itr.toString());
		return sc.toString();
	}

	/**
	 * Static class to contain data and links
	 *
	 * @param <E> The type of data stored. Must be a Comparable
	 */
	static class SLNode<E>{
		SLNode<E>[] links;
		LinkedList<E> data;

		/**
		 * Create a node of level m
		 * @param m The level of the node
		 * @param data The data to be stored
		 */
		@SuppressWarnings("unchecked")
		public SLNode(int m, LinkedList<E> data){
			links = (SLNode<E>[]) new SLNode[m];
			this.data = new LinkedList<>();
			this.data = data;
		}

		@Override
		public String toString() {
			return  "|"+ data + "|";
		}
	}
}
