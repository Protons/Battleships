package Battleships;
public class Ship {

	int bowRow;
	int bowColumn;
	int lenght;
	boolean horizontal;
	boolean[] hit = new boolean[4];

	boolean okToPlaceShipAt(int row, int column, boolean horizontal, OceanTest oceanTest) {
		return false;
	}

	void placeShipAt(int row, int column, boolean horizontal, OceanTest oceanTest) {

	}

	boolean shootAt(int row, int column) {
		return false;
	}

	boolean isSunk() {
		return false;
	}

	public int getBowRow() {
		return bowRow;
	}

	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}

	public int getBowColumn() {
		return bowColumn;
	}

	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean[] getHit() {
		return hit;
	}

	public void setHit(boolean[] hit) {
		this.hit = hit;
	}

}
