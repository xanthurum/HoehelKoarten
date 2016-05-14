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
	
	map.addEdge(getEdgeNumber("Brugge", "Gent"), "Brugge", "Gent");
	map.getEdge(getEdgeNumber("Brugge", "Gent")).addAttribute("length", 50);
	map.addEdge(getEdgeNumber("Brugge", "Kortrijk"), "Brugge", "Kortrijk");
	map.getEdge(getEdgeNumber("Brugge", "Kortrijk")).addAttribute("length", 56);
	map.addEdge(getEdgeNumber("Brugge", "Antwerpen"), "Brugge", "Antwerpen");
	map.getEdge(getEdgeNumber("Brugge", "Antwerpen")).addAttribute("length", 95);
	map.addEdge(getEdgeNumber("Kortrijk", "Bergen"), "Kortrijk", "Bergen");
	map.getEdge(getEdgeNumber("Kortrijk", "Bergen")).addAttribute("length", 83);
	map.addEdge(getEdgeNumber("Gent", "Brussel"), "Gent", "Brussel");
	map.getEdge(getEdgeNumber("Gent", "Brussel")).addAttribute("length", 50);
	map.addEdge(getEdgeNumber("Gent", "Antwerpen"), "Gent", "Antwerpen");
	map.getEdge(getEdgeNumber("Gent", "Antwerpen")).addAttribute("length", 60);
	map.addEdge(getEdgeNumber("Antwerpen", "Brussel"), "Antwerpen", "Brussel");
	map.getEdge(getEdgeNumber("Antwerpen", "Brussel")).addAttribute("length", 44);
	map.addEdge(getEdgeNumber("Antwerpen", "Hasselt"), "Antwerpen", "Hasselt");
	map.getEdge(getEdgeNumber("Antwerpen", "Hasselt")).addAttribute("length", 80);
	map.addEdge(getEdgeNumber("Brussel", "Leuven"), "Brussel", "Leuven");
	map.getEdge(getEdgeNumber("Brussel", "Leuven")).addAttribute("length", 30);
	map.addEdge(getEdgeNumber("Brussel", "Waver"), "Brussel", "Waver");
	map.getEdge(getEdgeNumber("Brussel", "Waver")).addAttribute("length", 30);
	map.addEdge(getEdgeNumber("Brussel", "Bergen"), "Brussel", "Bergen");
	map.getEdge(getEdgeNumber("Brussel", "Bergen")).addAttribute("length", 78);
	map.addEdge(getEdgeNumber("Bergen", "Namen"), "Bergen", "Namen");
	map.getEdge(getEdgeNumber("Bergen", "Namen")).addAttribute("length", 75);
	map.addEdge(getEdgeNumber("Namen", "Neufchateau"), "Namen", "Neufchateau");
	map.getEdge(getEdgeNumber("Namen", "Neufchateau")).addAttribute("length", 90);
	map.addEdge(getEdgeNumber("Namen", "Luik"), "Namen", "Luik");
	map.getEdge(getEdgeNumber("Namen", "Luik")).addAttribute("length", 65);
	map.addEdge(getEdgeNumber("Waver", "Namen"), "Waver", "Namen");
	map.getEdge(getEdgeNumber("Waver", "Namen")).addAttribute("length", 40);
	map.addEdge(getEdgeNumber("Leuven", "Hasselt"), "Leuven", "Hasselt");
	map.getEdge(getEdgeNumber("Leuven", "Hasselt")).addAttribute("length", 59);
	map.addEdge(getEdgeNumber("Leuven", "Luik"), "Leuven", "Luik");
	map.getEdge(getEdgeNumber("Leuven", "Luik")).addAttribute("length", 82);
	map.addEdge(getEdgeNumber("Hasselt", "Luik"), "Hasselt", "Luik");
	map.getEdge(getEdgeNumber("Hasselt", "Luik")).addAttribute("length", 53);
	map.addEdge(getEdgeNumber("Luik", "Neufchateau"), "Luik", "Neufchateau");
	map.getEdge(getEdgeNumber("Luik", "Neufchateau")).addAttribute("length", 110);
	map.addEdge(getEdgeNumber("Neufchateau", "Aarlen"), "Neufchateau", "Aarlen");
	map.getEdge(getEdgeNumber("Neufchateau", "Aarlen")).addAttribute("length", 37);
	for(Node node : map)
	{
		for(Edge edge : node)
		{
			if(edge.hasAttribute("accident")) {}
			else
			{
				edge.addAttribute("accident", 0);
				edge.addAttribute("chance", 0.00);
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
				String edge = getEdgeNumber((String)pathList.get(j).getAttribute("label"),(String)pathList.get(j-1).getAttribute("label"));
				checkAccident(map.getEdge(edge));
				adjustEdgeWeight(map.getEdge(edge));
				System.out.println("The number of accidents between " + pathList.get(j).getAttribute("label") + " and " + pathList.get(j-1).getAttribute("label") + " are : " 
				+ map.getEdge(edge).getAttribute("accident") + " the chance for an other one is " + map.getEdge(edge).getAttribute("chance") + " the length is : " + map.getEdge(edge).getAttribute("length"));
			}
		}	
		dijkstra.clear();
		
		System.out.println("would you like to add a new route, answer yes or no : ");
	    String answer = scanIn.next();
		if(answer.equals("yes"))
		{
			shortestPath();	
		}
		else System.exit(1);
	}
	/**
	 * method to calculate an edge label
	 * @param from
	 * @param to
	 * @return
	 */
	private String getEdgeNumber(String from, String to)
	{
		int temp =0;
		char[] first = from.toCharArray();
		for(char n : first)
		{
			temp = temp + (int)n;
		}
		char[] second = from.toCharArray();
		for(char n : second)
		{
			temp = temp + (int)n;
		}
		if(from.charAt(0) > to.charAt(0))
		{
			temp = temp + (int)from.charAt(0);
		}
		else
		{
			temp = temp + (int)to.charAt(0);
		}
		return Integer.toString(temp);
	}
	/**
	 * method to get the result of a check on teh chance of an accident
	 * @param chance
	 * @return boolean 
	 */
	private void checkAccident(Edge edge)
	{
		double chance = (double)edge.getAttribute("chance");
		double d = Math.random();
		d = d + chance;
		if (d  > 0.5) 
		{
			double a = Math.random();
			a = a + chance;
			if(a < 0.6)
			{
				edge.setAttribute("accident", (int)edge.getAttribute("accident")+1);
			}
		}
	}
	
	private void adjustEdgeWeight(Edge edge)
	{
		int accident = (int)edge.getAttribute("accident");
		if(accident == 0)
		{
			edge.setAttribute("length", (int)edge.getAttribute("length")+1);
			edge.setAttribute("chance", (double)edge.getAttribute("chance")+0.01);
		}
		else if(accident == 1)
		{
			edge.setAttribute("length", (int)edge.getAttribute("length")+30);
			edge.setAttribute("chance", (double)edge.getAttribute("chance")+0.3);
		}
		else
		{
			for(int i = accident; i > 0; i--)
			{
				edge.setAttribute("length", (int)edge.getAttribute("length")+50);
				edge.setAttribute("chance", (double)edge.getAttribute("chance")+0.5);
			}
		}
	}
}