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

    boolean buyable = false;

    int ownerID = -1;
    
	public abstract void setOwnerID(int id);

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
		return this.rent;
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
