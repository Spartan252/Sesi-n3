package Actividades.Actividad_18;

public class Motherboard {

    //Atributes
    private int Manufacturer;
    public static final int ASUS = 1;
    public static final int MSI = 2;
    public static final int GIGABYTE = 3;
    public static final int ASROCK = 4;

    private String Model;

    private int Socket;
    public static final int AM4 = 1;
    public static final int AM5 = 2;
    public static final int LGA1200 = 3;
    public static final int LGA1700 = 4;

    private int Ram;
    public static final int DDR4 = 1;
    public static final int DDR5 = 2;

    // <-- Agregación
    private Processor processor;
    private Storage storage;
    private USB[] usbPorts;

    //Constructors
    public Motherboard(int manufacturer, String model, int socket, int ram, Processor processor, Storage storage, USB[] usbPorts) {
        this.Manufacturer = manufacturer;
        this.Model = model;
        this.Socket = socket;
        this.Ram = ram;
        // <-- Asosiación
        this.processor = processor;
        this.storage = storage;
        this.usbPorts = usbPorts;
    }

    //Setters
    public void setManufacturer(int Manufacturer){
        this.Manufacturer = Manufacturer;
    }
    public void setModel(String Model){
        this.Model = Model;
    }
    public void setSocket(int Socket){
        this.Socket = Socket;
    }
    public void setRam(int Ram){
        this.Ram = Ram;
    }
    public void setProcessor(Processor processor) { this.processor = processor;}
    public void setStorage(Storage storage) {this.storage = storage;}
    public void setUsbPorts(USB[] usbPorts) {this.usbPorts = usbPorts;}



    //Getters
    public int getManufacturer(){
        System.out.println("Manufacturer: ");
            switch (Manufacturer){
                case ASUS:
                        System.out.println("Asus");
                    break;
                case MSI:
                        System.out.println("MSI");
                    break;
                case GIGABYTE:
                        System.out.println("Gygabite");
                    break;
                case ASROCK:
                        System.out.println("Asrock");
                    break;
            }
            return Manufacturer;
    }

    public String getModel(){
        System.out.println("Model: " + Model);
        return Model;
    }

    public int getSocket(){
        System.out.println("Socket: ");
        switch (Socket){
            case AM4:
                System.out.println("AMD AM4");
                break;
            case AM5:
                System.out.println("AMD AM5");
                break;
            case LGA1200:
                System.out.println("INTEL LGA1200");
                break;
            case LGA1700:
                System.out.println("INTEL LGA1700");
                break;
        }
        return Socket;
    }

    public int getRam(){
        System.out.println("Ram Type: ");
        switch (Ram){
            case DDR4:
                System.out.println("DDR4");
                break;
            case DDR5:
                System.out.println("DDR5");
                break;
        }
        return Ram;
    }

    // <-- Asosiación
    public Processor getProcessor() {
        return processor;
    }

    public Storage getStorage() {
        return storage;
    }

    public USB[] getUsbPorts() {
        return usbPorts;
    }

}
