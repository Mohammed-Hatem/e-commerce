import java.time.LocalDate;

public class Biscuits extends ExpirableProduct implements Shippable {
    private double weight;

    public Biscuits(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        if (weight <= 0.0) throw new IllegalArgumentException("Weight must be positive.");  // Now checking parameter
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }
}