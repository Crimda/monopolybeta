/**
 *
 * @author Brad
 */
public class Railroad extends Space
{
    int price; 
    
    public Railroad(String name, int mortgageValue)
    {
        super(name);
        this.price = 200;
        this.buyable = true;
        this.mortgageValue = mortgageValue;
    }
        
    public int getPrice()
    {
        return price;
    }

	@Override
	public void setBuyable(boolean value)
	{
		this.buyable = value;
	}

	@Override
	public void setOwnerID(int id)
	{
		this.ownerID = id;
	}

	@Override
	public void setHouses(int houses)
	{} // Disabled

	@Override
	public void setHotel(boolean yesno)
	{} // Disabled
        
    @Override
	public void setMortgage(boolean yesno)
	{
		this.mortgage = yesno;
	}

    @Override 
    public void action(Player player, Board board)
    {   
        System.out.print("I am a placeholder, ignore me");
    }
    
}

