package myjava;

public class PrimeNumber{
	public static boolean isPrime(int n){
		boolean isprime=true;
		for(int i=2; i<Math.sqrt(n); i++){
			if(n%i==0){
				isprime=false;
			}
		}
		return isprime;
	}
}