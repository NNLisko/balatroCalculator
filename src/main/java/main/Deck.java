package main;

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {

        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }
}
