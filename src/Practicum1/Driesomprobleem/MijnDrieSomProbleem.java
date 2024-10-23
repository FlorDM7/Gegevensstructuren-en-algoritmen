package Practicum1.Driesomprobleem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MijnDrieSomProbleem implements DrieSomProbleem {

    @Override
    public TripletIndices zoekNulSomTriplet(List<Integer> gesorteerdeInvoer) {
        if (gesorteerdeInvoer.size() < 3) return null;

        // neem 1 vaste i en ga ermee over de array
        for (int i = 0; i < gesorteerdeInvoer.size(); i++) {
            // indien het vorige getal dezelfde waarde had, skip de loop eenmalig
            if (i > 0 && gesorteerdeInvoer.get(i).equals(gesorteerdeInvoer.get(i - 1))) {
                continue;
            }

            // dubbele pointer ACHTER de i en kijk of er een som is
            int p = i + 1;
            int q = gesorteerdeInvoer.size() - 1;

            while (p < q) {
                if (gesorteerdeInvoer.get(p) + gesorteerdeInvoer.get(i) + gesorteerdeInvoer.get(q) == 0) {
                    List<Integer> list = Arrays.asList(p, i, q);
                    Collections.sort(list);
                    return new TripletIndices(list.getFirst(), list.get(1), list.getLast());
                } else if (gesorteerdeInvoer.get(p) + gesorteerdeInvoer.get(i) + gesorteerdeInvoer.get(q) > 0) {
                    q--;
                } else {
                    p++;
                }
            }
        }

        return null;
    }

}
