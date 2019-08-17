package formas;

public class Quadrado implements Forma {
	
	private double lado;
	
	public Quadrado(double lado) {
		this.lado = lado;
	}
	
	public double area() {
		return lado*lado;
	}

}
