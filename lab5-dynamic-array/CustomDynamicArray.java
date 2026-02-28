// This class implements a dynamic array (like ArrayList) and it starts with a small size and doubles when it gets full
public class CustomDynamicArray {

    // This is the internal array that stores the data
    private int[] data;

    // This Ttacks how many elements are actually in the array
    private int size;

    // This tracks the internal arrays total capacity 
    private int capacity;

    // This is a constructor and starts with a capacity of 2
    public CustomDynamicArray() {
        capacity = 2;
        data = new int[capacity];
        size = 0;
    }

    // This portion adds a new element to the end of the array  and if the array is full, it doubles in size first (doubling strategy)
    public void push(int value) {
        // This checks if the array is full
        if (size == capacity) {
            resize();
        }
        // This adds the new element at the next open spot
        data[size] = value;
        size++;
    }

    // This doubles the capacity of the array when it is full
    private void resize() {
        // Here it doubles the capacity
        capacity = capacity * 2;
        System.out.println("*** Resize event! New capacity: " + capacity + " ***");

        // This creates a new bigger array
        int[] newData = new int[capacity];

        // This copies all the elements from the old array to the new one
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        // This replaces old array with the new bigger array
        data = newData;
    }

    //This returns the element at a given index
    public int get(int index) {
        // Check if the index is valid
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Size is " + size);
        }
        return data[index];
    }

    // This returns how many elements are in the array
    public int size() {
        return size;
    }

    // This returns the current capacity of the internal array
    public int capacity() {
        return capacity;
    }

    // This returns true if the array has no elements
    public boolean isEmpty() {
        return size == 0;
    }

    // This prints all the elements in the array
    public void display() {
        System.out.print("Array contents: [");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Size: " + size + " | Capacity: " + capacity);
    }
}
