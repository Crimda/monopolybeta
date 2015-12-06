/**
 *
 * @author Brad
 */
public abstract class Space 
{
    String name;
    String color;
    
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
