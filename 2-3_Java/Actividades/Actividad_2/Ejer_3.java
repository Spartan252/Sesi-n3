package Actividades.Actividad_2;

import javax.swing.JOptionPane;

public class Ejer_3 {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Escribe tu primer nombre:");
        String ape_pat = JOptionPane.showInputDialog("Escribe tu apellido paterno:");
        String ape_mat = JOptionPane.showInputDialog("Escribe tu apellido materno:");

        String nom_com = nombre + " " + ape_pat + " " + ape_mat;
        System.out.println("Nombre = " + nom_com);

        JOptionPane.showMessageDialog(null, nom_com, "Nombre completo", 0);

    }
}
