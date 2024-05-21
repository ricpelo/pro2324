import java.util.Arrays;

class Televisor {
    private final int MIN_VOL = 0;
    private final int MAX_VOL = 30;
    private final int MIN_CANAL = 1;
    private final int MAX_CANAL = 100;

    private boolean encendido = false;
    private int canal = 1;
    private int volumen = 0;
    private Soporte soporte = null;

    public Televisor encender() {
        encendido = true;
        return this;
    }

    public Televisor apagar() {
        encendido = false;
        return this;
    }

    public Televisor subirVolumen() {
        if (encendido && volumen < MAX_VOL) {
            volumen++;
        }
        return this;
    }

    public Televisor bajarVolumen() {
        if (encendido && volumen > MIN_VOL) {
            volumen--;
        }
        return this;
    }

    public int getCanal() {
        return canal;
    }

    public int getVolumen() {
        return volumen;
    }

    public Televisor sintonizar(int canal) {
        if (encendido && canal >= MIN_CANAL && canal <= MAX_CANAL) {
            this.canal = canal;
        }
        return this;
    }

    public Televisor conectar(Soporte soporte) {
        this.soporte = soporte;
        return this;
    }

    public Televisor desconectarSiConectado() {
        soporte = null;
        return this;
    }

    public String[] reproducirSiConectado() {
        if (encendido && soporte != null) {
            return soporte.playlist();
        }
        return new String[0];
    }
}

class Soporte {
    private String[] listaReproduccion;

    Soporte(String[] listaReproduccion) {
        this.listaReproduccion = listaReproduccion;
    }

    public String[] playlist() {
        return listaReproduccion;
    }

    public String reproducir(int indice) {
        return listaReproduccion[indice];
    }
}

public class ExamenTelevisor {
    public static void main(String[] args) {
        Soporte soporte = new Soporte(new String[] { "Batman.mp4", "Superman.mp4" });

        assert new Televisor().encender().bajarVolumen().getVolumen() == 0;
        assert new Televisor().subirVolumen().encender().subirVolumen().getVolumen() == 1;
        assert new Televisor().conectar(soporte).reproducirSiConectado().length == 0;
        assert Arrays.equals(
            new Televisor().conectar(soporte).encender().reproducirSiConectado(),
            new String[] { "Batman.mp4", "Superman.mp4" }
        );
    }
}
