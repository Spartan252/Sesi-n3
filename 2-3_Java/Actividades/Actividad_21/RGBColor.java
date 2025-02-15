package Actividades.Actividad_21;

public class RGBColor {
	private int red=0;
	private int green=0;
	private int blue=0;

	public RGBColor() {
	}
	
	public RGBColor(int red, int green, int blue) throws InvalidColorValueException {
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}
	
	// throws indica que este método lanza
	public void setRed(int red) throws InvalidColorValueException {
		if(red>=0 && red<=255)
			this.red = red;
		else
			throw new InvalidColorValueException("Red",red);
			// lanza la excepción
	}
	public void setGreen(int green) throws InvalidColorValueException {
		if(green>=0 && green<=255)
			this.green = green;
		else
			throw new InvalidColorValueException("Green",green);
	}
	public void setBlue(int blue) throws InvalidColorValueException {
		if(blue>0 && blue<=255)
			this.blue = blue;
		else
			throw new InvalidColorValueException("Blue",blue);
	}
	
	public int getRed() {
		return red;
	}
	public int getGreen() {
		return green;
	}
	public int getBlue() {
		return blue;
	}
	
	@Override
	public String toString() {
		return "RGBColor [red=" + red + ", green=" + green + ", blue=" + blue + "]";
	}
	
}
