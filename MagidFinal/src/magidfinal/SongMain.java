package magidfinal;
import java.io.File;
import java.util.*;
public class SongMain {
	public static void main(String[] arg) {
		SongCollection myCollection = new SongCollection();
		Scanner keyboard = new Scanner(System.in);
		int options = -1;
		int start = -1;
		int end = -1;
		String title = "";
		String artist = "";
		String key = "";
		int pos = -1;
		String fileName = "";
		while(options != 0) {
			System.out.println("========Select action========\n" + 
					"0. Quit\n" + 
					"1. Get collection size\n" + 
					"2. Search for title\n" + 
					"3. Search for artist\n" + 
					"4. Add from file\n" + 
					"5. Save to file\n" + 
					"6. Add one song\n" + 
					"7. Remove one song\n" + 
					"8. Show");
			System.out.print("Enter Choice: ");
			options = Integer.parseInt(keyboard.nextLine());
			switch(options) {
			case 0:
			System.out.println("Thank you for using this program! Bye!");
			break;
			case 1:
			System.out.println("Collection size is " + myCollection.size() + ".");
			break;
			case 2:
			System.out.print("Enter title search key: ");
			key = keyboard.nextLine();
			myCollection.searchByTitle(key);
			break;
			case 3:
			System.out.print("Enter artist search key: ");
			key = keyboard.nextLine();
			myCollection.searchByArtist(key);
			break;
			case 4:
			System.out.print("Enter file name: ");
			fileName = keyboard.nextLine();
			File file = new File(fileName);
			myCollection.addFromFile(file);
			break;
			case 5:
			System.out.print("Enter file name: ");
			fileName = keyboard.nextLine();
			File writeFile = new File(fileName);
			myCollection.writeToFile(writeFile);
			break;
			case 6:
			System.out.print("Enter title: ");
			title = keyboard.nextLine();
			System.out.print("Enter artist: ");
			artist = keyboard.nextLine();
			myCollection.addOneSong(title, artist);
			break;
			case 7:
			System.out.print("Enter position: ");
			pos = Integer.parseInt(keyboard.nextLine());
			myCollection.delete(pos);
			break;
			case 8: 
			System.out.print("Enter start position: ");
			start = Integer.parseInt(keyboard.nextLine());
			System.out.print("Enter end position: ");
			end = Integer.parseInt(keyboard.nextLine());
			myCollection.show(start, end);
			break;
			default:
			break;
			}
		}
	}
}
