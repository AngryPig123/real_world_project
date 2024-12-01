package project2;

import java.io.File;
import java.io.IOException;

/**
 * packageName    : project2
 * fileName       : Impoter
 * author         : AngryPig123
 * date           : 24. 12. 1.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 1.        AngryPig123       최초 생성
 */
public interface Importer {
    Document importFile(File file) throws IOException;

}
