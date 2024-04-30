import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pila<T> {
    private List<T> elementos;

    public Pila() {
        elementos = new ArrayList<>();
    }

    public boolean esVacia() {
        return elementos.isEmpty();
    }

    public Pila<T> apilar(T elemento) {
        elementos.add(elemento);
        return this;
    }

    public T cima() {
        return elementos.get(elementos.size() - 1);
    }

    public Pila<T> desapilar() {
        elementos.remove(elementos.size() - 1);
        return this;
    }
}
