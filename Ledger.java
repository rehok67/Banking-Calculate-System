import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
public class Ledger {
    private final List<Transaction> entries = new ArrayList<>();
    void add(TxType type, BigDecimal amount, String note) {
        entries.add(new Transaction(new Date(), type, amount, note));
    }
    List<Transaction> all() { return Collections.unmodifiableList(entries); }
}