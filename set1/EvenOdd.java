import java.util.Scanner;
class EvenOdd{
	
	public static void main(String args[]){
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter a number to check even/odd : ");
		int num=scanner.nextInt();
		
		System.out.println("Is Even? : "+EvenChecker(num));
		float x,y,z;
		
		System.out.println("Enter 3 numbers to find their maximum : ");
		x=scanner.nextFloat();
		y=scanner.nextFloat();
		z=scanner.nextFloat();
		
		System.out.println("Maximum : "+Max.maximum(x,y,z));
		
	}
	static boolean EvenChecker(int n){
		if(n%2==0){
			return true;
		}else{
			return false;
		}
	}
}
class Max{
	static float maximum(float x,float y,float z){
		return x>y ? x>z ? x : z : y>z ? y : z;
	}
}