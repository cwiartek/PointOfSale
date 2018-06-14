package POS.model;

public interface ProductRepository {

    Product findBarcode(Barcode barcode);
}
