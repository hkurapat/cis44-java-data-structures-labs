// Phase 4: Testing and Validation
// this driver runs specific scenarios and prints PASS or FAIL and tests normal case, boundary case, and edge cases
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Smart Scheduler - Phase 4: Testing & Validation ===\n");

        // ==========================================
        // TEST 1: Normal Case - Priority Order
        // ==========================================
        System.out.println("--- Test 1: Normal Case (Priority Order) ---");
        SmartScheduler scheduler = new SmartScheduler();
        scheduler.insert(3, "Alice - Minor bug report");
        scheduler.insert(1, "Bob - System completely down");
        scheduler.insert(4, "Carol - Feature request");
        scheduler.insert(2, "Dave - VIP customer cannot login");

        // the highest priority ticket should be removed first
        TicketEntry first = scheduler.removeMin();
        if (first.getKey() == 1) {
            System.out.println("Test 1 PASS - Highest priority ticket processed first: " + first);
        } else {
            System.out.println("Test 1 FAIL - Expected priority 1 but got: " + first.getKey());
        }

        // the second removal should be priority 2
        TicketEntry second = scheduler.removeMin();
        if (second.getKey() == 2) {
            System.out.println("Test 1 PASS - Second priority ticket correct: " + second);
        } else {
            System.out.println("Test 1 FAIL - Expected priority 2 but got: " + second.getKey());
        }

        // ==========================================
        // TEST 2: Boundary Case - Empty Queue
        // ==========================================
        System.out.println("\n--- Test 2: Boundary Case (Empty Queue) ---");
        SmartScheduler emptyScheduler = new SmartScheduler();

        // null not crash should be returned for removeMin on empty queue
        TicketEntry result = emptyScheduler.removeMin();
        if (result == null) {
            System.out.println("Test 2 PASS - removeMin on empty queue returns null correctly");
        } else {
            System.out.println("Test 2 FAIL - Expected null but got: " + result);
        }

        // null should also be returned for min on empty queue 
        TicketEntry minResult = emptyScheduler.min();
        if (minResult == null) {
            System.out.println("Test 2 PASS - min on empty queue returns null correctly");
        } else {
            System.out.println("Test 2 FAIL - Expected null but got: " + minResult);
        }

        // isEmpty should return true
        if (emptyScheduler.isEmpty()) {
            System.out.println("Test 2 PASS - isEmpty returns true on empty queue correctly");
        } else {
            System.out.println("Test 2 FAIL - Expected isEmpty to return true");
        }

        // ==========================================
        // TEST 3: Edge Case - Ties in Priority
        // ==========================================
        System.out.println("\n--- Test 3: Edge Case (Ties in Priority) ---");
        SmartScheduler tieScheduler = new SmartScheduler();
        tieScheduler.insert(1, "Eve - Critical issue 1");
        tieScheduler.insert(1, "Frank - Critical issue 2");
        tieScheduler.insert(1, "Grace - Critical issue 3");

        // all three have same priority so all removals should return priority 1
        boolean allPriority1 = true;
        while (!tieScheduler.isEmpty()) {
            TicketEntry t = tieScheduler.removeMin();
            if (t.getKey() != 1) {
                allPriority1 = false;
            }
        }
        if (allPriority1) {
            System.out.println("Test 3 PASS - All tied priority tickets processed correctly");
        } else {
            System.out.println("Test 3 FAIL - Tie handling broken");
        }

        // ==========================================
        // TEST 4: Edge Case - Single Element
        // ==========================================
        System.out.println("\n--- Test 4: Edge Case (Single Element) ---");
        SmartScheduler singleScheduler = new SmartScheduler();
        singleScheduler.insert(2, "Henry - Single ticket");

        TicketEntry single = singleScheduler.removeMin();
        if (single != null && single.getKey() == 2) {
            System.out.println("Test 4 PASS - Single element removed correctly: " + single);
        } else {
            System.out.println("Test 4 FAIL - Single element handling broken");
        }

        // now queue should be empty after removing single element
        if (singleScheduler.isEmpty()) {
            System.out.println("Test 4 PASS - Queue empty after removing single element");
        } else {
            System.out.println("Test 4 FAIL - Queue should be empty but is not");
        }

        // ==========================================
        // TEST 5: Logic Validation - Size Tracking
        // ==========================================
        System.out.println("\n--- Test 5: Logic Validation (Size Tracking) ---");
        SmartScheduler sizeScheduler = new SmartScheduler();
        sizeScheduler.insert(1, "Ticket A");
        sizeScheduler.insert(2, "Ticket B");
        sizeScheduler.insert(3, "Ticket C");

        if (sizeScheduler.size() == 3) {
            System.out.println("Test 5 PASS - Size is 3 after 3 insertions");
        } else {
            System.out.println("Test 5 FAIL - Expected size 3 but got: " + sizeScheduler.size());
        }

        sizeScheduler.removeMin();
        if (sizeScheduler.size() == 2) {
            System.out.println("Test 5 PASS - Size is 2 after 1 removal");
        } else {
            System.out.println("Test 5 FAIL - Expected size 2 but got: " + sizeScheduler.size());
        }

        System.out.println("\n=== All Tests Complete ===");
    }
}
