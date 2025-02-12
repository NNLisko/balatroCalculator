package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Balatro calculator */

public class App {

    static Game game;

    public static void main(String[] args) {
        game = new Game;
    }

    private void goThroughJokers() {

    }

    private void goThroughHeldHand() {

    }

    private static void returnHand(ArrayList<Card> hand) {
        for (Card card : hand) {
            game.deck.returnCard(card);
        }
    }

}