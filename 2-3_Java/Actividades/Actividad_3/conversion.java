
package Actividades.Actividad_3;

public class conversion {
    public static void value_color(String hex, float list[]) {

        for (int i = 0; i < 6; i += 2) {
            list[i / 2] = Integer.parseInt("" + hex.charAt(i) + hex.charAt(i + 1), 16);

        }

    }

    public static float max(float list[]) {
        float max = list[0];
        for (int i = 1; i < list.length; i++)
            if (max < list[i])
                max = list[i];
        return max;
    }

    public static void main(String[] args) {

        /*
         * Desarrolla un programa en Java que a través de un cuadro de diálogo solicite
         * al usuario un valor hexadecimal
         * cuyo significado será un color RGB (Red-Green-Blue), por ejemplo un dato de
         * entrada puede ser F05BA8,
         * lo cual significa que: la intensidad del rojo es F0 (240 en decimal),
         * la intensidad del verde es 5B (91 en decimal) y la intensidad del azul es A8
         * (168 en decimal).
         * Este color deberá convertirse al formato CMYK (Cyan-Magenta-Yellow-Black) y
         * mostrar los valores (C,M,Y,K)
         * en otro cuadro de diálogo.
         */
        // ----------------------------
        // String colorRGB = JOptionPane.showInputDialog("Enter in hexadecimal a RGB
        // color");
        String colorRGB = "91349B";
        float list[] = { 0, 0, 0 };
        // last color is black, menaing position 3
        float cmyk[] = { 0 };
        value_color(colorRGB, list);
        // prints

        for (int i = 0; i < 3; i++)
            list[i] = list[i] / 255;
        for (int i = 0; i < 3; i++)
            System.out.println(list[i]);

        cmyk[3] = 1 - max(list);
        for (int i = 0; i < list.length; i++) {
            cmyk[i] = (1 - list[i] - cmyk[3]) / (1 - cmyk[3]);
        }
        for (int i = 0; i < 3; i++)
            System.out.println(cmyk[i]);

        // C:\Users\herrg\IdeaProjects\FirstSubProyects\src\Main.java
        // trim string
        // take first 2 characters and make it a number
        // take the second to characters and make it numbers so on
        // easy calculations, and transform back to hexadecimal

        // ---------------------------
    }
}
