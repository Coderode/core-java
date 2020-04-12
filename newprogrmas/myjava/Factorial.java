package myjava;
import java.math.*;
import java.util.*;

public class Factorial{
	public static BigInteger factorial(int n){
		BigInteger fact=BigInteger.valueOf(1);
		for(int i=2; i<= n; i++){
			fact=fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}
}