/**
 *
 * @author Brad
 */
public class FreeParking extends Space 
{   
    public FreeParking(String name) 
    {
	super(name);
    }

	@Override
	public void setOwnerID(int it)
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
    {
    System.out.println("I am placeholder, ignore me");
    
    }
}
