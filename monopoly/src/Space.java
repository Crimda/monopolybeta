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
    
    //reserved for square specific action?
    //public abstract void doSomething(Player player, Board board);
}
