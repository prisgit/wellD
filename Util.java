package patternRecognition_WellD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Util {
	static List<Point> list = new ArrayList<>();
	
	static {
		list.add(new Point(2,4));
		list.add(new Point(4,8));
		list.add(new Point(3,6));
		list.add(new Point(5,10));
		list.add(new Point(1,1));
		list.add(new Point(0,0));
		list.add(new Point(5,5));
		list.add(new Point(6,1));
		list.add(new Point(1,5));
		list.add(new Point(5,0));
//		list.add(null);
	}
	
	public static List<Point> readPoints() {
		return rimuoviNull(list);
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
			pointsMap.put(i, points.get(i));		//cioè una lista di punti dove ogni punto ha un identificativo numerico
		}
		return pointsMap;
	}

	private static List<Point> rimuoviNull(List<Point> points) {
		Iterator<Point> iterator = list.iterator();
		while (iterator.hasNext()) {
			Point p = iterator.next();
			if (p == null) {	
				iterator.remove();			//rimuovo tutti gli oggetti null
			}
		}
		return points;
	}
}
