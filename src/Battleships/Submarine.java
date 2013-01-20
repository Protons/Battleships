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
		super(SIZE, "Submarine", ".");
	}
}