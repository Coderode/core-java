import java.util.regex.*;
import java.util.*;

class Registration{
	String loginId;
	String password;
	//String name;
	//String address,city,mobile,email;
	Registration(String login,String password){
		this.loginId=login;
		if(password.length() >= 8 && Pattern.matches("[a-zA-Z0-9]+",password)){
			this.password=password;
		}else{
			System.out.println("You provided invalid password!\nPassword must contain atleast one digit ,one uppercase letter,no space,size >=8");
		}
	}
	void display(){
		System.out.println("loginId="+loginId);
		System.out.println("password="+password);
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter loginId:");
		String loginId=sc.nextLine();
		System.out.println("Enter password:");
		String password=sc.nextLine();
		Registration r=new Registration(loginId,password);
		r.display();
	}
}