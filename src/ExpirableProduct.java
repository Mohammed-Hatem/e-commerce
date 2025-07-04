import java.util.Date;

//implemented ExpirableProduct as a separate class inorder to avoid redundancy

public abstract class ExpirableProduct extends Product{
    private final Date expiryDate;

    public ExpirableProduct(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.after(new Date());
    }


}
