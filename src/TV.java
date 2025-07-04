public class TV extends Product implements Shippable {
    private final double weightKg;

    public TV(String name, double price, int quantity, double weightKg) {
        super(name, price, quantity);
        if (weightKg <= 0) throw new IllegalArgumentException("Weight must be positive.");
        this.weightKg = weightKg;
    }

    @Override
    public boolean isShippable() { return true; }

    @Override
    public double getWeight() { return weightKg; }
}