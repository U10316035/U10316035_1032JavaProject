package knowledge;

//import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class knowledge extends JFrame{
	int RandomQ;
	int who;
	challenge question = new challenge();
	int playerWhichCorrect;
	int playerWhichIncorrect;
	int rivalWhichCorrect;
	int rivalWhichIncorrect;

	long coin = 1000000;
	boolean win_lose = false;
	
	boolean[] checkQ = new boolean[10];
	
	boolean[] checkA = new boolean[4];
	
	
	int witchPay = 0;
	int whatQuestion;
	JFrame frameGame = new JFrame();
	JFrame frameMoney = new JFrame();
	JPanel panelSelcect = new JPanel();
	//JPanel panelQuestion = new JPanel();
	JLabel welcome = new JLabel("請選擇題庫 : ");
	JButton a = new JButton("數學");
	JButton b = new JButton("動漫遊戲");
	JButton c = new JButton("其他");
	JButton d = new JButton("連續挑戰");
	
	JLabel youName = new JLabel();
	JLabel rivalName = new JLabel();
	
	JLabel youPlayName = new JLabel();
	JLabel rivalPlayName = new JLabel();
	JTextArea text = new JTextArea();
	JTextField remainTime = new JTextField();
	
	JLabel bet = new JLabel("下賭注 : ");
	JButton money1 = new JButton("500元");
	JButton money2 = new JButton("1000元");
	JButton money3 = new JButton("5000元");
	
	JLabel youPIC;
	JLabel rivalPIC;
	
	JButton select1 = new JButton();
	JButton select2 = new JButton();
	JButton select3 = new JButton();
	JButton select4 = new JButton();
	
	JLabel playerCorrect[] = new JLabel[4];
	JLabel playerIncorrect[] = new JLabel[4];
	
	JLabel rivalCorrect[] = new JLabel[4];
	JLabel rivalIncorrect[] = new JLabel[4];
	
	JLabel talk;
	JTextArea talkText = new JTextArea();
	
	int time;
	String user;
	String id;
	
	Timer start;
	int startTime = 6;
	Timer game;
	int gameTime;
	Timer rivalJudge;
	int rivalJudgeTime;
	Timer over;
	int overTime = 3;
	
	float playerTime = 0;
	float playerTimeFinal = 0;
	float rivalTime = 0;
	
	String playerAns;
	String rivalAns;
	
	JLabel readySteadyStart = new JLabel("Ready?");
	
	JLabel coinRemain = new JLabel();
	
	knowledge(String userName, String userId){
		user = userName;
		id = userId;
		
		//start startGame = new start();////////////////////setGame設計按鈕使用遊戲選單
		new start(user, id);
	}
	knowledge(int choose, int time, String userName, String userId){
		if(choose == 1)
			new rival(userName, userId, time, coin);
		else
			new single(userName, userId, time);
	}
	knowledge(int rival,String userName,String userId,int timeSet,long cocoin){
		who = rival;
		npc npc = new npc(who);
		
		coin = cocoin;
		setMain();
		time = timeSet;
		user = userName;
		id = userId;
		gameTime = timeSet;
		
		talkText.setBounds(685, 220, 175, 65);
		talkText.setFont(new Font("標楷體", Font.BOLD, 16));
		talkText.setText("");
		talkText.setVisible(false);
		frameGame.add(talkText);
		
		/*java.net.URL imgURL1 = rival.class.getResource("11.jpg");
		ImageIcon r1 = new ImageIcon(imgURL1);
		JLabel rival1 = new JLabel(r1);*/
		ImageIcon iconTalk = new ImageIcon("image/talk.jpg"); 
		talk = new JLabel(iconTalk);
		talk.setBounds(660, 155, 240, 180);
		talk.setVisible(false);
		frameGame.add(talk);
		
		setBak1();setBak2();
		
		panelSelcect.setLayout(null);
		
		/*java.net.URL imgURL1 = rival.class.getResource("11.jpg");
		ImageIcon r1 = new ImageIcon(imgURL1);
		JLabel rival1 = new JLabel(r1);*/
		ImageIcon iconCoinPic = new ImageIcon("image/cash.png"); 
		JLabel coinPic = new JLabel(iconCoinPic);
		
		/*java.net.URL imgURL1 = rival.class.getResource("11.jpg");
		ImageIcon r1 = new ImageIcon(imgURL1);
		JLabel rival1 = new JLabel(r1);*/
		ImageIcon iconYou = new ImageIcon("image/3.jpg"); 
		JLabel you = new JLabel(iconYou);
		youPIC = new JLabel(iconYou);
		
		/*java.net.URL imgURL1 = rival.class.getResource("11.jpg");
		ImageIcon r1 = new ImageIcon(imgURL1);
		JLabel rival1 = new JLabel(r1);*/
		ImageIcon iconRivalPic;
		if(rival == 11){
			iconRivalPic = new ImageIcon("image/11.jpg"); 
			rivalName.setText("曉闢骸");
			rivalPlayName.setText("曉闢骸");
		}
		else{
			iconRivalPic = new ImageIcon("image/2.jpg"); 
			rivalName.setText("崑漢");
			rivalPlayName.setText("崑漢");
		}
		JLabel rivalPic = new JLabel(iconRivalPic);
		rivalPIC = new JLabel(iconRivalPic);
		
		/*java.net.URL imgURL1 = rival.class.getResource("11.jpg");
		ImageIcon r1 = new ImageIcon(imgURL1);
		JLabel rival1 = new JLabel(r1);*/
		ImageIcon iconVs = new ImageIcon("image/vs.png"); 
		JLabel versus = new JLabel(iconVs);
		
		youName.setText(user);
		youPlayName.setText(user);
		setGame();setMoney();
		//////////////////////frameGame.setVisible(true);
		
		you.setBounds(75, 325, 110, 105);
		add(you);
		
		versus.setBounds(287, 325, 125, 125);
		add(versus);
		
		rivalPic.setBounds(505, 325, 120, 120);
		add(rivalPic);
		
		coinPic.setBounds(425, 0, 65, 75);
		add(coinPic);
		
		remainTime.setBounds(375, 35, 140, 35);
		remainTime.setOpaque(false);
		remainTime.setEditable(false);
		remainTime.setFont(new Font("標楷體", Font.BOLD, 20));
		frameGame.add(remainTime);
		
		text.setBounds(180, 100, 535, 275);
		text.setOpaque(false);
		text.setVisible(false);
		text.setEditable(false);
		text.setForeground(Color.CYAN);
		text.setFont(new Font("標楷體", Font.BOLD, 55));
		/*text.setText("testtesttest00000" +"\n"
						+ "tsettesttest00000");*/
		frameGame.add(text);
		
		setAction();

		start = new Timer(1000, new ActionListener(){ 
		    public void actionPerformed(ActionEvent e) { 
		    	RandomQ = (int)(Math.random() * 10);
		    	readySteadyStart.setVisible(true);
		    	startTime--;
		    	if(startTime == 3)
		    		readySteadyStart.setText("Steady!");
		    	if(startTime == 1)
		    		readySteadyStart.setText("Start!!!");
		    	if(startTime == 0){
		    		setQuestionAnswer();
		    		readySteadyStart.setVisible(false);
		    		select1.setVisible(true);
		    		select2.setVisible(true);
		    		select3.setVisible(true);
		    		select4.setVisible(true);
		    		text.setVisible(true);
		    		//startTime = 6;
		    		start.stop();
		    		game.start();
		    		rivalJudge.start();
		    	}
		    }
		});
		//start.start();
		
		game = new Timer(1000, new ActionListener(){ 
			public void actionPerformed(ActionEvent e) { 
				gameTime--;
				playerTime++;
				remainTime.setText("  剩餘"+ gameTime + "秒");
				if(gameTime == 0){
					game.stop();
					rivalJudge.stop();
					over.start();
					startTime = 6;
				}
			}
		});
		
		over = new Timer(1000, new ActionListener(){ 
			public void actionPerformed(ActionEvent e) { 
				overTime--;
				int talkWhat = (int)(Math.random() * 4);
				if(overTime == 2){
					//over.stop();
				if(rivalTime > playerTime){
					JOptionPane.showMessageDialog(null, "你贏了");
					talkText.setText(npc.loseTalk(talkWhat));
					talk.setVisible(true);
					talkText.setVisible(true);
					coin = coin + 2 * witchPay;
				}
				else if(rivalTime == playerTime){
					JOptionPane.showMessageDialog(null, "平手");
					coin = coin + witchPay;
				}
				else if(rivalTime < playerTime){
					JOptionPane.showMessageDialog(null, "關主贏了");
					talk.setVisible(true);
					talkText.setVisible(true);
					talkText.setText(npc.winTalk(talkWhat));
				}
				}
				if(overTime == 0){
					//over.stop();
				frameGame.dispose();
				new rival(userName, userId, time, coin);
				/*text.setVisible(false);
				select1.setVisible(false);
	    		select2.setVisible(false);
	    		select3.setVisible(false);
	    		select4.setVisible(false);*/
				
				}
				
			}
		});
		
		int judgeTime = (int)(2500 + Math.random() * 1500);
		rivalJudge = new Timer(judgeTime, new ActionListener(){ 
			public void actionPerformed(ActionEvent e) { 
				rivalTime = judgeTime/1000;
				switch(whatQuestion){
				case 0:{
						rivalAns = question.ansToMath(RandomQ);
						if(rivalAns.equals(select1.getText()))
							rivalCorrect[0].setVisible(true);
						else if(rivalAns.equals(select2.getText()))
							rivalCorrect[1].setVisible(true);
						else if(rivalAns.equals(select3.getText()))
							rivalCorrect[2].setVisible(true);
						else if(rivalAns.equals(select4.getText()))
							rivalCorrect[3].setVisible(true);
					
					}
				case 1:{
						rivalAns = question.ansToMath(RandomQ);
						if(rivalAns.equals(select1.getText()))
							rivalCorrect[0].setVisible(true);
						else if(rivalAns.equals(select2.getText()))
							rivalCorrect[1].setVisible(true);
						else if(rivalAns.equals(select3.getText()))
							rivalCorrect[2].setVisible(true);
						else if(rivalAns.equals(select4.getText()))
							rivalCorrect[3].setVisible(true);
					}
				case 2:{
						rivalAns = question.ansToMath(RandomQ);
						if(rivalAns.equals(select1.getText()))
							rivalCorrect[0].setVisible(true);
						else if(rivalAns.equals(select2.getText()))
							rivalCorrect[1].setVisible(true);
						else if(rivalAns.equals(select3.getText()))
							rivalCorrect[2].setVisible(true);
						else if(rivalAns.equals(select4.getText()))
							rivalCorrect[3].setVisible(true);

					}
				case 3:{
						rivalAns = question.ansToMath(RandomQ);
						if(rivalAns.equals(select1.getText()))
							rivalCorrect[0].setVisible(true);
						else if(rivalAns.equals(select2.getText()))
							rivalCorrect[1].setVisible(true);
						else if(rivalAns.equals(select3.getText()))
							rivalCorrect[2].setVisible(true);
						else if(rivalAns.equals(select4.getText()))
							rivalCorrect[3].setVisible(true);
					}
				}
			}
		});
		
	}
	
	public void setBak1(){
		((JPanel)this.getContentPane()).setOpaque(false);
		/*java.net.URL imgURL = knowledge.class.getResource("1.jpg");
		ImageIcon img = new ImageIcon(imgURL);*/
		ImageIcon img = new ImageIcon("image/12.jpg");
		JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
	
	public void setBak2(){
		((JPanel)this.frameGame.getContentPane()).setOpaque(false);
		/*java.net.URL imgURL = knowledge.class.getResource("1.jpg");
		ImageIcon img = new ImageIcon(imgURL);*/
		ImageIcon img = new ImageIcon("image/cs.png");
		JLabel background = new JLabel(img);this.frameGame.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 225, img.getIconWidth(), img.getIconHeight());
	}
	
	public void setMain(){
		add(panelSelcect);
		panelSelcect.setOpaque(false);
		
		setTitle("knowledge_select");
		setSize(700, 525);
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLayout(null);
		
		/*coinPic.setBounds(425, 0, 65, 75);
		add(coinPic);*/
		
		//JLabel coinRemain = new JLabel();
		coinRemain.setBounds(500, 15, 200, 30);
		coinRemain.setFont(new Font("標楷體", Font.BOLD, 25));
		coinRemain.setForeground(Color.RED);
		coinRemain.setText("x " + String.valueOf(coin));
		panelSelcect.add(coinRemain);
		
		welcome.setBounds(45, 20, 200, 30);
		welcome.setFont(new Font("標楷體", Font.BOLD, 25));
		panelSelcect.add(welcome);
		
		a.setBounds(45, 90, 250, 85);
		a.setFont(new Font("標楷體", Font.BOLD, 16));
		panelSelcect.add(a);
		
		b.setBounds(405, 90, 250, 85);
		b.setFont(new Font("標楷體", Font.BOLD, 16));
		panelSelcect.add(b);
		
		c.setBounds(45, 225, 250, 85);
		c.setFont(new Font("標楷體", Font.BOLD, 16));
		panelSelcect.add(c);
		
		d.setBounds(405, 225, 250, 85);
		d.setFont(new Font("標楷體", Font.BOLD, 16));
		panelSelcect.add(d);
		
		youName.setBounds(95, 455, 150, 35);
		youName.setFont(new Font("標楷體", Font.BOLD, 22));
		youName.setText(user);
		panelSelcect.add(youName);
		
		rivalName.setBounds(525, 455, 150, 35);
		rivalName.setFont(new Font("標楷體", Font.BOLD, 22));
		panelSelcect.add(rivalName);
		
	}
	
	public void setGame(){
		frameGame.setTitle("versus!!!");
		frameGame.setSize(900, 650);
		frameGame.setLocationRelativeTo(null); // Center the frame
		//frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGame.setResizable(false);
		//frameGame.setVisible(true);
		frameGame.setLayout(null);
		
		youPIC.setBounds(20, 20, 150, 150);
		frameGame.add(youPIC);
		
		rivalPIC.setBounds(730, 20, 150, 150);
		frameGame.add(rivalPIC);
		
		youPlayName.setBounds(55, 155, 150, 35);
		youPlayName.setFont(new Font("標楷體", Font.BOLD, 22));
		frameGame.add(youPlayName);
		
		rivalPlayName.setBounds(765, 155, 150, 35);
		rivalPlayName.setFont(new Font("標楷體", Font.BOLD, 22));
		frameGame.add(rivalPlayName);
		
		select1.setBounds(275, 305, 350, 65);
		select1.setVisible(false);
		select1.setFont(new Font("標楷體", Font.BOLD, 22));
		frameGame.add(select1);
		
		select2.setBounds(275, 375, 350, 65);
		select2.setVisible(false);
		select2.setFont(new Font("標楷體", Font.BOLD, 22));
		frameGame.add(select2);
		
		select3.setBounds(275, 445, 350, 65);
		select3.setVisible(false);
		select3.setFont(new Font("標楷體", Font.BOLD, 22));
		frameGame.add(select3);
		
		select4.setBounds(275, 515, 350, 65);
		select4.setVisible(false);
		select4.setFont(new Font("標楷體", Font.BOLD, 22));
		frameGame.add(select4);
		
		readySteadyStart.setBounds(350, 292, 350, 66);
		readySteadyStart.setVisible(false);
		readySteadyStart.setForeground(Color.RED);
		readySteadyStart.setFont(new Font("標楷體", Font.BOLD, 44));
		frameGame.add(readySteadyStart);
		
		/*java.net.URL imgURL1 = rival.class.getResource("11.jpg");
		ImageIcon r1 = new ImageIcon(imgURL1);
		JLabel rival1 = new JLabel(r1);*/
		ImageIcon correct = new ImageIcon("image/correct.png"); 
		
		/*java.net.URL imgURL1 = rival.class.getResource("11.jpg");
		ImageIcon r1 = new ImageIcon(imgURL1);
		JLabel rival1 = new JLabel(r1);*/
		ImageIcon incorrect = new ImageIcon("image/incorrect.png"); 
		
		coinRemain.setText("x " + String.valueOf(coin));
		for(int i = 0;i <= 3;i++){
			playerCorrect[i] = new JLabel(correct);
			playerIncorrect[i] = new JLabel(incorrect);
			rivalCorrect[i] = new JLabel(correct);
			rivalIncorrect[i] = new JLabel(incorrect);
			
			playerCorrect[i].setBounds(200, 305 + 70 * i, 65, 65);
			playerCorrect[i].setVisible(false);
			frameGame.add(playerCorrect[i]);
			
			rivalCorrect[i].setBounds(635, 305 + 70 * i, 65, 65);
			rivalCorrect[i].setVisible(false);
			frameGame.add(rivalCorrect[i]);
		}
		

	}
	
	public void setMoney(){
		frameMoney.setTitle("make_a_bet!");
		frameMoney.setSize(350, 135);
		frameMoney.setLocationRelativeTo(null); // Center the frame
		//frameMoney.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMoney.setResizable(false);
		//frameMoney.setVisible(true);
		frameMoney.setLayout(null);
		
		bet.setBounds(132, 0, 85, 30);
		bet.setFont(new Font("標楷體", Font.BOLD, 16));
		frameMoney.add(bet);
		
		money1.setBounds(10, 55, 95, 35);
		money1.setFont(new Font("標楷體", Font.BOLD, 16));
		frameMoney.add(money1);
		
		money2.setBounds(125, 55, 95, 35);
		money2.setFont(new Font("標楷體", Font.BOLD, 16));
		frameMoney.add(money2);
		
		money3.setBounds(240, 55, 95, 35);
		money3.setFont(new Font("標楷體", Font.BOLD, 16));
		frameMoney.add(money3);
	}
	
	public void setAction(){
		a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frameMoney.setVisible(true);
				whatQuestion = 0;
				//setQuestionAnswer();
				//start.start();
				
			}
		});
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frameMoney.setVisible(true);
				whatQuestion = 1;
				//setQuestionAnswer();
				//start.start();
				
			}
		});
		
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frameMoney.setVisible(true);
				whatQuestion = 2;
				//setQuestionAnswer();
				//start.start();
				
			}
		});
		
		d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frameMoney.setVisible(true);
				whatQuestion = 3;
				//start.start();
				//setQuestionAnswer();///////////////////////////////////不同
			}
		});
		
		money1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				witchPay = 500;
				coin = coin - witchPay;
				frameMoney.setVisible(false);
				setVisible(false);
				frameGame.setVisible(true);
				start.start();
			}
		});
		
		money2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				witchPay = 1000;
				coin = coin - witchPay;
				frameMoney.setVisible(false);
				setVisible(false);
				frameGame.setVisible(true);
				start.start();
			}
		});
		
		money3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				witchPay = 10000;
				coin = coin - witchPay;
				frameMoney.setVisible(false);
				setVisible(false);
				frameGame.setVisible(true);
				start.start();
			}
		});
		
		select1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				playerAns = select1.getText();
				playerWhichCorrect = 0;
				playerWhichIncorrect = 0;
				switch(whatQuestion){
				case 0:{
					if(playerAns.equals(question.ansToMath(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else if(!(playerAns.equals(question.ansToMath(RandomQ))))//(playerAns.compareTo(question.ansToMath(RandomQ)) == 0)
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select2.setVisible(false);
		    		select3.setVisible(false);
		    		select4.setVisible(false);
					}
				case 1:{
					if(playerAns.equals(question.ansToGame(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select2.setVisible(false);
		    		select3.setVisible(false);
		    		select4.setVisible(false);
					}
				case 2:{
					if(playerAns.equals(question.ansToOther(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select2.setVisible(false);
		    		select3.setVisible(false);
		    		select4.setVisible(false);
					}
				case 3:{
					if(playerAns.equals(question.ansToRandom(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select2.setVisible(false);
		    		select3.setVisible(false);
		    		select4.setVisible(false);
					}
				}
				playerTimeFinal = playerTime;
				game.stop();
				over.start();
			}
		});
		
		select2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				playerAns = select2.getText();
				playerWhichCorrect = 1;
				playerWhichIncorrect = 1;
				switch(whatQuestion){
				case 0:{
					if(playerAns.equals(question.ansToMath(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select3.setVisible(false);
		    		select4.setVisible(false);
					}
				case 1:{
					if(playerAns.equals(question.ansToGame(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select3.setVisible(false);
		    		select4.setVisible(false);
					}
				case 2:{
					if(playerAns.equals(question.ansToOther(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select3.setVisible(false);
		    		select4.setVisible(false);
					}
				case 3:{
					if(playerAns.equals(question.ansToRandom(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select3.setVisible(false);
		    		select4.setVisible(false);
					}
				}
				playerTimeFinal = playerTime;
				game.stop();
				over.start();
			}
		});
		
		select3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				playerAns = select3.getText();
				playerWhichCorrect = 2;
				playerWhichIncorrect = 2;
				switch(whatQuestion){
				case 0:{
					if(playerAns.equals(question.ansToMath(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select2.setVisible(false);
		    		select4.setVisible(false);
					}
				case 1:{
					if(playerAns.equals(question.ansToGame(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select2.setVisible(false);
		    		select4.setVisible(false);
					}
				case 2:{
					if(playerAns.equals(question.ansToOther(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select2.setVisible(false);
		    		select4.setVisible(false);
					}
				case 3:{
					if(playerAns.equals(question.ansToRandom(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select2.setVisible(false);
		    		select4.setVisible(false);
					}
				}
				playerTimeFinal = playerTime;
				game.stop();
				over.start();
			}
		});
		
		select4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				playerAns = select4.getText();
				playerWhichCorrect = 3;
				playerWhichIncorrect = 3;
				switch(whatQuestion){
				case 0:{
					if(playerAns.equals(question.ansToMath(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select2.setVisible(false);
		    		select3.setVisible(false);
					}
				case 1:{
					if(playerAns.equals(question.ansToGame(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select2.setVisible(false);
		    		select3.setVisible(false);
					}
				case 2:{
					if(playerAns.equals(question.ansToOther(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select2.setVisible(false);
		    		select3.setVisible(false);
					}
				case 3:{
					if(playerAns.equals(question.ansToRandom(RandomQ)))
						playerCorrect[playerWhichCorrect].setVisible(true);
					else
						playerIncorrect[playerWhichIncorrect].setVisible(true);
					select1.setVisible(false);
		    		select2.setVisible(false);
		    		select3.setVisible(false);
					}
				}
				playerTimeFinal = playerTime;
				game.stop();
				over.start();
			}
		});
	}
	
	public void setQuestionAnswer(){
		remainTime.setText("  剩餘"+ gameTime + "秒");
		RandomQ = (int)(Math.random() * 10);
		int RandomA = (int)(Math.random() * 4);
		for(int j = 0;j <= 3;j++){
			checkA[j] = false;
		}
		switch(whatQuestion){
		case 0:{
			text.setText(question.math(RandomQ));
			for(int ans = 0;ans <= 3;ans++){
				do{
					RandomA = (int)(Math.random() * 4);
				}while(checkA[RandomA] == true);
				switch(ans){
					case 0:
						select1.setText(question.mathAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 1:
						select2.setText(question.mathAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 2:
						select3.setText(question.mathAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 3:
						select4.setText(question.mathAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
				}
			}
			break;
		}
		case 1:{
			text.setText(question.game(RandomQ));
			for(int ans = 0;ans <= 3;ans++){
				do{
					RandomA = (int)(Math.random() * 4);
				}while(checkA[RandomA] == true);
				switch(ans){
					case 0:
						select1.setText(question.gameAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 1:
						select2.setText(question.gameAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 2:
						select3.setText(question.gameAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 3:
						select4.setText(question.gameAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
				}
			}
			break;
		}
		case 2:{
			text.setText(question.other(RandomQ));
			for(int ans = 0;ans <= 3;ans++){
				do{
					RandomA = (int)(Math.random() * 4);
				}while(checkA[RandomA] == true);
				switch(ans){
					case 0:
						select1.setText(question.otherAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 1:
						select2.setText(question.otherAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 2:
						select3.setText(question.otherAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 3:
						select4.setText(question.otherAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
				}
			}
			break;
		}
		case 3:{
			text.setText(question.random(RandomQ));
			for(int ans = 0;ans <= 3;ans++){
				do{
					RandomA = (int)(Math.random() * 4);
				}while(checkA[RandomA] == true);
				switch(ans){
					case 0:
						select1.setText(question.randomAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 1:
						select2.setText(question.randomAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 2:
						select3.setText(question.randomAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
					case 3:
						select4.setText(question.randomAns(RandomQ, RandomA));
						checkA[RandomA] = true;
						break;
				}
			}
			break;
		}
		}
		
	}
	
	
	
	public static void main(String[] args){
		new login();
	}
}
