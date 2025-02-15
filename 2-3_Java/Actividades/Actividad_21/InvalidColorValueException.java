package Actividades.Actividad_21;

public class InvalidColorValueException extends RuntimeException {
	private String colorName;
	private int colorValue;
	
	public InvalidColorValueException(String colorName,int colorValue) {
		super("InvalidColorValueException");
		this.colorName = colorName;
		this.colorValue = colorValue;
	}
	
	public String toString() {
		return getMessage() + "\nInvalid color"+
				colorName+"="+colorValue;
	}

}
