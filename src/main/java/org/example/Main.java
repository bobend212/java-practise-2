package org.example;

import org.example.exercises.*;

import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) {

                // # SIMPLE
                // -- IsPalindrome
                // String palindromeSentence = "Anne I vote more cars race Rome to Vienna";
                // String nonPalindromeSentence = "Hello World!";
                // String palindromeWord = "Kayak";
                // String nonPalindromeWord = "Java";
                // System.out.println(Simple.isPalindrome(palindromeSentence));
                // System.out.println(Simple.isPalindrome(nonPalindromeSentence));
                // System.out.println(Simple.isPalindrome(palindromeWord));
                // System.out.println(Simple.isPalindrome(nonPalindromeWord));

                // -- letterThatOccursMostOften
                // String shouldReturnB = "baobab";
                // String shouldReturnE = "long sentence with spaces";
                // String shouldReturnL = "Hello World!";
                // System.out.println(Simple.letterThatOccursMostOften(shouldReturnB));
                // System.out.println(Simple.letterThatOccursMostOften(shouldReturnE));
                // System.out.println(Simple.letterThatOccursMostOften(shouldReturnL));

                // -- reverseWordsInText
                // String sample1 = "Ala ma kota"; // -> alA am atok
                // String sample2 = "Kot ma ale"; // -> toK am ela
                // String sample3 = "Java is powerful"; // -> avaJ si lufrewop
                // System.out.println(Simple.reverseWordsInText(sample1));
                // System.out.println(Simple.reverseWordsInText(sample2));
                // System.out.println(Simple.reverseWordsInText(sample3));

                // -- threeItemsInArrayAddUpToGivenNumber
                // List<Integer> list1 = Arrays.asList(20, 303, 3, 4, 25); // 49, true 20+4+25
                // List<Integer> list2 = Arrays.asList(7, 3, 1); // 10, false
                // List<Integer> list3 = Arrays.asList(10, 30, 55, 25, 100); // 140, true
                // 10+30+100
                // System.out.println(Simple.threeItemsInArrayAddUpToGivenNumber(list1, 49));
                // System.out.println(Simple.threeItemsInArrayAddUpToGivenNumber(list2, 10));
                // System.out.println(Simple.threeItemsInArrayAddUpToGivenNumber(list3, 140));

                // -- printHowManyTimesEachLetterOccurInText
                // String sample1 = "Ala ma kota";
                // String sample2 = "Kot ma ale";
                // String sample3 = "Java is powerful";
                // Simple.printHowManyTimesEachLetterOccurInText(sample1);
                // Simple.printHowManyTimesEachLetterOccurInText(sample2);
                // Simple.printHowManyTimesEachLetterOccurInText(sample3);

                // # Streams
                // Streams streams = new Streams();
                // System.out.println(streams.countAgeOfAllStudents());
                // System.out.println(streams.getTheOldestStudent());
                // System.out.println(streams.getStudentsWithNameStartingWith('J'));
                // System.out.println(streams.getStudentsWithEvenAge());

                // # Fish
                // System.out.print("should be: 3, is = ");
                // Fish.howManyTimesFishComeOut2("uuddduudduu");
                // System.out.print("should be: 2, is = ");
                // Fish.howManyTimesFishComeOut("ddduuuudddduuuu");
                // System.out.print("should be: 5, is = ");
                // Fish.howManyTimesFishComeOut("uudddduuudduuuudddduuddduuu");
                // System.out.print("should be: 1, is = ");
                // Fish.howManyTimesFishComeOut("ddddduuuuudduuu");

        }
}