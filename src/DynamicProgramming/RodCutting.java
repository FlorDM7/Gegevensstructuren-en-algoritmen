package DynamicProgramming;

import java.util.ArrayList;

/**
 * Implementation for example given in chapter 15.
 * @author Flor De Meulemeester
 */
public class RodCutting {

    public static final int[] prices = new int[] {1,5,8,9,10,17,17,20,24,30};

    public static void main(String[] args) {
        int n = 10;
        // naive
        long startTime = System.currentTimeMillis();
        System.out.println(cutRod(prices, n));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
        // dynamic programming
        startTime = System.currentTimeMillis();
        System.out.println(bottomUpCutRod(prices, n));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }

    /**
     * Naive recursive implementation
     * O(2^n)
     */
    public static int cutRod(int[] p, int n) {
        if (n == 0) {
            return n;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            q = Math.max(q, p[i] + cutRod(p, n - i - 1));
        }
        return q;
    }

    /**
     * Dynamic programming implementation (bottom-up)
     * O(n^2)
     */
    public static int bottomUpCutRod(int[] p, int n) {
        int[] dp = new int[n+1];
        int[] solution = new int[n+1];
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                if (q < p[i-1] + dp[j-i]) {
                    q = p[i-1] + dp[j-i];
                    solution[j] = i;
                }
            }
            dp[j] = q;
        }
        printCutRodSolution(n, dp, solution);
        return dp[n];
    }

    public static void printCutRodSolution(int n, int[] dp, int[] solution) {
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(solution[n]);
            n = n - solution[n];
        }
        System.out.println("Solution: " + list.toString());
    }

}
