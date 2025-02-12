package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* scoring class, handles scoring of each card,
 * detects hand types: flush, straight etc.
 * updates the chips and mult attributes
 */
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
        detectHands(hand);

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

    /*
     * This method detects which type of a hand it is
     * flush, straight etc. currently this only checks for
     * natural poker hands so balatro's flush five for
     * example is not checked
     */

    private void detectHands(ArrayList<Card> hand) {
        ArrayList<Card> clone = new ArrayList<Card>(hand);
        boolean isAStraight = true;
        boolean isAFlush = true;

        /* AI MADE COMPARATOR */
        Comparator<Card> comparator = Comparator
                .comparing(Card::getRankValue)
                .thenComparing(Card::getSuit);

        Collections.sort(clone, comparator);

        /* CHECKS IF THE HAND IS A STRAIGHT */
        for (int i = 1; i < 5; i++) {
            if (clone.get(i).getRank().ordinal() != clone.get(i - 1).getRank().ordinal() + 1) {
                isAStraight = false;
                break;
            }
        }
        /* CHECKS IF THE HAND IS A FLUSH */
        for (int j = 0; j < 5; j++) {
            Suits fSuit = clone.get(0).getSuit();
            if (clone.get(j).eff != Effects.WILD && clone.get(j).getSuit() != fSuit) {
                isAFlush = false;
                break;
            }
        }
        boolean isAStraightFlush = isAFlush && isAStraight;
        boolean isARoyalFlush = isAStraightFlush && clone.get(0).getRank() == Ranks.TEN;

        if (isARoyalFlush) {
            this.chips = 100;
            this.mult = 8;
        } else if (isAStraightFlush) {
            this.chips = 100;
            this.mult = 8;
        } else if (isAFlush) {
            this.chips = 35;
            this.mult = 4;
        } else if (isAStraight) {
            this.chips = 30;
            this.mult = 4;
        }

    }
}
