package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Battleships.EmptySea;
import Battleships.Ocean;
import Battleships.Ship;

public class ShipTest {
	private Ocean ocean;
	
	@Test
	public void testPlaceShipAt() {
		
		int row = 3;
		int column = 4;
		boolean horizonal = true;
		//ocean = new Ocean();
		
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
		fail("Not yet implemented");
	}}


