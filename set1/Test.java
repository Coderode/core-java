import java.util.*;

public class Test{
	public static void main(String args[]){
		Array<Integer> obj=new Array<Integer>(10);
		obj.add(10);
		obj.add(20);
		obj.add(30);
		obj.display();
	}
}
class Array<E>{
	Object[] a;
	int length;
	int size;
	public Array(int n){
		a=new Object[n];
		length=n;
		size=0;
	}
	public void add(int x){
		if(size>=length){
			System.out.println("no space");
			return;
		}
		//Integer intobj=new Integer(x);
		a[size]=x;
		size++;
	}
	public void display(){
		System.out.print("[");
		for(int i=0; i<size; i++){
			System.out.print(a[i]+", ");
		}
		System.out.print("\b\b]");
	}
}
