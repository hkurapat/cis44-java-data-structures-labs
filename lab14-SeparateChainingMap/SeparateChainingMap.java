import java.util.ArrayList;
import java.util.LinkedList;

class Entry<K, V> {
    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }
}

interface MapADT<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
}

// --- 4. Implementation: Separate Chaining Hash Map ---
// this uses an ArrayList of LinkedLists as buckets
// when two keys hash to the same index they get chained in the same linked list
// this is the separate chaining collision resolution from the lecture slides
// get put and remove are all O(1) expected time
class SeparateChainingMap<K, V> implements MapADT<K, V> {
    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size = 0;
    private final int N = 11; // using a prime number for table capacity just like the slides said

    public SeparateChainingMap() {
        table = new ArrayList<>(N);
        // initialize each bucket with an empty linked list
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<Entry<K, V>>());
        }
    }

    // hash function converts key into valid array index
    // uses division method h(k) = key.hashCode() mod N ---> lecture slides
    private int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // get calculates the hash index then searches the bucket for the key
    // O(1) expected because we go directly to the right bucket
    public V get(K key) {
        // step 1 calculate the hash index to find the right bucket
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // step 2 search linearly within the bucket for the key
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        // step 3 key not found in bucket so return null
        return null;
    }

    // put calculates hash index then checks if key exists in the bucket
    // if it does update the value if not add a new entry to the front
    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // check if key already exists in the bucket and update it
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.setValue(value);
            }
        }

        // key is new so add to front of linked list and increment size
        bucket.addFirst(new Entry<>(key, value));
        size++;
        return null;
    }

    // remove finds the entry in the bucket and removes it
    public V remove(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            V oldValue = toRemove.getValue();
            bucket.remove(toRemove);
            size--;
            return oldValue;
        }
        return null;
    }
}
