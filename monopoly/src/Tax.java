/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brad
 */
public class Tax extends Space
{
	int taxAmount;

    public Tax(String name, int charge) 
    {
        super(name);
        this.taxAmount = charge;
    }
	
    @Override
    public void action(Player player, Board board) 
    {
        System.out.println("You have the misfortune of appearing wealthy, you lose $" + taxAmount);
        player.getMoney().subtractMoney(taxAmount);
    }
    
}

