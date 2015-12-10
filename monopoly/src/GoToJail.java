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

    @Override
    public void action(Player player, Board board) 
    {} // Disabled
}
