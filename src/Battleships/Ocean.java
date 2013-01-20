/*
 * Class Ocean contains array of Ships, representing the "ocean"
 * Ocean keeps track of shots fired, hit count and number of ships sunk.
 * Ocean provides checks for whether a shot hits a ship, sinks it or misses.
 */
package Battleships;

/**
 * @author MARGARET WRIGHT
 * @author KLM
 */

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class Ocean {

	private static final int UPPER; // upper bound of the (square) board

	private final Ship[][] board;
	@Getter
	@Setter
	private int shotsFired;
	@Getter
	@Setter(AccessLevel.PRIVATE)
	private int hitCount;
	@Getter
	@Setter(AccessLevel.PRIVATE)
	private int shipsSunk;

	static { // just to show how to use static initialization blocks
		UPPER = 10;
	}

	/**
	 * Creates an "empty" ocean (fills the board array with EmptySeas). Also
	 * initialises game variables, shotsFired, hitCount & shipsSunk
	 */
	public Ocean() {
		board = new Ship[UPPER][UPPER];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new EmptySea();
			}
		}
		setShotsFired(0);
		setHitCount(0);
		setShipsSunk(0);
	}

	/**
	 * Prints the ocean.
	 */
	@Override
	public String toString() { // this replaces the "print" method of the spec
		final String SPACES = " ";
		// have to use a mutable String based data structure for efficiency
		StringBuilder buffer = new StringBuilder();
		buffer.append(" ");
		for (int i = 0; i < board[0].length; i++) {
			buffer.append(SPACES);
			buffer.append(i);
		}
		buffer.append("\n");

		for (int i = 0; i < board.length; i++) {
			buffer.append(i);
			for (int j = 0; j < board[0].length; j++) {
				buffer.append(SPACES);
				buffer.append(board[i][j]);
			}
			buffer.append("\n");
		}
		return buffer.toString();
	}

	private void setShipsSunk(int i) {
		// If not initialised add one to hit count
		if (i != 0)
			shipsSunk = shipsSunk + 1;
	}

	private void setHitCount(int i) {
		// If not initialised add one to hit count
		if (i != 0)
			hitCount = hitCount + 1;

	}

	private void setShotsFired(int i) {
		// If not initialised add one to hit count
		if (i != 0)
			shotsFired = shotsFired + 1;
	}

	private Object getShipsSunk() {
		// returns ships sunk total

		return (this.shipsSunk);
	}

	/**
	 * @return the size of the row/column
	 */
	public int getDimension() {
		return board.length;
	}

	/**
	 * Places all 10 board randomly on the (initially empty) ocean.
	 */
	public void placeAllShipsRandomly() {
		// TODO - Not time sorry
		// this does not have a "random" fleet - you should have one
		Ship[] fleet = new Ship[UPPER];
		fleet[0] = new BattleShip();
		fleet[1] = new Cruiser();
		fleet[2] = new Cruiser();
		fleet[3] = new Destroyer();
		fleet[4] = new Destroyer();
		fleet[5] = new Destroyer();
		fleet[6] = new Submarine();
		fleet[7] = new Submarine();
		fleet[8] = new Submarine();
		fleet[9] = new Submarine();

		Random m = new Random();
		// x is row position; y is column position
		int x, y;
		// boolean to represent horizontal
		boolean b;
		for (Ship s : fleet) { // for each Ship in fleet
			do {
				// generate random x, y, horizontal
				x = m.nextInt(UPPER); // x/row is random 0-9
				y = m.nextInt(UPPER); // y/col is random 0-9
				b = m.nextInt(2) == 1; // horizontal : 1 is true; 0 is false
			} while (!s.okToPlaceShipAt(x, y, b, this));

			// it is safe to place the ship
			s.placeShipAt(x, y, b, this);
		}
	}

	/**
	 * Checks whether the location contains anything other than empty sea or hit
	 * type.
	 * 
	 * @param row
	 *            the x position on the board
	 * @param column
	 *            the y position on the board
	 * @return true if the given location contains a ship, false if it does not.
	 */
	public boolean isOccupied(int row, int column) {
		return !(board[row][column] instanceof EmptySea || board[row][column] instanceof HitType);
	}

	/**
	 * Checks whether the location contains a ship, still afloat. Marks that
	 * ship as hit and checks whether whole ship is sunk. Updates the number of
	 * shots that have been fired, and number of hits.
	 * 
	 * @param row
	 *            the x position
	 * @param column
	 *            the y position
	 * @return true if location contains a "real" ship, still afloat, false if
	 *         not.
	 */
	public boolean shootAt(int row, int column) {
		// increment the number of shots fired regardless of result
		// use of accessor so that internal representation can change without
		// effecting usage
		setShotsFired(getShotsFired() + 1);

		// check for a ship
		if (isOccupied(row, column)) { // okay - this is a ship
			// get the ship
			board[row][column].shootAt(row, column);
			setHitCount(getHitCount() + 1);
			if (board[row][column].isSunk()) {
				// Add one to ships sunk;
				setShipsSunk(1);
				return true;
			}
		}
		return false;
	}

	private int getHitCount() {
		// return getHitCount for hits count 
		return 1;
	}

	private int getShotsFired() {
		// return getShotsFired for shots fired
		return 1;
	}

	/**
	 * Returns true if all the ships on the board have been sunk, otherwise
	 * false.
	 * 
	 * @return the "fleet" has been sunk
	 */

	public boolean isGameOver() {
		// check whether all board in fleet have been sunk
		if (this.getShipsSunk().equals(UPPER))
			return true;
		// return false when all ships sunk
		return false;
	}

	/**
	 * Gets the board so that the Ocean parameter can look at the contents of
	 * this array; the placeShipAt method can modify it this board (not a good
	 * idea).
	 * 
	 * @return the array of board
	 */
	public Ship[][] getShipArray() {
		return board;
	}

	/**
	 * A string containing the final results for hits, ships sunk and shots
	 * fired
	 */
	public String printFinalScores() {
		StringBuilder strbld = new StringBuilder();
		strbld.append("GAME OVER!! You scored ").append(this.shotsFired)
				.append(".");
		strbld.append("You sank ").append(this.getShipsSunk()).append(" ships");
		strbld.append(" and shot ").append(this.hitCount)
				.append(" shots for 10 ships, bla" + ".");
		return strbld.toString();
	}

	public void updateBoard(int row, int column, Ocean ocean) {

		Ship[][] sea = ocean.getShipArray();
		// if a ship type is hit mark with an H else mark with an X
		if (!(sea[row][column] instanceof HitType)) {
			if (sea[row][column] instanceof Submarine
					|| sea[row][column] instanceof BattleShip
					|| sea[row][column] instanceof Cruiser
					|| sea[row][column] instanceof Destroyer) {
				// if ships is sunk update board with dollar sign

				if (board[row][column].isSunk()) {
					board[row][column].sinkShip(ocean);

				} else {
					sea[row][column] = new HitType("H");
				}
			} else {
				sea[row][column] = new HitType("X");
			}
		}
	}

	public Ocean(Ship[][] board, int shotsFired, int hitCount, int shipsSunk) {
		super();
		this.board = board;
		this.shotsFired = shotsFired;
		this.hitCount = hitCount;
		this.shipsSunk = shipsSunk;
	}
}