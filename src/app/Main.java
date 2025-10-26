package app;

import java.util.Scanner;

/**
 * Kelas utama untuk menjalankan aplikasi pemesanan restoran.
 * Program ini memungkinkan pengguna memilih menu makanan,
 * memasukkan jumlah pesanan, dan mencetak nota.
 */
public class Main {

    /**
     * Method utama yang mengeksekusi program.
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar menu restoran
        MenuItem[] menu = {
                new MenuItem("Nasi Goreng", 15000),
                new MenuItem("Mie Ayam", 12000),
                new MenuItem("Sate Ayam", 20000),
                new MenuItem("Es Teh", 5000),
                new MenuItem("Jus Jeruk", 8000)
        };

        Order order = new Order();
        System.out.println("=== Selamat Datang di Restoran ===");

        boolean ordering = true;
        while (ordering) {
            System.out.println("\nMenu Makanan & Minuman:");
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("%d. %s - %s%n",
                        (i + 1),
                        menu[i].getName(),
                        menu[i].getFormattedPrice());
            }
            System.out.println("0. Selesai Memesan");

            System.out.print("Pilih nomor menu: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                ordering = false;
            } else if (choice > 0 && choice <= menu.length) {
                System.out.print("Jumlah: ");
                int qty = scanner.nextInt();
                order.addItem(new OrderItem(menu[choice - 1], qty));
                System.out.println("Pesanan ditambahkan!");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        // Cetak nota
        order.printReceipt();
        scanner.close();
    }
}
