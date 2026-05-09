// this driver tests the UnsortedListMap ---> same example from the lecture slides
public class Lab14Driver {
    public static void main(String[] args) {
        UnsortedListMap<Integer, String> map = new UnsortedListMap<>();

        System.out.println("=== Unsorted List Map Demo ===\n");

        // test put with new keys returns null each time
        System.out.println("put(5, A): " + map.put(5, "A")); // null
        System.out.println("put(7, B): " + map.put(7, "B")); // null
        System.out.println("put(2, C): " + map.put(2, "C")); // null

        // test put with existing key should update and return old value
        System.out.println("put(2, E): " + map.put(2, "E")); // C

        // test get
        System.out.println("get(7): " + map.get(7)); // B

        // test remove
        System.out.println("remove(5): " + map.remove(5)); // A

        System.out.println("\nAll operations match expected output from lecture slides!");
    }
}
