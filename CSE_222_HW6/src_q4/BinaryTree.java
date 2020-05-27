import java.io.*;

/** Class for a binary tree that stores type E objects. */
public class BinaryTree<E extends Comparable<E>> implements Serializable {

	/** Class to encapsulate a tree node. */
	protected static class Node<E extends Comparable<E>> implements Serializable {
		// Data Fields
		/** The information stored in this node. */
		protected E data;
		/** Reference to the left child. */
		protected Node<E> left;
		/** Reference to the right child. */
		protected Node<E> right;

		// Constructors

		/**
		 * Construct a node with given data and no children.
		 * 
		 * @param data The data to store in this node
		 * 
		 */

		public Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}

		public boolean isLeaf() {
			return (this.left == null && this.right == null);
		}

		// Methods
		/**
		 * Return a string representation of the node.
		 * 
		 * @return A string representation of the data fields.
		 */

		public String toString() {
			return data.toString();
		}

	}

	// Data Field
	/** The root of the binary tree */
	protected Node<E> root;
	private int size;

	public BinaryTree() {
		root = null;
		this.size = 0;
	}

	protected BinaryTree(Node<E> root) {
		this.root = root;
		this.size = 1;
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<>(data);
		size = 1;
		if (leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		} else {
			root.right = null;
		}
		if(leftTree != null ||rightTree != null){
			size++;
		}
	}

	/**
	 * Getting Left Sub Tree
	 * @return BinaryTree Node Root
	 */
	public BinaryTree<E> getLeftSubtree() {
		if (root != null && root.left != null) {
			return new BinaryTree<>(root.left);
		} else {
			return null;
		}
	}
	/**
	 * Getting Right Sub Tree
	 * @return BinaryTree Node Root
	 */
	public BinaryTree<E> getRightSubtree(){
		if(root!= null&& root.right != null){
			return new BinaryTree<>(root.right);
		}
		return null;
	}

	/**
	 * Getting Data
	 * @return Data
	 */
	public E getData(){
		if(root == null){
			return null;
		}
		return root.data;
	}

	/**
	 * Traverse Pre Order
	 * @return Pre Order Traverse
	 */
	public String preOrderTraverse(){
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root,1,sb);
		return sb.toString();
	}

	/**
	 * Traverse Pre Order
	 * @param node Node
	 * @param depth Depth
	 * @param sb String will be builded
	 */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for(int i = 1; i< depth;++i)
			sb.append("  ");

		if(node == null)
			sb.append("null\n");
		else{
			sb.append(node.toString()).append("\n");
			preOrderTraverse(node.left,depth+1,sb);
			preOrderTraverse(node.right,depth+1,sb);
		}
	}

	/**
	 * toString method
	 * @return String that will be constructed
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(root, 1, sb);
		return sb.toString();
	}

	private void toString(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append("  ");
		}
		if (node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.toString());
			sb.append("\n");
			toString(node.left, depth + 1, sb);
			toString(node.right, depth + 1, sb);
		}
	}

	/**
	 * Writing object as output stream
	 * @param nameofFile name of file
	 */
	public void writeObject(String nameofFile){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nameofFile));
			out.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Reading input stream
	 * @param nameofFile name of file
	 * @return ObjectInputStream
	 */
	protected static ObjectInputStream readObject(String nameofFile) {
		try {
			return new ObjectInputStream(new FileInputStream(nameofFile));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	public int getSize(){
		return getSize(root);
	}
	private int getSize(Node<E> node){
		if (node == null)
			return 0;
		else
		{
			/* compute the depth of each subtree */
			int lDepth = getSize(node.left);
			int rDepth = getSize(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	public void add(E value) {
		root = addRecursive(root, value);
	}

	private Node<E> addRecursive(Node<E> current, E value) {
		if (current == null) {
			return new Node<E>(value);
		}

		if (current.data.compareTo(value) > 0) {
			current.left = addRecursive(current.left, value);
		} else if (current.data.compareTo(value) < 0) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	Node<E> deleteKey(E key)
	{
		return deleteRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	private Node<E> deleteRec(Node<E> root, E key)
	{
		if (root == null)  return root;

		if (key.compareTo(root.data) < 0) {
			root.left = deleteRec(root.left, key);
		} else if (key.compareTo(root.data) > 0) {
			root.right = deleteRec(root.right, key);
		}

		else
		{

			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.data = minValue(root.right);
			root.right = deleteRec(root.right, root.data);
		}

		return root;
	}
	private E minValue(Node<E> root)
	{
		E minv = root.data;
		while (root.left != null)
		{
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}
}