package fiber_network;

import java.util.Random;

public class Node {
	
	protected int x;
	protected int y;
	private static Random r = new Random();
	
	public Node(int SIZE)
	{
		x = r.nextInt(SIZE);
		y = r.nextInt(SIZE);
	}
	
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getDistance(Node node)
	{
		return Math.pow(this.getX() - node.getX(), 2) + Math.pow(this.getY() - node.getY(), 2);
	}

}
