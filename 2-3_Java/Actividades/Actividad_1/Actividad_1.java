
package Actividades.Actividad_1;

public class Actividad_1 {
    public static void main(String[] args) {

        int N = 25;
        double A = 92.52;
        char C = 'a';
        int G = (int) C;

        System.out.println("Variable N = " + N);
        System.out.println("Variable A = " + A);
        System.out.println("Variable C = " + C);

        double suma = (double) N + A;
        double resta = A - (double) N;

        System.out.printf("%d + %f = %.2f \n", N, A, suma);
        System.out.printf("%f - %d = %.2f \n", A, N, resta);

        System.out.printf("Valor numérico del carácter %c = %d", C, G);

        System.out.println("\n% 60= " + 124 / 60);
        System.out.println("\n(sec / 60) *60: " + (124 / 60) * 60);
        System.out.println("\nResult " + 124 / 60 + " min, " + (124 - ((124 / 60) * 60)) + "seg");

    }
}