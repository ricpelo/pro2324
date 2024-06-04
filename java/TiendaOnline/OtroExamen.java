import java.util.List;
import java.util.LinkedList;
import java.util.List;

public class OtroExamen {
    public static void main(String[] args) {
        assert Histograma.histograma(List.of(1, 3, 4), '*').equals("*\n***\n****");
        assert Histograma.histograma(List.of(6, 2, 15, 3), '=').equals("======\n==\n===============\n===");
        assert Histograma.histograma(List.of(1, 10), '+').equals("+\n++++++++++");
    }
}



class Histograma {
    public static String histograma(List<Integer> numeros, char caracter) {
        StringBuilder sb = new StringBuilder();
        for (int num : numeros) {
            for (int i = 0; i < num; i++) {
                sb.append(caracter);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
