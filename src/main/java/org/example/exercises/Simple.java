package org.example.exercises;

import java.util.*;

public class Simple {

    public static Boolean isPalindrome(String word) {

        StringBuilder sb = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            sb.append(word.charAt(i));
        }

        word = word.replaceAll(" ", "");
        String word2 = sb.toString().replaceAll(" ", "");

        return word.equalsIgnoreCase(word2);
    }

    public static String letterThatOccursMostOften(String word) {
        word = word.replaceAll(" ", "").toLowerCase();
        Map<Character, Integer> myMap = new LinkedHashMap<>();

        for (int i = 0; i < word.length(); i++) {
            myMap.putIfAbsent(word.charAt(i), 0);
            if (myMap.containsKey(word.charAt(i))) {
                myMap.put(word.charAt(i), myMap.get(word.charAt(i)) + 1);
            }
        }

        List<Character> listOfCharacters = new ArrayList<>();
        List<Integer> listOfValues = new ArrayList<>();

        myMap.forEach((key, value) -> {
            listOfCharacters.add(key);
            listOfValues.add(value);
        });

        return listOfCharacters.get(listOfValues.indexOf(Collections.max(listOfValues))) + "=" +
                listOfValues.get(listOfValues.indexOf(Collections.max(listOfValues)));
    }

    public static String reverseWordsInText(String word) {

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < word.split(" ").length; j++) {

            for (int i = word.split(" ")[j].length() - 1; i >= 0; i--) {

                sb.append(word.split(" ")[j].charAt(i));
            }

            if (j != word.split(" ").length - 1) {
                sb.append(" ");
            }

        }

        return sb.toString();
    }

    // Mając do dyspozycji tablicę liczb i liczbę k, określ, czy w tablicy są trzy
    // pozycje, które
    // sumują się do podanej liczby k. Na przykład, biorąc pod uwagę [20, 303, 3, 4,
    // 25] i k = 49, zwróć wartość “true”, ponieważ 20 + 4 + 25 = 49.
    public static Boolean threeItemsInArrayAddUpToGivenNumber(List<Integer> numbers, int number) {

        boolean result = false;
        numbers = numbers.stream().sorted().toList();

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                for (int k = j + 1; k < numbers.size(); k++) {
                    if (numbers.get(i) + numbers.get(j) + numbers.get(k) == number) {
                        System.out.println(numbers.get(i) + "+" + numbers.get(j) + "+" + numbers.get(k));
                        result = true;
                    }
                }
            }
        }

        return result;
    }

    public static void printHowManyTimesEachLetterOccurInText(String text) {
        text = text.replaceAll(" ", "").toLowerCase();
        Map<Character, Integer> myMap = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            myMap.putIfAbsent(text.charAt(i), 0);
            if (myMap.containsKey(text.charAt(i))) {
                myMap.put(text.charAt(i), myMap.get(text.charAt(i)) + 1);
            }
        }
        System.out.println(myMap);
    }
}
