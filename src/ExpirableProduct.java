import java.util.Date;

public abstract class ExpirableProducts extends Product{
    private final Date expiryDate;

    public ExpirableProducts(String name,int price, int quantity, Date expiryDate) {
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
