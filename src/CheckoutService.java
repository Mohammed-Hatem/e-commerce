import java.util.*;

public class CheckoutService {
    private static final double SHIPPING_FEE = 30.0;

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalArgumentException("Cart is empty.");

        List<CartItem> items = new ArrayList<>(cart.getItems());
        items.sort(Comparator.comparing(a -> a.getProduct().getName()));

        double subtotal = 0.0;
        List<Shippable> toShip = new ArrayList<>();

        for (CartItem item : items) {
            Product p = item.getProduct();
            if (p.canExpire() && p.isExpired())
                throw new IllegalArgumentException("Product " + p.getName() + " is expired.");
            if (item.getQuantity() > p.getQuantity())
                throw new IllegalArgumentException("Product " + p.getName() + " is out of stock.");
            subtotal += item.getTotal();
            if (p.isShippable()) {
                for (int i = 0; i < item.getQuantity(); i++) toShip.add((Shippable) p);
            }
        }

        double shippingWeight = toShip.stream().mapToDouble(Shippable::getWeight).sum();
        double shippingFee = shippingWeight > 0 ? SHIPPING_FEE : 0.0;
        double total = subtotal + shippingFee;

        if (customer.getBalance() < total)
            throw new IllegalArgumentException("Insufficient customer balance.");

        if (!toShip.isEmpty()) ShippingService.ship((ArrayList<Shippable>) toShip);

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.printf("%dx %s %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getProduct().getPrice()*item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shippingFee);
        System.out.printf("Amount %.0f\n", total);

        for (CartItem item : items) item.getProduct().decreaseQuantity(item.getQuantity());
        customer.decreaseBalance(total);

        System.out.printf("Customer %s new balance: %.2f\n", customer.getName(), customer.getBalance());
        System.out.println("END.");

    }
}