import java.util.ArrayList;

// This is the min heap based priority queue for the customer service scheduler
// it uses an ArrayList internally
// both insert and removeMin are O(log n) because of upheap and downheap
public class SmartScheduler {

    private ArrayList<TicketEntry> heap = new ArrayList<>();

    private int parent(int j) { return (j - 1) / 2; }
    private int left(int j) { return 2 * j + 1; }
    private int right(int j) { return 2 * j + 2; }

    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }

    private void swap(int i, int j) {
        TicketEntry temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // insert adds the ticket to the end then bubbles it up to restore heap order
    // this is O(log n) because upheap travels at most the height of the tree
    public void insert(int key, String value) {
        TicketEntry newTicket = new TicketEntry(key, value);
        heap.add(newTicket);
        upheap(heap.size() - 1);
    }

    // removeMin always removes the root which is the highest priority ticket -----> replaces root with last element then bubbles down to restore heap order
    // this is O(log n) because downheap travels at most the height of the tree
    public TicketEntry removeMin() {
        if (isEmpty()) return null;
        TicketEntry min = heap.get(0);
        TicketEntry last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0);
        }
        return min;
    }

    // min returns the highest priority ticket without removing it
    // this is O(1) because the minimum is always at the root
    public TicketEntry min() {
        return isEmpty() ? null : heap.get(0);
    }

    // upheap bubbles the element up until heap order property is restored
    private void upheap(int j) {
        while (j > 0) {
            int p = parent(j);
            // if child is greater than or equal to parent heap order is good
            if (heap.get(j).compareTo(heap.get(p)) >= 0) break;
            // otherwise swap with parent and keep it going up
            swap(j, p);
            j = p;
        }
    }

    // downheap bubbles the element down until heap order property is restored
    private void downheap(int j) {
        while (left(j) < heap.size()) {
            int leftIndex = left(j);
            int smallChild = leftIndex;
            int rightIndex = right(j);

          // if right child exists and is smaller than left use right instead
            if (rightIndex < heap.size() &&
                heap.get(rightIndex).compareTo(heap.get(leftIndex)) < 0) {
                smallChild = rightIndex;
            }

            // if parent is already smaller than smallest child stop
            if (heap.get(j).compareTo(heap.get(smallChild)) <= 0) break;

            // otherwise swap with smaller child and keep it going down
            swap(j, smallChild);
            j = smallChild;
        }
    }
}
