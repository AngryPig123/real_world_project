package project1;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

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
public class Client {

    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementSCVParser();
        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }

}
