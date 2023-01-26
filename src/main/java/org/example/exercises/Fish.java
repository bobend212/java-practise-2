package org.example.exercises;

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

    public static Integer howManyTimesFishComeOut2(String moves) {
        int up = 0;
        int down = 0;
        int counter = 0;
        int calc = 0;

        for (int i = 0; i < moves.toCharArray().length - 1; i++) {
            if (moves.charAt(i) == 'u') {
                up++;
                if (moves.charAt(i + 1) == 'd') {
                    counter++;
                    for (int j = i + 1; j < moves.toCharArray().length; j++) {
                        down++;
                        if (moves.charAt(j + 1) == 'u') {
                            calc = up - down;
                            if (calc > 0) {
                                counter++;
                            }
                            break;
                        }
                    }
                }
            } else {
                up = 0;
                down = 0;
            }

        }
        if (counter > 0)
            counter++;

        System.out.println(counter);

        return null;
    }

    public static Integer howManyTimesFishComeOut(String moves) {
        int up = 0;
        int down = 0;
        int counter = 0;
        int calc = 0;

        for (int i = 0; i < moves.toCharArray().length - 1; i++) {
            if (moves.charAt(i) == 'u') {
                up++;
                if (moves.charAt(i + 1) == 'd') {
                    if (up - down != 0) {
                        calc += up;
                        if (calc > 0) {
                            counter++;
                            down = 0;
                        }
                        down = 0;
                    }

                    for (int j = i + 1; j < moves.toCharArray().length; j++) {
                        if (moves.charAt(j) == 'd') {
                            down++;
                        } else {
                            break;
                        }
                    }
                    calc -= down;
                    if (calc >= 0) {
                        counter++;
                    }
                    up = 0;
                    down = 0;
                }
            } else {
                down++;
            }

        }

        if (moves.charAt(0) == 'u') {
            counter++;
        }

        System.out.println(counter);

        return null;
    }

}
