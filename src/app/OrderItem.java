package app;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Kelas OrderItem merepresentasikan satu item pesanan
 * yang berisi menu dan jumlah yang dipesan.
 */
public class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    /**
     * Membuat objek OrderItem baru.
     *
     * @param menuItem menu yang dipesan
     * @param quantity jumlah pesanan
     */
    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    /**
     * Menghitung total harga untuk item pesanan ini.
     *
     * @return total harga (harga menu × jumlah)
     */
    public double calculateTotal() {
        return menuItem.getPrice() * quantity;
    }

    /**
     * Mengembalikan baris teks untuk ditampilkan pada nota.
     *
     * @return string format "Nama Menu x Jumlah = Total"
     */
    public String getReceiptLine() {
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return String.format("%s x %d = %s",
                menuItem.getName(),
                quantity,
                rupiah.format(calculateTotal()));
    }
}
