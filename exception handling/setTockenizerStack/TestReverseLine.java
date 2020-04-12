import java.util.*;
class TestReverseLine{
	public static void main(String args[]) throws Exception{
		String s="how are you";
		StringLine L=new StringLine(s);
		System.out.println("reverse of given line is : "+L.reverseLine());
		String s2="day mon mon mon day sun";
		StringLine L2= new StringLine(s2);
		System.out.println("after removing duplicates:"+L2.removeDuplicates());
	}
}

class StringLine{
	private String s;
	StringLine(String s){
		this.s=s;
	}
	String reverseLine(){
		StringTokenizer token = new StringTokenizer(s," ");
		Stack<String> s=new Stack<String>();
		while(token.hasMoreTokens()){
			s.push(token.nextToken());
		}
		String rev="";
		
		while(!s.empty()){
			rev+=s.pop();
			rev+=" ";
		}
		return rev;
	}
	String removeDuplicates(){
		StringTokenizer token = new StringTokenizer(s," ");
		Set<String> S=new HashSet<String>();
		while(token.hasMoreTokens()){
			String p=token.nextToken();
			S.add(p);
		}
		String set="";
		for(String i : S){
			set+=i;
			set+=" ";
		}
		return set;
	}
	
}