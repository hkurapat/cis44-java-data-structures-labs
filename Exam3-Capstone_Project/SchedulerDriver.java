// This driver tests the SmartScheduler by simulating a customer service call center
// the tickets are inserted with different priorities ---> this means they should also be removed in priority order
public class SchedulerDriver {
    public static void main(String[] args) {
        SmartScheduler scheduler = new SmartScheduler();

        System.out.println("=== Smart Scheduler - Customer Service Call Center ===\n");

        // add tickets with different priority levels
        // priority 1 = most urgent and priority 4 = least urgent
        System.out.println("Adding support tickets...");
        scheduler.insert(3, "Alice - Minor bug report");
        scheduler.insert(1, "Bob - System completely down (Critical)");
        scheduler.insert(4, "Carol - Feature request");
        scheduler.insert(2, "Dave - VIP customer cannot login");
        scheduler.insert(1, "Eve - Data loss emergency (Critical)");

        System.out.println("Tickets added: " + scheduler.size());
        System.out.println("Next ticket to process: " + scheduler.min());
        System.out.println();

        // here --> process all tickets in priority order
        System.out.println("Processing tickets in priority order:");
        while (!scheduler.isEmpty()) {
            System.out.println("Processing: " + scheduler.removeMin());
        }
    }
}
