import org.junit.Test;
import static org.junit.Assert.*;

// Phase 4: JUnit Test Class for SmartScheduler
// uses assertions to validate all methods just like the directions asked
public class SchedulerTest {

    // test that removeMin returns highest priority ticket first
    @Test
    public void testPriorityOrder() {
        SmartScheduler scheduler = new SmartScheduler();
        scheduler.insert(3, "Low priority ticket");
        scheduler.insert(1, "High priority ticket");
        scheduler.insert(2, "Medium priority ticket");

        assertEquals(1, scheduler.removeMin().getKey());
        assertEquals(2, scheduler.removeMin().getKey());
        assertEquals(3, scheduler.removeMin().getKey());
    }

    // test boundary case of empty queue
    @Test
    public void testEmptyQueue() {
        SmartScheduler scheduler = new SmartScheduler();

        assertTrue(scheduler.isEmpty());
        assertNull(scheduler.removeMin());
        assertNull(scheduler.min());
        assertEquals(0, scheduler.size());
    }

    // test that min returns root without removing it
    @Test
    public void testMinDoesNotRemove() {
        SmartScheduler scheduler = new SmartScheduler();
        scheduler.insert(1, "Critical ticket");
        scheduler.insert(3, "Low ticket");

        assertEquals(1, scheduler.min().getKey());
        assertEquals(2, scheduler.size());
    }

    // test edge case of ties in priority
    @Test
    public void testTiePriority() {
        SmartScheduler scheduler = new SmartScheduler();
        scheduler.insert(1, "Tie ticket 1");
        scheduler.insert(1, "Tie ticket 2");
        scheduler.insert(1, "Tie ticket 3");

        assertEquals(1, scheduler.removeMin().getKey());
        assertEquals(1, scheduler.removeMin().getKey());
        assertEquals(1, scheduler.removeMin().getKey());
        assertTrue(scheduler.isEmpty());
    }

    // test size tracking after insertions and removals
    @Test
    public void testSizeTracking() {
        SmartScheduler scheduler = new SmartScheduler();
        assertEquals(0, scheduler.size());

        scheduler.insert(1, "Ticket A");
        scheduler.insert(2, "Ticket B");
        assertEquals(2, scheduler.size());

        scheduler.removeMin();
        assertEquals(1, scheduler.size());

        scheduler.removeMin();
        assertEquals(0, scheduler.size());
        assertTrue(scheduler.isEmpty());
    }

    // test single element insertion and removal
    @Test
    public void testSingleElement() {
        SmartScheduler scheduler = new SmartScheduler();
        scheduler.insert(5, "Only ticket");

        assertFalse(scheduler.isEmpty());
        assertEquals(5, scheduler.removeMin().getKey());
        assertTrue(scheduler.isEmpty());
    }
}
