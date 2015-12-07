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
   
	public int getHouses()
	{
		return this.houses;
	}

	public abstract void setHouses(int houses)
	{
		this.houses = houses;
	}

	public boolean getHotel()
	{
		return this.hotel;
	}

	public abstract boolean setHotel(boolean yesno)
	{
		this.hotel = yesno;
	}

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
