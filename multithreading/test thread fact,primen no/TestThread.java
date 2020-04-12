import java.math.*;
import java.util.*;
class TestThread{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		PrimeThread t1=new PrimeThread(n);
		FactorialThread t2=new FactorialThread(n);
		FibonacciThread t3=new FibonacciThread(n);
		t1.start();
		t2.start();
		t3.start();
	}
}
class PrimeThread extends Thread{
	int n;
	PrimeThread(int n){
		this.n=n;
	}
	public void run(){
		try{
			primeNumbers();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	void primeNumbers(){
		for(int i=1; i<=n; i++){
			boolean isprime=true;
			for(int j=2; j<=i/2; j++){
				if(i%j==0){
					isprime=false;
				}
			}
			if(isprime){
				System.out.println("\nprime:"+i);
			}
			try{
				Thread.sleep(100);
			
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
	
	
}
class FactorialThread extends Thread{
	int n;
	FactorialThread(int n){
		this.n=n;
	}
	public void run(){
		try{
			factorial();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	void factorial(){
		for(int i=1; i<=n; i++){
			//System.out.println("\nfact:");
			BigInteger fact=BigInteger.valueOf(1);
			for(int j=2; j<=i; j++){
				fact=fact.multiply(BigInteger.valueOf(j));
			}
			System.out.println("\nfactorial:"+i+"!="+fact);
			try{
				Thread.sleep(100);
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
	}
}
class FibonacciThread extends Thread{
	int n;
	FibonacciThread(int n){
		this.n=n;
	}
	public void run(){
		try{
			fibonacci();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	void fibonacci(){
		int f1=1;
		int f2=1;
		System.out.println("\nfibonacci :");
		System.out.print(f1+","+f2);
		for(int i=3; i<=n; i++){
			//System.out.println("\nfibonacci :");
			int f3=f1+f2;
			f1=f2;
			f2=f3;
			System.out.println("\nfibonacci:"+f3);
			try{
				Thread.sleep(100);
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
}