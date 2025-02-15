package Actividades.Actividad_4;

import javax.swing.JOptionPane;
import java.util.Random;

public class Ejer_1 {

    public static void main(String[] args) {

        String password = "";

        Random rndm = new Random();
        int largo = rndm.nextInt(10);

        System.out.println("El largo de la contraseña es : " + largo);

        int i = 0;

        do {
            int n_l = rndm.nextInt(2);

            if (n_l == 0) {
                char caracter = (char) (rndm.nextInt(91) + 65);

                if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z'))
                    password += caracter;
                else
                    i -= 1;
            } else if (n_l == 1) {
                password += rndm.nextInt(10);
            }
            i++;

        } while (i < largo);
        System.out.println("La contraseña es: " + password);

        // Creación de contraseña arriba, verificación abajo

        int intentos = 0;
        String in_password = "";

        do {
            in_password = JOptionPane.showInputDialog("Escribe la contraseña:");

            if (in_password.equals(""))
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");

            else if (in_password.equals(password) != true) {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                intentos++;

            } else if (in_password.equals(null))
                break;

        } while (in_password.equals(password) != true);

        JOptionPane.showMessageDialog(null, "Total de intentos = " + intentos, "Contraseña correcta", 2);
    }
}