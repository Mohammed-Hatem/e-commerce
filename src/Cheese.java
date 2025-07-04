import java.sql.Date;
import java.time.LocalDate;

public class Cheese extends ExpirableProduct implements Shippable{
private final double weight; //weight is assumed to be constant per unit
    public Cheese(String name, double price, int quantity, LocalDate expiration, double weightKg) {
        super(name,price,quantity,expiration);
        if (weightKg <= 0) throw new IllegalArgumentException("Weight must be positive.");
        this.weight = weightKg;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isShippable() { return true; }





}
