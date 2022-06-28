package org.wordcompositor;

import org.wordcompositor.output.DataPrinter;
import org.wordcompositor.workwithwords.GetWordsList;
import org.wordcompositor.workwithwords.LettersInOriginalWord;
import org.wordcompositor.workwithwords.RandomWord;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Game {

    private final GetWordsList wordsList;

    private final RandomWord randomWord;

    private final DataPrinter dataPrinter;

    private final Player[] players;

    private final Map<String, Integer> usedWords;

    private final WinnerVerifier winnerVerifier;

    public Game(final GetWordsList wordsList,
                final RandomWord randomWord,
                final DataPrinter dataPrinter,
                final Player[] players,
                final Map<String, Integer> usedWords,
                final WinnerVerifier winnerVerifier) {
        this.wordsList = wordsList;
        this.randomWord = randomWord;
        this.dataPrinter = dataPrinter;
        this.players = players;
        this.usedWords = usedWords;
        this.winnerVerifier = winnerVerifier;
    }

    public void play() throws FileNotFoundException {
        List<String> words = wordsList.generateList();
        String chosenWord = randomWord.pick(words);
        usedWords.put(chosenWord, 0);
        dataPrinter.printGameInstructions(players);
        dataPrinter.printChosenWord(chosenWord);

        while (gameContinued(players)) {
            playersWriteWords(words, chosenWord);
            dataPrinter.printWordsResults(chosenWord, players, usedWords);
        }

        List<Player> playerWinners = winnerVerifier.whoIsWin(players);
        if (playerWinners.size() == 1) {
            dataPrinter.printPointsResult(players, playerWinners);
            dataPrinter.printEndGameOneWinner(players, playerWinners);
        } else {
            dataPrinter.printPointsResult(players, playerWinners);
            dataPrinter.printEndGameFewWinners(winnerVerifier);
        }
    }

    private boolean gameContinued(Player[] players) {
        for (Player player : players) {
            if (player.isInGame()) {
                return true;
            }
        }
        return false;
    }

    private void playersWriteWords(List<String> words, String chosenWord) {
        for (Player player : players) {
            while (player.isInGame()) {
                dataPrinter.printInfoMessage("Ход игрока №" + player.id + ". Введите слово, составленное из букв заданного слова:");
                String wordInput = player.writeWord();
                if (wordInput.equals("сдаюсь")) {
                    player.setInGame(false);
                    dataPrinter.printInfoMessage("Игрок №" + player.id + " закончил игру.");
                    break;
                } else {
                    if (!usedWords.containsKey(wordInput)) {
                        if (words.contains(wordInput)) {
                            if (LettersInOriginalWord.check(chosenWord, wordInput)) {
                                usedWords.put(wordInput, player.id);
                                player.setNumberOfPoints(player.getNumberOfPoints() + wordInput.length());
                                player.setNumberOfWords(player.getNumberOfWords() + 1);
                                break;
                            } else {
                                dataPrinter.printErrorMessage("В этом слове есть буквы, отсутствующие в заданном слове! Попробуйте составить другое слово!");
                            }
                        } else {
                            dataPrinter.printErrorMessage("Такого слова не существует или оно отсутствует в словаре игры! Попробуйте составить другое слово!");
                        }
                    } else {
                        dataPrinter.printErrorMessage("Это слово уже было использовано! Попробуйте составить другое слово!");
                    }
                }
            }
        }
    }
}


