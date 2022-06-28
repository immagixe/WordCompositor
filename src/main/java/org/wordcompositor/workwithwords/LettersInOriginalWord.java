package org.wordcompositor.workwithwords;

import java.util.ArrayList;
import java.util.List;

public class LettersInOriginalWord {

    public static boolean check(String chosenWord, String wordInput) {

        List<Character> chosenWordArray = convertStringToArrayListOfChars(chosenWord);
        List<Character> wordInputArray = convertStringToArrayListOfChars(wordInput);
        int countLetters = 0;
        for (Character characterInput : wordInputArray) {
            for (Character characterChosenWord : chosenWordArray) {
                if (characterInput.equals(characterChosenWord)) {
                    chosenWordArray.remove(characterChosenWord);
                    countLetters++;
                    break;
                }
            }
        }
        return countLetters == wordInput.length();
    }

    private static List<Character> convertStringToArrayListOfChars(String word) {
        List<Character> charArray = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            charArray.add(word.charAt(i));
        }
        return charArray;
    }
}
