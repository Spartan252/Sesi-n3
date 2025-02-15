package Actividades.Actividad_4;

import javax.swing.JOptionPane;

public class Ejer_2 {

    public static void main(String[] args) {

        String repeticiones = JOptionPane.showInputDialog("Escribe cuántas sumas tendrá la serie de Leibniz:");

        double pi = 0;
        double s = 1;
        for (int i = 1, j = 1; i <= Integer.parseInt(repeticiones); i++, j += 2) {
            pi += s / j;
            s = -s;
        }
        double serie = pi * 4;
        JOptionPane.showMessageDialog(null, "Resultado de la serie de Leibniz: " + serie, "Resultado operación", 2);

    }

}
