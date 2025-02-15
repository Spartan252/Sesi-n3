package Actividades.Actividad_8;

import javax.swing.JOptionPane;

public class RGB_Color {

	private int red = 0;
	private int green = 0;
	private int blue = 0;

	// Constructores
	public  RGBColor() {
		int red = Integer.parseInt(JOptionPane.showInputDialog(null, "Intensidad del rojo (0-255)"));
        int green = Integer.parseInt(JOptionPane.showInputDialog(null, "Intensidad del verde (0-255)"));
        int blue = Integer.parseInt(JOptionPane.showInputDialog(null, "Intensidad del azul (0-255)"));
	}

	public RGBColor(int side) {
		setRed(side);
		setGreen(side);
		setBlue(side);
	}

	public RGBColor(int red, int green, int blue) {
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}

	// Setters
	public void setRed(int r) {
		if (r >= 1 && r <= 255)
			red = r;
	}

	public void setGreen(int g) {
		if (g >= 1 && g <= 255)
			green = g;
	}

	public void setBlue(int b) {
		if (b >= 1 && b <= 255)
			blue = b;
	}

	// Getters
	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}

	// String
	public String toString(int red, int green, int blue) {
		return "{\"Rojo\":" + red + ",\"Verde\":" + green + ",\"Azul\":" + blue + "}";
	}

	// Clone
	public RGBColor clone() {
		return new RGBColor(red, green, blue);
	}

	// Equals
	public boolean equals(Object o) {
		boolean retVal = false;
		if (o instanceof RGBColor) {
			RGBColor rec = (RGBColor) o;
			retVal = rec.getRed() == red && rec.getGreen() == green && rec.getBlue() == blue;
		}
		return retVal;
	}

}
