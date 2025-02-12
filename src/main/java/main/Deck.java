package main.balatroCalc;

import java.util.ArrayList;

import main.App;
import main.assets.Ranks;
import main.assets.Suits;

/* deck class that handles drawing the hand and that
 * if a card is drawn its removed from a deck and if
 * its returned, it is put back
 * 
 * future: account for dynamic balatro deck
 */
public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    private static int deckSize = 52;

    public Deck() {
        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public Card getCard(int index) {
        Card card = deck.remove(index);
        System.out.println("Retrieved a " + card.rank + " OF " + card.suit);
        return card;
    }

    public void returnCard(Card card) {
        deck.add(card);
    }

    public void drawHand() {
        /* generates 5 playing cards from deck */
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * deckSize);
            deckSize--;
            App.game.playedHand.add(this.getCard(random));
        }
    }

    public void testHand() {
        Card card1 = new Card(Suits.CLUBS, Ranks.TEN);
        Card card2 = new Card(Suits.CLUBS, Ranks.THREE);
        Card card3 = new Card(Suits.CLUBS, Ranks.EIGHT);
        Card card4 = new Card(Suits.CLUBS, Ranks.SEVEN);
        Card card5 = new Card(Suits.CLUBS, Ranks.KING);

        App.game.playedHand.add(card1);
        App.game.playedHand.add(card2);
        App.game.playedHand.add(card3);
        App.game.playedHand.add(card4);
        App.game.playedHand.add(card5);
    }

    public void returnHand(ArrayList<Card> hand) {
        for (Card card : hand) {
            this.returnCard(card);
        }
    }
}
