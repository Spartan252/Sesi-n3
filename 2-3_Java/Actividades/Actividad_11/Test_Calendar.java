
package Actividades.Actividad_11;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test_Calendar {

	public static void main(String[] args) {
		Calendar d1 = Calendar.getInstance();
		Calendar d2 = Calendar.getInstance();
		Calendar t1 = Calendar.getInstance();
		Calendar dt1 = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
		System.out.println("Fecha actual: " + sdf.format(d1.getTime()));

		d2.set(Calendar.DAY_OF_MONTH, 23);
		d2.set(Calendar.MONTH, 8);
		d2.set(Calendar.YEAR, 2021);

		System.out.println("Fecha d2: " + sdf.format(d2.getTime()));

		if (d1.before(d2)) {
			System.out.println("La fecha más antigua es: " + sdf.format(d1.getTime()));
		} else {
			System.out.println("La fecha más antigua es: " + sdf.format(d2.getTime()));
		}

		d1.add(Calendar.WEEK_OF_YEAR, 2);
		d1.add(Calendar.YEAR, -4);
		System.out.println("Despues de sumar 2 sem y restar 4 años a d1: " + sdf.format(d1.getTime()));

		SimpleDateFormat h_sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Hora actual: " + h_sdf.format(t1.getTime()));

		SimpleDateFormat c_sdf = new SimpleDateFormat("dd/MMMMM/yyyy HH:mm:ss");
		dt1.set(Calendar.DAY_OF_MONTH, d2.get(Calendar.DAY_OF_MONTH));
		dt1.set(Calendar.MONTH, d2.get(Calendar.MONTH));
		dt1.set(Calendar.YEAR, d2.get(Calendar.YEAR));
		System.out.println("La hora combinada: " + c_sdf.format(d2.getTime()));

		/*
		 * 
		 * System.out.println("Fecha Formateada: " + sdf.format(d1.getTime()));
		 * System.out.print(" Dia :" + d1.get(Calendar.DAY_OF_MONTH));
		 * System.out.print(" Mes :" + (d1.get(Calendar.MONTH) + 1));
		 * System.out.print(" Año :" + d1.get(Calendar.YEAR));
		 * System.out.print(" Dia de la semana:" + (d1.get(Calendar.DAY_OF_WEEK) - 1));
		 * System.out.print(" Hora :" + d1.get(Calendar.HOUR_OF_DAY));
		 * System.out.print(" Minutos :" + d1.get(Calendar.MINUTE));
		 * System.out.println("Segundos :" + d1.get(Calendar.SECOND));
		 * 
		 * System.out.print(" Dia :" + d2.get(Calendar.DAY_OF_MONTH));
		 * System.out.print(" Mes :" + (d2.get(Calendar.MONTH) + 1));
		 * System.out.print(" Año :" + d2.get(Calendar.YEAR));
		 * System.out.print(" Dia de la semana:" + (d2.get(Calendar.DAY_OF_WEEK) - 1));
		 * System.out.print(" Hora :" + d2.get(Calendar.HOUR_OF_DAY));
		 * System.out.print(" Minutos :" + d2.get(Calendar.MINUTE));
		 * System.out.println("Segundos :" + d2.get(Calendar.SECOND));
		 */
	}

}
