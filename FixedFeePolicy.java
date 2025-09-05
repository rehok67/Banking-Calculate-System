import accountSnap.AccountSnapshot;
import java.math.BigDecimal;
public class FixedFeePolicy implements interfaces.FeePolicy{
    private final BigDecimal fee;
    public FixedFeePolicy(BigDecimal fee){this.fee = fee;}
    @Override
    public BigDecimal calculateFee(AccountSnapshot snapshot){
        return fee;
    }
}
