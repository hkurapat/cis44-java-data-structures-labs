public class SearchComparison {

    // Linear search goes through the array one element at a time
    // This works on unsorted arrays which is its main advantage
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // found it so return the index
            }
        }
        return -1; // went through everything and did not find it
    }

    // Binary search uses divide and conquer to find the key
    // The array must be sorted for this to work
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2; // find the middle index

            if (arr[mid] == key) {
                return mid; //
            } else if (key < arr[mid]) {
                high = mid - 1; // search the left half
            } else {
                low = mid + 1; // search the right half
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        int[] unsortedData = {22, 8, 12, 1, 9, 30, 4, 15};
        int[] sortedData =   {1, 4, 8, 9, 12, 15, 22, 30};

        System.out.println("--- Lab 1: Search Algorithm Implementation ---");

        // Test Linear Search
        System.out.println("Linear Search (Unsorted):");
        System.out.println("Find 9: Index " + linearSearch(unsortedData, 9)); // Expected: 4
        System.out.println("Find 3: Index " + linearSearch(unsortedData, 3)); // Expected: -1

        // Test Binary Search
        System.out.println("\nBinary Search (Sorted):");
        System.out.println("Find 9: Index " + binarySearch(sortedData, 9)); // Expected: 3
        System.out.println("Find 3: Index " + binarySearch(sortedData, 3)); // Expected: -1
        System.out.println("Find 30: Index " + binarySearch(sortedData, 30)); // Expected: 7
    }
}
