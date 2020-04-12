//Name - Sandeep rollno - 18MCA040
//assignment #1
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
class TestMatrix{
	public static void main(String args[]){
		//creating objects of Matrix class 
		Matrix m1=null;
		Matrix m2=null;
		Matrix m3=null;
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag==true){
			//displaying main menu
			System.out.print("\nmain menu for matrix operations\n================================================");
			System.out.print("\n1.create matrix\n2.display\n3.Addition of matrix 1 & 2\n4.Multiplication of matrix 1 & 2\n5.Exit");
			System.out.print("\nselect option:");
			int opt=sc.nextInt();
			//generating options
			switch(opt){
				//for creating matrix
				case 1:
					boolean flag2=true;
					while(flag2==true){
						System.out.print("\n1.matrix 1\t2.matrix 2\t3.go to main menu\nselect option:");
						int opt2=sc.nextInt();
						switch(opt2){
							//create matrix 1
							case 1:
								m1=new Matrix();  //calling constructor 
								m1.putRandomValues(); //putting random values
								break;
							//create matrix 2
							case 2:
								m2=new Matrix(); 
								m2.putRandomValues();
								break;
							//to go to main menu
							case 3:
								flag2=false;
								break;
							default:
								System.out.print("\nyou entered wrong option try again!\n");
						}
					}
					break;
				//for displaying matrices
				case 2:
					flag2=true;
					while(flag2==true){
						System.out.print("\n1.matrix 1\t2.matrix 2\t3.go to main menu\nselect option:");
						int opt3=sc.nextInt();
						switch(opt3){
							//matrix 1
							case 1:
								m1.display();
								break;
							//matrix 2
							case 2:
								m2.display();
								break;
							//for go to main menu
							case 3:
								flag2=false;
								break;
							default:
								System.out.print("\nyou entered wrong option try again!\n");
						}
					}
					break;
				//for addition
				case 3:
					m3=m1.add(m2);  //add
					System.out.println("want to display addition ? y or n:");  //display or not
					char ans = sc.next(".").charAt(0);
					if(ans=='y' || ans == 'Y'){
						m3.display();
					}
					break;
				//for multiplication
				case 4:
					m3=m1.Multiply(m2);  //multiply
					System.out.println("want to display multiplication ? y or n:");  //display or not
					ans = sc.next(".").charAt(0);
					if(ans=='y' || ans == 'Y'){
						m3.display();
					}
					break;
				//to exit from the program
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
	//declaring variables 
	int [][] a;  //2d array variable
	int m; //no. of rows
	int n; //no. of columns
	//constructor without parameter
	Matrix(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of rows and columns: ");
		m=sc.nextInt();  //enter rows
		n=sc.nextInt(); //enter cols
	    a=new int[m][n];  //providing memory to matrix
		//initializing matrix with zero
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				a[i][j]=0;
			}
		}
	}
	//constructor with 2 parameters
	Matrix(int row,int cols){
		m=row;
		n=cols;
		a=new int[m][n]; //allocating memory
		//initializing matrix with zero
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				a[i][j]=0;
			}
		}
	}
	//constructor with one parameter mainly for sqaure matirces
	Matrix(int size){
		m=size;
		n=size;
	    a=new int[m][n]; //allocating memory
		//initializing matrix with zero
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				a[i][j]=0;
			}
		}
	}
	//for generating matrix with random values
	public void putRandomValues(){
		Random random=new Random();
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[i].length; j++){
				a[i][j]=random.nextInt(10);
			}
		}
	}
	//for display of the matrix
	public void display(){
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[i].length; j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	//for addition of matrix
	public Matrix add(Matrix b){
		Matrix d=new Matrix(m,n);  //creating new matrix for storing addition matrix
		if(m!=b.m || n!=b.n){ 
			System.out.println("Addition not possible! Size of matrix should be same!");
			return d;
		}
		long startTime=System.nanoTime();  //code being measured starts
		//code to add
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
	//for multiplication of matrix
	public Matrix Multiply(Matrix b){
		Matrix c=new Matrix(m,b.n);  //creating new matrix for storing multiplied matrix
		if(n!=b.m){
			System.out.println("Multiplication not possible! \nno. of cols of matrix 1 should be equal to the no. of rows of matrix2");
			return c;
		}
		long startTime=System.nanoTime();  //code being measured starts
		//code to multiply
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
	
}

