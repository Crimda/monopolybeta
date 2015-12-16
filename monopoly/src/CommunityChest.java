/**
 *
 * @author Brad
 */
import java.util.Random;

public class CommunityChest extends Space
{
    public CommunityChest(String name) 
    {
        super(name);
    }

	@Override
	public void setBuyable(boolean value)
	{} // Disabled

	@Override
	public void setOwnerID(int id)
	{} // Disabled

	@Override
	public void setHouses(int houses)
	{} // Disabled

	@Override
	public void setHotel(boolean yesno)
	{} // Disabled
        
        @Override
	public void setMortgage(boolean yesno)
	{} // Disabled
    
    public static int getRng()
    {
    Random rand = new Random();
    int rng = 1+rand.nextInt(6);
    return rng;
    }
    
    @Override
    public void action(Player player, Board board) 
    {
        System.out.println("This is not a message. You do not see anything. Move along sir.");
    }
    
}

