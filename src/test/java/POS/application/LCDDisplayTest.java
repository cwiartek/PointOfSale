package POS.application;

import POS.infrastructure.LCDDisplay;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;

public class LCDDisplayTest {

    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream printStream;

    @BeforeMethod
    public void setup() {
        printStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }
    @Test
    public void shouldPrintProductNotFound() {
        //given
        LCDDisplay lcdDisplay = new LCDDisplay();
        //when
        lcdDisplay.printProductNotFound();
        //then
        String expected = "Product not found";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expected);
    }

    @Test
    public void shouldPrintInvalidBarcode() {
        //given
        LCDDisplay lcdDisplay = new LCDDisplay();
        //when
        lcdDisplay.printInvalidBarcode();
        //then
        String expected = "Invalid bar-code";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expected);
    }

}
