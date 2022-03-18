package patternRecognition_WellD;

public class Point {
	//variabili d'istanza
	private double x;
	private double y;
	
	//costruttori
	public Point(double x, double y) {
		setX(x);
		setY(y);
	}

	//altri metodi
	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}
	
	//getters&setters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
