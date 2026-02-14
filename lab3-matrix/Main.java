// This is testing the Matrix class
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Matrix Class\n");
        
        // This creates matrices with random values
        Matrix m1 = new Matrix(2, 2);
        Matrix m2 = new Matrix(2, 2);
        
        m1.populateRandom();
        m2.populateRandom();
        
        System.out.println("Matrix 1:");
        System.out.println(m1);
        
        System.out.println("Matrix 2:");
        System.out.println(m2);
        
        // This is test addition
        System.out.println("Adding them:");
        Matrix sum = m1.add(m2);
        System.out.println(sum);
        
        // This is test multiplication
        System.out.println("Multiplying them:");
        Matrix product = m1.multiply(m2);
        System.out.println(product);
        
        // This is test with the preset values
        int[][] arr1 = {{1, 2}, {3, 4}};
        int[][] arr2 = {{2, 0}, {1, 3}};
        
        Matrix m3 = new Matrix(arr1);
        Matrix m4 = new Matrix(arr2);
        
        System.out.println("Matrix 3:");
        System.out.println(m3);
        
        System.out.println("Matrix 4:");
        System.out.println(m4);
        
        System.out.println("Adding them:");
        System.out.println(m3.add(m4));
        
        // This is test exception
        System.out.println("Testing exception:");
        try {
            Matrix m5 = new Matrix(2, 3);
            Matrix m6 = new Matrix(2, 2);
            m5.add(m6);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        
        System.out.println("\nDone!");
    }
}
