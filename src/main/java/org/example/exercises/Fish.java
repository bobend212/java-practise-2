package org.example.exercises;

import java.util.ArrayList;
import java.util.List;

public class Fish {

    /*
     * u/\d
     * /u\d u/\d u/ \d u/\d
     * >('>--d\----/u--\d------u/--\d------------------ u/--\d--------
     * d\ /u \d u/ \d u/ \d u/ \d
     * d\/u \d u/ \d u/ \d u/
     *
     * 1. Rybka zaczyna z poziomu 0
     * 2. Zadanie polega na zliczeniu ile razy wyplynela rybka
     * 3. 'd' oznacza ze plynie w dol a 'u' ze plynie w gore
     *
     * np: ddduuuudddduuuu to rybka wyplynela 2 razy
     * uuddduudduu tu wyplynela 3 razy
     */

    public static Integer howManyTimesFishComeOut(String moves) {
        int level = 0;
        int counter = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (level == 0 && moves.charAt(i) == 'u') {
                counter++;
            }

            if (moves.charAt(i) == 'u') {
                level++;
            }

            if (moves.charAt(i) == 'd') {
                level--;
            }
        }

        return counter;
    }

}
