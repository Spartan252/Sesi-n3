package Actividades.Actividad_16;

public class Test {
    public static void main(String[] args) {

        ElectronicDevice e1 = new SmartTV();
        SmartTV tv = (SmartTV) e1;
        e1.getEstado();
        tv.getSistema();
        tv.ConectarWifi();

        ElectronicDevice e2 = new Telefono();
        Telefono tf1 = (Telefono) e2;
        e2.setSistema(4);
        e2.getSistema();
        tf1.ConectarWifi();
        tf1.getCapacidad();

        ElectronicDevice e3 = new Tableta();
        Tableta tb1 = (Tableta) e3;
        e3.setPantalla(7);
        e3.getPantalla();
        tb1.InstalarApp();
        tb1.DesinstalarApp();

        ElectronicDevice e4 = new Laptop();
        Laptop lp1 = (Laptop) e4;
        e4.setPantalla(14);
        e4.getPantalla();
        e4.setMarca(4);
        e4.getMarca();
        lp1.GetPorcentajeCarga();
        lp1.InstalarApp();
        lp1.DesinstalarApp();
        lp1.apagar();

    }
}
