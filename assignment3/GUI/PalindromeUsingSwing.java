// Sandeep (18MCA040)
//Palindrome substrings of string  GUI based program
//
import java.util.Scanner;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeUsingSwing{
	public static void main(String args[]){
		new PalindromePanel();
	}
}
class PalindromePanel extends Frame implements ActionListener{
	JTextField tf1,tf2;
	JButton b;
	
	//Setting GUI layout and its elements
	PalindromePanel(){
		JFrame f=new JFrame("Palindrome");
		JLabel l1,l2;
		
		//label1
		l1=new JLabel("<html>Enter string to find its <br>Distinct Palindrome substrings:</html>");
		l1.setBounds(50,50,300,50);  //x,y,width,height
		//text field 1
		tf1=new JTextField();
		tf1.setBounds(50,120,300,50);
		//button
		b=new JButton("Find Palindromes");
		b.setBounds(50,255,300,40);
		b.addActionListener(this);
		//label2
		l2=new JLabel("Distinct Palindromes substrings are :");
		l2.setBounds(50,315,300,40);
		//text field 2 for result
		tf2=new JTextField();
		tf2.setBounds(50,365,300,40);
		tf2.setEditable(false);
		//handling with enter key
		
		
		
		//for scroll bar
		JScrollBar s=new JScrollBar(JScrollBar.HORIZONTAL);
		JPanel panel=new JPanel();
		panel.setBounds(50,405,300,20);
		panel.setBackground(Color.gray);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		BoundedRangeModel brm=tf2.getHorizontalVisibility();
		s.setModel(brm);
		panel.add(tf2);
		panel.add(s);
		f.add(panel);
		
		//adding elements to frame
		f.add(l1);f.add(l2);f.add(b); f.add(tf1); f.add(tf2);
		//dispaly the window
		f.setSize(400,600);  //width,height
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	//functions to calculate all palindrome substrings
	ArrayList<String> palindrome(String s){
		//taking array of string to add palindromes
		ArrayList<String> arrstr=new ArrayList<String>();
		//if string is empty
		if(s.equals("")){
			arrstr.add("");
			return arrstr;
		}
		//palindromes of length 2 to size of string
		for(int i=2; i<=s.length(); i++){
			for(int j=0; j<s.length()-1; j++){
				//if index overflows
				if(j+i-1 >= s.length()){
					break;
				}
				String temp=s.substring(j,j+i);  //take substring from j to j+i-1
				if(isPalindrome(temp)){
					boolean found=false;
					//checking if new palindrome is already exist or not
					for(int k=0; k<arrstr.size(); k++){
						if(arrstr.get(k).equals(temp)){
							found=true;
						}
					}
					//if not found then add to arry of string
					if(!found){
						arrstr.add(temp);
					};	
				}
			}
		}
		Collections.sort(arrstr);
		return arrstr;
	}
	//function to check a string is palindrome or not
	boolean isPalindrome(String str){
		int n=str.length()-1;
		boolean ispal=true;
		for(int i=0;  i<=str.length()/2; i++){
			if(str.charAt(i)!=str.charAt(n-i)){
				ispal=false;
				break;
			}
		}
		return ispal;
	}
	
	//action listner for the GUI on click of button 
	public void actionPerformed(ActionEvent e){
		String str=tf1.getText();
		ArrayList<String> list=new ArrayList<String>();
		String text="";
		if(e.getSource()== b){
			list=palindrome(str);	
		}
		for(int i=0 ; i<list.size(); i++){
			text=text+list.get(i)+", ";
		}
		tf2.setText(text.substring(0,text.length()-2));
	}
}

















