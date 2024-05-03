import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Mapas {
    public static void main(String[] args) {
        Map<String, Integer> m = new TreeMap<>();
        m.put("Hola", 1);
        m.put("Adiós", 7);
        m.put("Barco", 5);
        Iterator<Map.Entry<String, Integer>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entrada = it.next();
            System.out.println("La clave " +
                entrada.getKey() +
                " se asocia al valor " +
                entrada.getValue()
            );
        }
    }
}
