package main;

import java.util.ArrayList;

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

    public void returnHand(ArrayList<Card> hand) {
        for (Card card : hand) {
            this.returnCard(card);
        }
    }
}
