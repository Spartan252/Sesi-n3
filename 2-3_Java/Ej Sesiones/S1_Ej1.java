/*
 * Este es mi primer programa en Java
 */

public class S1_Ej1 {

	/**
	 * Este es el método donde inicia la ejecución
	 * del programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hola mundo"); // Imprimir

		int i = 100;

		System.out.printf("i = %x\n", i);

		System.out.println("i = " + i);

		int a = 123_456_789;

		float f1 = 1.5f;
		float f2 = (float) 1.5;

		System.out.printf("f1 = %5.2f\n", f1);

		System.out.println("f1 = " + f1);

		String s1 = "f1 vale " + f1 + " y f2 vale " + f2;
		System.out.println(s1);
		System.out.println("El string s1 tiene " + s1.length() + " caracteres");

	}

}