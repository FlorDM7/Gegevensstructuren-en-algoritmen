package Practicum3.BitonicSearch;

import Practicum3.Sequence;

public class MyBitonicSearcher implements BitonicSearcher {

    @Override
    public int bitonicSearch(Sequence numbers, int query) {
        if (numbers.size() == 0) return -1;
        return bitonicSearchRecursive(numbers, query, 0, numbers.size() - 1);
    }

    private int bitonicSearchRecursive(Sequence numbers, int query, int start, int end) {
        if (start == end) {
            if (numbers.get(start) == query) {
                return start;
            } else {
                return -1;
            }
        }

        int mid = (start + end) / 2;
        int eersteDeel = bitonicSearchRecursive(numbers, query, start, mid);
        int tweedeDeel = bitonicSearchRecursive(numbers, query, mid+1, end);

        if (eersteDeel != -1) {
            return eersteDeel;
        } else {
            return tweedeDeel;
        }
    }

}
