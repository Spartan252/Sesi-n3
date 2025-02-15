
package Actividades.Actividad_4;

import javax.swing.JOptionPane;

public class Ejer3 {

	public static void main(String[] args) {

		String Precio;

		double precio = 0;

		do {
			try {
				Precio = JOptionPane.showInputDialog("¿Cuál es el precio del producto?: ");
				if ((Precio == null) || (Precio.equals(""))) {
					precio = 0;
					break;
				}
				precio = Double.parseDouble(Precio);
				if (precio <= 0) {
					JOptionPane.showMessageDialog(null, "Introduce un número válido", "Error",
							JOptionPane.WARNING_MESSAGE);
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Teclea un número", "Formato incorrecto",
						JOptionPane.ERROR_MESSAGE);
			}
		} while (true);

		if (precio > 0) {
			double iva = precio * 1.16;
			JOptionPane.showMessageDialog(null, "Precio con IVA: $" + String.format("%.2f", iva));
		}
	}

}
