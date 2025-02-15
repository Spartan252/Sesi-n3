package Actividades.Actividad_3;

import javax.swing.JOptionPane;

public class DistanciaYTiempo {
    public static void main(String[] args) {
        String vel_prom = JOptionPane.showInputDialog("Escribe la velocidad promedio en km/h:");
        String d_fal = JOptionPane.showInputDialog("Escribe la distancia que falta en km:");
        String tiempo = JOptionPane.showInputDialog("Escribe en cuanto tiempo tiene que llegar en minutos");

        double vel_fal = Double.parseDouble(d_fal) / (Double.parseDouble(tiempo) / 60);

        if (vel_fal > Double.parseDouble(vel_prom)) {
            JOptionPane.showMessageDialog(null, "No alcanzará a llegar a su destino a tiempo", "Estado de llegada", 0);
        } else if (vel_fal <= Double.parseDouble(vel_prom)) {
            JOptionPane.showMessageDialog(null, "Alcanzará a llegar a su destino a tiempo", "Estado de llegada", 2);
        }

    }
}
