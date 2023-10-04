package fiber_network;

public class MovableNode extends Node {
	public MovableNode(int SIZE) {
		super(SIZE);
	}

	/***
	 * Nodes that can be moved in order to personalize the network's architecture.
	 */

	public void setY(int y) {
		super.y = y;
	}

	public void setX(int x) {
		super.x = x;
	}
}
