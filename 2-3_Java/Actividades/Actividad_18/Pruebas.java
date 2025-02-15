package Actividades.Actividad_18;
public class Pruebas {
    public static void main(String[] args) {
        
        //CPU
        Processor cpu = new Processor(2, 5, 6, 4.0);
        cpu.getProcessor();
        System.out.println();

        //Storage
        Storage storage = new Storage(Storage.SSD, 1000);
        System.out.println("Storage Type: " + storage.getTipo());
        System.out.println("Storage Capacity: " + storage.getCapacidad() + " GB");
        System.out.println();

        //Memory
        Memory memory = new Memory(Memory.DDR4, 16);
        System.out.println("Memory RAM Type: " + memory.getRam());
        System.out.println("Memory Capacity: " + memory.getCapacity() + " GB");
        System.out.println();

        //USB
        USB usb = new USB(USB.USB3_1);
        System.out.println("USB Type: " + usb.getRam());
        System.out.println();

        //Motherboard
        Motherboard motherboard = new Motherboard(Motherboard.GIGABYTE, "GA-Z270X-Gaming 7", Motherboard.LGA1200,
                Motherboard.DDR4, cpu, storage,new USB[]{usb});
        System.out.println("Motherboard Brand: " + motherboard.getManufacturer());
        System.out.println("Motherboard Model: " + motherboard.getModel());
        System.out.println("Motherboard Socket: " + motherboard.getSocket());
        System.out.println("Motherboard Memory Type: " + motherboard.getRam());
        System.out.println("Motherboard Processor: " + motherboard.getProcessor());
        System.out.println("Motherboard Storage: " + motherboard.getStorage());
        System.out.println("Motherboard USB Ports:");
        for (USB usbPort : motherboard.getUsbPorts()) {
            System.out.println(usb);
        }

    }
}
