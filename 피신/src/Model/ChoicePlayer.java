package Model;

import java.util.Random;

public class ChoicePlayer {
	protected PlayerDAO player = new PlayerDAO();
	protected Random ran = new Random();
	
	public PlayerVO Choice () {
		int i = ran.nextInt(99)+1;
		PlayerVO vo = player.outPutPlayer(i);
		vo.print();
		return vo;
	}
	

	
	


}
