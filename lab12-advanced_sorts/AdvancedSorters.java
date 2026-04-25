import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    // Merge Sort - public wrapper method
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) return; // base case: already sorted

        // divide: split into two halves
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        // conquer: recursive calls
        mergeSort(S1, comp);
        mergeSort(S2, comp);

        // combine: merge sorted halves back into original
        merge(S, S1, S2, comp);
    }

    // helper method to merge two sorted arrays
    private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator<K> comp) {
        int i = 0, j = 0, k = 0;
        
        // loop through and pick the smaller element
        while (i < S1.length && j < S2.length) {
            if (comp.compare(S1[i], S2[j]) <= 0) {
                S[k++] = S1[i++];
            } else {
                S[k++] = S2[j++];
            }
        }
        
        // copy any remaining elements
        while (i < S1.length) S[k++] = S1[i++];
        while (j < S2.length) S[k++] = S2[j++];
    }

    // Quick Sort - public wrapper method
    public static <K> void quickSort(K[] S, Comparator<K> comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    // recursive helper for quick sort
    private static <K> void quickSort(K[] S, Comparator<K> comp, int a, int b) {
        if (a >= b) return; // base case

        // divide: partition around a pivot
        int pivotIndex = partition(S, comp, a, b);

        // conquer: recurse on the left and right sides
        quickSort(S, comp, a, pivotIndex - 1);
        quickSort(S, comp, pivotIndex + 1, b);
    }

    // partition logic using a pivot
    private static <K> int partition(K[] S, Comparator<K> comp, int a, int b) {
        K pivot = S[b]; // simple choice: last element as pivot
        int left = a;
        int right = b - 1;

        while (left <= right) {
            // move left pointer until we find something >= pivot
            while (left <= right && comp.compare(S[left], pivot) < 0) left++;
            // move right pointer until we find something <= pivot
            while (left <= right && comp.compare(S[right], pivot) > 0) right--;
            
            if (left <= right) {
                // swap elements
                K temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            }
        }
        
        // swap pivot into its final position
        K temp = S[left];
        S[left] = S[b];
        S[b] = temp;
        
        return left;
    }
}
