import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        // printPermuations(new int[] {1,2,3,4});
        // permuteWithoutIdentity(new int[] {1,2,3,4});
    }

    public static void permuteWithoutIdentity(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            swap(A, i, ThreadLocalRandom.current().nextInt(i+1, n));
            System.out.println(Arrays.toString(A));
        }
    }

    public static void printPermutations(int[] A) {
        printPermutationsRecursive(A, 0, A.length);
    }

    private static void printPermutationsRecursive(int[] A, int start, int end) {
        if (start == end) System.out.println(Arrays.toString(A));
        else {
            // we behouden start en nemen permutaties van de subarray
            printPermutationsRecursive(A, start + 1, end);
            for (int i = start + 1; i < end; i++) {
                swap(A, i, start); // we wisselen start zodat ook andere getallen buiten de subarray geraken
                printPermutationsRecursive(A, start + 1, end);
                swap(A, start, i); // we wisselen terug zodat we de tel niet kwijt geraken
            }
        }
    }

    /**
     * Swaps to elements in an int array.
     */
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}