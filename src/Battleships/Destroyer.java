/*
 * Class Destroyer
 * Three Destroyer Ships in the Game.
 * Length of 2
 *
 */
package Battleships;

/**
 * @author KLM
 */
public class Destroyer extends Ship {

	private final static int SIZE = 2;

	/**
	 * sets the length & clears the hit array
	 */
	public Destroyer() {
		super(SIZE, "Destroyer", "D");
	}
}