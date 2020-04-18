import java.io.*;

/** Class for a binary tree that stores type E objects. */
public class BinaryTree<E> implements Serializable {

	/** Class to encapsulate a tree node. */
	protected static class Node<E> implements Serializable {
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

	public BinaryTree() {
		root = null;
	}

	protected BinaryTree(Node<E> root) {
		this.root = root;
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<>(data);

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

	}

	public BinaryTree<E> getLeftSubtree() {
		if (root != null && root.left != null) {
			return new BinaryTree<>(root.left);
		} else {
			return null;
		}
	}

	public BinaryTree<E> getRightSubtree(){
		if(root!= null&& root.right != null){
			return new BinaryTree<>(root.right);
		}
		return null;
	}

	public E getData(){
		if(root == null){
			return null;
		}
		return root.data;
	}

	public String preOrderTraverse(){
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root,1,sb);
		return sb.toString();
	}

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

	public boolean isLeaf() {
		return (root.left == null && root.right == null);
	}

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

	public void writeObject(String nameofFile){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nameofFile));
			out.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	protected static ObjectInputStream readObject(String nameofFile) {
		try {
			return new ObjectInputStream(new FileInputStream(nameofFile));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}