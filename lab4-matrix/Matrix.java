import java.util.Random;

// This is the matrix class for the basic matrix operations
public class Matrix {
    private int[][] data;
    
    // This is the constructor that creates a matrix with the given dimensions
    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }
    
    // This is the constructor that creates a matrix from the existing 2D array
    public Matrix(int[][] data) {
        this.data = data;
    }
    
    // This fills the matrix with random numbers that are between #1 and #10
    public void populateRandom() {
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = rand.nextInt(10) + 1;
            }
        }
    }
    
    // Thia adds the two matrices together
    public Matrix add(Matrix other) throws IllegalArgumentException {
        // This checks if dimensions match
        if (data.length != other.data.length || data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Matrices need to have the same dimensions");
        }
        
        Matrix result = new Matrix(data.length, data[0].length);
        
        // This adds corresponding elements
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }
        
        return result;
    }
    
    // This multiplies the two matrices
    public Matrix multiply(Matrix other) throws IllegalArgumentException {
        // This checks if multiplication is possible
        if (data[0].length != other.data.length) {
            throw new IllegalArgumentException("The number of columns in the first matrix must equal the number of rows in the second matrix");
        }
        
        Matrix result = new Matrix(data.length, other.data[0].length);
        
        // This does the multiplication
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < other.data[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < data[0].length; k++) {
                    sum += data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        
        return result;
    }
    
    // This returns string representation of the matrix
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                output += data[i][j] + " ";
            }
            output += "\n";
        }
        return output;
    }
}
