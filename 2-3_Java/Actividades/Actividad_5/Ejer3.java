
package Actividades.Actividad_5;

public class Ejer3 {

	public static void main(String[] args) {

		int min = 2;
		int max = 20;
		int range = max - min + 1;

		int R = (int) (Math.random() * range) + min;

		int[][] lines = new int[R][];
		for (int i = 0; i < R; i++) {
			lines[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				lines[i][j] = i + 1;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(lines[i][j] + " ");
			}
			System.out.println();
		}

	}

}
