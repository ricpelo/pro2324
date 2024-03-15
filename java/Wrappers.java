import java.math.BigDecimal;

public class Wrappers {
    public static void main(String[] args) {
        Object[] o = new Object[] { 5, "hola", true, 3.4, new Object() };
        Number[] n = new Number[] { 1, 2, 3, new BigDecimal("0") };

        if (n[3] instanceof BigDecimal) {
            BigDecimal b = (BigDecimal) n[3];
            System.out.println(b.abs());
        }

        if (o[2] instanceof String) {
            String s = (String) o[2];
            System.out.println(s.length());
        }
    }
}
