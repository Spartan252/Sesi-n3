package Actividades.Actividad_8;

public class UseRectangle {

    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = r1.clone();
        Rectangle r3 = new Rectangle(5, 15);

        r2 = null;
        System.gc();

    }
}
