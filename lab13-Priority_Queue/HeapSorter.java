import java.util.Arrays;
import java.util.Random;

// driver class to test heap sort
public class HeapSorter {

    // heap sort works in two phases: insert all then remove all
    public static void heapSort(Integer[] arr) {
        HeapPriorityQueue<Integer> pq = new HeapPriorityQueue<>();

        // phase 1 build the heap by inserting everything
        for (Integer x : arr) {
            pq.insert(x);
        }

        // phase 2 remove min one by one to get sorted order
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.removeMin();
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[10];
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) data[i] = rand.nextInt(100);

        System.out.println("Before Sorting: " + Arrays.toString(data));
        heapSort(data);
        System.out.println("After Sorting:  " + Arrays.toString(data));
    }
}
