import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Belgium 
{
	private Graph map;
	
	public Belgium()
	{
		map= new SingleGraph("Belgium");
		map();
		map.display();
	}
	
	private void map()
	{
	map.setStrict(false);
	map.setAutoCreate( true );
	
	map.addEdge("BruggeGent", "Brugge", "Gent");
	map.addEdge("BruggeKortrijk", "Brugge", "Kortrijk");
	map.addEdge("BruggeAntwerpen", "Brugge", "Antwerpen");
	map.addEdge("KortrijkBergen", "Kortrijk", "Bergen");
	map.addEdge("GentBrussel", "Gent", "Brussel");
	map.addEdge("GentAntwerpen", "Gent", "Antwerpen");
	map.addEdge("AntwerpenBrussel", "Antwerpen", "Brussel");
	map.addEdge("AntwerpenHasselt", "Antwerpen", "Hasselt");
	map.addEdge("BrusselLeuven", "Brussel", "Leuven");
	map.addEdge("BrusselWaver", "Brussel", "Waver");
	map.addEdge("BrusselBergen", "Brussel", "Bergen");
	map.addEdge("BergenNamen", "Bergen", "Namen");
	map.addEdge("NamenNeufchateau", "Namen", "Neufchateau");
	map.addEdge("NamenLuik", "Namen", "Luik");
	map.addEdge("WaverNamen", "Waver", "Namen");
	map.addEdge("LeuvenHasselt", "Leuven", "Hasselt");
	map.addEdge("LeuvenLuik", "Leuven", "Luik");
	map.addEdge("HasseltLuik", "Hasselt", "Luik");
	map.addEdge("LuikNeufchateau", "Luik", "Neufchateau");
	map.addEdge("NeufchateauAarlen", "Neufchateau", "Aarlen");
	}
	
	
	
	
	
		
	
	
}
