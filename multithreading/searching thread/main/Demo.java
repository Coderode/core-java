
//write a java app for parallel linear search operation create a 1D array of huge size. & populate random data.
//now perform parallel search operation where the task of performing search in array should be divided into n subtasks where there are n 
//number of threads performing the search operation in the same array.
//test your program and compare its performance with the single threaded search.

import java.util.*;
import java.util.concurrent.TimeUnit;
class Demo{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements in the array :");
		int n=sc.nextInt(); //array size
		System.out.println("Enter number of threads to create :");
		int t=sc.nextInt(); //# no threads
		//SearchThread st[t];
		int start=0;
		int end=n/t;
		SearchThread.setSize(n);
		for(int i=0; i<t; i++){
			SearchThread st=new SearchThread(start,end,i+1);
			start=end+1;
			end=end+n/t;
			st.start();
		}
	}
}

class SearchThread extends Thread{
	static int data[],skey;
	static boolean found;
	int start,end,threadno;
	SearchThread(int start,int end,int threadno){
		this.start=start;
		this.end=end;
		this.threadno=threadno;
		found=false;
	}
	static void setSize(int n){
		Scanner sc=new Scanner(System.in);
		data = new int[n];
		//populate data
		Random ran=new Random();
		for(int i=0; i<n; i++){
			data[i]=ran.nextInt(100);
		}
		System.out.println("data induced");
		for(int i=0; i<n; i++){
			System.out.print(data[i]+" ");
		}
		//take search key
		System.out.println("Enter key to search:");
		skey=sc.nextInt();
	}
	public void run(){
		System.out.println("thread no. "+ threadno +" is searching");
		for(int i=start; i<=end; i++){
			if(found){
				break;
			}
			if(data[i]==skey){
				found=true;
				System.out.println("found at index: "+i+" first in thread no.: "+threadno);
				return;
			}
		}
	}
}
