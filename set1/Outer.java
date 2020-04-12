//import java.util.Scanner;
//nested class at 3 level
class Outer{
	int outerx=10;
	public void display(){
		System.out.println("outer class output");
		System.out.println("outerX="+outerx);
		Inner1 inner1=new Inner1();
		System.out.println("inner1 class output");
		inner1.display();
		//Inner2 inner2=new Inner2();  it is not accessible from Outer class
		//inner2.display();
	}
	class Inner1{
		int inner1X=20;
		public void display(){
			System.out.println("outerX="+outerx);
			System.out.println("inner1X="+inner1X);
			System.out.println("inner2 class output");
			Inner2 inner2=new Inner2();
			inner2.display();
		}
		class Inner2{
			int inner2X=30;
			public void display(){
				System.out.println("outerX="+outerx);
				System.out.println("inner1X="+inner1X);
				System.out.println("inner2X="+inner2X);
			}
		}
	}
	public static void main(String args[]){
		Outer outer=new Outer();
		outer.display();
	}
}