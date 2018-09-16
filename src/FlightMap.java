import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlightMap {
	protected Map<Character, HashMap<Character, Integer>> map;
	
	/**
	 * This function reads all flight routes and their costs, and store the information into
	 * the map variable
	 * @param content A list of strings in "OriginCity DestCity FLightCost" format
	 */
	protected void getMap(List<String> content){
		Map<Character, HashMap<Character, Integer>> map = new HashMap<>();
		
		for(String line: content) {
			
			String [] chars = line.trim().split(" ");
			char from = chars[0].charAt(0);
			char to = chars[1].charAt(0);
			int cost = Integer.parseInt(chars[2]);
			if (!map.containsKey(from)) {
				map.put(from, new HashMap<Character, Integer>());
				map.get(from).put(to, cost);
			} else {
				map.get(from).put(to, cost);
			}
			
		}
		this.map = map;
	}
		
	/**
	 * This function gets all paths starting from the origin city
	 * @param origin The original city
	 * @param curr The current cities in the route. Contains only the origin city at the begining.
	 * @param arrived The set of cities to which we already find a route. Contains only
	 * the origin city at the beginning.
	 * @param list Empty at the beginning. Will contain all routes from origin city after the function call.
	 */
	protected void getRoute(char origin, String curr, Set<Character> arrived, List<String> list){
		if (this.map.get(origin) != null) {
			for(Map.Entry<Character, Integer> entry: this.map.get(origin).entrySet()) {
				char dest = entry.getKey();
				System.out.println(dest);
				if (curr.indexOf(dest) == -1) {
					if (!arrived.contains(dest)) {
						String newStr = new String(curr) + dest;
						list.add(new String(curr) + dest);
						arrived.add(dest);
						getRoute(dest, newStr, arrived, list);
					}
				}
			}
		}
	}
		
	/**
	 * This function computes the flight cost given a certain route
	 * @param route The string that contains all the city names on the route.
	 * @return The flight cost of this route.
	 */
	protected int getCost(String route) {
		int cost = 0;
		for(int i=0; i < route.length() - 1; i++) {
			cost += this.map.get(route.charAt(i)).get(route.charAt(i+1));
		}
		return cost;
	}
}
