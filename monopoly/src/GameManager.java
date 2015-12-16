/**
 *
 * @author Brad
 */

//import java.util.Scanner;

public class GameManager
{
	GameState gs;

	int turnState = 0;
	int numAlivePlayers;

	// Per player tracking values
	int numDoubles = 0;

	boolean gameOver = false;
	boolean paidRentThisTurn = false;
	boolean paidJailFine = false;

	public GameManager()
	{
		this.gs = new GameState(2);
		this.numAlivePlayers = this.gs.players.length;
	}
	
	public void mainLoop()
	{
		while (!this.gameOver)
		{
			// Handle player turn swapping
			if (this.gs.turn > this.gs.players.length - 1)
				this.gs.turn = 0;

			if (this.gs.players[this.gs.turn].isBankrupt())
			{
				this.gs.turn += 1;
				continue;
			}

			if (this.numAlivePlayers == 1)
			{
				this.gameOver = true;
				break;
			}

			while (this.turnState != -1)
			{ // While not end of turn, do
				if (this.turnState == 0)
				{ // Handle pre-roll state
					// Update display (Pre-roll)
					UI.redraw(gs);

					if (this.gs.players[this.gs.turn].isBankrupt())
					{ // Handle player having 0 or less moneys
						System.out.println("You are bankrupt! Sell some properties or declare bankruptcy!");
						UI.prompt(gs);
						this.turnState = 10;
					} else

					if (this.gs.players[this.gs.turn].getInJail())
					{
						System.out.printf("You are in jail! You have made %d/3 escape attempts! What would you like to do?\n", this.gs.players[this.gs.turn].getEscapeAttempts());
						int attempts = this.gs.players[this.gs.turn].getEscapeAttempts();

						if (attempts == 0)
						{
							int choice = UI.getChoice(gs, "1 - Roll Dice\n2 - Pay Fine($50)\n3 - Use Get-Out-Of-Jail-Free Card\n4 - Manage Properties\n\t> ", 1, 4);
							if (choice == 1)
							{
								this.gs.players[this.gs.turn].incEscapeAttempts();
								int[] dieRoll = Dice.getRoll();
								if (dieRoll[0] == dieRoll[1])
								{
									this.gs.players[this.gs.turn].setInJail(false);
									this.gs.players[this.gs.turn].movePlayer(dieRoll[3]);
									this.numDoubles += 1;
									this.turnState = 2;
								}
								else
								{
									System.out.println("You failed to escape!");
									UI.prompt(gs);
									turnState = -1;
								}
							}
							if (choice == 2)
							{
								this.gs.players[this.gs.turn].takeMoney(50);
								this.gs.players[this.gs.turn].setInJail(false);
								this.turnState = -1;
							}
							if (choice == 3)
							{
								if (!this.gs.players[this.gs.turn].getEscapeCard())
								{
									System.out.println("You do not have an escape card!");
									UI.prompt(gs);
									continue;
								}
								
								System.out.println("You have an escape card, would you like to use it?");
								int subChoice = UI.getChoice(gs, "1 - Yes\n2 - No\n\t> ", 1, 2);

								if (subChoice == 1)
								{
									System.out.println("You used your escape card! FREEDOM!");
									this.gs.players[this.gs.turn].setEscapeCard(false);
									this.gs.players[this.gs.turn].setInJail(false);
									this.numDoubles = 0;
									this.turnState = 2;
								}
								else
									continue;
							}
							if (choice == 4)
								this.turnState = 10;
						}
						else
						{
							if (attempts == 3)
							{
								int choice = UI.getChoice(gs, "1 - Pay fine($50)\n2 - Manage Properties\n\t> ", 1, 2);
								if (choice == 1)
								{
									this.gs.players[this.gs.turn].takeMoney(50);
									this.gs.players[this.gs.turn].setInJail(false);
									this.turnState = -1;
									System.out.println("You pay your fine of $50.");
									UI.prompt(gs);
								}
								if (choice == 2)
									this.turnState = 10;
							}
							else
							{
								int choice = UI.getChoice(gs, "1 - Roll Dice\n2 - Manage Properties\n\t> ", 1, 2);
								if (choice == 1)
								{
									this.gs.players[this.gs.turn].incEscapeAttempts();
									int[] dieRoll = Dice.getRoll();
									if (dieRoll[0] == dieRoll[1])
									{
										this.gs.players[this.gs.turn].setInJail(false);
										this.gs.players[this.gs.turn].movePlayer(dieRoll[3]);
										this.numDoubles += 1;
										this.turnState = 2;
									}
									else
									{
										System.out.println("You fail to escape!");
										UI.prompt(gs);
									}
								}
								if (choice == 2)
									this.turnState = 10;
							}
						}
					}
					else
					{
						System.out.println("What would you like to do?");
						int choice = UI.getChoice(gs, "1 - Roll Dice\n2 - Manage Properties\n\t> ", 1, 2);
						
						if (choice == 1)
						{ // Handle player movement and doubles
							this.turnState = 1;
						} else
						if (choice == 2)
						{ // Manage properties for current player, referenced by turn number
							this.turnState = 10;
						}
					}
				} else

				if (this.turnState == 1)
				{ // Handle player movement and doubles
					if (this.gs.players[this.gs.turn].movePlayer())
					{
						this.numDoubles += 1;
						if (this.numDoubles == 3)
						{ // Forcibly end turn due to winding up in jail
							this.gs.players[this.gs.turn].setInJail(true);
							this.turnState = -1;
						}
					}
					else
						this.numDoubles = 0;
					this.turnState = 2;
				} else

				if (this.turnState == 2)
				{ // Handle post-roll things, such as buying current property, paying rent, and allowing property management, and end turn
					UI.redraw(gs);

					// Test if we landed on an owned property
					int ppos = this.gs.players[this.gs.turn].getPos();
					int ownerID = this.gs.properties[ppos].getOwnerID();

					System.out.println("You landed on " + this.gs.properties[ppos].getName());
					if (this.numDoubles > 0)
						System.out.printf("You rolled doubles! You have used %d/3 doubles up.\n", this.numDoubles);

					if (ownerID != -1 && ownerID != this.gs.players[this.gs.turn].getID())
					{ // Landed on another player's property. Pay rent if needed
						if (!this.paidRentThisTurn && !this.gs.properties[ppos].getMortgage())
						{
							if (ppos == 5 || ppos == 15 || ppos == 25 || ppos == 35)
							{ // Handle railroads
								int price = 0;
								switch(this.gs.players[ownerID].getRailroads())
								{
									case 1:
										price = 25;
										break;
									case 2:
										price = 50;
										break;
									case 3:
										price = 100;
										break;
									case 4:
										price = 200;
										break;
								}
								System.out.println("Paying due of $" + price + " to " + this.gs.players[ownerID].getName());
								this.gs.players[this.gs.turn].takeMoney(price);
								this.gs.players[ownerID].giveMoney(price);
							} else
							if (ppos == 12 || ppos == 28)
							{
								int price = 0;
								int mult = 0;
								switch(this.gs.players[ownerID].getUtilities())
								{
									case 1:
										mult = 4;
										break;
									case 2:
										mult = 10;
										break;
								}
								int[] dieRoll = Dice.getRoll();
								price = dieRoll[3]*mult;
								System.out.println("Paying due of $" + price + " to " + this.gs.players[ownerID].getName());
								this.gs.players[this.gs.turn].takeMoney(price);
								this.gs.players[ownerID].giveMoney(price);
							}
							else
							{
								System.out.println("Paying due of $" + this.gs.properties[ppos].getRent() + " to " + this.gs.players[ownerID].getName());
								this.gs.players[this.gs.turn].takeMoney(this.gs.properties[ppos].getRent());
								this.gs.players[ownerID].giveMoney(this.gs.properties[ppos].getRent());
								this.paidRentThisTurn = true;
							}
						}
					} else

					// Test if we landed on a tax property
					if (ppos == 4 || ppos == 38)
					{ // Handle taxing the fool
						this.gs.players[this.gs.turn].takeMoney(this.gs.properties[ppos].getTaxRate());
						this.paidRentThisTurn = true;
						System.out.printf("Bad luck, you got taxed for %s!\n", this.gs.properties[ppos].getTaxRate());
					} else

					// Test if we landed on go to jail
					if (ppos == 30)
					{ // Send this punk to jail
						this.gs.players[this.gs.turn].setInJail(true);
						System.out.println("GO TO JAIL!");
						UI.prompt(gs);
					} else

					// Test if we landed on chance
					if (ppos == 7 || ppos == 22 || ppos == 36)
					{
						int r = CommunityChest.getRng(); //use same random gen function
                        if (r == 1)
                        {
							this.gs.players[this.gs.turn].setInJail(true);
							System.out.println("YOU GO TO JAIL!");
							UI.prompt(gs);
                        }
                        if (r == 2)
                        {
							this.gs.players[this.gs.turn].setPos(0);
							System.out.println("You move to GO");
							UI.prompt(gs);
                        }
                        if (r == 3)
                        {
							this.gs.players[this.gs.turn].setPos(19);
							System.out.println("You go to New York for vacation");
							UI.prompt(gs);
                        }
                        else
                        {
                            System.out.println("You found money on the ground, you get $10!");
                            this.gs.players[this.gs.turn].money.addMoney(10);
                            UI.prompt(gs);
                        }
					} else

					// Test if we landed on community chest
					if (ppos == 2 || ppos == 17 || ppos == 33)
					{
						int r = CommunityChest.getRng();
						if (r == 1)
                        {
                            System.out.println("You won a crappy scratch-off, you get $25!");
                            this.gs.players[this.gs.turn].money.addMoney(25);
                            UI.prompt(gs);
                        }
                        if (r == 2)
                        {
                            System.out.println("You won a small lottery, you get $150!");
                            this.gs.players[this.gs.turn].money.addMoney(150); 
                            UI.prompt(gs);
                        }
                        if (r == 3)
                        {
                            System.out.println("A community chest is for the people, you pay your contribution of $100");
                            this.gs.players[this.gs.turn].money.subtractMoney(100); 
                            UI.prompt(gs);
                        }
                        
                        if (r > 3)
                        {
                            System.out.println("You save the life of a man named Bobby Gates. He thanks you with $500");
                            this.gs.players[this.gs.turn].money.addMoney(500); 
                            UI.prompt(gs);
                        }
					}

					System.out.println("What would you like to do?");
					if (numDoubles > 0)
					{
						if (this.gs.properties[ppos].getBuyable())
						{
							int choice = UI.getChoice(gs, "1 - Roll Again\n2 - Buy property\n3 - Manage Properties\n\t> ", 1, 3);
							if (choice == 1)
								this.turnState = 1;
							if (choice == 2)
							{ // Handle buying the property
								if (this.gs.players[this.gs.turn].buyProperty(this.gs.properties[ppos].getPrice()))
								{
									this.gs.properties[ppos].setOwnerID(this.gs.turn);
									this.gs.properties[ppos].setBuyable(false);

									System.out.println("You bought " + this.gs.properties[ppos].getName() + "!");
									UI.prompt(gs);
								}
								else
								{
									System.out.println("You don't have enough money to buy " + this.gs.properties[ppos].getName());
									UI.prompt(gs);
								}
							}
							if (choice == 3)
								this.turnState = 11;
						}
						else
						{
							int choice = UI.getChoice(gs, "1 - Roll Again\n2 - Manage Properties\n\t> ", 1, 2);
							if (choice == 1)
								this.turnState = 1;
							if (choice == 2)
								this.turnState = 11;
						}
					}
					else
					{
						if (this.gs.properties[ppos].getBuyable())
						{
							int choice = UI.getChoice(gs, "1 - Buy property\n2 - Manage Properties\n3 - End Turn\n\t> ", 1, 3);
							if (choice == 1)
							{
								if (this.gs.players[this.gs.turn].buyProperty(this.gs.properties[ppos].getPrice()))
								{
									this.gs.properties[ppos].setOwnerID(this.gs.turn);
									this.gs.properties[ppos].setBuyable(false);
									System.out.println("You bought " + this.gs.properties[ppos].getName() + "!");
									UI.prompt(gs);
								}
								else
								{
									System.out.println("You don't have enough money to buy " + this.gs.properties[ppos].getName());
									UI.prompt(gs);
								}
							}
							if (choice == 2)
								this.turnState = 11;
							if (choice == 3)
								this.turnState = -1;
						}
						else
						{
							int choice = UI.getChoice(gs, "1 - Manage Properties\n2 - End Turn\n\t> ", 1, 2);
							if (choice == 1)
								this.turnState = 11;
							if (choice == 2)
								this.turnState = -1;
						}
					}
				} else
				if (this.turnState == 10 || this.turnState == 11)
				{// if 10: go back to 0 on end, if 11: go back to 2 on end
					UI.redraw(gs);
					System.out.println("What do you want to do?");
					int choice = UI.getChoice(gs, "1 - Mortgage/Buy back a Property\n2 - Up/Down-grade a property\n3 - Declare Bankruptcy\n4 - Go Back\n\t> ", 1, 4);
					if (choice == 1)
					{// Handle generating a list of properties to mortgage
						System.out.println("Which would you like to do?");
						int subChoice = UI.getChoice(gs, "1 - Mortgage\n2 - Buy back\n3 - Cancel\n\t> ", 1, 3);
						if (subChoice == 1)
						{
							int propertyChoice = UI.chooseProperty(gs);
							if (propertyChoice == -1)
							{
								System.out.println("You do not own any properties!");
								UI.prompt(gs);
								continue;
							}

							if (this.gs.properties[propertyChoice].getHouses() > 0 || this.gs.properties[propertyChoice].getHotel())
							{
								System.out.println("You must sell all property upgrades before you can mortgage!");
								UI.prompt(gs);
								continue;
							}

							if (this.gs.properties[propertyChoice].getMortgage())
							{
								System.out.println("You cannot mortgage a property a second time >_>");
								UI.prompt(gs);
								continue;
							}

							System.out.println("You will get " + this.gs.properties[propertyChoice].getMortgageValue() + ", are you sure?");
							int finalChoice = UI.getChoice(gs, "1 - Yes\n2 - No\n\t> ", 1, 2);
							if (finalChoice == 1)
							{
								this.gs.properties[propertyChoice].setMortgage(true);
								this.gs.players[this.gs.turn].giveMoney(this.gs.properties[propertyChoice].getMortgageValue());
							}
							if (finalChoice == 2)
								continue;
						}
						if (subChoice == 2)
						{
							int propertyChoice = UI.chooseMortgagedProperty(gs);
							if (propertyChoice == -2)
							{
								System.out.println("You do not have any properties that can be unmortgaged!");
								UI.prompt(gs);
								continue;
							}

							if (propertyChoice == -1)
							{
								System.out.println("You do not own any properties!");
								UI.prompt(gs);
								continue;
							}

							if (!this.gs.properties[propertyChoice].getMortgage())
							{
								System.out.println("You cannot unmortgage a property that is not mortgaged >_>");
								UI.prompt(gs);
								continue;
							}

							System.out.println("You must pay " + (this.gs.properties[propertyChoice].getMortgageValue() + (this.gs.properties[propertyChoice].getMortgageValue() * 0.1)) + ", are you sure?");
							int finalChoice = UI.getChoice(gs, "1 - Yes\n2 - No\n\t> ", 1, 2);
							if (finalChoice == 1)
							{
								if (this.gs.players[this.gs.turn].buyProperty((int) Math.round(this.gs.properties[propertyChoice].getMortgageValue() + (this.gs.properties[propertyChoice].getMortgageValue() * 0.1))))
								{
									this.gs.properties[propertyChoice].setMortgage(false);
									System.out.println("You have bought back " + this.gs.properties[propertyChoice].getName() + "!");
									UI.prompt(gs);
								}
								else
								{
									System.out.println("You cannot afford to buy back " + this.gs.properties[propertyChoice].getName() + "!");
									UI.prompt(gs);
								}
							}
							if (finalChoice == 2)
								continue;
						}
						if (subChoice == 3)
							continue;
					}
					if (choice == 2)
					{// Handle generated a list of properties to upgrade
						System.out.println("Which would you like to do?");
						int subChoice = UI.getChoice(gs, "1 - Upgrade\n2 - Downgrade\n3 - Cancel\n\t> ", 1, 3);
						if (subChoice == 1)
						{
							int propertyChoice = UI.chooseUpgradableProperty(gs);
							if (propertyChoice == -1)
							{
								System.out.println("You do not own any properties!");
								UI.prompt(gs);
								continue;
							}

							UI.redraw(gs);
							if (this.gs.properties[propertyChoice].getHotel())
							{
								System.out.println("You cannot upgrade this property any further!");
								UI.prompt(gs);
								continue;
							} else
							if (this.gs.properties[propertyChoice].getHouses() == 4)
							{// Handle hotel
								System.out.println("This property has 4 houses. Would you like to upgrade to a hotel?");
								System.out.println("This will cost you $" + this.gs.properties[propertyChoice].getHotelCost());
								int finalChoice = UI.getChoice(gs, "1 - Yes\n2 - No\n\t> ", 1, 2);
								if (finalChoice == 1)
								{// Deduct money and upgrade property with hotel
									this.gs.players[this.gs.turn].takeMoney(this.gs.properties[propertyChoice].getHotelCost());
									this.gs.properties[propertyChoice].setHotel(true);
									this.gs.properties[propertyChoice].setHouses(0);
									continue;
								}
							}
							else
								System.out.println("This property presently has " + this.gs.properties[propertyChoice].getHouses() + " houses. Would you like to upgrade it?");
								System.out.println("This will cost you $" + this.gs.properties[propertyChoice].getHouseCost());

							int finalChoice = UI.getChoice(gs, "1 - Yes\n2 - No\n\t> ", 1, 2);
							if (finalChoice == 1)
							{// Deduct money and upgrade property with house
								this.gs.players[this.gs.turn].takeMoney(this.gs.properties[propertyChoice].getHouseCost());
								this.gs.properties[propertyChoice].setHouses(this.gs.properties[propertyChoice].getHouses() + 1);
								continue;
							}
						}
						if (choice == 2)
						{
							int propertyChoice = UI.chooseUpgradableProperty(gs);
							if (propertyChoice == -1)
							{
								System.out.println("You do not own any properties!");
								UI.prompt(gs);
								continue;
							}

							UI.redraw(gs);
							if (this.gs.properties[propertyChoice].getHouses() <= 0 && !this.gs.properties[propertyChoice].getHotel())
							{
								System.out.println("You cannot downgrade this property any further!");
								UI.prompt(gs);
								continue;
							} else
							if (this.gs.properties[propertyChoice].getHotel())
							{// Handle hotel
								System.out.println("This property has a hotel. Would you like to downgrade to 4 houses?");
								System.out.println("You will recieve $" + Math.round(this.gs.properties[propertyChoice].getHotelCost()/2));
								int finalChoice = UI.getChoice(gs, "1 - Yes\n2 - No\n\t> ", 1, 2);
								if (finalChoice == 1)
								{// Add money and downgrade to 4 houses
									this.gs.players[this.gs.turn].giveMoney((int) Math.round(this.gs.properties[propertyChoice].getHotelCost()/2));
									this.gs.properties[propertyChoice].setHotel(false);
									this.gs.properties[propertyChoice].setHouses(4);
									continue;
								}
							}
							else
							{
								System.out.println("This property presently has " + this.gs.properties[propertyChoice].getHouses() + " houses. Would you like to downgrade it?");
								System.out.println("You will recieve $" + Math.round(this.gs.properties[propertyChoice].getHouseCost()/2));
								int finalChoice = UI.getChoice(gs, "1 - Yes\n2 - No\n\t> ", 1, 2);
								if (finalChoice == 1)
								{// Add money and take a house from the property
									this.gs.players[this.gs.turn].giveMoney((int) Math.round(this.gs.properties[propertyChoice].getHouseCost()/2));
									this.gs.properties[propertyChoice].setHouses(this.gs.properties[propertyChoice].getHouses() - 1);
								}
							}
						}
						if (choice == 3)
							continue;
					}
					if (choice == 3)
					{// Handle declaring bankruptcy
						// Remove all properties owned by the player
						for (int i = 0; i < 40; i++)
						{
							if (this.gs.properties[i].getOwnerID() == this.gs.turn)
								this.gs.properties[i].setOwnerID(-1);
						}
						this.numAlivePlayers -= 1;
						this.gs.players[this.gs.turn].setBankrupt();
						this.turnState = -1;
					}
					if (choice == 4)
					{// Bake a cake I mean go back. Yeah. That.
						if (this.turnState == 10) this.turnState = 0;
						if (this.turnState == 11) this.turnState = 2;
					}
				}
			}

			// Reset for the next turn
			this.gs.turn += 1;
			this.paidRentThisTurn = false;
			this.turnState = 0;
			this.numDoubles = 0;
		}
		UI.clearScreen();
		System.out.printf("%s Wins!\n", this.gs.players[this.gs.turn].getName());
		UI.prompt(gs);
	}
}
