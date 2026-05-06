// This is the entry class that holds the key and value pair
//here the key = priority level and value = customer name and issue
public class TicketEntry implements Comparable<TicketEntry> {
    private int key;        // priority level 1 = most urgent to 4 = least urgent
    private String value;   // here ---> customer name and issue description

    public TicketEntry(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() { return key; }
    public String getValue() { return value; }

    // this lets us compare entries by their priority key
    @Override
    public int compareTo(TicketEntry other) {
        return Integer.compare(this.key, other.key);
    }

    @Override
    public String toString() {
        return "(Priority " + key + ") " + value;
    }
}
