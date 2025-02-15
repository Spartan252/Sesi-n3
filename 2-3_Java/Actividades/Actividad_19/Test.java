package Actividades.Actividad_19;

public class Test {
    
    public static void main(String[] args) {

        Day d1 = Day.WEDNESDAY;
        System.out.println(d1);
        d1.cambiarIdioma(Language.INGLISH);
        System.out.println();


        Day d2 = Day.SATURDAY;
        System.out.println(d2);
        System.out.println();

        for(Day dow:Day.values()){
            System.out.println(dow);
            dow.cambiarIdioma(Language.INGLISH);
            dow.cambiarIdioma(Language.FRENCH);
            System.out.println();
        }
    }
}
