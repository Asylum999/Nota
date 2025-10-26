package app;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Kelas Order merepresentasikan pesanan yang terdiri dari beberapa item.
 * Kelas ini menyediakan fungsi untuk menambah item pesanan,
 * menghitung subtotal, dan mencetak nota pembayaran.
 */
public class Order {
    private List<OrderItem> items = new ArrayList<>();
    private NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    /**
     * Menambahkan item baru ke dalam pesanan.
     *
     * @param item objek OrderItem yang akan ditambahkan
     */
    public void addItem(OrderItem item) {
        items.add(item);
    }

    /**
     * Menghitung total harga semua item sebelum pajak.
     *
     * @return subtotal dari seluruh item pesanan
     */
    public double calculateSubtotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.calculateTotal();
        }
        return total;
    }

    /**
     * Mencetak nota pembayaran lengkap ke konsol,
     * termasuk subtotal, pajak 10%, dan total akhir.
     */
    public void printReceipt() {
        System.out.println("\n=== Nota Pemesanan Restoran ===");
        for (OrderItem item : items) {
            System.out.println(item.getReceiptLine());
        }
        double subtotal = calculateSubtotal();
        double tax = subtotal * 0.1;   // Pajak 10%
        double grandTotal = subtotal + tax;

        System.out.println("-------------------------------");
        System.out.println("Subtotal   : " + rupiah.format(subtotal));
        System.out.println("Pajak (10%): " + rupiah.format(tax));
        System.out.println("Total Bayar: " + rupiah.format(grandTotal));
        System.out.println("===============================");
        System.out.println("Terima kasih atas pesanan Anda!");
    }
}
