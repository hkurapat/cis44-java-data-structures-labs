import java.util.*;

public class DataStructures {

     // ==========================================
     // 1. RECURSION
     // ==========================================

     // This calculates the nth Fibonacci number recursively and it has two base cases 
     public static int recursiveFibonacci(int n) {
          // base case 1: F(0) = 0
          if (n == 0) return 0;
          // base case 2: F(1) = 1
          if (n == 1) return 1;
          //this is the recursive step as each call reduces the problem by summing the two previous values
          return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
     }

     // ==========================================
     // 2. ANALYSIS OF ALGORITHMS
     // ==========================================

     // This finds the second largest value in a single pass which makes it O(n) and we track both the max and second max as we go through the array
     public static int findSecondMax(int[] arr) {
          if (arr == null || arr.length < 2) {
               throw new IllegalArgumentException("Array must have at least two elements");
          }

          int max = Integer.MIN_VALUE;
          int secondMax = Integer.MIN_VALUE;

          // go through the array once keeping track of the top two values
          for (int i = 0; i < arr.length; i++) {
               if (arr[i] > max) {
                    // current element is bigger than max so update both
                    secondMax = max;
                    max = arr[i];
               } else if (arr[i] > secondMax && arr[i] != max) {
                    // current element is in between max and secondMax
                    secondMax = arr[i];
               }
          }
          return secondMax;
     }

     // ==========================================
     // 3. TREES
     // ==========================================

     static class Node {
          int value;
          Node left, right;
          public Node(int value) {
               this.value = value;
               this.left = null;
               this.right = null;
          }
     }

     // This recursively sums only the leaf nodes
     public static int sumLeafNodes(Node root) {
          // base case: if node is null return 0
          if (root == null) return 0;

          // if this node is a leaf return its value
          if (root.left == null && root.right == null) {
               return root.value;
          }

          // otherwise return the sum of leaf nodes from both subtrees
          return sumLeafNodes(root.left) + sumLeafNodes(root.right);
     }

     // ==========================================
     // 4. SEARCH ALGORITHMS
     // ==========================================

     //This is the iterative binary search and array must be sorted for this to work
     
     public static int binarySearch(int[] arr, int target) {
          int low = 0;
          int high = arr.length - 1;

          while (low <= high) {
               int mid = (low + high) / 2; // find the middle index

               if (arr[mid] == target) {
                    return mid; // found it
               } else if (arr[mid] < target) {
                    low = mid + 1; // search the right half
               } else {
                    high = mid - 1; // search the left half
               }
          }
          return -1; // not found
     }

     // ==========================================
     // 5. SORTING ALGORITHMS
     // ==========================================

     // This is selection sort which finds the minimum in the unsorted portion and swaps it into place (one swap per outer loop iteration)
     public static void selectionSort(int[] arr) {
          int n = arr.length;

          for (int i = 0; i < n - 1; i++) {
               // find the minimum element in the unsorted portion
               int minIndex = i;
               for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                         minIndex = j;
                    }
               }
               // swap the minimum element with the first unsorted element
               int temp = arr[minIndex];
               arr[minIndex] = arr[i];
               arr[i] = temp;
          }
     }

     // ==========================================
     // TEST DRIVER (Do not modify this part)
     // ==========================================
     public static void main(String[] args) {
          System.out.println("=== Coding Advanced Data Structures ===\n");

          // Test 1: Recursion (Fibonacci)
          int fibN = 6;
          int expectedFib = 8;
          int actualFib = recursiveFibonacci(fibN);
          printTestResult("1. Recursion (Fibonacci)", expectedFib, actualFib);

          // Test 2: Analysis (Second Max)
          int[] numbers = {10, 5, 20, 8, 15};
          int expectedSecondMax = 15;
          int actualSecondMax = findSecondMax(numbers);
          printTestResult("2. Analysis (Second Max)", expectedSecondMax, actualSecondMax);

          // Test 3: Trees (Leaf Sum)
          //       1
          //      / \
          //     2   3 (Leaf)
          //    /
          //   4 (Leaf)
          Node root = new Node(1);
          root.left = new Node(2);
          root.right = new Node(3);
          root.left.left = new Node(4);
          int expectedLeafSum = 7;
          int actualLeafSum = sumLeafNodes(root);
          printTestResult("3. Trees (Leaf Sum)", expectedLeafSum, actualLeafSum);

          // Test 4: Search (Binary Search)
          int[] sortedData = {1, 2, 4, 7, 9};
          int target = 7;
          int expectedIndex = 3;
          int actualIndex = binarySearch(sortedData, target);
          printTestResult("4. Search (Binary)", expectedIndex, actualIndex);

          // Test 5: Sorting (Selection Sort)
          int[] sortData = {64, 25, 12, 22, 11};
          String expectedSort = "[11, 12, 22, 25, 64]";
          selectionSort(sortData);
          String actualSort = Arrays.toString(sortData);
          System.out.println("[Test 5] Sorting (Selection Sort)");
          System.out.println(" Expected: " + expectedSort);
          System.out.println(" Actual: " + actualSort);
          if (expectedSort.equals(actualSort)) {
               System.out.println(" Result: [PASS]");
          } else {
               System.out.println(" Result: [FAIL]");
          }
          System.out.println();
     }

     // this prints results
     private static void printTestResult(String testName, int expected, int actual) {
          System.out.println("[Test] " + testName);
          System.out.println(" Expected: " + expected);
          System.out.println(" Actual: " + actual);
          if (expected == actual) {
               System.out.println(" Result: [PASS]");
          } else {
               System.out.println(" Result: [FAIL]");
          }
          System.out.println();
     }
}
