import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankingSystemTest {

    private SavingsAccount savings;
    private CheckingAccount checking;

    @BeforeEach
    public void setUp() {
        savings = new SavingsAccount("SAV123", 1000.0);
        checking = new CheckingAccount("CHK456", 200.0);
    }

    @Test
    public void testDeposit() {
        savings.deposit(500.0);
        assertEquals(1500.0, savings.getBalance());
    }

    @Test
    public void testTransferSuccess() {
        savings.transfer(checking, 300.0);
        assertEquals(700.0, savings.getBalance());
        assertEquals(500.0, checking.getBalance());
    }

    // === ASSERT THROWS VERIFICATION ===
    @Test
    public void testSavingsWithdrawInsufficientFunds() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            savings.withdraw(950.0); 
        });
        assertEquals("Insufficient funds", exception.getMessage());
        assertEquals(1000.0, savings.getBalance()); 
    }

    @Test
    public void testCheckingOverdraftLimitExceeded() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            checking.withdraw(800.0); 
        });
        assertEquals("Exceeded overdraft limit", exception.getMessage());
        assertEquals(200.0, checking.getBalance()); 
    }
}