package patternRecognition_WellD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Space {
	//variabili d'istanza
	private List<Point> points;
	
	//costruttori
	public Space(List<Point> list) {
		points = list;
	}
	
	//altri metodi
	public void addPoint(Point p) {		//è una delle specifiche: "Add a point to the space"
		if (p != null) {
			points.add(p);
		}
	}
	
	public List<Point> getAllPoints() {	//è una delle specifiche: "Get all points in the space"
		return points;
	}

	public Set<List<Point>> getAllPatterns(int n) {	//è una delle specifiche: "Get all line segments passing through at least N points. Note that a line segment should be a set of points."
		List<Line> lines = new ArrayList<>();
		List<Point> patternPoints = new ArrayList<>();
		Set<List<Point>> patterns = new HashSet<>();
		lines = Util.getLines(Util.getCouplesOfPoints(Util.trasformaListaPuntiInMappaPunti(points)));	
		for (int i = 0; i < lines.size(); i++) {
			Line line = lines.get(i);
			Pattern pattern = new Pattern(line, points);
			patternPoints = pattern.getPatternPoints();
			if (patternPoints.size() >= n) {
				patterns.add(patternPoints);
			}
		}
		return patterns;
	}

	public void removeAllPoints() {
		for (int i = 0; i < points.size(); i++) {	//è una delle specifiche: "Remove all points from the space"
			points.removeAll(points);						//rimuovo tutti i punti dalla mappa
		}
	}

	public void printPoints(List<Point> points) {
		System.out.println("All points in the space: " + points);
	}
	
	public void printPointAdded(Point p) {
		System.out.println("New point " + p.toString() + " added");
	}
	
	public void printPatterns(int n, Set<List<Point>> patterns) {
		System.out.println("All line segments passing through at least " + n + " points: " + patterns);
	}
	
	public void printMessageRemove() {
		System.out.println("All points have been removed from the space");	
	}
	
	//getters&setters
	
}