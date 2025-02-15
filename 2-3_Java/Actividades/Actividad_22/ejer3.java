import java.util.ArrayList;
import java.util.HashMap;

//import javax.*;
public class ejer3{
	public static void main(String[] args){
		HashMap<String,Integer> map = new HashMap<>();
		map.put("uno",1);
		map.put("dos",2);
		map.put("tres",3);
		map.put("cuatro",4);
		map.put("cinco",5);
		
		String[] newNumber= {"seis","6"};
		try{
			//map.put(newNumber[2],Integer.parseInt(newNumber[1]));
			System.out.println(map.get("tres"));
			System.out.println(map.get("siete"));
		} catch(Exception e) {
			System.out.println("No existe un elemento para esa llave");
		}

	}
}