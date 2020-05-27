public class BTHashTableChain<K extends Comparable<K>,V> implements KWHashMap<K,V>{

    private BinaryTree<Entry<K,V>> [] table;
    private int numKeys;
    private static final int CAPACITY = 101;
    private static final double LOAD_THRESHOLD = 3.0;

    BTHashTableChain(){
        table = new BinaryTree[CAPACITY];
    }
    private static class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        @Override
        public int compareTo(Entry<K, V> o) {
            return 0;
        }
    }
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null)
            return null;
        for (BinaryTree<Entry<K, V>> entryBinaryTree : table) {
            Entry<K,V> entry = entryBinaryTree.getData();
            if(entry.key.equals(key))
                return entry.value;
        }
        return null;
    }

    private void rehash(){
        BinaryTree<Entry<K,V>>[] tempTable = table;
        table = new BinaryTree[2 * tempTable.length + 1];
        numKeys = 0;
        for(int i = 0; i< tempTable.length; i++){
            if(tempTable[i] != null){
                Entry<K,V> e = tempTable[i].getData();
                put(e.key,e.value);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return numKeys <= 0;
    }

    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null){
            table[index] = new BinaryTree<Entry<K, V>>();
        }
        V returnVal = replaceValue(key,value,table[index]);
        if(returnVal != null){
            return returnVal;
        }else {
            table[index].add(new Entry<>(key,value));
            numKeys++;
            if(numKeys > (LOAD_THRESHOLD * table.length))
                rehash();
            return null;
        }
    }

    private V replaceValue(K key, V value, BinaryTree<Entry<K,V>> tree) {
        BinaryTree.Node<Entry<K,V>> node = tree.root;
        while(node != null){
            if(node.data.key.equals(key)){
                node.data.value = value;
                return node.data.value;
            }
            node = (node.left.data.compareTo(node.right.data) < 0) ? node.left : node.right;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null){
            return null;
        }
        Entry<K,V> e = table[index].deleteKey(new Entry<K,V>((K)key,null)).data;
        if(e == null){
            return null;
        }else {
            numKeys--;
            return e.value;
        }
    }

    @Override
    public int size() {
        return numKeys;
    }
}
