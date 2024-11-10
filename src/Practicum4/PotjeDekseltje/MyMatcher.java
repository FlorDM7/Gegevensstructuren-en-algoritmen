package Practicum4.PotjeDekseltje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyMatcher implements Matcher {

    @Override
    public List<Pair> match(List<Jar> jars, List<Lid> lids) {
        List<Jar> myJars = new ArrayList<>(jars);
        List<Lid> myLids = new ArrayList<>(lids);
        List<Pair> myPairs = new ArrayList<>();
        int n = myJars.size() - 1;
        matchRecursive(myJars, myLids, myPairs, 0, n, 0, n);
        return myPairs;
    }

    /**
     * First pick a jar and then rearrange to lids in three groups (smaller, equal or bigger than the jar).
     * Then for a lid that fits the jar (there is a least one always),
     * rearrange the jars also in three groups (smaller, equal or bigger than the lid).
     * For the jars and lids that equal the pivot value make pairs.
     * Finally do recursion on the group smaller and the bigger group
     *
     * @param jars
     * List of jars
     * @param lids
     * List of lids
     * @param pairs
     * List of pairs
     * @param leftJar
     * Left pointer for the jars
     * @param rightJar
     * Right pointer for the jars
     * @param leftLid
     * Left pointer for the lids
     * @param rightLid
     * Right pointer for the lids
     */
    private void matchRecursive(List<Jar> jars, List<Lid> lids, List<Pair> pairs, int leftJar, int rightJar, int leftLid, int rightLid) {
        if (leftJar < rightJar && leftLid < rightLid) {
            // rearrange the lids based on a chosen jar
            Jar pivotJar = jars.get(rightJar);
            int sameLid = partitionLids(lids, leftLid, rightLid, pivotJar); // sameLid is the index of the last element of the second group
            int newRightLid = sameLid + 1; // so this is the first index of the third group, used for the recursion

            // now rearrange the jars given the lid that matches the jar chosen above
            Lid pivotLid = lids.get(sameLid);
            int sameJar = partitionJars(jars, leftJar, rightJar, pivotLid); // sameJar is the index of the last element of the second group
            int newRightJar = sameJar + 1; // so this is the first index of the third group, used for the recursion

            // now we are the right side of the second group in each list (with lids and jars that are equal)
            // we go left until they are not equal to the pivot anymore
            while (sameJar >= leftJar && sameLid >= leftLid && jars.get(sameJar).compareTo(lids.get(sameLid)) == 0 && jars.get(sameJar).compareTo(pivotLid) == 0) {
                // yay we have found a pair
                pairs.add(new Pair(jars.get(sameJar), lids.get(sameLid)));
                sameJar--;
                sameLid--;
            }
            // do recursion on the lids and jars that are smaller than the pivot
            matchRecursive(jars, lids, pairs, leftJar, sameJar, leftLid, sameLid);
            // do recursion on the lids and jars that are bigger than the pivot
            matchRecursive(jars, lids, pairs, newRightJar, rightJar, newRightLid, rightLid);
        } else if (leftJar == rightJar && leftLid == rightLid) {
            pairs.add(new Pair(jars.get(leftJar), lids.get(leftLid)));
        }
    }

    private int partitionLids(List<Lid> list, int left, int right, Jar pivot) {
        // first do partition like in quicksort
        int i = left - 1;
        for (int j = left; j <= right; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        // i is now the last element of the group that is smaller or equal to the pivot
        int result = i;
        // the values that are equal to the pivot should be at the end of the first group
        // (creating a middle group that is equal to the pivot, guaranteed there is at least one)
        for (int j = 0; j <= i; j++) {
            if (list.get(j).compareTo(pivot) == 0) {
                Collections.swap(list, j, i);
                i--;
            }
        }
        return result;
    }

    /**
     * Copy of partitionLids (except the type of the arguments)
     */
    private int partitionJars(List<Jar> list, int left, int right, Lid pivot) {
        // first do partition like in quicksort
        int i = left - 1;
        for (int j = left; j <= right; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        // i is now the last element of the group that is smaller or equal to the pivot
        int result = i;
        // the values that are equal to the pivot should be at the end of the first group
        // (creating a middle group that is equal to the pivot, guaranteed there is at least one)
        for (int j = 0; j <= i; j++) {
            if (list.get(j).compareTo(pivot) == 0) {
                Collections.swap(list, j, i);
                i--;
            }
        }
        return result;
    }

}
