package knowledge;

public class npc {
	int who;
	npc(int whoIsit){
		who = whoIsit;
	}
	String winTalk(int random){
		if(who == 11){
			switch(random){
			case 0:
				return "啊不是很厲害?";
			case 1:
				return "嫩!";
			case 2:
				return "弱!";
			case 3:
				return "哈ㄏ哈ㄚ";
			}
		}else{
			switch(random){
			case 0:
				return "同學你要被當囉~";
			case 1:
				return "呵呵呵";
			case 2:
				return "這裡我們教過了，\n回去好好念書";
			case 3:
				return "不是我想當你，\n但你的成績......";
			}
		}
		return null;	 
	}
	String loseTalk(int random){
		if(who == 11){
			switch(random){
			case 0:
				return "0912345678，\n有種打電話過來?";
			case 1:
				return "啊不就好棒棒?";
			case 2:
				return "北車等你來";
			case 3:
				return "很強?";
			}
		}else{
			switch(random){
			case 0:
				return "很厲害";
			case 1:
				return "有進步喔!";
			case 2:
				return "課堂成績加0.5分!";
			case 3:
				return "不錯喔";
			}
		}
		return null;	 
	}
}
