package cuentas;

class Movimiento {
    private String concepto;
    private float cantidad;

    Movimiento(String concepto, float cantidad) {
        this.concepto = concepto;
        this.cantidad = cantidad;
    }

    Movimiento(Movimiento movimiento) {
        concepto = movimiento.getConcepto();
        cantidad = movimiento.getCantidad();
    }

    public String getConcepto() {
        return concepto;
    }

    public float getCantidad() {
        return cantidad;
    }
}
