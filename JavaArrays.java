// Topic: Working with Java Arrays
// Demonstrates: 1D, 2D arrays, java.util.Arrays class

import java.util.Arrays;

public class JavaArrays {

    public static void main(String[] args) {
        // --- 1D Array ---
        System.out.println("=== 1D Array ===");
        int[] numbers = {5, 3, 8, 1, 9, 2, 7};
        System.out.println("Original : " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sorted   : " + Arrays.toString(numbers));
        System.out.println("Search 8 : index " + Arrays.binarySearch(numbers, 8));

        // Copy
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        int[] range = Arrays.copyOfRange(numbers, 2, 5);
        System.out.println("Copy     : " + Arrays.toString(copy));
        System.out.println("Range[2-5]: " + Arrays.toString(range));

        // Fill
        int[] filled = new int[5];
        Arrays.fill(filled, 99);
        System.out.println("Filled   : " + Arrays.toString(filled));

        // --- 2D Array ---
        System.out.println("\n=== 2D Array (Matrix) ===");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) System.out.printf("%4d", val);
            System.out.println();
        }

        System.out.println("\nTranspose:");
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) System.out.printf("%4d", matrix[row][col]);
            System.out.println();
        }

        // 2D array to string
        System.out.println("\ndeepToString: " + Arrays.deepToString(matrix));
    }
}
