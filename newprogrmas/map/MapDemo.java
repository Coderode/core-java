import java.util.*;

class MapDemo{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		Map<String,String> users=new HashMap<String,String>();
		for(int i=0; i<5; i++){
			System.out.println("user no :"+(i+1));
			System.out.println("Enter username :");
			String username=sc.nextLine();
			System.out.println("Enter password :");
			String password=sc.nextLine();
			users.put(username,password);
		}
		System.out.println("Displaying information :");
		System.out.print("|");
		System.out.printf("%20s %20s","Username|","Password|\n");
		System.out.println("-----------------------------------");
		for(Map.Entry m:users.entrySet()){
			System.out.print("|");
			System.out.printf("%20s %20s",m.getKey()+"|",m.getValue()+"|");
			System.out.println();
		}
	}
}