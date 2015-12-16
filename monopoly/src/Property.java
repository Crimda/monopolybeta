
/**
 *
 * @author Brad
 */
public class Property extends Space
{
    
    public Property(String name, int price, int rent, int houseCost, int hotelCost, int mortgageValue, int h1RateModifier, int h2RateModifier, int h3RateModifier, int h4RateModifier, int hotelRateModifier)
    {
        super(name);
        //super(color); // for later
        this.price = price;
        this.rent = rent;
        this.houseCost = houseCost;
        this.hotelCost = hotelCost;
		
		this.h1RateModifier = h1RateModifier;
		this.h2RateModifier = h2RateModifier;
		this.h3RateModifier = h3RateModifier;
		this.h4RateModifier = h4RateModifier;
		this.hotelRateModifier = hotelRateModifier;

        this.mortgageValue = mortgageValue;
        this.buyable = true;
        this.canUpgrade = true;
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
		this.mortgage = yesno;
	}
   
    @Override 
    public void action(Player player, Board board)
    {   
        System.out.print("I am a placeholder, ignore me");
                
        
    }
    
}
