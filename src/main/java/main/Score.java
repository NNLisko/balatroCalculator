package main;

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
}
