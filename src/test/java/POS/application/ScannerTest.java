package POS.application;

import POS.model.Barcode;
import POS.model.Product;
import POS.model.ProductRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.when;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;

public class ScannerTest {

    private ProductRepository productRepository;

    @Before
    public void setup() {
        productRepository = mock(ProductRepository.class);
    }

    @Test
    public void shouldScan() {

        //given
        Scanner scanner = new Scanner(productRepository);
        Product mock = mock(Product.class);
        when(productRepository.findBarcode(any(Barcode.class))).thenReturn(mock);

        //when
        Product product = scanner.scan(new Barcode("zzz"));
        //then
        assertThat(product).isEqualTo(mock);
    }
    @Test(expected = InvalidBarcodeException.class)
    public void shouldThrowInvalidBarcodeException() {
        //given
        Scanner scanner = new Scanner(productRepository);
        //when
        scanner.scan(new Barcode(""));
    }
}
