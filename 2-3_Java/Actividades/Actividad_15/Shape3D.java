
public abstract class Shape3D {
	protected double x;
	protected double y;
	protected double z;

	public Shape3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;

	}

	public abstract double calcularVolumen();

	public abstract double calcularAS();

	public String toString() {
		return String.format("Coordenada x: %f\n Coordenada y: %f\n Coordenada z: %f\n", x, y, z);
	}
}
