
abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String acctNum, double initBal) {
        this.accountNumber = acctNum;
        this.balance = initBal;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public abstract void withdraw(double amount);

    public void transfer(Account targetAccount, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Invalid transfer amount.");
        this.withdraw(amount);
        targetAccount.deposit(amount);
    }
}
