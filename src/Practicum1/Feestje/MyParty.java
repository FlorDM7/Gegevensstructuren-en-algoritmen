package Practicum1.Feestje;

import java.util.Collections;
import java.util.List;

public class MyParty implements Party {

    @Override
    public boolean check(List<Interval> helpers, int start, int stop) {
        if (helpers.isEmpty()) return false;

        // sort list using compareTo method from Interval class
        Collections.sort(helpers);

        for (int i = 0; i < helpers.size(); i++) {
            // loop over start numbers, if it's further than current start, false
            if (helpers.get(i).getStart() <= start) {
                // set the furthest stop number, if needed
                if (start < helpers.get(i).getStop()) {
                    start = helpers.get(i).getStop();
                }
                // if current start is bigger than stop, all time is filled, true
                if (start > stop) {
                    return true;
                }
            } else {
                // false if the current start is smaller than the next one
                return false;
            }
        }

        if (start < stop) {
            return false;
        }
        return true;
    }
}
