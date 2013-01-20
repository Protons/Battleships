/*
 * Class Position
 * Gets the position of X and Y from user input. I forgot you had yours and made my own.
 *
 */
package Battleships;

public class Position {

	private int row, column;

	public Position(int x, int y) {
		row = x;
		column = y;
	}

	public int getX() {
		// returns the row of position
		return row;
	}

	public int getY() {
		// returns the column of position
		return column;
	}

}
