package Actividades.Actividad_5;

import javax.swing.JOptionPane;

public class Ejer_1 {

    public static void main(String[] args) {

        String col = JOptionPane.showInputDialog("Escribe el número de columnas para la matriz A y B:");
        String fil = JOptionPane.showInputDialog("Escribe el número de filas para la matriz A y B:");

        int[][] A = new int[Integer.parseInt(col)][Integer.parseInt(fil)];
        int[][] B = new int[Integer.parseInt(col)][Integer.parseInt(fil)];
        int[][] C = new int[Integer.parseInt(col)][Integer.parseInt(fil)];

        for (int i = 0; i < Integer.parseInt(fil); i++) {
            for (int j = 0; j < Integer.parseInt(col); j++) {
                A[i][j] = Integer.parseInt(JOptionPane
                        .showInputDialog(
                                "Matriz A: \n Escribe el número de la columna: " + (j + 1) + " fila: " + (i + 1)));
            }
        }

        for (int i = 0; i < Integer.parseInt(fil); i++) {
            for (int j = 0; j < Integer.parseInt(col); j++) {
                B[i][j] = Integer.parseInt(JOptionPane
                        .showInputDialog(
                                "Matriz B: \n Escribe el número de la columna: " + (j + 1) + " fila: " + (i + 1)));
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
                for (int k = 0; k < C.length; k++) {
                    C[i][j] = C[i][j] + A[i][k] + B[k][j];
                }
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
                System.out.print(C[i][j] + "\t");
            }
            System.out.println();
        }
    }
}