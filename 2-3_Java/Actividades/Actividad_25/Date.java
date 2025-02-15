
import javax.swing.*;

import org.w3c.dom.css.RGBColor;

import java.util.Calendar;
import java.util.Random;

public class Date implements Comparable<Date>
{
    private int day = 1;
    private int month = 1;
    private int year = 1970;
    private String nameMonth;
    
    public Date() {
        this.day = Calendar.DAY_OF_MONTH;
        this.month = Calendar.MONTH;
        this.year = Calendar.YEAR;
    }

    public Date(int day)
    {
        setDay(day);
    }

    public Date(int day, int month)
    {
        setDay(day);
        setMonth(month);
    }

    public Date(int day, int month, int year)
    {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void setDay(int day) throws OutOfRange
    {
        if(day>=1 && day<=31) {
            switch (this.month) {
                case 2:
                    if ((this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0)
                        if (day <= 29)
                            this.day = day;
                        else System.out.println("This Month has 29 days");
                    else if (day <= 28)
                        this.day = day;
                    else System.out.println("This Month has 28 days");
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    this.day = day;
                    break;
                default:
                    if (day <= 30)
                        this.day = day;
                    else System.out.println("This Month has 30 days");
                    break;
            }
        }else {
            System.out.println("Exception: Date Was Not Succesfull");
            throw new OutOfRange(day, month, year);
        }
    }

    public void setMonth(int month) throws OutOfRange
    {
        if(month>=1 && month<=12)
            this.month = month;
        else throw new OutOfRange(day, month, year);
    }

    public void setYear(int year) throws OutOfRange
    {
        if(year>=1970)
            this.year = year;
        else throw new OutOfRange(day, month, year);
    }

    public int Day_of_the_week() {
        int century = year / 100;
        int centuryBase = 6 - 2 * (century%4);
        int yy = year % 100;
        int leapDays = yy / 4;
        int [] monthBase = {0,3,3,6,1,4,6,2,5,0,3,5};

        int result = centuryBase + yy + leapDays + monthBase[month-1] + day;

        if(((year%4==0 && year%100!=0) || year%400==0) && month<3)
            result--;

        return result%7;
    }

    /*public String toString()
    {//modify so it can print 10/05/2021 XD
        return (this.day + "/" + this.month + "/" + this.year);
        // return "{\"day\":" + day + ",\"month\":" + month + ,"\"year\":" + year};
    }*/



    //Geters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getMonthName() {
        switch (month){
            case 1:
                nameMonth = "Enero";
                break;

            case 2:
                nameMonth = "Ferbrero";
                break;

            case 3:
                nameMonth = "Marzo";
                break;

            case 4:
                nameMonth = "Abril";
                break;

            case 5:
                nameMonth = "Mayo";
                break;

            case 6:
                nameMonth = "Junio";
                break;

            case 7:
                nameMonth = "Julio";
                break;

            case 8:
                nameMonth = "Agosto";
                break;

            case 9:
                nameMonth = "Septiembre";
                break;

            case 10:
                nameMonth = "Octubre";
                break;

            case 11:
                nameMonth = "Noviembre";
                break;

            case 12:
                nameMonth = "Diciembre";
                break;
        }
        return nameMonth;
    }
    public boolean isValid()
    {
        //por que la funcion de los setterss es cumplida, implica que un usario fisicamente no puede ingresar un valor erroneo
        return true;
    }
    public String toString()
    {
        //Formato: "{\"day\": " + this.day +", \"month\": "+ this.month +", \"year\": "+ this.year +", \"month name\": \'" + this.nameMonth +"\'}"
        return "{\"day\": " + this.day +", \"month\": "+ this.month +", \"year\": "+ this.year +", \"month name\": '" + getMonthName() +"'}";
    }
    public boolean equals(Object o)
    {
        if(o instanceof Date){
            Date d1 = (Date)o;
            return (this.day==d1.getDay())&&(this.month==getMonth())&&(this.year==d1.getYear());
        } else return false;

    }

    public Date clone()
    {
        return new Date(this.day, this.month, this.year);
    }
    
    public int daysInMonth(int month, int year) throws OutOfRange{
        int days = 0;

        switch (month) {
            case 1: 
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4: 
            case 6: 
            case 9: 
            case 11:
                days = 30;
                break;
            case 2: // February
                if (isLeap(year)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default:
                throw new OutOfRange(day, month, year);
        }

        return days;
    }
    
    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public void nextDay() {
        int daysInMonth = daysInMonth(month, year);

        if (day < daysInMonth) {
            day++;
        } else {
            day = 1;

            if (month < 12) {
                month++;
            } else {
                month = 1;
                year++;
            }
        }
    }


    public static Date randomDate(){
        Random random = new Random();
        int y=random.nextInt(1970,2100);
        int m=random.nextInt(1,12);
        int d=1;
        if (isLeap(y)==true&& m==2){
            d=random.nextInt(1,28);
        }
        else if (isLeap(y)==false&& m==2){
            d=random.nextInt(1,29);
        }
        else {
            d=random.nextInt(1,30);
        }
        Date date = new Date(d,m,y);
        date.nextDay();
        return date;
    }
        
    /* public int hashCode() {
        return this.getDay()+(this.getMonth()*100)+(this.getYear()*10000);
    } */
    //Con 100,000 fechas en 3 pruebas, no se repitieron: 37568, 37661, 37690

    /* public int hashCode() {
        return this.getYear()*this.getMonth()*this.getDay();
    } */
    //Con 100,000 fechas en 3 pruebas, no se repitieron: 37659, 37711, 37605

    /* public int hashCode() {
        return (getMonthName()).length()+ this.getDay();
    } */
    //Con 100,000 fechas en 3 pruebas, no se repitieron: 24284, 24208, 24350

    public int hashCode() {
        return (this.getYear()*366)+(this.getMonth()<<5)+this.getDay();
    }
    //Con 100,000 fechas en 3 pruebas, no se repitieron: 37693, 37662, 37738

    @Override
    public int compareTo(Date o) {
        int a= this.hashCode();
        int b= hashCode();
        return a-b;
    }
}
