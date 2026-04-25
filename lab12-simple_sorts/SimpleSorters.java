import java.util.Comparator;

public class SimpleSorters {

    // This sorts an array using the optimized Bubble Sort algorithm, It also uses a swapped flag to stop early if already sorted (best case O(n))
    public static <K> void bubbleSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        // outer loop controls how many passes we do
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // inner loop goes through the unsorted part of the array
            for (int j = 0; j < n - 1 - i; j++) {
                // if left element is bigger than right, swap them
                if (comp.compare(S[j], S[j + 1]) > 0) {
                    // swap using a temp variable
                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;
                    swapped = true;
                }
            }

            // if nothing was swapped this pass, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }


    /**
     * Sorts an array using the Insertion Sort algorithm.
     * Works like sorting a hand of playing cards
     */
    public static <K> void insertionSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        // start at index 1 because a single element is already sorted
        for (int i = 1; i < n; i++) {
            K cur = S[i]; // the current element we need to insert
            int j = i - 1;

            // shift elements greater than cur one spot to the right
            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            // insert cur into its correct position
            S[j + 1] = cur;
        }
    }
}
