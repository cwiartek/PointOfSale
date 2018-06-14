package POS.model;

import java.math.BigDecimal;
import java.util.List;

public class Recipt {

    private List<Product> products;

    public Recipt(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public BigDecimal totalSum() {

        BigDecimal totalSum = BigDecimal.ZERO;

        for(Product product: products) {
            totalSum = totalSum.add(product.getPrice());
        }
        return totalSum;
    }
}
