import java.util.*;


class GenericSwap{
	public static void main(String args[]){
		Pair<Integer> p=new Pair('5','8');
		p.display();
		p.swap();
		p.display();
	}
}

class Pair<T>{
	T x,y;
	Pair(T f,T s){
		x=f;
		y=s;
	}
	Pair(){
		x=null;
		y=null;
	}
	void swap(){
		T temp;
		temp=x;
		x=y;
		y=temp;
	}
	void display(){
		System.out.println("x="+x);
		System.out.println("y="+y);
	}
}



