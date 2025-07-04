import java.util.ArrayList;
import java.util.List;

public class Cart {
    private ArrayList<CartItem> items = new ArrayList<>();

    public void add(Product product, int qty) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null.");
        if (qty <= 0) throw new IllegalArgumentException("Quantity must be positive.");

        items.add(new CartItem(qty, product));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        double total = 0;
        for (CartItem item : items) {
            total+= item.getTotal();
        }
        return total;
    }

}