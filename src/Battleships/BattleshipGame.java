package Battleships;

public class BattleshipGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ocean sea = new Ocean();
		sea.placeAllShipsRandomly();
		System.out.print(sea);
	}

}