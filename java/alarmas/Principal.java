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
    }
}
