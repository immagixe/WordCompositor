package org.wordcompositor.workwithwords;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetWordsListFromFile implements GetWordsList {

    private final File words;

    public GetWordsListFromFile() {
        this.words = new File("src/main/resources/WordsList.txt");
    }

    @Override
    public final List<String> generateList() throws FileNotFoundException {
        List<String> wordList = new ArrayList<>();
        Scanner scanner = new Scanner(words);
        while (scanner.hasNextLine()) {
            wordList.add(scanner.nextLine());
        }
        return wordList;
    }
}