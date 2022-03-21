package stefano.pastori.wellD_Maven;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Util {
	
	public static List<Point> readPoints() {
		List<Point> points = new ArrayList<>();
		try {
			JSONParser parser = new JSONParser();
			Reader r = new FileReader("points.json");
			JSONArray jsonArray = (JSONArray) parser.parse(r);//path to the JSON file.
			for (Object o : jsonArray) {
				if (o != null) {
					JSONObject point = (JSONObject) o;
					double x = (double) point.get("x");
					double y = (double) point.get("y");
					System.out.println("x = " + x + ", y = " + y);
					Point p = new Point(x,y);
					points.add(p);
				}
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return points;
	}
	
	//metodo di utilità che data una mappa di punti, restituisce tutte le diverse coppie di punti (non ci sono duplicati)
	public static List<Point[]> getCouplesOfPoints(Map<Integer, Point> pointsMap) {
		List<Point[]> couples = new ArrayList<>();
		for (int i = 0; i < pointsMap.size()-1; i++) {
			for (int j = i+1; j < pointsMap.size(); j++) {
				Point[] couple = new Point[2];
				couple[0] = new Point(pointsMap.get(i).getX(), pointsMap.get(i).getY());
				couple[1] = new Point(pointsMap.get(j).getX(), pointsMap.get(j).getY());
				couples.add(couple);
			}
		}
		return couples;
	}
	
	//metodo di utilità che data una lista di coppie di punti, restituisce tutte le linee passanti per le coppie di punti
	//(possono esserci duplicati se sulla stessa linea giacciono più punti)
	public static List<Line> getLines(List<Point[]> couples) {
		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < couples.size(); i++) {
			Line l = new Line(couples.get(i));
			lines.add(l);
		}
		return lines;
	}
	
	
	//metodo di utilità che trasforma una lista di punti in mappa di punti
	public static Map<Integer, Point> trasformaListaPuntiInMappaPunti(List<Point> points) {
		Map<Integer, Point> pointsMap = new HashMap<>();
		for (int i = 0; i < points.size(); i++) {	//da una lista di punti costruisco una mappa, 
			pointsMap.put(i, points.get(i));		//cio� una lista di punti dove ogni punto ha un identificativo numerico
		}
		return pointsMap;
	}

}
