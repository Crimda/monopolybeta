
/**
 *
 * @author Brad
 */
public class Property extends Space
{
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
	public void setOwnerID(int id)
	{
		this.ownerID = id;
	}

	@Override
	public int getOwnerID()
	{
		return this.ownerID;
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
