package POS.application;

import POS.model.Barcode;
import POS.model.Product;
import POS.model.ProductRepository;

import static POS.model.Barcode.isNotEmpty;

public class Scanner {

    private ProductRepository productRepository;

    public Scanner(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product scan(Barcode barcode) {

        String code = barcode.getBarcode();

        if (!isNotEmpty(code)) {
            throw new InvalidBarcodeException("Invalid bar-code");
        }
        return productRepository.findBarcode(barcode);
    }
}
