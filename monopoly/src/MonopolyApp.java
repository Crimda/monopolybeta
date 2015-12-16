/**
 *
 * @author Brad
 */

import java.util.Scanner;

public class MonopolyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
	   	System.out.println("How many players?");
	   	GameState gs = new GameState(2); // Temp, need the drawing
    	int choice = UI.getChoice(gs, "1 - 2 Players\n2 - 3 Players\n3 - 4 Players\n4 - 5 Players\n5 - 6 Players\n\t> ", 1, 5);

		GameManager gm = new GameManager(choice + 1);
		gm.mainLoop();
//		GameState gs = new GameState(6);
//		UI.drawMap2(gs);
    }
    
}
