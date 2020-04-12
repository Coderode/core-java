import java.math.*;
import javax.swing.*;

class BInteger
{
	public static void main(String [] args)
	{
		BigInteger fact =BigInteger.valueOf(1);
		String input = JOptionPane.showInputDialog("Enter a number for Factorial");
		int x=Integer.parseInt(input);  
		
		for(int i=1;i<=x;i++)
		{
			fact=fact.multiply(BigInteger.valueOf(i));
		}
		JOptionPane.showMessageDialog(null,"Factorial is "+fact);
	}
}