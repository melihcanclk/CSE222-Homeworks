public class BinarySearchTree<E extends Comparable<E>>
        extends BinaryTree<E>
        implements SearchTree<E> {
    private boolean addReturn = Boolean.parseBoolean(null);
    private E deleteReturn = null;
    @Override
    public boolean add(E item) {
        root = add(root,item);
        return addReturn;
    }
    private Node<E> add(Node<E> localRoot, E item){
        if(localRoot == null){
            addReturn = true;
            return new Node<E>(item);
        }else if(item.compareTo(localRoot.data) == 0){
            addReturn = false;
            return localRoot;
        }else if(item.compareTo(localRoot.data) < 0){
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        }else{
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    @Override
    public boolean contains(E target) {
        return false;
    }

    @Override
    public E find(E target) {
        return find(root,target);
    }
    private E find(Node<E> localRoot, E target){
        if(localRoot == null){
            return null;
        }else{
            int compResult = target.compareTo(localRoot.data);
            if(compResult == 0){
                return localRoot.data;
            }else if(compResult<0){
                return find(root.left, target);
            }else {
                return find(root.right, target);
            }
        }
    }

    @Override
    public E delete(E target) {
        root = delete(root,target);
        return deleteReturn;
    }

    private Node<E> delete(Node<E> localRoot, E item) {
        if(localRoot == null){
            deleteReturn = null;
        }
        int compareResult = item.compareTo(localRoot.data);
        if(compareResult == -2){
            return localRoot;
        }
        else if(compareResult < 0){
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }else if(compareResult>0){
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
        else{
            deleteReturn = localRoot.data;
            if(localRoot.left == null){
                return localRoot.right;
            }else if(localRoot.right == null){
                return localRoot.left;
            }else{
                if(localRoot.left.right == null){
                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }else {
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    private E findLargestChild(Node<E> parent) {
        if(parent.right.right == null){
            E returnValue = parent.right.data;
            parent.right = parent.right. left;
            return returnValue;
        }else{
            return findLargestChild(parent.right);
        }
    }

    @Override
    public boolean remove(E target) {
        E returnVal = delete(target);
        if(returnVal == null)
            return false;
        return true;
    }
}
