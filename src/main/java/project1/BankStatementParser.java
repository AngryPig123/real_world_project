package project1;

import java.time.LocalDate;
import java.util.List;

/**
 * packageName    : project1
 * fileName       : BankStatemtntParser
 * author         : AngryPig123
 * date           : 24. 12. 1.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 1.        AngryPig123       최초 생성
 */
public interface BankStatementParser {

    BankTransaction parseFormCSV(final String line);

    List<BankTransaction> parseLineFromCSV(final List<String> lines);
    
}
