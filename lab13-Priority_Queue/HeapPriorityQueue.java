import java.util.ArrayList;

// this implements a min heap using an ArrayList just like the lecture slides showed
public class HeapPriorityQueue<K extends Comparable<K>> {
    private ArrayList<K> heap = new ArrayList<>();

    // these helper methods use the same index formulas from the lecture slides
    protected int parent(int j) { return (j - 1) / 2; }
    protected int left(int j) { return 2 * j + 1; }
    protected int right(int j) { return 2 * j + 2; }

    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }

    private void swap(int i, int j) {
        K temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // add to end then bubble up to restore heap order property
    public void insert(K key) {
        heap.add(key);
        upheap(heap.size() - 1);
    }

    // save the root minimum then move last element to root and bubble down
    public K removeMin() {
        if (isEmpty()) return null;
        K answer = heap.get(0);
        K last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0);
        }
        return answer;
    }

    public K min() {
        return isEmpty() ? null : heap.get(0);
    }

    // upheap bubbles the element up until heap order is restored
    private void upheap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (heap.get(j).compareTo(heap.get(p)) >= 0) break;
            swap(j, p);
            j = p;
        }
    }

    // downheap bubbles the element down until heap order is restored
    private void downheap(int j) {
        while (left(j) < heap.size()) {
            int leftIndex = left(j);
            int smallChild = leftIndex;
            int rightIndex = right(j);

            if (rightIndex < heap.size() &&
                heap.get(rightIndex).compareTo(heap.get(leftIndex)) < 0) {
                smallChild = rightIndex;
            }

            if (heap.get(j).compareTo(heap.get(smallChild)) <= 0) break;

            swap(j, smallChild);
            j = smallChild;
        }
    }
}                      
