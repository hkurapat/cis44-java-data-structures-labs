import java.util.LinkedList;

// insert is O(1) but removing requires scanning the whole list O(n)
public class UnsortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    public boolean isEmpty() { return list.isEmpty(); }

    // just add to the end of the list
    public void insert(K key, V value) {
        list.addLast(new MyEntry<>(key, value)); 
    }

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

    // find the min and then remove it
    public MyEntry<K, V> removeMin() {
        if (isEmpty()) return null;
        MyEntry<K, V> minEntry = min();
        list.remove(minEntry);
        return minEntry;
    }
}
