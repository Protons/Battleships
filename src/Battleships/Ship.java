/*
 * Class Ship describes characteristics common to all the ships.
 *
 */
package Battleships;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author MARGARET WRIGHT
 * @author KLM
 */

public abstract class Ship {
	// TODO add appropriate comments
	@Getter
	private int size;
	private String type;
	private String shortForm;

	// TODO add appropriate comments
	@Getter
	@Setter(AccessLevel.PACKAGE)
	private int bowRow;
	@Getter
	@Setter(AccessLevel.PACKAGE)
	private int bowColumn;
	@Getter
	@Setter(AccessLevel.PACKAGE)
	private boolean horizontal;

	/**
	 * An array of boolean which indicates whether that part of the ship has
	 * been hit. This is initialised by the appropriate sub-class. Battleships
	 * use all 4 locations; cruisers use the first 3; destroyers 2; submarines
	 * 1; and "empty sea" 1.
	 */
	protected boolean[] hit;

	/**
	 * clears the hit array indicating whether that part of the "Ship" has been
	 * hit
	 */
	protected Ship(int size, String type, String shortForm) {
		this.size = size;
		this.setType(type);
		this.shortForm = shortForm;
		hit = new boolean[size];
		for (int i = 0; i < hit.length; i++)
			hit[i] = false;
	}

	/**
	 * Checks that ship of this size will not overlap another ship, or touch
	 * another ship (vertically, horizontally, or diagonally) and that ship will
	 * not "stick out" beyond the array.
	 * 
	 * @param row
	 *            that will contain the bow
	 * @param column
	 *            that will contain the bow
	 * @param horizontal
	 *            = true if horizontal
	 * @param ocean
	 * @return true if it is okay to put a ship of this size with its bow in
	 *         this location, with the given orientation.
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal,
			Ocean ocean) {
		
		// try catch exception error if ship goes past board
		try {
			//check if ship exists in that exact spot
			 Ship ships[][] = ocean.getShipArray();
				if (!(ships[row][column] instanceof EmptySea)) 
					return false;
				
			// check if another ship is on either left  or right side
			if (!(isLeft(row, column, horizontal, ocean)))
				return false;
			if (!(isRight(row, column, horizontal, ocean)))
				return false;
			if (!(isTop(row, column, horizontal, ocean)))
				return false;
			if (!(isBottom(row, column, horizontal, ocean)))
				return false;
			
			return true;
		}
		// catch the error
		catch (Exception err) {
			return false;
		}
	}

	/**
	 * "places" the ship in the ocean, assigning values to the bowRow,
	 * bowColumn, and horizontal. Places a reference to the ship in the ships
	 * array in the Ocean object.
	 * 
	 * @param row
	 *            to contain the bow
	 * @param column
	 *            to contain the bow
	 * @param horizontal
	 * @param ocean
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);

		Ship ships[][] = ocean.getShipArray();

		for (int i = 0; i < getSize(); i++) {
			// set position in array to contain the ship
			ships[row][column] = this;
			if (horizontal) {
				column++;
			} else {
				row++;
			}
		}
	}

	private int getSize() {
		// return size of ship
		return size;
	}

	private void setHorizontal(boolean horizontal2) {
		// sets horizontal to incoming value
		horizontal = horizontal2;
	}

	private void setBowColumn(int column) {
		// sets bow column
		bowColumn = column;
	}

	private void setBowRow(int row) {
		// sets bow row
		bowRow = row;
	}

	/**
	 * If this ship has been hit, marks that part of the ship as "hit"
	 * 
	 * @param row
	 *            User's supplied row shot
	 * @param column
	 *            User's supplied column shot
	 * @return true if ship is hit, false otherwise
	 */
	public boolean shootAt(int row, int column) {
		if ((isHorizontal() && (row != getBowRow()))
				|| (!isHorizontal() && (column != getBowColumn()))) {
			return false; // it's not a hit
		} else {
			// it's a hit. Work out offset & set that position in hit array to
			// true
			hit[(row - getBowRow() + column - getBowColumn())] = true;

			return true;
		}
	}

	private int getBowRow() {
		// returns bow row
		return bowRow;
	}

	private int getBowColumn() {
		// returns bow column
		return bowColumn;
	}

	private boolean isHorizontal() {
		// returns true of ship is horizontal
		return horizontal;

	}

	/**
	 * checks whether this ship is sunk - using the hit array
	 * 
	 * @return true if every part of the ship has been hit, false otherwise.
	 */
	public boolean isSunk() {

		for (boolean b : hit)
			if (b == false)
				return false;

		return true;
	}

	public void sinkShip(Ocean ocean) {
		Ship ships[][] = ocean.getShipArray();
		int brow = getBowRow();
		int bcolumn = getBowColumn();
		boolean bhorizontal = isHorizontal();

		for (int i = 0; i < hit.length; i++) {
			ships[brow][bcolumn] = new HitType("$");

			if (bhorizontal) {
				bcolumn++;
			} else {
				brow++;
			}

			// System.out.println("Bow Column " + getBowColumn() + " Bow Row " +
			// getBowRow() + " Is Horizontal " + isHorizontal());
			// row = row + i;

		}

	}
	/**
	 * checks whether there is ship on the left
	 * 
	 * @return true if nothing is on the left, false otherwise.
	 */
	public boolean isLeft(int row, int column, boolean horizontal, Ocean ocean) {

		Ship ships[][] = ocean.getShipArray();

		// check if ship doesn't go off board
		if ((column - 1) >= 0) {
			// check for ship to the left, top left and bottom left of ship when horizontal
			if (horizontal && !(ships[row][column - 1] instanceof EmptySea))
				return false;
			if (horizontal	&& !(ships[row + 1][column - 1] instanceof EmptySea))
				return false;
			if (horizontal	&& !(ships[row - 1][column - 1] instanceof EmptySea))
				return false;
		}
		// check for ships on left if vertical
		for (int i = 0; i < getSize(); i++){
			if (!horizontal
					&& !(ships[row][column - 1] instanceof EmptySea)
					&& ((column - 1) >= 0)) 
				return false;
				row++;
		}
		
		return true;
	}
	
	public boolean isRight(int row, int column, boolean horizontal, Ocean ocean) {
		Ship ships[][] = ocean.getShipArray();
		// check if ship doesn't go off board
		if (column + getSize() < ocean.getDimension()) {
			// check for ship to the right, top right and top left right of ship when horizontal
			if (horizontal && !(ships[row][column + getSize()] instanceof EmptySea))
				return false;
			if (horizontal && !(ships[row + 1][column + getSize()] instanceof EmptySea))
				return false;
			if (horizontal && !(ships[row - 1][column + getSize()] instanceof EmptySea))
				return false;
		}
		for (int i = 0; i < getSize(); i++){
			if (!horizontal
					&& !(ships[row][column + 1] instanceof EmptySea)
					&& ((column + 1) < ocean.getDimension())) 
				return false;
				row++;
		}
		
		return true;
	}
	public boolean isTop(int row, int column, boolean horizontal, Ocean ocean) {
		Ship ships[][] = ocean.getShipArray();
		// check if ship is not off board
		if ((row - 1) >= 0) {
			// check if ship is on top left, top right and top when vertical
		if (!horizontal && !(ships[row - 1][column] instanceof EmptySea))
			return false;
		if (!horizontal && !(ships[row - 1][column - 1] instanceof EmptySea))
			return false;
		if (!horizontal && !(ships[row - 1][column + 1] instanceof EmptySea))
			return false;
		}
		for (int i = 0; i < getSize(); i++) {
			if (horizontal
					&& !(ships[row - 1][column] instanceof EmptySea)
					&& ((row - 1) >= 0)) 
				return false;
			column++;
		}
		
		return true;
	}
	public boolean isBottom(int row, int column, boolean horizontal, Ocean ocean) {
		Ship ships[][] = ocean.getShipArray();
		
		// check if a ship is not off board
		if (row + getSize() < ocean.getDimension()) {
		// check if ship is on bottom left, bottom right and bottom when vertical
		if (!horizontal	&& !(ships[row + getSize()][column] instanceof EmptySea))
			return false;
		if (!horizontal	&& !(ships[row + getSize()][column + 1] instanceof EmptySea))
			return false;
		if (!horizontal	&& !(ships[row + getSize()][column - 1] instanceof EmptySea))
			return false;
		}
		// check if ship is below if horizontal
		for (int i = 0; i < getSize(); i++) {
			if (horizontal
					&& !(ships[row + 1][column] instanceof EmptySea)
					&& ((row + 1) < ocean.getDimension())) 
				return false;
			column++;
		}
		
		return true;
	}
	/**
	 * @return a single character String to use in Ocean's print method
	 */
	@Override
	public String toString() {
		return shortForm;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String setHit(String hit) {
		return hit;
	}
}