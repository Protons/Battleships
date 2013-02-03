package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Battleships.EmptySea;
import Battleships.Ocean;
import Battleships.Ship;

public class ShipTest {

	@Test
	public void testPlaceShipAt() {
		fail("Not yet implemented");
	}
	
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal,
			Ocean ocean) {
		// try catch exception error if ship goes past board
		try {
			Ship ships[][] = ocean.getShipArray();
			// check if another ship is on either left size or right
		//	if (!(isLeft(row, column, horizontal, ocean)))
		//			return false;
			
			// check if another ship is on either left size or right
			if (row + getSize() < ocean.getDimension()) {
				// check for ship to the bottom of ship when vertical
				if (!horizontal
						&& !(ships[row + getSize()][column] instanceof EmptySea))
					return false;
			}
			if ((row - 1) >= 0) {
				// check for ship to the top of ship when vertical
				if (!horizontal
						&& !(ships[row - 1][column] instanceof EmptySea))
					return false;
			}
			if ((column - 1) >= 0) {
				// check for ship to the left of ship when horizontal
				if (horizontal && !(ships[row][column - 1] instanceof EmptySea))
					return false;
			}
			if (column + getSize() < ocean.getDimension()) {
				// check for ship to the right of ship when horizontal
				if (horizontal
						&& !(ships[row][column + getSize()] instanceof EmptySea))
					return false;
			}

			for (int i = 0; i < getSize(); i++) {
				if (!(ships[row][column] instanceof EmptySea)) {
					return false;
				}
				// check below if ship exists and not off board
				else if (horizontal
						&& !(ships[row + 1][column] instanceof EmptySea)
						&& ((row + 1) < ocean.getDimension())) {
					return false;
				}
				// check above if ship exists and not off board
				else if (horizontal
						&& !(ships[row - 1][column] instanceof EmptySea)
						&& ((row - 1) >= 0)) {
					return false;
				}
				// check to the right if ship exists and not off board
				else if (!horizontal
						&& !(ships[row][column + 1] instanceof EmptySea)
						&& ((column + 1) < ocean.getDimension())) {
					return false;
				}
				// check to the left if ship exists and not off board
				else if (!horizontal
						&& !(ships[row][column - 1] instanceof EmptySea)
						&& ((column - 1) >= 0)) {
					return false;
				} else {
					if (horizontal) {
						column++;
					} else {
						row++;
					}
				}
			}
			return true;
		}
		// catch the error
		catch (Exception err) {
			return false;
		}
	}

}
