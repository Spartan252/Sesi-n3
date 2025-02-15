
package Actividades.Actividad_5;

public class Ejer2 {

	public static void main(String[] args) {

		short[] V = { 17, 72, 29, 67, 60, 53, 86 };
		short x = 50;

		int contv1 = 0;
		int contv2 = 0;

		for (short num : V) {
			if (num > x) {
				contv1++;
			}
			if (num % 2 != 0) {
				contv2++;
			}
		}

		short[] V1 = new short[contv1];
		short[] V2 = new short[contv2];

		int iv1 = 0;
		int iv2 = 0;

		for (short num : V) {
			if (num > x) {
				V1[iv1] = num;
				iv1++;
			}
			if (num % 2 != 0) {
				V2[iv2] = num;
				iv2++;
			}
		}
		System.out.print("V: ");
		for (int i = 0; i < V.length; i++) {
			System.out.print(V[i]);
			if (i < V.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();

		System.out.print("V1: ");
		for (int i = 0; i < V1.length; i++) {
			System.out.print(V1[i]);
			if (i < V1.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();

		System.out.print("V2: ");
		for (int i = 0; i < V2.length; i++) {
			System.out.print(V2[i]);
			if (i < V2.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();

	}

}
