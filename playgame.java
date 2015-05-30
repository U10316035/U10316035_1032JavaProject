import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class playgame{
	static String user;
	JFrame playgame = new JFrame();
	int random;
	int score = 0;
	String subjectSelect;
	boolean[] mathCheck = new boolean[4];
	boolean[] compCheck = new boolean[4];
	boolean[] otherCheck = new boolean[4];
	boolean[] finCheck = new boolean[2];
	
	int count = 0;
	
	question select = new question();
	display displayIt;
	JButton math = new JButton("數學");
	JButton fin = new JButton("終極挑戰");
	JButton other = new JButton("其他");
	JButton computer = new JButton("計算機");
	/*/////////////////////////////////////////////////////////////////
	JPanel picture1 = new JPanel();
	JPanel picture2 = new JPanel();
	JPanel picture3 = new JPanel();
	JPanel picture4 = new JPanel();
	/////////////////////////////////////////////////////////////////*/
	/*class panel extends JPanel{ 
		public void paint(Graphics g) {
			ImageIcon a = new ImageIcon("image/1.png");
			g.drawImage(a,550,150,this);
		}
	}*/
	
	/*Image imageToBeDraw=Toolkit.getDefaultToolkit().getImage("image/correct.jpg");
	ImageIcon a = new ImageIcon(imageToBeDraw);
	public void paint(Graphics g){
		 g.drawImage(imageToBeDraw,0,0,null);  
	}*/
	ImageIcon a = new ImageIcon("image/1.png");
	JLabel pic1 = new JLabel(a);
	//JLabel background = new JLabel(new ImageIcon("image/pic1.jpg"));
	
	/*protected ImageIcon createImage(String filename){
	    java.net.URL picture = getClass().getResource(filename);
	    if(picture != null)
	        return new ImageIcon(picture);
	

		return null;
	}*/
	
	
	playgame(String passUser, String passId){
		user = passUser;
		for(int i = 0;i <= 3;i++){
			mathCheck[i] = false;
			compCheck[i] = false;
			otherCheck[i] = false;
			if(i <= 1)
				finCheck[i] = false;
		}
		playgame.setTitle("U10316035_question");
		playgame.setSize(800, 800);
		playgame.setLocationRelativeTo(null); // Center the frame
		playgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playgame.setResizable(false);
		playgame.setVisible(true);

		/*/////////////////////////////////////////////////////////////////////
		JLabel bg = new JLabel(new ImageIcon("image/pic1.jpg"));
		layeredPane.add(bg, new Integer(-1));
		playgame.setContentPane(new JLabel(new ImageIcon("image/pic1.jpg")));*/
		/*////////////////////////////////////////////////
		playgame.setLayout(new BorderLayout());
		layeredPane.add(child, new Integer(10));
		playgame.setContentPane(new JLabel(new ImageIcon("image/pic1.jpg")));
		//add(background);*/
		pic1.setBounds(50,150,150,150);
		playgame.add(pic1);
		
		playgame.setLayout(null);
		
		JLabel user = new JLabel("使用者 : " + passUser);
		user.setBounds(0, 0, 500, 35);
		user.setFont(new Font("標楷體", Font.BOLD, 32));
		playgame.add(user);
		
		JLabel id = new JLabel("ID : " + passId);
		id.setBounds(0, 35, 500, 30);
		id.setFont(new Font("標楷體", Font.BOLD, 32));
		playgame.add(id);
		
		JLabel label = new JLabel("請選擇題庫 : ");
		label.setBounds(0, 150, 200, 30);
		label.setFont(new Font("標楷體", Font.BOLD, 28));
		playgame.add(label);
		
		JLabel question = new JLabel("");
		question.setBounds(200, 0, 200, 40);
		playgame.add(question);
		
		math.setBounds(80, 240, 300, 200);
		playgame.add(math);
		math.addActionListener(new setMathListener());
		
		computer.setBounds(80, 460, 300, 200);
		playgame.add(computer);
		computer.addActionListener(new setComputerListener());
		
		other.setBounds(420, 240, 300, 200);
		playgame.add(other);
		other.addActionListener(new setOtherListener());
		
		fin.setBounds(80, 240, 640, 440);
		fin.setVisible(false);
		playgame.add(fin);
		fin.addActionListener(new setFinListener());
		
		/*/refresh??????????????????????????????????????????????????
		playgame.setSize(799,799);
		playgame.setSize(800,800);*/
		
		playgame.setVisible(true);
		
	}
	
	class display extends JFrame{            
		//,String buttonA,String buttonB,String buttonC,String buttonD
		int remainTime = 10;
		answer select = new answer();
		int answerRandom = 5;
		JLabel subjectNum = new JLabel();
		JLabel subject = new JLabel("題目 : ");
		JTextField text = new JTextField();
		JLabel a = new JLabel("A. ");
		JLabel b = new JLabel("B. ");  
		JLabel c = new JLabel("C. ");
		JLabel d = new JLabel("D. ");
		JLabel scoreNow = new JLabel("你目前的得分: ");
		JTextField scoreText = new JTextField();
		JLabel score = new JLabel("分");
		JButton A = new JButton();
		JButton B = new JButton();
		JButton C = new JButton();
		JButton D = new JButton();
		JButton next = new JButton("下一題");
		JTextField time = new JTextField();
		Timer timer;
		/*JLabel judge1;
		JLabel judge2;
		JLabel judge3;
		JLabel judge4;*/
		
		display(int num,int random,String Text,int Score,String Subject){
			
			/*JPanel panel =new JPanel(){ 
				@Override
				protected void paintComponent(Graphics g) {
					try{
					super.paintComponent(g);
					BufferedImage a = ImageIO.read(new File("Z:\\work\\project\\src\\project\\image.png"));
					g.drawImage(a,500, 500, null);
					}catch(IOException e){
						
					}
				}
			};
			add(panel);
			repaint();
			*/
			
			/*/////////////////////////////////////////////////
			//picture1.setSize(50, 50);
			picture1.setBounds(45, 400, 50, 50);
			//picture2.setSize(50, 50);
			picture2.setBounds(45, 470, 50, 50);
			//picture3.setSize(50, 50);
			picture3.setBounds(45, 540, 50, 50);
			//picture4.setSize(50, 50);
			picture4.setBounds(45, 610, 50, 50);
			/////////////////////////////////////////////////*/
			setTitle("U10316035_question");
			setSize(800, 800);
			setLocationRelativeTo(null); // Center the frame
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			/*/background???????????????????????????????????????????????
			setLayout(new BorderLayout());
			JLabel background=new JLabel(new ImageIcon("image/pic1.jpg"));
			add(background);
			background.setLayout(new FlowLayout());*/
			setLayout(null);
			/////////////////////////////////////////////////////////////
			subjectNum.setBounds(25, 0, 250, 50);
			subjectNum.setFont(new Font("標楷體", Font.BOLD, 25));
			subjectNum.setText("第 " + num +" 題  /  10 題");
			add(subjectNum);
			
			/*remain.setBounds(500, 0, 150, 50);
			remain.setFont(new Font("標楷體", Font.BOLD, 22));
			add(remain);*/
			
			time.setBounds(620, 10, 130, 40);
			time.setEditable(false);
			time.setFont(new Font("標楷體", Font.BOLD, 22));
			add(time);
			
			subject.setBounds(25, 50, 200, 50);
			subject.setFont(new Font("標楷體", Font.BOLD, 20));
			add(subject);
			
			text.setBounds(25, 95, 750, 300);
			text.setText(Text);
			text.setEditable(false);
			text.setFont(new Font("標楷體", Font.BOLD, 20));
			add(text);
			
			pic1.setBounds(550,150,150,150);
			playgame.add(pic1);
			
			//picture1.paintComponent().fillRect(550, 115, 150, 150)
			
			a.setBounds(25, 400, 50, 50);
			a.setFont(new Font("標楷體", Font.BOLD, 20));
			add(a);
			
			/*judge1.setBounds(45, 400, 50, 50);
			add(judge1);*/
			
			b.setBounds(25, 470, 50, 50);
			b.setFont(new Font("標楷體", Font.BOLD, 20));
			add(b);
			
			/*judge2.setBounds(45, 470, 50, 50);
			add(judge2);*/
			
			c.setBounds(25, 540, 50, 50);
			c.setFont(new Font("標楷體", Font.BOLD, 20));
			add(c);
			
			/*judge3.setBounds(45, 540, 50, 50);
			add(judge3);*/
			
			d.setBounds(25, 610, 50, 50);
			d.setFont(new Font("標楷體", Font.BOLD, 20));
			add(d);

			/*judge4.setBounds(45, 610, 50, 50);
			add(judge4);*/
			
			A.setBounds(75, 400, 650, 40);
			A.setFont(new Font("標楷體", Font.BOLD, 20));
			add(A);
			
			B.setBounds(75, 470, 650, 40);
			B.setFont(new Font("標楷體", Font.BOLD, 20));
			add(B);
			
			C.setBounds(75, 540, 650, 40);
			C.setFont(new Font("標楷體", Font.BOLD, 20));
			add(C);
			
			D.setBounds(75, 610, 650, 40);
			D.setFont(new Font("標楷體", Font.BOLD, 20));
			add(D);
			
			scoreNow.setBounds(25, 660, 200, 20);
			scoreNow.setFont(new Font("標楷體", Font.BOLD, 18));
			add(scoreNow);
			
			scoreText.setBounds(25, 700, 200, 50);
			scoreText.setEditable(false);
			scoreText.setText(Integer.toString(Score));
			scoreText.setFont(new Font("標楷體", Font.BOLD, 18));
			add(scoreText);
			
			score.setBounds(255, 700, 200, 50);
			score.setFont(new Font("標楷體", Font.BOLD, 18));
			add(score);
			
			next.setBounds(600, 680, 150, 50);
			next.setFont(new Font("標楷體", Font.BOLD, 18));
			next.setVisible(false);
			add(next);
			
			boolean[] check = new boolean[4];
				for(int j = 0;j <= 3;j++){
					check[j] = false;
				}
				
			for(int i = 0;i <= 3;i++){
				
				do{
					answerRandom = (int)(Math.random() * 4);
				}while(check[answerRandom] == true);
				if(Subject.equals("math")){
					if(i == 0){
						A.setText(select.math(answerRandom));
						check[answerRandom] = true;
					}else if(i == 1){
						B.setText(select.math(answerRandom));
						check[answerRandom] = true;
					}else if(i == 2){
						C.setText(select.math(answerRandom));
						check[answerRandom] = true;
					}else{
						D.setText(select.math(answerRandom));
						check[answerRandom] = true;
					}
				}else if(Subject.equals("computer")){
					if(i == 0){
						A.setText(select.computer(answerRandom));
						check[answerRandom] = true;
					}else if(i == 1){
						B.setText(select.computer(answerRandom));
						check[answerRandom] = true;
					}else if(i == 2){
						C.setText(select.computer(answerRandom));
						check[answerRandom] = true;
					}else{
						D.setText(select.computer(answerRandom));
						check[answerRandom] = true;
					}
				}else if(Subject.equals("other")){
					if(i == 0){
						A.setText(select.other(answerRandom));
						check[answerRandom] = true;
					}else if(i == 1){
						B.setText(select.other(answerRandom));
						check[answerRandom] = true;
					}else if(i == 2){
						C.setText(select.other(answerRandom));
						check[answerRandom] = true;
					}else{
						D.setText(select.other(answerRandom));
						check[answerRandom] = true;
					}
				}else{
					if(i == 0){
						A.setText(select.fin(answerRandom));
						check[answerRandom] = true;
					}else if(i == 1){
						B.setText(select.fin(answerRandom));
						check[answerRandom] = true;
					}else if(i == 2){
						C.setText(select.fin(answerRandom));
						check[answerRandom] = true;
					}else{
						D.setText(select.fin(answerRandom));
						check[answerRandom] = true;
					}
					if(count == 10 && i ==3){
						switch(answerRandom){
							case 0:
								A.setText(user);
								break;
							case 1:
								B.setText(user);
								break;
							case 2:
								C.setText(user);
								break;
							case 3:
								D.setText(user);
								break;
						}
					}
				}
			}
		
			time.setText("剩餘 " + remainTime + " 秒");
			timer= new Timer(1000, new ActionListener(){ 
			    public void actionPerformed(ActionEvent e) {   
			    	remainTime--;
			    	time.setText("剩餘 " + remainTime + " 秒");
			    	if(remainTime == 0){
			    		if(Subject.equals("math")){
			    			JOptionPane.showMessageDialog(null, "時間到, 答案是 : " + select.math(random));
			    		}else if(Subject.equals("computer")){
			    			JOptionPane.showMessageDialog(null, "時間到, 答案是 : " + select.computer(random));
			    		}else if(Subject.equals("other")){
			    			JOptionPane.showMessageDialog(null, "時間到, 答案是 : " + select.other(random));
			    		}else if(Subject.equals("fin")){
			    			JOptionPane.showMessageDialog(null, "時間到, 答案是 : " + select.fin(random));
			    		}else if(count == 10){
							JOptionPane.showMessageDialog(null, "時間到, 答案是 : " + user);
    					}
			    		A.setVisible(false);
			    		B.setVisible(false);
			    		C.setVisible(false);
			    		D.setVisible(false);
			    		timer.stop();
			    		if(count == 10)
							next.setText("結束");
						next.setVisible(true);
			    	}
			    }
			});
			timer.start();
			
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					dispose();
					playgame.setVisible(true);
					if(count == 10){
						JOptionPane.showMessageDialog(null, "遊戲結束, 你的得分是 " + Integer.toString(getScore()) + "分");
						playgame.dispose();
					}
				}
			});
			
			A.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					B.setVisible(false);
					C.setVisible(false);
					D.setVisible(false);
					if(Subject.equals("math")){
						if(A.getText() == select.math(random)){
							/*judge1 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge1);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge1 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge1);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.math(random));
						}
					}else if(Subject.equals("computer")){
						if(A.getText() == select.computer(random)){
							/*judge1 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge1);*/
							
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge1 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge1);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.computer(random));
						}
					}else if(Subject.equals("other")){
						if(A.getText() == select.other(random)){
							/*judge1 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge1);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge1 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge1);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.other(random));
						}
					}else if(Subject.equals("fin")  && count == 9){
						if(A.getText() == select.fin(random)){
							/*judge1 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge1);*/
							
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge1 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge1);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.fin(random));
						}
					}else{
						if(A.getText().equals(user)){
							/*judge1 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge1);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge1 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge1);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + user);
						}
					}
					/*judge1.setBounds(45, 400, 50, 50);
					picture1.add(judge1);*/
					timer.stop();
					if(count == 10)
						next.setText("結束");
					next.setVisible(true);
				}
			});
			
			B.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					A.setVisible(false);
					C.setVisible(false);
					D.setVisible(false);
					if(Subject.equals("math")){
						if(B.getText() == select.math(random)){
							/*judge2 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge2);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{							
							/*judge2 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge2);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.math(random));
						}
					}else if(Subject.equals("computer")){
						if(B.getText() == select.computer(random)){
							/*judge2 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge2);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge2 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge2);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.computer(random));
						}
					}else if(Subject.equals("other")){
						if(B.getText() == select.other(random)){
							/*judge2 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge2);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge2 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge2);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.other(random));
						}
					}else if(Subject.equals("fin")  && count == 9){
						if(B.getText() == select.fin(random)){
							/*judge2 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge2);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge2 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge2);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.fin(random));
						}
					}else{
						if(B.getText().equals(user)){
							/*judge2 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge2);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge2 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge2);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + user);
						}
					}
					/*judge2.setBounds(45, 470, 50, 50);
					picture2.add(judge2);*/
					timer.stop();
					if(count == 10)
						next.setText("結束");
					next.setVisible(true);
				}
			});
			
			C.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					B.setVisible(false);
					A.setVisible(false);
					D.setVisible(false);
					if(Subject.equals("math")){
						if(C.getText() == select.math(random)){
							/*judge3 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge3);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge3 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge3);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.math(random));
						}
					}else if(Subject.equals("computer")){
						if(C.getText() == select.computer(random)){
							/*judge3 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge3);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge3 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge3);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.computer(random));
						}
					}else if(Subject.equals("other")){
						if(C.getText() == select.other(random)){
							/*judge3 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge3);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge3 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge3);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.other(random));
						}
					}else if(Subject.equals("fin")  && count == 9){
						if(C.getText() == select.fin(random)){
							/*judge3 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge3);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge3 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge3);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.fin(random));
						}
					}else{
						if(C.getText().equals(user)){
							/*judge3 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge3);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge3 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge3);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + user);
						}
					}
					/*judge3.setBounds(45, 540, 50, 50);
					picture3.add(judge3);*/
					timer.stop();
					if(count == 10)
						next.setText("結束");
					next.setVisible(true);
				}
			});
			
			D.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					B.setVisible(false);
					C.setVisible(false);
					A.setVisible(false);
					if(Subject.equals("math")){
						if(D.getText() == select.math(random)){
							/*judge4 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge4);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge4 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge4);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.math(random));
						}
					}else if(Subject.equals("computer")){
						if(D.getText() == select.computer(random)){
							/*judge4 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge4);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge4 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge4);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.computer(random));
						}
					}else if(Subject.equals("other")){
						if(D.getText() == select.other(random)){
							/*judge4 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge4);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge4 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge4);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.other(random));
						}
					}else if(Subject.equals("fin")  && count == 9){
						if(D.getText() == select.fin(random)){
							/*judge4 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge4);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge4 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge4);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + select.fin(random));
						}
					}else{
						if(D.getText().equals(user)){
							/*judge4 = new JLabel(new ImageIcon("image/correct.png"));
							add(judge4);*/
							JOptionPane.showMessageDialog(null, "正確 !!! 加10分!!!");
							setScore(10);
							scoreText.setText(Integer.toString(getScore()));
						}else{
							/*judge4 = new JLabel(new ImageIcon("image/incorrect.png"));
							add(judge4);*/
							JOptionPane.showMessageDialog(null, "錯誤,正確答案是 " + user);
						}
					}
					/*judge4.setBounds(45, 610, 50, 50);
					picture4.add(judge4);*/
					timer.stop();
					if(count == 10)
						next.setText("結束");
					next.setVisible(true);
				}
			});
		}
	}
	
	class setMathListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			playgame.setVisible(false);
			subjectSelect = "math";
			count++;
			do{
				random = (int)(Math.random() * 4);
			}while(mathCheck[random]);
			displayIt = new display(count, random, select.math(random),score,subjectSelect);
			displayIt.setVisible(true);		
			mathCheck[random] = true;
			for(int check = 0;check < mathCheck.length;check++){
				if(mathCheck[check] == false)
					break;
				if(check == mathCheck.length - 1)
					math.setVisible(false);
			}
			if(count > 7){
				math.setVisible(false);
				computer.setVisible(false);
				other.setVisible(false);
				fin.setVisible(true);
			}
		}
	}
	
	
	class setComputerListener implements ActionListener{	
		public void actionPerformed(ActionEvent e){
			playgame.setVisible(false);
			subjectSelect = "computer";
			count++;
			do{
				random = (int)(Math.random() * 4);
			}while(compCheck[random]);
			displayIt = new display(count, random, select.computer(random),score,subjectSelect);
			displayIt.setVisible(true);		
			compCheck[random] = true;
			for(int check = 0;check < compCheck.length;check++){
				if(compCheck[check] == false)
					break;
				if(check == compCheck.length - 1)
					computer.setVisible(false);
			}
			if(count > 7){
				math.setVisible(false);
				computer.setVisible(false);
				other.setVisible(false);
				fin.setVisible(true);
			}
		}
	}
	
	
	class setOtherListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			playgame.setVisible(false);
			subjectSelect = "other";
			count++;
			do{
				random = (int)(Math.random() * 4);
			}while(otherCheck[random]);
			displayIt = new display(count, random, select.other(random),score,subjectSelect);
			displayIt.setVisible(true);		
			otherCheck[random] = true;
			for(int check = 0;check < otherCheck.length;check++){
				if(otherCheck[check] == false)
					break;
				if(check == otherCheck.length - 1)
					other.setVisible(false);
			}
			if(count > 7){
				math.setVisible(false);
				computer.setVisible(false);
				other.setVisible(false);
				fin.setVisible(true);
			}
		}
	}
	
	
	class setFinListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			playgame.setVisible(false);
			subjectSelect = "fin";
			count++;
			if (count == 9)
				displayIt = new display(count, 0, select.fin(0),score,subjectSelect);
			else
				displayIt = new display(count, 1, select.fin(1),score,subjectSelect);
			displayIt.setVisible(true);		
			
		}
	}
	
	void setScore(int plus){
		score = score + plus;
	}
	
	int getScore(){
		return score;
	}
	
	public static void main(String[] args) {
		new login();	
	}

}

class login{
	
	static JTextField setUserName = new JTextField();
	static JTextField setNumber = new JTextField();
	JLabel userName = new JLabel("姓名 : "); 
	JLabel number = new JLabel("學號 : ");
	
	login(){
		JFrame login = new JFrame();
		login.setTitle("U10316035_login");
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
					if(setUserName.getText().equals("") || setNumber.getText().equals("")){/////////////////////////////////////////////////登入資訊勿刪
						JOptionPane.showMessageDialog(null, "請輸入內容 !!!");
					}else{
						new playgame(setUserName.getText(), setNumber.getText());
						login.dispose();
					}
				}
		});
		loginIn.setBounds(250, 80, 80, 30);
		login.add(loginIn);
		login.setVisible(true);
	}
}


class question{
	String math(int para){
		switch(para){
			case 0:
				return "75 + 83 = ?";
			case 1:
				return "66 + 98 = ?";
			case 2:
				return "23 + 79 = ?";
			case 3:
				return "15 + 99 = ?";
		}
		return null;
	}
	
	String computer(int para){
		switch(para){
			case 0:
				return "15973 + 24571 = ?";
			case 1:
				return "22433 + 22433 = ?";
			case 2:
				return "32132 + 12312 = ?";
			case 3:
				return "0 + 45678 = ?";
		}
		return null;
	}
	
	String other(int para){
		switch(para){
			case 0:
				return "E = ?";
			case 1:
				return "P = ?";
			case 2:
				return "V = ?";
			case 3:
				return "0 = ?";
		}
		return null;
	}
	
	String fin(int para){
		switch(para){
			case 0:
				return "請問你的JAVA教授叫什麼名字 ?";
			case 1:
				return "你的使用者名稱是什麼 ?";
		}	
		return null;
	}
}

class answer{
	String math(int para){
		switch(para){
			case 0:
				return "158";
			case 1:
				return "164";
			case 2:
				return "102";
			case 3:
				return "114";
		}
		return null;
	}
	String computer(int para){
		switch(para){
			case 0:
				return "40544";
			case 1:
				return "44866";
			case 2:
				return "44444";
			case 3:
				return "45678";
		}	
		return null;
	}
		
	String other(int para){
		switch(para){
			case 0:
				return "mc^2";
			case 1:
				return "IV";
			case 2:
				return "IR";
			case 3:
				return "0";
		}
		return null;
	}
		
	String fin(int para){
		switch(para){
			case 0:
				return "昆翰";
			case 1:
				return "小明";
			case 2:
				return "阿福";
			case 3:
				return "助教";
			}
		return null;
	}	
}
