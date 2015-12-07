/**
 *
 * @author Brad
 */

public class GameState
{
	public int playerCount;
	public Player[] players;

	public GameState(int playerCount)
	{
		this.playerCount = playerCount;
		this.players = new Player[playerCount];
		for (int i = 0; i < playerCount; i++)
		{
			this.players[i] = new Player(i, "Player " + (i + 1));
		}
	}
}

