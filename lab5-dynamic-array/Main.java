// This is the Main class which tests the CustomDynamicArray
public class Main {

    public static void main(String[] args) {

        // This creates a new dynamic array
        CustomDynamicArray myArray = new CustomDynamicArray();

        System.out.println("=== Testing Custom Dynamic Array ===\n");
        System.out.println("Starting capacity: " + myArray.capacity());

        // This adds elements one by one
        // This watches for the resize events as the array fills up and doubles
        System.out.println("\n=== Adding 10 elements ===");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Pushing: " + i);
            myArray.push(i);
            myArray.display();
            System.out.println();
        }

        // This displays the final state of the array
        System.out.println("=== Final State ===");
        myArray.display();

        // This tests get method
        System.out.println("\n=== Testing get() ===");
        System.out.println("Element at index 0: " + myArray.get(0));
        System.out.println("Element at index 4: " + myArray.get(4));
        System.out.println("Element at index 9: " + myArray.get(9));

        // This tests isEmpty
        System.out.println("\n=== Testing isEmpty() ===");
        System.out.println("Is array empty? " + myArray.isEmpty());

        // This tests IndexOutOfBoundsException
        System.out.println("\n=== Testing invalid index ===");
        try {
            myArray.get(99);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
