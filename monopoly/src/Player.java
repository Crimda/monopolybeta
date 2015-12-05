/**
 *
 * @author Brad
 */
public class Player 
{
    int playerId;
    int turn = 0;
    int position = 0;
    String name; 
    boolean bankrupt = false; 
    Money money = new Money(1500); //look up starting cash for real game
    
    public Player (int playerId, String name)
    {
        this.playerId = playerId; 
        this.name = name;
    }
    
    public void nextTurn()
    {
        turn++;
    }
    
    public int getTurn()
    {
        return turn;
    }
    
    public void setPos(int position)
    {
        this.position = position;
    }
    
    public int getPos()
    {
    return position;
    }
    
    public String getName()
    {
        return name;
    }
   
    public Money getMoney() 
    {
	return money;
    }
	
    public int getID() 
    {
	return playerId;
    }
    
    //player tosses a die 
    public int rollDice(Dice dice)
    {
        int rollResult = dice.getRoll();
        System.out.println(getName() + "tosses the die... the result is: " + rollResult);
        return rollResult;                 
    }
    
    public void setBankrupt(boolean bankrupt) 
    {
	this.bankrupt = bankrupt;
    }
	
    public boolean isBankrupt() 
    {
	return bankrupt;
    }
    
    
    
}
