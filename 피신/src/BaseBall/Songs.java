package BaseBall;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class Songs {
	protected MP3Player mp3 =new MP3Player();
	ArrayList<Music> songs = new ArrayList<>();
	int pointer = 0;
	boolean onOff = true;
	
	
	public Songs() {
		songs.add(new Music("야구bgm","모름..","C:\\Users\\smhrd\\Desktop\\Music\\Song1.mp3"));
		songs.add(new Music());
		songs.add(new Music());
		songs.add(new Music());

	}
	
	public void play(String name) {
		if(!mp3.isPlaying()) {
			for(int i = 0; i< songs.size(); i++) {
				if( songs.get(i).getTitle() == name)
					pointer = i;
					mp3.play(songs.get(pointer).getPath());
			}
		}
	}
	
	public void Stop() {
		if(mp3.isPlaying()) mp3.stop();
		else mp3.play(songs.get(pointer).getPath());
		
		
	}
	
	
	
		


}
