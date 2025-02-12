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
        this.deck.drawHand();
        this.score.processPlayedHand(playedHand);
        this.deck.returnHand(playedHand);
    }
}
