package Algorithms;

/**
 * Java implementation for the sorting algorithms discussed in this course.
 * Based on the pseudocode from the slides.
 * General note: Pseudocode starts counting at index 1, in Java we start at 0.
 *
 * @author Flor De Meulemeester
 */
public class SortingAlgorithms {

    /**
     * Insertion Sort
     * Time complexity is O(n^2)
     * Space complexity is O(1)
     */
    public static void insertionSort(int[] A){
        int i;
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            // Insert A[j] into the sorted sequence A[1..j-1]
            i = j-1;
            while(i >= 0 && A[i] > key) {
                A[i+1] = A[i];
                i = i-1;
            }
            A[i+1] = key;
        }
    }

    /**
     * Merge Sort
     * Time Complexity is O(n*log(n))
     * Space Complexity is O(n)
     */
    public static void mergeSort(int[] A){
        mergeSortRecursive(A, 0, A.length-1);
    }

    private static void mergeSortRecursive(int[] A, int start, int end){
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortRecursive(A, start, mid);
            mergeSortRecursive(A, mid + 1, end);
            merge(A, start, mid, end);
        }
    }

    /**
     * Merging two sorted arrays
     */
    private static void merge(int[] A, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;
        // two new arrays L[1..n1+1] and R[1..n2+1]
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        // make the two separate arrays with the original values
        for (int i = 0; i < n1; i++) {
            L[i] = A[start + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[mid + 1 + j];
        }
        // Last element of the list is 'infinity'
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        // Here we actually merge back into A
        // We use three pointers, one in each array
        // We start at the front, we check what is the smallest value in both of our sub-arrays,
        // then we put that value in A, we increment and look for the next smallest value
        // the result is a sorted array A
        for (int k = start; k <= end; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    /**
     * Heap sort
     * Time complexity is O(n*log(n))
     * Space complexity is O(1)
     */
    public static void heapSort(int[] A) {
        buildMaxHeap(A);
        int n = A.length - 1;
        for (int i = A.length - 1; i > 1; i--) {
            swap(A, 0,i);
            n--;
            maxHeapify(A, 0, n);
        }
    }

    private static void buildMaxHeap(int[] A) {
        int n = A.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxHeapify(A, i, n);
        }
    }

    private static void maxHeapify(int[] A, int i, int n) {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest;
        if (l < n && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < n && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(A, i, largest);
            maxHeapify(A, largest, n);
        }
    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static int rightChild(int i) {
        return 2 * i + 2;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * Quick sort
     */
    public static void quickSort(int[] A) {

    }

}
