import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CarritoExamen {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        Carrito carrito = usuario.getCarrito();
        Categoria tornilleria = new Categoria("Tornillería");
        Categoria ferreteria = new Categoria("Ferretería");
        Producto tuerca = new Producto(25, "Tuerca", new BigDecimal("12.50"), tornilleria);
        Producto grifo = new Producto(58, "Grifo", new BigDecimal("6.30"), ferreteria);
        carrito.insertarProducto(tuerca);
        carrito.insertarProducto(tuerca);
        Map<Producto, Integer> entradas = carrito.getEntradas();

        assert entradas.get(tuerca) == 2;
        assert entradas.get(grifo) == null;
        assert !ferreteria.getProductos().contains(tuerca);
        assert ferreteria.getProductos().contains(grifo);
    }
}

class Usuario {
    private Carrito carrito;

    Usuario() {
        carrito = new Carrito();
    }

    public Carrito getCarrito() {
        return carrito;
    }
}

class Carrito {
    private Map<Producto, Integer> entradas;

    Carrito() {
        entradas = new HashMap<>();
    }

    public Map<Producto, Integer> getEntradas() {
        return entradas;
    }

    public void insertarProducto(Producto producto) {
        int cantidad = (entradas.containsKey(producto))
                ? entradas.get(producto) + 1
                : 1;
        entradas.put(producto, cantidad);
    }

    public void eliminarProducto(Producto producto) {
        if (entradas.containsKey(producto)) {
            int cantidad = entradas.get(producto);
            if (cantidad > 1) {
                entradas.put(producto, cantidad - 1);
            } else {
                entradas.remove(producto);
            }
        }
    }

    public void vaciar() {
        entradas.clear();
    }
}

class Categoria {
    private String titulo;
    List<Producto> productos;

    Categoria(String titulo) {
        this.titulo = titulo;
        productos = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void insertarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }
}

class Producto {
    private int codigo;
    private String denominacion;
    private BigDecimal precio;
    private Categoria categoria;

    Producto(
        int codigo,
        String denominacion,
        BigDecimal precio,
        Categoria categoria
    ) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.precio = precio;
        this.categoria = categoria;
        categoria.insertarProducto(this);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Producto)) {
            return false;
        }

        Producto producto = (Producto) obj;
        return codigo == producto.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
