import java.util.LinkedList;

// --- 1. Entry ADT ---
// this holds the key and value pair just like the Entry ADT from the lecture slides
class MyEntry<K extends Comparable<K>, V> implements Comparable<MyEntry<K, V>> {
    private K key;
    private V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }

    @Override
    public int compareTo(MyEntry<K, V> other) {
        return this.key.compareTo(other.key);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

// --- 2. Common Interface ---
interface PriorityQueue<K extends Comparable<K>, V> {
    void insert(K key, V value);
    MyEntry<K, V> removeMin();
    MyEntry<K, V> min();
    boolean isEmpty();
}

// --- 3. Implementation 1: Unsorted List (LinkedList) ---
// Insert is O(1) because we just add to the end
// RemoveMin is O(n) because we have to scan the whole list to find the minimum
class UnsortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    public boolean isEmpty() { return list.isEmpty(); }

    // just add to the end of the list no comparisons needed
    public void insert(K key, V value) {
        list.addLast(new MyEntry<>(key, value)); // O(1)
    }

    // scan the whole list to find the minimum entry
    public MyEntry<K, V> min() {
        if (isEmpty()) return null;
        MyEntry<K, V> minEntry = list.getFirst();
        for (MyEntry<K, V> entry : list) {
            if (entry.compareTo(minEntry) < 0) {
                minEntry = entry;
            }
        }
        return minEntry;
    }

    // find the minimum entry then remove it from the list
    public MyEntry<K, V> removeMin() {
        if (isEmpty()) return null;
        // find the minimum entry by scanning the whole list
        MyEntry<K, V> minEntry = min();
        // remove it from the list and return it
        list.remove(minEntry);
        return minEntry;
    }
}

// --- 4. Implementation 2: Sorted List (LinkedList) ---
// Insert is O(n) because we have to find the right spot to keep it sorted
// RemoveMin is O(1) because the minimum is always at the front
class SortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    public boolean isEmpty() { return list.isEmpty(); }

    // find the correct position and insert to keep the list sorted by key
    public void insert(K key, V value) {
        MyEntry<K, V> newEntry = new MyEntry<>(key, value);

        // go through the list to find where this new entry belongs
        int i = 0;
        for (MyEntry<K, V> entry : list) {
            if (newEntry.compareTo(entry) < 0) {
                // found the spot where new entry is smaller so insert here
                list.add(i, newEntry);
                return;
            }
            i++;
        }
        // if we get here the new entry is the largest so add to the end
        list.addLast(newEntry);
    }

    // minimum is always at the front since list is sorted
    public MyEntry<K, V> min() {
        return isEmpty() ? null : list.getFirst(); // O(1)
    }

    // just remove from the front since minimum is always there
    public MyEntry<K, V> removeMin() {
        return isEmpty() ? null : list.removeFirst(); // O(1)
    }
}

// --- 5. Driver Class ---
public class ListPQDriver {
    public static void main(String[] args) {
        System.out.println("--- UnsortedListPQ (O(n) removal) ---");
        PriorityQueue<Integer, String> pq1 = new UnsortedListPQ<>();
        pq1.insert(5, "Task E");
        pq1.insert(1, "Task A");
        pq1.insert(10, "Task G");
        pq1.insert(3, "Task C");
        while (!pq1.isEmpty()) System.out.println("Removed: " + pq1.removeMin());

        System.out.println("\n--- SortedListPQ (O(n) insertion) ---");
        PriorityQueue<Integer, String> pq2 = new SortedListPQ<>();
        pq2.insert(5, "Task E");
        pq2.insert(1, "Task A");
        pq2.insert(10, "Task G");
        pq2.insert(3, "Task C");
        while (!pq2.isEmpty()) System.out.println("Removed: " + pq2.removeMin());
    }
}
