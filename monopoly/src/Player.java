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

    int numRailroads = 0;
    int numUtilities = 0;

	// This is basically a player-owned list of properties
	List<Integer> ownedProperties = new ArrayList<Integer>();

    public Player (int playerId, String name)
    {
        this.playerID = playerId; 
        this.name = name;
    }
    
	public void buyProperty(int property, int value)
	{
		if (this.money.getMoney() > value)
		{
			this.ownedProperties.add(property);
			this.money.subtractMoney(value);
		}
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
    
	public void setInJail()
	{
		this.inJail = true;
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
		return playerID;
    }

    public boolean jailTime()
    { // Returns false if a player attempted an invalid action, true otherwise
    	if (!this.inJail) return false;

    	int choice = 0;

		// TODO: Get player choice; 1 == roll, 2 == pay, 3 == use card(if possible), else == invalid
		
		if (this.escapeAttempts == 3)
		{
			this.money.subtractMoney(50);
			this.inJail = false;
			return true;
		}

    	if (choice == 1)
    	{
    		if (this.escapeAttempts < 3)
    		{
    			this.escapeAttempts += 1;
    			int[] dieRoll = Dice.getRoll();
    			if (dieRoll[0] == dieRoll[1])
    			{
    				this.inJail = false;
    				// TODO: Move player post this
    			}
    			else
    			{
    				// TODO: inform player that they failed to escape
    			}
    		}
    		return true;
    	} else
    	if (choice == 2)
    	{
    		if (this.escapeAttempts == 0)
    		{
	    		this.money.subtractMoney(50);
				this.inJail = false;
				return true;
			}
			else
			{
				// TODO: inform player that they may not roll again
				return false;
			}	
		} else
		if (choice == 3)
		{
			if (this.escapeAttempts == 0)
			{
				if (this.hasGetOutOfJailFreeCard)
				{
					this.hasGetOutOfJailFreeCard = false;
					this.inJail = false;
					return true;
				}
				else
				{
					// TODO: inform player that they lack a get out of jail free card
					return false;
				}
			}
			else
			{
				// TODO: inform player that they may not use the get out of jail free card after rolling
				return false;
			}
		}
		else return false;
    }

    public void setBankrupt(boolean bankrupt) 
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
