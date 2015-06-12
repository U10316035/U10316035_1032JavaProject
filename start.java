package knowledge;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class start extends JFrame{
	JPanel start = new JPanel();
	JButton startGame = new JButton("開始遊戲");
	JButton set = new JButton("遊戲設定");
	JButton overGame = new JButton("結束遊戲");
	int time = 10;
	
	start(String user, String id){
		setBak1();
		add(start);
		start.setOpaque(false);
		setTitle("let's_party");
		setSize(270, 480);
		setLocationRelativeTo(null); // Center the frame
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		start.setLayout(null);
		
		startGame.setBounds(60, 180, 150, 30);
		startGame.setFont(new Font("標楷體", Font.BOLD, 16));
		start.add(startGame);
		
		set.setBounds(60, 225, 150, 30);
		set.setFont(new Font("標楷體", Font.BOLD, 16));
		start.add(set);
		
		overGame.setBounds(60, 270, 150, 30);
		overGame.setFont(new Font("標楷體", Font.BOLD, 16));
		start.add(overGame);
		
		startGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JFrame choose = new JFrame();
				JButton choose1 = new JButton("自我挑戰");
				JButton choose2 = new JButton("過關斬將");
				choose.setTitle("choose");
				choose.setSize(300, 100);
				choose.setLocationRelativeTo(null); // Center the frame
				//choose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				choose.setResizable(false);
				choose.setVisible(true);
				choose.setLayout(null);
				
				choose1.setBounds(15, 25, 125, 30);
				choose1.setFont(new Font("標楷體", Font.BOLD, 16));
				choose.add(choose1);
				
				choose2.setBounds(155, 25, 125, 30);
				choose2.setFont(new Font("標楷體", Font.BOLD, 16));
				choose.add(choose2);
				
				choose1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						new knowledge(0, time, user, id);
						choose.dispose();
						setVisible(false);
					}
				});
				
				choose2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						new knowledge(1, time, user, id);
						choose.dispose();
						setVisible(false);
					}
				});
			}
		});
		
		set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JFrame setGame = new JFrame();
				JButton time1 = new JButton("5秒");
				JButton time2 = new JButton("7秒");
				JButton time3 = new JButton("10秒");
				JLabel setTime = new JLabel("每題時間 : ");
				
				setGame.setTitle("set_time");
				setGame.setSize(255, 135);
				setGame.setLocationRelativeTo(null); // Center the frame
				//setGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setGame.setResizable(false);
				setGame.setVisible(true);
				setGame.setLayout(null);
				
				setTime.setBounds(77, 15, 135, 35);
				setTime.setFont(new Font("標楷體", Font.BOLD, 20));
				setGame.add(setTime);
				
				time1.setBounds(12, 65, 70, 25);
				time1.setFont(new Font("標楷體", Font.BOLD, 16));
				setGame.add(time1);
				
				time2.setBounds(90, 65, 70, 25);
				time2.setFont(new Font("標楷體", Font.BOLD, 16));
				setGame.add(time2);
				
				time3.setBounds(168, 65, 70, 25);
				time3.setFont(new Font("標楷體", Font.BOLD, 16));
				setGame.add(time3);
				
				time1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						time = 5;
						setGame.dispose();
					}
				});
				
				time2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						time = 7;
						setGame.dispose();
					}
				});
				
				time3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						time = 10;
						setGame.dispose();
					}
				});
				
			}
		});
		
		overGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
	}
	
	public void setBak1(){
		((JPanel)this.getContentPane()).setOpaque(false);
		/*java.net.URL imgURL = knowledge.class.getResource("1.jpg");
		ImageIcon img = new ImageIcon(imgURL);*/
		ImageIcon img = new ImageIcon("image/start.png");
		JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
}
