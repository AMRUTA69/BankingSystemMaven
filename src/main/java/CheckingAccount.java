
class CheckingAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 500.0;

    public CheckingAccount(String acctNum, double initBal) {
        super(acctNum, initBal);
    }

    @Override
    public void withdraw(double amount) {
        if (balance + OVERDRAFT_LIMIT >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Exceeded overdraft limit");
        }
    }
}
