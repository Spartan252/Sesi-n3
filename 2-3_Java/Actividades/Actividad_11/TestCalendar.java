package Actividades.Actividad_11;

import java.util.Calendar;

public class TestCalendar {

    public static void main(String[] args) {

        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();

        System.out.println("Dia:" + d1.get(Calendar.DAY_OF_MONTH));
        System.out.println("Mes:" + (d1.get(Calendar.MONTH) + 1));
        System.out.println("Año:" + d1.get(Calendar.YEAR));
        System.out.println("Hora:" + d1.get(Calendar.HOUR_OF_DAY));

        d2.set(Calendar.DAY_OF_MONTH, 23);
        d2.set(Calendar.MONTH, Calendar.SEPTEMBER);
        d2.set(Calendar.YEAR, 2021);

        System.out.println("Dia:" + d2.get(Calendar.DAY_OF_MONTH));
        System.out.println("Mes:" + (d2.get(Calendar.MONTH) + 1));
        System.out.println("Año:" + (d2.get(Calendar.YEAR) - 1));

        if (d1.before(d2)) {
            System.out.println("La fecha mas antigua es: " + d1.getTime());
        } else {
            System.out.println("La fecha mas antigua es: " + d2.getTime());
        }
        d1.add(Calendar.WEEK_OF_YEAR, 2);
        d1.add(Calendar.YEAR, -4);
        System.out.println("Despues de sumar 2 sem y restar 4 años:" + d1.getTime());
        Calendar t1 = Calendar.getInstance();
        Calendar dt1 = Calendar.getInstance();
        dt1.set(Calendar.DAY_OF_MONTH, d2.get(Calendar.DAY_OF_MONTH));
        dt1.set(Calendar.MONTH, d2.get(Calendar.MONTH));
        dt1.set(Calendar.YEAR, d2.get(Calendar.YEAR));
        dt1.set(Calendar.YEAR, d1.get(Calendar.YEAR));
        System.out.println("La hora actual:" + t1.getTime());
        System.out.println("La hora combinada:" + dt1.getTime());
    }

}