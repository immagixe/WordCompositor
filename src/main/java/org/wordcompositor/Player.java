package org.wordcompositor;

import java.util.*;

public class Player {

    public final int id;

    private static int countId;

    private int numberOfPoints;

    private int numberOfWords;

    private boolean inGame;

    public Player() {
        id = ++countId;
        inGame = true;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public void setNumberOfWords(int numberOfWords) {
        this.numberOfWords = numberOfWords;
    }

    public String writeWord() {
        return new Scanner(System.in).nextLine().toLowerCase();
    }
}
