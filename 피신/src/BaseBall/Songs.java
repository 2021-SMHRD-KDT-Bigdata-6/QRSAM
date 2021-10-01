package BaseBall;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class Songs {
	protected MP3Player mp3 =new MP3Player();
	ArrayList<Music> songs = new ArrayList<>();
	int pointer = 0;
	boolean onOff = true;
	
	
	public Songs() {
		songs.add(new Music("야구bgm","모름..","Music\\Song1.mp3"));
		songs.add(new Music("클릭bgm","모름..", "Music\\Song2.mp3"));
		songs.add(new Music("베트bgm","모름..", "Music\\Song3.mp3"));
		songs.add(new Music("함성bgm","모름..", "Music\\Song4.mp3"));
		songs.add(new Music("마무리bgm","모름..", "Music\\Song5.mp3"));

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
		if(mp3.isPlaying()) {
			
			mp3.stop();
			
		}
		
	}
	
	
	
		


}
