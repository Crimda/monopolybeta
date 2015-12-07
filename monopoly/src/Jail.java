/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brad
 */
public class Jail extends Space 
{   
    public Jail(String name) 
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
    System.out.println("I am placeholder, ignore");
    }
}
