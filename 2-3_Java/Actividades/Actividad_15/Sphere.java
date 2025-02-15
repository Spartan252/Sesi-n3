
public class Sphere extends Shape3D {
	private double radio;

	public Sphere(double x, double y, double z, double radio) {
		super(x, y, z);
		this.radio = Math.max(0, Math.min(radio, 100));
	}

	public double calcularVolumen() {
		return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
	}

	public double calcularAS() {
		return 4 * Math.PI * Math.pow(radio, 2);
	}

	public String toString() {
		return super.toString()
				+ String.format("radio %f\n, volumen: %f\n area: %f", radio, calcularVolumen(), calcularAS());
	}
}
