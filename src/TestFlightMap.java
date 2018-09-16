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
	
	




}
