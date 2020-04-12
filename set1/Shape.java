//static variables and functions
import java.util.Scanner;
import java.lang.Math;
import java.lang.*;
class Shape{
	static double findArea(double r){
		return (Math.PI*r*r);
	}
	static double findArea(double a,double b){
		return (a*b);
	}
	static double findArea(double a,double b,double c){
		if(a+b>c && b+c>a && a+c>b){
			double s=(a+b+c)/2.0;
			return (Math.sqrt(s*(s-a)*(s-b)*(s-c)));
		}else{
			return -1;
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("1.area of circle\n2.area of rectangle\n3.area of triangle\n4.exit\nSelect option:");
			int opt=sc.nextInt();
			switch(opt){
				case 1:
					float radius;
					System.out.println("Enter radius of circle:");
					radius=sc.nextFloat();
					System.out.println("Area of cirle="+Shape.findArea(radius));
					break;
				case 2:
					float a,b;
					System.out.println("Enter length and breadth of rectangle :");
					a=sc.nextFloat();
					b=sc.nextFloat();
					System.out.println("Area of rectangle="+Shape.findArea(a,b));
					break;
				case 3:
					float c,d,e;
					System.out.println("Enter the three sides of triangle:");
					c=sc.nextFloat();
					d=sc.nextFloat();
					e=sc.nextFloat();
					System.out.println("Area of triangle="+Shape.findArea(c,d,e));
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong option chosen try again!");
					break;
			}
		}
	}
}