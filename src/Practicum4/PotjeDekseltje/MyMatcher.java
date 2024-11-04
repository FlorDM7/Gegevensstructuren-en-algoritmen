package Practicum4.PotjeDekseltje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyMatcher implements Matcher {

    // werkt nog niet
    @Override
    public List<Pair> match(List<Jar> jars, List<Lid> lids) {
        List<Jar> myJars = new ArrayList<>(jars);
        List<Lid> myLids = new ArrayList<>(lids);
        List<Pair> myPairs = new ArrayList<>();
        matchRecursive(myJars, myLids, myPairs, 0, jars.size() - 1, 0, lids.size() - 1);
        return myPairs;
    }

    private void matchRecursive(List<Jar> jars, List<Lid> lids, List<Pair> pairs, int leftJar, int rightJar, int leftLid, int rightLid) {
        if (leftJar < rightJar && leftLid < rightLid) {
            Jar pivotJar = jars.get(rightJar);
            // matchingLid is index of the most right Lid with the value of the pivotJar
            int matchingLid = partitionLids(lids, leftLid, rightLid, pivotJar);
            int originalLid = matchingLid;
            Lid pivotLid = lids.get(matchingLid);
            int matchingJar = partitionJars(jars, leftJar, rightJar, pivotLid);
            int originalJar = matchingJar;
            while (matchingJar >= 0 && matchingLid >= 0 && lids.get(matchingLid).compareTo(jars.get(matchingJar)) == 0) {
                pairs.add(new Pair(jars.get(matchingJar), lids.get(matchingLid)));
                matchingJar--;
                matchingLid--;
            }
            matchRecursive(jars, lids, pairs, leftJar, matchingJar, leftLid, matchingLid);
            matchRecursive(jars, lids, pairs, originalJar + 1, rightJar, originalLid + 1, rightLid);
        } else if (leftJar == rightJar && leftLid == rightLid) {
            pairs.add(new Pair(jars.get(leftJar), lids.get(rightJar)));
        }
    }

    private int partitionLids(List<Lid> list, int left, int right, Jar pivot) {
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i+1, right);
        if (list.get(i+1).compareTo(pivot) == 0) {
            return i+1;
        }
        return i;
    }

    private int partitionJars(List<Jar> list, int left, int right, Lid pivot) {
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i+1, right);
        if (list.get(i+1).compareTo(pivot) == 0) {
            return i+1;
        }
        return i;
    }

}
