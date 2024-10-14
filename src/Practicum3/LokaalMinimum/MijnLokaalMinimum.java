package Practicum3.LokaalMinimum;

public class MijnLokaalMinimum implements LokaalMinimum {

    @Override
    public int lokaalMinimum(int[] rij) {
        int i = 0; // pointer begin van lijst
        int j = rij.length - 1; // pointer einde van lijst
        int m = (j+i) / 2; // midden van lijst

        // telkens de array in 2 splitsen
        while (j-i > 1) {
            if (rij[m-1] > rij[m] && rij[m] < rij[m+1]) {
                // check of het midden een lokaal minimum is
                return rij[m];
            } else if (rij[m] < rij[m+1]) {
                // lokaal minimum ligt in linkerdeellijst
                j = m;
            } else {
                // lokaal minimum ligt in de rechterdeellijst
                i = m;
            }
            m = (j+i) / 2; // herbereken het midden
        }

        // als j-i > 1 dan zijn er nog twee opties over, neem de kleinste
        if (rij[i] > rij[j]) {
            return rij[j];
        } else {
            return rij[i];
        }

    }
}
