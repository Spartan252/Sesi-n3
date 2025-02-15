package Actividades.Actividad_3;

import javax.swing.JOptionPane;

public class DiasMeses {
    public static void main(String[] args) {
        String mes = JOptionPane.showInputDialog("Escribe el nombre del mes:");
        String año = JOptionPane.showInputDialog("Escribe el año:");

        mes = mes.toUpperCase().trim();

        switch (mes) {
            case "ENERO":
                JOptionPane.showMessageDialog(null, "Enero tiene 31 días", "Días del mes", 2);
                break;

            case "FEBRERO":
                if ((Integer.parseInt(año) % 4 == 0)
                        && ((Integer.parseInt(año) % 100 != 0) || (Integer.parseInt(año) % 400 == 0)))
                    JOptionPane.showMessageDialog(null, "Enero tiene 29 días", "Días del mes", 2);
                else
                    JOptionPane.showMessageDialog(null, "Enero tiene 28 días", "Días del mes", 2);
                break;

            case "MARZO":
                JOptionPane.showMessageDialog(null, "Marzo tiene 31 días", "Días del mes", 2);
                break;

            case "ABRIL":
                JOptionPane.showMessageDialog(null, "Abril tiene 30 días", "Días del mes", 2);
                break;

            case "MAYO":
                JOptionPane.showMessageDialog(null, "Mayo tiene 31 días", "Días del mes", 2);
                break;

            case "JUNIO":
                JOptionPane.showMessageDialog(null, "Junio tiene 30 días", "Días del mes", 2);
                break;

            case "JULIO":
                JOptionPane.showMessageDialog(null, "Julio tiene 31 días", "Días del mes", 2);
                break;

            case "AGOSTO":
                JOptionPane.showMessageDialog(null, "Agosto tiene 31 días", "Días del mes", 2);
                break;

            case "SEPTIEMBRE":
                JOptionPane.showMessageDialog(null, "Septiembre tiene 30 días", "Días del mes", 2);
                break;

            case "OCTUBRE":
                JOptionPane.showMessageDialog(null, "Octubre tiene 31 días", "Días del mes", 2);
                break;

            case "NOVIEMBRE":
                JOptionPane.showMessageDialog(null, "Noviembre tiene 30 días", "Días del mes", 2);
                break;

            case "DICIEMBRE":
                JOptionPane.showMessageDialog(null, "Diciembre tiene 31 días", "Días del mes", 2);
                break;
        }

    }
}
