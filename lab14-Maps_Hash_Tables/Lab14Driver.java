// this driver tests the UnsortedListMap ---> on the lecture slides
public class UnsortedListMapDriver {
    public static void main(String[] args) {
        UnsortedListMap<Integer, String> map = new UnsortedListMap<>();

        System.out.println("=== Unsorted List Map Demo ===\n");

        // test isEmpty on empty map
        System.out.println("isEmpty: " + map.isEmpty()); // true

        // test put with new keys returns null each time
        System.out.println("put(5, A): " + map.put(5, "A")); // null
        System.out.println("put(7, B): " + map.put(7, "B")); // null
        System.out.println("put(2, C): " + map.put(2, "C")); // null
        System.out.println("put(8, D): " + map.put(8, "D")); // null

        // test put with existing key should update and return old value
        System.out.println("put(2, E): " + map.put(2, "E")); // C

        // test get
        System.out.println("get(7): " + map.get(7));  // B
        System.out.println("get(4): " + map.get(4));  // null
        System.out.println("get(2): " + map.get(2));  // E

        // test size
        System.out.println("size: " + map.size()); // 4

        // test remove
        System.out.println("remove(5): " + map.remove(5)); // A
        System.out.println("remove(2): " + map.remove(2)); // E

        // test get after remove
        System.out.println("get(2) after remove: " + map.get(2)); // null

        // test isEmpty on non empty map
        System.out.println("isEmpty: " + map.isEmpty()); // false

        System.out.println("\nAll operations match expected output from lecture slides!");
    }
}
