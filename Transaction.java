import java.util.Date;
import java.math.BigDecimal;
public record Transaction(Date date, TxType type, BigDecimal amount, String description) {
}