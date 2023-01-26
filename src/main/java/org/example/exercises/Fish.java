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

    public static Integer howManyTimesFishComeOut3(String moves) {
        int counter = 0;
        int up = 0;
        int down = 0;
        var firstChar = moves.charAt(0);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        List<String> tempList = new ArrayList();
        List<String> tempList2 = new ArrayList();

        // koncepcja
        // 1 lista z uu
        // 2 lista z ddd
        // potem ich wartosci porownac i jestli jest > 0 to znaczy wynurzenie

        // u
        for (int i = 0; i < moves.toCharArray().length; i++) {
            if (moves.charAt(i) == 'u') {
                sb.append(moves.charAt(i));
            } else {
                if (sb.length() > 0) {
                    tempList.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if (moves.charAt(moves.toCharArray().length - 1) == 'u') {
            tempList.add(sb.toString());
            sb.setLength(0);
        }

        // d
        for (int i = 0; i < moves.toCharArray().length; i++) {
            if (moves.charAt(i) == 'd') {
                sb2.append(moves.charAt(i));
            } else {
                if (sb2.length() > 0) {
                    tempList2.add(sb2.toString());
                    sb2.setLength(0);
                }
            }
        }
        if (moves.charAt(moves.toCharArray().length - 1) == 'd') {
            tempList2.add(sb2.toString());
            sb2.setLength(0);
        }

        // tutaj skonczylem

        System.out.println(tempList);
        System.out.println(tempList2);
        System.out.println(moves);
        return null;
    }

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
