/*
 * A Battleship class which extends ship
 * Four Submarines in the game
 * Length 1
 * 
 */
package Battleships;

/**
 * @author KLM
 */
public class Submarine extends Ship {

	private final static int SIZE = 1;

	/**
	 * sets the length & clears the hit array
	 */
	public Submarine() {
		// for the sake of easy testing I have left the short name instead of
		// removing it.
		super(SIZE, "Submarine", "S");
	}
}