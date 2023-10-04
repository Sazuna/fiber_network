package fiber_network;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class World {

	private final int SIZE=1000;

	private ArrayList<Node> nodes = new ArrayList<Node>();

	private ArrayList<Link> links = new ArrayList<Link>();
	
	private final int NNODES = 100;
	
	public World()
	{
		nodes = new ArrayList<Node>();
		for (int i = 0; i < NNODES; i++)
		{
			nodes.add(new Node(SIZE)); // Nodes that we must link.
		}
	}

	public double getLoss()
	{
		double res = 0;
		for (Link l: links)
		{
			res += l.getDistance();
		}
		return res;
	}

	public static void main(String[] args)
	{
		World w = new World();
		w.stepOne();


		/*
		Link init_link = new Link(nodes.get(0), nodes.get(1));
		links.add(init_link);
		System.out.println("Distance of initial link: " + init_link.getDistance());
		System.out.println("Loss: " + getLoss());
		 */

	}

	// Step one: link every node to its nearest node.

	public void stepOne()
	{
		int nLinks = nodes.size() - 1;
		//Stack<Node> toLink = (Stack<Node>) nodes.clone();
		//System.out.println(toLink.pop());
		ArrayList<Node> alreadyLinked = new ArrayList<Node>();
		ArrayList<Node> toLink = (ArrayList<Node>) nodes.clone();
		alreadyLinked.add(nodes.get(0));
		toLink.remove(0);
		System.out.println(toLink + "\n" + alreadyLinked);
		while (toLink.size() > 0)
		{
			double bestScore = SIZE * SIZE + 1;
			Link bestLink = new Link(new Node(SIZE), new Node(SIZE));
			for (Node node1: toLink)
			{
				for (Node node2: alreadyLinked)
				{
					double score = node1.getDistance(node2);
					if (score < bestScore)
					{
						bestScore = score;
						bestLink = new Link(node1, node2, score);
					}
				}
			}
			links.add(bestLink);
			toLink.remove(bestLink.getNode1());
			alreadyLinked.add(bestLink.getNode1());
		}
		/*
			double bestScore = SIZE*SIZE+1;
			Link bestLink = new Link(new Node(), new Node());
			for (int j = 0; j < nLinks; j++)
			{
				if (i == j) continue;
				Node node1 = nodes.get(i);
				Node node2 = nodes.get(j);
				Link link = new Link(nodes.get(i), nodes.get(j));
				double score = link.getDistance();
				if (score <= bestScore)
				{
					bestScore = score;
					bestLink = link;
				}
			}
			links.add(bestLink);


		}*/
		for (Link l: links)
			System.out.println(l);
		System.out.println(getLoss());
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		nodes = nodes;
	}

	public ArrayList<Link> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Link> links) {
		links = links;
	}

	public int getNNODES() {
		return NNODES;
	}

	public int getSize() {
		return SIZE;
	}
	
	// Step two: try to add some movable nodes inbetween.

}
