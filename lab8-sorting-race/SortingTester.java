import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");
        System.out.printf("%-12s %-15s %-20s %-20s %-20s%n",
                "Size", "Case", "Selection Sort", "Insertion Sort", "Merge Sort");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        for (int n : sizes) {
            // this tests the average case with random array
            runAndTimeAllSorts(n, "Average");

            //this tests the best case with already sorted array
            runAndTimeAllSorts(n, "Best");

            // this tests the worst case with reverse sorted array
            runAndTimeAllSorts(n, "Worst");
        }
    }

    // this method runs all three sorts on the same data and prints the times
    public static void runAndTimeAllSorts(int size, String caseType) {
        int[] original;

        // this here generates the right type of array based on the case
        if (caseType.equals("Average")) {
            original = generateRandomArray(size);
        } else if (caseType.equals("Best")) {
            original = generateSortedArray(size);
        } else {
            original = generateReverseSortedArray(size);
        }

        // this makes copies so each sort gets the same unsorted data
        int[] arr1 = Arrays.copyOf(original, original.length);
        int[] arr2 = Arrays.copyOf(original, original.length);
        int[] arr3 = Arrays.copyOf(original, original.length);

        // this is the time selection sort
        long start1 = System.nanoTime();
        SortingAlgorithms.selectionSort(arr1);
        long time1 = System.nanoTime() - start1;

        // this is the time insertion sort
        long start2 = System.nanoTime();
        SortingAlgorithms.insertionSort(arr2);
        long time2 = System.nanoTime() - start2;

        // this is the  time merge sort
        long start3 = System.nanoTime();
        SortingAlgorithms.mergeSort(arr3);
        long time3 = System.nanoTime() - start3;

        // This here prints the results in milliseconds so they are easier to read
        System.out.printf("%-12d %-15s %-20.2f %-20.2f %-20.2f%n",
                size, caseType,
                time1 / 1_000_000.0,
                time2 / 1_000_000.0,
                time3 / 1_000_000.0);
    }

    // This generates an array with random integers for average case testing
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }

    // This generates an already sorted array for best case testing
    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // This generates a reverse sorted array for worst case testing
    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
}
