/**
 *
 * @author Brad
 */

public class GameState
{
	public int playerCount;
	public Player[] players;
	public Space[] properties;

	int turn = 0;

	public GameState(int playerCount)
	{
		this.playerCount = playerCount;
		this.players = new Player[playerCount];
		for (int i = 0; i < playerCount; i++)
		{
			this.players[i] = new Player(i, "Player " + (i + 1));
		}

		this.properties = new Space[40];

		this.properties[0] = new Go("GO");
		this.properties[1] = new Property("Mediteranean Avenue", 60);
//		this.properties[2] = new //TODO: Community chest
		this.properties[3] = new Property("Baltic Avenue", 60);
		this.properties[4] = new Tax("Income Tax", 200);
//		this.properties[5] = new //TODO: Railroad
		this.properties[6] = new Property("Oriental Avenue", 100);
//		this.properties[7] = new //TODO: Chance
		this.properties[8] = new Property("Vermont Avenue", 100);
		this.properties[9] = new Property("Connecticut Avenue", 120);
//		this.properties[10] = new //TODO: Jail
		this.properties[11] = new Property("St. Charles Place", 140);
//		this.properties[12] = new //TODO: Utility
		this.properties[13] = new Property("States Avenue", 140);
		this.properties[14] = new Property("Virginia Avenue", 160);
//		this.properties[15] = new //TODO: Railroad
		this.properties[16] = new Property("St James Place", 180);
//		this.properties[17] = new //TODO: Community chest
		this.properties[18] = new Property("Tennessee Avenue", 180);
		this.properties[19] = new Property("New York Avenue", 200);
//		this.properties[20] = new //TODO: Free parking
		this.properties[21] = new Property("Kentucky Avenue", 220);
//		this.properties[22] = new //TODO: Chance
		this.properties[23] = new Property("Indiana Avenue", 220);
		this.properties[24] = new Property("Illinois Avenue", 240);
//		this.properties[25] = new //TODO: Railroad
		this.properties[26] = new Property("Atlantic Avenue", 260);
		this.properties[27] = new Property("Ventnor Avenue", 260);
//		this.properties[28] = new //TODO: Utility
		this.properties[29] = new Property("Marvin Gardens", 280);
		this.properties[30] = new GoToJail("Go to Jail");
		this.properties[31] = new Property("Pacific Avenue", 300);
		this.properties[32] = new Property("North Carolina Avenue", 300);
//		this.properties[33] = new //TODO: Community chest
		this.properties[34] = new Property("Pennsylvania Avenue", 320);
//		this.properties[35] = new //TODO: Railroad
//		this.properties[36] = new //TODO: Chance
		this.properties[37] = new Property("Park Place", 350);
		this.properties[38] = new Tax("Luxury Tax", 100);
		this.properties[39] = new Property("Boardwalk", 400);
	}
}

