package BaseBall;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class Songs {
	protected MP3Player mp3 =new MP3Player();
	ArrayList<Music> songs = new ArrayList<>();
	int pointer = 0;
	boolean onOff = true;
	
	
	public Songs() {
		songs.add(new Music("�߱�bgm","��..","Player\\Song1.mp3"));
		songs.add(new Music("Ŭ��bgm","��..", "Player\\Song1.mp3"));
		songs.add(new Music("��Ʈbgm","��..", "Player\\Song1.mp3"));
		songs.add(new Music("�Լ�bgm","��..", "Player\\Song1.mp3"));
		songs.add(new Music("������bgm","��..", "Player\\Song1.mp3"));

	}
	
	public void play(String name) {
		if(mp3.isPlaying()) {
			mp3.stop();
		}
		if(true) {
			for(int i = 0; i< songs.size(); i++) {
				if( songs.get(i).getTitle().equals(name))
					pointer = i;
					mp3.play(songs.get(pointer).getPath());
			}
		}
	}
	
	public void stop() {
		for(int i =0; i < 30; i++) {
			mp3.stop();
		}
		
	}
	
	
	
		


}
