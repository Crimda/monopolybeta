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
		int g_numberOfPlayers = 0;

		Scanner scnr = new Scanner(System.in);

		g_numberOfPlayers = 2;
			
		// Initialize the game state
        GameState gs = new GameState(2);

        UI.drawMap(gs);
    }
    
}
