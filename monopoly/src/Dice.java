/**
 *
 * @author Brad
 * rolls 6 sided die and returns a number 
 */
import java.util.Random;

public class Dice 
{
    public static int[] getRoll() 
        {
        int[] roll = new int[3];
	Random rand = new Random();
        int r1 = 1+rand.nextInt(6);
        int r2 = 1+rand.nextInt(6);
	int combined = (r1 + r2); 
        roll[0] = r1; 
        roll[1] = r2; 
        roll[3] = combined; 
        return roll;
        }
        
}



