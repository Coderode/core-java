import java.util.*;

class GenericArray{
	public static void main(String args[]){
		TwoDArray<Float> d=new TwoDArray<Float>(3,3);
		d.display();
	}
}
class TwoDArray<T>{
	Object a[][];
	int m,n;
	TwoDArray(int m,int n){
		this.m=m;
		this.n=n;
		T array[][]=(T[][])new Object[m][n];
		this.a=array;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				a[i][j]=0;
			}
		}
	}
	void display(){
		System.out.println();
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
}