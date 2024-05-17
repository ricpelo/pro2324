import java.util.Collection;

public class Principal {
    public static void main(String[] args) {
        // Ejercicio 4:
        for (Cliente cliente : Cliente.all()) {
            int cuantas = 0;
            for (Alarma alarma : cliente.getAlarmas()) {
                for (Incidencia incidencia : alarma.getIncidencias()) {
                    for (Actuacion actuacion : incidencia.getActuaciones()) {
                        if (actuacion.getTipoActuacion().equals(TipoActuacion.FALSA_ALARMA)) {
                            cuantas++;
                        }
                    }
                }
            }
            System.out.println("El cliente " + cliente + " ha producido " + cuantas + " falsas alarmas");
        }

        // Ejercicio 5:
        for (Cliente cliente : Cliente.all()) {
            int cuantas = 0;
            for (Alarma alarma : cliente.getAlarmas()) {
                cuantas = alarma.getIncidencias().size();
                if (cuantas == 0) {
                    System.out.println("La alarma " + alarma + " NUNCA ha saltado.");
                } else {
                    System.out.println("La alarma " + alarma + " ha saltado " + cuantas + " veces.");
                }
            }
        }

        // Ejercicio 7:
        for (Alarma alarma : Cliente.find(485102).getAlarmas()) {
            Collection<Sensor> vistaSensores = alarma.getSensores();
            for (Sensor sensor : vistaSensores) {
                if (sensor.getCantidadIncidencias() == 0) {
                    vistaSensores.remove(sensor);
                }
            }
        }

        // Ejercicio 8:
        int minimaCantidadMovimiento = Integer.MAX_VALUE;
        Cliente objetivo = null;
        for (Cliente cliente : Cliente.all()) {
            int cuantosMovimiento = 0;
            for (Alarma alarma : cliente.getAlarmas()) {
                cuantosMovimiento += alarma.getSensores(TipoSensor.MOVIMIENTO).size();
            }
            if (cuantosMovimiento < minimaCantidadMovimiento) {
                minimaCantidadMovimiento = cuantosMovimiento;
                objetivo = cliente;
            } else if (cuantosMovimiento == minimaCantidadMovimiento) {
                if (cliente.getNumero() < objetivo.getNumero()) {
                    objetivo = cliente;
                }
            }
        }
        objetivo.asociarMovil("645888102", "Natalia Rodríguez García" );
    }
}
