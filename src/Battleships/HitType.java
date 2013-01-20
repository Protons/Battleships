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
		super(size, string, string);
		// TODO Auto-generated constructor stub
	}

	public String toString(String hitType) {
		//String hitType = null;
		return hitType;
	}
}