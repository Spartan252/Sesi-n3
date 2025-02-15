package Actividades.Actividad_18;

public class Memory {

    //Atributes
    private int Ram;
    public static final int DDR4 = 1;
    public static final int DDR5 = 2;
    private int Capacity;

    // Constructor
    public Memory(int ram, int capacity) {
        this.Ram = ram;
        if (capacity > 8 && capacity < 64) {
            this.Capacity = capacity;
        }
    }

    //Setters
    public void setRam(int Ram){
        this.Ram = Ram;
    }
    public void setCapacity(int capacity) {
        if (capacity > 8 && capacity < 64) {
            this.Ram = capacity;
        }
    }

    //Getters
    public int getRam(){
        switch (Ram){
            case DDR4:
                System.out.println("Ram Type: DDR4");
                break;
            case DDR5:
                System.out.println("Ram Type: DDR5");
                break;
        }
        return Ram;
    }

    public int getCapacity(){
        System.out.println("Capacity: " + Capacity);
        return Capacity;
    }
}
