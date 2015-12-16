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
//		GameManager gm = new GameManager();
//		gm.mainLoop();
		GameState gs = new GameState(6);
		UI.drawMap2(gs);
    }
    
}
