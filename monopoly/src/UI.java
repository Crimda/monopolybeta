/**
 *
 * @author Brad
 */

public class UI
{
	public static void drawMap(GameState gs)
	{ // Currently a placeholder; TODO: Implement map logic
		System.out.print("+============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+\n");
		System.out.print("|    FREE    | | Kent. Ave. | |            | | Indi. Ave. | | Illi. Ave. | |    B&O     | | Atla. Ave. | | Vent. Ave. | |    Water   | | Marvin Ga. | |!   GTFO   !|\n");
		System.out.print("|            | +============+ |            | +============+ +============+ |  Railroad  | +============+ +============+ |    Works   | +============+ |            |\n");
		System.out.print("|  PARKING!  | |            | |   CHANCE   | |            | |            | |            | |            | |            | |            | |            | |     TO     |\n"); // TODO: hotels and houses line

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
				System.out.print("    | |    ");
		}
		System.out.print("    |\n");

		System.out.print("|   (OMG!)   | |1   M220   1| |            | |1   M220   1| |1   M240   1| |1   M200   1| |1   M260   1| |1   M260   1| |1   M150   1| |1   M280   1| |!   JAIL   !|\n"); // TODO: Owner player number slot
		System.out.print("+============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| New Y Ave. |                                                                                                                                        | Paci. Ave. |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line

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

			System.out.print("    |                                                                                                                                        ");

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

			System.out.print("    |\n");
		}
		
		System.out.print("|1   M200   1|                                                                                                                                        |1   M300   1|\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| Tenn. Ave. |                                                                                                                                        | N. C. Ave. |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line
		
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

			System.out.print("    |                                                                                                                                        ");

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

			System.out.print("    |\n");
		}

		////////////////////////////////
		System.out.print("|1   M180   1|                                                                                                                                        |1   M300   1|\n"); // TODO: Owner player slot
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

			System.out.print("    |                                                                                                                                        ");

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

			System.out.print("    |\n");
		}

		////////////////////////////////
		System.out.print("|            |                                                                                                                                        |            |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| St. James  |                                                                                                                                        | Penn. Ave. |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line
		////////////////////////////////

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

			System.out.print("    |                                                                                                                                        ");

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

			System.out.print("    |\n");
		}

		////////////////////////////////
		System.out.print("|1   M180   1|                                                                                                                                        |1   M220   1|\n"); // TODO: Owner player slot
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

			System.out.print("    |                                                                                                                                        ");

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

			System.out.print("    |\n");
		}
		
		////////////////////////////////
		System.out.print("|1   M200   1|                                                                                                                                        |1   M200   1|\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| Virg. Ave. |                                                                                                                                        |            |\n");
		System.out.print("+============+                                                                                                                                        |            |\n");
		System.out.print("|            |                                                                                                                                        |   CHANCE   |\n"); // TODO: hotels and houses line
		////////////////////////////////
		
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

			System.out.print("    |                                                                                                                                        ");

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

			System.out.print("    |\n");
		}
		
		////////////////////////////////
		System.out.print("|1   M160   1|                                                                                                                                        |            |\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| Stat. Ave. |                                                                                                                                        | Park Place |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line
		////////////////////////////////

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

			System.out.print("    |                                                                                                                                        ");

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

			System.out.print("    |\n");
		}

		////////////////////////////////
		System.out.print("|1   M140   1|                                                                                                                                        |1   M350   1|\n"); // TODO: Owner player slot
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

			System.out.print("    |                                                                                                                                        ");

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

			System.out.print("    |\n");
		}

		////////////////////////////////
		System.out.print("|1   M150   1|                                                                                                                                        |  PAY M100  |\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("| St. Charl. |                                                                                                                                        | Board Walk |\n");
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.print("|            |                                                                                                                                        |            |\n"); // TODO: hotels and houses line
		////////////////////////////////

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

			System.out.print("    |                                                                                                                                        ");

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

			System.out.print("    |\n");
		}

		////////////////////////////////
		System.out.print("|1   M140   1|                                                                                                                                        |1   M400   1|\n"); // TODO: Owner player slot
		System.out.print("+============+                                                                                                                                        +============+\n");
		System.out.println("");
		System.out.print("+============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+ +============+\n");
		System.out.print("|  Visiting  | | Conn. Ave. | | Verm. Ave. | |            | | Orie. Ave. | |  Reading   | |   INCOME   | | Balt. Ave. | |  Community | | Medi. Ave. | |            |\n");
		System.out.print("+J  +========+ +============+ +============+ |            | +============+ |  Railroad  | |     TAX    | +============+ |    Chest   | +============+ |    G  O    |\n");
		System.out.print("|U  |   IN   | |            | |            | |   CHANCE   | |            | |            | |            | |            | |            | |            | |  <------   |\n"); // TODO: hotels and houses line
		
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
				System.out.print("    | |    ");
		}
		System.out.print("    |\n");

		System.out.print("|T  |  JAIL  | |1   M120   1| |1   M100   1| |            | |1   M100   1| |1   M200   1| |  PAY M200  | |1    M60   1| |            | |1    M60   1| |            |\n"); // TODO: Owner player slot
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
}

