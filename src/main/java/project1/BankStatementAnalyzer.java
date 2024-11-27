package project1;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * @author shguddnr2@coremethod.co.kr
 * @version 1.0
 * @description
 * @since 24. 11. 28.
 */
@Slf4j
public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {

        BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        Path path = Paths.get(RESOURCES + args[0]);
        List<String> lines = Files.readAllLines(path);
        List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);

        log.info("total price = {}", calculateTotalAmount(bankTransactions));
        log.info("select in month = {}", selectInMonth(bankTransactions, Month.FEBRUARY));

    }

    private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        return bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        return bankTransactions.stream().filter(transaction -> transaction.getDate().getMonth() == month).toList();
    }

}
