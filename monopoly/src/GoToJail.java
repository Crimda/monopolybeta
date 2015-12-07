/**
 *
 * @author Brad
 */
public class GoToJail extends Space 
{
    public GoToJail(String name) 
    {
		super(name);
    }
	
    @Override
    public void action(Player player, Board board) 
    {
		System.out.println("Player has to go to jail");
	    player.setPos(10);
	    player.setInJail();
    }
}
