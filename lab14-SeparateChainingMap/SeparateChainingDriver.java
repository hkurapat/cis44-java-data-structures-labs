// this driver tests the SeparateChainingMap and demonstrates collision handling
// we insert string keys that hash to the same bucket to show separate chaining working
public class SeparateChainingDriver {
    public static void main(String[] args) {
        SeparateChainingMap<String, String> map = new SeparateChainingMap<>();

        System.out.println("=== Separate Chaining Hash Map Demo ===\n");

        // insert entries and show hash values to demonstrate collisions
        System.out.println("--- Inserting entries and showing hash values ---");
        String[] keys = {"name", "city", "job", "age", "major"};
        String[] values = {"Alice", "San Jose", "SWE", "25", "CS"};

        for (int i = 0; i < keys.length; i++) {
            int hash = Math.abs(keys[i].hashCode() % 11);
            System.out.println("put(" + keys[i] + ", " + values[i] + ")" +
                " -> hash=" + hash + " -> returned: " + map.put(keys[i], values[i]));
        }

        System.out.println("\nSize after insertions: " + map.size());

        // test get operations
        System.out.println("\n--- Testing get ---");
        System.out.println("get(name): " + map.get("name"));       // Alice
        System.out.println("get(city): " + map.get("city"));       // San Jose
        System.out.println("get(job): " + map.get("job"));         // SWE
        System.out.println("get(missing): " + map.get("missing")); // null

        // test update existing key demonstrates value replacement
        System.out.println("\n--- Testing update (put existing key) ---");
        System.out.println("put(name, Bob): " + map.put("name", "Bob")); // Alice
        System.out.println("get(name) after update: " + map.get("name")); // Bob

        // test remove
        System.out.println("\n--- Testing remove ---");
        System.out.println("remove(city): " + map.remove("city")); // San Jose
        System.out.println("get(city) after remove: " + map.get("city")); // null
        System.out.println("Size after remove: " + map.size());

        // demonstrate collision handling explicitly
        System.out.println("\n--- Collision Demonstration ---");
        SeparateChainingMap<String, String> collisionMap = new SeparateChainingMap<>();
        String[] collisionKeys = {"Aa", "BB", "Ca"};
        for (String key : collisionKeys) {
            int hash = Math.abs(key.hashCode() % 11);
            collisionMap.put(key, "value-" + key);
            System.out.println("put(" + key + ") -> hash=" + hash);
        }
        System.out.println("get(Aa): " + collisionMap.get("Aa"));
        System.out.println("get(BB): " + collisionMap.get("BB"));
        System.out.println("get(Ca): " + collisionMap.get("Ca"));
    }
}
