package main;

import main.assets.Effects;
import main.assets.Modifiers;
import main.assets.Ranks;
import main.assets.Seals;
import main.assets.Suits;

/* playing card class with balatro modifiers */
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

    public int getRankValue() {
        return this.rank.getValue();
    }

    public Ranks getRank() {
        return this.rank;
    }

    public Suits getSuit() {
        return this.suit;
    }
}
