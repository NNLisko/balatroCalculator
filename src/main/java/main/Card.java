package main;

import main.cardEffects.Effects;
import main.cardEffects.Modifiers;
import main.cardEffects.Ranks;
import main.cardEffects.Seals;
import main.cardEffects.Suits;

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
