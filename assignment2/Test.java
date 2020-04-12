//Name - Sandeep (18MCA040)
//assignment#2(constructor ,inheritance)
//
import java.util.Scanner;
import java.lang.*;
//testing class 
class Test{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int opt;
		while(true){
			//creating main menu
			System.out.println("============main menu===========");
			System.out.println("1.Directed graph\n2.Weighted graph\n3.exit\nSelect option:");
			opt=sc.nextInt();
			boolean flag;
			switch(opt){
				case 1:
					flag=true;
					DirectedGraph D=null;
					while(flag){
						//submenu for directed graph
						System.out.println("1.create graph\t2.display\t3.Indegree\t4.Outdegree\t5.isConnected\n6.Go to main menu\nSelect option:");
						opt=sc.nextInt();
						switch(opt){
							case 1:
								D=new DirectedGraph();
								break;
							case 2:
								System.out.println("Directed Graph adjacency matrix:");
								D.display();
								break;
							case 3:
								D.indegree();
								break;
							case 4:
								D.outdegree();
								break;
							case 5:
								if(D.isConnected() == true){
									System.out.println("**** Yes,Graph is connected! ****");
								}else{
									System.out.println("**** No, Graph is not connected! ****");
								}
								break;
							case 6:
								flag=false;
								break;
							default:
								System.out.println("You entered wrong option try again!");
						}
					}
					break;
				case 2:
					flag=true;
					WeightedGraph W=null;
					while(flag){
						//submenu for weighted graph
						System.out.println("1.create graph\t2.display\t3.isConnected\t4.ShortestPath(n1,n2)\n5.Go to main menu\nSelect option:");
						opt=sc.nextInt();
						switch(opt){
							case 1:
								W=new WeightedGraph();
								break;
							case 2:
								System.out.println("Weighted Graph adjacency matrix:");
								W.display();
								break;
							case 3:
								if(W.isConnected() == true){
									System.out.println("**** Yes,Graph is connected! ****");
								}else{
									System.out.println("**** No, Graph is not connected! ****");
								}
								break;
							case 4:
							//for shortest path between v1 and v2
								System.out.println("Enter vertices to find shortest path between them: ");
								System.out.print("\nfirst Vertex no:");
								int v1=sc.nextInt();
								System.out.print("\nsecond Vertex no :");
								int v2=sc.nextInt();
								W.shortestPath(v1,v2);
								break;
							case 5:
								flag=false;
								break;
							default:
								System.out.println("You entered wrong option try again!");
						}
					}
					break;
				case 3:
				//exit
					System.exit(0);
				default:
					System.out.println("You entered wrong option try again!");
			}
			
		}
	}
}
//abstract for method isConnected
//main graph class
abstract class Graph{
	int adjmatrix[][]; //adjacency matrix
	int v;  //no of vertices
	//default constructor
	Graph(){
		System.out.println("Enter number of vertices: ");
		Scanner sc=new Scanner(System.in);
		v=sc.nextInt();
		adjmatrix = new int[v][v];
		//initializing with 0
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				adjmatrix[i][j]=0;
			}
		}
	}
	//parameterised constructor
	Graph(int v){
		this.v=v;
		adjmatrix=new int[v][v];
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				adjmatrix[i][j]=0;
			}
		}
	}
	//the display function generic
	void display(){
		for(int i=0; i<adjmatrix.length; i++){
			for(int j=0; j<adjmatrix[i].length; j++){
				System.out.print(adjmatrix[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	//abstract method
	abstract boolean isConnected();
}
//class for directed graph inherits Graph class
class DirectedGraph extends Graph{
	//default constructor 
	DirectedGraph(){
		super(); //calling constructor of parent class
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter values for Directed graph: ");
		System.out.println("Note : Enter 1 if there is an edge else 0 ");
		//taking values for connected edges
		//if connected then 1 else 0
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				if(i!=j){
				System.out.print("\nEdge between v"+(i+1)+"and v"+(j+1)+":");
				adjmatrix[i][j]=sc.nextInt();
				}else{
					adjmatrix[i][j]=0;
				}
			}
		}
	}
	//show indegree of each vertex 
	void indegree(){
		//indegree of each node=sum of col values
		System.out.println("Vertex	Indegree");
		for(int i=0; i<v; i++){
			int in=0;
			for(int j=0; j<v; j++){
				in=in+adjmatrix[j][i];
			}
			System.out.println("v"+(i+1)+"\t"+in);
		}
	}
	//show outdegree of each node
	void outdegree(){
		//outdegree of each node = sum of row values
		System.out.println("Vertex	Outdegree");
		for(int i=0; i<v; i++){
			int out=0;
			for(int j=0; j<v; j++){
				out=out+adjmatrix[i][j];
			}
			System.out.println("v"+(i+1)+"\t"+out);
		}
	}
	//to check weather graph is connected or not
	boolean isConnected(){
		//taking temporary array
		int temp[][]=new int[v][v];
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				temp[i][j]=adjmatrix[i][j];
			}
		}
		//warshal's algorithm to find connectivity
		for(int k=0; k<v; k++){
			for(int i=0; i<v; i++){
				for(int j=0; j<v; j++){
					if(temp[i][k]==1 && temp[k][j]==1){
						temp[i][j]=1;
					}
				}
			}
		}
		//checking if all are 1 or not
		//if found any one 0 then return false;
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				if(temp[i][j]==0){
					return false;
				}
			}
		}
		return true;
	}
}
//class for weighted graph inherits graph class
class WeightedGraph extends Graph{
	int Dist[][]; //to store  shortest distance between each pair of vertices
	int P[][];  //required for in floyd algorithm
	WeightedGraph(){
		super();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter values for Weighted graph: ");
		System.out.println("Note : if there is edge between vi and vj then enter its weight else enter big value(like 10000): ");
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				if(i!=j){
				System.out.print("\nEdge Between v"+(i+1)+"and v"+(j+1)+":");
				adjmatrix[i][j]=sc.nextInt();
				}else{
					adjmatrix[i][j]=0;
				}
			}
		}
		Dist=new int[v][v];
		P=new int[v][v];
		//initializing P with 0
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				P[i][j]=0;
			}
		}
		//initializing Dist to adjacency matrix
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				Dist[i][j]=adjmatrix[i][j];
			}
		}
	}
	//Floyd algorithm to find shortest distance between each pair of vertices
	void calFloyd(){
		for(int k=0; k<v; k++){
			for(int i=0; i<v; i++){
				for(int j=0; j<v; j++){
					if(Dist[i][j]>(Dist[i][k]+Dist[k][j])){
						Dist[i][j]=Dist[i][k]+Dist[k][j];
						P[i][j]=k+1;
					}
				}
			}
		}
	}
	//to show path trace
	void Path(int q,int r){
		if(P[q][r]!=0){
			Path(q,P[q][r]-1);
			System.out.print("V"+P[q][r]+"->");
			Path(P[q][r]-1,r);
		}
	}
	//to show path trace
	void shortestPath(int i,int j){
		calFloyd();
		i=i-1;
		j=j-1;
		System.out.println("Shortest path length (min weight): "+Dist[i][j]);
		System.out.print("\nPath : ");
		System.out.print("V"+(i+1)+"->");
		Path(i,j);
		System.out.print("V"+(j+1)+"\n");
	}
	//isconnected function for weighted graph
	boolean isConnected(){
		int temp[][]=new int[v][v];
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				if(adjmatrix[i][j]==10000 || adjmatrix[i][j]==0){
					temp[i][j]=0;
				}else{
				temp[i][j]=1;
				}
			}
		}
		//warshal's algorithm to find connectivity
		for(int k=0; k<v; k++){
			for(int i=0; i<v; i++){
				for(int j=0; j<v; j++){
					if(temp[i][k]==1 && temp[k][j]==1){
						temp[i][j]=1;
					}
				}
			}
		}
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				if(temp[i][j]==0){
					return false;
				}
			}
		}
		return true;	
	}
}