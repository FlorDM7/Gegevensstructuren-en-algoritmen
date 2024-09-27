package Practicum1.Driesomprobleem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MijnDrieSomProbleem implements DrieSomProbleem {

    @Override
    public TripletIndices zoekNulSomTriplet(List<Integer> gesorteerdeInvoer) {
        if (gesorteerdeInvoer.size() < 3) return null;

        // dubbele pointer
        int p = 0;
        int q = gesorteerdeInvoer.size() - 1;

        while (p < q) {
            for (int i = 0; i < gesorteerdeInvoer.size(); i++) {
                if (i != p && i != q) {
                    if (sumIsZero(gesorteerdeInvoer.get(p),gesorteerdeInvoer.get(i), gesorteerdeInvoer.get(q))) {
                        List<Integer> list = Arrays.asList(p,i,q);
                        Collections.sort(list);
                        return new TripletIndices(list.getFirst(),list.get(1),list.getLast());
                    }
                }
            }
            if (Math.abs(gesorteerdeInvoer.get(p)) >= gesorteerdeInvoer.get(q)) {
                p++;
            } else {
                q--;
            }
        }

        return null;
    }

    public boolean sumIsZero(int i, int j, int k) {
        return i + j + k == 0;
    }

}
