package Actividades.Actividad_2;

import javax.swing.JOptionPane;

public class Ejer_2 {
    public static void main(String[] args) {
        String distancia = JOptionPane.showInputDialog("Escribe la distancia recorrida en kilómetros:");
        String t_inicial = JOptionPane.showInputDialog("Escribe la hora de inicio en minutos a partir de la hora 0:");
        String t_final = JOptionPane.showInputDialog("Escribe la hora final en minutos a partir de la hora 0");

        double tiempo = Double.parseDouble(t_final) - Double.parseDouble(t_inicial);

        String velocidad = Double.toString(Double.parseDouble(distancia) / (tiempo / 60));

        JOptionPane.showMessageDialog(null, velocidad + " km/h ", "Velocidad promedio", 2);

    }
}