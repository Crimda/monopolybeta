/**
 *
 * @author Brad
 */
public class Utility extends Space
{
    int price; 
    
    public Utility(String name)
    {
        super(name);
        this.price = 150;
    }
        
    public int getPrice()
    {
        return price;
    }
    
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
        System.out.print("I am a placeholder, ignore me");
    }
    
}

