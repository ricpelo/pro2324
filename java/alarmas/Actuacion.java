import java.util.Date;

public class Actuacion {
    private Date fechaHora;
    private String observaciones;
    private TipoActuacion tipoActuacion;

    public Actuacion(TipoActuacion tipoActuacion, String observaciones) {
        fechaHora = new Date();
        this.tipoActuacion = tipoActuacion;
        this.observaciones = observaciones;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public TipoActuacion getTipoActuacion() {
        return tipoActuacion;
    }
}
