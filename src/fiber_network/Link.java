package fiber_network;

public class Link {

	private Node node1;
	private Node node2;
	private double distance;
	
	public Link(Node node1, Node node2, double distance)
	{
		this.node1 = node1;
		this.node2 = node2;
		this.distance = distance;
	}

	public Node getNode1() {
		return node1;
	}

	public void setNode1(Node node1) {
		this.node1 = node1;
	}

	public Node getNode2() {
		return node2;
	}

	public void setNode2(Node node2) {
		this.node2 = node2;
	}

	public Link(Node node1, Node node2)
	{
		this.node1 = node1;
		this.node2 = node2;
		computeDistance();
	}
	
	public void computeDistance()
	{
		this.distance = Math.pow(node1.getX() - node2.getX(), 2) + Math.pow(node1.getY() - node2.getY(), 2);
	}
	
	public double getDistance()
	{
		return this.distance;
	}
	
	public String toString()
	{
		return "First Node: " + node1.toString() + "\tSecond node: " + node2.toString() + "\tdistance: " + getDistance();
	}
	

}
