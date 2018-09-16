import static org.junit.Assert.*;

import org.junit.Test;

public class TestSearchMap {

	@Test
	public void testGetRouteString() {
		assertEquals(SearchMap.getRouteString("PWR"), "P,W,R");
		assertEquals(SearchMap.getRouteString("ABCDE"), "A,B,C,D,E");
	}

}
