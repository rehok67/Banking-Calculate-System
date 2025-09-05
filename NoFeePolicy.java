public class NoFeePolicy implements interfaces.FeePolicy {
    @Override
    public java.math.BigDecimal calculateFee(accountSnap.AccountSnapshot snapshot) {
        return java.math.BigDecimal.ZERO;
    }
}
