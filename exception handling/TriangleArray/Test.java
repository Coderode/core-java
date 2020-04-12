import java.util.*;
import java.lang.*;
class Test{
	public static void main(String args[]){
		Random ran=new Random();
		Random ran2=new Random();
		Random ran3=new Random();
		Set<Triangle> T=new HashSet<Triangle>();
		for(int i=1; i<=20; i++){
			int a,b,c;
			a=25;
			b=20;
			c=10;
			try{
			T.add(new Triangle(ran.nextInt(10),ran2.nextInt(10),ran3.nextInt(10)));
			}catch(Exception e){System.out.println(e);}
		}
		int j=1;
		for(Triangle i:T){
			System.out.println("Triangle No. "+j+":");
			System.out.println(i);
			System.out.println("Area= " +i.findArea());
			j++;
		}
	}
}
class Triangle{
	private int a;
	private int b;
	private int c;
	Triangle(int a,int b,int c) throws Exception{
		if(a+b >c && b+c > a && a+c > b){
			this.a=a;
			this.b=b;
			this.c=c;
		}else{
			throw new Exception("triangle sides not appropriate");
		}
	}
	void setSides(int a,int b,int c) throws Exception{
		if(a+b >c && b+c > a && a+c > b){
			this.a=a;
			this.b=b;
			this.c=c;
		}else{
			throw new Exception("triangle sides not appropriate");
		}
	}
	public String toString(){
		String s="";
		s+=String.valueOf(a);
		s+=",";
		s+=String.valueOf(b);
		s+=",";
		s+=String.valueOf(c);
		return s;
	}
	float findArea(){
		float s=(a+b+c)/2;
		return (float)Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
}