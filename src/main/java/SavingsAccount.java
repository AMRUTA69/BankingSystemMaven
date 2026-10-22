
class SavingsAccount extends Account {
    private static final double MINIMUM_BALANCE = 100.0;

    public SavingsAccount(String acctNum, double initBal) {
        super(acctNum, initBal);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MINIMUM_BALANCE) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
}
