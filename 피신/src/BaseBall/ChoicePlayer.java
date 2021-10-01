package BaseBall;

import java.util.Random;

public class ChoicePlayer {
	protected PlayerDAO player = new PlayerDAO();
	protected Random ran = new Random();
	
	public PlayerVO Choice () {
		int i = ran.nextInt(120)+1;
		PlayerVO vo = player.outPutPlayer(i);
		vo.print();
		return vo;
	}
	

	
	


}
