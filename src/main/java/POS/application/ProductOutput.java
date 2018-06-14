package POS.application;

import POS.model.Product;

public interface ProductOutput {

    void print(Product product);
    void printProductNotFound();
    void printInvalidBarcode();
}
