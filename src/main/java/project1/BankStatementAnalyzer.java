package project1;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * packageName    : project1
 * fileName       : Client
 * author         : AngryPig123
 * date           : 24. 12. 1.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 1.        AngryPig123       최초 생성
 */
@Slf4j
public class BankStatementAnalyzer {

    private static final String RESOURCES = "./src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        List<BankTransaction> bankTransactions = bankStatementParser.parseLineFromCSV(lines);
        BankStatementProcessor bankStatementProcessor = BankStatementProcessor.of(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        log.info("total amount = {}", bankStatementProcessor.calculateTotalAmount());
        log.info("total in month amount = {}", bankStatementProcessor.calculateTotalInMonth(Month.AUGUST));
        log.info("total int category amount = {}", bankStatementProcessor.calculateTotalForCategory("Food"));
    }

}
