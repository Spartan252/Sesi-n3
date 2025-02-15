
import java.util.ArrayList;

public class ejer1 {
    public static void main(String[] args){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Uno");
        lista.add("Dos");
        lista.add("Tres");
        lista.add("Cuatro");
        lista.add("Cinco");
        lista.add("Seis");

        for(int x=0;x<lista.size();x++){
            System.out.println((x+1) + " - "+ lista.get(x));
        }
        System.out.println();

        lista.set(3, "Dos");
        for(int x=0;x<lista.size();x++){
            System.out.println((x+1) + " - "+ lista.get(x));
        }
        System.out.println();


        for(int x=0;x<lista.size();x++){
            lista.set(x, (lista.get(x)).toUpperCase());
            System.out.println((x+1) + " - "+ lista.get(x));
        }
        System.out.println();

        for(int x=lista.size()-1;x>=0;x--){
            lista.remove(x);
        }

        System.out.println(lista);

    }
}
