package Algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmsTest {

    /**
     * INSERTION SORT
     */

    @Test
    void testInsertionSortWithUnsortedArray() {
        int[] inputArray = {5, 2, 4, 6, 1, 3};
        int[] expectedArray = {1, 2, 3, 4, 5, 6};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray, "The array should be sorted in ascending order.");
    }

    @Test
    void testInsertionSortWithSortedArray() {
        int[] inputArray = {1, 2, 3, 4, 5, 6};
        int[] expectedArray = {1, 2, 3, 4, 5, 6};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray, "An already sorted array should remain unchanged.");
    }

    @Test
    void testInsertionSortWithReverseSortedArray() {
        int[] inputArray = {6, 5, 4, 3, 2, 1};
        int[] expectedArray = {1, 2, 3, 4, 5, 6};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray, "A reverse sorted array should be sorted in ascending order.");
    }

    @Test
    void testInsertionSortWithSingleElementArray() {
        int[] inputArray = {42};
        int[] expectedArray = {42};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray, "An array with a single element should remain unchanged.");
    }

    @Test
    void testInsertionSortWithEmptyArray() {
        int[] inputArray = {};
        int[] expectedArray = {};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray, "An empty array should remain unchanged.");
    }

    @Test
    void testInsertionSortCase1() {
        int[] inputArray = {5, 12, 3, 19, 7, 1, 8};
        int[] expectedArray = {1, 3, 5, 7, 8, 12, 19};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase2() {
        int[] inputArray = {15, 6, 2, 9, 14, 13, 1};
        int[] expectedArray = {1, 2, 6, 9, 13, 14, 15};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase3() {
        int[] inputArray = {-5, -12, -3, -19, -7, -1, -8};
        int[] expectedArray = {-19, -12, -8, -7, -5, -3, -1};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase4() {
        int[] inputArray = {100, 99, 98, 97, 96, 95};
        int[] expectedArray = {95, 96, 97, 98, 99, 100};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase5() {
        int[] inputArray = {4, 8, 12, 16, 20, 24, 28};
        int[] expectedArray = {4, 8, 12, 16, 20, 24, 28};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase6() {
        int[] inputArray = {9, 4, 8, 7, 3, 6, 2, 5, 1};
        int[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase7() {
        int[] inputArray = {11, 22, 33, 44, 55, 66};
        int[] expectedArray = {11, 22, 33, 44, 55, 66};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase8() {
        int[] inputArray = {21, 15, 13, 19, 10, 7, 4};
        int[] expectedArray = {4, 7, 10, 13, 15, 19, 21};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase9() {
        int[] inputArray = {3, 3, 3, 3, 3, 3};
        int[] expectedArray = {3, 3, 3, 3, 3, 3};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase10() {
        int[] inputArray = {-10, -5, 0, 5, 10};
        int[] expectedArray = {-10, -5, 0, 5, 10};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase11() {
        int[] inputArray = {100, 200, 50, 75, 25, 150, 175, 0};
        int[] expectedArray = {0, 25, 50, 75, 100, 150, 175, 200};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase12() {
        int[] inputArray = {15, 1, 23, 8, 10, 16, 25, 5, 30};
        int[] expectedArray = {1, 5, 8, 10, 15, 16, 23, 25, 30};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase13() {
        int[] inputArray = {-9, 4, 0, -3, 8, 5, -6, 7};
        int[] expectedArray = {-9, -6, -3, 0, 4, 5, 7, 8};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase14() {
        int[] inputArray = {99, 3, 100, 98, 4, 97, 2};
        int[] expectedArray = {2, 3, 4, 97, 98, 99, 100};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase15() {
        int[] inputArray = {-2, -4, -1, -5, 0, -3};
        int[] expectedArray = {-5, -4, -3, -2, -1, 0};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase16() {
        int[] inputArray = {8, 0, 1, 8, 3, 8, 7, 4};
        int[] expectedArray = {0, 1, 3, 4, 7, 8, 8, 8};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase17() {
        int[] inputArray = {90, 10, 80, 20, 70, 30, 60, 40, 50};
        int[] expectedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase18() {
        int[] inputArray = {-15, 5, -10, 0, -5, 10};
        int[] expectedArray = {-15, -10, -5, 0, 5, 10};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase19() {
        int[] inputArray = {50, 100, 150, 0, -50, -100};
        int[] expectedArray = {-100, -50, 0, 50, 100, 150};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase20() {
        int[] inputArray = {8, 4, 12, 16, 20, 2, 0, 14, 18};
        int[] expectedArray = {0, 2, 4, 8, 12, 14, 16, 18, 20};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase21() {
        int[] inputArray = {1024, 512, 256, 128, 64, 32, 16};
        int[] expectedArray = {16, 32, 64, 128, 256, 512, 1024};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase22() {
        int[] inputArray = {23, 47, 15, 8, 89, 67, 24, 68, 35};
        int[] expectedArray = {8, 15, 23, 24, 35, 47, 67, 68, 89};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase23() {
        int[] inputArray = {-99, -66, -33, -44, -88, -22, -55};
        int[] expectedArray = {-99, -88, -66, -55, -44, -33, -22};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase24() {
        int[] inputArray = {7, 0, -7, 14, -14, 21, -21};
        int[] expectedArray = {-21, -14, -7, 0, 7, 14, 21};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testInsertionSortCase25() {
        int[] inputArray = {55, 11, 22, 33, 44, 66, 99, 77, 88};
        int[] expectedArray = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    /**
     * MERGE SORT
     */

    @Test
    void testMergeSortWithUnsortedArray() {
        int[] inputArray = {5, 2, 4, 6, 1, 3};
        int[] expectedArray = {1, 2, 3, 4, 5, 6};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray, "The array should be sorted in ascending order.");
    }

    @Test
    void testMergeSortWithSortedArray() {
        int[] inputArray = {1, 2, 3, 4, 5, 6};
        int[] expectedArray = {1, 2, 3, 4, 5, 6};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray, "An already sorted array should remain unchanged.");
    }

    @Test
    void testMergeSortWithReverseSortedArray() {
        int[] inputArray = {6, 5, 4, 3, 2, 1};
        int[] expectedArray = {1, 2, 3, 4, 5, 6};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray, "A reverse sorted array should be sorted in ascending order.");
    }

    @Test
    void testMergeSortWithSingleElementArray() {
        int[] inputArray = {42};
        int[] expectedArray = {42};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray, "An array with a single element should remain unchanged.");
    }

    @Test
    void testMergeSortWithEmptyArray() {
        int[] inputArray = {};
        int[] expectedArray = {};
        SortingAlgorithms.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray, "An empty array should remain unchanged.");
    }

    @Test
    void testMergeSortCase1() {
        int[] inputArray = {5, 12, 3, 19, 7, 1, 8};
        int[] expectedArray = {1, 3, 5, 7, 8, 12, 19};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase2() {
        int[] inputArray = {15, 6, 2, 9, 14, 13, 1};
        int[] expectedArray = {1, 2, 6, 9, 13, 14, 15};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase3() {
        int[] inputArray = {-5, -12, -3, -19, -7, -1, -8};
        int[] expectedArray = {-19, -12, -8, -7, -5, -3, -1};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase4() {
        int[] inputArray = {100, 99, 98, 97, 96, 95};
        int[] expectedArray = {95, 96, 97, 98, 99, 100};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase5() {
        int[] inputArray = {4, 8, 12, 16, 20, 24, 28};
        int[] expectedArray = {4, 8, 12, 16, 20, 24, 28};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase6() {
        int[] inputArray = {9, 4, 8, 7, 3, 6, 2, 5, 1};
        int[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase7() {
        int[] inputArray = {11, 22, 33, 44, 55, 66};
        int[] expectedArray = {11, 22, 33, 44, 55, 66};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase8() {
        int[] inputArray = {21, 15, 13, 19, 10, 7, 4};
        int[] expectedArray = {4, 7, 10, 13, 15, 19, 21};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase9() {
        int[] inputArray = {3, 3, 3, 3, 3, 3};
        int[] expectedArray = {3, 3, 3, 3, 3, 3};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase10() {
        int[] inputArray = {-10, -5, 0, 5, 10};
        int[] expectedArray = {-10, -5, 0, 5, 10};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase11() {
        int[] inputArray = {100, 200, 50, 75, 25, 150, 175, 0};
        int[] expectedArray = {0, 25, 50, 75, 100, 150, 175, 200};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase12() {
        int[] inputArray = {15, 1, 23, 8, 10, 16, 25, 5, 30};
        int[] expectedArray = {1, 5, 8, 10, 15, 16, 23, 25, 30};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase13() {
        int[] inputArray = {-9, 4, 0, -3, 8, 5, -6, 7};
        int[] expectedArray = {-9, -6, -3, 0, 4, 5, 7, 8};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase14() {
        int[] inputArray = {99, 3, 100, 98, 4, 97, 2};
        int[] expectedArray = {2, 3, 4, 97, 98, 99, 100};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase15() {
        int[] inputArray = {-2, -4, -1, -5, 0, -3};
        int[] expectedArray = {-5, -4, -3, -2, -1, 0};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase16() {
        int[] inputArray = {8, 0, 1, 8, 3, 8, 7, 4};
        int[] expectedArray = {0, 1, 3, 4, 7, 8, 8, 8};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase17() {
        int[] inputArray = {90, 10, 80, 20, 70, 30, 60, 40, 50};
        int[] expectedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase18() {
        int[] inputArray = {-15, 5, -10, 0, -5, 10};
        int[] expectedArray = {-15, -10, -5, 0, 5, 10};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase19() {
        int[] inputArray = {50, 100, 150, 0, -50, -100};
        int[] expectedArray = {-100, -50, 0, 50, 100, 150};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase20() {
        int[] inputArray = {8, 4, 12, 16, 20, 2, 0, 14, 18};
        int[] expectedArray = {0, 2, 4, 8, 12, 14, 16, 18, 20};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase21() {
        int[] inputArray = {1024, 512, 256, 128, 64, 32, 16};
        int[] expectedArray = {16, 32, 64, 128, 256, 512, 1024};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase22() {
        int[] inputArray = {23, 47, 15, 8, 89, 67, 24, 68, 35};
        int[] expectedArray = {8, 15, 23, 24, 35, 47, 67, 68, 89};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase23() {
        int[] inputArray = {-99, -66, -33, -44, -88, -22, -55};
        int[] expectedArray = {-99, -88, -66, -55, -44, -33, -22};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase24() {
        int[] inputArray = {7, 0, -7, 14, -14, 21, -21};
        int[] expectedArray = {-21, -14, -7, 0, 7, 14, 21};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testMergeSortCase25() {
        int[] inputArray = {55, 11, 22, 33, 44, 66, 99, 77, 88};
        int[] expectedArray = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        SortingAlgorithms.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

}