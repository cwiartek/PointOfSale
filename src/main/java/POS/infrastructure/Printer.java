package POS.infrastructure;

import POS.application.SummaryOutput;
import POS.model.Product;
import POS.model.Recipt;

import java.math.BigDecimal;
import java.util.List;

public class Printer implements SummaryOutput {

    public void  printSummary(Recipt recipt) {

        StringBuilder sb = new StringBuilder(250);

        recipt(recipt.getProducts(),recipt.totalSum(),sb);
        System.out.println(sb);
    }

    private void recipt(List<Product> products, BigDecimal totalSum, StringBuilder sb) {
        bodyRecipt(products,sb);
        totalSum(sb,totalSum);
    }

    private void bodyRecipt(List<Product> products, StringBuilder sb) {

        for(Product product: products) {
            sb.append(product.getName() + product.getPrice());
        }

    }
    private void totalSum(StringBuilder sb, BigDecimal totalSum) {

        sb.append(totalSum);
    }
}
