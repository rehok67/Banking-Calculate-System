package interfaces;
import accountSnap.AccountSnapshot;
import java.math.BigDecimal;
public interface FeePolicy {
    public BigDecimal calculateFee(AccountSnapshot snapshot);
}
