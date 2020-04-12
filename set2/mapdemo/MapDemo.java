import java.util.*;
class MapDemo{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		HashMap<String,String> Users = new HashMap<String,String>();
		for(int i=0; i<1; i++){
			String userName=sc.next();
			String password=sc.next();
			Users.put(userName,password);
		}
		for(Map.Entry m:Users.entrySet()){
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
		System.out.println("Enter a key name :");
		String key=sc.next();
		if(Users.containsKey(key))
			System.out.println(key);
		else
			System.out.println("does not exist");
	}
}