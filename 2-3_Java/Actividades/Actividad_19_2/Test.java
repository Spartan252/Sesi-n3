public class Test {
    public static void main(String[] args) {
        Motherboard m1 = new Motherboard(Manufacturer.GIGABYTE, CPU.Corei7);
        System.out.println(m1);

        Motherboard m2 = new Motherboard(Manufacturer.ASUS, CPU.Ryzen3);
        System.out.println(m2);

        Motherboard m3 = new Motherboard(Manufacturer.MSI, CPU.Corei5);
        System.out.println(m3);

        Motherboard m4 = new Motherboard(Manufacturer.ASROCK, CPU.Ryzen9);
        System.out.println(m4);
    }
}