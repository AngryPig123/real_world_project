package project1;

import lombok.extern.slf4j.Slf4j;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        return bankTransactions.stream()
                .filter(bankTransactionFilter::test)
                .collect(Collectors.toList());
    }

    public static BankStatementProcessor of(List<BankTransaction> bankTransactions) {
        return new BankStatementProcessor(bankTransactions);
    }

    @FunctionalInterface
    public interface BankTransactionSummarizer {
        double summarize(double accumulator, BankTransaction bankTransaction);
    }

    @FunctionalInterface
    public interface BankTransactionFilter {
        boolean test(BankTransaction bankTransaction);
    }

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        return bankTransactions.stream()
                .reduce(0.0, bankTransactionSummarizer::summarize, Double::sum);
    }

    public double calculateTotalAmount() {
        return this.bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions(
                (acc, bankTransaction) ->
                        bankTransaction.getDate().getMonth() == month
                                ? acc + bankTransaction.getAmount()
                                : acc
        );
    }

    public double calculateTotalForCategory(final String category) {
        return summarizeTransactions(
                (acc, bankTransaction) ->
                        category.equals(bankTransaction.getDescription())
                                ? acc + bankTransaction.getAmount()
                                : acc
        );
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() > amount);
    }

}
