package DynamicProgramming;

import java.util.Arrays;

/**
 * Implementation for the second example given in chapter 15.
 * @author Flor De Meulemeester
 */
public class MatrixChaining {

    /**
     * We multiply 6 (n) matrices. The dimensions of the first matrix are 30x35,
     * for the second one 35x15, etc. (because they have to be compatible)
     * So we only have to 7 (n+1) values when we care about the parenthesization.
     */
    public static final int[] dimensions = new int[]{30, 35, 15, 5, 10, 20, 25};

    public static void main(String[] args) {
        int solution = matrixChainOrder(dimensions);
        System.out.println("\nNumber of scalair multiplications: "  + solution);
    }

    /**
     * Dynamic programming has a time-memory trade-off.
     * A naive recursive implementation without memoization would have an exponential running time.
     * But we keep track if results from problems instead of calculating them again.
     *
     * Time complexity: O(n^3) (we have a triple nested loop of each time n-1 elements)
     * Space complexity: O(n^2) (we keep track of results with 2 n by n matrices)
     */
    public static int matrixChainOrder(int[] p) {
        int j;
        int q;
        int n = p.length - 1;
        int[][] matrix = new int[n][n];
        int[][] solution = new int[n - 1][n - 1];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
        }
        for (int l = 1; l < n; l++) {   // l is the chain length
            for (int i = 0; i < n - l; i++) {
                j = i + l;
                matrix[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    // een beetje sukkelen met de indices maar het lukt
                    q = matrix[i][k] + matrix[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < matrix[i][j]) {
                        matrix[i][j] = q;
                        solution[i][j - 1] = k + 1;
                    }
                }
            }
        }
        // print out the dynamic programming matrices
        System.out.println("Matrix: ");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Solution matrix: ");
        for (int[] row : solution) {
            System.out.println(Arrays.toString(row));
        }
        // print the solution
        System.out.println("Solution: ");
        printSolution(solution, 0, n - 1);
        // the minimal amount of scalair multiplications is now found in matrix[0][n-1]
        return matrix[0][n - 1];
    }

    public static void printSolution(int[][] solution, int i, int j) {
        if (i == j) {
            System.out.print(i + 1);
        } else {
            System.out.print("(");
            printSolution(solution, i, solution[i][j - 1] - 1);
            printSolution(solution, solution[i][j - 1], j);
            System.out.print(")");
        }
    }
}