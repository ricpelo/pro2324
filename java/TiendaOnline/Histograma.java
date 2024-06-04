import java.util.LinkedList;
import java.util.List;

public class Histograma {
    public static void main(String[] args) {
        System.out.println(Histograma.histograma(List.of(1, 3, 4), '*').equals("*\n***\n****"));
        System.out.println(Histograma.histograma(List.of(6, 2, 15, 3), '=').equals("======\n==\n===============\n==="));
        System.out.println(Histograma.histograma(List.of(1, 10), '+').equals("+\n++++++++++"));
    }

    public static String histograma(List<Integer> lista, char car) {
        List<String> listaRes = new LinkedList<>();
        for (int i : lista) {
            listaRes.add(String.valueOf(car).repeat(i));
        }
        return String.join("\n", listaRes);
    }
}
