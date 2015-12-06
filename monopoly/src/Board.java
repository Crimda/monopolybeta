/**
 *
 * @author Brad
 */
public class Board 
{
    int presentTurn = 0;
    int playerCount = 0;
    Player[] players; 
    Space[] spaces = new Space[40];
    //TODO: need a way to name/mark the spaces 
    
    /**
    public Board()
    {
    }
    TODO: call functions for special blocks like jail, and rent, and everything  else kill me now
    */
    
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
	
    public Player getPlayer(int id) 
    {
	return players[id];
    }
	
    public int getTotalSpaces() 
    {
	return spaces.length;
    }
    
}
