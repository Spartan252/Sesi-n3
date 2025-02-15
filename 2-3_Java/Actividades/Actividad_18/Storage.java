package Actividades.Actividad_18;

public class Storage {
    private final int Tipo;
    private final int Capacidad;

    public static final int HDD = 1, SSD= 2;
    
    // Constructores_________________________________________
    public Storage(){
        Tipo = 2;
        Capacidad = 8000;
    }

    public Storage(int Tipo, int Capacidad){
        this.Tipo = Tipo;
        this.Capacidad = Capacidad;
    }

    // Getters_______________________________________________
    public int getTipo() {
        if (Tipo == 1){
            System.out.println("Tipo: HDD");
            return Tipo;
        }
        else {
            System.out.println("Tipo: SSD");
            return Tipo;
        }
    }

    public int getCapacidad() {
        System.out.println("Capacidad: " + Capacidad + " gygabytes");
        return Capacidad;
    }
}
