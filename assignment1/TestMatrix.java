//assignment #1
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
class TestMatrix{
	public static void main(String args[]){
		Matrix m1=null;
		Matrix m2=null;
		Matrix m3=null;
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag==true){
			
			System.out.print("\nmain menu for matrix operations\n================================================");
			System.out.print("\n1.create matrix\n2.display\n3.Addition of matrix 1 & 2\n4.Multiplication of matrix 1 & 2\n5.Exit");
			System.out.print("\nselect option:");
			int opt=sc.nextInt();
			
			switch(opt){
				case 1:
					boolean flag2=true;
					while(flag2==true){
						System.out.print("\n1.matrix 1\t2.matrix 2\t3.go to main menu\nselect option:");
						int opt2=sc.nextInt();
						switch(opt2){
							case 1:
								m1=new Matrix();
								m1.putRandomValues();
								break;
							case 2:
								m2=new Matrix();
								m2.putRandomValues();
								break;
							case 3:
								flag2=false;
								break;
							default:
								System.out.print("\nyou entered wrong option try again!\n");
						}
					}
					break;
				case 2:
					flag2=true;
					while(flag2==true){
						System.out.print("\n1.matrix 1\t2.matrix 2\t3.go to main menu\nselect option:");
						int opt3=sc.nextInt();
						switch(opt3){
							case 1:
								m1.display();
								break;
							case 2:
								m2.display();
								break;
							case 3:
								flag2=false;
								break;
							default:
								System.out.print("\nyou entered wrong option try again!\n");
						}
					}
					break;
				case 3:
					m3=m1.add(m2);
					System.out.println("want to display addition ? y or n:");
					char ans = sc.next(".").charAt(0);
					if(ans=='y' || ans == 'Y'){
						m3.display();
					}
					break;
				case 4:
					m3=m1.Multiply(m2);
					System.out.println("want to display multiplication ? y or n:");
					ans = sc.next(".").charAt(0);
					if(ans=='y' || ans == 'Y'){
						m3.display();
					}
					break;
				case 5:
					flag=false;
					break;
				default:
					System.out.print("\nyou entered wrong option try again!\n");
			}
		}
	}
}
class Matrix{
	int [][] a;
	int m; //no. of rows
	int n; //no. of columns
	Matrix(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of rows and columns: ");
		m=sc.nextInt();
		n=sc.nextInt();
	    a=new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				a[i][j]=0;
			}
		}
	}
	Matrix(int row,int cols){
		m=row;
		n=cols;
		a=new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				a[i][j]=0;
			}
		}
	}
	Matrix(int size){
		m=size;
		n=size;
	    a=new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				a[i][j]=0;
			}
		}
	}
	public void putRandomValues(){
		Random random=new Random();
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[i].length; j++){
				a[i][j]=random.nextInt(10);
			}
		}
	}
	public void display(){
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[i].length; j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	public Matrix add(Matrix b){
		Matrix d=new Matrix(m,n);
		if(m!=b.m || n!=b.n){
			System.out.println("Addition not possible! Size of matrix should be same!");
			return d;
		}
		long startTime=System.nanoTime();  //code being measured starts
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[i].length; j++){
				d.a[i][j]=a[i][j]+b.a[i][j];
			}
		}
		long endTime=System.nanoTime(); //code being measured ends
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds : "+timeElapsed);
		System.out.println("Execution time in milliseconds : "+timeElapsed / 1000000);
		System.out.print("\nAddition of matrix 1 and Matrix 2 is:\n");
		return d;
	}
	public Matrix Multiply(Matrix b){
		Matrix c=new Matrix(m,b.n);
		if(n!=b.m){
			System.out.println("Multiplication not possible! \nno. of cols of matrix 1 should be equal to the no. of rows of matrix2");
			return c;
		}
		long startTime=System.nanoTime();  //code being measured starts
		for(int i=0; i<m; i++){
			for(int j=0; j<b.n; j++){
				c.a[i][j]=0;
				for(int k=0; k<n; k++){
					c.a[i][j]=c.a[i][j]+a[i][k]*b.a[k][j];
				}
			}
		}
		long endTime=System.nanoTime(); //code being measured ends
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds : "+timeElapsed);
		System.out.println("Execution time in milliseconds : "+timeElapsed / 1000000);
		System.out.print("\nMultiplication of matrix 1 and Matrix 2 is:\n");
		return c;
	}
	
	
	
	
	/*	public void add(Matrix b){
		if(m!=b.m && n!=b.n){
			System.out.println("Addition not possible! Size of matrix should be same!");
			return;
		}
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[i].length; j++){
				a[i][j]=a[i][j]+b.a[i][j];
			}
		}
	}
	public void add(Matrix b,Matrix c){
		if(m!=b.m && n!=b.n){
			System.out.println("Addition not possible! Size of matrix should be same!");
			return;
		}
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[i].length; j++){
				a[i][j]=a[i][j]+b.a[i][j]+c.a[i][j];
			}
		}
	}
*/


/*public static void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	} */ 
	
}

