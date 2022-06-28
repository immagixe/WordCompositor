package org.wordcompositor;

import java.util.ArrayList;
import java.util.List;

public class WinnerVerifier {

    private List<Player> playerWinners;

    public List<Player> whoIsWin(Player[] players) {
        int indexWinner = 0;
        List<Integer> listOfPoints = new ArrayList<>();

        for (int i = 0; i < players.length - 1; i++) {
            listOfPoints.add(players[i].getNumberOfPoints());
            if (players[i].getNumberOfPoints() < players[i + 1].getNumberOfPoints()) {
                indexWinner = i + 1;
            }
        }

        playerWinners = new ArrayList<>();
        for (Player player : players) {
            if (player.getNumberOfPoints() == players[indexWinner].getNumberOfPoints()) {
                playerWinners.add(player);
            }
        }
        return playerWinners;
    }

    @Override
    public String toString() {
        StringBuilder indexesOfWinners = new StringBuilder();
        for (int i = 0; i < playerWinners.size() - 1; i++) {
            indexesOfWinners.append(playerWinners.get(i).id).append(", ");
        }
        indexesOfWinners.append(playerWinners.get(playerWinners.size() - 1).id);
        return indexesOfWinners.toString();
    }
}


