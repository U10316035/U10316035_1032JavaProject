package knowledge;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class rival extends JFrame{
	JButton button1 = new JButton("曉闢骸");
	JButton button2 = new JButton("崑漢");
	JButton button3;
	JTextArea introduction1 = new JTextArea();
	JTextArea introduction2 = new JTextArea();
	JTextArea introduction3;
	JLabel pic1;
	JLabel pic2;
	JLabel pic3;
	int choose;
	
	int time;
	String user;
	String id;
	
	rival(String userName, String userId, int timeSet, long ccoin){
		time = timeSet;
		user = userName;
		id = userId;
		setTitle("choose_your_rival!");
		setSize(525, 475);
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLayout(null);
		
		
		button1.setBounds(30, 40, 150, 35);
		button1.setFont(new Font("標楷體", Font.BOLD, 18));
		button1.setForeground(Color.BLUE);
		add(button1);
		
		button2.setBounds(320, 40, 150, 35);
		button2.setFont(new Font("標楷體", Font.BOLD, 18));
		button2.setForeground(Color.BLUE);
		add(button2);
		
		
		introduction1.setBounds(30, 100, 225, 250);
		introduction1.setOpaque(false);
		introduction1.setEditable(false);
		//introduction1.setForeground(Color.CYAN);
		introduction1.setFont(new Font("標楷體", Font.BOLD, 20));
		add(introduction1);
		introduction1.setText("超煞氣@闢骸\n"
								+ "打輸會嗆你，\n贏了照樣嗆\n"
									+ "你有沒有信心打贏他呢?\n"
										+"擅長領域:動漫遊戲  \n"
											+ "強度: ");
		introduction2.setBounds(320, 100, 200, 250);
		introduction2.setOpaque(false);
		introduction2.setEditable(false);
		//introduction2.setForeground(Color.CYAN);
		introduction2.setFont(new Font("標楷體", Font.BOLD, 20));
		add(introduction2);
		introduction2.setText("爪哇島的大魔王\n"
								+ "究竟你這學期爪哇\n會不會被當呢?\n"
									+ "快來挑戰看看吧!\n"
										+"擅長領域:全領域 \n"
											+ "強度:*****");
		
		/*java.net.URL imgURL1 = rival.class.getResource("11.jpg");
		ImageIcon r1 = new ImageIcon(imgURL1);
		JLabel rival1 = new JLabel(r1);*/
		ImageIcon icon1 = new ImageIcon("image/11.jpg"); 
		pic1 = new JLabel(icon1);
		pic1.setBounds(30, 275, 150, 150);
		pic1.setFont(new Font("標楷體", Font.BOLD, 18));
		pic1.setForeground(Color.BLUE);
		add(pic1);
		
		/*java.net.URL imgURL2 = rival.class.getResource("2.jpg");
		ImageIcon r2 = new ImageIcon(imgURL1);
		JLabel rival2 = new JLabel(r2);*/
		ImageIcon icon2 = new ImageIcon("image/2.jpg"); 
		pic2 = new JLabel(icon2);
		pic2.setBounds(320, 275, 150, 150);
		pic2.setFont(new Font("標楷體", Font.BOLD, 18));
		pic2.setForeground(Color.BLUE);
		add(pic2);
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new knowledge(11,user,id,time,ccoin);
				dispose();
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new knowledge(2,user,id,time,ccoin);
				dispose();
			}
		});
	}
}
