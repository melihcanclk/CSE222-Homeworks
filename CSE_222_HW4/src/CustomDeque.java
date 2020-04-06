import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

class CustomDeque<T> implements Deque<T> {

    LinkedList<T> mainLinkedList;
    LinkedList<T> trashLinkedList;

    CustomDeque(){
        clear();
    }

    @Override
    public void addFirst(T e) {
        ListNode<T> newNode;
        if(trashLinkedList.isEmpty()){
            newNode = new ListNode<T>(null, e,null);
        }else {
            newNode = trashLinkedList.removeLast();
            newNode.data = e;
        }
        mainLinkedList.addFront(newNode);
    }

    @Override
    public void addLast(T e) {
        ListNode<T> newNode;
        if(trashLinkedList.isEmpty()){
            newNode = new ListNode<T>(null, e,null);
        }else {
            newNode = trashLinkedList.removeLast();
            newNode.data = e;
        }
        mainLinkedList.addEnd(newNode);
    }

    @Override
    public boolean offerFirst(T e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(T e) {
        addLast(e);
        return true;
    }

    @Override
    public T removeFirst() {
        ListNode<T> listNode = mainLinkedList.removeFirst();
        trashLinkedList.addEnd(listNode);
        return listNode.data;
    }

    @Override
    public T removeLast() {
        ListNode<T> listNode = mainLinkedList.removeLast();
        trashLinkedList.addEnd(listNode);
        return listNode.data;
    }

    @Override
    public T pollFirst() {
        return removeFirst();
    }

    @Override
    public T pollLast() {
        return removeLast();
    }

    @Override
    public T getFirst() {
        return mainLinkedList.getFirst();
    }

    @Override
    public T getLast() {
        return mainLinkedList.getLast();
    }

    @Override
    public T peekFirst() {
        if(mainLinkedList.isEmpty())
            return null;
        else {
            return getFirst();
        }
    }

    @Override
    public T peekLast() {
        if(mainLinkedList.isEmpty())
            return null;
        else {
            return getLast();
        }
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(T e) {
        if(e == null){
            throw new NullPointerException();
        }
        try{
            this.addFirst(e);
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean offer(T e) {
        return add(e);
    }

    @Override
    public T remove() {
        return removeFirst();
    }

    @Override
    public T poll() {
        return remove();
    }

    @Override
    public T element() {
        return mainLinkedList.head.data;
    }

    @Override
    public T peek() {
        if(mainLinkedList.isEmpty()){
            return null;
        }else {
            return element();
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        try {
            throw new CustomNotImplementedException();
        } catch (CustomNotImplementedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        try {
            throw new CustomNotImplementedException();
        } catch (CustomNotImplementedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        try {
            throw new CustomNotImplementedException();
        } catch (CustomNotImplementedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void clear() {
        mainLinkedList = new LinkedList<>();
        trashLinkedList = new LinkedList<>();
    }

    @Override
    public void push(T e) {
        addFirst(e);
    }

    @Override
    public T pop() {
        return removeFirst();
    }


    @Override
    public boolean remove(Object o) {
        ListNode<T> listNode = mainLinkedList.head;
        while (listNode != null){
            if(listNode.data.equals(o)){
                if(listNode == mainLinkedList.head){
                    ListNode<T> temp = mainLinkedList.head;
                    listNode = listNode.next;
                    mainLinkedList.head = listNode;
                    temp.next = null;
                    listNode.prev = null;
                }else if(listNode == mainLinkedList.tail){
                    ListNode<T> temp = mainLinkedList.tail;
                    listNode = listNode.prev;
                    mainLinkedList.tail = listNode;
                    temp.prev = null;
                    listNode.prev = null;
                }else {
                    listNode.prev.next = listNode.next;
                    listNode.next.prev = listNode.prev;
                    listNode.next = null;
                    listNode.prev = null;
                }
            }
            listNode = listNode.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        try {
            throw new CustomNotImplementedException();
        } catch (CustomNotImplementedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        ListNode<T> listNode = mainLinkedList.head;
        while (listNode != null){
            if(listNode.data.equals(o)){
                return true;
            }
            listNode = listNode.next;
        }
        return false;
    }

    @Override
    public int size() {
        return mainLinkedList.size();
    }
    @Override
    public boolean isEmpty() {
        return mainLinkedList.head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int current = 0;
            ListNode<T> node;
            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
                current++;
                return node.next.data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        try {
            throw new CustomNotImplementedException();
        } catch (CustomNotImplementedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            int current = mainLinkedList.size() - 1;
            ListNode<T> node;
            @Override
            public boolean hasNext() {
                return node.prev != null;
            }

            @Override
            public T next() {
                current--;
                return node.prev.data;
            }
        };
    }

    @Override
    public String toString() {
        return"Deque=" + mainLinkedList;
    }
}
