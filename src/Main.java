import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== TEST 1: Valid Checkout =====");
        try {
            Customer alice = new Customer("Alice", 1000);
            Cheese cheese = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(5), 0.4);
            Biscuits biscuits = new Biscuits("Biscuits", 150, 2, LocalDate.now().plusDays(3), 0.3);
            Cart cart = new Cart();
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            CheckoutService.checkout(alice, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n===== TEST 2: Expired Product =====");
        try {
            Customer c = new Customer("TestUser", 500);
            Cheese expired = new Cheese("Expired Cheese", 100, 1, LocalDate.now().minusDays(1), 0.5);
            Cart cart = new Cart();
            cart.add(expired, 1);
            CheckoutService.checkout(c, cart);
        } catch (Exception e) {
            System.out.println("Expected Error: " + e.getMessage());
        }

        System.out.println("\n===== TEST 3: Out of Stock =====");
        try {
            Customer c = new Customer("TestUser", 500);
            Biscuits b = new Biscuits("Biscuits", 100, 1, LocalDate.now().plusDays(1), 0.2);
            Cart cart = new Cart();
            cart.add(b, 2);  // asking for more than available
            CheckoutService.checkout(c, cart);
        } catch (Exception e) {
            System.out.println("Expected Error: " + e.getMessage());
        }

        System.out.println("\n===== TEST 4: Insufficient Balance =====");
        try {
            Customer poor = new Customer("Bob", 50); // too low
            TV tv = new TV("TV", 200, 2, 5.0);
            Cart cart = new Cart();
            cart.add(tv, 1);
            CheckoutService.checkout(poor, cart);
        } catch (Exception e) {
            System.out.println("Expected Error: " + e.getMessage());
        }

        System.out.println("\n===== TEST 5: Empty Cart =====");
        try {
            Customer empty = new Customer("Empty", 100);
            Cart cart = new Cart();
            CheckoutService.checkout(empty, cart);
        } catch (Exception e) {
            System.out.println("Expected Error: " + e.getMessage());
        }

        System.out.println("\n===== TEST 6: Non-Shippable Product Only =====");
        try {
            Customer c = new Customer("NonShippable", 500);
            ScratchCard s = new ScratchCard("Scratch", 50, 10);
            Cart cart = new Cart();
            cart.add(s, 2);  // not shippable
            CheckoutService.checkout(c, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n===== TEST 7: Product with Invalid Constructor Parameters =====");
        try {
            Cheese badCheese = new Cheese("BadCheese", 0, 5, LocalDate.now().plusDays(2), 0.5);  // price = 0
        } catch (Exception e) {
            System.out.println("Expected Constructor Error: " + e.getMessage());
        }

        System.out.println("\n===== TEST 8: Add Invalid Quantity to Cart =====");
        try {
            Customer c = new Customer("Alice", 500);
            Cheese cheese = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(3), 0.4);
            Cart cart = new Cart();
            cart.add(cheese, -2); // invalid
        } catch (Exception e) {
            System.out.println("Expected Cart Error: " + e.getMessage());
        }
    }
}
