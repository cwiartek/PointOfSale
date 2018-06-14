package POS.model;

public class Barcode {

    String barcode;

    public Barcode(String barcode) {
        isNotNull(barcode);
        this.barcode = barcode;
    }

    public static void isNotNull (String barcode) {
        if (barcode == null)
            throw new NullPointerException();
    }
    public static boolean isNotEmpty(String barcode) {
        return barcode != null && !barcode.isEmpty();
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
