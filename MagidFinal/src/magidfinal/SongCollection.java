package magidfinal;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.*;
public class SongCollection {
	
	private Song theSongs[];
	public SongCollection() {
		this.theSongs = new Song[0];
	}
	public int size() {
		return theSongs.length;
	}
	
	public void addFromFile(File f) {
		try {
			String title ="";
			String artist="";
			Scanner scnr = new Scanner(f);
			String line = scnr.nextLine();
			int numOfSongs = Integer.parseInt(line);
	        Song[] merged = Arrays.copyOf( theSongs, numOfSongs+this.size());
	        for(int i = this.size(); i < merged.length; i++) {
	        	title = scnr.nextLine();
	        	artist = scnr.nextLine();
	        	Song newSong = new Song(title,artist);
	        	merged[i] = newSong;
	        }
	        this.theSongs = merged;
	        scnr.close();
		}catch(Exception FileNotFoundException){
			System.out.println("We could not find the file you entered, please try again or use another option!");
		}
	}
	
	public void writeToFile(File f) {
		try {
		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
	    writer.write("" + this.size() + "\n");
	    for(int i = 0; i < this.size(); i++) {
	    	writer.write(theSongs[i].getTitle() + "\n");
	        writer.write(theSongs[i].getArtist() + "\n");
	    }
	    writer.close();
		}catch(Exception FileNotFoundException) {
			System.out.println("We could not find the file you entered, please try again or use another option!");
		}
	}
	
	 public void addOneSong( String t, String a ) {
         Song[] merged = Arrays.copyOf( theSongs,this.size()+1);
         Song newSong = new Song(t,a);
         merged[merged.length-1] = newSong;
         theSongs = merged;
	 }
	  public void delete( int pos ) {
		  if(pos-1 >= 0 && pos-1 < this.size()) {
			  this.theSongs[pos] = null;
			  for(int i = pos; i < this.size()-1; i++) {
				  Song temp = this.theSongs[i];
				  this.theSongs[i] = this.theSongs[i+1];
				  this.theSongs[i+1] = temp;
			  }
			  this.theSongs = Arrays.copyOfRange(this.theSongs, 0,this.size()-1);
		  }
	  }
	  
	  public void searchByTitle( String key ) {
		  for(int i = 0; i < this.size(); i++) {
			  String title = this.theSongs[i].getTitle();
			  if(title.contains(key) || key.contains(title)) {
				  System.out.println((i) + ": " + this.theSongs[i].getTitle() + ", " + this.theSongs[i].getArtist());
			  }
		  }
	  }
	  public void searchByArtist( String key ) {
		  for(int i = 0; i < this.size(); i++) {
			  String artist = this.theSongs[i].getArtist();
			  if(artist.contains(key) || key.contains(artist)) {
				  System.out.println((i) + ": " + this.theSongs[i].getTitle() + ", " + this.theSongs[i].getArtist());
			  }
		  }
	  }
	  public void show( int start, int end ) {
		  if(start < 0) {
			  start = 0;
		  }
		  if(end > this.size()) {
			  end = this.size();
		  }
		  for(int i = start; i < end; i++) {
			 System.out.println((i) + ": " + this.theSongs[i].getTitle() + ", " + this.theSongs[i].getArtist());
		  }
	  }
}
