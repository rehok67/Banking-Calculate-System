import java.util.List;
import java.time.YearMonth;
import java.math.BigDecimal;
record MonthlyStatement(YearMonth month, BigDecimal opening,
                        BigDecimal interest, BigDecimal fees,
                        BigDecimal closing, List<Transaction> transactions) {}