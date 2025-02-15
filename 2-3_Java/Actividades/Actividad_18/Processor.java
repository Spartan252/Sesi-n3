package Actividades.Actividad_18;

public class Processor {
    private final int Marca;
    private final int Modelo;
    private final int Nucleos;
    private final double Velocidad;

    public static final int AMD = 1, INTEL= 2;
    public static final int  Corei3 = 3, Corei5 = 5, Corei7 = 7, Corei9 = 9, Ryzen3 = 3, Ryzen5 = 5, Ryzen7 = 7, Ryzen9 = 9;
    
    // Constructores_________________________________________
    public Processor(){
        Marca = AMD;
        Modelo = Ryzen5;
        Nucleos = 6;
        Velocidad = 4.0;
    }

    public Processor(int Marca, int Modelo, int Nucleos, double Velocidad){
        this.Marca = Marca;
        this.Modelo = Modelo;
        if (Nucleos >= 4 && Nucleos <= 24)
            this.Nucleos = Nucleos;
        else
            this.Nucleos = 0;

        if (Velocidad >= 4 && Velocidad <= 24)
            this.Velocidad = Velocidad;
        else
            this.Velocidad = 0;
    }

    // Getters_______________________________________________
    public int getMarca() {
        if (Marca == 1)
            System.out.println("Marca: AMD");
        if (Marca == 2)
            System.out.println("Marca: Intel");
        return Marca;
    }

    public void getModelo() {
        if (Marca == 1)
            switch (Modelo) {
            case 3:
                System.out.println("Modelo: Ryzen3");
                break;
            case 5:
                System.out.println("Modelo: Ryzen5");
                break;
            case 7:
                System.out.println("Modelo: Ryzen7");
                break;
            case 9:
                System.out.println("Modelo: Ryzen9");
                break;
            }
        else if (Marca == 2)
            switch (Modelo) {
            case 3:
                System.out.println("Modelo: Corei3");
                break;
            case 5:
                System.out.println("Modelo: Corei5");
                break;
            case 7:
                System.out.println("Modelo: Corei7");
                break;
            case 9:
                System.out.println("Modelo: Corei9");
                break;
            }
    }

    public int getNucleos() {
        System.out.println("Nucleos: " + Nucleos);
        return Nucleos;
    }

    public double getVelocidad() {
        System.out.println("Velocidad: " + Velocidad);
        return Velocidad;
    }

    public void getProcessor(){
        getMarca();
        getModelo();
        getNucleos();
        getVelocidad();
    }

}
