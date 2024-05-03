import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Carrito implements Iterable<Map.Entry<Articulo, Integer>> {
    /**
     * @var lineas Las líneas del carrito
     */
    private Map<Articulo, Integer> lineas;

    Carrito() {
        lineas = new LinkedHashMap<>();
    }

    @Override
    public Iterator<Entry<Articulo, Integer>> iterator() {
        return lineas.entrySet().iterator();
    }

    /**
     * Inserta un artículo en el carrito. Si ya estaba,
     * le suma 1 a la cantidad.
     *
     * @param articulo El artículo a añadir
     */
    public void insertarArticulo(Articulo articulo) {
        if (lineas.containsKey(articulo)) {
            int cantidad = lineas.get(articulo);
            lineas.put(articulo, cantidad + 1);
        } else {
            lineas.put(articulo, 1);
        }
    }

    public void quitarArticulo(Articulo articulo) {
        if (!lineas.containsKey(articulo)) {
            throw new ArticuloNoEstaException("El artículo no está en el carrito");
        }

        int cantidad = lineas.get(articulo);
        if (cantidad == 1) {
            lineas.remove(articulo);
        } else {
            lineas.put(articulo, cantidad - 1);
        }
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal("0.00").setScale(2);

        for (Map.Entry<Articulo, Integer> linea : this) {
            BigDecimal precio = linea.getKey().getPrecio();
            BigDecimal cantidad = new BigDecimal(linea.getValue()).setScale(2);
            total = total.add(precio.multiply(cantidad).setScale(2)).setScale(2);
        }

        return total;
    }
}
