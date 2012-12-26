package Battleships;
/*
* Class Ocean contains array of Ships, representing the "ocean,"
* Ocean keeps track of shots fired, hit count and number of ships sunk.
* Ocean provides checks for whether a shot hits a ship, sinks it or misses.
*/


/**
* @author MARGARET WRIGHT
* @author KLM
*/

import java.util.Random;

public class OceanTest {

    private static final int TEN;

    private final Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    static {
        TEN = 10;
    }

    /**
* Creates an "empty" ocean (fills the ships array with EmptySeas). Also
* initialises game variables, shotsFired, hitCount & shipsSunk
*/
    public OceanTest() {
        ships = new Ship[TEN][TEN];
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                ships[i][j] = new EmptySea();
            }
        }
        setShotsFired(0);
        setHitCount(0);
        setShipsSunk(0);
    }

    /**
* @return the size of the row/column
*/
    public int getDimension() {
        return ships.length;
    }

    /**
* Places all 10 ships randomly on the (initially empty) ocean.
*/
    public void placeAllShipsRandomly() {
        Ship[] fleet = new Ship[TEN];
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
        for (Ship s : fleet) {
            do {
                // generate random x, y, horizontal
                x = m.nextInt(TEN); // x/row is random 0-9
                y = m.nextInt(TEN); // y/col is random 0-9
                b = m.nextInt(2) == 1; // horizontal : 1 is true; 0 is false
            } while (!s.okToPlaceShipAt(x, y, b, this));

            // it is safe to place the ship
            s.placeShipAt(x, y, b, this);
        }
    }

	/**
	* Prints the ocean.
	*/
    @Override
    public String toString() {
        final String SPACES = " ";
        StringBuilder buffer = new StringBuilder();
        buffer.append(" ");
        for (int i = 0; i < ships[0].length; i++) {
            buffer.append(SPACES);
            buffer.append(i);
        }
        buffer.append("\n");

        for (int i = 0; i < ships.length; i++) {
            buffer.append(i);
            for (int j = 0; j < ships[0].length; j++) {
                buffer.append(SPACES);
                buffer.append(ships[i][j]);
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    /**
* Checks whether the location contains anything other than empty sea.
*
* @param row
* @param column
* @return true if the given location contains a ship, false if it does not.
*/
    public boolean isOccupied(int row, int column) {
        return !(ships[row][column] instanceof EmptySea);
    }

    /**
* Checks whether the location contains a ship, still afloat. Marks that
* ship as hit and checks whether whole ship is sunk. Updates the number of
* shots that have been fired, and number of hits.
*
* @param row
* @param column
* @return true if location contains a "real" ship, still afloat, false if not.
*/
    public boolean shootAt(int row, int column) {
        // increment the number of shots fired regardless of result
        setShotsFired(getShotsFired() + 1);

        // check for a ship
        if (isOccupied(row, column)) {

            // get the ship
            Ship s = ships[row][column];
            s.shootAt(row, column);
            setHitCount(getHitCount() + 1);
            return true;
        }
        return false;
    }


    /**
* Returns true if all ships have been sunk, otherwise false.
*
* @return true or false
*/

    public boolean isGameOver() {
        // check whether all ships in fleet have been sunk
        return getShipsSunk() == TEN;
    }

    /**
* Gets the array of ships Methods in the Ship class that take an Ocean
* parameter can look at the contents of this array; the placeShipAt method
* can modify it.
*
* @return the array of ships
*/
    public Ship[][] getShipArray() {
        return ships;
    }

    /**
* The number of times a shot hit a ship. If the user shoots the same part
* of a ship more than once, every hit is counted, even though the
* additional "hits" don't do the user any good.
*/
    public int getHitCount() {
        return hitCount;
    }

    /**
* The number of ships sunk (10 ships in all)
*/
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
* The total number of shots fired by the user.
*/
    public int getShotsFired() {
        return shotsFired;
    }

    private void setShotsFired(int shotsFired) {
        this.shotsFired = shotsFired;
    }

    private void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    private void setShipsSunk(int shipsSunk) {
        this.shipsSunk = shipsSunk;
    }
}