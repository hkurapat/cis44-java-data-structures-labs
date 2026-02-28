// This is the main class to test the itinerary manager
public class Main {

    public static void main(String[] args) {

        // This here create a new positional list to store travel stops
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        System.out.println("=== Building Travel Itinerary ===\n");

        // This adds initial destinations to the list
        itinerary.addLast("San Francisco");
        itinerary.addLast("New York");
        itinerary.addLast("Japan");

        System.out.println("Initial stops:");
        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }

        // Here is where it inserts Rome between New York and Japan
        Position<String> newYorkPos = itinerary.first(); // San Francisco
        newYorkPos = itinerary.after(newYorkPos); // move to New York
        itinerary.addAfter(newYorkPos, "Rome");

        System.out.println("\nAfter inserting Rome after New York:");
        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }

        // Here it prints final itinerary using for-each loop
        System.out.println("\n=== Final Itinerary (for-each loop) ===");
        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }

        System.out.println("\nTotal stops: " + itinerary.size());
    }
}
