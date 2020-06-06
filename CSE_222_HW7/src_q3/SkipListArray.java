
import java.util.*;

/**
 * Implementation of a Skip-List data structure
 * @author Jacob / Koffman & Wolfgang
 *
 *@param <E> The type of data stored. Must be a Comparable
 */
public class SkipListArray<E extends Comparable<E>> {
	/**
	 * Head of the skip-list
	 */
	public GeneralNode<E> head;
	/**
	 * Size of the skip list
	 */
	private int size;
	/**
	 * Natural log of 2
	 */
	static final double LOG2 = Math.log(2.0);
	/**
	 * Minimum possible integer value for the head
	 */
	static final Integer MIN = Integer.MIN_VALUE;

	//Constructor

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SkipListArray(){
		size = 1;
		head = new GeneralNode<>(null, new SLNode(),null );
	}

	/**
	 * Search for an item in the list
	 * @param target The item being sought
	 * @return An SLNode array which references the predecessors of the target at each level.
	 */
	@SuppressWarnings("unchecked")
	private GeneralNode<E> search(E target){

		GeneralNode<E> current = head;
		while(current.nextNode != null && target.compareTo(current.node.data.get(current.node.data.size() - 1)) > 0){
			current = current.nextNode;
		}
		return current;
	}

	/**
	 * Find an object in the skip-list
	 * @param target The item being sought
	 * @return A reference to the object in the skip-list that matches
	 * 		   the target. If not found, null is returned
	 */
	public E find(E target){
		GeneralNode<E> pred = search(target);
		for(int i = 0; i< pred.node.data.size();i++) {
			if (pred.node.data.get(i) != null &&
					pred.node.data.get(i) .compareTo(target) == 0) {
				return pred.node.data.get(i) ;
			}
		}
		return null;
	}

	/**
	 * Inserts the given item
	 * @param item The item to add
	 * @return true as the item is added
	 */
	boolean add(E item) {
		GeneralNode<E> pred = search(item);
		int index = pred.node.data.indexOf(item);
		if (index == -1) {
			pred.node.data.add(item);
			Collections.sort(pred.node.data);
			while(pred.node.data.size() == SLNode.SIZE_OF_ARRAYS + 1){
				if(pred.nextNode == null){
					pred.nextNode = new GeneralNode<>(pred,new SLNode<>(pred.node.data.get(pred.node.data.size() - 1)),null);
					pred.node.data.remove(pred.nextNode.node.data.get(0));
				}else{
					pred.nextNode.node.data.add(pred.node.data.get(pred.node.data.size() - 1));
					pred.node.data.remove(pred.node.data.size() -1);
					Collections.sort(pred.nextNode.node.data);
				}
				pred = pred.nextNode;
			}
		}else{
			return false;
		}
		return true;
	}
	/**
	 * Removes an instance of the given item
	 * @param item The item to remove
	 * @return true if the item is removed, false if the item is not in the list
	 */
	boolean remove(E item){
		GeneralNode<E> pred = search(item);
		int index = pred.node.data.indexOf(item);
		if(index != -1){
			pred.node.data.remove(index);
			if(pred.beforeNode != null){
				if(pred.beforeNode.node.data.size() + pred.node.data.size() == SLNode.SIZE_OF_ARRAYS){
					pred.beforeNode.node.data.addAll(pred.node.data);
					if(pred.nextNode == null){

					}else{
						pred.beforeNode.nextNode = pred.nextNode;
						pred.nextNode.beforeNode = pred.beforeNode;
					}
					pred = null;
				}
			}else if(pred.nextNode != null){
				if(pred.nextNode.node.data.size() + pred.node.data.size() == SLNode.SIZE_OF_ARRAYS){
					pred.nextNode.node.data.addAll(pred.node.data);
					pred.beforeNode.nextNode = pred.nextNode;
					pred.nextNode.beforeNode = pred.beforeNode;
					pred = null;
				}
			}
		}else{
			return false;
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	public String toString(){
		if(size == 0)
			return "Empty";
		StringBuilder sc = new StringBuilder();
		GeneralNode itr = head;
		sc.append("Head: " + size);
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

		List<E> data;
		int cursor;
		/**
		 * Create a node of level m
		 * @param data The data to be stored
		 */
		@SuppressWarnings("unchecked")
		public SLNode(E data){
			this.data = new ArrayList<>();
			this.data.add(data);
			cursor = 0;
		}
		public SLNode(){
			this.data = new ArrayList<>();
			cursor = 0;
		}


		public String toString(){
			return (data + " |" +  "|");
		}
	}
	static class GeneralNode<E>{
		SLNode<E> node;
		GeneralNode<E> nextNode;
		GeneralNode<E> beforeNode;

		public GeneralNode( GeneralNode<E> beforeNode,SLNode<E> node, GeneralNode<E> nextNode) {
			this.node = node;
			this.nextNode = nextNode;
			this.beforeNode = beforeNode;
		}
	}
}