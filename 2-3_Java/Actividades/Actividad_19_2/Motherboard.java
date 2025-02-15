public class Motherboard {
    private Manufacturer manufacturer;
    private CPU cpu;

    public Motherboard(Manufacturer manufacturer, CPU cpu) {
        this.manufacturer = manufacturer;
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "Motherboard [Manufacturer: " + manufacturer + "| CPU: " +cpu+"]";
    }
}