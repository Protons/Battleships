package Battleships;
public class Ocean {

	Ship[][] ships = new Ship[10][10];
	int shotsFired;
	int hitCount;
	int shipsSunk;

	public Ocean() {
		
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				ships[i][j] = new EmptySea();
			}
		}
	}
	@Override
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
	}

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
