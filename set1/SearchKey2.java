import java.util.Scanner;
public class SearchKey2{
	SearchKey2(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("\nEnter the size of the array:");
		int n=scanner.nextInt();
		int[] array=new int[n];
	}
	
	public static void main(String args[]){
		Methods S;
		char ans;
		S.input(array);
		S.display(array);
		do{
			System.out.println("\nEnter element to search in the array:");
			int x=scanner.nextInt();
			int index=S.Search(array,x);
			if(index != -1){
				System.out.println("\n"+x+" is at index"+index);
			}
			else{
				System.out.println("\n"+x+" is not present in the array");
			}
			
			System.out.println("\nDo you want to continue? y or n");
			ans=scanner.next().charAt(0);
			
		}while(ans=='y');
		System.out.println("\nSorted Array is:\n");
		S.selectionSort(array);
		S.display(array);
	}
}
class Methods{
	void input(int[] array[]){
		Scanner scanner=new Scanner(System.in);
		for(int i=0; i<array.length(); i++){
			System.out.println("\nEnter element "+(i+1)+":");
			array[i]=scanner.nextInt();
		}
	}
	void display(int[] array[]){
		System.out.println("\nThe array formed is:\n");
		System.out.print("[");
		for(int i=0; i<array.length(); i++){
			System.out.print(array[i]+",");
		}
		System.out.print("\b]");
	}
	int Search(int[] array[],int x){
		int index=-1;
		for(i=0; i<array.length(); i++){
				if(array[i]==x){
					index=i;
					break;
				}
			}
		return index;
	}
	void selectionSort(int[] array[]){
		for (int i=0; i<(array.length()-1); i++){
			int j=i;
			for(int k=i+1; k<array.length(); k++){
				if(array[k]<array[j]){
					j=k;
				}
			}
			if(i!= j){
				int temp=array[i];
				array[i]=array[j];
				array[j]=temp;
			}
		}
	}
}