import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class TiendaOnline {
    public static void main(String[] args) {
        Cliente rosa = new Cliente("123", "Rosa", "González");
        Articulo televisor = new Articulo(
            123,
            "Televisor",
            new BigDecimal(399).setScale(2)
        );
        Articulo grafica = new Articulo(
            765,
            "Tarjeta gráfica",
            new BigDecimal(239).setScale(2)
        );
        Factura f = new Factura(10, rosa);
        f.insertarLinea(televisor, 2);
        f.insertarLinea(grafica, 1);
        f.imprimir();
    }
}

class Cliente {
    private String dni;
    private String nombre;
    private String apellidos;

    Cliente(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        // if (obj == null) {
        //     return false;
        // }

        if (!(obj instanceof Cliente)) {
            return false;
        }

        // if (getClass() != obj.getClass()) {
        //     return false;
        // }

        Cliente c = (Cliente) obj;

        return Objects.equals(dni, c.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}

class Articulo {
    private long codigo;
    private String denominacion;
    private BigDecimal precio;

    Articulo(long codigo, String denominacion, BigDecimal precio) {
        this.codigo = codigo;
        setDenominacion(denominacion);
        setPrecio(precio);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Articulo)) {
            return false;
        }

        Articulo a = (Articulo) obj;
        return codigo == a.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public long getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}

class Linea {
    private Articulo articulo;
    private int cantidad;

    Linea(Articulo articulo, int cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Linea)) {
            return false;
        }

        Linea l = (Linea) obj;
        return Objects.equals(articulo, l.articulo) &&
                cantidad == l.cantidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(articulo, cantidad);
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }
}

class Factura {
    private long numero;
    private Cliente cliente;
    private Linea[] lineas;
    private int cantidadLineas;

    Factura(long numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        lineas = new Linea[5];
        cantidadLineas = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Factura)) {
            return false;
        }

        Factura f = (Factura) obj;
        return numero == f.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    public long getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void insertarLinea(Articulo articulo, int cantidad) {
        Linea l = new Linea(articulo, cantidad);
        int longitud = lineas.length;
        if (cantidadLineas >= longitud) {
            lineas = Arrays.copyOf(lineas, (int) (longitud * 1.5f));
        }
        lineas[cantidadLineas++] = l;
    }

    public void eliminarLinea(Articulo articulo, int cantidad) {
        Linea[] nuevasLineas = new Linea[lineas.length];
        int nuevaCantidadLineas = 0;
        Linea l = new Linea(articulo, cantidad);

        for (int i = 0; i < lineas.length; i++) {
            if (!lineas[i].equals(l)) {
                nuevasLineas[nuevaCantidadLineas++] = lineas[i];
            }
        }

        lineas = nuevasLineas;
        cantidadLineas = nuevaCantidadLineas;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal("0").setScale(2);

        for (int i = 0; i < cantidadLineas; i++) {
            BigDecimal importe = new BigDecimal(String.valueOf(lineas[i].getCantidad())).setScale(2);
            importe = importe.multiply(lineas[i].getArticulo().getPrecio()).setScale(2);
            total = total.add(importe).setScale(2);
        }

        return total;
    }

    public void imprimir() {
        BigDecimal total = new BigDecimal("0").setScale(2);

        System.out.println("Factura número: " + numero);
        System.out.println("Cliente: " + cliente.getDni() + ' ' + cliente.getNombre() + ' ' + cliente.getApellidos());
        System.out.println();
        System.out.println("Código Denominación      Cantidad Precio Importe");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < cantidadLineas; i++) {
            long cod = lineas[i].getArticulo().getCodigo();
            String den = lineas[i].getArticulo().getDenominacion();
            int cant = lineas[i].getCantidad();
            String prec = lineas[i].getArticulo().getPrecio().toString();
            BigDecimal importe = new BigDecimal(String.valueOf(lineas[i].getCantidad())).setScale(2);
            importe = importe.multiply(lineas[i].getArticulo().getPrecio()).setScale(2);
            String imp = importe.toString();
            total = total.add(importe).setScale(2);
            System.out.printf("%6d %-10s\t%2d        %-6s  %-7s\n", cod, den, cant, prec, imp);
        }
        System.out.println("------------------------------------------------");
        System.out.println("Total factura: " + total.toString());
    }
}
