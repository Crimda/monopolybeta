/**
 *
 * @author Brad
 */
public class Railroad extends Space
{
    int price; 
    
    public Railroad(String name)
    {
        super(name);
        this.price = 200;
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
    public void action(Player player, Board board)
    {   
        System.out.print("I am a placeholder, ignore me");
    }
    
}

