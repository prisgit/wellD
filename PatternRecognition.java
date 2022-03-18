package patternRecognition_WellD;

public class PatternRecognition {	
	
	public static void main(String[] args) {
		Space s = new Space(Util.readPoints());
		s.printPoints(s.getAllPoints());
		int n = 4;
		s.printPatterns(n, s.getAllPatterns(n));
		Point p = new Point(5,7);
		s.addPoint(p);
		s.printPointAdded(p);
		s.printPoints(s.getAllPoints());
		s.printPatterns(n, s.getAllPatterns(n));
		s.removeAllPoints();
		s.printMessageRemove();
		s.printPoints(s.getAllPoints());
	}

}
