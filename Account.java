import interfaces.FeePolicy;
import interfaces.InterestPolicy;
import java.math.BigDecimal;
import java.time.YearMonth;
import accountSnap.AccountSnapshot;
public class Account {
    private BigDecimal balance = BigDecimal.ZERO;
    private final FeePolicy feePolicy;
    private final InterestPolicy interestPolicy;
    private final Ledger ledger = new Ledger();
    public Account(FeePolicy feePolicy, InterestPolicy interestPolicy) {
        this.feePolicy = feePolicy;
        this.interestPolicy = interestPolicy;
    }
    private void requirePositive(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    public BigDecimal balance(){return balance;}
    public void deposit(BigDecimal amount){
        requirePositive(amount);
        balance = balance.add(amount);
        ledger.add(TxType.DEPOSIT, amount, "Deposit");
    }
    public void withdraw(BigDecimal amount){
        requirePositive(amount);
        if (balance.compareTo(amount)<0) throw new IllegalArgumentException("Insufficient funds");
        balance = balance.subtract(amount);
        ledger.add(TxType.WITHDRAWAL, amount, "Withdrawal");
    }
    public MonthlyStatement closeMonth(YearMonth month) {
        BigDecimal opening = balance;
        // Burada basitçe end-of-month verileri kullanıyoruz;
        // istersen günlük ortalama için Ledger’dan gerçek ortalama hesapla.
        AccountSnapshot snapshot = new AccountSnapshot(balance, balance, countMonthlyTx());
        BigDecimal interest = interestPolicy.calculateInterest(snapshot);
        if (interest.signum() != 0) {
            balance = balance.add(interest);
            ledger.add(TxType.INTEREST, interest, "monthly interest");
        }
        BigDecimal fee = feePolicy.calculateFee(snapshot);
        if (fee.signum() != 0) {
            balance = balance.subtract(fee);
            ledger.add(TxType.FEE, fee.negate(), "monthly fee");
        }
        return new MonthlyStatement(month, opening, interest, fee, balance, ledger.all());
    }
    private int countMonthlyTx() { return ledger.all().size(); }
}

