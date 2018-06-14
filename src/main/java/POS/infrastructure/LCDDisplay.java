package POS.infrastructure;

import POS.application.ProductOutput;
import POS.application.SummaryOutput;
import POS.model.Product;
import POS.model.Recipt;

import java.math.BigDecimal;

public class LCDDisplay implements ProductOutput, SummaryOutput {

    @Override
    public void print(Product product) {
        System.out.printf(product.getName() + product.getPrice());
    }

    public void print(BigDecimal totalSum) {
        System.out.println("Total sum: " + totalSum);
    }

    public void printSummary (Recipt recipt) {
        print(recipt.totalSum());
    }

    @Override
    public void printProductNotFound() {
        System.out.print("Product not found");
    }

    @Override
    public void printInvalidBarcode() {
        System.out.print("Invalid bar-code");
    }
}
