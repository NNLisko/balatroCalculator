package main;

import java.util.ArrayList;

import main.cardEffects.Effects;
import main.cardEffects.HandTypes;
import main.cardEffects.Modifiers;
import main.cardEffects.Ranks;
import main.cardEffects.Seals;
import main.cardEffects.Suits;

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
     * 
     * when a hand is detected, it calls an appropriate
     * scoring method
     * 
     * this method is bit messy :/
     */

    public void handDirector(ArrayList<Card> hand, ArrayList<Card> orderedHand, HandTypes handType) {

        System.out.println(handType);
        switch (handType) {
            case HandTypes.ROYALFLUSH:
                this.chips = 100;
                this.mult = 8;
                processAllFive(hand);
                break;
            case HandTypes.STRAIGHTFLUSH:
                this.chips = 100;
                this.mult = 8;
                processAllFive(hand);
                break;
            case HandTypes.STRAIGHT:
                this.chips = 30;
                this.mult = 4;
                processAllFive(hand);
                break;
            case HandTypes.FLUSH:
                this.chips = 35;
                this.mult = 4;
                processAllFive(hand);
                break;
            case HandTypes.HIGHCARD:
                this.chips = 5;
                this.mult = 1;
                processHighCard(orderedHand);
            default:
                break;
        }
    }

    public void detectHands(ArrayList<Card> hand, ArrayList<Card> orderedHand) {
        boolean isAStraight = true;
        boolean isAFlush = true;
        boolean isAStraightFlush;
        boolean isARoyalFlush;

        /* CHECKS IF THE HAND IS A STRAIGHT */
        for (int i = 1; i < 5; i++) {
            if (orderedHand.get(i).getRank().ordinal() != orderedHand.get(i - 1).getRank().ordinal() + 1) {
                isAStraight = false;
                break;
            }
        }

        /* CHECKS IF THE HAND IS A FLUSH */
        for (int j = 0; j < 5; j++) {
            Suits fSuit = orderedHand.get(0).getSuit();
            if (orderedHand.get(j).eff != Effects.WILD && orderedHand.get(j).getSuit() != fSuit) {
                isAFlush = false;
                break;
            }
        }

        isAStraightFlush = isAFlush && isAStraight;
        isARoyalFlush = isAStraight && (orderedHand.get(1).getRank() == Ranks.TEN);

        HandTypes handType;

        if (isARoyalFlush) {
            handType = HandTypes.ROYALFLUSH;
        } else if (isAStraightFlush) {
            handType = HandTypes.STRAIGHTFLUSH;
        } else if (isAStraight) {
            handType = HandTypes.STRAIGHT;
        } else {
            handType = HandTypes.HIGHCARD;
        }

        handDirector(hand, orderedHand, handType);
    }

    /*
     * Below is the scoring methods, eg when all cards in the hand
     * need to be scored, vs to for example high card when only the
     * top card needs to be scored
     */

    public void processAllFive(ArrayList<Card> hand) {
        for (Card card : hand) {
            if (card.seal == Seals.RED) {
                scoreCard(card);
            }
            scoreCard(card);
        }
    }

    public void processHighCard(ArrayList<Card> hand) {
        scoreCard(hand.get(4));
    }

    public void printScore() {
        System.out.println("\n" + this.chips + " x " + this.mult);
        System.out.println(this.calculateScore() + "\n");
    }
}
