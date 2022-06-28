package org.wordcompositor.output;

import org.wordcompositor.Player;
import org.wordcompositor.WinnerVerifier;

import java.util.List;
import java.util.Map;

public interface DataPrinter {

    void printGameInstructions (Player[] players);

    void printChosenWord(String chosenWord);

    void printWordsResults(String chosenWord, Player [] players, Map<String, Integer> usedWords);

    void printInfoMessage (String message);

    void printErrorMessage (String message);

    void printPointsResult(Player[] players, List<Player> playerWinners);

    void printEndGameOneWinner(Player[] players, List<Player> playerWinners);

    void printEndGameFewWinners(WinnerVerifier winnerVerifier);
}
