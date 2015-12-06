
/**
 *
 * @author Brad
 */
public class Property extends Space
{
    int price; 
    int master = -1;
    
    public Property(String name, int price)
    {
        super(name);
        //super(color); // for later
        this.price = price;
    }
    
    public void setMaster(int master)
    {
        this.master = master; 
    }
    
    public int getPrice()
    {
        return price;
    }
    
    @Override 
    public void action(Player player, Board board)
    {
        if (master < 0)
        {
        System.out.println(player.getName() + " do you want to purchase " + getName() + "?");
        /**if //fuck TODO: handle player input on whether to buy property or not
                // also charge rent if the player is not the Master/owner
                */
        }
    }
    
}
