package org.wordcompositor.workwithwords;

import java.util.List;
import java.util.Random;

public class RandomWord {

    String randomWord;

    public String pick(List<String> words) {
        boolean longWord = false;
        while (!longWord) {
            int random = new Random().nextInt(words.size());
            randomWord = words.get(random);
            if (randomWord.length() > 12) {
                longWord = true;
            }
        }
        return randomWord;
    }
}