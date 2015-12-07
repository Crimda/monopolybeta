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
	public void setHouses(int houses)
	{} // Disabled

	@Override
	public void setHotel(boolean yesno)
	{} // Disabled

    @Override
    public void action(Player player, Board board) 
    {
		System.out.println("Player has to go to jail");
	    player.setPos(10);
	    player.setInJail();
    }
}
