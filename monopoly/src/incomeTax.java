/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brad
 */
public class incomeTax extends Space
{
    public incomeTax(String name) 
    {
        super(name);
    }
	
    @Override
    public void action(Player player, Board board) 
    {
        System.out.println("Mmmm tax, you lose $200");
        player.getMoney().substractMoney(200);
    }
    
}
