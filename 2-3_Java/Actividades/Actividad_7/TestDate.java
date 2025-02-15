package Actividades.Actividad_7;

public class TestDate {
    public static void main(String[] args) {
        Date d_1 = new Date(2003, 7, 3);
        Date d_2 = new Date(2002, 12, 5);
        Date d_3 = new Date(2002, 5, 11);
        Date d_4 = new Date(2003, 8, 16);
        Date d_5 = new Date(2003, 12, 17);
        Date d_6 = new Date(2001, 9, 11);

        System.out.println(d_1.toString());
        System.out.println(d_2.toString());
        System.out.println(d_3.toString());
        System.out.println(d_4.toString());
        System.out.println(d_5.toString());
        System.out.println(d_6.toString());

        d_1.print();
        d_2.print();
        d_3.print();
        d_4.print();
        d_5.print();
        d_6.print();

    }
}
