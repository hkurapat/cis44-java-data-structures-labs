public class SortingAlgorithms {

    // Selection sort works by finding the smallest element and putting it in the right place
    // This is O(n^2) because we can see that we have two nested loops
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // here it finds the smallest element in the rest of the array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // here it swaps the smallest element with the current position
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion sort works by taking one element at a time and inserting it in the right spot
    // Best case is O(n) when already sorted 
  //worst case is O(n^2)
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // here it shifts elements that are greater than key one position to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Here is merge sort which is a divide and conquer algorithm with O(n log n) complexity
    // Here it splits the array in half recursively then merges them back together sorted
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // already sorted
        }
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    // This is the recursive part that keeps splitting the array in half
    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return; // 
        }
        int mid = (left + right) / 2;
        mergeSortRecursive(arr, temp, left, mid);       // here it sorts left half
        mergeSortRecursive(arr, temp, mid + 1, right);  // here it sorts right half
        merge(arr, temp, left, mid, right);              //here it  merges both halves
    }

    // This merges two sorted halves back into one sorted array
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // copy both halves into temp array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;      // This is the pointer for the left half
        int j = mid + 1;   // This is the pointer for the right half
        int k = left;      // This is the pointer for merged result

        // This compares elements from both halves and put the smaller one back
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // This copies any remaining elements from the left half
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        // this copies any remaining elements from the right half
        while (j <= right) {
            arr[k] = temp[j];
            j++;
            k++;
        }
    }
}
