package Battleships;
public class EmptySea extends Ship {
	public EmptySea() {
		lenght = 1;
	}

	@Override
	boolean shootAt(int row, int column) {
		return false;
	}

	@Override
	boolean isSunk() {
		return false;
	}

	@Override
	public String toString() {
		return ".";
	}
}
