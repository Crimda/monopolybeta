/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brad
 */
public class LuxTax extends Space
{
    public LuxTax(String name) 
    {
        super(name);
    }
	
    @Override
    public void action(Player player, Board board) 
    {
        System.out.println("You have the misfortune of appearing wealthy, you lose $100");
        player.getMoney().substractMoney(100);
    }
    
}

