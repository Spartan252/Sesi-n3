
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;

public class ejer {


    // EJEERCICIO 3__________________________________________
    public static double greatestNumber(Collection<Number> collection) {
        Number G = null;
        for (Number N : collection)
            if (G == null || N.doubleValue() > G.doubleValue())
                G = N;
        return G.doubleValue();
    }

    public static double greatestNumberInt(Collection<? extends Number> collection) {
        Number G = null;
        for (Number N : collection)
            if (G == null || N.doubleValue() > G.doubleValue())
                G = N;
        return G.doubleValue();
    }
        // Este método sí es aplicable al HashSet<Number>, donde funciona correctamente,
        // pero no funciona con el HashSet<Number>, por lo que es necesario crear otro parecido 
        // para que funcione correctamentre con el uso de (Collection<? extends Number> collection)
        // EJEERCICIO 3__________________________________________

    public static void main(String[] args){

        // EJEERCICIO 3__________________________________________
        // HashSet<Integer>
        HashSet<Integer> integerSet = new HashSet<>();
        integerSet.add(10);
        integerSet.add(5);
        integerSet.add(15);
        integerSet.add(8);
        double greatestInteger = greatestNumberInt(integerSet);
        System.out.println("The greatest integer is: " + greatestInteger);

        // HashSet<Number>
        HashSet<Number> numberSet = new HashSet<>();
        numberSet.add(3.14);
        numberSet.add(2.5);
        numberSet.add(10);
        numberSet.add(7.8);
        Number greatestNumber = greatestNumber(numberSet);
        System.out.println("The greatest number is: " + greatestNumber);
        // EJEERCICIO 3__________________________________________


        // EJEERCICIO 4__________________________________________
        Deque<Number> deque_num = new ArrayDeque<>();
		
		deque_num.add(100);
        deque_num.add(150);
        deque_num.add(-12);
        deque_num.add(100);
        deque_num.add(180);
        deque_num.add(200);
        deque_num.add(120);
        deque_num.add(180.4);
        deque_num.add(100);
		
        System.out.println("Tamaño del conjunto deque_num: "+deque_num.size());
        System.out.println(deque_num);


        Deque<Object> deque_obj = new ArrayDeque<>();

        for(Number cadena :deque_num){
            deque_obj.add(cadena);
        }
        System.out.println("Tamaño del conjunto deque_obj: "+deque_obj.size());
        System.out.println(deque_obj);
        // EJEERCICIO 4__________________________________________

    }        
}
