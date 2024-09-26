package Practicum1.DubbelWoord;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class MyDoubler implements Doubler {

    @Override
    public boolean isDouble(String str) {
        Dictionary<Character, Integer> dict = new Hashtable<>();

        for (char c : str.toLowerCase().toCharArray()) {
            dict.put(c, 0);
        }
        for (char c : str.toLowerCase().toCharArray()) {
            dict.put(c, dict.get(c) + 1);
        }

        Enumeration<Character> keys = dict.keys();
        while (keys.hasMoreElements()) {
            Character key = keys.nextElement();
            if (dict.get(key) != 2) {
                return false;
            }
        }

        return true;
    }

    // alternatief: alfabetisch sorteren kijken of ze in paren voorkomen

}
