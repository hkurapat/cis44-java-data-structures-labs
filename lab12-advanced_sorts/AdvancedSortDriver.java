import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AdvancedSortDriver {
    public static void main(String[] args) {
        Comparator<Integer> comp = Comparator.naturalOrder();
        int N = 20; 
        Random rand = new Random();

        // create random array
        Integer[] arr1 = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = rand.nextInt(100);
        }
        
        // copy so both algorithms test the same numbers
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test: Random Array (N=20) ---");
        System.out.println("Original:   " + Arrays.toString(arr1));

        // Test Merge Sort
        AdvancedSorters.mergeSort(arr1, comp);
        System.out.println("Merge Sort: " + Arrays.toString(arr1));

        // Test Quick Sort
        System.out.println("Original:   " + Arrays.toString(arr2));
        AdvancedSorters.quickSort(arr2, comp);
        System.out.println("Quick Sort: " + Arrays.toString(arr2));
    }
}
