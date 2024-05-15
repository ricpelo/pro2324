import java.util.Date;

public class Incidencia {
    private long numero;
    private Date fechaHora;
    private Sensor sensor;

    public Incidencia(Sensor sensor) {
        fechaHora = new Date();
        this.sensor = sensor;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public Sensor getSensor() {
        return sensor;
    }
}
