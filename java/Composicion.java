import java.util.Arrays;

class Boton {

}

class Tv {
    private Boton[] botones;

    Tv() {
        botones = new Boton[] { new Boton(), new Boton(), new Boton() };
    }

    public Boton[] getBotones() {
        return Arrays.copyOf(botones, botones.length);
    }
}
