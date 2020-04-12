//write a multithreaded java app for following tasks
//1.generate prime nos b/w 1 and n
//2.generate fibonacci series upto n
//3.factorial of all nos b/w 1 and n
//for each above task separate thread should compute the task concurrently . the main thread must wait untill all of its children threads
//sucessfully completes its tasks.

import java.math.*;

class PrimeThread extends Thread
{
	String tname;
	int n;
	PrimeThread(String name, int n)
	{
		tname=name;
		this.n=n;
	}
	
	public void run()
	{
	try{
		for(int i=1; i<=n; i++)
		{
			if(isPrime(i))
				System.out.println(tname + ": " + i);
			Thread.sleep(25);
		}
	}catch(Exception e) {}
	}
	
	private boolean isPrime(int n)
	{
		for(int i=2; i<=Math.sqrt(n); i++)
			if(n % i == 0)
				return false;
		return true;
	}
}

class FactorialThread extends Thread
{
	String tname;
	int n;
	FactorialThread(String name, int n)
	{
		tname=name;
		this.n=n;
	}
	
	public void run()
	{
	try{	
		for(int i=1; i<=n; i++)
		{
			System.out.println(tname + ": Factorial(" + i + ")=" + factorial(i));
			Thread.sleep(25);
		}
	} catch(Exception e) {}
	}
	
	private BigInteger factorial(int m)
	{
		 BigInteger f = new BigInteger("1"); 
        for (int i = 2; i <= m; i++) 
            f = f.multiply(BigInteger.valueOf(i)); 
  
        return f; 
	}
}

public class ThreadDemo
{
	public static void main(String args[])
	{
		PrimeThread primeThread = new PrimeThread("PrimeThread", 500);
		FactorialThread factorialThread = new FactorialThread("FactorialThread", 50);
		primeThread.start();
		factorialThread.start();
	}
}