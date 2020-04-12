import java.util.*;
import java.util.concurrent.TimeUnit;
class TestThread{
	public static void main(String args[]){
		int n=500;
		int t=5;
		int value=40;
		LinearSearch L=new LinearSearch(n,t,value);
		L.generateThreads();
	}
}
class LinearSearch{
	int a[];
	int n;
	int t;
	int found;
	int index2;
	int value;
	LinearSearch(int n,int t,int value){
		Random ran=new Random();
		a=new int[n];
		for(int i=0; i<n; i++){
			a[i]=ran.nextInt(100);
		}
		this.n=n;
		this.t=t;
		found=false;
		index2=-1;
		this.value=value;
	}
	
	int Lsearch(int value){
		int index=-1;
		long startTime = System.nanoTime();
		for(int i=0; i<n; i++){
			if(a[i]==value){
				index= i;
			}
		}
		long endTime=System.nanoTime();
		long TimeTaken = endTime - startTime;
		System.out.println("Searching time in milliseconds: "+TimeTaken/1000000);
		return index;
	}
	void generateThreads(){
		threads arr[t];
		int low=0;
		int high=n/t;
		int tno;
		for(int i=0; i<5; i++){
			arr[i]=new Threads(low,high,value,tno);
			low=high+1;
			high=high+n/t;
		}
	}
}
class Threads extends LinearSearch{
	int l;
	int h;
	int value
	int tno;
	Threads(int l,int h,int value,int tno){
		this.l=l;
		this.h=h;
		this.value=value;
		this.tno=tno;
	}
	int search(int l,int h,int value){
		if(found==false){
			for(int i=l; i<=h; i++){
				if(a[i]==value){
					index=i;
					found=true;
				}
			} 
		}
		return index;
	}
	public void run(){
		try{
			System.out.println('thread no:'+tno);
			System.out.println('index:'+search(l,h,value));
		}catch(Exception e){
			System.out.println(e);
		}
	}
}