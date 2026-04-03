// Helper class for the BST
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class RecursiveSearch {

    // Recursive binary search splits the array in half each time
    // This is the divide and conquer approach from the lecture slides
    public static int recursiveBinarySearch(int[] arr, int key, int low, int high) {

        // base case: if low passes high the key is not in the array
        if (low > high) {
            return -1;
        }

        // find the middle index
        int mid = (low + high) / 2;

        // found it at the middle
        if (arr[mid] == key) {
            return mid;
        }

        // key is smaller so search the left half
        if (key < arr[mid]) {
            return recursiveBinarySearch(arr, key, low, mid - 1);
        }

        // key is larger so search the right half
        return recursiveBinarySearch(arr, key, mid + 1, high);
    }

    // This is the public wrapper method to start the recursive binary search
    public static int searchArray(int[] arr, int key) {
        return recursiveBinarySearch(arr, key, 0, arr.length - 1);
    }

    // BST search uses the BST property to go left or right at each node
    // This is naturally recursive just like the slides showed
    public Node searchBST(Node root, int key) {

        // base case: tree is empty or we found the key at this node
        if (root == null || root.key == key) {
            return root;
        }

        // key is smaller so search the left subtree
        if (key < root.key) {
            return searchBST(root.left, key);
        }

        // key is larger so search the right subtree
        return searchBST(root.right, key);
    }

    public static void main(String[] args) {
        System.out.println("--- Lab 2: Recursive Search Algorithms ---");

        // Test Recursive Binary Search
        int[] sortedData = {10, 20, 30, 40, 50, 60};
        System.out.println("Recursive Binary Search:");
        System.out.println("Find 40: Index " + searchArray(sortedData, 40)); // Expected: 3
        System.out.println("Find 15: Index " + searchArray(sortedData, 15)); // Expected: -1

        // Build a sample BST
        RecursiveSearch bstSearcher = new RecursiveSearch();
        Node root = new Node(40);
        root.left = new Node(20);
        root.right = new Node(60);
        root.left.left = new Node(10);
        root.left.right = new Node(30);
        root.right.left = new Node(50);

        System.out.println("\nBinary Search Tree Search:");
        Node result1 = bstSearcher.searchBST(root, 30);
        System.out.println("Find 30: " + (result1 != null ? "Found (" + result1.key + ")" : "Not Found"));

        Node result2 = bstSearcher.searchBST(root, 45);
        System.out.println("Find 45: " + (result2 != null ? "Found" : "Not Found"));
    }
}
