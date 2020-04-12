import java.util.*;


class TestTriangle{
	public static void main(String args[]){
		try{
			Triangle T2=new Triangle();
			Triangle T=new Triangle(5,6,8);
			T2.setSides(1,2,3);
			System.out.println("area = "+T.findArea());
			System.out.println("perimeter = "+T.perimeter());
			System.out.println("area = "+T2.findArea());
			System.out.println("perimeter = "+T2.perimeter());
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
}
class InvalidTriangleException extends Exception{
	public String toString(){
		return "Invalid triangle sides!";
	}
}

class Triangle{
	private int a,b,c;
	Triangle(){}
	Triangle(int a,int b,int c) throws InvalidTriangleException{
		if(a+b > c && b+c >a && c+a >b){
			this.a=a;
			this.b=b;
			this.c=c;
		}else{
			throw new InvalidTriangleException();
		}
	}
	void setSides(int a,int b,int c) throws InvalidTriangleException{
		if(a+b > c && b+c >a && c+a >b){
			this.a=a;
			this.b=b;
			this.c=c;
		}else{
			throw new InvalidTriangleException();
		}
	}
	float findArea(){
		float s=(a+b+c)/2;
		return (float)Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	float perimeter(){
		return a+b+c;
	}
} 