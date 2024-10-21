package Practicum3.Meerderheidselement;

import Practicum3.Sequence;

public class MyMajority implements Majority {

    @Override
    public int findMajority(Sequence numbers) {
        if (numbers.size() == 1) {
            return numbers.get(0);
        }

        int mid = numbers.size() / 2;
        int possibleMajorityA = findMajority(numbers.subSequence(0, mid));
        int possibleMajorityB = findMajority(numbers.subSequence(mid, numbers.size()));

        if (possibleMajorityA == possibleMajorityB) {
            return possibleMajorityA;
        }

        int aantalKeerA = 0;
        int aantalKeerB = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (possibleMajorityA == numbers.get(i)) aantalKeerA++;
            if (possibleMajorityB == numbers.get(i)) aantalKeerB++;
        }

        if (aantalKeerB > mid) {
            return possibleMajorityB;
        }

        if (aantalKeerA > mid) {
            return possibleMajorityA;
        }

        return -1;
    }
}
