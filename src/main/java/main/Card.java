package main;

public class Card {
    Suits suit;
    Ranks rank;
    Effects eff;
    Modifiers mod;
    Seals seal;

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
        this.eff = Effects.NONE;
        this.mod = Modifiers.NONE;
        this.seal = Seals.NONE;
    }
}
