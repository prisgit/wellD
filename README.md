# wellD
Diagramma delle Classi

Point

	Variabili d'istanza: x,y.
  
	Costruttore: Point(Double, Double)
  
	Metodi: toString(): String --> restituisce una stringa con le coordinate del punto inserite tra parentesi tonde e separate da virgola --> "(x1, y1)"
  
	Getters&Setters

Line

	Variabili d'istanza: a, b, vertical.
	
	Costruttore: Line(Point[] couple) --> data una coppia di punti restituisce la retta che passa per quei due punti calcolando i valori di a, b e vertical
	
	Metodi: 
	
	Getters&Setters
	

Pattern 

	Variabili d'istanza: patternPoints.
	
	Costruttore: Pattern(Line, List<Point>) --> data una retta e una lista di punti, verifica se i punti appartengono alla retta e, se sì, li inserisce in patternPoints
	
	Metodi:
	
	Getters&Setters
	

Util 

	Variabili d'istanza: 
	
	Metodi: 
		getCouplesOfPoints(Map<Integer, Point>): List<Point[]> --> data una mappa di punti, restituisce tutte le diverse coppie di punti (non ci sono duplicati)
		getLines(List<Point[]>): List<Line> --> data una lista di coppie di punti, restituisce tutte le linee che passano per quelle coppie di punti (possono esserci       duplicati se sulla stessa linea giacciono più punti)
		trasformaListaPuntiInMappaPunti(List<Point>): Map<Integer, Point> --> data una lista di punti restituisce una mappa degli stessi punti, cioè una lista di punti dove ogni punto ha un identificativo numerico
		
	Getters&Setters
	

Space   

	Variabili d'istanza: List<Point>. 
	
	Costruttore: Space(List<Point>)
	
	Metodi: 
		addPoint(Point): void --> aggiunge un punto allo space
		getAllPoints(): List<Point> --> restituisce una lista di tutti i punti dello space
		getAllPatterns(int n): Set<List<Point>> --> restituisce il set di pattern che soddisfano il requisito di essere composti da almeno n punti
		removeAllPoints(): void --> rimuove tutti i punti dallo space
		
	Getters&Setters
