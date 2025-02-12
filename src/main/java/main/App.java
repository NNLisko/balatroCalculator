package main;

import java.util.ArrayList;

/* Balatro calculator */

public class App {
    static Score score = new Score();
    static ArrayList<Card> playedHand = new ArrayList<Card>();
    static ArrayList<Joker> jokers = new ArrayList<Joker>();
    static ArrayList<Card> HeldHand = new ArrayList<Card>();
    static Deck deck = new Deck();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * 52);
            deck.getCard(random);
        }

        goThroughPlayedHand();
        returnHand();
    }

    public static void goThroughPlayedHand() {
        for (Card card : playedHand) {
            if (card.seal == Seals.RED) {
                scoreCard(card);
            }
            scoreCard(card);
        }
    }

    private void goThroughJokers() {

    }

    private void goThroughHeldHand() {

    }

    private static void returnHand() {
        for (Card card : playedHand) {
            deck.returnCard(card);
        }
    }

    private static void scoreCard(Card card) {
        score.chips += card.rank.getValue();
        if (card.eff == Effects.MULT) {
            score.mult += 4;
        }
        if (card.mod == Modifiers.FOIL) {
            score.chips += 50;
        }
        if (card.mod == Modifiers.POLYCHROME) {
            score.mult *= 1.5;
        }
        if (card.mod == Modifiers.HOLOGRAPHIC) {
            score.mult += 10;
        }
    }
}