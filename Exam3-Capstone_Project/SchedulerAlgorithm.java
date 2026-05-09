// Phase 3: Algorithm Logic
// this is where the Heap is being used
// basically, poll() just handles the logic of grabbing the top ticket
public class SchedulerAlgorithm {

  // this is the core part of the scheduler
    // it's basically the removeMin logic 
    // complexity is O(log n) because the heap has to fix itself (downheap)
    public static TicketEntry poll(SmartScheduler scheduler) {
        if (scheduler.isEmpty()) {
            System.out.println("No tickets in the queue.");
            return null;
        }

        // peek at the highest priority ticket before removing
        TicketEntry next = scheduler.min();
        System.out.println("Processing next ticket: " + next);

        // remove and return the highest priority ticket
        TicketEntry processed = scheduler.removeMin();
        System.out.println("Ticket processed successfully!");
        System.out.println("Remaining tickets in queue: " + scheduler.size());
        System.out.println();
        return processed;
    }

    // this method processes all tickets in the queue one by one
    // showing the algorithm working through the entire backlog
    public static void processAllTickets(SmartScheduler scheduler) {
        System.out.println("=== Starting Ticket Processing Algorithm ===");
        System.out.println("Total tickets to process: " + scheduler.size());
        System.out.println();

        int count = 1;
        while (!scheduler.isEmpty()) {
            System.out.println("--- Processing ticket " + count + " ---");
            poll(scheduler);
            count++;
        }

        System.out.println("=== All tickets have been processed! ===");
    }

    public static void main(String[] args) {
        SmartScheduler scheduler = new SmartScheduler();

        // this is to simulate a real customer service backlog
        // tickets arrive in a random order but get processed by priority
        System.out.println("=== Smart Scheduler Algorithm Demo ===");
        System.out.println("Simulating incoming support tickets...\n");

        scheduler.insert(3, "Alice - Minor UI bug");
        scheduler.insert(1, "Bob - Full system outage (CRITICAL)");
        scheduler.insert(4, "Carol - Feature request");
        scheduler.insert(2, "Dave - VIP customer cannot access account");
        scheduler.insert(1, "Eve - Data corruption emergency (CRITICAL)");
        scheduler.insert(3, "Frank - Billing question");
        scheduler.insert(2, "Grace - Payment processing failure");

        System.out.println("Total tickets submitted: " + scheduler.size());
        System.out.println("Highest priority ticket right now: " + scheduler.min());
        System.out.println();

        // run the core scheduling algorithm
        processAllTickets(scheduler);

        // this here demonstrates edge case handling
        System.out.println("--- Edge Case: Empty Queue ---");
        poll(scheduler);
    }
}
