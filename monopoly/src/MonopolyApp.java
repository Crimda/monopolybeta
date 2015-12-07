/**
 *
 * @author Brad
 */
public class MonopolyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GameState gs = new GameState(4);
        gs.players[0].setPos(32);
        gs.players[1].setPos(19);
        gs.players[2].setPos(31);
		gs.players[3].setPos(18);
        UI.drawMap(gs);
    }
    
}
