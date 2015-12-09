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
        // TODO code application logic here
		int g_numberOfPlayers = 0;

		Scanner scnr = new Scanner();

		while (g_numberOfPlayers == 0)
		{
			String option = getString(scnr, "How many players? [1,2,3,4]: ");

			
		// Initialize the game state
        GameState gs = new GameState(2);


		

        UI.drawMap(gs);
    }
    
}
