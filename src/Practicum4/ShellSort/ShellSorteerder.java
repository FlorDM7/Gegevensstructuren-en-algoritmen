package Practicum4.ShellSort;

public class ShellSorteerder implements Sorteerder {

    private int[] incrementreeks;

    public ShellSorteerder(int[] incrementreeks){
        this.incrementreeks = incrementreeks;
    }

    @Override
    public void sorteer(Tabel tabel) {
        for (int i : incrementreeks) {
            for (int j = i; j > 0; j--) {
                insertionSort(tabel, i + j);
            }
        }
    }

    public static void insertionSort(Tabel A, int increment){
        int i;
        int j = increment*2;
        while (j < A.size()) {
            int key = A.get(j);
            // Insert A[j] into the sorted sequence A[1..j-1]
            i = j-increment;
            while(i >= 0 && A.get(j) > key) {
                A.swap(i+increment, i);
                i -= increment;
            }
            A.swap(i+increment, j);
            j += increment;
        }
    }

}
