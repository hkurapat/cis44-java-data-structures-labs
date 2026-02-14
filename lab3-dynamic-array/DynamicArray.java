// This is generic dynamic array class which basically is making our own ArrayList
public class DynamicArray<T> {
    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
    
    // A constructor that sets up an empty array
    public DynamicArray() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }
    
    // This adds element to the end and also resizes if it is needed
    public void add(T element) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        data[size] = element;
        size++;
    }
    
    // This returns element at index
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return data[index];
    }
    
    // This removes element at index and shifts everything left
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        
        T removedElement = data[index];
        
        // This shift elements to the left to fill the gap
        for (int j = index; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        
        data[size - 1] = null;
        size--;
        
        return removedElement;
    }
    
    // This returns current number of elements
    public int size() {
        return size;
    }
    
    // This helper method resizez array when it gets full
    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp;
    }
}
