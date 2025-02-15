package Actividades.Actividad_19;

public enum Day {
    SUNDAY("Domingo", "Sunday", "Dimanche"),
    MONDAY("Lunes", "Monday", "Lundi"),
    TUESDAY("Martes", "Tuesday", "Mardi"),
    WEDNESDAY("Miércoles", "Wednesday", "Mercredi"),
    THURSDAY("Jueves", "Thursday", "Jeudi"),
    FRIDAY("Viernes", "Friday", "Vendredi"),
    SATURDAY("Sábado", "Saturday", "Samedi");

    
    private final String DayEspanish;
    private final String DayInglish;
    private final String DayFrench;

    private String Lenguaje;

    private Day(String DayEspanish, String DayInglish, String DayFrench){
        this.DayEspanish = DayEspanish;
        this.DayInglish = DayInglish;
        this.DayFrench = DayFrench;
        Lenguaje = DayEspanish;
    }

    void setDay(Day Day, Language Language){
        switch (Language) {
            case SPANISH:
                System.out.println(Day.DayEspanish);
                break;
            case INGLISH:
                System.out.println(Day.DayInglish);
                break;
            case FRENCH:
                System.out.println(Day.DayFrench);
                break;
            default:
                System.out.println(Day.DayEspanish);
        }
    }



    public void cambiarIdioma(Language Language){
        switch (Language) {
            case SPANISH:
                Lenguaje = DayEspanish;
                System.out.println(DayEspanish);
                break;
            case INGLISH:
                Lenguaje = DayInglish;
                System.out.println(DayInglish);
                break;
            case FRENCH:
                Lenguaje = DayFrench;
                System.out.println(DayFrench);
                break;
        }
    }

    public String toString() {
        return this.Lenguaje;
    }

}
