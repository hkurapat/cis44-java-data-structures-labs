import java.util.Iterator;
// This is the class that implements a positional list using a doubly linked list. Sentinel nodes make insertions more cleaner
public class LinkedPositionalList<E> implements Iterable<E> {
    // This is the Nested Node class and here each node acts as a Position
    private static class Node<E> implements Position<E> {

        private E element; // the data stored at this node
        private Node<E> prev; // this references to previous node
        private Node<E> next; // this references to next node

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E e) {
            element = e;
        }

        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }

    // These are the sentinel nodes and they never store real data
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    // This is the contructor and it creates sentinel nodes and links them together
    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    // This returns the number of elements in the list
    public int size() { return size; }

    // This returns true if the list is empty
    public boolean isEmpty() { return size == 0; }

    // This returns the position of the first element
    public Position<E> first() {
        if (isEmpty()) return null;
        return header.getNext();
    }
    // This returns the position of the last element
    public Position<E> last() {
        if (isEmpty()) return null;
        return trailer.getPrev();
    }

    // This returns the position immediately before p
    public Position<E> before(Position<E> p) {
        Node<E> node = (Node<E>) p;
        Node<E> prev = node.getPrev();
        if (prev == header) return null;
        return prev;
    }

    // This returns the position immediately after p
    public Position<E> after(Position<E> p) {
        Node<E> node = (Node<E>) p;
        Node<E> next = node.getNext();
        if (next == trailer) return null;
        return next;
    }

    // This is the private helper method  and it inserts element between two existing nodes -----> (addFirst, addLast, addBefore, addAfter all call this method)
    private Position<E> addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
        return newest;
    }

    // This adds element at the front of the list
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }
    // This adds element at the end of the list
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    // This adds element immediately before position p
    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = (Node<E>) p;
        return addBetween(e, node.getPrev(), node);
    }

    // This adds element immediately after position p
    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = (Node<E>) p;
        return addBetween(e, node, node.getNext());
    }

    // This replaces the element at position p with e, returns the old element
    public E set(Position<E> p, E e) {
        Node<E> node = (Node<E>) p;
        E old = node.getElement();
        node.setElement(e);
        return old;
    }

    // This removes the element at position p and returns it
    public E remove(Position<E> p) {
        Node<E> node = (Node<E>) p;
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    // This is the Nested Iterator class and it allows for-each loop to work on this list
    private class ElementIterator implements Iterator<E> {
        // this is the cursor that tracks where we are in the list
        Position<E> cursor = first();

        // This returns true if there are more elements to visit
        public boolean hasNext() {
            return cursor != null;
        }

        // This returns the current element and advances the cursor forward
        public E next() {
            E element = cursor.getElement();
            cursor = after(cursor);
            return element;
        }
    }
    // This returns a new iterator instance so for-each loop works
    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}
