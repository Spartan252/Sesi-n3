package Actividades.Actividad_13;

public class TestDateTime {
    public static void main(String[] args) {

        // A
        DateTime dt1 = new DateTime();
        System.out.println("\nA = dt1: " + dt1);

        // B
        DateTime dt2 = new DateTime();
        dt2.setDateTime(0, 26, 03);
        System.out.println("\nB = dt2: " + dt2);

        // C
        DateTime dt3 = new DateTime();
        dt3.setDateTime(11, 59, 59);
        dt3.setDate(2017, 12, 31);
        System.out.println("\nC = dt3: " + dt3);

        // D
        DateTime dt4 = new DateTime();
        // dt_4 = dt_3.Next();
        System.out.println("\nD = dt4 = dt3.Next: " + dt4);

        // E
        Date d5 = new Date();
        d5.setDate(2017, 12, 31);
        System.out.println("\nE = d5: " + d5);

        // F

        // G
        DateTime dt6 = new DateTime();
        dt6 = dt2.clone();
        if (dt2.equals(dt6))
            System.out.println("\nG = dt2 y su clon son iguales: " + "\ndt2: " + dt2 + "\ndt6: " + dt6);
        else
            System.out.println("\nG = dt2 y su clon no son iguales: " + "\ndt2: " + dt2 + "\ndt6: " + dt6);

        // H
        if (dt3.equals(d5) && d5.equals(dt3))
            System.out.println("\nH = dt3 y d5 son iguales:" + "\ndt3: " + dt3 + "\nd5: " + d5);
        else
            System.out.println("\nH = dt3 y d5 no son iguales:" + "\ndt3: " + dt3 + "\nd5: " + d5);

        // I
        Date d6 = dt3.clone();
        if (d6.equals(d5))
            System.out.println("\nI = la fecha de dt3 y d5 son iguales:" + "\ndt3: " + dt3 + "\nd5: " + d5);
        else
            System.out.println("\nI = la fecha de dt3 y d5 no son iguales:" + "\ndt3: " + dt3 + "\nd5: " + d5);
    }
}
