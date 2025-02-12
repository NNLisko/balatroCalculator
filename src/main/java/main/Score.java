package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Score {
    int chips;
    int mult;
    int score;

    public Score() {
        this.chips = 0;
        this.mult = 0;
        this.score = 0;
    }

    public int calculateScore() {
        return this.chips * this.mult;
    }

    public void processPlayedHand(ArrayList<Card> hand) {
        for (Card card : hand) {
            if (card.seal == Seals.RED) {
                scoreCard(card);
            }
            scoreCard(card);
        }
    }

    private void scoreCard(Card card) {
        this.chips += card.rank.getValue();
        System.out.println("CHI: +" + card.rank.getValue());
        if (card.eff == Effects.MULT) {
            this.mult += 4;
        }
        if (card.mod == Modifiers.FOIL) {
            this.chips += 50;
        }
        if (card.mod == Modifiers.POLYCHROME) {
            this.mult *= 1.5;
        }
        if (card.mod == Modifiers.HOLOGRAPHIC) {
            this.mult += 10;
        }
    }

    private void processJokers() {

    }

    private void processHeldHand() {

    }

    private static void detectHands(ArrayList<Card> hand) {
        ArrayList<Card> clone = new ArrayList<Card>(hand);

        /* AI MADE COMPARATOR */
        Comparator<Card> comparator = Comparator
                .comparing(Card::getRank)
                .thenComparing(Card::getSuit);

        Collections.sort(clone, comparator);

        for (Card card : clone) {
            System.out.println("Retrieved a " + card.rank + " OF " + card.suit);
        }
    }
}
