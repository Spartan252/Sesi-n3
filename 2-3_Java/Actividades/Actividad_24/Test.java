package Actividades.Actividad_24;

public class Test {
        public static void main(String[] args) {

        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = r1.clone();
        Rectangle r3 = new Rectangle(5, 15);
        
        System.out.println("r1: " + r1);
        System.out.println("r1 Area: " + r1.getArea());

        System.out.println("r2: " + r2);
        System.out.println("r2 Area: " + r2.getArea());

        System.out.println("r3: " + r3);
        System.out.println("r3 Area: " + r3.getArea());
        

    }
}
