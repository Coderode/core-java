//  Sandeep (18MCA040)
//Palindrome substrings of a string without GUI
import java.util.Scanner;
import java.util.*;

class Palindrome{
	
	static void palindrome(String s){
		ArrayList<String> arrstr=new ArrayList<String>(); //to store palindromes
		//strings from 2 to length
		for(int i=2; i<=s.length(); i++){
			for(int j=0; j<s.length()-1; j++){
				if(j+i-1 >= s.length()){
					break;
				}
				String temp=s.substring(j,j+i);   //it takes substring from j to j+i-1
				if(isPalindrome(temp)){
					boolean found=false;
					//to check if it is already present then ignore it
					//to make every palindrome distinct
					for(int k=0; k<arrstr.size(); k++){
						if(arrstr.get(k).equals(temp)){
							found=true;
						}
					}
					//if not present then add it to array of string
					if(!found){
						arrstr.add(temp);
					};	
				}
			}
		}
		System.out.println(arrstr);
		Collections.sort(arrstr);
		System.out.println("All the distinct palindrome from the string are :");
		System.out.println(arrstr);
	}
	//is palindrome function
	static boolean isPalindrome(String str){
		int n=str.length()-1;
		boolean ispal=true;
		for(int i=0;  i<=str.length()/2; i++){
			if(str.charAt(i)!=str.charAt(n-i)){
				ispal=false;
				break;
			}
		}
		return ispal;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string to find distinct palindrome: ");
		String str=sc.nextLine();
		palindrome(str);
		
	}
}