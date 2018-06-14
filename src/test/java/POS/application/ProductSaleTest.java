package POS.application;

import POS.infrastructure.InMemoryProductRepository;
import POS.infrastructure.LCDDisplay;
import POS.infrastructure.ListProductTest;
import POS.infrastructure.Printer;
import POS.model.Product;
import POS.model.ProductRepository;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;

public class ProductSaleTest {

    private Scanner scanner;
    private ByteArrayOutputStream arrayOutputStream;
    private PrintStream printStream;




    @BeforeClass
    public void setupClass() {
        scanner = setUpBarcodeScanner();
    }

    @BeforeMethod
    public void setup() {
        printStream = System.out;
        arrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(arrayOutputStream));
        sale = new ProductSale(scanner,singleProductOutput(),summaryOutputs());
    }
    private ProductSale sale;

    private List<ProductOutput> singleProductOutput() {
        List<ProductOutput> singleProductOutputs = new ArrayList<>();
        singleProductOutputs.add(new LCDDisplay());
        return singleProductOutputs;
    }

    private List<SummaryOutput> summaryOutputs() {
        List<SummaryOutput> summaryOutputs = new ArrayList<>();
        summaryOutputs.add(new LCDDisplay());
        summaryOutputs.add(new Printer());
        return summaryOutputs;
    }
    private Scanner setUpBarcodeScanner() {
        Map<Long, Product> listProduct = ListProductTest.getListProduct();
        ProductRepository productRepository = new InMemoryProductRepository(listProduct);
        return new Scanner(productRepository);
    }
   // @Test
    public void shouldScanValidBarcode() {
        //given
        String validBarcode = "123";
        //when
        sale.scan(validBarcode);
        //then
        String expectedString = "Chipsy" + "3,56 zł";
        assertThat(arrayOutputStream.toString()).isEqualTo(expectedString);
    }

    @Test
    public void shouldScanEmptyBarcode() {
        //given
        String invalidBarcode = "";
        //when
        sale.scan(invalidBarcode);
        //then
        String expectedString = "Invalid bar-code";
        assertThat(arrayOutputStream.toString()).isEqualTo(expectedString);
    }


}
