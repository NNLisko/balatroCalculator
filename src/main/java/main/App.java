package main;

/* videogame Balatro calculator
 * 
 * Currently calculates the points obtained from
 * a randomly generated hand of a regular 52 card
 * deck, but balatro-style so there is base chips
 * and mult for each hand and card.
 * 
 * Cards have the attributes for seals and editions
 * and others but calculator currently doesn't account
 * for them
 */

public class App {

    public static Game game;

    public static void main(String[] args) {
        game = new Game();
        /* generates a deck, hand and counts the score */
        game.play();
    }
}