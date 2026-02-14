// This is testing the DynamicArray class
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing DynamicArray\n");
        
        // This is testing with strings
        DynamicArray<String> names = new DynamicArray<>();
        
        // This adds some elements
        names.add("Bruce");
        names.add("Peter");
        names.add("Nancy");
        names.add("May");
        System.out.println("Size: " + names.size());
        System.out.println("First element: " + names.get(0));
        System.out.println();
        
        // This is test remove
        String removed = names.remove(1);
        System.out.println("Removed: " + removed);
        System.out.println("New size: " + names.size());
        System.out.println();
        
        // This is test with integers and trigger resize
        DynamicArray<Integer> numbers = new DynamicArray<>();
        System.out.println("Adding 12 numbers to test resize...");
        for (int i = 0; i < 12; i++) {
            numbers.add(i * 10);
        }
        System.out.println("Size after adding 12: " + numbers.size());
        System.out.println("Element at index 5: " + numbers.get(5));
        System.out.println();
        
        // This is test exception
        try {
            numbers.get(100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        System.out.println("\nDone!");
    }
}
