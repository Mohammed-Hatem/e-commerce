public abstract class Product {
    private final String name;
    private final int price;
    private int quantity;

    protected Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
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

}
