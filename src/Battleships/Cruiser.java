/*
 * Class Cruiser
 * Two Cruisers in a Game.
 * Length of 3
 *
 */
package Battleships;

/**
 * @author KLM
 */
public class Cruiser extends Ship {

    private final static int SIZE = 3;

    /**
     * sets the length & clears the hit array
     */
    public Cruiser() {
        super(SIZE, "Cruiser", "C");
    }
}