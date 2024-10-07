package Practicum2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomSum {

    private static final int MAX = 10000;

    private static final long SEED = 1234;

    public static long sum(int start, int end, int iterations) {
        Random random = new Random(SEED); // SEED is for debugging purposes

        ArrayList<Integer> array = new ArrayList<Integer>();
        // gewone array nog iets beter maar moeilijker te gebruiken

        long startTime = System.currentTimeMillis();
        // Populate map
        for (int i = start; i < end; i++) {
            array.add(random.nextInt(MAX));
        }
        System.out.printf("Time elapsed: %d ms\n", System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < iterations; i++) {
            sum += array.get(random.nextInt(end - start)); // is altijd constant
        }
        System.out.printf("Time elapsed: %d ms\n", System.currentTimeMillis() - startTime);

        return sum;
    }

    /*
    Original function
    public static long sum(int start, int end, int iterations) {
        Random random = new Random(SEED);

        Map<Integer, Integer> map = new HashMap<>();

        //Populate map
        for (int i = start; i < end; i++) {
            map.put(i, random.nextInt(MAX));
        }

        long sum = 0;
        for (int i = 0; i < iterations; i++) {
            sum += map.get(random.nextInt(end - start) + start);
        }
        // ophalen duurt (VEEL) langer

        return sum;
    }
     */

    public static void main(String[] args) {
        int start = 97;
        int end = 200000;
        int iterations = 50000000;
        System.out.println("Sum is: " + sum(start, end, iterations));
    }

}
