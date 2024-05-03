import java.math.BigDecimal;
import java.util.Map;

public class Principal {
    public static void main(String[] args) {
        Articulo televisor = new Articulo(
            123,
            "Televisor",
            new BigDecimal(399).setScale(2));
        Articulo grafica = new Articulo(
            765,
            "Tarjeta gráfica",
                new BigDecimal(239).setScale(2));

            Carrito carrito = new Carrito();
            carrito.insertarArticulo(televisor);
            carrito.insertarArticulo(televisor);
            carrito.quitarArticulo(grafica);
            // carrito.insertarArticulo(grafica);

            for (Map.Entry<Articulo, Integer> linea : carrito) {
                System.out.println("Artículo " +
                        linea.getKey().getDenominacion() +
                        " con cantidad " +
                        linea.getValue());
            }

            System.out.println("Total: " + carrito.getTotal());
    }
}
