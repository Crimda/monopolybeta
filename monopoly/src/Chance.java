/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brad
 */
public class Chance extends Space
{
    public Chance(String name) 
    {
        super(name);
    }

	@Override
	public void setHouses(int houses)
	{} // Disabled

	@Override
	public void setHotel(boolean yesno)
	{} // Disabled

    @Override
    public void action(Player player, Board board) 
    {
        System.out.println("You are ugly as hell and I am not standing for this any longer!");
    }
    
}

