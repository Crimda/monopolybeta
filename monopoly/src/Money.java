/**
 *
 * @author Brad
 */
public class Money 
{
    int money;
	
    public Money() 
    {
		this(0);
    }
    
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
		this.money += amount;
    }

    public void setMoney(int amount)
    {
    	this.money = amount;
    }
	
    public void subtractMoney(int amount) 
    {
		this.money -= amount;
    }
	
    public boolean bankrupt() 
    {
		return this.money < 0;
	}
}
