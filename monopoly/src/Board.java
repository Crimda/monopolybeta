/**
 *
 * @author Brad
 */
import java.util.Random;
public class Board 
{
    int presentTurn = 0;
    int playerCount = 0;
    Player[] players; 
    Space[] spaces = new Space[40];
    //TODO: need a way to name/mark the spaces 
    
    
    public Board(int playerCount)
    {
        this.playerCount = playerCount;
        players = new Player[playerCount]; 
        for(int i = 0; i < players.length; i++)
        {   //create player 1 and 2 or however many is specified 
            players[i] = new Player(i, "player " + (i + 1));
        }
        
        for(int i = 0; i < spaces.length; i++)
        {
            if(i == 0)
                spaces[i] = new Go("GO");
            /** these pieces don't exist yet 
            else if(i == 2)
                spaces[i] = new chest("Community Chest");
            else if(i == 4)
                spaces[i] = new incomeTax("Income Tax");
            else if(i == 7)
                spaces[i] = new chance("Chance?");
                */
        }
        
    }
    //TODO: call functions for special blocks like jail, and rent, and everything  else kill me now
    
    
    public Space movePos(Player player, int roll)
    {
        if(player.isBankrupt())
        {
            return spaces[player.getPos()];
            //TODO: Handle bankruptcy and eject player? 
        }
        
        int newPos = (player.getPos() + roll);
        player.setPos(newPos);
        System.out.println("Player moves to " + spaces[player.getPos()].getName()); //TODO: get a helper function to 
        return spaces[newPos];                                                      //identify player name and print it
    }
    
    public boolean hasWinner() 
    {//see if there's only 1 player left
	int stillAlive = 0;
	for(Player player:players)
        {
            if(!player.isBankrupt())
            {
                stillAlive++;
            }
	}
            return stillAlive <= 1;
    }
	
    public Player getWinner() 
    {//get the remaining player 
	if(!hasWinner())
        { 
            return null; 
        }
	for(Player player:players)
        {
            if(!player.isBankrupt())
            { 
                return player; 
            }
	}
	return null;
    }
    
    public Player getCurrentPlayer() 
    {
        return players[presentTurn];
    }
	
    public Player[] getPlayers() 
    {
        return players;
    }
	
    public Player getPlayer(int playerID) 
    {
	return players[playerID];
    }
	
    public int getTotalSpaces() 
    {
	return spaces.length;
    }
    
    public void nextTurn() 
    {//make sure turn does not exceed number of players left 
        //todo: for this to work, need to implement player removal as well
	if(++presentTurn >= players.length)
        {
            presentTurn = 0;
        }
    }
}	