package main;

import java.util.ArrayList;

/* game class handles the game logic and scoring flow */
public class Game {
    private Score score;
    public ArrayList<Card> playedHand;
    public ArrayList<Card> orderedHand;
    private Deck deck;

    public Game() {
        this.score = new Score();
        this.playedHand = new ArrayList<>();
        this.deck = new Deck();
    }

    public void play() {
        this.deck.drawHand();
        this.score.detectHands(playedHand, orderedHand);
        this.deck.returnHand(playedHand);
        this.score.printScore();
    }
}
