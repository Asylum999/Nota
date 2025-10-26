package app;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Kelas MenuItem merepresentasikan item menu di restoran
 * yang memiliki nama dan harga.
 */
public class MenuItem {
    private String name;
    private double price;

    /**
     * Konstruktor untuk membuat objek MenuItem baru.
     *
     * @param name  nama menu
     * @param price harga menu
     */
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Mengambil nama menu.
     *
     * @return nama menu
     */
    public String getName() {
        return name;
    }

    /**
     * Mengambil harga menu.
     *
     * @return harga menu
     */
    public double getPrice() {
        return price;
    }

    /**
     * Mengembalikan harga menu dalam format rupiah.
     *
     * @return harga format mata uang rupiah
     */
    public String getFormattedPrice() {
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return rupiah.format(price);
    }
}
