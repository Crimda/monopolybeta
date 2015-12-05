/**
 *
 * @author Brad
 */
public class Money 
{
    int money;
	
    /**
     * public Money() 
        {
	this(0);
	}
    */ 
    
    //methods
    public Money(int money) 
    {
	this.money = money;
    }
	
    public int getMoney() //mo money mo problems
    {
        return money;
    }
	
    public void addMoney(int amount) 
    {
        money += amount;
    }
	
    public void substractMoney(int amount) 
    {
	money -= amount;
    }
	
    public boolean bankrupt() 
    {
	return money < 0;
    }
}
