import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Belgium 
{
	private Graph map;
	
	public Belgium()
	{
		map= new SingleGraph("Belgium");
		map();
		setLabel();
		map.addAttribute("ui.stylesheet","Node{text-style : bold; text-alignment : above;}");
		map.addAttribute("ui.stylesheet","Edge{text-style : bold; text-alignment : above;}");
		System.setProperty("gs.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		map.display();
	}
	
	private void map()
	{
	map.setStrict(false);
	map.setAutoCreate( true );
	
	map.addEdge("BruggeGent", "Brugge", "Gent");
	map.getEdge("BruggeGent").addAttribute("weight", 50);
	map.addEdge("BruggeKortrijk", "Brugge", "Kortrijk");
	map.getEdge("BruggeKortrijk").addAttribute("weight", 56);
	map.addEdge("BruggeAntwerpen", "Brugge", "Antwerpen");
	map.getEdge("BruggeAntwerpen").addAttribute("weight", 95);
	map.addEdge("KortrijkBergen", "Kortrijk", "Bergen");
	map.getEdge("KortrijkBergen").addAttribute("weight", 83);
	map.addEdge("GentBrussel", "Gent", "Brussel");
	map.getEdge("GentBrussel").addAttribute("weight", 50);
	map.addEdge("GentAntwerpen", "Gent", "Antwerpen");
	map.getEdge("GentAntwerpen").addAttribute("weight", 60);
	map.addEdge("AntwerpenBrussel", "Antwerpen", "Brussel");
	map.getEdge("AntwerpenBrussel").addAttribute("weight", 44);
	map.addEdge("AntwerpenHasselt", "Antwerpen", "Hasselt");
	map.getEdge("AntwerpenHasselt").addAttribute("weight", 80);
	map.addEdge("BrusselLeuven", "Brussel", "Leuven");
	map.getEdge("BrusselLeuven").addAttribute("weight", 30);
	map.addEdge("BrusselWaver", "Brussel", "Waver");
	map.getEdge("BrusselWaver").addAttribute("weight", 30);
	map.addEdge("BrusselBergen", "Brussel", "Bergen");
	map.getEdge("BrusselBergen").addAttribute("weight", 78);
	map.addEdge("BergenNamen", "Bergen", "Namen");
	map.getEdge("BergenNamen").addAttribute("weight", 75);
	map.addEdge("NamenNeufchateau", "Namen", "Neufchateau");
	map.getEdge("NamenNeufchateau").addAttribute("weight", 90);
	map.addEdge("NamenLuik", "Namen", "Luik");
	map.getEdge("NamenLuik").addAttribute("weight", 65);
	map.addEdge("WaverNamen", "Waver", "Namen");
	map.getEdge("WaverNamen").addAttribute("weight", 40);
	map.addEdge("LeuvenHasselt", "Leuven", "Hasselt");
	map.getEdge("LeuvenHasselt").addAttribute("weight", 59);
	map.addEdge("LeuvenLuik", "Leuven", "Luik");
	map.getEdge("LeuvenLuik").addAttribute("weight", 82);
	map.addEdge("HasseltLuik", "Hasselt", "Luik");
	map.getEdge("HasseltLuik").addAttribute("weight", 53);
	map.addEdge("LuikNeufchateau", "Luik", "Neufchateau");
	map.getEdge("LuikNeufchateau").addAttribute("weight", 110);
	map.addEdge("NeufchateauAarlen", "Neufchateau", "Aarlen");
	map.getEdge("NeufchateauAarlen").addAttribute("weight", 37);
	}
	
	private void setLabel()
	{
		for(Node n : map)
		{
			n.addAttribute("label", n.getId());
			for(Edge e : n)
			{
				int x = e.getAttribute("weight");
				e.addAttribute("label", x);
			}
		}
	}
	
	
}
