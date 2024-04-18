import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Interfaces {
    public static void main(String[] args) {
        Sumable s = new Numero(4);
        Sumable res = s.sumar(s);

        List l = new ArrayList<>();
        l.add(4);
        l.add(5);

        System.out.println(res.valorInt());
    }
}

interface Sumable {
    Sumable sumar(Sumable otro);

    int valorInt();
}

class Numero implements Sumable {
    private int numero;

    Numero(int numero) {
        this.numero = numero;
    }

    @Override
    public Sumable sumar(Sumable otro) {
        numero += otro.valorInt();
        return this;
    }

    @Override
    public int valorInt() {
        return numero;
    }
}
