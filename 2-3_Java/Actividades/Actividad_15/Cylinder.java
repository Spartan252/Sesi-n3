
public class Cylinder extends Shape3D {
	private double radio;
	private double altura;

	public Cylinder(double x, double y, double z, double radio, double altura) {
		super(x, y, z);
		this.radio = Math.max(0, Math.min(radio, 100));
		this.altura = Math.max(0, Math.min(radio, 100));
	}

	public double calcularVolumen() {
		return Math.PI * Math.pow(radio, 2) * altura;
	}

	public double calcularAS() {
		double baseArea = Math.PI * Math.pow(radio, 2);
		double lArea = 2 * Math.PI * radio * altura;
		return 2 * baseArea * lArea;
	}

	public String toString() {
		return super.toString() + String.format("radio %f\n altura %f\n volumen: %f\n  area: %f", radio, altura,
				calcularVolumen(), calcularAS());
	}

}
