import accountSnap.AccountSnapshot;
import java.math.BigDecimal;
public class SimpleInterestPolicy implements interfaces.InterestPolicy {
    private final BigDecimal monthlyRate;
    public SimpleInterestPolicy(BigDecimal monthlyRate){this.monthlyRate = monthlyRate;}

    @Override
    public BigDecimal calculateInterest(AccountSnapshot snapshot) {
        return snapshot.getAverageDailyBalance().multiply(monthlyRate);
    }
}
