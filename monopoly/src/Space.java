/**
 *
 * @author Brad
 */
public abstract class Space 
{
    String name;
    String color;
    int houses = 0;
    boolean hotel = false;
    boolean mortgage = false;

    int price = 0;
    int rent = 0;
    int taxRate = 0;
    int houseCost = 0;
    int hotelCost = 0;
    int mortgageValue = 0;

    int h1RateModifier = 0;
    int h2RateModifier = 0;
    int h3RateModifier = 0;
    int h4RateModifier = 0;
	int hotelRateModifier = 0;

    boolean buyable = false;
    boolean canUpgrade = false;

    int ownerID = -1;
    
	public abstract void setOwnerID(int id);

	public int getMortgageValue()
	{
		return this.mortgageValue;
	}

	public int getHouseCost()
	{
		return this.houseCost;
	}

	public int getHotelCost()
	{
		return this.hotelCost;
	}

	public int getOwnerID()
	{
		return this.ownerID;
	}

	public int getTaxRate()
	{
		return this.taxRate;
	}

	public boolean getBuyable()
	{
		return this.buyable;
	}

	public boolean getCanUpgrade()
	{
		return this.canUpgrade;
	}

	public abstract void setBuyable(boolean value);

	public int getHouses()
	{
            return this.houses;
	}

	public int getPrice()
	{
		return this.price;
	}

	public int getRent()
	{
		int finalRent = this.rent;
		switch (this.houses)
		{
			case 1:
				finalRent = this.h1RateModifier;
				break;
			case 2:
				finalRent = this.h2RateModifier;
				break;
			case 3:
				finalRent = this.h3RateModifier;
				break;
			case 4:
				finalRent = this.h4RateModifier;
				break;
			default:
				break;
		}

		if (this.hotel)
			finalRent = this.hotelRateModifier;

		return finalRent;
	}

	public abstract void setHouses(int houses);
        
	public boolean getHotel()
	{
            return this.hotel;
	}

	public abstract void setHotel(boolean yesno);
        
        public boolean getMortgage()
        {
            return this.mortgage;
        }
        
        public abstract void setMortgage(boolean yesno);

    public Space(String name) 
    {
	this.name = name;
    }
	
    public String getName() 
    {
	return name;
    }
    
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public String getColor()
    {
        return color;
    }
    
   //abstract method that special monopoly squares will use to execute
    //their actions by overriding 
    public abstract void action(Player player, Board board);
}
