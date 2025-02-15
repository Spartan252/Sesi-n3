
public class Box extends Shape3D {
	double ancho;
	double altura;
	double longitud;

	public Box(double x, double y, double z, double ancho,
			double altura, double longitud) {
		super(x, y, z);
		this.ancho = Math.max(0, Math.min(ancho, 100));
		this.altura = Math.max(0, Math.min(altura, 100));
		this.longitud = Math.max(0, Math.min(longitud, 100));
	}

	public double calcularVolumen() {
		return longitud * ancho * altura;
	}

	public double calcularAS() {
		double AreaSuperior = longitud * ancho;
		double areaLado1 = longitud * altura;
		double areaLado2 = ancho * altura;
		return 2 * (AreaSuperior + areaLado1 + areaLado2);
	}

	public String toString() {
		return super.toString() + String.format("ancho %f\n altura %f\n longitud %f\n  volumen: %f\n  area: %f", ancho,
				altura, longitud, calcularVolumen(), calcularAS());
	}
}
