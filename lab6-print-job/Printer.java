import java.util.EmptyStackException;

// This is the Queue interface 
interface Queue<E> {
    int size();
    boolean isEmpty();
    void enqueue(E e);
    E first();
    E dequeue();
}

// This is the LinkedQueue implementation
class LinkedQueue<E> implements Queue<E> {

    // this here is the node class that holds each element
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
    }

    // Here we can see that the  head is the front of the queue while tail is the rear
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    // This returns how many jobs are in the queue
    public int size() { return size; }

    // This returns true if there are no jobs in the queue
    public boolean isEmpty() { return size == 0; }

    // This adds a new job to the rear of the queue
    public void enqueue(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) head = newest;
        else tail.next = newest;
        tail = newest;
        size++;
    }

    // This returns the front job without removing it
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    // This removes and returns the front job
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) tail = null;
        return answer;
    }
}

// This PrintJob class represents a single document to be printed
class PrintJob {
    private String documentName;
    private int pageCount;

    //This constructor here sets up the print job with a name and page count
    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // This returns a description of the print job
    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]";
    }
}

// This class simulates a printer that manages a queue of print jobs
public class Printer {

    // This is the queue that holds all the print jobs
    private Queue<PrintJob> jobQueue;

    // This constructor here sets up the printer with an empty linked queue
    public Printer() {
        jobQueue = new LinkedQueue<>();
    }

    // This adds a new print job to the rear of the queue
    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        jobQueue.enqueue(job);
    }

    // This processes the job at the front of the queue
    public void processNextJob() {
        // For this if queue is empty there is nothing to print
        if (jobQueue.isEmpty()) {
            System.out.println("No jobs in the queue. Nothing to print.");
            return;
        }
        // dequeue the front job and print it
        PrintJob job = jobQueue.dequeue();
        System.out.println("Processing... " + job);
    }

    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");
        officePrinter.processNextJob(); // Should print Annual_Report.pdf
        officePrinter.processNextJob(); // Should print Meeting_Agenda.docx

        System.out.println("\nNew high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
        officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
        officePrinter.processNextJob(); // Should say the queue is empty
    }
}
