import java.util.Scanner;
class SearchKey{
	public static void main(String args[]){
		Scanner scanner=new Scanner(System.in);
		System.out.println("\nEnter the size of the array:");
		int n=scanner.nextInt();
		int[] array=new int[n];
		for(int i=0; i<n; i++){
			System.out.println("\nEnter element "+(i+1)+":");
			array[i]=scanner.nextInt();
		}
		System.out.println("\nThe array formed is:\n");
		System.out.print("[");
		for(int i=0; i<n; i++){
			System.out.print(array[i]+",");
		}
		System.out.print("\b]");
		char ans;
		do{
			System.out.println("\nEnter element to search in the array:");
			int x=scanner.nextInt();
			int i;
			for(i=0; i<n; i++){
				if(array[i]==x){
					System.out.println("\n"+x+" is at position "+(i+1));
					break;
				}
			}
			if(i==n){
				System.out.println("\n"+x+" is not present in the array");
			}
			
			System.out.println("\nDo you want to continue? y or n");
			ans=scanner.next().charAt(0);
			
		}while(ans=='y');
	}
}