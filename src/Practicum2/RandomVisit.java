package Practicum2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomVisit {

    private static final long SEED = 1234;

    // 60ms andere voorstelling
    public static int visitElements(int dimension1, int dimension2,
                                    int dimension3, int iterations,
                                    int internalIterations) {
        Random random = new Random(SEED);

        int numberVisited = 0;

        for (int i = 0; i < iterations; i++) {
            List<Integer> alreadyVisited = new ArrayList<Integer>();
            for (int j = 0; j < internalIterations; j++) {
                int a = random.nextInt(dimension1);
                int b = random.nextInt(dimension2);
                int c = random.nextInt(dimension3);
                int voorstelling = a*dimension1*dimension2 + b * dimension1 + c;
                if (!alreadyVisited.contains(voorstelling)) {
                    numberVisited++;
                    alreadyVisited.add(voorstelling);
                }
            }
        }
        return numberVisited;
    }

    /*
    Eerste optimalisatie: volgorde wijzigen (1150ms)
    public static int visitElements(int dimension1, int dimension2,
                                    int dimension3, int iterations,
                                    int internalIterations) {
        Random random = new Random(SEED);

        int numberVisited = 0;

        // dimensies van kleiner naar groot sorteren
        if (dimension1 > dimension2) {
            int tmp = dimension1;
            dimension1 = dimension2;
            dimension2 = tmp;
        }
        if (dimension2 > dimension3) {
            int tmp = dimension2;
            dimension2 = dimension3;
            dimension3 = tmp;
        }

        for (int i = 0; i < iterations; i++) {
            boolean[][][] alreadyVisited = new boolean[dimension1][dimension2][dimension3];
            for (int j = 0; j < internalIterations; j++) {
                int a = random.nextInt(dimension1);
                int b = random.nextInt(dimension2);
                int c = random.nextInt(dimension3);
                if (!alreadyVisited[a][b][c]) {
                    alreadyVisited[a][b][c] = true;
                    numberVisited++;
                }
            }
        }
        return numberVisited;
    }
    */

    /*
    Original function (24407ms)
    public static int visitElements(int dimension1, int dimension2,
                                    int dimension3, int iterations,
                                    int internalIterations) {
        Random random = new Random(SEED);

        int numberVisited = 0;
        for (int i = 0; i < iterations; i++) {
            boolean[][][] alreadyVisited = new boolean[dimension1][dimension2][dimension3];
            for (int j = 0; j < internalIterations; j++) {
                int a = random.nextInt(dimension1);
                int b = random.nextInt(dimension2);
                int c = random.nextInt(dimension3);
                if (!alreadyVisited[a][b][c]) {
                    alreadyVisited[a][b][c] = true;
                    numberVisited++;
                }
            }
        }
        return numberVisited;
    }
    */

    public static void main(String[] args) {
        int dimension1 = 10000;
        int dimension2 = 100;
        int dimension3 = 10;
        int iterations = 1000;
        int internalIterations = 200;

        int visited = visitElements(dimension1, dimension2, dimension3,
                                    iterations, internalIterations);
        System.out.println("Number of elements visited " + visited);
    }

}
