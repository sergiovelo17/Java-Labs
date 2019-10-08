package magid;

import java.util.Scanner;
import java.io.*;
public class TreasureHunting{
	static Scanner sc = new Scanner(System.in); 
	static int trueX, trueY;
	static int prevX, prevY;
	static int nowX, nowY;
	static int prevDistance, nowDistance;
	static final int CLOSE = 3;
	static final int FAR = 6;
	
    public static void main(String[] args) {
    openingMessage();
    initialize();
	System.out.println(trueX + " " + trueY);
	for(int i = 1; i <= 10; i++) {
		System.out.println("---- Round " + i + " ----");
		System.out.println(trueX + ", " + trueY);
		recieveGuess();
		if(nowDistance == 0) {
			System.out.println("Treasure found!!!!");
			break;
		}
    	checkDistance();
    	if(i > 1) {
    		advise();
    	}
		show();
	}
   }
    
    public static void openingMessage(){
	System.out.println("#######################################################\n" + 
				"# A treasure has been hidden at a location in a 10x10 #\n" + 
				"# gird. Guess where it is. You have 10 chances.       #\n" + 
				"#######################################################");
	}
    
    public static void initialize() {
    	trueX = (int)(Math.random() * 10) + 1;
    	trueY = (int)(Math.random() * 10) + 1;
    	nowDistance = 20;
    }
    public static void recieveGuess() {
    	prevDistance = nowDistance;
    	prevY = nowY;
    	prevX = nowX;
    	System.out.print("Enter your guess for X, Y: ");
    	nowX = sc.nextInt(); 
    	nowY = sc.nextInt(); 
    	nowDistance = (Math.abs(nowX - trueX)) + (Math.abs(nowY-trueY));
    }
    public static void show() {
    	for(int i = 10; i >= 1; i--) {
    		for(int j = 1; j <= 10; j++) {
    			if(j == nowX && i == nowY) {
    				System.out.print("@ ");
    			}else if(nowDistance != 20 && j == prevX && i == prevY) {
    				System.out.print("P ");
    			}else if(j == 10) {
    				System.out.println(i);
    			}else {
    				System.out.print(". ");
    			}
    		}
    	}
    	System.out.println("@ = current, P = previous\n");
    }
    
    public static void checkDistance() {
    	if(nowDistance <= CLOSE) {
    		System.out.println("The distance is no more than 3.");
    	}else if(nowDistance > CLOSE && nowDistance <= FAR) {
    		System.out.println("The distance is no more than 6.");
    	}else {
    		System.out.println("The distance is more than 6.");
    	}
    }
    
    public static void advise() {
    	if(nowDistance - prevDistance == 0) {
    		System.out.println("The same distance");
    	}else if(nowDistance - prevDistance > 0) {
    		System.out.println("You are farther");
    	}else if(nowDistance - prevDistance < 0) {
    		System.out.println("You are closer");
    	}
    }
}