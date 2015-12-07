
/**
 *
 * @author Brad
 */
public class Property extends Space
{
    int Owner = -1;
    int houses = 0; 
    boolean hotel;
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
    
    public void setHouses(int houses)
    {
        this.houses = houses; 
    }
    
    public int getHouses()
    {
        return houses;
    }
   
    public void setHotel(boolean hotel)
    {
        this.hotel = hotel;
    }
    
    public boolean hasHotel()
    {
        return hotel;
    }
    
    @Override 
    public void action(Player player, Board board)
    {   
        System.out.print("I am a placeholder, ignore me");
                
        
    }
    
}
