// Sandeep (18MCA040)
import java.lang.reflect.Array;
import java.util.*;
import java.lang.Integer;
public class TestMatrix {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter no. of rows & cols:");
		int row=sc.nextInt();
		int col=sc.nextInt();
		Matrix<Integer> matint= new Matrix<Integer>(Integer.class,row,col);
		Matrix<Complex> matcom=new Matrix<Complex>(Complex.class,row,col);
		matint.populateData();
		matcom.populateData();
		System.out.println("Integer Matrix:");
		System.out.println(matint);
		System.out.println("Complex Matrix:");
		System.out.println(matcom);
		System.out.println("Array list of Matrix of Integer:");
		ArrayList<Matrix<Integer>> AL=new ArrayList<Matrix<Integer>>();
		for(int i=1; i<=20; i++){
			Matrix<Integer> m =new Matrix<Integer>(row,col);
			m.populateData();
			AL.add(m);
		}
		for(Matrix<Integer> m:AL){
			System.out.println(m);
		}
	}
}

class Matrix<T>{
	int m;
	int n;
	Object a[][];
	Class<T> c;
	Matrix(int row,int col){
		m=row;
		n=col;
		T[][] array=(T[][])new Object[m][n];
		a=array;
		//a=(T[][])Array.newInstance(Matrix.class,row,col); using reflect.Array
		//Matrix<?> //for any type
	}
	Matrix(Class<T> c,int row,int col){
		m=row;
		n=col;
		this.c = c;
		T[][] tmp = (T[][])Array.newInstance(c,row,col);// using reflect.Array
		a=tmp;
	}
	void populateData(){
		Random ran =new Random();
		if(a instanceof Complex[][]){
			for(int i=0; i<m; i++){
				for(int j=0; j<n ;j++){
					a[i][j]= new Complex(ran.nextInt(10),ran.nextInt(10));
				}
			}
		}else{
			for(int i=0; i<m; i++){
				for(int j=0; j<n ;j++){
					Object obj=new Object();
					obj=ran.nextInt(50);
					a[i][j]=obj;
				}
			}
		}
	}
	void input(){
		System.out.println("Enter values in the matrix : ");
		Scanner sc=new Scanner(System.in);
		for(int i=0; i<m; i++){
			for(int j=0; j<n ;j++){
				System.out.print("elment a("+(i+1)+","+(j+1)+"):");
				Object obj=new Object();
				obj=sc.next();
				a[i][j]=(T)obj;
			}
		}
	}
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("");
		for(int i=0; i<m; i++){
			for(int j=0; j<n ;j++){
				sb.append(String.valueOf(a[i][j])).append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
class Complex{
	float real;
	float comp;
	Complex(float a,float b){
		real=a;
		comp=b;
	}
	Complex(){
		Random ran=new Random();
		real=ran.nextFloat();
		comp=ran.nextFloat();
	}
	@Override
	public String toString(){
		return real+" + i"+comp;
	}
	public void input(){
		Random ran=new Random();
		real=ran.nextInt();
		comp=ran.nextInt();
	}
}