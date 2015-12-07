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
    
	public int getHouses()
	{
            return this.houses;
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
