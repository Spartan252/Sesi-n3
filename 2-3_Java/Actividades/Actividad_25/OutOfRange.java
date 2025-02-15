

public class OutOfRange extends RuntimeException   {
    private int day;
    private int month;
    private int year;
    public OutOfRange(int day,int month,int year) {
        super("InvalidDateValueException");
        this.day = day;
        this.month = month;
        if (day<=0 || day>31) {
            System.out.println("Invalid Day Value Exception");
            this.month = month;
            this.year = year;
        }
        if (month<=0 || month>12) {
            System.out.println("Invalid Month Value Exception");
        }
        if (year<=0 || year>9999) {
            System.out.println("Invalid Year Value Exception");
        }
    }

    public String toString() {
		return getMessage() + "\nInvalid Date:    "+
				day+" \\ "+month+" \\ "+year;
	}
}
