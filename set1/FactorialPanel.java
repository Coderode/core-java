import java.math.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout; 
 

public class FactorialPanel implements ActionListener
{
	JTextField tf1,tf2;
	JButton b;
	FactorialPanel(){
		JFrame f=new JFrame();
		JPanel panel = new JPanel();
		JPanel panel2=new JPanel();
		panel.setLayout(new FlowLayout()); 
		panel2.setLayout(new FlowLayout()); 		
        JLabel label = new JLabel("Enter a number:"); 
		JLabel label2 = new JLabel("Result:");		
		
		tf1=new JTextField();
		tf1.setBounds(50,100,400,30);  //(x,y,width,height)
		tf2=new JTextField();  
        tf2.setBounds(50,400,400,30);  
		tf2.setEditable(false);
		b=new JButton("Find Factorial");  
        b.setBounds(50,200,400,30); 
		b.addActionListener(this);
		
		panel2.add(label2);
		panel.add(label);
		panel.setBounds(50,50,400,30);
		panel2.setBounds(50,350,400,30);
		
		f.add(panel);
		f.add(tf1);
		f.add(b);
		f.add(panel2);
		
		f.add(tf2); 
        f.setSize(500,500);
		f.setLocationRelativeTo(null);	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);  
        f.setVisible(true); 
	}
	public void actionPerformed(ActionEvent e){
		String s1=tf1.getText();
		int x=Integer.parseInt(s1); 
		BigInteger fact =BigInteger.valueOf(1);
		if(e.getSource()==b){
			for(int i=1;i<=x;i++)
			{
				fact=fact.multiply(BigInteger.valueOf(i));
			}
		}
		String result = String.valueOf(fact);
		tf2.setText(result);
	}
	
	public static void main(String [] args)
	{
		new FactorialPanel();
	}
}