
import java.util.HashSet;

public class Test {
    public static void main(String[] args) throws Exception {
        HashSet <Date> hashset = new HashSet<>();
        int x=100000;
        for (int i = 0; i<x; i++) {
            hashset.add(Date.randomDate());
        }
        System.out.println("Fechas no repetidas de "+x+" : " +hashset.size());
    }
}
