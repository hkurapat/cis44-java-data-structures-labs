import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");
        System.out.printf("%-12s %-20s %-20s %-15s %-15s%n",
                "Size", "Brute Force (ms)", "Kadanes (ms)", "BF Result", "K Result");
        System.out.println("-------------------------------------------------------------------------------------");

        for (int n : sizes) {
            int[] original = generateRandomArrayWithNegatives(n);

            int[] arr1 = original.clone();
            int[] arr2 = original.clone();

            // time the brute force approach
            long start1 = System.nanoTime();
            int result1 = MaxSubarraySolver.bruteForceMaxSum(arr1);
            long time1 = System.nanoTime() - start1;

            // time kadanes algorithm
            long start2 = System.nanoTime();
            int result2 = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr2);
            long time2 = System.nanoTime() - start2;

            // this here prints results in milliseconds
            System.out.printf("%-12d %-20.2f %-20.2f %-15d %-15d%n",
                    n,
                    time1 / 1_000_000.0,
                    time2 / 1_000_000.0,
                    result1,
                    result2);
        }
    }

    // This generates a random array with both positive and negative numbers
    public static int[] generateRandomArrayWithNegatives(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100001) - 50000;
        }
        return arr;
    }
}
