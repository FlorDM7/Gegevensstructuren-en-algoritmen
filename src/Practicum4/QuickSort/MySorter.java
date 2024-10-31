package Practicum4.QuickSort;

import java.util.List;

public class MySorter implements Sorter {

    @Override
    public void sort(List<Integer> list) {
        quickSortRecursive(list, 0, list.size() - 1);
    }

    private void quickSortRecursive(List<Integer> list, int left, int right) {
        if (left < right) {
            int q = partition(list, left, right);
            quickSortRecursive(list, left, q - 1);
            quickSortRecursive(list, q + 1, right);
        }
    }

    private int partition(List<Integer> list, int left, int right) {
        int x = list.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (list.get(j) <= x) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i+1, right);
        return i+1;
    }

    private static void swap(List<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

}
