/**
 *
 * @author Brad
 * rolls 6 sided die and returns a number 
 */
import java.util.Random;

public class Dice 
{
    public int getRoll() 
        {
	Random rand = new Random();
	int roll = 1+rand.nextInt(6);
	return roll;
	}    
}



