package Practicum3.BitonicSearch;

import Practicum3.Sequence;

public class MyBitonicSearcher implements BitonicSearcher {

    @Override
    public int bitonicSearch(Sequence numbers, int query) {
        if (numbers.size() == 0) return -1;

        // zoek eerst het bitonisch element
        int indexBitonic = findMaximumIndex(numbers, 0, numbers.size() - 1);

        // overloop verschillende gevallen
        if (numbers.get(indexBitonic) == query) {
            return indexBitonic;
        } else if (numbers.get(indexBitonic) < query) {
            return -1;
        } else {
            int l = binairySearchAscending(numbers,query,0, indexBitonic - 1); // zoek links, stijgende deel array
            if (l != -1) {
                return l;
            } else {
                return binairySearchDescending(numbers,query,indexBitonic + 1, numbers.size() - 1); // zoek rechts, dalende deel array
            }
        }
    }

    private int findMaximumIndex(Sequence numbers, int start, int end) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;
        if (numbers.get(mid - 1) < numbers.get(mid) && numbers.get(mid) > numbers.get(mid + 1)) {
            return mid;
        } else if (numbers.get(mid) < numbers.get(mid + 1)) {
            return findMaximumIndex(numbers, mid + 1, end);
        } else {
            return findMaximumIndex(numbers, start, mid -1);
        }
    }

    private int binairySearchAscending(Sequence numbers, int query, int start, int end) {
        if (start > end) {
            return -1;
        }

        if (start == end) {
            if (numbers.get(start) == query) {
                return start;
            } else {
                return -1;
            }
        }

        int mid = (start + end) / 2;
        if (numbers.get(mid) == query) {
            return mid;
        } else if (numbers.get(mid) < query) {
            return binairySearchAscending(numbers, query, mid+1, end); // indien groter, zoek rechts
        } else {
            return binairySearchAscending(numbers, query, start, mid - 1);
        }
    }

    private int binairySearchDescending(Sequence numbers, int query, int start, int end) {
        if (start > end) {
            return -1;
        }

        if (start == end) {
            if (numbers.get(start) == query) {
                return start;
            } else {
                return -1;
            }
        }

        int mid = (start + end) / 2;
        if (numbers.get(mid) == query) {
            return mid;
        } else if (numbers.get(mid) < query) {
            return binairySearchDescending(numbers, query, start, mid - 1); // indien groter, zoek links
        } else {
            return binairySearchDescending(numbers, query, mid + 1, end);
        }
    }

}
