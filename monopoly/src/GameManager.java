/**
 *
 * @author Brad
 */

import java.util.Scanner;

public class GameManager
{
	GameState gs;
	public GameManager()
	{
		this.gs = new GameState(2);
	}

	private void firstTurnPrep()
	{
		// Determine who goes first via die-roll
		int roll[3] = 

	public void mainLoop()
	{
		// Handle player turn swapping
		if (this.gs.turn > this.gs.players.length())
		{
			this.gs.turn = 0;
}
