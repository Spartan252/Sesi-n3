package Actividades.Actividad_5;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class Ejer_4 {
    public static void main(String[] args) {

        String lar = JOptionPane.showInputDialog("Escribe el número de calificaciones a capturar:");

        float[] calif = new float[Integer.parseInt(lar)];

        int i = 0;
        while (i < Integer.parseInt(lar)) {
            calif[i] = Float.parseFloat(JOptionPane.showInputDialog("Escribe la calificación " + (i + 1)));
            i++;
        }

        // ACOMODADOR
        Arrays.sort(calif);

        // MEDIANA
        float mediana;
        if (Integer.parseInt(lar) % 2 == 0) {

            int div = (Integer.parseInt(lar) / 2);
            mediana = (calif[div - 1] + calif[div]) / 2;
        }

        else {
            int div = (Integer.parseInt(lar) / 2);
            mediana = calif[div];
        }

        JOptionPane.showMessageDialog(null, "La mediana de las calificaciones es: \n" + mediana, "Resultado mediana",
                2);
    }
}
