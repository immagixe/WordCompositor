package org.wordcompositor.output;

import org.wordcompositor.Player;
import org.wordcompositor.WinnerVerifier;

import java.util.List;
import java.util.Map;

public class ConsoleDataPrinter implements DataPrinter {


    @Override
    public void printGameInstructions(Player[] players) {

        System.out.println("Добро пожаловать в игру Наборщик!");
        System.out.println();
        System.out.println("Вам необходимо из букв заданного слова составить как можно больше других слов.");
        System.out.println("Количество игроков: " + players.length + ". Выигрывает игрок, набравший наибольшее число букв в названных словах.");
        System.out.println("Если не можете придумать слово, напишите: \"сдаюсь\".");
    }

    @Override
    public void printChosenWord(String chosenWord) {

        System.out.println();
        drawBorders(chosenWord);
        System.out.println(chosenWord.toUpperCase());
        drawBorders(chosenWord);
        System.out.println();
    }

    @Override
    public void printWordsResults(String chosenWord, Player[] players, Map<String, Integer> usedWords) {

        printChosenWord(chosenWord);
        for (Player player : players) {
            System.out.print(">>> Слова игрока №" + player.id + ": ");
            int count = 0;
            for (Map.Entry<String, Integer> entry : usedWords.entrySet()) {
                if (entry.getValue().equals(player.id)) {
                    count++;
                    if (count != player.getNumberOfWords()) {
                        System.out.print(entry.getKey() + ", ");
                    } else {
                        System.out.print(entry.getKey());
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void printInfoMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printErrorMessage(String message) {
        System.err.println(message);
    }

    @Override
    public void printPointsResult(Player[] players, List<Player> playerWinners) {
        for (Player player : players) {
            System.out.println("Игрок №" + player.id + " набрал " + player.getNumberOfPoints() + " очков.");
        }
        System.out.println();
    }

    @Override
    public void printEndGameOneWinner(Player[] players, List<Player> playerWinners) {
        System.out.println("Победил игрок №"+playerWinners.get(0).id+".");
    }

    @Override
    public void printEndGameFewWinners(WinnerVerifier winnerVerifier) {
        System.out.println("Ничью между собой разделили игроки №"+winnerVerifier.toString()+".");
    }

    private void drawBorders(String chosenWord) {
        for (int i = 0; i < chosenWord.length(); i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
