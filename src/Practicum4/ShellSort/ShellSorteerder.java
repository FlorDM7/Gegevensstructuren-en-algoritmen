package Practicum4.ShellSort;

public class ShellSorteerder implements Sorteerder {

    private int[] incrementreeks;

    public ShellSorteerder(int[] incrementreeks){
        this.incrementreeks = incrementreeks;
    }

    @Override
    public void sorteer(Tabel tabel) {
        int increment;
        for (int i = incrementreeks.length - 1; i >= 0; i--) {
            increment = incrementreeks[i];
            for (int j = 0; j < increment; j++) {
                insertionSort(tabel, increment, j);
            }
        }
    }

    public void insertionSort(Tabel A, int increment, int start) {
        int i;
        int j = increment + start - 1;
        while (j < A.size()) {
            int key = A.get(j);
            // Insert A[j] into the sorted sequence A[1..j-1]
            i = j-increment;
            while(i >= 0 && A.get(i) > key) {
                A.swap(i+increment, i);
                i -= increment;
            }
            j += increment;
        }
    }

}
