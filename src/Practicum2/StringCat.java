package Practicum2;

import java.util.Random;

public class StringCat {

    private static final long SEED = 1234;

    public String generateString(int length) {
        Random rand = new Random(SEED);
        StringBuilder str = new StringBuilder(new String());
        for (int i = 0; i < length; i++) {
            str.append((char) ('a' + rand.nextInt('z' - 'a' + 1)));
        }
        return str.toString();
    }

    /*
    Original function
    public String generateString(int length) {
        Random rand = new Random(SEED);
        String str = new String();
        for (int i = 0; i < length; i++) {
            str += (char) ('a' + rand.nextInt('z' - 'a' + 1));
            // telkens een nieuwe string aanmaken want in Java zijn String is immutable, deze operatie is opzich lineair
        }
        return str;
    }
     */

    public static void main(String[] args) {
        Practicum2.StringCat test = new Practicum2.StringCat();
        int length = 100000;

        long start = System.currentTimeMillis();
        test.generateString(length);
        long stop = System.currentTimeMillis();
        System.out.printf("Time for length %6d is: %d ms\n", length, stop - start);
    }

    // verwachte complexiteit = linear
    // is niet het geval
    // tijd = 793 ms
    // tijd met aanpassing stringbuilder = 11 ms


}
