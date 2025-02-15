package Actividades.Actividad_21;

public class Test {
    public static void main(String[] args) {
        //  Cajón Integer
        GDrawer<Integer> c1 = new GDrawer<>();
        c1.put(252);
        System.out.println(c1);
        //  Cajón Integer dentro de cajón
        GDrawer<GDrawer> c2 = new GDrawer<>();
        c2.put(c1);
        System.out.println(c2);

        //  Cajón String
        GDrawer<String> c3 = new GDrawer<>();
        c3.put("Hola Mundo");
        System.out.println(c3);
        //  Cajón String remove
        c3.remove();
        System.out.println(c3);

        //  Cajón RGB
        GDrawer<RGBColor> c4 = new GDrawer<>();
        c4.put(new RGBColor(230,40,80));
        System.out.println(c4);


        //  Cajón dentro del mismo cajón
        GDrawer<GDrawer> c5 = new GDrawer<>();
        c5.put(c5);
        //System.out.println(c4);

        //  Cajón double vacio
        GDrawer<Double> c6 = new GDrawer<>();
        System.out.println(c6);
    }
}
