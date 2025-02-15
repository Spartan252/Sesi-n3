package Actividades.Actividad_8;

import java.util.Random;

public class Ex_2 {
    public static void main(String[] args) {
        int n = 10000;
        for (int i = 1; i <= n; i++) {

            int m = 10000000;

            double[] arreglo = new double[m];

            for (int x = 0; x < m; x++) {
                Random rndm = new Random();
                double R = rndm.nextInt();
                arreglo[0] = R;

            }
            System.out.println(arreglo[0]);
        }
    }
}
