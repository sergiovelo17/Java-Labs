package magidfinal;

public class Song {
	String title;
	String artist;
	
	public Song(String userTitle, String userArtist) {
		this.title = userTitle;
		this.artist = userArtist;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
}
