package patternRecognition_WellD;

import java.util.ArrayList;
import java.util.List;

public class Pattern {
	//variabili d'istanza
	List<Point> patternPoints = new ArrayList<>();
	
	//costruttori
	public Pattern(Line line, List<Point> points) {
		double a = line.getA();
		double b = line.getB();
		boolean vertical = line.isVertical();
		double x;
		double y;
		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			x = p.getX();
			if (!(vertical)) {
				y = p.getY();
				if (y == ((a * x) + b)) {
					patternPoints.add(p);
				}
			} else {			//essendo la retta verticale, l'equazione è del tipo "x = x1" e recupero il valore di "x1" da "a"
				if (x == a) {	//se x = a significa che il punto appartiene alla retta verticale
					patternPoints.add(p);	
				}
			}
		}		
	}
	
	//altri metodi
	public String toString() {
		String pointsListStr = "";
		for (Point p : patternPoints) {
			pointsListStr += p;
		}
		return "{" + pointsListStr + "}";	
	}

	//getters&setters
	public List<Point> getPatternPoints() {
		return patternPoints;
	}
	

	
}
