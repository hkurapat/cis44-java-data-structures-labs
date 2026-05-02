import java.util.LinkedList;

// insert is O(n) to keep it sorted but removeMin is O(1)
public class SortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    public boolean isEmpty() { return list.isEmpty(); }

    // find the right spot to keep the list sorted by key
    public void insert(K key, V value) {
        MyEntry<K, V> newEntry = new MyEntry<>(key, value);
        int i = 0;
        for (MyEntry<K, V> entry : list) {
            if (newEntry.compareTo(entry) < 0) {
                list.add(i, newEntry);
                return;
            }
            i++;
        }
        list.addLast(newEntry);
    }

    public MyEntry<K, V> min() {
        return isEmpty() ? null : list.getFirst();
    }

    public MyEntry<K, V> removeMin() {
        return isEmpty() ? null : list.removeFirst();
    }
}
