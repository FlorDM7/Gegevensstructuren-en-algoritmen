package Practicum1.BeroemdheidZoeken;

import java.util.ArrayList;
import java.util.List;

public class MijnZoeker implements Zoeker {


    @Override
    public Persoon zoekBeroemdheid(List<Persoon> groep) {
        if (groep.size() == 0) return null; // triviaal

        // alternatief: niet de lijst kopieren maar wel met 2 pointers
        List<Persoon> mogelijkeBeroemdheden = new ArrayList<>(groep);
        int grootte = groep.size() - 1;

        // Er kan maar 1 beroemheid zijn, dus je kan telkens één persoon verwijderen die sowieso niet de beroemheid is
        while (mogelijkeBeroemdheden.size() > 1) {
            if (mogelijkeBeroemdheden.get(0).kent(mogelijkeBeroemdheden.get(1))) {
                // persoon0 is geen beroemdheid
                mogelijkeBeroemdheden.remove(0);
            } else {
                // persoon1 is geen beroemdbeid
                mogelijkeBeroemdheden.remove(1);
            }
        }

        // Deze persoon blijft mogelijks over, check volgens de defenitie of deze daadwerkelijk een beroemheid is
        Persoon mogelijkeBekende = mogelijkeBeroemdheden.get(0);
        int aantal = 0;
        for (Persoon andere : groep) {
            if (!mogelijkeBekende.equals(andere)) { // kan zichzelf niet kennen
                if (mogelijkeBekende.kent(andere)) {
                    return null; // geen beroemdheid, dus er zijn er geen
                }
                if (andere.kent(mogelijkeBekende)) {
                    aantal++;
                }
            }
        }
        if (aantal == grootte) {
            return mogelijkeBekende; // iedereen kent hem
        }
        return null; // toch niet iedereen kent hem
    }


    // 2 for-loops is te inefficient
    /*
    @Override
    public Practicum1.BeroemdheidZoeken.Persoon zoekBeroemdheid(List<Practicum1.BeroemdheidZoeken.Persoon> groep) {
        int grootte = groep.size() - 1;

        for (Practicum1.BeroemdheidZoeken.Persoon persoon1 : groep) {
            int aantalDiePersoon1Kent = 0;

            for (Practicum1.BeroemdheidZoeken.Persoon persoon2 : groep) {
                if (!persoon1.equals(persoon2)) {
                    if (persoon1.kent(persoon2)) {
                        break;
                    }
                    if (persoon2.kent(persoon1)) {
                        aantalDiePersoon1Kent++;
                    }
                }
            }

            if (aantalDiePersoon1Kent == grootte) {
                return persoon1;
            }
        }
        return null;
    }
    */
}
