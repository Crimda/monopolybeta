/**
 *
 * @author Brad
 */

import java.util.Scanner;

public class MonopolyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		// Initialize input
		Scanner scnr = new Scanner(System.in);
			
		// Initialize the game state
        GameState gs = new GameState(2);

		

        UI.drawMap(gs);
    }
    
}
