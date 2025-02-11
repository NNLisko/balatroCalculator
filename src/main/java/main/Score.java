package main;

public class Score {
    int chips;
    int mult;
    int score;

    private Score() {
        this.chips = 0;
        this.mult = 0;
        this.score = 0;
    }

    public static Score makeScore() {
        if (App.score == null) {
            return new Score();
        }
        return App.score;
    }

    public int calculateScore() {
        return this.chips * this.mult;
    }
}
