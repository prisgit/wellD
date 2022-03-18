package patternRecognition_WellD;

public class Line {	//y = a * x + b;
	//variabili d'istanza
	private double a;
	private double b;
	private boolean vertical;
	
	//costruttori
	public Line(Point[] couple) {
		double x1 = couple[0].getX();
		double y1 = couple[0].getY();
		double x2 = couple[1].getX();
		double y2 = couple[1].getY();
		if (x1 != x2) {
			setA((y2 - y1)/(x2 - x1));
			setB(((x2 * y1) - (x1 * y2))/(x2 - x1));
			setVertical(false);
		} else {
			setVertical(true);
			a = x1;				//siccome l'equazione che rappresenta la retta è "x = x1", passo il valore di "x1" attraverso "a"
			b = 0;
		}
		
	}

	//altri metodi

	
	//getters&setters
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public boolean isVertical() {
		return vertical;
	}

	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}
	
}
