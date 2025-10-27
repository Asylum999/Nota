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
                new MenuItem("Fried Rice", 15000),
                new MenuItem("Chicken Noodle", 12000),
                new MenuItem("Satay", 20000),
                new MenuItem("Ice Tea", 5000),
                new MenuItem("Orange", 8000)
        };

        Order order = new Order();
        System.out.println("Selamat Datang di Restoran");

        boolean ordering = true;
        while (ordering) {
            System.out.println("\nMenu Food & Drinks:");
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("%d. %s - %s%n",
                        (i + 1),
                        menu[i].getName(),
                        menu[i].getFormattedPrice());
            }
            System.out.println("0. Done");

            System.out.print("Choose Menu: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                ordering = false;
            } else if (choice > 0 && choice <= menu.length) {
                System.out.print("Total: ");
                int qty = scanner.nextInt();
                order.addItem(new OrderItem(menu[choice - 1], qty));
                System.out.println("order added.");
            } else {
                System.out.println("invalid input.");
            }
        }

        // Cetak nota
        order.printReceipt();
        scanner.close();
    }
}
