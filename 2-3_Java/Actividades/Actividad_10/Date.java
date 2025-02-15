package Actividades.Actividad_10;

import javax.swing.JOptionPane;

public class Date {
    public static void main(String[] args) {
        Date d_1 = new Date();
        d_1.setDay(5);
        d_1.setMonth(5);
        Date d_2 = new Date(2002, 12, 5);
        d_2.setDay(12);
        d_2.setMonth(5);
        Date d_3 = new Date(2002, 5, 11);
        Date d_4 = new Date(2003, 8, 16);
        Date d_5 = new Date(2003, 12, 17);
        Date d_6 = new Date(2001, 9, 11);

        System.out.println(d_1);
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
    private double days = 0;
    public static int count = 0;

    public final int FIRST_YEAR;
    public final int FIRST_MONTH;
    public final int FIRST_DAY;

    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

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
    private boolean isLeap() {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    public static boolean isLeap(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    public boolean isValid() {
        return year >= 1800 && year <= 20000 &&
                day >= 1 && day <= daysPerMonth();
    }

    private static boolean isValid(int year, int month, int day) {
        return year >= 1800 && year <= 20000 &&
                day >= 1 && day <= daysPerMonth(year, month);
    }

    // __________________________________________________________________________
    private int daysPerMonth() {
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

    private static int daysPerMonth(int year, int month) {
        int retVal = 0;

        if (month == JANUARY || month == MARCH || month == MAY || month == JULY
                || month == AUGUST || month == OCTOBER || month == DECEMBER)
            retVal = 31;
        else if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER)
            retVal = 30;
        else if (month == FEBRUARY && !isLeap(year))
            retVal = 28;
        else if (month == FEBRUARY && isLeap(year))
            retVal = 29;

        return retVal; // Retorna un entero
    }

    // __________________________________________________________________________
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getFirstDay() {
        return FIRST_DAY;
    }

    public int getFirstMonth() {
        return FIRST_MONTH;
    }

    public int getFirstYear() {
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
    public int Dow() {
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

    public static int getDow(int year, int month, int day) {
        int result = -1;
        if (isValid(year, month, day)) {
            int century = year / 100;
            int centuryBase = 6 - 2 * (century % 4);
            int yy = year % 100;
            int leapDays = yy / 4;
            int[] monthBase = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

            result = centuryBase + yy + leapDays + monthBase[month - 1] + day;

            if (isLeap(year) && month < 3)
                result--;
            result = result % 7;
        }
        return result;
    }

    public int Dow(int FIRST_Day) {
        int century = FIRST_YEAR / 100;
        int centuryBase = 6 - 2 * (century % 4);
        int yy = FIRST_YEAR % 100;
        int leapDays = yy / 4;
        int[] monthBase = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

        int result = centuryBase + yy + leapDays + monthBase[FIRST_MONTH - 1] + FIRST_Day;

        if (isLeap() && FIRST_MONTH < 3)
            result--;

        return result % 7;
    }

    // __________________________________________________________________________
    public String getMonthName() {
        String[] monthName = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        return monthName[month - 1];
    }

    public String getMonthName(int month) {
        if (month < 0 || month > 12)
            return null;
        else {
            String[] monthName = { "January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December" };
            return monthName[month - 1];
        }
    }

    public String getDowName() {
        String[] dowName = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        return dowName[Dow()];
    }

    public String getDowName(int day) {
        String[] dowName = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        if (Dow(day) < 0 || Dow(day) > 6)
            return null;
        else
            return dowName[Dow(day)];
    }

    public static int getIstancesCount() {
        return count += 1;
    }

    public String toString() {
        int bis = 0;

        switch (month) {
            case 1:
                break;
            case 2:
                if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                    days += 31;
                    bis = 1;
                } else
                    days += 31;
                break;
            case 3:
                if (bis == 1)
                    days += 60;
                else
                    days += 59;
                break;
            case 4:
                if (bis == 1)
                    days += 91;
                else
                    days += 90;
                break;
            case 5:
                if (bis == 1)
                    days += 121;
                else
                    days += 120;
                break;
            case 6:
                if (bis == 1)
                    days += 152;
                else
                    days += 151;
                break;
            case 7:
                if (bis == 1)
                    days += 182;
                else
                    days += 181;
                break;
            case 8:
                if (bis == 1)
                    days += 213;
                else
                    days += 212;
                break;
            case 9:
                if (bis == 1)
                    days += 244;
                else
                    days += 243;
                break;
            case 10:
                if (bis == 1)
                    days += 274;
                else
                    days += 273;
                break;
            case 11:
                if (bis == 1)
                    days += 305;
                else
                    days += 304;
                break;
            case 12:
                if (bis == 1)
                    days += 335;
                else
                    days += 334;
                break;
        }

        return "day: " + day + " month: " + month + " monthname: " + getMonthName() + " year: " + year;
    }

    public void print() {
        JOptionPane.showMessageDialog(null, "Fecha: " + getIstancesCount() + "\n\n" +
                getDowName() + ", " + getMonthName() + " " + day + ", " + year + "\n"
                + "\nDays that have passed since 01/01/1970 \n"
                + epoch() + "\n\nOriginal Date: \n" + getDowName(FIRST_DAY) + ", " + getMonthName(FIRST_MONTH)
                + " " + FIRST_DAY + ", " + FIRST_YEAR,
                "Date:", 2);
    }

}
