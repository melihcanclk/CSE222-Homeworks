public class AgeSearchTree<E extends Comparable<E>> extends BinarySearchTree<E>{

    @Override
    public boolean add(E item) {
        return super.add(item);
    }

    @Override
    public E find(E target) {
        return super.find(target);
    }

    @Override
    public boolean remove(E target) {
        return super.remove(target);
    }

    public int youngerThan(int age){
        return youngerThan(root,age);
    }

    private int youngerThan(Node<E> localRoot, int age) {
        if(isNull(localRoot))
            return 0;
        int countLeft = youngerThan(localRoot.left, age);;
        int countRight = youngerThan(localRoot.right, age);

        return (((AgeData) localRoot.data).getAge() < age ? ((AgeData) localRoot.data).getNumberOfPeople() : 0) + countLeft + countRight;
    }

    public int olderThan(int age){
        return olderThan(root,age);
    }
    private int olderThan(Node<E> localRoot, int age) {
        if(isNull(localRoot))
            return 0;
        int countLeft = olderThan(localRoot.left, age);;
        int countRight = olderThan(localRoot.right, age);

        return (((AgeData) localRoot.data).getAge() > age ? ((AgeData) localRoot.data).getNumberOfPeople() : 0) + countLeft + countRight;
    }
    private boolean isNull(Node<E> localRoot){
        return localRoot == null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
