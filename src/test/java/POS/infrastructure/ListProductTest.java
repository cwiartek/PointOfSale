package POS.infrastructure;

import POS.model.Barcode;
import POS.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ListProductTest {

    private static final Product[] products = {
            new Product(1L, "Chipsy", BigDecimal.valueOf(3.56),new Barcode("123")),
            new Product(2L, "Paluszki", BigDecimal.valueOf(1.26),new Barcode("321")),
            new Product(3L, "Cola", BigDecimal.valueOf(2.20),new Barcode("555")),
            new Product(4L, "Piwo", BigDecimal.valueOf(4.20),new Barcode("666")) };

    private ListProductTest() {}

    public static Map<Long, Product> getListProduct() {
        Map<Long, Product> listProduct = new HashMap<>();

        for (int i = 0; i < products.length; i++) {
            listProduct.put((long) i, products[i]);
        }

        return listProduct;
    }
}
