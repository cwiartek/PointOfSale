package POS.application;

import POS.infrastructure.Printer;
import POS.infrastructure.ProductNotFoundException;
import POS.model.Barcode;
import POS.model.Product;
import POS.model.Recipt;

import java.util.List;

import static POS.model.Barcode.isNotNull;

public class ProductSale {

    public final String EXIT = "exit";
    private Scanner scanner;
    private Recipt recipt;
    private Printer printer;
    private List<ProductOutput> productOutputs;
    private List<SummaryOutput> summaryOutputs;

    public ProductSale(Scanner scanner, List<ProductOutput> productOutputs,
                          List<SummaryOutput> summaryOutputs) {
        this.scanner = scanner;
        this.productOutputs = productOutputs;
        this.summaryOutputs=summaryOutputs;
    }

    public ProductSale(Scanner scanner, Recipt recipt, Printer printer, List<SummaryOutput> summaryOutputs, List<ProductOutput> productOutputs) {
        this.scanner = scanner;
        this.recipt = recipt;
        this.printer = printer;
        this.summaryOutputs = summaryOutputs;
        this.productOutputs = productOutputs;
    }

    public void scan(String input) {
        isNotNull(input);
        if(isExit(input)) {
            printSummary();
            return;
        }
        try {
            scan(new Barcode(input));
        } catch (ProductNotFoundException e) {
            for (ProductOutput productOutput : productOutputs) {
                productOutput.printProductNotFound();
            }
        } catch (InvalidBarcodeException e) {
            for (ProductOutput productOutput : productOutputs) {
                productOutput.printInvalidBarcode();
            }
        }
    }

    private void scan(Barcode barcode) {
        Product product = scanner.scan(barcode);
        recipt.add(product);
        print(product);

    }

    private boolean isExit(String input) {
        return input.equals(EXIT);
    }

    private void print(Product product) {
        for(ProductOutput productOutput : productOutputs) {
            productOutput.print(product);
        }
    }

    private void printSummary() {
        for(SummaryOutput summaryOutput : summaryOutputs) {
            summaryOutput.printSummary(recipt);
        }
    }
}
