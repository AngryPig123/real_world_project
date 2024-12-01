package project2;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * packageName    : project2
 * fileName       : Document
 * author         : AngryPig123
 * date           : 24. 12. 1.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 1.        AngryPig123       최초 생성
 */

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class Document {

    private final Map<String, String> attributes;

    public static Document of(Map<String, String> attributes) {
        return new Document(attributes);
    }

    public String getAttributes(String attributeName) {
        return attributes.get(attributeName);
    }

}
