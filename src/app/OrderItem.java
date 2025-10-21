package app;

import java.text.NumberFormat;
import java.util.Locale;

public class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return menuItem.getPrice() * quantity;
    }

    public String getReceiptLine() {
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return String.format("%s x %d = %s",
                menuItem.getName(),
                quantity,
                rupiah.format(calculateTotal()));
    }
}

