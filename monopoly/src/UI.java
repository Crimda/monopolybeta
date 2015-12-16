/**
 *
 * @author Brad
 */

public class UI
{

	private int horiSpacing = 1;
	private int vertSpacing = 1;

	private static String id2text(int id)
	{
		if (id == -1) return " ";
		else return ""+(id+1);
	}

	public static void fillBlanks(int cells)
	{ // Print spaces up to CELLS
		for (int i  = 0; i < cells; i++)
			System.out.print(" ");
	}

	public static void drawRow(GameState gs, int[] properties, String[] namemap, int[] typemap)
	{ // Draw either 10 properties or 2, depending on length of typemap
		/*
		 * For typemap:
		 * -1 == blank
		 *	0 == property
		 *	1 == chance
		 *	2 == com chest
		 *	3 == railroad
		 *	4 == utility
		 *	5 == tax
		 *	6 == go
		 *	7 == jail
		 *	8 == freeparking
		 *	9 == gotojail
		*/
		// Cell is 7 rows by 13 columns
		for (int x = 0; x < 11; x++)
		{ // Iterate over the 10 cells of this side, first row
			if (typemap[x] == -1)
			{
				fillBlanks(15);
				continue;
			}
			else
			{
				System.out.print("+============+ ");
			}
		}
		System.out.print("\n");
		for (int x = 0; x < 11; x++)
		{ // Second row, contains property name
			if (typemap[x] == -1)
			{
				fillBlanks(15);
				continue;
			}
			else
			{
				switch (typemap[x])
				{
					case 0:
						System.out.printf("| %s | ", namemap[x]);
						break;

					case 1:
						System.out.print("|            | ");
						break; // Draw chance on the next line

					case 2:
						System.out.print("|  Community | ");
						break;

					case 3:
						if (properties[x] == 5) // draw rest on next line
							System.out.print("|  Reading   | ");
						if (properties[x] == 15) // draw rest on next line
							System.out.print("| Pennsylva. | ");
						if (properties[x] == 25)
							System.out.print("|    B &O    | "); // draw rest on next line
						if (properties[x] == 35)
							System.out.print("| Short Line | ");
						break;

					case 4:
						if (properties[x] == 12) // draw rest on next line
							System.out.print("|  Electric  | ");
						if (properties[x] == 28) // draw rest on next line
							System.out.print("|    Water   | ");
						break;
					case 5:
						if (properties[x] == 4) // draw rest on next line
							System.out.print("|   INCOME   | ");
						if (properties[x] == 38) // draw rest on next line
							System.out.print("|   LUXURY   | ");
						break;
					case 6:
						System.out.print("|    G  O    | ");
						break;
					case 7:
						System.out.print("|  Visiting  | ");
						break;
					case 8:
						System.out.print("|    FREE    | ");
						break;
					case 9:
						System.out.print("|!   GTFO   !| ");
						break;
				}
			}
		}
		System.out.print("\n");
		for (int x = 0; x < 11; x++)
		{
			if (typemap[x] == -1)
			{
				fillBlanks(15);
				continue;
			}
			else
			{
				switch (typemap[x])
				{
					case 0:
						System.out.print("+============+ ");
						break;
					default:
						// Corners
						if (properties[x] == 0 ) System.out.print("|  <-------  | "); else
						if (properties[x] == 10) System.out.print("|J  +========+ "); else
						if (properties[x] == 20) System.out.print("|            | "); else
						if (properties[x] == 30) System.out.print("|     TO     | "); else
						// Community Chest
						if (properties[x] == 2 || properties[x] == 17 || properties[x] == 33)
							System.out.print("|    Chest   | "); else
						// Chance
						if (properties[x] == 7 || properties[x] == 22 || properties[x] == 36)
							System.out.print("|   CHANCE   | "); else
						// Railroads
						if (properties[x] == 5 || properties[x] == 15 || properties[x] == 25)
							System.out.print("|  Railroad  | "); else
						// Tax
						if (properties[x] == 4 || properties[x] == 38)
							System.out.print("|    Tax     | "); else
						// Utilities
						if (properties[x] == 12) System.out.print("|  Company   | "); else
						if (properties[x] == 28) System.out.print("|    Works   | ");
						break;
				}
			}
		}
		System.out.print("\n");
		for (int x = 0; x < 11; x++)
		{
			if (typemap[x] == -1)
			{
				fillBlanks(15);
				continue;
			}
			else
			{
				switch(typemap[x])
				{
					case 0:
						Space curProp = gs.properties[properties[x]];
						if (curProp.getHouses() == 0 && !curProp.getHotel())
							System.out.print("|            | "); else
						if (curProp.getHouses() == 1)
							System.out.print("|    H       | "); else
						if (curProp.getHouses() == 2)
							System.out.print("|    HH      | "); else
						if (curProp.getHouses() == 3)
							System.out.print("|    HHH     | "); else
						if (curProp.getHouses() == 4)
							System.out.print("|    HHHH    | "); else
						if (curProp.getHotel())
							System.out.print("|    [==]    | ");
						break;
					case 7:
						System.out.print("|U  |   In   | ");
						break;
					case 8:
						System.out.print("|  PARKING!  | ");
						break;
					default:
						System.out.print("|            | ");
						break;
				}
			}
		}
		System.out.print("\n");
		for (int x = 0; x < 11; x++)
		{
			if (typemap[x] == -1)
			{
				fillBlanks(15);
				continue;
			}
			else
			{
				if (typemap[x] == 7)
					System.out.print("|S  |");
				else
					System.out.print("|    ");

				// Minimum number of players is 2. You may not play with yourself.
				if (gs.playerCount >= 2)
				{
					if (gs.players[0].getPos() == properties[x])
						System.out.print("1");
					else
						System.out.print(" ");

					if (gs.players[1].getPos() == properties[x])
						System.out.print("2");
					else
						System.out.print(" ");
				}
				
				if (gs.playerCount >= 3)
				{
					if (gs.players[2].getPos() == properties[x])
						System.out.print("3");
					else
						System.out.print(" ");
				}
				else
					System.out.print(" ");

				if (gs.playerCount >= 4)
				{
					if (gs.players[3].getPos() == properties[x])
						System.out.print("4");
					else
						System.out.print(" ");
				}
				else
					System.out.print(" ");

				if (gs.playerCount >= 5)
				{
					if (gs.players[4].getPos() == properties[x])
						System.out.print("5");
					else
						System.out.print(" ");
				}
				else
					System.out.print(" ");

				if (gs.playerCount == 6)
				{
					if (gs.players[5].getPos() == properties[x])
						System.out.print("6");
					else
						System.out.print(" ");
				}
				else
					System.out.print(" ");
				
				System.out.print("  | ");
			}
		}
		System.out.print("\n");
		for (int x = 0; x < 11; x++)
		{
			if (typemap[x] == -1)
			{
				fillBlanks(15);
				continue;
			}
			else
			{
				Space curProp = gs.properties[properties[x]];
				switch (typemap[x])
				{
					case 3:
					case 4:
					case 0:
						System.out.printf("|%s   M", id2text(curProp.getOwnerID()));

						// Test if price is less than 100 and pad for missing 0
						if (curProp.getPrice() < 100)
							System.out.printf("%d ", curProp.getPrice());
						else
							System.out.printf("%d", curProp.getPrice());

						System.out.printf("   %s| ", id2text(curProp.getOwnerID()));
						break;

					case 5:
						System.out.printf("|  PAY M%d  | ", curProp.getTaxRate());
						break;

					case 7:
						System.out.print("|T  |  JAIL  | ");
						break;

					case 8:
						System.out.print("|   (OMG!)   | ");
						break;

					case 9:
						System.out.print("|!   JAIL   !| ");
						break;

					default:
						System.out.print("|            | ");
				}
			}
		}
		System.out.print("\n");
		for (int x = 0; x < 11; x++)
		{
			if (typemap[x] == -1)
			{
				fillBlanks(15);
				continue;
			}
			else
			{
				System.out.print("+============+ ");
			}
		}
		System.out.print("\n");
	}

	public static void drawMap2(GameState gs)
	{
		// this is counting 0 as top and 10 as bottom
		int[] row0_indexes = {20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
		String[] row0_namemap = {"", "Kent. Ave.", "", "Indi. Ave.", "Illi. Ave.", "", "Atla. Ave.", "Vent. Ave.", "", "Marvin Ga.", ""};
		int[] row0_typemap = {8, 0, 1, 0, 0, 3, 0, 0, 4, 0, 9};

		int[] row1_indexes = {19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31};
		String[] row1_namemap = {"New Y Ave.", "","","","","","","","", "", "Paci. Ave."};
		int[] row1_typemap = {0,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0};

		int[] row2_indexes = {18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32};
		String[] row2_namemap = {"Tenn. Ave.", "","","","","","","","", "", "N. C. Ave."};
		int[] row2_typemap = {0,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0};

		int[] row3_indexes = {17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33};
		String[] row3_namemap = {"", "","","","","","","","", "", ""};
		int[] row3_typemap = {2,-1,-1,-1,-1,-1,-1,-1,-1,-1, 2};

		int[] row4_indexes = {16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34};
		String[] row4_namemap = {"St. James ", "","","","","","","","", "", "Penn. Ave."};
		int[] row4_typemap = {0,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0};

		int[] row5_indexes = {15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35};
		String[] row5_namemap = {"", "","","","","","","","", "", ""};
		int[] row5_typemap = {3,-1,-1,-1,-1,-1,-1,-1,-1,-1, 3};

		int[] row6_indexes = {14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 36};
		String[] row6_namemap = {"Virg. Ave.", "","","","","","","","", "", ""};
		int[] row6_typemap = {0,-1,-1,-1,-1,-1,-1,-1,-1,-1, 1};

		int[] row7_indexes = {13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 37};
		String[] row7_namemap = {"Stat. Ave.", "","","","","","","","", "", "Park Place"};
		int[] row7_typemap = {0,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0};

		int[] row8_indexes = {12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 38};
		String[] row8_namemap = {"", "","","","","","","","", "", ""};
		int[] row8_typemap = {4,-1,-1,-1,-1,-1,-1,-1,-1,-1, 5};

		int[] row9_indexes = {11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39};
		String[] row9_namemap = {"St. Charl.", "","","","","","","","", "", "Board Walk"};
		int[] row9_typemap = {0,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0};

		int[] row10_indexes = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		String[] row10_namemap = {"", "Conn. Ave.", "Verm. Ave.", "", "Orie. Ave.", "", "", "Balt. Ave.", "", "Medi. Ave.", ""};
		int[] row10_typemap = {7, 0, 0, 1, 0, 3, 5, 0, 2, 0, 6};

		drawRow(gs, row0_indexes, row0_namemap, row0_typemap);
		drawRow(gs, row1_indexes, row1_namemap, row1_typemap);
		drawRow(gs, row2_indexes, row2_namemap, row2_typemap);
		drawRow(gs, row3_indexes, row3_namemap, row3_typemap);
		drawRow(gs, row4_indexes, row4_namemap, row4_typemap);
		drawRow(gs, row5_indexes, row5_namemap, row5_typemap);
		drawRow(gs, row6_indexes, row6_namemap, row6_typemap);
		drawRow(gs, row7_indexes, row7_namemap, row7_typemap);
		drawRow(gs, row8_indexes, row8_namemap, row8_typemap);
		drawRow(gs, row9_indexes, row9_namemap, row9_typemap);
		drawRow(gs, row10_indexes, row10_namemap, row10_typemap);
/*
		{ // Bottom row
			int[] indexes = {10, 9, 8, 7, 8, 7, 6, 5, 4, 3, 2, 1, 0};
			int[] typemap = {7, 0, 0, 1, 0, 3, 5, 0, 2, 0, 6};
			drawRow(gs, indexes, typemap);
		}
*/
	}

	public static void drawMap(GameState gs)
	{ // Currently a placeholder; TODO: Implement map logic
		System.out.print("+============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+\n");
		System.out.print("|    FREE    | | Kent. Ave. | |            | | Indi. Ave. | | Illi. Ave. | |    B&O     | | Atla. Ave. | | Vent. Ave. | |    Water   | | Marvin Ga. | |!   GTFO   !|\n");
		System.out.print("|            | +============+ |   CHANCE   | +============+ +============+ |  Railroad  | +============+ +============+ |    Works   | +============+ |     TO     |\n");

		// Hotels and or houses draw
		System.out.print("|  PARKING!  | |    ");
		for (int offset = 21; offset <= 30; offset++)
		{
			if (gs.properties[offset].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[offset].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}
			
			if (offset < 30)
				System.out.print("    | |    ");
		}
		System.out.print("    |\n");

		// Player Position Draw
		System.out.print("|    ");
		for (int offset = 20; offset <= 30; offset++)
		{
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == offset)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			if (offset < 30) // Helper as this line draws odd :/
				System.out.print("     | |    ");
		}
		System.out.print("     |\n");

		// I am ashamed of this line
		System.out.printf("|   (OMG!)   | |%s   M220    | |            | |%s   M220    | |%s   M240    | |%s   M200    | |%s   M260    | |%s   M260    | |%s   M150    | |%s   M280    | |!   JAIL   !|\n",
				id2text(gs.properties[21].getOwnerID()),
				id2text(gs.properties[23].getOwnerID()),
				id2text(gs.properties[24].getOwnerID()),
				id2text(gs.properties[25].getOwnerID()),
				id2text(gs.properties[26].getOwnerID()),
				id2text(gs.properties[27].getOwnerID()),
				id2text(gs.properties[28].getOwnerID()),
				id2text(gs.properties[29].getOwnerID()));
		System.out.print("+============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| New Y Ave. |                                                                                                                                        | Paci. Ave. |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");

		// Houses and hotels draw
		{ // For code folding
			// New York Ave.
			System.out.print("|    ");
			if (gs.properties[19].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[19].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}
		
			System.out.print("    |                                                                                                                                        ");
			
			// Pacific Ave.
			System.out.print("|    ");
			if (gs.properties[31].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[31].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}

			System.out.print("    |\n");
		}

		// Player Position Draw
		{ // For code folding
			// New York Ave.
			System.out.print("|    ");
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 19)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |                                                                                                                                        ");

			System.out.print("|    ");
			// Pacific Ave.
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 31)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |\n");
		}
		
		System.out.printf("|%s   M200    |                                                                                                                                        |%s   M300    |\n",
				id2text(gs.properties[19].getOwnerID()),
				id2text(gs.properties[31].getOwnerID())); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| Tenn. Ave. |                                                                                                                                        | N. C. Ave. |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");

		// Houses and hotels draw
		{ // For code folding
			// Tennessee Ave.
			System.out.print("|    ");
			if (gs.properties[18].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[18].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}
		
			System.out.print("    |                                                                                                                                        ");
			
			// North Carolina Ave.
			System.out.print("|    ");
			if (gs.properties[32].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[32].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}

			System.out.print("    |\n");
		}

		// Player Position Draw
		{ // For code folding
			// Tennessee Ave.
			System.out.print("|    ");
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 18)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |                                                                                                                                        ");

			System.out.print("|    ");
			// North Carolina Ave.
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 32)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |\n");
		}

		////////////////////////////////
		System.out.printf("|%s   M180    |                                                                                                                                        |%s   M300    |\n",
				id2text(gs.properties[18].getOwnerID()),
				id2text(gs.properties[32].getOwnerID()));
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|  Community |                                                                                                                                        |  Community |\n");
		System.out.print("|    Chest   |                                                                                                                                        |    Chest   |\n");
		System.out.print("|            |                                                                                                                                        |            |\n");
		////////////////////////////////
		
		// Player Position Draw
		{ // For code folding
			// Community Chest 2
			System.out.print("|    ");
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 17)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |                                                                                                                                        ");

			System.out.print("|    ");
			// Community Chest 3
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 33)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |\n");
		}

		////////////////////////////////
		System.out.print("|            |                                                                                                                                        |            |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| St. James  |                                                                                                                                        | Penn. Ave. |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		////////////////////////////////

		// Houses and hotels draw
		{ // For code folding
			// St James Place.
			System.out.print("|    ");
			if (gs.properties[16].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[16].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}
		
			System.out.print("    |                                                                                                                                        ");
			
			// Pennsylvania Ave.
			System.out.print("|    ");
			if (gs.properties[34].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[34].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}

			System.out.print("    |\n");
		}

		// Player Position Draw
		{ // For code folding
			// St. James Place
			System.out.print("|    ");
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 16)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |                                                                                                                                        ");

			System.out.print("|    ");
			// Pennsylvania Ave.
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 34)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |\n");
		}

		////////////////////////////////
		System.out.printf("|%s   M180    |                                                                                                                                        |%s   M220    |\n",
				id2text(gs.properties[16].getOwnerID()),
				id2text(gs.properties[34].getOwnerID()));
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| Pennsylva. |                                                                                                                                        | Short Line |\n");
		System.out.print("|  Railroad  |                                                                                                                                        |            |\n");
		System.out.print("|            |                                                                                                                                        |            |\n");
		////////////////////////////////

		// Player Position Draw
		{ // For code folding
			// Pennsylvania Railroad
			System.out.print("|    ");
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 15)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |                                                                                                                                        ");

			System.out.print("|    ");
			// Pennsylvania Ave.
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 35)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |\n");
		}
		
		////////////////////////////////
		System.out.printf("|%s   M200    |                                                                                                                                        |%s   M200    |\n",
				id2text(gs.properties[15].getOwnerID()),
				id2text(gs.properties[35].getOwnerID()));
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| Virg. Ave. |                                                                                                                                        |            |\n");
		System.out.print("+============+                                                                                                                                        |   CHANCE   |\n");
		////////////////////////////////

		// Houses and hotels draw
		{ // For code folding
			// Virginia Ave.
			System.out.print("|    ");
			if (gs.properties[16].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[16].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}
		
			System.out.print("    |                                                                                                                                        ");
			
			// Chanc
			System.out.print("|            |\n");
		}

		// Player Position Draw
		{ // For code folding
			// Virginia Ave.
			System.out.print("|    ");
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 14)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |                                                                                                                                        ");

			System.out.print("|    ");
			// Short Line
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 36)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |\n");
		}
		
		////////////////////////////////
		System.out.printf("|%s   M160    |                                                                                                                                        |            |\n",
				id2text(gs.properties[14].getOwnerID()));
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| Stat. Ave. |                                                                                                                                        | Park Place |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		////////////////////////////////

		// Houses and hotels draw
		{ // For code folding
			// States Ave.
			System.out.print("|    ");
			if (gs.properties[13].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[13].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}
		
			System.out.print("    |                                                                                                                                        ");
			
			// Park Place
			System.out.print("|    ");
			if (gs.properties[37].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[37].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}

			System.out.print("    |\n");
		}

		// Player Position Draw
		{ // For code folding
			// States Ave.
			System.out.print("|    ");
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 13)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |                                                                                                                                        ");

			System.out.print("|    ");
			// Park Place
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 37)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |\n");
		}

		////////////////////////////////
		System.out.printf("|%s   M140    |                                                                                                                                        |%s   M350    |\n",
				id2text(gs.properties[13].getOwnerID()),
				id2text(gs.properties[37].getOwnerID()));
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|  Electric  |                                                                                                                                        |   LUXURY   |\n");
		System.out.print("|  Company   |                                                                                                                                        |    TAX     |\n");
		System.out.print("|            |                                                                                                                                        |            |\n");
		////////////////////////////////

		{ // For code folding
			// Electric Company
			System.out.print("|    ");
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 12)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |                                                                                                                                        ");

			System.out.print("|    ");
			// Luxury Tax
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 38)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |\n");
		}

		////////////////////////////////
		System.out.printf("|%s   M150    |                                                                                                                                        |  PAY M100  |\n",
				id2text(gs.properties[12].getOwnerID())); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| St. Charl. |                                                                                                                                        | Board Walk |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		////////////////////////////////

		// Houses and hotels draw
		{ // For code folding
			// States Ave.
			System.out.print("|    ");
			if (gs.properties[11].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[11].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}
		
			System.out.print("    |                                                                                                                                        ");
			
			// Park Place
			System.out.print("|    ");
			if (gs.properties[39].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[39].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}

			System.out.print("    |\n");
		}

		{ // For code folding
			// St. Charles Place
			System.out.print("|    ");
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 11)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |                                                                                                                                        ");

			System.out.print("|    ");
			// Board Walk
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == 39)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			System.out.print("     |\n");
		}

		////////////////////////////////
		System.out.printf("|%s   M140    |                                                                                                                                        |%s   M400    |\n",
				id2text(gs.properties[11].getOwnerID()),
				id2text(gs.properties[39].getOwnerID()));
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+\n");
		System.out.print("|  Visiting  | | Conn. Ave. | | Verm. Ave. | |            | | Orie. Ave. | |  Reading   | |   INCOME   | | Balt. Ave. | |  Community | | Medi. Ave. | |    G  O    |\n");
		System.out.print("+J  +========+ +============+ +============+ |   CHANCE   | +============+ |  Railroad  | |     TAX    | +============+ |    Chest   | +============+ |  <------   |\n");

		System.out.print("|U  |   In   | |    ");
		for (int offset = 9; offset > -1; offset--)
		{
			if (gs.properties[offset].getHotel())
			{
				System.out.print("[==]");
			}
			else
			{
				int houseCount = gs.properties[offset].getHouses();

				if (houseCount == 0) System.out.print("    ");
				if (houseCount == 1) System.out.print("H   ");
				if (houseCount == 2) System.out.print("HH  ");
				if (houseCount == 3) System.out.print("HHH ");
				if (houseCount == 4) System.out.print("HHHH");
			}
			
			if (offset > 0)
				System.out.print("    | |    ");
		}
		System.out.print("    |\n");

		// Player Position Draw
		System.out.print("|S  |");
		for (int offset = 10; offset > -1; offset--)
		{
			for (int i = 0; i < gs.playerCount; i++)
			{
				if (gs.players[i].position == offset)
					System.out.print(i+1);
				else
					System.out.print(" ");
			}
			if (gs.playerCount < 3) System.out.print(" ");
			else if (gs.playerCount < 4) System.out.print(" ");

			if (offset > 0) // Helper as this line draws odd :/
				System.out.print("     | |    ");
		}
		System.out.print("     |\n");

//		System.out.print("|T  |  JAIL  | |1   M120   1| |1   M100   1| |            | |1   M100   1| |1   M200   1| |  PAY M200  | |1    M60   1| |            | |1    M60   1| |            |\n"); // TODO: Owner player slot
		System.out.printf("|T  |  JAIL  | |%s   M120    | |%s   M100    | |            | |%s   M100    | |%s   M200    | |  PAY M200  | |%s    M60    | |            | |%s    M60    | |            |\n",
				id2text(gs.properties[9].getOwnerID()),
				id2text(gs.properties[8].getOwnerID()),
				id2text(gs.properties[6].getOwnerID()),
				id2text(gs.properties[5].getOwnerID()),
				id2text(gs.properties[3].getOwnerID()),
				id2text(gs.properties[1].getOwnerID()));
		System.out.print("+==+=========+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+\n");
	}
	
	public static void drawMap()
	{ // Currently a placeholder; Draws an empty test map
		System.out.print("+============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+\n");
		System.out.print("|    FREE    | | Kent. Ave. | |            | | Indi. Ave. | | Illi. Ave. | |    B&O     | | Atla. Ave. | | Vent. Ave. | |    Water   | | Marvin Ga. | |!   GTFO   !|\n");
		System.out.print("|            | +============+ |            | +============+ +============+ |  Railroad  | +============+ +============+ |    Works   | +============+ |            |\n");
		System.out.print("|  PARKING!  | |            | |   CHANCE   | |            | |            | |            | |            | |    hhhh    | |            | |    [==]    | |     TO     |\n"); // TODO: hotels and houses line
		System.out.print("|    1234    | |    1234    | |    1234    | |    1234    | |    1234    | |    1234    | |    1234    | |    1234    | |    1234    | |    1234    | |            |\n"); // TODO: Player slots
		System.out.print("|   (OMG!)   | |1   M220   1| |            | |1   M220   1| |1   M240   1| |1   M200   1| |1   M260   1| |1   M260   1| |1   M150   1| |1   M280   1| |!   JAIL   !|\n"); // TODO: Owner player number slot
		System.out.print("+============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| New Y Ave. |                                                                                                                                        | Paci. Ave. |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: Player slots
		System.out.print("|1   M200   1|                                                                                                                                        |1   M300   1|\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| Tenn. Ave. |                                                                                                                                        | N. C. Ave. |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: Player slots
		System.out.print("|1   M180   1|                                                                                                                                        |1   M300   1|\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|  Community |                                                                                                                                        |  Community |\n");
		System.out.print("|    Chest   |                                                                                                                                        |    Chest   |\n");
		System.out.print("|            |                                                                                                                                        |            |\n");
		System.out.print("|            |                                                                                                                                        |            |\n");
		System.out.print("|            |                                                                                                                                        |            |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| St. James  |                                                                                                                                        | Penn. Ave. |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: Player slots
		System.out.print("|1   M180   1|                                                                                                                                        |1   M220   1|\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| Pennsylva. |                                                                                                                                        |   Short    |\n");
		System.out.print("|  Railroad  |                                                                                                                                        |    Line    |\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: Player slots
		System.out.print("|1   M200   1|                                                                                                                                        |1   M200   1|\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| Virg. Ave. |                                                                                                                                        |            |\n");
		System.out.print("+============+                                                                                                                                        |            |\n");
		System.out.print("|            |                                                                                                                                        |   CHANCE   |\n"); // TODO: hotels and houses line
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: Player slots
		System.out.print("|1   M160   1|                                                                                                                                        |            |\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| Stat. Ave. |                                                                                                                                        | Park Place |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: Player slots
		System.out.print("|1   M140   1|                                                                                                                                        |1   M350   1|\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|  Electric  |                                                                                                                                        |   LUXURY   |\n");
		System.out.print("|  Company   |                                                                                                                                        |    TAX     |\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: Player slots
		System.out.print("|1   M150   1|                                                                                                                                        |  PAY M100  |\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| St. Charl. |                                                                                                                                        | Board Walk |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: Player slots
		System.out.print("|1   M140   1|                                                                                                                                        |1   M400   1|\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+\n");
		System.out.print("|  Visiting  | | Conn. Ave. | | Verm. Ave. | |            | | Orie. Ave. | |  Reading   | |   INCOME   | | Balt. Ave. | |  Community | | Medi. Ave. | |            |\n");
		System.out.print("+J  +========+ +============+ +============+ |            | +============+ |  Railroad  | |     TAX    | +============+ |    Chest   | +============+ |    G  O    |\n");
		System.out.print("|U  |   IN   | |            | |            | |   CHANCE   | |            | |            | |            | |            | |            | |            | |  <------   |\n"); // TODO: hotels and houses line
		System.out.print("|S  |        | |            | |            | |            | |            | |            | |            | |            | |            | |            | |            |\n"); // TODO: Player slots
		System.out.print("|T  |  JAIL  | |1   M120   1| |1   M100   1| |            | |1   M100   1| |1   M200   1| |  PAY M200  | |1    M60   1| |            | |1    M60   1| |            |\n"); // TODO: Owner player slot
		System.out.print("+==+=========+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+\n");
	}
	
	public static void draw(String test)
	{
		System.out.println(test);
	}

	public static void clearScreen()
	{
		for (int i = 0; i < 100; i++)
			System.out.print("\n");
	}
}

