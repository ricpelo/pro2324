
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class Examen {
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


class Producto {

    private int codigo;
    private String denominacion;
    private BigDecimal precio;
    private Categoria categoria;


    public Producto(int codigo, String denominacion, BigDecimal precio, Categoria categoria){

    this.codigo = codigo;
    this.denominacion = denominacion;
    this.precio = precio;
    this.categoria = categoria;

    }

    public int getCodigo(){
       return codigo;

    }

    public String getDenominacion(){
       return  denominacion;

    }

    public BigDecimal getPrecio(){
       return precio;

    }

    public Categoria getCategoria(){
        return categoria;

    }

    @Override

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return codigo == producto.codigo;

    }

    @Override

    public int hashCode() {
        return Integer.hashCode(codigo);


    }

    @Override

    public String toString() {
        return "Producto(" +
               "codigo=" + codigo +
               ", denominacion='" + denominacion + '\'' +
               ", precio=" + precio +
               ", categoria=" + categoria.getNombre() +
               "}"
    }

    class Categoria {

        private String nombre;
        private List<Producto> productos;


        public Categoria(String nombre) {

            this.nombre = nombre;
            this.producto = new Arraylist<>();


        }

        public String getNombre(){
            return nombre;

        }


        public void agregarProductos(Producto producto){

            productos.add(producto);


        }

        public List<Producto> getProductos(){
            return productos;

        }

    }

    class Carrito {

        private Map<Producto, Integer> productos;

        public Carrito() {
            this.productos = new HashMap<>();


        }

        public void insertarProducto(Producto producto) {

            productos.put(producto, productos.getDefault(producto, 0) + 1);

        }

        public void reducirProducto(Producto producto) {

            if (productos.containsKey(producto)) {

                int cantidad = productos.get(producto);
                if (cantidad > 1) {
                    productos.put(producto, cantidad - 1);
                }else {
                    productos.remove(producto);
                }
                }
            }

            public void vaciarCarrito() {

                productos.clear();

            }

            public Map<Producto, Integer> getEntradas() {

                return productos;

            }

            class Usuario {

            private Carrito carrito;

            public Usuario() {

                this.carrito = new Carrito();

            }

            public Carrito getCarrito() {
                return carrito;
            }

        }

        public class Main {

            public static void main(String[] args) {

                Usuario usuario = new Usuario();
                Carrito carrito = usuario.getCarrito();
                Categoria tornilleria = new Categoria("Tornillería");
                Categoria ferreteria = new Categoria("Ferretería");
                Producto tuerca = new Producto(25, "Tuerca", new BigDecimal("12.50"), tornilleria);
                Producto grifo = new Producto(58, "Grifo", new BigDecimal("6.30"), ferreteria);
                carrito.insertarProducto(tuerca);
                carrito.insertarProducto(tuerca);
                Map<Producto,Integer> entradas = carrito.getEntradas();
            }

            System.out.println(entradas.get(tuerca) == 2);
            System.out.println(entradas.get(grifo) == null);
            System.out.println(ferreteria.getProductos().contains(tuerca));
            System.out.println(ferreteria.getProductos().contains(grifo));

        }


    }
}
