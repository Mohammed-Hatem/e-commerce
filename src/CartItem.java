public class CartItem {
    private int quantity;
    private Product product;

    public CartItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public Product getProduct() {
        return product;
    }

    public double getTotal() {
        return product.getPrice()*quantity;
    }
}
