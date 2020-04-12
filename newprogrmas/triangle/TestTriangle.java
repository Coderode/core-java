
import java.util.*;

class TestTriangle{
	public static void main(String args[]){
		ArrayList<Triangle> s=new ArrayList<Triangle>();
		Triangle t=new Triangle();
		t.setSides(5,6,2);
		s.add(t);
		Triangle t2=new Triangle();
		t2.setSides(5,6,2);
		s.add(t2);
		for(Triangle t3: s){
			System.out.println(t3);
			System.out.println("Area="+t3.findArea());
		}
	}
}

class Triangle{
	float a,b,c;
	Triangle(float a,float b,float c){
		if((a+b)>c && (b+c)>a && (c+a)>b){
			this.a=a;
			this.b=b;
			this.c=c;
		}else{
			System.out.println("NOt a triangle");
		}	
	}
	Triangle(){
		this.a=0;
		this.b=0;
		this.c=0;
	}
	boolean setSides(float a,float b,float c){
		if((a+b)>c && (b+c)>a && (c+a)>b){
			this.a=a;
			this.b=b;
			this.c=c;
			return true;
		}else{
			return false;
		}	
	}
	float findArea(){
		float s=(a+b+c)/2;
		return (float)Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	@Override
	public String toString(){
		return "a="+a+" b="+b+" c="+c;
	}
}