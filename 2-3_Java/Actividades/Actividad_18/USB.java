package Actividades.Actividad_18;

public class USB {
    //Atributes
    private int USB;
    public static final int USB2_O = 1;
    public static final int USB3_O = 2;
    public static final int USB3_1 = 3;
    public static final int USB3_2 = 4;
    public static final int USB4_0 = 5;

    // Constructor
    public USB(int USB) {
        this.USB = USB;
    }

    //Setters
    public void seUSB(int USB){
        this.USB = USB;
    }

    //Getters
    public int getRam(){
        System.out.println("USB Type: ");
        switch (USB){
            case USB2_O:
                System.out.println("USB 2.0");
                break;
            case USB3_O:
                System.out.println("USB 3.0");
                break;
            case USB3_1:
                System.out.println("USB 3.1");
                break;
            case USB3_2:
                System.out.println("USB 3.2");
                break;
            case USB4_0:
                System.out.println("USB 4.0");
                break;
        }
        return USB;
    }
}
