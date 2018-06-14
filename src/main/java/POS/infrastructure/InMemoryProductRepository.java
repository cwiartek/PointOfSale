package POS.infrastructure;

import POS.model.Barcode;
import POS.model.Product;
import POS.model.ProductRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProductRepository implements ProductRepository {

    private Map<Long, Product> listProduct = new HashMap<>();

    public InMemoryProductRepository(Map<Long, Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public Product findBarcode(Barcode barcode) {

        Product foundProduct = findProductByBarcodeFromListProduct(barcode);


        if (foundProduct == null) {
            throw new ProductNotFoundException("Product not found");
        }

        return foundProduct;
    }

    private Product findProductByBarcodeFromListProduct(Barcode barcode) {
        Product foundProduct = null;
        for (Product product : listProduct.values()) {
            if (product.getBarcode().equals(barcode)) {
                foundProduct = product;
                break;
            }
        }
        return foundProduct;
    }

}
