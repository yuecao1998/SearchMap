import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestFlightMap {
	
	@org.junit.Test
	public void testGetMap() {
		
		FlightMap flightMap = new FlightMap();
		List<String> content = new ArrayList<>();
		content.add("P W 200");
		content.add("P R 300");
		content.add("W S 200");
		flightMap.getMap(content);
		assertEquals(200, (int)flightMap.map.get('P').get('W'));	
		assertEquals(300, (int)flightMap.map.get('P').get('R'));
		assertEquals(200, (int)flightMap.map.get('W').get('S'));
	}
	
	
	@org.junit.Test
	public void testGetRoute() {
		FlightMap map = new FlightMap();
		List<String> content = new ArrayList<>();
		content.add("P W 200");
		content.add("P R 300");
		content.add("W S 200");
		map.getMap(content);
		Set<Character> arrived = new HashSet<>();
		List<String> route = new ArrayList<>();
		map.getRoute('P', "P", arrived, route);
		assertEquals(route.get(0), "PR");
		assertEquals(route.get(1), "PW");
		assertEquals(route.get(2), "PWS");	
	}
	
	@org.junit.Test
	public void testGetCost() {
		FlightMap map = new FlightMap();
		List<String> content = new ArrayList<>();
		content.add("P W 200");
		content.add("P R 300");
		content.add("W S 200");
		content.add("S T 100");
		map.getMap(content);
		assertEquals(map.getCost("PW"), 200);
		assertEquals(map.getCost("PWS"), 400);
	}



}
