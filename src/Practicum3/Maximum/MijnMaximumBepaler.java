package Practicum3.Maximum;

public class MijnMaximumBepaler implements MaximumBepaler {

    @Override
    public int bepaalMaximum(int... rij) throws IllegalArgumentException {
        if (rij.length == 0) throw new IllegalArgumentException("Lege lijst!");

        int i = 0; // pointer begin
        int j = rij.length - 1; // pointer einde
        int m = (i+j) / 2; // pointer midden

        while (j-i > 1) {
            if (rij[m-1] < rij[m] && rij[m] > rij[m+1]) {
                // check of het midden het maximum is
                return rij[m];
            } else if (rij[i] > rij[m] && rij[m] < rij[j]) {
                // maximum ligt in linkerdeellijst (want het begin is groter dan midden)
                j = m;
            } else {
                // maximum ligt in de rechterdeellijst
                i = m;
            }
            m = (j+i) / 2; // herbereken het midden
        }

        // nog 2 over, neem het maximum
        if (rij[i] < rij[j]) {
            return rij[j];
        } else {
            return rij[i];
        }
    }
}
