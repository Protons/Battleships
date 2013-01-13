package Battleships;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BattleshipGame {
	
	/**
	 * @param <Position>
	 * @param args
	 */
	public static void main(String[] args) {
		
        Set<String> replies = new HashSet<>(); // TODO - improve this
        replies.add("Yes");
        replies.add("yes");
        replies.add("y");

        int limit;
        String reply;
        Scanner input = new Scanner(System.in);
		
        do {
            // set up the game		
        	Ocean sea = new Ocean();
        	sea.placeAllShipsRandomly();
        	System.out.println();
        	System.out.println(sea);
        	limit = sea.getDimension();
		//System.out.print(sea);
            do {
                // read in the shot
                Position p = getValidInput(input, limit);
                // accept shots & check whether it's a hit (in Ocean)
                if (!sea.shootAt(p.getX(), p.getY())) // a miss
                {
                	System.out.println("A miss, try again.");
                	                	
                	sea.updateBoard(p.getX(), p.getY(), sea);
                } else
                {
                	sea.updateBoard(p.getX(), p.getY(), sea);
                }
                //System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //clear screen kind of
                
                System.out.println(sea);
                System.out.println("[. is empty sea; X is a miss; H is a hit; $ is a sunken ship.]");
                
            	                //System.out.println();
            } while (!sea.isGameOver());
            // print out final scores
            System.out.println(sea.printFinalScores());

            System.out.print("Do you want to play again (Yes or No)? ");
            reply = input.next();
        } while (replies.contains(reply)); // play again?
	}


    /*
* Gets valid input from user for row (x) & column (y)
*
* @param user input from keyboard
*
* @return the valid shot location
*/
    private static Position getValidInput(Scanner input, int limit) {
        // x is the row; y is the column
        int x, y;
        System.out.println();
        System.out.println("Where do you want to fire (x,y)? ");
        x = askForInput(input, "x/row = ", limit);
        y = askForInput(input, "y/col = ", limit);
        return new Position(x, y);
    }

    /*
* Checks for valid user input for x or y
*
* @param input from user
*
* @return the valid co-ordinate
*/
    private static int askForInput(Scanner input, String rowCol, int limit) {
        int coordinate;
        do {
            try {
                do {
                    System.out.print(rowCol);
                    coordinate = input.nextInt();
                } while (coordinate < 0 || coordinate > limit - 1);
                return coordinate;
            } // checks for not an integer
            catch (Exception ex) {
                System.err.println("Invalid answer - please enter a number between 0-" + limit + ".");
                input.nextLine();
            } // end of catch
        } while (true);
    }
}