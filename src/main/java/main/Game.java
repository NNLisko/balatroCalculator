package main;

import java.util.ArrayList;

public class Game {
    private Score score;
    public ArrayList<Card> playedHand;
    private Deck deck;

    public Game() {
        this.score = new Score();
        this.playedHand = new ArrayList<>();
        this.deck = new Deck();
    }

    public void play() {
        deck.drawHand();
        score.processPlayedHand(playedHand);
        deck.returnHand(playedHand);
    }
}
