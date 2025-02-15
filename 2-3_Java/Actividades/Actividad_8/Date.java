package Actividades.Actividad_8;

import javax.swing.JOptionPane;

public class Date {
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

    private int day = 1;
    private int month = 1;
    private int year = 1970;
    private String txtmonth = "Enero";
    private double days = 0;

    public Date(int year, int month, int day) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31)
            this.day = day;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12)
            this.month = month;
    }

    public void setYear(int year) {
        if (year >= 1800 && year <= 9999)
            this.year = year;
    }

    public double getDay() {
        return day;
    }

    public double getMonth() {
        return month;
    }

    public double getYear() {
        return year;
    }

    // Regresa el día de la semana
    // 0-Domingo, 1-Lunes, 2-Martes ... 6-Sábado
    public int dow() {
        int century = year / 100;
        int centuryBase = 6 - 2 * (century % 4);
        int yy = year % 100;
        int leapDays = yy / 4;
        int[] monthBase = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

        int result = centuryBase + yy + leapDays + monthBase[month - 1] + day;

        if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month < 3)
            result--;

        System.out.println("Mes: " + txtmonth);
        return result % 7;
    }

    public String toString() {
        int bis = 0;

        switch (month) {
            case 1:
                txtmonth = "Enero";
                break;
            case 2:
                txtmonth = "Febrero";
                if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                    days += 31;
                    bis = 1;
                } else
                    days += 31;
                break;
            case 3:
                txtmonth = "Marzo";
                if (bis == 1)
                    days += 60;
                else
                    days += 59;
                break;
            case 4:
                txtmonth = "Abril";
                if (bis == 1)
                    days += 91;
                else
                    days += 90;
                break;
            case 5:
                txtmonth = "Mayo";
                if (bis == 1)
                    days += 121;
                else
                    days += 120;
                break;
            case 6:
                txtmonth = "Junio";
                if (bis == 1)
                    days += 152;
                else
                    days += 151;
                break;
            case 7:
                txtmonth = "Julio";
                if (bis == 1)
                    days += 182;
                else
                    days += 181;
                break;
            case 8:
                txtmonth = "Agosto";
                if (bis == 1)
                    days += 213;
                else
                    days += 212;
                break;
            case 9:
                txtmonth = "Septiembre";
                if (bis == 1)
                    days += 244;
                else
                    days += 243;
                break;
            case 10:
                txtmonth = "Octubre";
                if (bis == 1)
                    days += 274;
                else
                    days += 273;
                break;
            case 11:
                txtmonth = "Noviembre";
                if (bis == 1)
                    days += 305;
                else
                    days += 304;
                break;
            case 12:
                txtmonth = "Diciembre";
                if (bis == 1)
                    days += 335;
                else
                    days += 334;
                break;
        }

        return "day: " + day + " month: " + month + " year: " + year + " monthname: " + txtmonth;
    }

    public boolean isValid() {

        if (day < 1 || day > 31) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            return false;
        }
        if (month == 2) {
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if ((isLeapYear && day > 29) || (!isLeapYear && day > 28)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object o) {
        boolean retVal = false;

        if (o instanceof Date) {
            Date date = (Date) o;
            retVal = (date.getDay() == day) && (date.getMonth() == month) && (date.getYear() == year);
        }
        return retVal;
    }

    public Date clone() {
        return new Date(year, month, day);
    }

    public double epoch() {

        days += (year - 1970) * 365.2425;
        days += day - 1;
        return days;
    }

    public void print() {
        JOptionPane.showMessageDialog(null,
                day + " de " + txtmonth + " de " + year + "\n" + "Días que han transcurrido desde el 01/01/1970 \n"
                        + epoch(),
                "Fechas:", 2);
    }

}
