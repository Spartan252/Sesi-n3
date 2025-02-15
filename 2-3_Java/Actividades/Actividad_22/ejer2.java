import java.util.TreeSet;

public class ejer2 {
    public static void main(String[] args){
        TreeSet<Integer> pq = new TreeSet<>();
		
		pq.add(100);
        pq.add(150);
        pq.add(120);
        pq.add(100);
        pq.add(180);
        pq.add(200);
        pq.add(120);
        pq.add(180);
        pq.add(100);
		
        System.out.println("Tamaño del conjunto: "+pq.size());


        for(Integer cadena :pq){
            System.out.println(cadena);
        }
        System.out.println(pq);
    }
}
