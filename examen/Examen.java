/**
 * Examen
 */
public class Examen {
    public static void main(String[] args) {
        Movil m = new Movil();
        Abonado a = new Abonado();
        a.contratar(m);
    }
}

class Abonado {
    public void contratar(Servicio servicio) {

    }
}

abstract class Servicio {

}

class Movil extends Servicio {

}
