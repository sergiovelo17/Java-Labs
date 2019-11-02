package lab11;

public class Node{
	
	public char data;
	public boolean visited;
	public Node cameFrom;
	public int row;
	public int column;
	public Node(char inputData, int i, int j){
		visited = false;
		cameFrom = null;
		this.data = inputData;
		this.row = i;
		this.column = j;
	}
}