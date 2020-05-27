public interface KWHashMap<K, V> {
	/**
	 * Get method that gets object
	 * @param key Key of object that will be looking for
	 * @return null if not found, otherwise, value of the key
	 */
	V get(Object key);

	/**
	 * Returns if KWHashMap is Empty or not
	 * @return True if empty
	 */
	boolean isEmpty();

	/**
	 * Put Value with Key key
	 * @param key Key that will be put value
	 * @param value Value that will be put to KWHashMap
	 * @return null if not put, otherwise, value of the key
	 */
	V put(K key, V value);

	/**
	 * Remove Entry with Key key
	 * @param key Key that will be removed
	 * @return null if not removed, otherwise, value of the key
	 */
	V remove(Object key);

	/**
	 * Size of KWHashMap
	 * @return Size of KWHashMap
	 */
	int size();
}
