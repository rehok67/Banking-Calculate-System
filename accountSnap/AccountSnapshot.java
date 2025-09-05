package accountSnap;

import java.math.BigDecimal;

public final class AccountSnapshot {
    private final BigDecimal averageDailyBalance;
    private final BigDecimal endBalance;
    private final int monthlyTxCount;

    public AccountSnapshot(BigDecimal averageDailyBalance, BigDecimal endBalance, int monthlyTxCount){
        this.averageDailyBalance = averageDailyBalance;
        this.endBalance = endBalance;
        this.monthlyTxCount = monthlyTxCount;
    }
    public BigDecimal getAverageDailyBalance() { return averageDailyBalance; }
    public BigDecimal getBalance() { return endBalance; }
    public int getMonthlyTxCount() { return monthlyTxCount; }
}
