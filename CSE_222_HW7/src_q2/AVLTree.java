public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> {
//TODO : Remove method will be add to AVLTree
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private boolean increase;
    private boolean decrease;

    private static class AVLNode<E> extends Node<E> {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        public static final int LEFT_HEAVY = -1;
        public static final int BALANCED = 0;
        public static final int RIGHT_HEAVY = 1;
        private int balance;

        public AVLNode(E item) {
            super(item);
            balance = BALANCED;
        }

        @Override
        public String toString() {
            return balance + ": " + super.toString();
        }
    }
    

    @Override
    public boolean add(E item) {
        increase = false;
        root = add((AVLNode<E>) root, item);
        return addReturn;
    }

    private AVLNode<E> add(AVLNode<E> localroot, E item) {
        if (localroot == null) {
            addReturn = true;
            increase = true;
            return new AVLNode<E>(item);
        }
        else if (item.compareTo(localroot.data) == 0) {
            increase = false;
            addReturn = false;
            return localroot;
        } else if (item.compareTo(localroot.data) < 0) {
            localroot.left = add((AVLNode<E>) localroot.left, item);
        } 
        if (increase) {
            decrementBalance(localroot);
            if (localroot.balance < AVLNode.LEFT_HEAVY) {
                increase = false;
                return rebalanceLeft(localroot);
            }
        }
        else if (item.compareTo(localroot.data) > 0) {
            localroot.right = add((AVLNode<E>) localroot.right, item);
        }
        if (increase) {
            incrementBalance(localroot);
            if(localroot.balance > AVLNode.RIGHT_HEAVY){
                increase = false;
                return rebalanceRight(localroot);
            }
        }
        
        return localroot;
    }

    private AVLNode<E> rebalanceRight(AVLNode<E> localroot) {
        AVLNode<E> rightChild = (AVLNode<E>) localroot.right;
        if(rightChild != null){
            if (rightChild.balance < AVLNode.BALANCED) {
                AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;
                if (rightLeftChild.balance < AVLNode.BALANCED) {
                    rightChild.balance = AVLNode.BALANCED;
                    rightLeftChild.balance = AVLNode.BALANCED;
                    localroot.balance = AVLNode.LEFT_HEAVY;
                } else {
                    rightChild.balance = AVLNode.RIGHT_HEAVY;
                    rightLeftChild.balance = AVLNode.BALANCED;
                    localroot.balance = AVLNode.BALANCED;
                }
                localroot.left = rotateRight(rightChild);
            } else {
                rightChild.balance = AVLNode.BALANCED;
                localroot.balance = AVLNode.BALANCED;
            }
        }
        return (AVLNode<E>) rotateLeft(localroot);    
    }

    private void decrementBalance(AVLNode<E> node) {
        node.balance--;
        if (node.balance == AVLNode.BALANCED) {
            increase = false;
        }
    }
    private void incrementBalance(AVLNode<E> node) {
        node.balance++;
        if (node.balance == AVLNode.BALANCED) {
            increase = false;
        }
    }

    private AVLNode<E> rebalanceLeft(AVLNode<E> localroot) {
        AVLNode<E> leftChild = (AVLNode<E>) localroot.left;
        if(leftChild != null){
            if (leftChild.balance > AVLNode.BALANCED) {
                AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
                if (leftRightChild.balance < AVLNode.BALANCED) {
                    leftChild.balance = AVLNode.BALANCED;
                    leftRightChild.balance = AVLNode.BALANCED;
                    localroot.balance = AVLNode.RIGHT_HEAVY;
                } else {
                    leftChild.balance = AVLNode.LEFT_HEAVY;
                    leftRightChild.balance = AVLNode.BALANCED;
                    localroot.balance = AVLNode.BALANCED;
                }
                localroot.left = rotateLeft(leftChild);
            } else {
                leftChild.balance = AVLNode.BALANCED;
                localroot.balance = AVLNode.BALANCED;
            }
        }
        return (AVLNode<E>) rotateRight(localroot);
    }

}
