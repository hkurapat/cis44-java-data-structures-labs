public class MaxSubarraySolver {

    // This brute force checks every possible subarray using nested loops
    // this time complexity is O(n^2) because the outer loop runs n times and inner loop runs n times
    public static int bruteForceMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    // This is the Kadanes algorithm which finds the max subarray sum in one single pass
    // This time complexity is O(n) because there is only one loop that runs n times
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // either extend the current subarray or start fresh
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
            } else {
                currentSum = currentSum + arr[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
