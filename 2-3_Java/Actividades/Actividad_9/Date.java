package Actividades.Actividad_9;

import javax.swing.JOptionPane;

public class Date {
    public static void main(String[] args) {
        Date d_1 = new Date();
        d_1.setDay(5);
        Date d_2 = new Date(2002, 12, 5);
        Date d_3 = new Date(2002, 5, 11);
        Date d_4 = new Date(2003, 8, 16);
        Date d_5 = new Date(2003, 12, 17);
        Date d_6 = new Date(2001, 9, 11);

        System.out.println(d_1);
        System.out.println(d_1.getFirstDay());
        System.out.println(d_2);
        System.out.println(d_3);
        System.out.println(d_4);
        System.out.println(d_5);
        System.out.println(d_6);

        d_1.print();
        d_2.print();
        d_3.print();
        d_4.print();
        d_5.print();
        d_6.print();
    }

    // __________________________________________________________________________
    private int day;
    private int month;
    private int year;
    private String txtmonth = "Enero";
    private double days = 0;

    private final int FIRST_YEAR;
    private final int FIRST_MONTH;
    private final int FIRST_DAY;

    private final int JANUARY = 1;
    private final int FEBRUARY = 2;
    private final int MARCH = 3;
    private final int APRIL = 4;
    private final int MAY = 5;
    private final int JUNE = 6;
    private final int JULY = 7;
    private final int AUGUST = 8;
    private final int SEPTEMBER = 9;
    private final int OCTOBER = 10;
    private final int NOVEMBER = 11;
    private final int DECEMBER = 12;

    // __________________________________________________________________________
    public Date() {
        FIRST_YEAR = 1970;
        FIRST_MONTH = 1;
        FIRST_DAY = 1;
        setDate(1970, 1, 1);
    }

    public Date(int year, int month, int day) {
        if (isValid(year, month, day)) {
            FIRST_YEAR = year;
            FIRST_MONTH = month;
            FIRST_DAY = day;
        } else {
            FIRST_YEAR = 1970;
            FIRST_MONTH = 1;
            FIRST_DAY = 1;

        }

        setDate(year, month, day);
    }

    // __________________________________________________________________________
    public void setDate(int year, int month, int day) {
        if (isValid(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    public void setYear(int year) { // year(color café es el argumento del método
        setDate(year, month, day);
    }

    public void setMonth(int month) {
        setDate(year, month, day);
    }

    public void setDay(int day) {
        setDate(year, month, day);
    }

    // __________________________________________________________________________
    public boolean isLeap() {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    public boolean isLeap(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    public int daysPerMonth() {
        int retVal = 0;

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            retVal = 31;
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            retVal = 30;
        else if (month == 2 && !isLeap())
            retVal = 28;
        else if (month == 2 && isLeap())
            retVal = 29;

        return retVal;
    }

    public int daysPerMonth(int year, int month) {
        int retVal = 0;

        if (month == JANUARY || month == MARCH || month == MAY || month == JULY || month == AUGUST || month == OCTOBER
                || month == DECEMBER)
            retVal = 31;
        else if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER)
            retVal = 30;
        else if (month == FEBRUARY && !isLeap())
            retVal = 28;
        else if (month == FEBRUARY && isLeap())
            retVal = 29;
        return retVal;
    }

    public boolean isValid() {
        return year >= 1800 && year <= 20000 &&
                day >= 1 && day <= daysPerMonth();
    }

    private boolean isValid(int year, int month, int day) {
        return year >= 1800 && year <= 20000 &&
                day >= 1 && day <= daysPerMonth(year, month);

    }

    // __________________________________________________________________________
    public double getDay() {
        return day;
    }

    public double getMonth() {
        return month;
    }

    public double getYear() {
        return year;
    }

    public double getFirstDay() {
        return FIRST_DAY;
    }

    public double getFirstMonth() {
        return FIRST_MONTH;
    }

    public double getFirstYear() {
        return FIRST_YEAR;
    }

    // __________________________________________________________________________
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

    // __________________________________________________________________________
    // Regresa el día de la semana
    // 0-Domingo, 1-Lunes, 2-Martes ... 6-Sábado
    public int dow() {
        int century = year / 100;
        int centuryBase = 6 - 2 * (century % 4);
        int yy = year % 100;
        int leapDays = yy / 4;
        int[] monthBase = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

        int result = centuryBase + yy + leapDays + monthBase[month - 1] + day;

        if (isLeap() && month < 3)
            result--;

        return result % 7;
    }

    // __________________________________________________________________________
    public String getMonthName() {
        String[] monthName = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };

        return monthName[month - 1];
    }

    public String getDowName() {
        String[] dowName = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        return dowName[dow()];
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

    public void print() {
        JOptionPane.showMessageDialog(null,
                getDowName() + " " + day + " de " + txtmonth + " de " + year + "\n"
                        + "\nDías que han transcurrido desde el 01/01/1970 \n"
                        + epoch() + "\n\nFecha original: \n" + FIRST_DAY + " de " + FIRST_MONTH + " de " + FIRST_YEAR,
                "Fechas:", 2);
    }

}
