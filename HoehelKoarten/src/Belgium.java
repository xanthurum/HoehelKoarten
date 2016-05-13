import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.graphstream.algorithm.*;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Belgium 
{
	private Graph map;
	
	public Belgium()
	{
		map= new SingleGraph("Belgium");
		map();
		setLabel();
		map.addAttribute("ui.stylesheet","node{text-style : bold; text-alignment : above;}");
		map.addAttribute("ui.stylesheet","edge{text-style : bold; text-alignment : above;}");
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		map.display();
	}
	/**
	 * method which makes the actual map
	 */
	private void map()
	{
	map.setStrict(false);
	map.setAutoCreate( true );
	
	map.addEdge(Integer.toString(4), "Brugge", "Gent");
	map.getEdge(Integer.toString(4)).addAttribute("length", 50);
	map.addEdge(Integer.toString(3), "Brugge", "Kortrijk");
	map.getEdge(Integer.toString(3)).addAttribute("length", 56);
	map.addEdge(Integer.toString(5), "Brugge", "Antwerpen");
	map.getEdge(Integer.toString(5)).addAttribute("length", 95);
	map.addEdge(Integer.toString(8), "Kortrijk", "Bergen");
	map.getEdge(Integer.toString(8)).addAttribute("length", 83);
	map.addEdge(Integer.toString(13), "Gent", "Brussel");
	map.getEdge(Integer.toString(13)).addAttribute("length", 50);
	map.addEdge(Integer.toString(7), "Gent", "Antwerpen");
	map.getEdge(Integer.toString(7)).addAttribute("length", 60);
	map.addEdge(Integer.toString(14), "Antwerpen", "Brussel");
	map.getEdge(Integer.toString(14)).addAttribute("length", 44);
	map.addEdge(Integer.toString(25), "Antwerpen", "Hasselt");
	map.getEdge(Integer.toString(25)).addAttribute("length", 80);
	map.addEdge(Integer.toString(19), "Brussel", "Leuven");
	map.getEdge(Integer.toString(19)).addAttribute("length", 30);
	map.addEdge(Integer.toString(18), "Brussel", "Waver");
	map.getEdge(Integer.toString(18)).addAttribute("length", 30);
	map.addEdge(Integer.toString(16), "Brussel", "Bergen");
	map.getEdge(Integer.toString(16)).addAttribute("length", 78);
	map.addEdge(Integer.toString(23), "Bergen", "Namen");
	map.getEdge(Integer.toString(23)).addAttribute("length", 75);
	map.addEdge(Integer.toString(29), "Namen", "Neufchateau");
	map.getEdge(Integer.toString(29)).addAttribute("length", 90);
	map.addEdge(Integer.toString(38), "Namen", "Luik");
	map.getEdge(Integer.toString(38)).addAttribute("length", 65);
	map.addEdge(Integer.toString(25), "Waver", "Namen");
	map.getEdge(Integer.toString(25)).addAttribute("length", 40);
	map.addEdge(Integer.toString(29), "Leuven", "Hasselt");
	map.getEdge(Integer.toString(29)).addAttribute("length", 59);
	map.addEdge(Integer.toString(30), "Leuven", "Luik");
	map.getEdge(Integer.toString(30)).addAttribute("length", 82);
	map.addEdge(Integer.toString(41), "Hasselt", "Luik");
	map.getEdge(Integer.toString(41)).addAttribute("length", 53);
	map.addEdge(Integer.toString(33), "Luik", "Neufchateau");
	map.getEdge(Integer.toString(33)).addAttribute("length", 110);
	map.addEdge(Integer.toString(52), "Neufchateau", "Aarlen");
	map.getEdge(Integer.toString(52)).addAttribute("length", 37);
	for(Node node : map)
	{
		for(Edge edge : node)
		{
			if(edge.hasAttribute("accident")) {}
			else
			{
				edge.addAttribute("accident", 0);
			}
		}
	}
	}
	/**
	 * method which places labels on the nodes and edges
	 */
	private void setLabel()
	{
		for(Node n : map)
		{
			n.addAttribute("label", n.getId());
			switch ((String)n.getId())
			{
			case "Brugge"		: n.addAttribute("value", 1);	break;
			case "Kortrijk"		: n.addAttribute("value", 2);	break;
			case "Gent"			: n.addAttribute("value", 3);	break;
			case "Antwerpen"	: n.addAttribute("value", 4);	break;
			case "Brussel"		: n.addAttribute("value", 10);	break;
			case "Bergen"		: n.addAttribute("value", 6);	break;
			case "Waver"		: n.addAttribute("value", 8);	break;
			case "Leuven"		: n.addAttribute("value", 9);	break;
			case "Hasselt"		: n.addAttribute("value", 20);	break;
			case "Luik"			: n.addAttribute("value", 21);	break;
			case "Namen"		: n.addAttribute("value", 17);	break;
			case "Neufchateau"	: n.addAttribute("value", 12);	break;
			case "Aarlen"		: n.addAttribute("value", 40);	break;
			}
			System.out.println("case nodename : " + n.getAttribute("label")+ " value : " + n.getAttribute("value"));
			for(Edge e : n)
			{
				int x = e.getAttribute("length");
				e.addAttribute("label", x);
			}
		}
	}
	
	/**
	 * method to calculate the shortest path with the Dijkstra algorithm
	 * 
	 */
	public void shortestPath()
	{
		System.out.println("type in the starting point : ");
		Scanner scanIn = new Scanner(System.in);
	    String from = scanIn.nextLine();
	    System.out.println("type in the destination : ");
	    String to = scanIn.next();
	    System.out.println("So you want the shortest path from " + from + " to " + to);
		Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, "length", "length");
		dijkstra.init(map);
		dijkstra.setSource(map.getNode(from));
		dijkstra.compute();
		dijkstra.getPathLength(map.getNode(to));
		System.out.println(dijkstra.getPathLength(map.getNode(to)));
		List<Node> pathList = new ArrayList<Node>();
		int i = 0;
		for(Node node : dijkstra.getPathNodes(map.getNode(to)))
		{
			pathList.add(i, node);
			i++;
		}
		for(int j = pathList.size()-1; j >= 0; j--) 
		{
			Node node = pathList.get(j);
			System.out.println("city : " + node.getAttribute("label"));
			if(j > 0)
			{
				String edge = getEdgeNumber(pathList.get(j),pathList.get(j-1));
				System.out.println("The number of accidents between " + pathList.get(j).getAttribute("label") + " and " + pathList.get(j-1).getAttribute("label") + " are : " + map.getEdge(edge).getAttribute("accident"));
			}
		}	
		dijkstra.clear();
		
		System.out.println("would you like to add a new route, answer yes or no : ");
	    String answer = scanIn.next();
		if(answer.equals("yes"))
		{
			shortestPath();
			scanIn.close();
		}
		else System.exit(1);
	}
	/**
	 * method to calculate an edge label
	 * @param from
	 * @param to
	 * @return
	 */
	private String getEdgeNumber(Node from, Node to)
	{
		return Integer.toString((int)from.getAttribute("value") + (int)to.getAttribute("value"));
	}

}