package POS.model;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private Barcode barcode;

    public Product(Long id, String name, BigDecimal price, Barcode barcode) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.barcode = barcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public void setBarcode(Barcode barcode) {
        this.barcode = barcode;
    }
}
