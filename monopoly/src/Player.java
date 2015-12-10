/**
 *
 * @author Brad
 */

import java.util.*;

public class Player 
{
    int playerID;
    int position = 0;
    String name; 

    Money money = new Money(1500); //look up starting cash for real game

	boolean inJail = false;
	int escapeAttempts = 0;
	boolean hasGetOutOfJailFreeCard = false;
	String invalidReason = "";
	int escapeRollValue = 0;

    int numRailroads = 0;
    int numUtilities = 0;

    int numMortgages = 0;

	// This is basically a player-owned list of properties
//	List<Integer> ownedProperties = new ArrayList<Integer>();

    public Player (int playerId, String name)
    {
        this.playerID = playerId; 
        this.name = name;
    }
 /*   
	public Integer[] getOwnedProperties()
	{
		Integer[] retval = this.ownedProperties.toArray(new Integer[this.ownedProperties.size()]);
		return retval;
	}
*/
 	public int getNumMortgages()
 	{
 		return this.numMortgages;
 	}

 	public void setNumMortgages(int value)
 	{
 		this.numMortgages = value;
 	}

	public boolean buyProperty(int value)
	{
		if (this.money.getMoney() > value)
		{
//			this.ownedProperties.add(property);
			this.money.subtractMoney(value);
			return true;
		}
		return false;
	}

    public void setPos(int position)
    {
        this.position = position;
    }

    public boolean movePlayer()
    { // returns true if the player rolled doubles and may move again
    	if (this.inJail) return false;

		int[] dieRoll = Dice.getRoll();

		this.position += dieRoll[2];

    	if (this.position > 39)
    	{
    		this.position -= 39;
    		this.money.addMoney(200);
    	}

    	if (dieRoll[0] == dieRoll[1]) return true;
    	return false;
    }
    
    public boolean movePlayer(int amount)
    { // always returns true
    	this.position += amount;
    	if (this.position > 39)
    	{
    		this.position -= 39;
    		this.money.addMoney(200);
    	}

    	return true;
    }

    
	public void setInJail(boolean value)
	{ // Move the player to be in jail and set inJail
		if (value == true)
		{
			this.position = 10;
			this.inJail = true;
		} else
		this.inJail = false;
	}

	public boolean getInJail()
	{ // Returns whether the player is in jail or not
		return this.inJail;
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

    public int getTotalMoney()
    {
    	return this.money.getMoney();
    }

    public void giveMoney(int amount)
    {
    	this.money.addMoney(amount);
    }

    public void takeMoney(int amount)
    {
    	this.money.subtractMoney(amount);
    }
	
    public int getID() 
    {
		return playerID;
    }

    public int getEscapeAttempts()
    { // Returns number of escape attempts from jail
		return this.escapeAttempts;
	}

	public void incEscapeAttempts()
	{ // Increments number of escape attempts used
		this.escapeAttempts += 1;
	}

    public void setBankrupt() 
    { // Set a player forcibly to bankrupt
		this.money.setMoney(0);
    }
	
    public boolean isBankrupt() 
    { // Return whether money is at 0 or less
    	if (this.money.getMoney() <= 0)
    		return true;

    	return false;
    }  
}
