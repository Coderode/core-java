import java.util.Scanner;
class SumIntegerInString{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String s;
		int sum=0;
		System.out.println("Enter a string : ");
		s=sc.nextLine();
		System.out.println("sum of integers present in string : ");
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) > 47 && s.charAt(i) < 58){
				sum+=s.charAt(i)-48;
				System.out.print(s.charAt(i)-48+"+");
			}
		}
		System.out.print("\b="+sum);
	}
}