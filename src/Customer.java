public class Customer {
    private final String name;
    private double balance;

    public Customer(String name, double balance) {
        if (balance < 0) throw new IllegalArgumentException("Negative balance.");
        this.name = name;
        this.balance = balance;
    }

    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void decreaseBalance(double amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance.");
        balance -= amount;
    }
}