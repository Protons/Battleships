package Battleships;
public class Ocean {

	private static final int UPPER;  // upper bound of the (square) board
	Ship[][] ships = new Ship[10][10];
	int shotsFired;
	int hitCount;
	int shipsSunk;
	
    static { // just to show how to use static initialization blocks
        UPPER = 10;
    }
/*	public Ocean() {
		
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				ships[i][j] = new EmptySea();
			}
		}
	}*/
    public Ocean() {
        ships = new Ship[UPPER][UPPER];
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                ships[i][j] = new EmptySea();
            }
        }
        setShotsFired(0);
        setHitCount(0);
        setShipsSunk(0);
    }
    @Override
    public String toString() { // this replaces the "print" method of the spec
        final String SPACES = " ";
        // have to use a mutable String based data structure for efficiency
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
/*	@Override
	public String toString() {
		System.out.print(" ");
        for (int i = 0; i < ships.length; i++) {
        		System.out.print(" ");
             	System.out.print(i);
        }
        System.out.println();
		
		for (int i = 0; i < ships.length; i++) {
			System.out.print(i);
			
			for (int j = 0; j < ships[0].length; j++) {
				System.out.print(" ");
				System.out.print(ships[i][j]);
			}
			System.out.println();
		}
		return "";
	}*/

	public Ship[][] getShips() {
		return ships;
	}

	public void setShips(Ship[][] ships) {
		this.ships = ships;
	}

	public int getShotsFired() {
		return shotsFired;
	}

	public void setShotsFired(int shotsFired) {
		this.shotsFired = shotsFired;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public int getShipsSunk() {
		return shipsSunk;
	}

	public void setShipsSunk(int shipsSunk) {
		this.shipsSunk = shipsSunk;
	}
}
