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
		this.properties[1] = new Property("Mediteranean Avenue", 60, 2);
		this.properties[2] = new CommunityChest("Community Chest");
		this.properties[3] = new Property("Baltic Avenue", 60, 4);
		this.properties[4] = new Tax("Income Tax", 200);
		this.properties[5] = new Railroad("Reading Railroad");
		this.properties[6] = new Property("Oriental Avenue", 100, 6);
		this.properties[7] = new Chance("Chance");
		this.properties[8] = new Property("Vermont Avenue", 100, 6);
		this.properties[9] = new Property("Connecticut Avenue", 120, 8);
		this.properties[10] = new Jail("Jail");
		this.properties[11] = new Property("St. Charles Place", 140, 10);
		this.properties[12] = new Utility("Electric Company");
		this.properties[13] = new Property("States Avenue", 140, 10);
		this.properties[14] = new Property("Virginia Avenue", 160, 12);
		this.properties[15] = new Railroad("Pennsylvania Railroad");
		this.properties[16] = new Property("St James Place", 180, 14);
		this.properties[17] = new CommunityChest("Community Chest");
		this.properties[18] = new Property("Tennessee Avenue", 180, 14);
		this.properties[19] = new Property("New York Avenue", 200, 16);
		this.properties[20] = new FreeParking("Free Parking");
		this.properties[21] = new Property("Kentucky Avenue", 220, 18);
		this.properties[22] = new Chance("Chance");
		this.properties[23] = new Property("Indiana Avenue", 220, 18);
		this.properties[24] = new Property("Illinois Avenue", 240, 20);
		this.properties[25] = new Railroad("B & O Railroad");
		this.properties[26] = new Property("Atlantic Avenue", 260, 22);
		this.properties[27] = new Property("Ventnor Avenue", 260, 22);
		this.properties[28] = new Utility("Waterworks");
		this.properties[29] = new Property("Marvin Gardens", 280, 24);
		this.properties[30] = new GoToJail("Go to Jail");
		this.properties[31] = new Property("Pacific Avenue", 300, 26);
		this.properties[32] = new Property("North Carolina Avenue", 300, 26);
		this.properties[33] = new CommunityChest("Community Chest");
		this.properties[34] = new Property("Pennsylvania Avenue", 320, 28);
		this.properties[35] = new Railroad("Short Line");
		this.properties[36] = new Chance("Chance");
		this.properties[37] = new Property("Park Place", 350, 35);
		this.properties[38] = new Tax("Luxury Tax", 100);
		this.properties[39] = new Property("Boardwalk", 400, 50);
	}

}

