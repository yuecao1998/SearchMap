import java.awt.event.MouseWheelEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sound.sampled.Line;


public class SearchMap {
	
	protected static String getRouteString(String route) {
		
		String temp = "";
		for(int i=0; i < route.length()-1; i++) {
			temp += route.charAt(i) + ",";
		}
		temp += route.charAt(route.length()-1);
		return temp;
	}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String infile = args[0];
		String outfile = args[1];
		
		FlightMap map = new FlightMap();
		List<String> content = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new FileReader(infile));
		char origin = reader.readLine().charAt(0);
		String line;
		while((line = reader.readLine()) != null) {
			content.add(line);
		}
		
		map.getMap(content);
			
		
		List<String> result = new ArrayList<>();
		Set<Character> arrived = new HashSet<>();
		arrived.add(origin);
		map.getRoute(origin, "P", arrived, result);
		
		PrintWriter pw = new PrintWriter(new FileWriter(outfile));
		pw.println("Destination    " + "Flight Route from " + origin + "        " + "Total Cost" );
		
		for(String s: result) {
			int cost = map.getCost(s);
			pw.print(s.charAt(s.length()-1) + "              ");
			String route = getRouteString(s);
			char[] spaces = new char[27 - route.length()];
			Arrays.fill(spaces, ' ');
			pw.print(route + new String(spaces));
			pw.println("$" + cost);
		}
		
		
	}

}
