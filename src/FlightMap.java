import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlightMap {
	protected Map<Character, HashMap<Character, Integer>> map;
	
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
		
	protected int getCost(String route) {
		int cost = 0;
		for(int i=0; i < route.length() - 1; i++) {
			cost += this.map.get(route.charAt(i)).get(route.charAt(i+1));
		}
		return cost;
	}
}
