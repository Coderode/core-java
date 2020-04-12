
import java.util.Scanner;
import java.lang.Math;
class Area{
	public static void main(String args[]){
		
		double Areaoftriangle=AreaOfTriangle();
		System.out.println("Area of Triangle is: "+Areaoftriangle);	
	}
	//area of triangle using heron's formula
	static double AreaOfTriangle(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter 3 sides of triangle :");
		System.out.println("a= ");
		float a=scanner.nextFloat();
		System.out.println("b= ");
		float b=scanner.nextFloat();
		System.out.println("c= ");
		float c=scanner.nextFloat();
		double area=0;
		float s=0;
		if(a+b>c && b+c>a && c+a>b){
			s=(a+b+c)/2;
			//System.out.println(s);
			area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
		}else{
			System.out.println("\nNot a valid triangle!");
		}
		return area;
	}
}