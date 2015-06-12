package knowledge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class login {

	static JTextField setUserName = new JTextField();
	static JTextField setNumber = new JTextField();
	JLabel userName = new JLabel("姓名 : "); 
	JLabel number = new JLabel("學號 : ");
	
	login(){
		JFrame login = new JFrame();
		login.setTitle("do_u_want_to_play_a_game_?");
		login.setSize(350, 180);
		login.setLocationRelativeTo(null); // Center the frame
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setResizable(false);
		login.setLayout(null); 
		
		userName.setBounds(20, 20, 50, 30);
		login.add(userName);
		
		setUserName.setBounds(90,20, 150, 30);
		login.add(setUserName);
		
		number.setBounds(20, 80, 50, 30);
		login.add(number);
		
		setNumber.setBounds(90, 80, 150, 30);
		login.add(setNumber);
		
		JButton loginIn = new JButton("login in");
		loginIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(setUserName.getText().equals(""))
						setUserName.setText("無名氏");
					if(setNumber.getText().equals(""))
						setNumber.setText("xxx");
					if(setUserName.getText().length() > 6 || setNumber.getText().length() > 10){
						JOptionPane.showMessageDialog(null, "字串太長! 姓名不大於6字, 學號不大於10字!");
					}else{
						new knowledge(setUserName.getText(), setNumber.getText());
						login.dispose();
					}
				}
		});
		loginIn.setBounds(250, 80, 80, 30);
		login.add(loginIn);
		login.setVisible(true);
	}
}
