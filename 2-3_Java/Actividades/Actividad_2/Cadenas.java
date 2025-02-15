
package Actividades.Actividad_2;

public class Cadenas {

    public static void main(String[] args) {
        String s1 = "Hola";
        String s2 = "Hola";
        String s3 = new String("Hola");

        if (s1 == s2)
            System.out.println("s1 == s2");
        if (s1 == s3)
            System.out.println("s1 == s3");

        if (s1.equals(s2))
            System.out.println("s1 igual a s2");

        if (s1.equals(s3))
            System.out.println("s1 igual a s3");

    }

}