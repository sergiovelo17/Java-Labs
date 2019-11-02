package lab11;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Scanner;  // Import the Scanner class
import java.io.*;
import java.util.LinkedList;
import java.util.Queue; 

public class PathFinder {
	
	public static void solveMaze(String inputFile, String outputFile) {
	   try {
		BufferedReader input = new BufferedReader(new FileReader(inputFile));
		String[] dimensions = input.readLine().split(" "); 
		Queue<Node> Q = new LinkedList<Node>();
		int height = Integer.parseInt(dimensions[0]);
		int width = Integer.parseInt(dimensions[1]);
		int startY = -1;
		int startX = -1;
		int goalX = -1;
		int goalY= -1;
		Node nodes[][];
		nodes = new Node[height][width];
		for(int i = 0; i < height; i++) {
			String line = input.readLine();
			for(int j = 0; j < width; j++) {
				if(line.charAt(j) == 'S') {
					startY = i;
					startX = j;
				}
				if(line.charAt(j) == 'G') {
					goalY = i;
					goalX = j;
				}
				if(line.charAt(j) == 'X') {
					nodes[i][j] = null;
				}else {
					nodes[i][j] = new Node(line.charAt(j),i,j);
				}
			}
		}
		Q.add(nodes[startY][startX]);
		Node currentNode = null;
		while(!Q.isEmpty()){
			currentNode = Q.remove();
			if(currentNode.data != 'G') {
				if(nodes[currentNode.row-1][currentNode.column] != null && nodes[currentNode.row-1][currentNode.column].visited == false) {
					Q.add(nodes[currentNode.row-1][currentNode.column]);
					nodes[currentNode.row-1][currentNode.column].visited = true;
					nodes[currentNode.row-1][currentNode.column].cameFrom = nodes[currentNode.row][currentNode.column];
				}
				if(nodes[currentNode.row+1][currentNode.column] != null && nodes[currentNode.row+1][currentNode.column].visited == false) {
					Q.add(nodes[currentNode.row+1][currentNode.column]);
					nodes[currentNode.row+1][currentNode.column].visited = true;
					nodes[currentNode.row+1][currentNode.column].cameFrom = nodes[currentNode.row][currentNode.column];
				}
				if(nodes[currentNode.row][currentNode.column-1] != null && nodes[currentNode.row][currentNode.column-1].visited == false) {
					Q.add(nodes[currentNode.row][currentNode.column-1]);
					nodes[currentNode.row][currentNode.column-1].visited = true;
					nodes[currentNode.row][currentNode.column-1].cameFrom = nodes[currentNode.row][currentNode.column];
				}
				if(nodes[currentNode.row][currentNode.column+1] != null && nodes[currentNode.row][currentNode.column+1].visited == false) {
					Q.add(nodes[currentNode.row][currentNode.column+1]);
					nodes[currentNode.row][currentNode.column+1].visited = true;
					nodes[currentNode.row][currentNode.column+1].cameFrom = nodes[currentNode.row][currentNode.column];
				}
			}else {
				break;
			}
		}
		if(currentNode.data == 'G') {
		while(currentNode.data != 'S') {
			currentNode = currentNode.cameFrom;
			if(currentNode.data == ' ') {
				currentNode.data = '.';
			}
		}
		}
		try {
		BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
		String firstLine = "" + height + " " + width + "\n";
		output.write(firstLine);
		for(int i = 0; i < height; i++) {
			firstLine = "";
			for(int j = 0; j < width; j++) {
				if(nodes[i][j] == null) {
					firstLine += "X";
				}else {
				firstLine += "" + nodes[i][j].data;
				}
			}
			firstLine += "\n";
			output.write(firstLine);
		}
		output.close();
		input.close();
		System.out.println("Found route! Check it out!!!");
		}catch (Exception e)
	   {
		    System.err.format("Exception occurred trying to read '%s'.", outputFile);

	   }
		//printMap(nodes,height,width);
	   }
	   catch (Exception e)
	   {
		    System.err.format("Exception occurred trying to read '%s'.", inputFile);

	   }

	}

	public static void printMap(Node[][] nodes,int height,int width) {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				System.out.print(nodes[i][j].data);
			}
			System.out.println();
		}
	}
	public static void main(String[] arg) {
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Welcome, enter a maze to solve");
	    String fileName = myObj.nextLine();
		System.out.println("Welcome, enter a maze file to write to");
	    String outputFile = myObj.nextLine();
	    solveMaze(fileName,outputFile);
	    myObj.close();
	}
}