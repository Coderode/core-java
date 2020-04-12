// Sandeep (18MCA040)


//write a multithreaded java app for finding all the possible numbers of palindromes of size atleast 3 corrected in a given string . the string 
//will be given as input through a file and all the possible palindromes also has to be stored in a file.
//string is a human genome string containing ATGC
//eg. aabaa   3.1 billion characters are in human genome
//palindromes : aba,aabaa
//each thread will find palindromes of different sizes > 3,4,5...
//write block is synchronized :shared file - > synchronized


import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

class ThreadDemo{
	public static void main(String args[]) throws Exception{
		String s="";
		int psize=3;   //palindrome lower size
		
		//READING DATA FROM FILE 
		FileReader fr=new FileReader("dnaseq.dat");
		int i;
		while((i=fr.read())!= -1)
			s+=String.valueOf((char)i);
		fr.close();
		
		System.out.println("The given DNA sequence is : \n"+s+"\n\n");
		
		//EDITING IN OUTPUT FILE
		FileWriter fw= new FileWriter("outputfile.txt");
		fw.write("Plaindromes of size atleast 3 for input DNA sequence : "+s+" are:\n");
		fw.close();
		
		//CREATING THREADS OF LENGTH STARTING FROM 3 UPTO SIZE OF LENGTH OF STRING
		for(int j=psize; j<=s.length(); j++){
			//Thread.sleep(500);
			Palindrome P=new Palindrome(j,s);
			P.setName("thread with palindrome size "+ j +" is running...");
			P.start();
		}
		
		Thread.sleep(5000);
		
		
		Palindrome.showOutputFile();
	}
}


//CLASS OF PALINDROME
class Palindrome extends Thread{
	int psize;
	String s;
	Set<String> hash_set;

	Palindrome(int psize,String s){
		this.psize=psize;
		this.s=s;
		hash_set=new HashSet<String>();
	}
	@Override
	public void run(){
		try{
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName());
			palindromes();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	//METHOD TO FIND ALL PALINDROMES OF GIVEN SIZE IN A STRING
	void palindromes() throws IOException{
		for(int i=0; i<=s.length()-psize; i++){
			int j=psize+i;
			String p="";
			p=s.substring(i,j);
			if(isPalindrome(p)){
				if(hash_set.add(p)){
					System.out.println(p);
					//WRITING TO FILE THAT PALINDROME
					writeToFile(p);  //SYNCHRONIZED METHOD
				}
			}
		}
	}
	
	//METHOD TO CHECK WETHER A STRING IS PALINDROME OR NOT
	boolean isPalindrome(String p){
		boolean ispal=true;
		int last=p.length()-1;
		for(int i=0; i<=p.length()/2; i++){
			if(p.charAt(i) != p.charAt(last-i)){
				ispal=false;
			}
		}
		return ispal;
	}
	
	//METHOD TO SHOW THE OUTPUT FILE CONTENT
	static void showOutputFile() throws IOException{
		System.out.println("\n\nOutput file content : " );
		FileReader fr=new FileReader("outputfile.txt");
		int i;
		String out="";
		while((i=fr.read())!= -1)
			out+=String.valueOf((char)i);
		fr.close();
		System.out.println("The palindromes are  : \n"+out);
	}
	
	//METHOD TO WRITE IN THE OUTPUT FILE 
	//WHICH IS SYNCHRONIZED 
	synchronized void writeToFile(String p) throws IOException{
		FileWriter outputfile=new FileWriter("outputfile.txt",true);
		outputfile.write(p);
		outputfile.write("\n");
		outputfile.close();
	}
}