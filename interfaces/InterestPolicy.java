package interfaces;

import accountSnap.AccountSnapshot;
import java.math.BigDecimal;

public interface InterestPolicy {
    public BigDecimal calculateInterest(AccountSnapshot snapshot);
}