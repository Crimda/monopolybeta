/**
 *
 * @author Brad
 */

import java.util.Scanner;

public class GameState
{
	public int playerCount;
	public Player[] players;
	public Space[] properties;

	public Scanner scnr;

	int turn = 0;

	public GameState(int playerCount)
	{
		this.scnr = new Scanner(System.in);
		this.playerCount = playerCount;
		this.players = new Player[playerCount];
		for (int i = 0; i < playerCount; i++)
		{
			this.players[i] = new Player(i, "Player " + (i + 1));
		}

		this.properties = new Space[40];

		this.properties[0] = new Go("GO");
		this.properties[1] = new Property("Mediteranean Avenue", 60, 2, 50, 50, 30, 10, 30, 90, 160, 250);
		this.properties[2] = new CommunityChest("Community Chest");
		this.properties[3] = new Property("Baltic Avenue", 60, 4, 50, 50, 30, 20, 60, 180, 320, 450);
		this.properties[4] = new Tax("Income Tax", 200);
		this.properties[5] = new Railroad("Reading Railroad", 100);
		this.properties[6] = new Property("Oriental Avenue", 100, 6, 50, 50, 50, 30, 90, 270, 400, 550);
		this.properties[7] = new Chance("Chance");
		this.properties[8] = new Property("Vermont Avenue", 100, 6, 50, 50, 50, 30, 90, 270, 400, 550);
		this.properties[9] = new Property("Connecticut Avenue", 120, 8, 50, 50, 60, 40, 100, 300, 450, 600);
		this.properties[10] = new Jail("Jail");
		this.properties[11] = new Property("St. Charles Place", 140, 10, 100, 100, 70, 50, 150, 450, 625, 750);
		this.properties[12] = new Utility("Electric Company", 75);
		this.properties[13] = new Property("States Avenue", 140, 10, 100, 100, 70, 50, 150, 450, 625, 750);
		this.properties[14] = new Property("Virginia Avenue", 160, 12, 100, 100, 80, 60, 180, 500, 700, 900);
		this.properties[15] = new Railroad("Pennsylvania Railroad", 100);
		this.properties[16] = new Property("St James Place", 180, 14, 100, 100, 90, 70, 200, 550, 750, 950);
		this.properties[17] = new CommunityChest("Community Chest");
		this.properties[18] = new Property("Tennessee Avenue", 180, 14, 100, 100, 90, 70, 200, 550, 750, 950);
		this.properties[19] = new Property("New York Avenue", 200, 16, 100, 100, 100, 80, 220, 600, 800, 1000);
		this.properties[20] = new FreeParking("Free Parking");
		this.properties[21] = new Property("Kentucky Avenue", 220, 18, 150, 150, 110, 90, 250, 700, 875, 1050);
		this.properties[22] = new Chance("Chance");
		this.properties[23] = new Property("Indiana Avenue", 220, 18, 150, 150, 110, 90, 250, 700, 875, 1050);
		this.properties[24] = new Property("Illinois Avenue", 240, 20, 150, 150, 120, 100, 300, 750, 925, 1100);
		this.properties[25] = new Railroad("B & O Railroad", 100);
		this.properties[26] = new Property("Atlantic Avenue", 260, 22, 150, 150, 130, 110, 330, 800, 975, 1150);
		this.properties[27] = new Property("Ventnor Avenue", 260, 22, 150, 150, 130, 110, 330, 800, 975, 1150);
		this.properties[28] = new Utility("Waterworks", 75);
		this.properties[29] = new Property("Marvin Gardens", 280, 24, 150, 150, 140, 120, 360, 850, 1025, 1200);
		this.properties[30] = new GoToJail("Go to Jail");
		this.properties[31] = new Property("Pacific Avenue", 300, 26, 200, 200, 150, 130, 390, 900, 1100, 1275);
		this.properties[32] = new Property("North Carolina Avenue", 300, 26, 200, 200, 150, 130, 390, 900, 1100, 1275);
		this.properties[33] = new CommunityChest("Community Chest");
		this.properties[34] = new Property("Pennsylvania Avenue", 320, 28, 200, 200, 160, 150, 450, 1000, 1200, 1400);
		this.properties[35] = new Railroad("Short Line", 100);
		this.properties[36] = new Chance("Chance");
		this.properties[37] = new Property("Park Place", 350, 35, 200, 200, 175, 175, 500, 1100, 1300, 1500);
		this.properties[38] = new Tax("Luxury Tax", 100);
		this.properties[39] = new Property("Boardwalk", 400, 50, 200, 200, 200, 200, 600, 1400, 1700, 2000);
	}
}

