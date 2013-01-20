/*
 * Class Hit Type
 * Changes the hit type on the board to either "X" or "$" or "H".
 * Length of 1
 *
 */
package Battleships;

/**
 * @author DFG
 */
public class HitType extends Ship {

    private static int size;

	protected HitType(String string) {
		//sets hit type
		super(size, string, string);
	}

	public String toString(String hitType) {
		//returns hit type;
		return hitType;
	}
}