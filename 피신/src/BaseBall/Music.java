package BaseBall;

public class Music {
	protected String title;
	protected String singer;
	protected String path;
	
	
	
	
	public Music(String title, String singer, String path) {
		super();
		this.title = title;
		this.singer = singer;
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Music() {}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}

}
