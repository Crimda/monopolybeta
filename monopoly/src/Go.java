/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brad
 */
public class Go extends Space 
{
    public Go(String name) 
    {
		super(name);
    }
	
	@Override
	public void setOwnerID(int id)
	{} // Disabled

	@Override
	public void setHouses(int houses)
	{} // Disabled

	@Override
	public void setHotel(boolean yesno)
	{} // Disabled
        
        @Override
	public void setMortgage(boolean yesno)
	{} // Disabled

    @Override
    public void action(Player player, Board board) 
    {
	System.out.println(player.getName() + " is at Go, get's 200. ");
        player.getMoney().addMoney(200); //add 200 to player's total 
    }
    
    //TODO: How to give for passing go and not landing? 
}

