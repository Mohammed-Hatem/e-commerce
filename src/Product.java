public abstract class Product {
    private final String name;
    private final double price;
    private int quantity;

    protected Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity( int amount) {
        quantity+=amount;
    }
    public void decreaseQuantity( int amount) {
        if (amount < 0 || amount > quantity) throw new IllegalArgumentException("Invalid quantity to decrease.");
        quantity -= amount;
    }

    public boolean isExpired() { return false; }

}
