package project1;

import lombok.extern.slf4j.Slf4j;

import java.time.Month;
import java.util.List;

/**
 * packageName    : project1
 * fileName       : BankStatementProcessor
 * author         : AngryPig123
 * date           : 24. 12. 1.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 1.        AngryPig123       최초 생성
 */
@Slf4j
public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    private BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public static BankStatementProcessor of(List<BankTransaction> bankTransactions) {
        return new BankStatementProcessor(bankTransactions);
    }

    public double calculateTotalAmount() {
        return this.bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double calculateTotalInMonth(final Month month) {
        return this.bankTransactions.stream()
                .filter(item -> item.getDate().getMonth() == month)
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double calculateTotalForCategory(final String category) {
        return this.bankTransactions.stream()
                .filter(item -> category.equals(item.getDescription()))
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

}
