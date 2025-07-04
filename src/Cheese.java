import java.sql.Date;

public class Cheese extends ExpirableProduct implements Shippable{
private final double weight; //weight is assumed to be constant per unit
    public Cheese(String name, double price, int quantity, Date expiration, double weightKg) {
        super(name,price,quantity,expiration);
        if (weightKg <= 0) throw new IllegalArgumentException("Weight must be positive.");
        this.weight = weightKg;
    }

    @Override
    public double getWeight() {
        return weight;
    }



}
