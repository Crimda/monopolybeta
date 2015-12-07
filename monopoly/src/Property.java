
/**
 *
 * @author Brad
 */
public class Property extends Space
{
    int Owner = -1;
    int price; 
    
    
    public Property(String name, int price)
    {
        super(name);
        //super(color); // for later
        this.price = price;
    }
        
    public int getPrice()
    {
        return price;
    }
    
    public void setOwner(Player player)
    {
        Owner = player.getID();
    }
    
    public int getOwner()
    {
        return Owner;
    }

	@Override
	public void setHouses(int houses)
	{
		this.houses = houses;
	}

	@Override
	public void setHotel(boolean yesno)
	{
		this.hotel = yesno;
	}
        
        @Override
	public void setMortgage(boolean yesno)
	{
		this.hotel = yesno;
	}
   
    @Override 
    public void action(Player player, Board board)
    {   
        System.out.print("I am a placeholder, ignore me");
                
        
    }
    
}
