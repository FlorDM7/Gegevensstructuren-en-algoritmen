package Practicum4.CoutingSort;

import java.util.List;

public class CountingScoreBord implements ScoreBord {

    @Override
    public void sort(List<Student> studenten, int max) {
        int n = studenten.size();
        Student[] b = new Student[n]; // to be sorted array (of fixed length)
        // waarden van 0 t.e.m. k
        int[] c = new int[max+1];  // help array initialized with 0

        for (Student student : studenten) {
            c[student.getScore()]++;
        }
        // c[i] now contains the amount of students with score i

        for (int i=1; i<=max; i++) {
            c[i] += c[i-1];
        }
        // c[i] now contains the amount of students with score i or lower

        for (int i=n-1; i>=0; i--) {
            b[c[studenten.get(i).getScore()] - 1] = studenten.get(i); // -1 omdat het grootste element van c = n
            c[studenten.get(i).getScore()]--;
        }

        for (int i=0; i<n; i++) {
            studenten.set(i, b[i]);
        }
    }

    /*
    pseudocode:

    function CountingSort(a[1,..,n], max)

       for j from 0 to max do
          c[j] = 0
       for i from 1 to n do
          c[a[i]] = c[a[i]] + 1
       for j from 1 to max do
          c[j] = c[j] + c[j-1]
       for i from n to 1 do
          b[c[a[i]]] = a[i]
          c[a[i]] = c[a[i]] - 1
       for i from 1 to n do
          a[i] = b[i]

     */

}
