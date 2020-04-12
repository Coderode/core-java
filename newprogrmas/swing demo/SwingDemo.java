import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class SwingDemo{
	public static void main(String args[]){
		JFrame f=new JFrame();
		f.getContentPane().setLayout(null);
		JLabel label1=new JLabel("Enter Username:");
		label1.setBounds(50,50,200,50);
		
		JTextField field1=new JTextField();
		field1.setEditable(true);
		field1.setBounds(50,100,200,50);
		
		JLabel label2=new JLabel("Enter Password:");
		label2.setBounds(50,150,200,50);
		
		JTextField field2=new JTextField();
		field2.setEditable(true);
		field2.setBounds(50,200,200,50);
		
		JTextField field3=new JTextField();
		field3.setEditable(false);
		field3.setBounds(50,320,200,120);
		
		
		JButton b=new JButton("Submit");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String username=field1.getText();
				String password=field2.getText();
				field3.setText("Username: "+username+"\n\nPassword: "+password);
			}
		});
		b.setBounds(50,260,200,40);
		
		
		
		
		//JPanel p=new JPanel();
		//.setBounds(0,0,400,500);
		f.add(field1);
		f.add(field2);
		f.add(label1);
		f.add(label2);
		f.add(field3);
		f.add(b);

		//.getContentPane().add(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,350,500);
		f.setVisible(true);
	}
}