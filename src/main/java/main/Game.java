package main.balatroCalc;

import java.util.ArrayList;

/* game class handles the game logic and scoring flow */
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
        /* this.deck.drawHand(); */
        this.deck.testHand();
        this.score.processPlayedHand(playedHand);
        this.deck.returnHand(playedHand);
        this.score.printScore();
    }
}
